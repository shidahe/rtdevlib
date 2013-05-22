package com.rarnu.devlib.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.component.PullDownListView;
import com.anjuke.devlib.component.event.OnPullDownListener;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.adapter.StringAdapter;
import com.rarnu.devlib.demo.loader.StringLoader;

public class PullDownListViewFragment extends BaseFragment implements
		OnLoadCompleteListener<List<String>>, OnPullDownListener {

	PullDownListView lvPullDown;
	StringAdapter adapter;
	List<String> list;
	StringLoader loader;
	
	private Handler hRefresh = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case PullDownListView.WHAT_DID_REFRESH: {
				list.add(0, "Add on Top");
				adapter.notifyDataSetChanged();
				lvPullDown.notifyDidRefresh();
				break;
			}

			case PullDownListView.WHAT_DID_MORE: {
				list.add("Add on Bottom");
				adapter.notifyDataSetChanged();
				lvPullDown.notifyDidMore();
				break;
			}
			}

		}

	};

	@Override
	public int getBarTitle() {
		return R.string.pulldown_listview_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.pulldown_listview_name_with_path;
	}

	@Override
	public void initComponents() {
		lvPullDown = (PullDownListView) innerView.findViewById(R.id.lvPullDown);
		list = new ArrayList<String>();
		adapter = new StringAdapter(getActivity(), list);
		lvPullDown.getListView().setAdapter(adapter);
		loader = new StringLoader(getActivity());
		lvPullDown.enableAutoFetchMore(true, 1);
		lvPullDown.setOnPullDownListener(this);
	}

	@Override
	public void initEvents() {
		loader.registerListener(0, this);

	}

	@Override
	public void initLogic() {
		loader.startLoading();
		lvPullDown.notifyDidLoad();
	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_pulldown_listview;
	}

	@Override
	public String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	public void initMenu(Menu menu) {

	}

	@Override
	public void onGetNewArguments(Bundle bn) {

	}

	@Override
	public void onLoadComplete(Loader<List<String>> loader, List<String> data) {
		list.clear();
		if (data != null) {
			list.addAll(data);
		}
		adapter.setNewList(list);

	}

	@Override
	public void onRefresh() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message msg = new Message();
				msg.what = PullDownListView.WHAT_DID_REFRESH;
				hRefresh.sendMessage(msg);
			}
		}).start();
		
	}

	@Override
	public void onMore() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Message msg = new Message();
				msg.what = PullDownListView.WHAT_DID_MORE;
				hRefresh.sendMessage(msg);
			}
		}).start();
		
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

}
