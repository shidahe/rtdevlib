package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class TabViewFragment extends BaseFragment {
	
	TextView tvText;
	
	public TabViewFragment() {
		super();
	}
	
	public TabViewFragment(String tagText, String tabTitle) {
		super(tagText, tabTitle);
	}
	
	@Override
	public int getBarTitle() {
		return R.string.tab_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.tab_name_with_path;
	}

	@Override
	protected void initComponents() {
		tvText = (TextView) innerView.findViewById(R.id.tvText);
		tvText.setText(getTagText());
	}

	@Override
	protected void initEvents() {

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_tab_view;
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
