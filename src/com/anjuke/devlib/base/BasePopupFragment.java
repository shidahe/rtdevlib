package com.anjuke.devlib.base;

import com.anjuke.devlib.base.inner.InnerFragment;

public abstract class BasePopupFragment extends InnerFragment {
	public BasePopupFragment() {
		super();
	}

	public BasePopupFragment(String tagText, String tabTitle) {
		super(tagText, tabTitle);
	}
}
