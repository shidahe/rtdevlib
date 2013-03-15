package com.rarnu.devlib.demo.fragment.activity;

import android.app.Fragment;

import com.anjuke.devlib.base.BaseSlidingActivity;
import com.anjuke.devlib.component.SlidingMenu;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.R;

public class SlideActivity extends BaseSlidingActivity {

	@Override
	public int getIcon() {
		return R.drawable.ic_launcher;
	}

	@Override
	public Fragment replaceFragment() {
		return Fragments.fSlideContent;
	}

	@Override
	public Fragment replaceMenuFragment() {
		return Fragments.fSlideMenu;
	}

	@Override
	public int getBehindOffset() {
		return 200;
	}

	@Override
	public int getAboveTouchMode() {
		return SlidingMenu.TOUCHMODE_FULLSCREEN;
	}

	@Override
	public int getBehindTouchMode() {
		return SlidingMenu.TOUCHMODE_MARGIN;
	}

}
