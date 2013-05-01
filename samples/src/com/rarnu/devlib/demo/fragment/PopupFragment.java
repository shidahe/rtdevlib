package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;

import com.anjuke.devlib.base.BasePopupFragment;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class PopupFragment extends BasePopupFragment {

	@Override
	public int getBarTitle() {
		return R.string.popup_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.popup_name;
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
		return R.layout.fragment_popup;
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
