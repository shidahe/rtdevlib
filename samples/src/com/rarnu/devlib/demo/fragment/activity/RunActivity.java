package com.rarnu.devlib.demo.fragment.activity;

import android.app.Fragment;

import com.anjuke.devlib.base.BaseActivity;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.fragment.RunFragment;

public class RunActivity extends BaseActivity {

	@Override
	public Fragment replaceFragment() {
		if (Fragments.fRun == null) {
			Fragments.fRun = new RunFragment();
		}
		return Fragments.fRun;
	}

	@Override
	public int getIcon() {
		return R.drawable.ic_launcher;
	}
}
