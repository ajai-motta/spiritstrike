package com.tnkfactory.ad;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AdListener {
    public static int CLOSE_AUTO = 1;
    public static int CLOSE_EXIT = 2;
    public static int CLOSE_SIMPLE = 0;
    public static int VIDEO_VERIFY_FAILED_ERROR = -9;
    public static int VIDEO_VERIFY_FAILED_NO_DATA = -3;
    public static int VIDEO_VERIFY_FAILED_S2S = -1;
    public static int VIDEO_VERIFY_FAILED_TEST_VIDEO = -4;
    public static int VIDEO_VERIFY_FAILED_TIMEOUT = -2;
    public static int VIDEO_VERIFY_SUCCESS_S2S = 1;
    public static int VIDEO_VERIFY_SUCCESS_SELF;

    public String logTag() {
        return Logger.TNKAD_LOG;
    }

    public void onClick(AdItem adItem) {
        Log.d(logTag(), adItem.getPlacementId() + " onClick");
    }

    public void onClose(AdItem adItem, int i) {
        Log.d(logTag(), adItem.getPlacementId() + " onClose : " + i);
    }

    public void onError(AdItem adItem, AdError adError) {
        Log.d(logTag(), adItem.getPlacementId() + " onError : " + adError.getMessage());
    }

    public void onLoad(AdItem adItem) {
        Log.d(logTag(), adItem.getPlacementId() + " onLoad");
    }

    public void onShow(AdItem adItem) {
        Log.d(logTag(), adItem.getPlacementId() + " onShow");
    }

    public void onVideoCompletion(AdItem adItem, int i) {
        Log.d(logTag(), adItem.getPlacementId() + " onVideoCompletion : " + i);
    }
}
