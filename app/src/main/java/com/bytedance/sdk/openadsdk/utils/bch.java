package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class bch {
    public static String qdl(Context context) {
        int iQdl = com.bytedance.sdk.component.utils.bqt.qdl(context, 0L);
        if (iQdl == 2) {
            return "2g";
        }
        if (iQdl == 3) {
            return "3g";
        }
        if (iQdl == 4) {
            return "wifi";
        }
        if (iQdl == 5) {
            return "4g";
        }
        if (iQdl == 6) {
            return "5g";
        }
        return "mobile";
    }
}
