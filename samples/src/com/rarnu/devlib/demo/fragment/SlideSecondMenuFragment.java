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

public class SlideSecondMenuFragment extends BasePreferenceFragment implements
		OnPreferenceClickListener {

	Preference pItem4, pItem5, pItem6;

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
		pItem4 = findPreference(getString(R.string.menuid_item_4));
		pItem5 = findPreference(getString(R.string.menuid_item_5));
		pItem6 = findPreference(getString(R.string.menuid_item_6));

	}

	@Override
	protected void initEvents() {
		pItem4.setOnPreferenceClickListener(this);
		pItem5.setOnPreferenceClickListener(this);
		pItem6.setOnPreferenceClickListener(this);

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
		return R.xml.second_menu_slide;
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
