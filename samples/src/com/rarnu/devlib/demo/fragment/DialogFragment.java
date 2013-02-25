package com.rarnu.devlib.demo.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.anjuke.devlib.base.BaseDialogFragment;
import com.rarnu.devlib.demo.R;

public class DialogFragment extends BaseDialogFragment implements OnClickListener {

	Button btnClose;
	
	@Override
	protected void initComponents() {
		btnClose = (Button) innerView.findViewById(R.id.btnClose);

	}

	@Override
	protected void initEvents() {
		btnClose.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_dialog;
	}

	@Override
	public void onClick(View v) {
		getActivity().finish();
		
	}

}
