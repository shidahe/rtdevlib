package com.rarnu.devlib.demo.fragment;

import java.io.IOException;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.component.BlockView.FocusCallback;
import com.anjuke.devlib.component.BlockView.ItemClickListener;
import com.anjuke.devlib.component.HScrollLayout;
import com.anjuke.devlib.component.MergeView;
import com.anjuke.devlib.component.tools.MergePage;
import com.anjuke.devlib.utils.FileUtils;
import com.anjuke.devlib.utils.UIUtils;
import com.rarnu.devlib.demo.R;

public class DynamicMetroFragment extends BaseFragment implements
		FocusCallback, ItemClickListener {

	MergeView mvPage1, mvPage2, mvPage3;
	MergePage mp1, mp2, mp3;
	HScrollLayout slMain;

	int focusPage = 0;

	@Override
	public int getBarTitle() {
		return 0;
	}

	@Override
	public int getBarTitleWithPath() {
		return 0;
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public void initComponents() {
		slMain = (HScrollLayout) innerView.findViewById(R.id.slMain);

		mvPage1 = (MergeView) innerView.findViewById(R.id.mvPage1);
		mvPage2 = (MergeView) innerView.findViewById(R.id.mvPage2);
		mvPage3 = (MergeView) innerView.findViewById(R.id.mvPage3);

		// the main activity is not landscape, so here needs to swap the width
		// and height value;
		mvPage1.setSize(UIUtils.getHeight(), UIUtils.getWidth());
		mvPage2.setSize(UIUtils.getHeight(), UIUtils.getWidth());
		mvPage3.setSize(UIUtils.getHeight(), UIUtils.getWidth());
		mvPage1.setGridSize(4, 2);
		mvPage2.setGridSize(4, 2);
		mvPage3.setGridSize(4, 2);

		int padding = UIUtils.dipToPx(16);
		mvPage1.setPadding(padding);
		mvPage2.setPadding(padding);
		mvPage3.setPadding(padding);

	}

	@Override
	public void initEvents() {

	}

	@Override
	public void initLogic() {
		try {
			mp1 = new MergePage(getActivity(), getData(getActivity(), 1));
			mp2 = new MergePage(getActivity(), getData(getActivity(), 2));
			mp3 = new MergePage(getActivity(), getData(getActivity(), 3));
		} catch (Exception e) {

		}

		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;

		mvPage1.setViews(mp1.getViews(getActivity(),
				R.layout.item_dynamic_cell, new String[] { "image", "text" },
				new int[] { R.id.ivImage, R.id.tvItem }, options, this), this);
		mvPage2.setViews(mp2.getViews(getActivity(),
				R.layout.item_dynamic_cell, new String[] { "image", "text" },
				new int[] { R.id.ivImage, R.id.tvItem }, options, this), this);
		mvPage3.setViews(mp3.getViews(getActivity(),
				R.layout.item_dynamic_cell, new String[] { "image", "text" },
				new int[] { R.id.ivImage, R.id.tvItem }, options, this), this);

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_dynamic_metro;
	}

	@Override
	public String getMainActivityName() {
		return "";
	}

	@Override
	public void initMenu(Menu menu) {

	}

	@Override
	public void onGetNewArguments(Bundle bn) {

	}

	@Override
	public Bundle getFragmentState() {
		return null;
	}

	@Override
	public void onFocusChanged(boolean focused, int index) {
		if (focused) {
			countFocusPage(index);
			if (focusPage != slMain.getCurScreen()) {
				slMain.snapToScreen(focusPage);
			}
		}
	}

	private void countFocusPage(int index) {
		String sIdx = String.valueOf(index);
		focusPage = Integer.parseInt(sIdx.substring(0, 1)) - 1;
	}

	public String getData(Context context, int index) throws IOException {
		return FileUtils.readAssetFile(context, String.format("data%d", index));
	}

	@Override
	public void onItemClick(int id, String data) {
		Toast.makeText(getActivity(), String.valueOf(id), Toast.LENGTH_SHORT)
				.show();

	}
}
