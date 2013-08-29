package com.rarnu.devlib.demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.classes.JsonNode;
import com.anjuke.devlib.classes.JsonNode.FieldType;
import com.anjuke.devlib.utils.FileUtils;
import com.anjuke.devlib.utils.JsonUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;
import com.rarnu.devlib.demo.test.TestClass;

public class JsonFragment extends BaseFragment {

	TextView tvObj2Json, tvJson2Obj;
	JsonNode root;
	TestClass tc;
	JsonUtils<TestClass> ju;

	@Override
	public int getBarTitle() {
		return R.string.json_name;
	}

	@Override
	public int getBarTitleWithPath() {
		return R.string.json_name_with_path;
	}

	@Override
	public String getCustomTitle() {
		return null;
	}

	@Override
	public void initComponents() {
		tvObj2Json = (TextView) innerView.findViewById(R.id.tvObj2Json);
		tvJson2Obj = (TextView) innerView.findViewById(R.id.tvJson2Obj);
		tc = new TestClass();
		initNodeTree();
	}

	@Override
	public void initEvents() {

	}

	@Override
	public void initLogic() {

		try {
			// object 2 json
			String jstr = ju.toJson(tc);
			tvObj2Json.setText(jstr);
		} catch (Exception e) {
			Log.e("JsonFragment", e.getMessage());
		}

		try {
			// json 2 object
			String jsonString = FileUtils.readAssetFile(getActivity(), "json");
			TestClass t = ju.toObject(jsonString);
			tvJson2Obj.setText(t.toString());
		} catch (Exception e) {
			Log.e("JsonFragment", e.toString());
		}
	}

	/**
	 * the tree structure is:<br>
	 * |root<br>
	 * |----fa(V)<br>
	 * |----fb(V)<br>
	 * |----inner(O)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----innerFA(V)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----innerFB(V)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----array(L)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&
	 * nbsp;&nbsp;|====TestArray(O)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&
	 * nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----arr(V)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----arrStr(L)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&
	 * nbsp;&nbsp;|====String(V)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|----map(M)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&
	 * nbsp;&nbsp;|====String(V)<br>
	 * |----test(M)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|====TestMap(O)<br>
	 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&
	 * nbsp;&nbsp;|----map(V)<br>
	 */
	private void initNodeTree() {
		root = new JsonNode("", FieldType.ftObject);
		root.childs.add(new JsonNode("fa", FieldType.ftValue)); // fa
		root.childs.add(new JsonNode("fb", FieldType.ftValue)); // fb

		JsonNode inner = new JsonNode("inner", FieldType.ftObject); // inner
		inner.childs.add(new JsonNode("innerFA", FieldType.ftValue)); // inner.innerFA
		inner.childs.add(new JsonNode("innerFB", FieldType.ftValue)); // inner.innerFB

		JsonNode innerArray = new JsonNode("array", FieldType.ftList); // inner.array
		innerArray.subItemNode = new JsonNode("TestArray", FieldType.ftObject); // inner.array<TestArray>
		innerArray.subItemNode.childs
				.add(new JsonNode("arr", FieldType.ftValue)); // TestArray.arr
		inner.childs.add(innerArray);

		inner.childs.add(new JsonNode("arrStr", FieldType.ftList, new JsonNode(
				"arrStr", FieldType.ftValue))); // inner.arrStr

		JsonNode innerMap = new JsonNode("map", FieldType.ftMap); // inner.map
		innerMap.subItemNode = new JsonNode("String", FieldType.ftValue); // inner.map<String>
		inner.childs.add(innerMap);

		root.childs.add(inner);

		JsonNode test = new JsonNode("test", FieldType.ftMap); // test
		test.subItemNode = new JsonNode("TestMap", FieldType.ftObject); // test<TestMap>
		test.subItemNode.childs.add(new JsonNode("map", FieldType.ftValue)); // TestMap.map

		root.childs.add(test);

		ju = new JsonUtils<TestClass>(TestClass.class, root);
	}

	@Override
	public int getFragmentLayoutResId() {
		return R.layout.fragment_json;
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
