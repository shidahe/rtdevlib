package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.NetworkUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class NetworkFragment extends BaseFragment {

	TextView tvNetwork;

	@Override
	public int getBarTitle() {
		return R.string.network_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.network_name_with_path;
	}

	@Override
	protected void initComponents() {
		tvNetwork = (TextView) innerView.findViewById(R.id.tvNetwork);

	}

	@Override
	protected void initEvents() {

	}

	@Override
	protected void initLogic() {
		tvNetwork.setText(NetworkUtils.getNetworkStatusString(getActivity()));
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_network;
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

	@Override
	public String getCustomTitle() {
		return null;
	}

}
