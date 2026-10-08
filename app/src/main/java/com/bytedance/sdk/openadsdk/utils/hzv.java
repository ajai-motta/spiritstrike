package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class hzv {
    private static String qdl;

    public static boolean lnr() {
        return false;
    }

    public static boolean qdl() {
        return com.bytedance.sdk.component.utils.bjy.mml() && com.bytedance.sdk.openadsdk.core.tvp.ud().yt() && com.bytedance.sdk.openadsdk.core.tvp.ud().exc();
    }

    public static String qdl(String str) {
        try {
            if (!qdl()) {
                return str;
            }
            String strAaj = com.bytedance.sdk.openadsdk.core.tvp.ud().aaj();
            if (TextUtils.isEmpty(strAaj)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=".concat(String.valueOf(strAaj)));
            return Uri.parse(str).buildUpon().appendQueryParameter(ud(), strAaj).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String ud() {
        if (TextUtils.isEmpty(qdl)) {
            qdl = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return qdl;
    }
}
