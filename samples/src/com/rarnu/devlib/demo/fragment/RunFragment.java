package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.command.CommandResult;
import com.anjuke.devlib.utils.command.RootUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.terminal.callback.ReturnDataCallback;
import com.rarnu.terminal.session.ShellTermSession;
import com.rarnu.terminal.session.TermSession;

public class RunFragment extends BaseFragment implements OnClickListener, ReturnDataCallback {

	EditText etCommand;
	Button btnRun;
	TextView tvResult;
	
	TermSession session;

	@Override
	protected int getBarTitle() {
		return R.string.run_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.run_name_with_path;
	}

	@Override
	protected void initComponents() {
		etCommand = (EditText) innerView.findViewById(R.id.etCommand);
		btnRun = (Button) innerView.findViewById(R.id.btnRun);
		tvResult = (TextView) innerView.findViewById(R.id.tvResult);
		session = new ShellTermSession("");
		session.setDefaultUTF8Mode(true);
		session.initializeEmulator(1, 1);
	}

	@Override
	protected void initEvents() {
		btnRun.setOnClickListener(this);
		session.setReturnDataCallback(this);
	}

	@Override
	protected void initLogic() {
		session.write("su\r");
		session.write("getevent\r");
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_run;
	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected void initMenu(Menu menu) {

	}

	@Override
	protected void onGetNewArguments(Bundle bn) {

	}
	
	@Override
	public void onDestroyView() {
		session.finish();
		super.onDestroyView();
	}

	@Override
	public void onClick(View v) {
		String cmd = etCommand.getText().toString();
		if (cmd.equals("")) {
			return;
		}
		CommandResult cr = RootUtils.runCommand(cmd, false);
		String ret = "result$: " + cr.result + "\nerror$: " + cr.error;
		tvResult.setText(ret);
	}

	@Override
	public void onReceiveData(String data) {
		Log.e("onReceiveData", data);
	}
}
