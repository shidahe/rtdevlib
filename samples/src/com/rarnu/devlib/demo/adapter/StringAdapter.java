package com.rarnu.devlib.demo.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.anjuke.devlib.base.adapter.BaseAdapter;
import com.rarnu.devlib.demo.R;

public class StringAdapter extends BaseAdapter<String> {

	public StringAdapter(Context context, List<String> list) {
		super(context, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			v = inflater.inflate(R.layout.item_adapter, parent, false);
		}
		StringHolder holder = (StringHolder) v.getTag();
		if (holder == null) {
			holder = new StringHolder();
			holder.tvItem = (TextView) v.findViewById(R.id.tvItem);
			v.setTag(holder);
		}
		String item = list.get(position);
		if (item != null) {
			holder.tvItem.setText(item);
		}
		return v;
	}

	@Override
	public String getValueText(String item) {
		return item;
	}

}
