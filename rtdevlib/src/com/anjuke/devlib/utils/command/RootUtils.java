package com.anjuke.devlib.utils.command;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.anjuke.devlib.R;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;

public class RootUtils {

    public static final int LEVEL_ROOTED = 2;
    public static final int LEVEL_HALF_ROOTED = 1;
    public static final int LEVEL_NO_ROOT = 0;
    private static final String[] SU_PATH = new String[]{"/system/bin/su", "/system/xbin/su"};
    private static final String[] APP_PATH = new String[]{"/system/app/", "/system/priv-app/"};
    private static final String[] BUSYBOX_PATH = new String[]{"/system/xbin/busybox", "/system/bin/busybox"};
    private static final String[] IPTABLES_PATH = new String[]{"/system/bin/iptables", "/system/xbin/iptables"};
    private static final String[] IP6TABLES_PATH = new String[]{"/system/bin/ip6tables", "/system/xbin/ip6tables"};
    private static boolean DEBUG = false;
    private static String[] SUPERUSER_PATH = null;
    private static PackageManager pm = null;

    public static void init(Context context) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            boolean msg = appInfo.metaData.getBoolean("debug");
            DEBUG = msg;

        } catch (Exception e) {
            DEBUG = false;
        }
        pm = context.getPackageManager();
        SUPERUSER_PATH = context.getResources().getStringArray(R.array.super_user);

    }

    public static boolean hasBusybox() {
        boolean ret = false;

        for (String b : BUSYBOX_PATH) {
            ret = openFile(b).exists();
            if (ret) {
                break;
            }
        }
        return ret;
    }

    public static boolean hasIptables() {
        boolean ret = false;
        for (int i = 0; i < IPTABLES_PATH.length; i++) {
            ret = openFile(IPTABLES_PATH[i]).exists() && openFile(IP6TABLES_PATH[i]).exists();
            if (ret) {
                break;
            }
        }
        return ret;
    }

    public static boolean hasSuperuser() {

        boolean ret = false;
        for (String su : SUPERUSER_PATH) {
            ret = applicationExists(su);
            if (ret) {
                break;
            }
        }

        if (!ret) {
            ret = isSettingsContainsSU();
        }

        if (!ret) {
            ret = isBaiduRom();
        }
        return ret;
    }

    private static boolean applicationExists(String packageName) {
        ApplicationInfo info = null;
        try {
            info = pm.getApplicationInfo(packageName, 0);
        } catch (Exception e) {
        }
        return info != null;
    }

    public static int hasRoot() {
        boolean hasSU = findSU();
        if (!hasSU) {
            return LEVEL_NO_ROOT;
        }
        boolean hasSuperUser = findSuperUser();
        return hasSuperUser ? LEVEL_ROOTED : LEVEL_HALF_ROOTED;
    }

    public static CommandResult runCommand(String command, boolean root) {
        return runCommand(new String[]{command}, root, null);
    }

    public static CommandResult runCommand(String[] prog) {
        return runCommand(prog, false, null);
    }

    public static CommandResult runCommand(String[] prog, CommandCallback callback) {
        return runCommand(prog, false, callback);
    }

    public static CommandResult runCommand(String command, boolean root, CommandCallback callback) {
        return runCommand(new String[]{command}, root, callback);
    }

    public static CommandResult runCommand(String[] command, boolean root, CommandCallback callback) {
        if (DEBUG) {
            Log.e("runCommand", command[0]);
        }
        Process process = null;
        DataOutputStream os = null;
        BufferedReader brOut = null;
        BufferedReader brErr = null;
        CommandResult ret = new CommandResult();
        try {
            StringBuffer output = new StringBuffer();
            StringBuffer error = new StringBuffer();
            if (root) {
                process = Runtime.getRuntime().exec("su");
                os = new DataOutputStream(process.getOutputStream());

                os.writeBytes(command[0] + "\n");
                os.writeBytes("exit\n");
                os.flush();
            } else {
                if (command.length == 1) {
                    process = Runtime.getRuntime().exec(command[0]);
                } else {
                    process = Runtime.getRuntime().exec(command);
                }
            }

            String line;
            brOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = brOut.readLine()) != null) {
                output.append(line).append('\n');
                if (callback != null) {
                    callback.onReadLine(line);
                }
            }
            brErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while ((line = brErr.readLine()) != null) {
                error.append(line).append('\n');
                if (callback != null) {
                    callback.onReadError(line);
                }
            }
            process.waitFor();
            ret.result = output.toString().trim();
            ret.error = error.toString().trim();
        } catch (Exception e) {
            ret.result = "";
            ret.error = e.getMessage();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (brOut != null) {
                    brOut.close();
                }
                if (brErr != null) {
                    brErr.close();
                }
            } catch (Exception e) {
                ret.result = "";
                ret.error = e.getMessage();
            }
        }
        if (callback != null) {
            callback.onCommandFinish();
        }
        if (DEBUG) {
            Log.e("runCommand", String.format("result:%s, error:%s", ret.result, ret.error));
        }
        return ret;
    }

    private static boolean findSuperUser() {
        boolean hasSuperUser = false;

        for (String path : APP_PATH) {
            File apps = new File(path);
            String[] apks = apps.list();
            if (apks != null) {
                if (apks.length > 0) {
                    for (String apk : apks) {
                        if (apk.toLowerCase().contains("superuser.apk")) {
                            hasSuperUser = true;
                            break;
                        }
                    }
                    if (hasSuperUser) {
                        break;
                    }
                }
            }
        }
        return hasSuperUser;
    }

    private static boolean findSU() {
        boolean ret = openFile(SU_PATH[0]).exists();
        if (!ret) {
            ret = openFile(SU_PATH[1]).exists();
        }
        return ret;
    }

    public static boolean hasSu() {
        return findSU();
    }

    private static File openFile(String path) {
        return new File(path);
    }

    @Deprecated
    public static String buildMountCommand() {
        String retstr = "";
        CommandResult ret = runCommand("mount", false, null);
        if (ret.error.equals("")) {
            String[] mt = ret.result.split("\n");
            for (String m : mt) {
                if (m.contains("/system")) {
                    String mstr = m;
                    mstr = mstr.replace(" on ", " ").trim();
                    String[] mele = mstr.split(" ");
                    int cnt = 0;
                    for (String me : mele) {
                        if (cnt >= 2) {
                            break;
                        }
                        if (!me.trim().equals("")) {
                            retstr = retstr + " " + me;
                            cnt++;
                        }
                    }
                    break;
                }
            }
        }
        if (!retstr.equals("")) {
            retstr = "mount -o remount,rw" + retstr;
        }
        return retstr;
    }

    public static void mountRW() {
        String cmd = "mount -o remount,rw /system"; // buildMountCommand();
        runCommand(cmd, true, null);
    }

    private static boolean isSettingsContainsSU() {
        boolean ret = false;
        CommandResult result = runCommand("getprop ro.build.host", false);
        if (result != null) {
            if (result.result.toLowerCase().contains("cyanogenmod")) {
                ret = true;
            }
        }
        return ret;
    }

    private static boolean isBaiduRom() {
        boolean ret = false;
        try {
            ApplicationInfo infoService = pm.getApplicationInfo("com.baidu.bsf.service", 0);
            ApplicationInfo infoSystem = pm.getApplicationInfo("com.baidu.bsf.system", 0);
            ret = (infoService != null && infoSystem != null);
        } catch (Exception e) {

        }

        return ret;
    }
}
