package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    private static volatile Handler qdl;

    public static Handler qdl() {
        return com.bytedance.sdk.component.jpc.qdl.qdl.qdl().ud();
    }

    public static Handler ud() {
        if (qdl == null) {
            synchronized (tvp.class) {
                if (qdl == null) {
                    qdl = new Handler(Looper.getMainLooper());
                }
            }
        }
        return qdl;
    }
}
