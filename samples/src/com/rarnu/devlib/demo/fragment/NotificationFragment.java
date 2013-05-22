package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.common.Actions;
import com.anjuke.devlib.utils.NotificationUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class NotificationFragment extends BaseFragment implements
		OnClickListener {

	Button btnShowNotification, btnHideNotification;
	CheckBox chkCanClose;

	@Override
	public int getBarTitle() {
		return R.string.notification_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.notification_name_with_path;
	}

	@Override
	public void initComponents() {
		btnShowNotification = (Button) innerView
				.findViewById(R.id.btnShowNotification);
		btnHideNotification = (Button) innerView
				.findViewById(R.id.btnHideNotification);
		chkCanClose = (CheckBox) innerView.findViewById(R.id.chkCanClose);
	}

	@Override
	public void initEvents() {
		btnShowNotification.setOnClickListener(this);
		btnHideNotification.setOnClickListener(this);

	}

	@Override
	public void initLogic() {

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_notification;
	}

	@Override
	public String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	public void initMenu(Menu menu) {

	}

	@Override
	public void onGetNewArguments(Bundle bn) {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnShowNotification:
			NotificationUtils.showNotification(getActivity(), 999,
					R.drawable.ic_launcher, R.string.notification_title,
					R.string.notification_desc,
					(chkCanClose.isChecked() ? Actions.ACTION_NOTIFY
							: Actions.ACTION_NOTIFY_NULL), chkCanClose
							.isChecked());
			break;
		case R.id.btnHideNotification:
			NotificationUtils.cancalAllNotification(getActivity(),
					new int[] { 999 });
			break;
		}

	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

}
