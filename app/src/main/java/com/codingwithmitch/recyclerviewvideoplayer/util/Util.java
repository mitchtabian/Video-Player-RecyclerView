package com.codingwithmitch.recyclerviewvideoplayer.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class Util {

    public static int getScreenHeight(WindowManager windowManager, Resources resources){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);

        // subtract the status bar height
        return (displayMetrics.heightPixels - getStatusBarHeight(resources));
    }

    public static int getStatusBarHeight(Resources resources) {
        int result = 0;
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
