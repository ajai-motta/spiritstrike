package com.bytedance.sdk.openadsdk.exc.qdl.qdl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.utils.gy;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    public static mo qdl(Context context, String str) {
        if (lnr.qdl()) {
            return new mzz(context, str);
        }
        if (gy.mml(context)) {
            return new mml(context, str);
        }
        return new qdl(context, str);
    }
}
