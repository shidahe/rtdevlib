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
import com.anjuke.devlib.component.intf.OnReceiveMessage;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.fragment.activity.AdapterActivity;
import com.rarnu.devlib.demo.fragment.activity.ArgumentActivity;
import com.rarnu.devlib.demo.fragment.activity.DeviceActivity;
import com.rarnu.devlib.demo.fragment.activity.DialogActivity;
import com.rarnu.devlib.demo.fragment.activity.DownloadActivity;
import com.rarnu.devlib.demo.fragment.activity.DragListViewActivity;
import com.rarnu.devlib.demo.fragment.activity.FileActivity;
import com.rarnu.devlib.demo.fragment.activity.FlipViewActivity;
import com.rarnu.devlib.demo.fragment.activity.FloatWindowActivity;
import com.rarnu.devlib.demo.fragment.activity.HScrollActivity;
import com.rarnu.devlib.demo.fragment.activity.HttpRequestActivity;
import com.rarnu.devlib.demo.fragment.activity.ImageActivity;
import com.rarnu.devlib.demo.fragment.activity.NetworkActivity;
import com.rarnu.devlib.demo.fragment.activity.NotificationActivity;
import com.rarnu.devlib.demo.fragment.activity.PopupActivity;
import com.rarnu.devlib.demo.fragment.activity.PullDownLayoutActivity;
import com.rarnu.devlib.demo.fragment.activity.PullDownListViewActivity;
import com.rarnu.devlib.demo.fragment.activity.RunActivity;
import com.rarnu.devlib.demo.fragment.activity.SlideActivity;
import com.rarnu.devlib.demo.fragment.activity.TabActivity;
import com.rarnu.devlib.demo.fragment.activity.UIActivity;
import com.rarnu.devlib.demo.fragment.activity.VScrollActivity;
import com.rarnu.devlib.demo.fragment.activity.WaterfallActivity;
import com.rarnu.devlib.demo.service.DemoService;

