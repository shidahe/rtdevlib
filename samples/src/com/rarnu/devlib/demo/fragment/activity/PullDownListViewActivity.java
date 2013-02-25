package com.rarnu.devlib.demo.fragment.activity;

import android.app.Fragment;

import com.anjuke.devlib.base.BaseActivity;
import com.rarnu.devlib.demo.Fragments;

public class PullDownListViewActivity extends BaseActivity {

	@Override
	public Fragment replaceFragment() {
		return Fragments.fPullDownListView;
	}

}
