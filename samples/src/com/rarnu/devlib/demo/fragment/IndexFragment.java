package com.rarnu.devlib.demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.view.Menu;

import com.anjuke.devlib.base.BasePreferenceFragment;
import com.anjuke.devlib.common.FragmentStarter;
import com.anjuke.devlib.common.GlobalInstance;
import com.anjuke.devlib.component.MutaxReceiver;
import com.anjuke.devlib.component.event.OnReceiveMessage;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.fragment.activity.AdapterActivity;
import com.rarnu.devlib.demo.fragment.activity.ArgumentActivity;
import com.rarnu.devlib.demo.fragment.activity.DialogActivity;
import com.rarnu.devlib.demo.fragment.activity.PopupActivity;
import com.rarnu.devlib.demo.service.DemoService;

public class IndexFragment extends BasePreferenceFragment implements
		OnPreferenceClickListener, OnReceiveMessage {

	Preference p1_1, p1_2, p1_3;
	Preference p2_1, p2_2, p2_3, p2_4, p2_5;
	
	MutaxReceiver mutax;

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
		
		mutax = new MutaxReceiver("com.devlib.service", null, null);
				
		
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
		
		mutax.setOnReceiveMessage(this);
		
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
		} else if (key.equals(getString(R.string.id_item_2_2))) {
			startActivity(new Intent(getActivity(), DialogActivity.class));
		} else if (key.equals(getString(R.string.id_item_2_3))) {
			startActivity(new Intent(getActivity(), PopupActivity.class));
		} else if (key.equals(getString(R.string.id_item_2_5))) {
			Intent inService = new Intent(getActivity(), DemoService.class);
			inService.putExtra("command", "service");
			inService.putExtra("id", 101);
			inService.putExtra("title", R.string.service_name);
			inService.putExtra("desc", R.string.service_finished);
			inService.putExtra("proc_id", 201);
			inService.putExtra("proc_title",	R.string.service_name);
			inService.putExtra("proc_desc", R.string.service_detail);
		    getActivity().startService(inService);
		}
		return false;
	}

	@Override
	public void onStateChange(boolean operating) {
		if (!operating) {
			Intent inCleanBackupService = new Intent(getActivity(),
					DemoService.class);
			getActivity().stopService(inCleanBackupService);
		}
		setState(operating);
	}
	
	private void setState(boolean operating) {
		p2_5.setEnabled(!operating);
	}

	@Override
	public void onProgress(String name, int position, int total) {
		
	}

	@Override
	public void onMutaxMessage(boolean operating) {
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		mutax.register(getActivity());
	}

	@Override
	public void onPause() {
		mutax.unregister(getActivity());
		super.onPause();
	}

}
