package com.anjuke.devlib.base;

import android.content.res.Configuration;

import com.anjuke.devlib.R;
import com.anjuke.devlib.base.inner.InnerActivity;

public abstract class BaseActivity extends InnerActivity {

	@Override
	public boolean getCondition() {
		return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
	}

	@Override
	public int getBaseLayout() {
		return R.layout.layout_replacement;
	}

	@Override
	public int getReplaceId() {
		return R.id.fReplacement;
	}

}
