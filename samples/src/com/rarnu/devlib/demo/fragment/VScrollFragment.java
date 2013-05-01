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
	protected void initComponents() {
		

	}

	@Override
	protected void initEvents() {
		

	}

	@Override
	protected void initLogic() {
		

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_vscroll;
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
