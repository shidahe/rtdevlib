package com.rarnu.devlib.demo.fragment.activity;

import android.app.Fragment;
import android.os.Bundle;
import com.anjuke.devlib.base.BaseDialog;
import com.rarnu.devlib.demo.FragmentNameConsts;
import com.rarnu.devlib.demo.Fragments;

public class DialogActivity extends BaseDialog {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean getCondition() {
        return false;
    }

    @Override
    public Fragment replaceFragment() {
        return Fragments.getFragment(FragmentNameConsts.FN_DIALOG);
    }

}
