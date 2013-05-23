package com.rarnu.devlib.demo.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.component.DragListView;
import com.anjuke.devlib.component.intf.DropListener;
import com.anjuke.devlib.component.intf.RemoveListener;
import com.anjuke.devlib.component.tools.DragController;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class DragListViewFragment extends BaseFragment implements DropListener,
		RemoveListener {

	private DragListView mListview;
	private DragController mController;

	private ArrayAdapter<String> adapter;
	private ArrayList<String> list;

	@Override
	public int getBarTitle() {
		return R.string.drag_listview_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.drag_listview_name_with_path;
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public void initComponents() {

		mListview = (DragListView) innerView.findViewById(R.id.lvDrag);
		mController = new DragController(mListview);
		mController.setDragHandleId(R.id.handlerDrag);
		mController.setRemoveEnabled(true);
		mController.setSortEnabled(true);
		mController.setDragInitMode(DragController.ON_DRAG);
		mController.setRemoveMode(DragController.FLING_REMOVE);
		mListview.setFloatViewManager(mController);
		mListview.setDragEnabled(true);
		mListview.setFloatAlpha(0.5F);

	}

	@Override
	public void initEvents() {
		mListview.setOnTouchListener(mController);
		mListview.setDropListener(this);
		mListview.setRemoveListener(this);
	}

	@Override
	public void initLogic() {
		list = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			list.add(String.format("Item %d", i + 1));
		}
		adapter = new ArrayAdapter<String>(getActivity(),
				R.layout.item_adapter_handle, R.id.tvDragText, list);
		mListview.setAdapter(adapter);
	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_drag_listview;
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

	@Override
	public void drop(int from, int to) {
		if (from != to) {
			String item = adapter.getItem(from);
			adapter.remove(item);
			adapter.insert(item, to);
		}

	}

	@Override
	public void remove(int which) {
		adapter.remove(adapter.getItem(which));
	}

}
