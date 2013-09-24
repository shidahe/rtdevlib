package com.anjuke.devlib.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;

import com.anjuke.devlib.classes.DeviceInfo;
import com.anjuke.devlib.utils.DeviceUtils;

public class GlobalInstance {

	public static boolean DEBUG = false;
	public static boolean dualPane = false;
	public static PackageManager pm = null;
	public static int currentFragment = 0;

	// network
	public static boolean loadingNetwork = false;
	public static NetworkInfo networkInfo = null;
	public static String networkSpeed = "";

	public static String nameServer = "8.8.8.8";
	public static DeviceInfo device = null;
	
	public static void init(Context context, boolean debug) {
		pm = context.getPackageManager();
		DEBUG = debug;
		device = DeviceUtils.getDeviceInfo();
	}
}
