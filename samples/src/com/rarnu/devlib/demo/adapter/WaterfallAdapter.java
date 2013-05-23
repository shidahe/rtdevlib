package com.rarnu.devlib.demo.adapter;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.anjuke.devlib.base.adapter.BaseAdapter;
import com.anjuke.devlib.component.ScaleImageView;
import com.anjuke.devlib.utils.ImageLoader;
import com.rarnu.devlib.demo.R;

public class WaterfallAdapter extends BaseAdapter<String> {

	private ImageLoader mLoader;

	public WaterfallAdapter(Context context, List<String> list) {
		super(context, list);
		Log.e("WaterfallAdapter", String.valueOf(list.size()));
		mLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.e("WaterfallAdapter", "getView");
		View v = convertView;
		if (v == null) {
			v = inflater.inflate(R.layout.item_waterfall, parent, false);
		}
		WaterfallHolder holder = (WaterfallHolder) v.getTag();
		if (holder == null) {
			holder = new WaterfallHolder();
			holder.ivDemo = (ScaleImageView) v.findViewById(R.id.ivDemo);
			v.setTag(holder);
		}
		String item = list.get(position);
		if (item != null) {
			Log.e("WaterfallAdapter", "DisplayImage");
			mLoader.DisplayImage(item, holder.ivDemo);
		}
		return v;
	}

	@Override
	public String getValueText(String item) {
		return "";
	}

}
