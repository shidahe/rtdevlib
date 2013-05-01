package com.rarnu.devlib.demo.fragment;

import java.util.List;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.FileUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class FileFragment extends BaseFragment implements OnClickListener {

	Button btnWrite, btnRead, btnReadAssets;
	TextView tvText;

	@Override
	public int getBarTitle() {
		return R.string.file_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.file_name_with_path;
	}

	@Override
	protected void initComponents() {
		btnWrite = (Button) innerView.findViewById(R.id.btnWrite);
		btnRead = (Button) innerView.findViewById(R.id.btnRead);
		btnReadAssets = (Button) innerView.findViewById(R.id.btnReadAssets);
		tvText = (TextView) innerView.findViewById(R.id.tvText);
	}

	@Override
	protected void initEvents() {
		btnWrite.setOnClickListener(this);
		btnRead.setOnClickListener(this);
		btnReadAssets.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_file;
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
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnWrite:
			try {
				FileUtils.rewriteFile("/sdcard/test.txt", "test");
			} catch (Exception e) {

			}
			break;
		case R.id.btnRead:
			try {
				List<String> list = FileUtils.readFile("/sdcard/test.txt");
				tvText.setText(FileUtils.toString(list));
			} catch (Exception e) {

			}
			break;
		case R.id.btnReadAssets:
			try {
				String s = FileUtils.readAssetFile(getActivity(), "test_file");
				tvText.setText(s);
			} catch (Exception e) {

			}
			break;
		}

	}

	@Override
	public String getCustomTitle() {
		return null;
	}

}
