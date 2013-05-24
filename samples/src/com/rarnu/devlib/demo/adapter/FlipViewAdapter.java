package com.rarnu.devlib.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anjuke.devlib.base.adapter.BaseAdapter;
import com.anjuke.devlib.utils.ImageLoader;
import com.rarnu.devlib.demo.R;

public class FlipViewAdapter extends BaseAdapter<String> {

	private ImageLoader mLoader;

	public FlipViewAdapter(Context context, List<String> list) {
		super(context, list);
		mLoader = new ImageLoader(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			v = inflater.inflate(R.layout.item_flip, parent, false);
		}
		FlipViewHolder holder = (FlipViewHolder) v.getTag();
		if (holder == null) {
			holder = new FlipViewHolder();
			holder.photo = (ImageView) v.findViewById(R.id.photo);
			holder.description = (TextView) v.findViewById(R.id.description);
			v.setTag(holder);
		}
		String item = list.get(position);
		if (item != null) {
			holder.description.setText(item);
			mLoader.DisplayImage(item, holder.photo);
		}
		return v;
	}

	@Override
	public String getValueText(String item) {
		return "";
	}

}
