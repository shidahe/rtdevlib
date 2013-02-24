package com.anjuke.devlib.component;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.anjuke.devlib.common.GlobalInstance;
import com.anjuke.devlib.utils.NetworkUtils;
import com.anjuke.devlib.utils.PingUtils;

public class NetworkReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		if (intent == null) {
			return;
		}
		String action = intent.getAction();
		if (action == null || action.equals("")) {
			return;
		}

		if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					GlobalInstance.loadingNetwork = true;
					GlobalInstance.networkInfo = NetworkUtils.getNetworkInfo(context);
					GlobalInstance.networkSpeed = PingUtils.testNetworkSpeed(context);
					GlobalInstance.loadingNetwork = false;

				}
			}).start();

		}

	}

}
