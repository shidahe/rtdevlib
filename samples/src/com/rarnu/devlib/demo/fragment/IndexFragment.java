package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.Menu;

import com.anjuke.devlib.base.BasePreferenceFragment;
import com.anjuke.devlib.common.FragmentStarter;
import com.anjuke.devlib.common.GlobalInstance;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.fragment.activity.AdapterActivity;
import com.rarnu.devlib.demo.fragment.activity.ArgumentActivity;

public class IndexFragment extends BasePreferenceFragment implements
		OnPreferenceClickListener {

	Preference p1_1, p1_2, p1_3;
	Preference p2_1, p2_2, p2_3, p2_4, p2_5;

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

		p2_1 = (Preference) findPreference(getString(R.string.id_item_2_1));
		p2_2 = (Preference) findPreference(getString(R.string.id_item_2_2));
		p2_3 = (Preference) findPreference(getString(R.string.id_item_2_3));
		p2_4 = (Preference) findPreference(getString(R.string.id_item_2_4));
		p2_5 = (Preference) findPreference(getString(R.string.id_item_2_5));

	}

	@Override
	protected void initEvents() {
		p1_1.setOnPreferenceClickListener(this);
		p1_2.setOnPreferenceClickListener(this);
		p1_3.setOnPreferenceClickListener(this);

		p2_1.setOnPreferenceClickListener(this);
		p2_2.setOnPreferenceClickListener(this);
		p2_3.setOnPreferenceClickListener(this);
		p2_4.setOnPreferenceClickListener(this);
		p2_5.setOnPreferenceClickListener(this);
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
		String key = preference.getKey();
		if (key.startsWith("Arg_1_")) {
			GlobalInstance.currentFragment = 1;
			Bundle bn = new Bundle();
			bn.putString("key", preference.getKey());
			if (Fragments.fDetail.isAdded()) {
				Fragments.fDetail.setNewArguments(bn);
			} else {
				Fragments.fDetail.setArguments(bn);
				FragmentStarter.showContent(getActivity(),
						ArgumentActivity.class, Fragments.fDetail);
			}
		} else if (key.equals(getString(R.string.id_item_2_1))
				|| key.equals(getString(R.string.id_item_2_4))) {
			GlobalInstance.currentFragment = 2;
			FragmentStarter.showContent(getActivity(), AdapterActivity.class,
					Fragments.fAdapter);
		}
		return false;
	}

}
