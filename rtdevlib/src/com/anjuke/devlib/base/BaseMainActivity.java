package com.anjuke.devlib.base;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.anjuke.devlib.R;
import com.anjuke.devlib.common.GlobalInstance;
import com.anjuke.devlib.common.IFragments;
import com.anjuke.devlib.utils.DrawableUtils;
import com.anjuke.devlib.utils.UIUtils;

public abstract class BaseMainActivity extends Activity implements IFragments {

    protected static boolean oneTimeRun = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        registerReceiver(receiverHome, filterHome);

        loadFragments();

        if (!oneTimeRun) {
            oneTimeRun = true;
            initOneTime();
        }
        loadUI();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!GlobalInstance.dualPane) {
            getActionBar()
                    .setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        }
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiverHome);
        releaseFragments();
        oneTimeRun = false;
        super.onDestroy();
    }

    private void initOneTime() {
        initOnce();
    }

    public abstract void initOnce();

    public abstract String getBarTitle();

    private void loadUI() {
        setContentView(R.layout.layout_main);

        replaceIndexFragment();
        View vDetail = findViewById(R.id.fragmentDetail);
        GlobalInstance.dualPane = vDetail != null
                && vDetail.getVisibility() == View.VISIBLE;

        Drawable dSysBackground = DrawableUtils.getSystemAttrDrawable(this,
                DrawableUtils.DETAILS_ELEMENT_BACKGROUND);
        Drawable dBackground = (UIUtils.isFollowSystemBackground() ? dSysBackground
                : null);
        if (GlobalInstance.dualPane) {
            ((FrameLayout) findViewById(R.id.fragmentMain))
                    .setBackgroundDrawable(dBackground);
            ((FrameLayout) findViewById(R.id.fragmentDetail))
                    .setBackgroundDrawable(dBackground);
        } else {
            ((LinearLayout) findViewById(R.id.layoutMain))
                    .setBackgroundDrawable(dBackground);
        }

        getActionBar().setTitle(getBarTitle());
        setDualPane();
    }

    public abstract Fragment getFragment(int currentFragment);

    private void setDualPane() {
        if (GlobalInstance.dualPane) {
            replaceDetailFragment(getFragment(GlobalInstance.currentFragment));
        }
    }

    public abstract Fragment getIndexFragment();

    private void replaceIndexFragment() {
        Fragment fIndex = getIndexFragment();
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentMain, fIndex).commit();
    }

    private void replaceDetailFragment(Fragment f) {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentDetail, f)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        initMenu(menu);
        return true;
    }

    public abstract void initMenu(Menu menu);

    public abstract void onHomeClick();

    public abstract void onRecentAppClick();

    public class HomeReceiver extends BroadcastReceiver {

        static final String SYSTEM_REASON = "reason";
        static final String SYSTEM_HOME_KEY = "homekey";
        static final String SYSTEM_RECENT_APPS = "recentapps";

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
                String reason = intent.getStringExtra(SYSTEM_REASON);
                if (reason != null) {
                    if (reason.equals(SYSTEM_HOME_KEY)) {
                        onHomeClick();
                        oneTimeRun = false;
                    } else if (reason.equals(SYSTEM_RECENT_APPS)) {
                        onRecentAppClick();
                    }
                }
            }
        }
    }

    public HomeReceiver receiverHome = new HomeReceiver();
    public IntentFilter filterHome = new IntentFilter(
            Intent.ACTION_CLOSE_SYSTEM_DIALOGS);

}
