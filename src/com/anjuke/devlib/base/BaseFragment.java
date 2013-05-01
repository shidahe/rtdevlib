package com.anjuke.devlib.base;

import com.anjuke.devlib.base.inner.InnerFragment;


public abstract class BaseFragment extends InnerFragment {

	public BaseFragment() {
		super();
	}
	
	public BaseFragment(String tagText, String tabTitle) {
		super(tagText, tabTitle);
	}
	
}
