package com.anjuke.devlib.utils.command;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import com.anjuke.devlib.common.GlobalInstance;

public class RootUtils {

	private static final String SU_PATH = "/system/bin/su";
	private static final String SU_PATH_X = "/system/xbin/su";
	private static final String APP_PATH = "/system/app/";
	private static final String BUSYBOX_PATH = "/system/xbin/busybox";

	private static final String[] SUPERUSER_PATH = new String[] {
			"eu.chainfire.supersu", "eu.chainfire.supersu.pro",
			"com.noshufou.android.su", "com.miui.uac",
			"com.lbe.security.shuame", "com.lbe.security.miui", "com.m0narx.su" };

	private static final String SETTINGS_PACKAGE = "com.android.settings";

	public static boolean hasBusybox() {
		return openFile(BUSYBOX_PATH).exists();
	}

	public static boolean hasSuperuser() {

		boolean ret = false;
		for (int i = 0; i < SUPERUSER_PATH.length; i++) {
			ret = applicationExists(SUPERUSER_PATH[i]);
			if (ret) {
				break;
			}
		}

		if (!ret) {
			ret = isSettingsContainsSU();
		}

		return ret;
	}

	private static boolean applicationExists(String packageName) {
		ApplicationInfo info = null;
		try {
			info = GlobalInstance.pm.getApplicationInfo(packageName, 0);
		} catch (NameNotFoundException e) {
			info = null;
		}
		return info != null;
	}

	public static int hasRoot() {
		boolean hasSU = findSU();
		if (!hasSU) {
			return 0;
		}
		boolean hasSuperUser = findSuperUser();
		return hasSuperUser ? 2 : 1;
	}

	public static boolean isWrongRoot() {
		// -rwsr-sr-x
		String suStat = runCommand("ls -l " + SU_PATH, false, null).result
				+ runCommand("ls -l " + SU_PATH_X, false, null).result;
		if (GlobalInstance.DEBUG) {
			Log.e("suStat", suStat);
		}
		return ((!suStat.contains("-rwsr-sr-x")) && (!suStat
				.contains("-rwsr-xr-x")));
	}

	public static CommandResult runCommand(String command, boolean root) {
		return runCommand(command, root, null);

	}

	public static CommandResult runCommand(String command, boolean root,
			ReadLineCallback callback) {
		if (GlobalInstance.DEBUG) {
			Log.e("runRootCommand", command);
		}
		Process process = null;
		DataOutputStream os = null;
		// DataInputStream stdout = null;
		// DataInputStream stderr = null;
		BufferedReader brOut = null;
		BufferedReader brErr = null;
		CommandResult ret = new CommandResult();
		try {
			StringBuffer output = new StringBuffer();
			StringBuffer error = new StringBuffer();
			if (root) {
				process = Runtime.getRuntime().exec("su");
				os = new DataOutputStream(process.getOutputStream());
				os.writeBytes(command + "\n");
				os.writeBytes("exit\n");
				os.flush();
			} else {
				process = Runtime.getRuntime().exec(command);
			}
			// stdout = new DataInputStream(process.getInputStream());
			String line;
			brOut = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			while ((line = brOut.readLine()) != null) {
				output.append(line).append('\n');
				if (callback != null) {
					callback.onReadLine(line);
				}
			}
			// stderr = new DataInputStream(process.getErrorStream());
			brErr = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));
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
				// if (stdout != null) {
				// stdout.close();
				// }
				// if (stderr != null) {
				// stderr.close();
				// }
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
		if (GlobalInstance.DEBUG) {
			Log.e("runRootCommand-Result",
					String.format("result:%s, error:%s", ret.result, ret.error));
		}
		return ret;
	}

	private static boolean findSuperUser() {
		File apps = new File(APP_PATH);
		String[] apks = apps.list();
		boolean hasSuperUser = false;
		if (apks != null) {
			if (apks.length > 0) {
				for (String apk : apks) {
					if (apk.toLowerCase().contains("superuser.apk")) {
						hasSuperUser = true;
						break;
					}
				}
			}
		}
		return hasSuperUser;
	}

	private static boolean findSU() {
		boolean ret = openFile(SU_PATH).exists();
		if (!ret) {
			ret = openFile(SU_PATH_X).exists();
		}
		return ret;
	}

	public static boolean hasSu() {
		return findSU();
	}

	private static File openFile(String path) {
		return new File(path);
	}

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
		String cmd = buildMountCommand();
		runCommand(cmd, true, null);
	}

	private static boolean isSettingsContainsSU() {
		boolean ret = false;
		try {
			PackageInfo pi = GlobalInstance.pm.getPackageInfo(SETTINGS_PACKAGE,
					0);
			String versionName = pi.versionName;
			versionName = versionName
					.substring(0, versionName.lastIndexOf("."));
			versionName = versionName
					.substring(versionName.lastIndexOf(".") + 1);
			ret = (Integer.parseInt(versionName) >= 20130308);
		} catch (Exception e) {

		}

		return ret;
	}
}
