package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.FloatUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.service.DemoFloatWindowService;

public class FloatWindowFragment extends BaseFragment implements
		OnClickListener {

	Button btnShowFloatWindow, btnHideFloatWindow;

	@Override
	public int getBarTitle() {
		return R.string.float_window_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.float_window_name_with_path;
	}

	@Override
	protected void initComponents() {
		btnShowFloatWindow = (Button) innerView
				.findViewById(R.id.btnShowFloatWindow);
		btnHideFloatWindow = (Button) innerView
				.findViewById(R.id.btnHideFloatWindow);

	}

	@Override
	protected void initEvents() {
		btnShowFloatWindow.setOnClickListener(this);
		btnHideFloatWindow.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_float_window;
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnShowFloatWindow:
			FloatUtils.showFloatWindow(getActivity(),
					DemoFloatWindowService.class);
			break;
		case R.id.btnHideFloatWindow:
			FloatUtils.hideFloatWindow(getActivity(),
					DemoFloatWindowService.class);
			break;
		}

	}

	@Override
	public String getCustomTitle() {
		return null;
	}

}
