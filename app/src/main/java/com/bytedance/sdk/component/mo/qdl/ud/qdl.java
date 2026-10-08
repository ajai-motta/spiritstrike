package com.bytedance.sdk.component.mo.qdl.ud;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.sdk.component.mo.qdl.jpc;
import com.bytedance.sdk.component.mo.qdl.qdl.mzz;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public static long qdl(int i, Context context) {
        return ud(i, context);
    }

    private static long ud(int i, Context context) {
        if (context == null) {
            return i;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        long jMaxMemory = (runtime.maxMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - (runtime.totalMemory() / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            if (jFreeMemory <= 10) {
                return Math.min(i, 10);
            }
            return Math.min((jFreeMemory / 2) * 10, i);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        if (j <= 10) {
            return Math.min(i, 10);
        }
        return Math.min(j * 10, i);
    }

    public static boolean qdl() {
        mzz mzzVarMml = jpc.wd().mml();
        return (mzzVarMml == null || TextUtils.isEmpty(mzzVarMml.qdl())) ? false : true;
    }

    public static boolean ud() {
        mzz mzzVarMml = jpc.wd().mml();
        return (mzzVarMml == null || TextUtils.isEmpty(mzzVarMml.ud())) ? false : true;
    }

    public static boolean lnr() {
        mzz mzzVarMml = jpc.wd().mml();
        return (mzzVarMml == null || TextUtils.isEmpty(mzzVarMml.mml())) ? false : true;
    }

    public static boolean mml() {
        mzz mzzVarMml = jpc.wd().mml();
        return (mzzVarMml == null || TextUtils.isEmpty(mzzVarMml.mzz())) ? false : true;
    }

    public static boolean mzz() {
        mzz mzzVarMml = jpc.wd().mml();
        return (mzzVarMml == null || TextUtils.isEmpty(mzzVarMml.lnr())) ? false : true;
    }

    public static boolean mo() {
        mzz mzzVarMml = jpc.wd().mml();
        return (mzzVarMml == null || TextUtils.isEmpty(mzzVarMml.mo())) ? false : true;
    }
}
