package com.rarnu.devlib.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.Menu;

import com.anjuke.devlib.base.BasePreferenceFragment;
import com.anjuke.devlib.common.FragmentStarter;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.fragment.activity.DetailActivity;

public class IndexFragment extends BasePreferenceFragment implements
		OnPreferenceClickListener {

	Preference p1_1, p1_2, p1_3;

	@Override
	protected int getBarTitle() {
		return R.string.app_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.app_name;
	}

	@Override
	protected void initComponents() {
		p1_1 = (Preference) findPreference(getString(R.string.id_item_1_1));
		p1_2 = (Preference) findPreference(getString(R.string.id_item_1_2));
		p1_3 = (Preference) findPreference(getString(R.string.id_item_1_3));
	}

	@Override
	protected void initEvents() {
		p1_1.setOnPreferenceClickListener(this);
		p1_2.setOnPreferenceClickListener(this);
		p1_3.setOnPreferenceClickListener(this);
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
		return R.xml.main;
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		Bundle bn = new Bundle();
		bn.putString("key", preference.getKey());
		if (Fragments.fDetail.isAdded()) {
			Fragments.fDetail.setNewArguments(bn);
		} else {
			Fragments.fDetail.setArguments(bn);
			FragmentStarter.showContent(getActivity(), new Intent(
					getActivity(), DetailActivity.class), Fragments.fDetail);
		}
		return false;
	}

}
