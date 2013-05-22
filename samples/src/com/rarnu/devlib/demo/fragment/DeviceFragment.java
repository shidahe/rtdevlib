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
	public int getBarTitle() {
		return R.string.device_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.device_name_with_path;
	}

	@Override
	public void initComponents() {
		tvDevice = (TextView) innerView.findViewById(R.id.tvDevice);
	}

	@Override
	public void initEvents() {
		

	}

	@Override
	public void initLogic() {
		tvDevice.setText(GlobalInstance.device.toString());

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_device;
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
	public String getCustomTitle() {
		return null;
	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

}
