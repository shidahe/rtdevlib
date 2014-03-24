package com.anjuke.devlib.common;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import com.anjuke.devlib.R;

public class FragmentStarter {

    public static void showContent(Activity activity, Class<?> clz, Fragment fContent) {
        if (GlobalInstance.dualPane) {
            activity.getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentDetail, fContent)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        } else {
            activity.startActivity(new Intent(activity, clz));
        }
    }
}
