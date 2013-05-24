package com.rarnu.devlib.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.Menu;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.component.FlipView;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.adapter.FlipViewAdapter;

public class FlipViewFragment extends BaseFragment {

	private String urls[] = {
			"http://farm7.staticflickr.com/6101/6853156632_6374976d38_c.jpg",
			"http://farm8.staticflickr.com/7232/6913504132_a0fce67a0e_c.jpg",
			"http://farm5.staticflickr.com/4133/5096108108_df62764fcc_b.jpg",
			"http://farm5.staticflickr.com/4074/4789681330_2e30dfcacb_b.jpg",
			"http://farm9.staticflickr.com/8208/8219397252_a04e2184b2.jpg",
			"http://farm9.staticflickr.com/8483/8218023445_02037c8fda.jpg",
			"http://farm9.staticflickr.com/8335/8144074340_38a4c622ab.jpg",
			"http://farm9.staticflickr.com/8060/8173387478_a117990661.jpg",
			"http://farm9.staticflickr.com/8056/8144042175_28c3564cd3.jpg",
			"http://farm9.staticflickr.com/8183/8088373701_c9281fc202.jpg",
			"http://farm9.staticflickr.com/8185/8081514424_270630b7a5.jpg",
			"http://farm9.staticflickr.com/8462/8005636463_0cb4ea6be2.jpg",
			"http://farm9.staticflickr.com/8306/7987149886_6535bf7055.jpg",
			"http://farm9.staticflickr.com/8444/7947923460_18ffdce3a5.jpg",
			"http://farm9.staticflickr.com/8182/7941954368_3c88ba4a28.jpg",
			"http://farm9.staticflickr.com/8304/7832284992_244762c43d.jpg",
			"http://farm9.staticflickr.com/8163/7709112696_3c7149a90a.jpg",
			"http://farm8.staticflickr.com/7127/7675112872_e92b1dbe35.jpg",
			"http://farm8.staticflickr.com/7111/7429651528_a23ebb0b8c.jpg",
			"http://farm9.staticflickr.com/8288/7525381378_aa2917fa0e.jpg",
			"http://farm6.staticflickr.com/5336/7384863678_5ef87814fe.jpg",
			"http://farm8.staticflickr.com/7102/7179457127_36e1cbaab7.jpg",
			"http://farm8.staticflickr.com/7086/7238812536_1334d78c05.jpg",
			"http://farm8.staticflickr.com/7243/7193236466_33a37765a4.jpg",
			"http://farm8.staticflickr.com/7251/7059629417_e0e96a4c46.jpg",
			"http://farm8.staticflickr.com/7084/6885444694_6272874cfc.jpg" };
	
	FlipView fvFlip;
	List<String> list;
	FlipViewAdapter adapter;

	@Override
	public int getBarTitle() {
		return R.string.flipview_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.flipview_name_with_path;
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public void initComponents() {
		list = new ArrayList<String>();
		for (String u: urls) {
			list.add(u);
		}
		adapter = new FlipViewAdapter(getActivity(), list);		
		fvFlip = (FlipView) innerView.findViewById(R.id.fvFlip);
		fvFlip.setFlipByTouchEnabled(true);
		fvFlip.setAdapter(adapter);
	}

	@Override
	public void initEvents() {

	}

	@Override
	public void initLogic() {

	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_flipview;
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
	public Bundle getFragmentState() {
		return null;
	}

}
