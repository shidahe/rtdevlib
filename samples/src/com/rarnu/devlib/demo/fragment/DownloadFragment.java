package com.rarnu.devlib.demo.fragment;

import java.io.File;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.DownloadUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class DownloadFragment extends BaseFragment implements OnClickListener {

	ImageView iv;
	TextView tvProgress;
	Button btnDownload;

	@Override
	protected int getBarTitle() {
		return R.string.download_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.download_name_with_path;
	}

	@Override
	protected void initComponents() {
		iv = (ImageView) innerView.findViewById(R.id.iv);
		tvProgress = (TextView) innerView.findViewById(R.id.tvProgress);
		btnDownload = (Button) innerView.findViewById(R.id.btnDownload);

	}

	@Override
	protected void initEvents() {
		btnDownload.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_download;
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

	Handler hProgress = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case DownloadUtils.WHAT_DOWNLOAD_START:
			case DownloadUtils.WHAT_DOWNLOAD_PROGRESS:
				tvProgress.setText(String.format("%d/%d", msg.arg1, msg.arg2));
				break;
			case DownloadUtils.WHAT_DOWNLOAD_FINISH:
				tvProgress.setText(getString(R.string.ok));
				break;
			}
			super.handleMessage(msg);
		};
	};

	@Override
	public void onClick(View v) {
		String url = "http://b.pic1.ajkimg.com/display/xfnew/a6f4c538b466bb792a32e8d5c9de9d40/800x600.jpg";
		String localDir = "/sdcard/";
		String localFile = "test.png";
		File fLocal = new File(localDir + localFile);
		if (fLocal.exists()) {
			fLocal.delete();
		}
		DownloadUtils.downloadFileT(getActivity(), iv, url, localDir,
				localFile, hProgress);

	}

}
