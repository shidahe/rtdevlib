package com.rarnu.devlib.demo;

import com.rarnu.devlib.demo.fragment.DetailFragment;
import com.rarnu.devlib.demo.fragment.IndexFragment;

public class Fragments {

	public static IndexFragment fIndex = null;
	public static DetailFragment fDetail = null;
	
	public static void loadFragments() {
		if (fIndex == null) {
			fIndex = new IndexFragment();
		}
		if (fDetail == null) {
			fDetail = new DetailFragment();
		}
	}
	
	public static void releaseFragments() {
		fIndex = null;
		fDetail = null;
	}
}
