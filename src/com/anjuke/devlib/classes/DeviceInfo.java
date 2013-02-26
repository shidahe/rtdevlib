package com.anjuke.devlib.classes;

public class DeviceInfo {

	public String roBuildId;
	public String roBuildVersionSdk;
	public String roBuildVersionRelease;
	public String roProductModel;
	public String roProductBrand;
	public String roProductName;
	public String roProductDevice;
	public String roProductBoard;
	public String roProductCpuAbi;
	public String roProductCpuAbi2;
	public String roProductManufacturer;
	public String roBoardPlatform;
	public String roBuildDescription;
	public String roProductVersion;

	public String toString() {
		String ret = "";
		ret += "roBuildId:" + roBuildId + "\n";
		ret += "roBuildVersionSdk:" + roBuildVersionSdk + "\n";
		ret += "roBuildVersionRelease:" + roBuildVersionRelease + "\n";
		ret += "roProductModel:" + roProductModel + "\n";
		ret += "roProductBrand:" + roProductBrand + "\n";
		ret += "roProductName:" + roProductName + "\n";
		ret += "roProductDevice:" + roProductDevice + "\n";
		ret += "roProductBoard:" + roProductBoard + "\n";
		ret += "roProductCpuAbi:" + roProductCpuAbi + "\n";
		ret += "roProductCpuAbi2:" + roProductCpuAbi2 + "\n";
		ret += "roProductManufacturer:" + roProductManufacturer + "\n";
		ret += "roBoardPlatform:" + roBoardPlatform + "\n";
		ret += "roBuildDescription:" + roBuildDescription + "\n";
		ret += "roProductVersion:" + roProductVersion + "\n";
		return ret;
	}
}
