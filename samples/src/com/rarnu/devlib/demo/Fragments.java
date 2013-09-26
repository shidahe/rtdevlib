package com.rarnu.devlib.demo;

import android.app.Fragment;
import com.rarnu.devlib.demo.fragment.*;

public class Fragments {

    private static IndexFragment fIndex = null;
    private static ArgumentFragment fDetail = null;
    private static AdapterFragment fAdapter = null;
    private static DialogFragment fDialog = null;
    private static PopupFragment fPopup = null;
    private static HScrollFragment fHScroll = null;
    private static VScrollFragment fVScroll = null;
    private static PullDownListViewFragment fPullDownListView = null;
    private static PullDownLayoutFragment fPullDownLayout = null;
    private static DeviceFragment fDevice = null;
    private static DownloadFragment fDownload = null;
    private static FileFragment fFile = null;
    private static HttpRequestFragment fHttpRequest = null;
    private static ImageFragment fImage = null;
    private static NetworkFragment fNetwork = null;
    private static NotificationFragment fNotification = null;
    private static UIFragment fUI = null;
    private static RunFragment fRun = null;
    private static SlideMenuFragment fSlideMenu = null;
    private static SlideContentFragment fSlideContent = null;
    private static SlideSecondMenuFragment fSlideSecondMenu = null;
    private static FloatWindowFragment fFloatWindow = null;
    private static TabFragment fTab = null;
    private static DragListViewFragment fDragListView = null;
    private static WaterfallFragment fWaterfall = null;
    private static FlipViewFragment fFlipView = null;
    private static DynamicMetroFragment fDynamicMetro = null;
    private static JsonFragment fJson = null;

    public static Fragment getFragment(String name) {
        releaseOtherFragments(name);
        Fragment f = null;
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_INDEX, IndexFragment.class, fIndex);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_DETAIL, ArgumentFragment.class, fDetail);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_ADAPTER, AdapterFragment.class, fAdapter);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_DIALOG, DialogFragment.class, fDialog);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_POPUP, PopupFragment.class, fPopup);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_HSCROLL, HScrollFragment.class, fHScroll);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_VSCROLL, VScrollFragment.class, fVScroll);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_PULLDOWN_LISTVIEW, PullDownListViewFragment.class, fPullDownListView);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_PULLDOWN_LAYOUT, PullDownLayoutFragment.class, fPullDownLayout);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_DEVICE, DeviceFragment.class, fDevice);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_DOWNLOAD, DownloadFragment.class, fDownload);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_FILE, FileFragment.class, fFile);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_HTTP_REQUEST, HttpRequestFragment.class, fHttpRequest);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_IMAGE, ImageFragment.class, fImage);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_NETWORK, NetworkFragment.class, fNetwork);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_NOTIFICATION, NotificationFragment.class, fNotification);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_UI, UIFragment.class, fUI);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_RUN, RunFragment.class, fRun);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_SLIDE_MENU, SlideMenuFragment.class, fSlideMenu);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_SLIDE_CONTENT, SlideContentFragment.class, fSlideContent);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_SLIDE_SECOND_MENU, SlideSecondMenuFragment.class, fSlideSecondMenu);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_FLOAT_WINDOW, FloatWindowFragment.class, fFloatWindow);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_TAB, TabFragment.class, fTab);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_DRAG_LISTVIEW, DragListViewFragment.class, fDragListView);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_WATERFALL, WaterfallFragment.class, fWaterfall);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_FLIPVIEW, FlipViewFragment.class, fFlipView);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_DYNAMIC_METRO, DynamicMetroFragment.class, fDynamicMetro);
        }
        if (f == null) {
            f = getFragment(name, FragmentNameConsts.FN_JSON, JsonFragment.class, fJson);
        }

        return f;
    }

    private static Fragment getFragment(String name, String checkName, Class<?> fClass, Fragment f) {
        if (name.equals(checkName)) {
            if (f == null) {
                try {
                    f = (Fragment) fClass.newInstance();
                } catch (Exception e) {

                }
            }
        }
        return f;
    }

    public static void releaseFragments() {
        fIndex = null;
        fDetail = null;
        fAdapter = null;
        fDialog = null;
        fPopup = null;
        fHScroll = null;
        fVScroll = null;
        fPullDownListView = null;
        fPullDownLayout = null;
        fDevice = null;
        fDownload = null;
        fFile = null;
        fHttpRequest = null;
        fImage = null;
        fNetwork = null;
        fNotification = null;
        fUI = null;
        fRun = null;
        fSlideMenu = null;
        fSlideContent = null;
        fSlideSecondMenu = null;
        fFloatWindow = null;
        fTab = null;
        fDragListView = null;
        fWaterfall = null;
        fFlipView = null;
        fDynamicMetro = null;
        fJson = null;
    }

    private static void releaseOtherFragments(String name) {
        doReleaseFragment(name, FragmentNameConsts.FN_DETAIL, fDetail);
        // TODO: release other fragments
    }

    private static void doReleaseFragment(String name, String checkName, Fragment f) {
        if (!name.equals(checkName)) {
            f = null;
        }
    }
}
