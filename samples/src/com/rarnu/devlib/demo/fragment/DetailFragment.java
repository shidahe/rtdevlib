package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.anjuke.devlib.base.BaseFragment;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class DetailFragment extends BaseFragment implements OnClickListener {

	TextView tvFragmentId;
	Button btnShowId;

	@Override
	protected int getBarTitle() {
		return R.string.detail_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.detail_name_with_path;
	}

	@Override
	protected void initComponents() {
		tvFragmentId = (TextView) innerView.findViewById(R.id.tvFragmentId);
		btnShowId = (Button) innerView.findViewById(R.id.btnShowId);

	}

	@Override
	protected void initEvents() {
		btnShowId.setOnClickListener(this);
	}

	@Override
	protected void initLogic() {
		if (innerBundle != null) {
			String key = getArguments().getString("key");
			tvFragmentId.setText(key);
		}
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment;
	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected void initMenu(Menu menu) {

	}

	@Override
	public void onClick(View v) {
		Toast.makeText(getActivity(), tvFragmentId.getText().toString(),
				Toast.LENGTH_SHORT).show();

	}

	@Override
	protected void onGetNewArguments(Bundle bn) {
		String key = bn.getString("key");
		tvFragmentId.setText(key);
	}

}
