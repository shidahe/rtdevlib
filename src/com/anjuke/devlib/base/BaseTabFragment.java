package com.anjuke.devlib.base;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.anjuke.devlib.R;
import com.anjuke.devlib.base.inner.InnerFragment;

public abstract class BaseTabFragment extends InnerFragment implements
		TabListener, OnPageChangeListener {

	protected ActionBar bar;
	private ViewPager pager;
	private BaseFragmentAdapter adapter;
	private List<Fragment> listFragment;
	private int currentPage = 0;

	@Override
	public void onDestroyView() {
		bar.removeAllTabs();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		adapter = null;
		listFragment = null;
		pager.post(new Runnable() {

			@Override
			public void run() {
				pager.setAdapter(null);

			}
		});

		super.onDestroyView();
	}

	@Override
	protected void initComponents() {
		bar = getActivity().getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		pager = (ViewPager) innerView.findViewById(R.id.pager);
		pager.setOffscreenPageLimit(3);
		listFragment = new ArrayList<Fragment>();
		initFragmentList(listFragment);
		adapter = new BaseFragmentAdapter(getFragmentManager(), listFragment);

		pager.post(new Runnable() {

			@Override
			public void run() {
				pager.setAdapter(adapter);

			}
		});

		initTab();
	}

	public void addTab(final int position, BaseFragment fragment) {

		if (listFragment.indexOf(fragment) == -1) {
			Tab t = bar.newTab().setText(fragment.getTabTitle())
					.setTabListener(this);
			if (position == -1) {
				listFragment.add(fragment);
				bar.addTab(t);
			} else {
				listFragment.add(position, fragment);
				bar.addTab(t, position);
			}

			adapter = new BaseFragmentAdapter(getFragmentManager(),
					listFragment);
			pager.post(new Runnable() {

				@Override
				public void run() {
					pager.setAdapter(adapter);
					int newPosition = (position == -1 ? listFragment.size() - 1
							: position);
					pager.setCurrentItem(newPosition);
				}
			});

		}
	}

	public void removeTab(int position) {
		int newPosition = position;
		listFragment.remove(position);
		bar.removeTabAt(position);
		newPosition--;
		if (newPosition < 0) {
			newPosition = 0;
		}
		final int nPos = newPosition;
		adapter = new BaseFragmentAdapter(getFragmentManager(), listFragment);
		pager.post(new Runnable() {

			@Override
			public void run() {
				pager.setAdapter(adapter);
				pager.setCurrentItem(nPos);
			}
		});

	}

	public abstract void initFragmentList(List<Fragment> listFragment);

	private void initTab() {
		bar.removeAllTabs();
		for (int i = 0; i < listFragment.size(); i++) {
			Tab t = bar
					.newTab()
					.setText(((BaseFragment) listFragment.get(i)).getTabTitle())
					.setTabListener(this);
			bar.addTab(t);
		}
	}

	@Override
	protected void initEvents() {
		pager.setOnPageChangeListener(this);
	}

	@Override
	protected void initLogic() {
		pager.post(new Runnable() {

			@Override
			public void run() {
				pager.setCurrentItem(0);

			}
		});
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.layout_tab;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	public int getCurrentPage() {
		return currentPage;
	}

	@Override
	public void onTabSelected(final Tab tab, FragmentTransaction ft) {
		if (pager.getCurrentItem() != tab.getPosition()) {
			currentPage = tab.getPosition();
			pager.post(new Runnable() {

				@Override
				public void run() {
					pager.setCurrentItem(tab.getPosition());

				}
			});
		}

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {

	}

	@Override
	public void onPageSelected(int position) {
		currentPage = position;
		bar.setSelectedNavigationItem(position);

	}

	public void setTabPosition(final int position) {
		bar.setSelectedNavigationItem(position);
		pager.post(new Runnable() {

			@Override
			public void run() {
				pager.setCurrentItem(position);

			}
		});

	}

}
