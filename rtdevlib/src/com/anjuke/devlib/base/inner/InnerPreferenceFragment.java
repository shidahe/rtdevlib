package com.anjuke.devlib.base.inner;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.Menu;
import android.view.MenuInflater;

import com.anjuke.devlib.base.intf.InnerIntf;
import com.anjuke.devlib.common.GlobalInstance;

public abstract class InnerPreferenceFragment extends PreferenceFragment
		implements InnerIntf {

	protected String tabTitle;
	protected Bundle innerBundle = null;

	public String getTabTitle() {
		return tabTitle;
	}

	public InnerPreferenceFragment() {
		super();
	}

	public InnerPreferenceFragment(String tabTitle) {
		super();
		this.tabTitle = tabTitle;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		innerBundle = getArguments();
		initComponents();
		initEvents();
		initLogic();
	}

	public void setNewArguments(Bundle bn) {
		innerBundle = getArguments();
		onGetNewArguments(bn);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		addPreferencesFromResource(getFragmentLayoutResId());

		if (getActivity().getActionBar() != null) {
			if (getCustomTitle() == null || getCustomTitle().equals("")) {
				if (GlobalInstance.dualPane) {
					getActivity().getActionBar()
							.setTitle(getBarTitleWithPath());
				} else {
					getActivity().getActionBar().setTitle(getBarTitle());
				}
			} else {
				getActivity().getActionBar().setTitle(getCustomTitle());
			}
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		if (getActivity() == null) {
			return;
		}
		if (getActivity().getClass().getName().equals(getMainActivityName())
				&& !GlobalInstance.dualPane) {
			return;
		}

		initMenu(menu);
	}

}
