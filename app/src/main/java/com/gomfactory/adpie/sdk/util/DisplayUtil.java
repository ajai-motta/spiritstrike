package com.gomfactory.adpie.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class DisplayUtil {
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int dpToPx(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int pxToDp(Context context, int i) {
        float f = context.getResources().getDisplayMetrics().density;
        Float.valueOf(f).getClass();
        return (int) (i / f);
    }

    public static int getDeviceWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getDeviceHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static boolean isLargeScreen(Context context) {
        return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }

    public static boolean isTarget36AndLargeScreen(Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 36) {
            return false;
        }
        return isLargeScreen(context);
    }

    public static int getCurrentWidth(Activity activity) {
        return activity.getWindowManager().getCurrentWindowMetrics().getBounds().width();
    }

    public static int getCurrentHeight(Activity activity) {
        return activity.getWindowManager().getCurrentWindowMetrics().getBounds().height();
    }
}
