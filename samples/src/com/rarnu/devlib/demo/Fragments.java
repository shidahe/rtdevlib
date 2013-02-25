package com.rarnu.devlib.demo;

import com.rarnu.devlib.demo.fragment.AdapterFragment;
import com.rarnu.devlib.demo.fragment.ArgumentFragment;
import com.rarnu.devlib.demo.fragment.IndexFragment;

public class Fragments {

	public static IndexFragment fIndex = null;
	public static ArgumentFragment fDetail = null;
	public static AdapterFragment fAdapter = null;
	
	public static void loadFragments() {
		if (fIndex == null) {
			fIndex = new IndexFragment();
		}
		if (fDetail == null) {
			fDetail = new ArgumentFragment();
		}
		if (fAdapter == null) {
			fAdapter = new AdapterFragment();
		}
	}
	
	public static void releaseFragments() {
		fIndex = null;
		fDetail = null;
		fAdapter = null;
	}
}
