package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.common.GlobalInstance;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class DeviceFragment extends BaseFragment {

	TextView tvDevice;
	
	@Override
	protected int getBarTitle() {
		return R.string.device_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.device_name_with_path;
	}

	@Override
	protected void initComponents() {
		tvDevice = (TextView) innerView.findViewById(R.id.tvDevice);
	}

	@Override
	protected void initEvents() {
		

	}

	@Override
	protected void initLogic() {
		tvDevice.setText(GlobalInstance.device.toString());

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_device;
	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected void initMenu(Menu menu) {

	}

	@Override
	protected void onGetNewArguments(Bundle bn) {

	}

}
