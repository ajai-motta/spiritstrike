package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends fs {
    public lnr(Context context) {
        super(context);
        this.ud = false;
    }

    @Override // com.bytedance.sdk.openadsdk.common.fs
    public void qdl() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.lnr.1
            @Override // java.lang.Runnable
            public void run() {
                if (lnr.this.qdl != null) {
                    lnr.this.setVisibility(0);
                }
            }
        });
    }

    public void qdl(ljh ljhVar, String str, int i, String str2, long j, boolean z, int i2, long j2) {
        if (getVisibility() != 8) {
            com.bytedance.sdk.openadsdk.mml.lnr.qdl(ljhVar, str, i, str2, SystemClock.elapsedRealtime() - j, z, i2, j2);
            super.ud();
        }
    }
}
