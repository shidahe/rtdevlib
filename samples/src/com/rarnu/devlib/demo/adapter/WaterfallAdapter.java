package com.rarnu.devlib.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.anjuke.devlib.base.adapter.BaseAdapter;
import com.anjuke.devlib.utils.ImageLoader;
import com.rarnu.devlib.demo.R;

public class WaterfallAdapter extends BaseAdapter<String> {

	private ImageLoader mLoader;

	public WaterfallAdapter(Context context, List<String> list) {
		super(context, list);
		mLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			v = inflater.inflate(R.layout.item_waterfall, parent, false);
		}
		WaterfallHolder holder = (WaterfallHolder) v.getTag();
		if (holder == null) {
			holder = new WaterfallHolder();
			holder.ivDemo = (ImageView) v.findViewById(R.id.ivDemo);
			v.setTag(holder);
		}
		String item = list.get(position);
		if (item != null) {
			mLoader.DisplayImage(item, holder.ivDemo);
		}
		return v;
	}

	@Override
	public String getValueText(String item) {
		return "";
	}

}
