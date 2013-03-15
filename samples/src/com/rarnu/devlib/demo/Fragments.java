package com.rarnu.devlib.demo;

import com.rarnu.devlib.demo.fragment.AdapterFragment;
import com.rarnu.devlib.demo.fragment.ArgumentFragment;
import com.rarnu.devlib.demo.fragment.DeviceFragment;
import com.rarnu.devlib.demo.fragment.DialogFragment;
import com.rarnu.devlib.demo.fragment.DownloadFragment;
import com.rarnu.devlib.demo.fragment.FileFragment;
import com.rarnu.devlib.demo.fragment.HScrollFragment;
import com.rarnu.devlib.demo.fragment.HttpRequestFragment;
import com.rarnu.devlib.demo.fragment.ImageFragment;
import com.rarnu.devlib.demo.fragment.IndexFragment;
import com.rarnu.devlib.demo.fragment.NetworkFragment;
import com.rarnu.devlib.demo.fragment.NotificationFragment;
import com.rarnu.devlib.demo.fragment.PopupFragment;
import com.rarnu.devlib.demo.fragment.PullDownLayoutFragment;
import com.rarnu.devlib.demo.fragment.PullDownListViewFragment;
import com.rarnu.devlib.demo.fragment.RunFragment;
import com.rarnu.devlib.demo.fragment.SlideContentFragment;
import com.rarnu.devlib.demo.fragment.SlideMenuFragment;
import com.rarnu.devlib.demo.fragment.UIFragment;
import com.rarnu.devlib.demo.fragment.VScrollFragment;

public class Fragments {

	public static IndexFragment fIndex = null;
	public static ArgumentFragment fDetail = null;
	public static AdapterFragment fAdapter = null;
	public static DialogFragment fDialog = null;
	public static PopupFragment fPopup = null;
	public static HScrollFragment fHScroll = null;
	public static VScrollFragment fVScroll = null;
	public static PullDownListViewFragment fPullDownListView = null;
	public static PullDownLayoutFragment fPullDownLayout = null;
	public static DeviceFragment fDevice = null;
	public static DownloadFragment fDownload = null;
	public static FileFragment fFile = null;
	public static HttpRequestFragment fHttpRequest = null;
	public static ImageFragment fImage = null;
	public static NetworkFragment fNetwork = null;
	public static NotificationFragment fNotification = null;
	public static UIFragment fUI = null;
	public static RunFragment fRun = null;
	public static SlideMenuFragment fSlideMenu = null;
	public static SlideContentFragment fSlideContent = null;
	
	public static void loadFragments() {
		if (fIndex == null) {
			fIndex = new IndexFragment();
		}
		if (fDetail == null) {
			fDetail = new ArgumentFragment();
		}
		if (fAdapter == null) {
			fAdapter = new AdapterFragment();
		}
		if (fDialog == null) {
			fDialog = new DialogFragment();
		}
		if (fPopup == null) {
			fPopup = new PopupFragment();
		}
		if (fHScroll == null) {
			fHScroll = new HScrollFragment();
		}
		if (fVScroll == null) {
			fVScroll = new VScrollFragment();
		}
		if (fPullDownListView == null) {
			fPullDownListView = new PullDownListViewFragment();
		}
		if (fPullDownLayout == null) {
			fPullDownLayout = new PullDownLayoutFragment();
		}
		if (fDevice == null) {
			fDevice = new DeviceFragment();
		}
		if (fDownload == null) {
			fDownload = new DownloadFragment();
		}
		if (fFile == null) {
			fFile = new FileFragment();
		}
		if (fHttpRequest == null) {
			fHttpRequest = new HttpRequestFragment();
		}
		if (fImage == null) {
			fImage = new ImageFragment();
		}
		if (fNetwork == null) {
			fNetwork = new NetworkFragment();
		}
		if (fNotification == null) {
			fNotification = new NotificationFragment();
		}
		if (fUI == null) {
			fUI = new UIFragment();
		}
		if (fRun == null) {
			fRun = new RunFragment();
		}
		if (fSlideMenu == null) {
			fSlideMenu = new SlideMenuFragment();
		}
		if (fSlideContent == null) {
			fSlideContent = new SlideContentFragment();
		}
	}
 
	public static void releaseFragments() {
		fIndex = null;
		fDetail = null;
		fAdapter = null;
		fDialog = null;
		fPopup = null;
		fHScroll = null;
		fVScroll = null;
		fPullDownListView = null;
		fPullDownLayout = null;
		fDevice = null;
		fDownload = null;
		fFile = null;
		fHttpRequest = null;
		fImage = null;
		fNetwork = null;
		fNotification = null;
		fUI = null;
		fRun = null;
		fSlideMenu = null;
		fSlideContent = null;
	}
}
