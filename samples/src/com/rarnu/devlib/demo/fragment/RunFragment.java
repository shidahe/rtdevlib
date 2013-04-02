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
import com.anjuke.devlib.utils.command.emu.EmulatorTool;
import com.anjuke.devlib.utils.command.emu.event.IEmuCallback;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class RunFragment extends BaseFragment implements OnClickListener, IEmuCallback {

	EditText etCommand;
	Button btnRun;
	TextView tvResult;
	
	EmulatorTool tool;

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
		tool = new EmulatorTool(this);
	}

	@Override
	protected void initEvents() {
		btnRun.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {
		tool.listen();
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
		Log.e("EmulatorTool", "close");
		tool.close();
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
	public void openingEmu() {
		tool.write("su\r");
		tool.write("getevent\r");
		
	}

	@Override
	public void closingEmu() {
		tool.write("killall getevent\r");
		tool.write("exit\r");
	}

	@Override
	public void receiveEmuMessage(String msg) {
		Log.e("EmulatorTool", msg);
		
	}


}
