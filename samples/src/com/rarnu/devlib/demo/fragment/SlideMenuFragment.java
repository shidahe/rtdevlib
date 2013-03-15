package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.Menu;

import com.anjuke.devlib.base.BasePreferenceFragment;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.fragment.activity.SlideActivity;

public class SlideMenuFragment extends BasePreferenceFragment implements
		OnPreferenceClickListener {

	Preference pItem1, pItem2, pItem3;

	@Override
	protected int getBarTitle() {
		return R.string.slidemenu_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.slidemenu_name;
	}

	@Override
	protected void initComponents() {
		pItem1 = findPreference(getString(R.string.menuid_item_1));
		pItem2 = findPreference(getString(R.string.menuid_item_2));
		pItem3 = findPreference(getString(R.string.menuid_item_3));

	}

	@Override
	protected void initEvents() {
		pItem1.setOnPreferenceClickListener(this);
		pItem2.setOnPreferenceClickListener(this);
		pItem3.setOnPreferenceClickListener(this);

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected void initMenu(Menu menu) {

	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected int getPreferenceLayoutId() {
		return R.xml.menu_slide;
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		String text = preference.getTitle().toString();
		Bundle bn = new Bundle();
		bn.putString("text", text);
		Fragments.fSlideContent.setNewArguments(bn);
		((SlideActivity) getActivity()).getSlidingMenu().toggle();
		return true;
	}

}
