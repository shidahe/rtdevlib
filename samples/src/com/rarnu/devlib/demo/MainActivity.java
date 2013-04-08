package com.rarnu.devlib.demo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.anjuke.devlib.base.BaseMainActivity;
import com.anjuke.devlib.common.GlobalInstance;
import com.anjuke.devlib.utils.NetworkUtils;

public class MainActivity extends BaseMainActivity {

	MenuItem itemShare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		GlobalInstance.init(this, true);
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initOnce() {
		NetworkUtils.doGetNetworkInfoT(this);
	}

	@Override
	public String getBarTitle() {
		return getString(R.string.app_name);
	}

	@Override
	public Fragment getFragment(int currentFragment) {
		switch (currentFragment) {
		case 1:
			return Fragments.fDetail;
		case 2:
			return Fragments.fAdapter;
		case 3:
			return Fragments.fHScroll;
		case 4:
			return Fragments.fVScroll;
		case 5:
			return Fragments.fPullDownLayout;
		case 6:
			return Fragments.fPullDownListView;
		case 7:
			return Fragments.fDevice;
		case 8:
			return Fragments.fDownload;
		case 9:
			return Fragments.fFile;
		case 10:
			return Fragments.fHttpRequest;
		case 11:
			return Fragments.fImage;
		case 12:
			return Fragments.fNetwork;
		case 13:
			return Fragments.fNotification;
		case 14:
			return Fragments.fUI;
		case 15:
			return Fragments.fRun;
		case 16:
			return Fragments.fFloatWindow;
		case 17:
			return Fragments.fTab;
		}
		return Fragments.fDetail;
	}

	@Override
	public Fragment getIndexFragment() {
		return Fragments.fIndex;
	}

	@Override
	public void initMenu(Menu menu) {
		itemShare = menu.add(0, 1, 150, "Share");
		itemShare.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		itemShare.setIcon(android.R.drawable.ic_menu_share);
		ShareActionProvider actionProvider = new ShareActionProvider(this);
		itemShare.setActionProvider(actionProvider);
		actionProvider
				.setShareHistoryFileName(ShareActionProvider.DEFAULT_SHARE_HISTORY_FILE_NAME);
		actionProvider.setShareIntent(createShareIntent());
	}

	private Intent createShareIntent() {
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/*");
		shareIntent.putExtra(Intent.EXTRA_TEXT, "share body");
		shareIntent.putExtra(Intent.EXTRA_SUBJECT, "share title");
		return shareIntent;
	}

	@Override
	public void onHomeClick() {

	}

	@Override
	public void onRecentAppClick() {

	}

	@Override
	public void loadFragments() {
		Fragments.loadFragments();

	}

	@Override
	public void releaseFragments() {
		Fragments.releaseFragments();

	}

}
