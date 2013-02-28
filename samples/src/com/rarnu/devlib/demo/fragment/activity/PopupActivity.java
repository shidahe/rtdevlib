package com.rarnu.devlib.demo.fragment.activity;

import android.app.Fragment;

import com.anjuke.devlib.base.BasePopupActivity;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.R;

public class PopupActivity extends BasePopupActivity {

	@Override
	public Fragment replaceFragment() {
		return Fragments.fPopup;
	}

	@Override
	public int getIcon() {
		return R.drawable.ic_launcher;
	}
}
