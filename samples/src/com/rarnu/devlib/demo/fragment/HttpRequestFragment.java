package com.rarnu.devlib.demo.fragment;

import org.apache.http.protocol.HTTP;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.HttpRequest;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class HttpRequestFragment extends BaseFragment implements
		OnClickListener {

	Button btnRequest;
	TextView tvResult;

	@Override
	protected int getBarTitle() {
		return R.string.http_request_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.http_request_name_with_path;
	}

	@Override
	protected void initComponents() {
		btnRequest = (Button) innerView.findViewById(R.id.btnRequest);
		tvResult = (TextView) innerView.findViewById(R.id.tvResult);
	}

	@Override
	protected void initEvents() {
		btnRequest.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {

	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_http_request;
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

	Handler hRequest = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 1) {
				tvResult.setText((String) msg.obj);
			}
			super.handleMessage(msg);
		};

	};

	@Override
	public void onClick(View v) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				String ret = HttpRequest.get("http://www.anjuke.com", "",
						HTTP.UTF_8);
				Message msg = new Message();
				msg.what = 1;
				msg.obj = ret;
				hRequest.sendMessage(msg);

			}
		}).start();

	}

}
