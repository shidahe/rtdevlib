package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;

import com.anjuke.devlib.base.BaseFragment;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class VScrollFragment extends BaseFragment {

	@Override
	public int getBarTitle() {
		return R.string.scroll_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.scroll_name_with_path;
	}

	@Override
	public void initComponents() {
		

	}

	@Override
	public void initEvents() {
		

	}

	@Override
	public void initLogic() {
		

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_vscroll;
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
