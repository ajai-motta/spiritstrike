package com.adxcorp.ads.mediation.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.ads.mediation.network.NetworkServiceManager;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ReportUtil {
    public static final String EVENT_TYPE_ATTEMPT = "attempt";
    public static final String EVENT_TYPE_CLICK = "click";
    public static final String EVENT_TYPE_CLOSE = "close";
    public static final String EVENT_TYPE_FILL = "fill";
    public static final String EVENT_TYPE_IMPRESSION = "impression";
    public static final String EVENT_TYPE_NO_FILL = "nofill";
    public static final String EVENT_TYPE_OUTBID = "outbid";
    public static final String EVENT_TYPE_PAID = "paid";
    public static final String EVENT_TYPE_REWARD = "reward";
    public static final String FULLSCREEN_CLOSE_TAG = "FULLSCREEN_CLOSE_TAG";
    public static final String INVENTORY_TYPE_BANNER = "banner";
    public static final String INVENTORY_TYPE_INTERSTITIAL = "interstitial";
    public static final String INVENTORY_TYPE_NATIVE = "native";
    public static final String INVENTORY_TYPE_RV = "rv";
    public static final String NATIVE_CLICK_TAG = "NATIVE_CLICK_TAG";
    public static final String NATIVE_IMPRESSION_TAG = "NATIVE_IMPRESSION_TAG";
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
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(TAG, ":::sendReport:::" + str + " - " + arrayList);
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    sendReport(str, arrayList.get(i));
                }
            } catch (Exception e) {
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.e(TAG, e);
                }
            }
        }
    }

    public static void sendReport(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.d(TAG, ":::sendReport:::" + str + " - " + str2);
            }
            NetworkServiceManager.getInstance().get(str2, new Handler(Looper.getMainLooper()) { // from class: com.adxcorp.ads.mediation.util.ReportUtil.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int i = message.what;
                    if (i != -1) {
                        if (i == 200 && MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(ReportUtil.TAG, "HTTP Connection : Success");
                            return;
                        }
                        return;
                    }
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        String str3 = ReportUtil.TAG;
                        StringBuilder sb = new StringBuilder("HTTP Connection : ERROR ");
                        sb.append(message.obj != null ? message.obj.toString() : "");
                        ADXLogUtil.d(str3, sb.toString());
                    }
                }
            });
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public static void sendMetric(MediationData mediationData, String str, String str2) {
        sendReport(str + "-" + str2, getMetricUrl(mediationData, str2));
    }

    public static void sendRewardMetric(MediationData mediationData, String str, String str2, String str3) {
        String metricUrl = getMetricUrl(mediationData, EVENT_TYPE_REWARD);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            if (str2 == null) {
                str2 = "";
            }
            if (str3 == null) {
                str3 = "";
            }
            sendReport(str + "-reward", setOrUpdateQueryParam(setOrUpdateQueryParam(metricUrl, "userId", str2), "customData", str3));
            return;
        }
        sendReport(str + "-reward", metricUrl);
    }

    public static void sendPaidMetric(MediationData mediationData, String str, double d) {
        try {
            sendReport(str + "-paid", setOrUpdateQueryParam(getMetricUrl(mediationData, EVENT_TYPE_PAID), "ecpm", String.valueOf(d)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getMetricUrl(MediationData mediationData, String str) {
        if (mediationData == null) {
            return null;
        }
        try {
            return mediationData.getMetricEndpointFormat().replaceFirst("\\{\\{mediationId\\}\\}", mediationData.getMediationId()).replaceFirst("\\{\\{requestId\\}\\}", mediationData.getRequestId()).replaceFirst("\\{\\{eventType\\}\\}", str).replaceFirst("\\{\\{ecpm\\}\\}", String.valueOf(mediationData.getEcpm()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String setOrUpdateQueryParam(String str, String str2, String str3) {
        String str4 = "(" + str2 + "=)([^&]*)";
        if (str.matches(".*[?&]" + str4 + ".*")) {
            return str.replaceFirst(str4, "$1" + str3);
        }
        if (str.contains("?")) {
            return str + "&" + str2 + "=" + str3;
        }
        return str + "?" + str2 + "=" + str3;
    }
}
