package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.mo;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends mo {
    private static volatile mzz qdl;

    @Override // com.bytedance.sdk.openadsdk.core.mo
    public /* bridge */ /* synthetic */ mo.lnr qdl() {
        return super.qdl();
    }

    public static mzz qdl(Context context) {
        if (qdl == null) {
            synchronized (mzz.class) {
                if (qdl == null) {
                    qdl = new mzz(context);
                }
            }
        }
        return qdl;
    }

    private mzz(Context context) {
        super(context);
    }
}
