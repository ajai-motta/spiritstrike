package com.bytedance.sdk.openadsdk.bch.ud;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.hzv;

/* JADX INFO: loaded from: classes3.dex */
public class mo {
    public static boolean qdl(View view, int i) {
        return qdl(view, false, i);
    }

    public static boolean qdl(View view, boolean z, int i) {
        if (view == null) {
            return false;
        }
        return hzv.qdl(view, z ? 30 : 50, i, false);
    }
}
