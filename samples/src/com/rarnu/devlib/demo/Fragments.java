package com.rarnu.devlib.demo;

import com.rarnu.devlib.demo.fragment.AdapterFragment;
import com.rarnu.devlib.demo.fragment.ArgumentFragment;
import com.rarnu.devlib.demo.fragment.DialogFragment;
import com.rarnu.devlib.demo.fragment.IndexFragment;
import com.rarnu.devlib.demo.fragment.PopupFragment;

public class Fragments {

	public static IndexFragment fIndex = null;
	public static ArgumentFragment fDetail = null;
	public static AdapterFragment fAdapter = null;
	public static DialogFragment fDialog = null;
	public static PopupFragment fPopup = null;
	
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
		if (fDialog == null) {
			fDialog = new DialogFragment();
		}
		if (fPopup == null) {
			fPopup = new PopupFragment();
		}
	}
	
	public static void releaseFragments() {
		fIndex = null;
		fDetail = null;
		fAdapter = null;
		fDialog = null;
		fPopup = null;
	}
}
