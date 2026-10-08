package com.gomfactory.adpie.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.network.NetworkServiceManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ReportUtil {
    public static final String NATIVE_CLICK_TAG = "NATIVE_CLICK_TAG";
    public static final String NATIVE_IMPRESSION_TAG = "NATIVE_IMPRESSION_TAG";
    public static final String SSV_CALLBACK_TAG = "SSV_CALLBACK";
    public static final String TAG = "ReportUtil";
    public static final String VIDEO_CLICK_TAG = "VIDEO_CLICK";
    public static final String VIDEO_COMPLETE_TAG = "VIDEO_COMPLETE";
    public static final String VIDEO_ENDCARD_CLICK_TAG = "VIDEO_ENDCARD_CLICK";
    public static final String VIDEO_ENDCARD_IMPRESSION_TAG = "VIDEO_ENDCARD_IMPRESSION";
    public static final String VIDEO_FIRST_QUARTILE_TAG = "VIDEO_FIRST_QUARTILE";
    public static final String VIDEO_IMPRESSION_TAG = "VIDEO_IMPRESSION";
    public static final String VIDEO_MID_POINT_TAG = "VIDEO_MID_POINT";
    public static final String VIDEO_START_TAG = "VIDEO_START";
    public static final String VIDEO_THIRD_QUARTILE_TAG = "VIDEO_THIRD_QUARTILE";
    public static final String WEBVIEW_CLICK_TAG = "WEBVIEW_CLICK_TAG";
    public static final String WEBVIEW_IMPRESSION_TAG = "WEBVIEW_IMPRESSION_TAG";

    public static void sendReport(String str, ArrayList<String> arrayList) {
        if (arrayList != null) {
            try {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.d(TAG, ":::sendReport:::" + str + " - " + arrayList);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    sendReport(str, arrayList.get(i));
                }
            } catch (Exception e) {
                if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                    AdPieLog.e(TAG, e);
                }
            }
        }
    }

    public static void sendReport(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.d(TAG, ":::sendReport:::" + str + " - " + str2);
            }
            NetworkServiceManager.getInstance().get(str2, new Handler(Looper.getMainLooper()) { // from class: com.gomfactory.adpie.sdk.util.ReportUtil.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != -1) {
                        if (i == 200 && AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(ReportUtil.TAG, "HTTP Connection : Success");
                            return;
                        }
                        return;
                    }
                    if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                        String str3 = ReportUtil.TAG;
                        StringBuilder sb = new StringBuilder("HTTP Connection : ERROR ");
                        sb.append(message.obj != null ? message.obj.toString() : "");
                        AdPieLog.d(str3, sb.toString());
                    }
                }
            });
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }
}
