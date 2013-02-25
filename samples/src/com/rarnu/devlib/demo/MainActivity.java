package com.rarnu.devlib.demo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.anjuke.devlib.base.BaseMainActivity;
import com.anjuke.devlib.common.GlobalInstance;
import com.anjuke.devlib.utils.UIUtils;

public class MainActivity extends BaseMainActivity {

	MenuItem itemShare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		GlobalInstance.init(this, true);
		UIUtils.initDisplayMetrics(this, getWindowManager());
		super.onCreate(savedInstanceState);
	}

	@Override
	public void initOnce() {

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
		}
		return Fragments.fDetail;
	}

	@Override
	public Fragment getIndexFragment() {
		return Fragments.fIndex;
	}

	@Override
	public void initMenu(Menu menu) {
		itemShare = menu.add(0, 1, 0, "Share");
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
		Fragments.releaseFragments();
		oneTimeRun = false;
		finish();
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
