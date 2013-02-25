package com.rarnu.devlib.demo.service;

import android.app.Notification;
import android.content.Intent;

import com.anjuke.devlib.base.BaseService;
import com.rarnu.devlib.demo.R;

public class DemoService extends BaseService {

	private Intent inService = new Intent("com.devlib.service");

	@Override
	public void initIntent() {
		inService.putExtra("operating", true);

	}

	@Override
	public void fiIntent() {
		inService.putExtra("operating", false);

	}

	@Override
	public boolean showNotification() {
		return true;
	}

	@Override
	public Intent getSendIntent() {
		return inService;
	}

	@Override
	public void doOperation(String command, Notification n) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {

		}

	}

	@Override
	public boolean getCommandCondition(String command) {
		return true;
	}

	@Override
	public int getIcon24() {
		return R.drawable.ic_launcher;
	}

}
