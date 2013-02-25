package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.component.HScrollLayout;
import com.anjuke.devlib.component.PointBar;
import com.anjuke.devlib.component.event.OnScreenChangeListener;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class HScrollFragment extends BaseFragment implements OnScreenChangeListener {

	PointBar barPoint;
	HScrollLayout hsl;

	@Override
	protected int getBarTitle() {
		return R.string.scroll_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.scroll_name_with_path;
	}

	@Override
	protected void initComponents() {
		barPoint = (PointBar) innerView.findViewById(R.id.barPoint);
		hsl = (HScrollLayout) innerView.findViewById(R.id.hsl);
	}

	@Override
	protected void initEvents() {
		hsl.setOnScreenChangeListener(this);
	}

	@Override
	protected void initLogic() {
		barPoint.setPointCount(3);
		barPoint.setPoint(0);
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_hscroll;
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
	public void onScreenChange(View v, int screen) {
		barPoint.setPoint(screen);
		
	}

}
