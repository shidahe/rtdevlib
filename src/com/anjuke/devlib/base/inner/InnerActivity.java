package com.anjuke.devlib.base.inner;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.RelativeLayout;

import com.anjuke.devlib.R;
import com.anjuke.devlib.utils.DrawableUtils;
import com.anjuke.devlib.utils.UIUtils;

public abstract class InnerActivity extends Activity {

	protected ActionBar bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		super.onCreate(savedInstanceState);

		if (getCondition()) {
			finish();
			return;
		}

		setContentView(getBaseLayout());
		
		((RelativeLayout) findViewById(R.id.layoutReplacement))
		.setBackgroundDrawable(UIUtils.isFollowSystemBackground() ? DrawableUtils
				.getSystemAttrDrawable(this,
						DrawableUtils.DETAILS_ELEMENT_BACKGROUND)
				: null);

		bar = getActionBar();
		if (bar != null) {
			bar.setIcon(getIcon());
			bar.setDisplayOptions(0, ActionBar.DISPLAY_HOME_AS_UP);
			bar.setDisplayHomeAsUpEnabled(true);
		}
		replace();
	}

	public void replace() {
		getFragmentManager().beginTransaction()
				.replace(getReplaceId(), replaceFragment()).commit();
	}

	public abstract int getIcon();

	public abstract boolean getCondition();

	public abstract int getBaseLayout();

	public abstract int getReplaceId();

	public abstract Fragment replaceFragment();

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
