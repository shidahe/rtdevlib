package com.rarnu.devlib.demo.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.anjuke.devlib.base.BaseFragment;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.adapter.StringAdapter;
import com.rarnu.devlib.demo.loader.StringLoader;

public class AdapterFragment extends BaseFragment implements
		OnLoadCompleteListener<List<String>>, OnQueryTextListener {

	ListView lvAdapter;
	StringAdapter adapter;
	List<String> list = null;
	StringLoader loader;
	
	MenuItem itemSearch;

	@Override
	protected int getBarTitle() {
		return R.string.adapter_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.adapter_name_with_path;
	}

	@Override
	protected void initComponents() {
		lvAdapter = (ListView) innerView.findViewById(R.id.lvAdapter);
		list = new ArrayList<String>();
		adapter = new StringAdapter(getActivity(), list);
		lvAdapter.setAdapter(adapter);
		loader = new StringLoader(getActivity());
	}

	@Override
	protected void initEvents() {
		loader.registerListener(0, this);
	}

	@Override
	protected void initLogic() {
		loader.startLoading();
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_adapter;
	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected void initMenu(Menu menu) {
		itemSearch = menu.add(0, 3, 98,
				"Search");
		itemSearch.setIcon(android.R.drawable.ic_menu_search);
		itemSearch.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
		SearchView sv = new SearchView(getActivity());
		sv.setOnQueryTextListener(this);
		itemSearch.setActionView(sv);
	}

	@Override
	protected void onGetNewArguments(Bundle bn) {

	}

	@Override
	public void onLoadComplete(Loader<List<String>> loader, List<String> data) {
		list.clear();
		if (data != null) {
			list.addAll(data);
		}
		adapter.setNewList(list);
 	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		if (adapter != null) {
			adapter.filter(newText);
		}
		return true;
	}

}
