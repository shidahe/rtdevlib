package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.anjuke.devlib.base.BaseDialogFragment;
import com.rarnu.devlib.demo.R;

public class DialogFragment extends BaseDialogFragment implements OnClickListener {

	Button btnClose;
	
	@Override
	public void initComponents() {
		btnClose = (Button) innerView.findViewById(R.id.btnClose);

	}

	@Override
	public void initEvents() {
		btnClose.setOnClickListener(this);

	}

	@Override
	public void initLogic() {

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_dialog;
	}

	@Override
	public void onClick(View v) {
		getActivity().finish();
		
	}

	@Override
	public int getBarTitle() {
		return 0;
	}

	@Override
	public int getBarTitleWithPath() {
		return 0;
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public String getMainActivityName() {
		return null;
	}

	@Override
	public void initMenu(Menu menu) {
		
	}

	@Override
	public void onGetNewArguments(Bundle bn) {
	
	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

}
