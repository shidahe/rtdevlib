package com.anjuke.devlib.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.anjuke.devlib.common.Actions;
import com.anjuke.devlib.utils.NotificationUtils;

public abstract class BaseNotifyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {
		if (intent == null) {
			return;
		}
		String action = intent.getAction();
		if (action == null || action.equals("")) {
			return;
		}
		if (action.equals(Actions.ACTION_NOTIFY)) {
			int id = intent.getIntExtra("id", 0);
			onReceiveNotify(context, id);
			NotificationUtils.cancalAllNotification(context, new int[] { id });

		}

	}

	public abstract void onReceiveNotify(Context context, int id);

}
