package com.anjuke.devlib.common;

import android.content.pm.PackageManager;
import android.net.NetworkInfo;

public class GlobalInstance {

	public static boolean DEBUG = false;
	
	public static boolean dualPane = false;
	public static PackageManager pm = null;
	
	public static int currentFragment = 0;

	// network
	public static boolean loadingNetwork = false;
	public static NetworkInfo networkInfo = null;
	public static String networkSpeed = "";

	// host
	public static String nameServer = "8.8.8.8";

	// device info
	public static String deviceId = "";
	public static String module = "";
	public static String osVersion = "";
	public static String buildDescription = "";
}
