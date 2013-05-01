package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.common.GlobalInstance;
import com.anjuke.devlib.utils.UIUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class UIFragment extends BaseFragment {

	TextView tv40, tv60, tv80;
	Button btn1, btn2, btn3;

	@Override
	public int getBarTitle() {
		return R.string.ui_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.ui_name_with_path;
	}

	@Override
	protected void initComponents() {
		tv40 = (TextView) innerView.findViewById(R.id.tv40);
		tv60 = (TextView) innerView.findViewById(R.id.tv60);
		tv80 = (TextView) innerView.findViewById(R.id.tv80);
		btn1 = (Button) innerView.findViewById(R.id.btn1);
		btn2 = (Button) innerView.findViewById(R.id.btn2);
		btn3 = (Button) innerView.findViewById(R.id.btn3);
	}

	@Override
	protected void initEvents() {

	}

	@Override
	protected void initLogic() {
		int btnWidth = 0;
		if (GlobalInstance.dualPane) {
			UIUtils.setViewPercentXByFrame(tv40, 40, 55);
			UIUtils.setViewPercentXByFrame(tv60, 60, 55);
			UIUtils.setViewPercentXByFrame(tv80, 80, 55);

			btnWidth = UIUtils.countViewAdvWidthByFrame(3, UIUtils.dipToPx(8),
					UIUtils.dipToPx(16), (UIUtils.getWidth() * 55 / 100));

		} else {

			UIUtils.setViewPercentX(tv40, 40);
			UIUtils.setViewPercentX(tv60, 60);
			UIUtils.setViewPercentX(tv80, 80);

			btnWidth = UIUtils.countViewAdvWidth(3, UIUtils.dipToPx(8),
					UIUtils.dipToPx(16));
		}
		UIUtils.setViewSizeX(btn1, btnWidth);
		UIUtils.setViewSizeX(btn2, btnWidth);
		UIUtils.setViewSizeX(btn3, btnWidth);

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_ui;
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
