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
import com.anjuke.devlib.utils.UIUtils;

public class MainActivity extends BaseMainActivity {

	MenuItem itemShare;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		UIUtils.initDisplayMetrics(this, getWindowManager(), false);
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
			return Fragments.getFragment(FragmentNameConsts.FN_DETAIL);
		case 2:
			return Fragments.getFragment(FragmentNameConsts.FN_ADAPTER);
		case 3:
			return Fragments.getFragment(FragmentNameConsts.FN_HSCROLL);
		case 4:
			return Fragments.getFragment(FragmentNameConsts.FN_VSCROLL);
		case 5:
			return Fragments.getFragment(FragmentNameConsts.FN_PULLDOWN_LAYOUT);
		case 6:
			return Fragments.getFragment(FragmentNameConsts.FN_PULLDOWN_LISTVIEW);
		case 7:
			return Fragments.getFragment(FragmentNameConsts.FN_DEVICE);
		case 8:
			return Fragments.getFragment(FragmentNameConsts.FN_DOWNLOAD);
		case 9:
			return Fragments.getFragment(FragmentNameConsts.FN_FILE);
		case 10:
			return Fragments.getFragment(FragmentNameConsts.FN_HTTP_REQUEST);
		case 11:
			return Fragments.getFragment(FragmentNameConsts.FN_IMAGE);
		case 12:
			return Fragments.getFragment(FragmentNameConsts.FN_NETWORK);
		case 13:
			return Fragments.getFragment(FragmentNameConsts.FN_NOTIFICATION);
		case 14:
			return Fragments.getFragment(FragmentNameConsts.FN_UI);
		case 15:
			return Fragments.getFragment(FragmentNameConsts.FN_RUN);
		case 16:
			return Fragments.getFragment(FragmentNameConsts.FN_FLOAT_WINDOW);
		case 17:
			return Fragments.getFragment(FragmentNameConsts.FN_TAB);
		case 18:
			return Fragments.getFragment(FragmentNameConsts.FN_DRAG_LISTVIEW);
		case 19:
			return Fragments.getFragment(FragmentNameConsts.FN_WATERFALL);
		case 20:
			return Fragments.getFragment(FragmentNameConsts.FN_FLIPVIEW);
		case 21:
			return Fragments.getFragment(FragmentNameConsts.FN_JSON);
		}
		return Fragments.getFragment(FragmentNameConsts.FN_DETAIL);
	}

	@Override
	public Fragment getIndexFragment() {
		return Fragments.getFragment(FragmentNameConsts.FN_INDEX);
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

	}

	@Override
	public void releaseFragments() {
		Fragments.releaseFragments();

	}

}
