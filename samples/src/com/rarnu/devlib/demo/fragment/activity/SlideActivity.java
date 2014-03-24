package com.rarnu.devlib.demo.fragment.activity;

import android.app.Fragment;
import com.anjuke.devlib.base.BaseSlidingActivity;
import com.anjuke.devlib.component.SlidingMenu;
import com.rarnu.devlib.demo.FragmentNameConsts;
import com.rarnu.devlib.demo.Fragments;
import com.rarnu.devlib.demo.R;

public class SlideActivity extends BaseSlidingActivity {

    @Override
    public int getIcon() {
        return R.drawable.ic_launcher;
    }

    @Override
    public Fragment replaceFragment() {
        return Fragments.getFragment(FragmentNameConsts.FN_SLIDE_CONTENT);
    }

    @Override
    public int customTheme() {
        return 0;
    }

    @Override
    public Fragment replaceMenuFragment() {
        return Fragments.getFragment(FragmentNameConsts.FN_SLIDE_MENU);
    }

    @Override
    public int getBehindOffset() {
        return 200;
    }

    @Override
    public int getAboveTouchMode() {
        return SlidingMenu.TOUCHMODE_FULLSCREEN;
    }

    @Override
    public int getBehindTouchMode() {
        return SlidingMenu.TOUCHMODE_MARGIN;
    }

    @Override
    public int getSlideMode() {
        // LEFT
        // RIGHT
        // LEFT_RIGHT
        return SlidingMenu.LEFT_RIGHT;
    }

    @Override
    public Fragment replaceSecondMenuFragment() {
        // if you choosed LEFT or RIGHT
        // keep this method returns null
        return Fragments.getFragment(FragmentNameConsts.FN_SLIDE_SECOND_MENU);
    }

    @Override
    public void loadFragments() {


    }

    @Override
    public void releaseFragments() {


    }

}
