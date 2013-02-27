package com.rarnu.devlib.demo.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.anjuke.devlib.base.BaseFragment;
import com.anjuke.devlib.utils.ImageUtils;
import com.rarnu.devlib.demo.MainActivity;
import com.rarnu.devlib.demo.R;

public class ImageFragment extends BaseFragment implements OnClickListener {

	ImageView ivOrigin;
	ImageView ivChanged;
	Button btnRotate, btnFlip, btnRound, btnBlackWhite, btnBlur;

	Bitmap bmpOrigin, bmpChanged;

	@Override
	protected int getBarTitle() {
		return R.string.image_name;
	}

	@Override
	protected int getBarTitleWithPath() {
		return R.string.image_name_with_path;
	}

	@Override
	protected void initComponents() {
		ivOrigin = (ImageView) innerView.findViewById(R.id.ivOrigin);
		ivChanged = (ImageView) innerView.findViewById(R.id.ivChanged);
		btnRotate = (Button) innerView.findViewById(R.id.btnRotate);
		btnFlip = (Button) innerView.findViewById(R.id.btnFlip);
		btnRound = (Button) innerView.findViewById(R.id.btnRound);
		btnBlackWhite = (Button) innerView.findViewById(R.id.btnBlackWhite);
		btnBlur = (Button) innerView.findViewById(R.id.btnBlur);

	}

	@Override
	protected void initEvents() {
		btnRotate.setOnClickListener(this);
		btnFlip.setOnClickListener(this);
		btnRound.setOnClickListener(this);
		btnBlackWhite.setOnClickListener(this);
		btnBlur.setOnClickListener(this);

	}

	@Override
	protected void initLogic() {
		bmpOrigin = ImageUtils.getBitmapByAssets(getActivity(), "test.jpg");
		ivOrigin.setImageBitmap(bmpOrigin);
		ivChanged.setImageBitmap(bmpOrigin);
	}

	@Override
	protected int getFragmentLayoutResId() {
		return R.layout.fragment_image;
	}

	@Override
	protected String getMainActivityName() {
		return MainActivity.class.getName();
	}

	@Override
	protected void initMenu(Menu menu) {

	}

	@Override
	protected void onGetNewArguments(Bundle bn) {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnRotate:
			bmpChanged = ImageUtils.rotateBmp(bmpOrigin, 90);
			ivChanged.setImageBitmap(bmpChanged);
			break;
		case R.id.btnFlip:
			bmpChanged = ImageUtils.flipBmp(bmpOrigin, 0);
			ivChanged.setImageBitmap(bmpChanged);
			break;
		case R.id.btnRound:
			bmpChanged = ImageUtils.roundedCornerBitmap(bmpOrigin, 24);
			ivChanged.setImageBitmap(bmpChanged);
			break;
		case R.id.btnBlackWhite:
			bmpChanged = ImageUtils.blackWhiteBmp(bmpOrigin);
			ivChanged.setImageBitmap(bmpChanged);
			break;
		case R.id.btnBlur:
			bmpChanged = ImageUtils.blurBmp(bmpOrigin, 4);
			ivChanged.setImageBitmap(bmpChanged);
			break;
		}

	}

}
