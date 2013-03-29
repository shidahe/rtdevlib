package com.rarnu.devlib.demo.service;

import android.view.View;

import com.anjuke.devlib.base.BaseFloatService;
import com.rarnu.devlib.demo.R;

public class DemoFloatWindowService extends BaseFloatService {

	@Override
	public int getViewResId() {
		return R.layout.view_float;
	}

	@Override
	public void initView(View view) {


	}

	@Override
	public int getX() {
		return -1;
	}

	@Override
	public int getY() {
		return -1;
	}

}
