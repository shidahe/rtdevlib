package com.rarnu.devlib.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.component.EndlessViewPager;
import com.anjuke.devlib.component.HScrollLayout;
import com.anjuke.devlib.component.PointBar;
import com.anjuke.devlib.component.event.OnPageSelected;
import com.anjuke.devlib.component.event.OnScreenChangeListener;
import com.anjuke.devlib.utils.UIUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class HScrollFragment extends BaseFragment implements OnScreenChangeListener, OnPageSelected {

	PointBar barPoint, evpPoint;
	HScrollLayout hsl;
	EndlessViewPager evp;
	
	List<View> views;

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
		barPoint = (PointBar) innerView.findViewById(R.id.barPoint);
		evpPoint = (PointBar) innerView.findViewById(R.id.evpPoint);
		hsl = (HScrollLayout) innerView.findViewById(R.id.hsl);
		evp = (EndlessViewPager) innerView.findViewById(R.id.evp);
		
		int height = UIUtils.getHeight() - getActivity().getActionBar().getHeight() - UIUtils.getStatusbarHeight(getActivity());
		height /= 2;
		ViewGroup.LayoutParams hsllp = hsl.getLayoutParams();
		hsllp.height = height;
		hsl.setLayoutParams(hsllp);
		
		ViewGroup.LayoutParams evplp = evp.getLayoutParams();
		evplp.height = height;
		evp.setLayoutParams(evplp);
		
		initViewPager();
		
	}
	
	private void initViewPager() {
		evp.setEndless(true);
		views = new ArrayList<View>();
		LayoutInflater inf = LayoutInflater.from(getActivity());
		View v1 = inf.inflate(R.layout.view_page1, null);
		View v2 = inf.inflate(R.layout.view_page2, null);
		View v3 = inf.inflate(R.layout.view_page3, null);
		views.add(v1);
		views.add(v2);
		views.add(v3);
		evp.setData(views);
		evp.setCurrentItem(Integer.MAX_VALUE / 2 - 3);
	}

	@Override
	protected void initEvents() {
		hsl.setOnScreenChangeListener(this);
		evp.setOnPageSelected(this);
	}

	@Override
	protected void initLogic() {
		barPoint.setPointCount(3);
		barPoint.setPoint(0);
		
		evpPoint.setPointCount(3);
		evpPoint.setPoint(0);
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

	@Override
	public void onPageSelected(int position) {
		evpPoint.setPoint(position);
		
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

}
