package com.rarnu.devlib.demo.receiver;

import android.content.Context;
import android.widget.Toast;

import com.anjuke.devlib.base.BaseNotifyReceiver;

public class NotifyReceiver extends BaseNotifyReceiver {

	@Override
	public void onReceiveNotify(Context context, int id) {
		Toast.makeText(context, String.valueOf(id), Toast.LENGTH_SHORT).show();
	}

}
