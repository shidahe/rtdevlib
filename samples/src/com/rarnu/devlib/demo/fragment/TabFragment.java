package com.rarnu.devlib.demo.fragment;

import java.util.List;
import java.util.Random;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.anjuke.devlib.base.BaseTabFragment;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class TabFragment extends BaseTabFragment {

	MenuItem itemAdd, itemRemove;

	@Override
	public int getBarTitle() {
		return R.string.tab_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.tab_name_with_path;
	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected void initMenu(Menu menu) {
		itemAdd = menu.add(0, 1, 99, "Add");
		itemAdd.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		itemRemove = menu.add(0, 2, 100, "Remove");
		itemRemove.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Random r = new Random(System.currentTimeMillis());
			String tag = String.valueOf(r.nextInt());
			addTab(-1, new TabViewFragment(tag, tag));
			break;
		case 2:
			int position = getCurrentPage();
			removeTab(position);
			break;
		}
		return true;
	}

	@Override
	protected void onGetNewArguments(Bundle bn) {

	}

	@Override
	public void initFragmentList(List<Fragment> listFragment) {
		listFragment.add(new TabViewFragment("Fragment 1", "Tab 1"));
		listFragment.add(new TabViewFragment("Fragment 2", "Tab 2"));
		listFragment.add(new TabViewFragment("Fragment 3", "Tab 3"));
		listFragment.add(new TabViewFragment("Fragment 4", "Tab 4"));
		listFragment.add(new TabViewFragment("Fragment 5", "Tab 5"));
		
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

}