public class IndexFragment extends BasePreferenceFragment implements
		OnPreferenceClickListener, OnReceiveMessage {

	Preference p1_1, p1_2, p1_3;
	Preference p2_1, p2_2, p2_3, p2_4;
	Preference p3_1, p3_2, p3_3, p3_4, p3_5, p3_6, p3_7;
	Preference p4_1, p4_2, p4_3, p4_4, p4_5, p4_6, p4_7, p4_8;
	Preference p5_1;

	Preference p3_4_1, p3_4_2, p3_4_3;

	MutaxReceiver mutax;

	@Override
	public int getBarTitle() {
		return R.string.app_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.app_name;
	}

	@Override
	public void initComponents() {

		mutax = new MutaxReceiver("com.devlib.service", null, null);

		p1_1 = (Preference) findPreference(getString(R.string.id_item_1_1));
		p1_2 = (Preference) findPreference(getString(R.string.id_item_1_2));
		p1_3 = (Preference) findPreference(getString(R.string.id_item_1_3));

		p2_1 = (Preference) findPreference(getString(R.string.id_item_2_1));
		p2_2 = (Preference) findPreference(getString(R.string.id_item_2_2));
		p2_3 = (Preference) findPreference(getString(R.string.id_item_2_3));
		p2_4 = (Preference) findPreference(getString(R.string.id_item_2_4));

		p3_1 = (Preference) findPreference(getString(R.string.id_item_3_1));
		p3_2 = (Preference) findPreference(getString(R.string.id_item_3_2));
		p3_3 = (Preference) findPreference(getString(R.string.id_item_3_3));
		p3_4 = (Preference) findPreference(getString(R.string.id_item_3_4));
		p3_5 = (Preference) findPreference(getString(R.string.id_item_3_5));
		p3_6 = (Preference) findPreference(getString(R.string.id_item_3_6));
		p3_7 = (Preference) findPreference(getString(R.string.id_item_3_7));

		p4_1 = (Preference) findPreference(getString(R.string.id_item_4_1));
		p4_2 = (Preference) findPreference(getString(R.string.id_item_4_2));
		p4_3 = (Preference) findPreference(getString(R.string.id_item_4_3));
		p4_4 = (Preference) findPreference(getString(R.string.id_item_4_4));
		p4_5 = (Preference) findPreference(getString(R.string.id_item_4_5));
		p4_6 = (Preference) findPreference(getString(R.string.id_item_4_6));
		p4_7 = (Preference) findPreference(getString(R.string.id_item_4_7));
		p4_8 = (Preference) findPreference(getString(R.string.id_item_4_8));

		p5_1 = (Preference) findPreference(getString(R.string.id_item_5_1));

		p3_4_1 = (Preference) findPreference(getString(R.string.id_item_3_4_1));
		p3_4_2 = (Preference) findPreference(getString(R.string.id_item_3_4_2));
		p3_4_3 = (Preference) findPreference(getString(R.string.id_item_3_4_3));

	}

	@Override
	public void initEvents() {

		mutax.setOnReceiveMessage(this);

		p1_1.setOnPreferenceClickListener(this);
		p1_2.setOnPreferenceClickListener(this);
		p1_3.setOnPreferenceClickListener(this);

		p2_1.setOnPreferenceClickListener(this);
		p2_2.setOnPreferenceClickListener(this);
		p2_3.setOnPreferenceClickListener(this);
		p2_4.setOnPreferenceClickListener(this);

		p3_1.setOnPreferenceClickListener(this);
		p3_2.setOnPreferenceClickListener(this);
		p3_3.setOnPreferenceClickListener(this);
		p3_4.setOnPreferenceClickListener(this);
		p3_5.setOnPreferenceClickListener(this);
		p3_6.setOnPreferenceClickListener(this);
		p3_7.setOnPreferenceClickListener(this);

		p4_1.setOnPreferenceClickListener(this);
		p4_2.setOnPreferenceClickListener(this);
		p4_3.setOnPreferenceClickListener(this);
		p4_4.setOnPreferenceClickListener(this);
		p4_5.setOnPreferenceClickListener(this);
		p4_6.setOnPreferenceClickListener(this);
		p4_7.setOnPreferenceClickListener(this);
		p4_8.setOnPreferenceClickListener(this);

		p5_1.setOnPreferenceClickListener(this);

		p3_4_1.setOnPreferenceClickListener(this);
		p3_4_2.setOnPreferenceClickListener(this);
		p3_4_3.setOnPreferenceClickListener(this);
	}

	@Override
	public void initLogic() {

	}

	@Override
	public void initMenu(Menu menu) {

	}

	@Override
	public String getMainActivityName() {
		return MainActivity.class.getName();
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
		} else if (key.equals(getString(R.string.id_item_2_1))) {
			GlobalInstance.currentFragment = 2;
			FragmentStarter.showContent(getActivity(), AdapterActivity.class,
					Fragments.fAdapter);
		} else if (key.equals(getString(R.string.id_item_2_2))) {
			startActivity(new Intent(getActivity(), DialogActivity.class));
		} else if (key.equals(getString(R.string.id_item_2_3))) {
			startActivity(new Intent(getActivity(), PopupActivity.class));
		} else if (key.equals(getString(R.string.id_item_2_4))) {
			Intent inService = new Intent(getActivity(), DemoService.class);
			inService.putExtra("command", "service");
			inService.putExtra("id", 101);
			inService.putExtra("title", R.string.service_name);
			inService.putExtra("desc", R.string.service_finished);
			inService.putExtra("proc_id", 201);
			inService.putExtra("proc_title", R.string.service_name);
			inService.putExtra("proc_desc", R.string.service_detail);
			getActivity().startService(inService);
		} else if (key.equals(getString(R.string.id_item_3_1))) {
			GlobalInstance.currentFragment = 3;
			FragmentStarter.showContent(getActivity(), HScrollActivity.class,
					Fragments.fHScroll);
		} else if (key.equals(getString(R.string.id_item_3_2))) {
			GlobalInstance.currentFragment = 4;
			FragmentStarter.showContent(getActivity(), VScrollActivity.class,
					Fragments.fVScroll);
		} else if (key.equals(getString(R.string.id_item_3_3))) {
			GlobalInstance.currentFragment = 5;
			FragmentStarter.showContent(getActivity(),
					PullDownLayoutActivity.class, Fragments.fPullDownLayout);
		} else if (key.equals(getString(R.string.id_item_3_4))) {
			GlobalInstance.currentFragment = 6;
			FragmentStarter
					.showContent(getActivity(), PullDownListViewActivity.class,
							Fragments.fPullDownListView);
		} else if (key.equals(getString(R.string.id_item_3_5))) {
			startActivity(new Intent(getActivity(), SlideActivity.class));
		} else if (key.equals(getString(R.string.id_item_3_6))) {
			GlobalInstance.currentFragment = 16;
			FragmentStarter.showContent(getActivity(),
					FloatWindowActivity.class, Fragments.fFloatWindow);
		} else if (key.equals(getString(R.string.id_item_3_7))) {
			GlobalInstance.currentFragment = 17;
			FragmentStarter.showContent(getActivity(), TabActivity.class,
					Fragments.fTab);
		} else if (key.equals(getString(R.string.id_item_4_1))) {
			GlobalInstance.currentFragment = 7;
			FragmentStarter.showContent(getActivity(), DeviceActivity.class,
					Fragments.fDevice);
		} else if (key.equals(getString(R.string.id_item_4_2))) {
			GlobalInstance.currentFragment = 8;
			FragmentStarter.showContent(getActivity(), DownloadActivity.class,
					Fragments.fDownload);
		} else if (key.equals(getString(R.string.id_item_4_3))) {
			GlobalInstance.currentFragment = 9;
			FragmentStarter.showContent(getActivity(), FileActivity.class,
					Fragments.fFile);
		} else if (key.equals(getString(R.string.id_item_4_4))) {
			GlobalInstance.currentFragment = 10;
			FragmentStarter.showContent(getActivity(),
					HttpRequestActivity.class, Fragments.fHttpRequest);
		} else if (key.equals(getString(R.string.id_item_4_5))) {
			GlobalInstance.currentFragment = 11;
			FragmentStarter.showContent(getActivity(), ImageActivity.class,
					Fragments.fImage);
		} else if (key.equals(getString(R.string.id_item_4_6))) {
			GlobalInstance.currentFragment = 12;
			FragmentStarter.showContent(getActivity(), NetworkActivity.class,
					Fragments.fNetwork);
		} else if (key.equals(getString(R.string.id_item_4_7))) {
			GlobalInstance.currentFragment = 13;
			FragmentStarter.showContent(getActivity(),
					NotificationActivity.class, Fragments.fNotification);
		} else if (key.equals(getString(R.string.id_item_4_8))) {
			GlobalInstance.currentFragment = 14;
			FragmentStarter.showContent(getActivity(), UIActivity.class,
					Fragments.fUI);
		} else if (key.equals(getString(R.string.id_item_5_1))) {
			GlobalInstance.currentFragment = 15;
			FragmentStarter.showContent(getActivity(), RunActivity.class,
					Fragments.fRun);
		} else if (key.equals(getString(R.string.id_item_3_4_1))) {
			GlobalInstance.currentFragment = 18;
			FragmentStarter.showContent(getActivity(),
					DragListViewActivity.class, Fragments.fDragListView);
		} else if (key.equals(getString(R.string.id_item_3_4_2))) {
			GlobalInstance.currentFragment = 19;
			FragmentStarter.showContent(getActivity(), WaterfallActivity.class,
					Fragments.fWaterfall);
		} else if (key.equals(getString(R.string.id_item_3_4_3))) {
			GlobalInstance.currentFragment = 20;
			FragmentStarter.showContent(getActivity(), FlipViewActivity.class,
					Fragments.fFlipView);
		}
		return true;
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
		p2_4.setEnabled(!operating);
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

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public int getFragmentLayoutResId() {
		return R.xml.main;
	}

	@Override
	public void onGetNewArguments(Bundle bn) {

	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

}
