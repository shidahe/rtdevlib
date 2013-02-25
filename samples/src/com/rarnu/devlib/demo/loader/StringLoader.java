package com.rarnu.devlib.demo.loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;

import com.anjuke.devlib.base.BaseLoader;

public class StringLoader extends BaseLoader<String> {

	public StringLoader(Context context) {
		super(context);
	}

	@Override
	public List<String> loadInBackground() {
		List<String> list = new ArrayList<String>();
		Random r = new Random(65535);
		for (int i = 0; i < 100; i++) {
			list.add(String.valueOf(r.nextInt()));
		}
		return list;
	}

}
