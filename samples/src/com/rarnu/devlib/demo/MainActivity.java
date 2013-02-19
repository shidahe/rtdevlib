package com.rarnu.devlib.demo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

import com.anjuke.devlib.base.BaseMainActivity;

public class MainActivity extends BaseMainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
		return Fragments.fDetail;
	}

	@Override
	public Fragment getIndexFragment() {
		return Fragments.fIndex;
	}

	@Override
	public void initMenu(Menu menu) {

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
