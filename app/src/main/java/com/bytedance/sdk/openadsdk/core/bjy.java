package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.ApmHelper;

/* JADX INFO: loaded from: classes3.dex */
public class bjy {
    private final com.bytedance.sdk.openadsdk.utils.qdl qdl = new com.bytedance.sdk.openadsdk.utils.qdl();
    private boolean ud;

    public static bjy qdl() {
        return qdl.qdl;
    }

    private static class qdl {
        private static final bjy qdl = new bjy();
    }

    public void ud() {
        try {
            Context contextQdl = yt.qdl();
            if (contextQdl instanceof Application) {
                ((Application) contextQdl).registerActivityLifecycleCallbacks(this.qdl);
                this.ud = true;
            } else {
                if (contextQdl == null || contextQdl.getApplicationContext() == null) {
                    return;
                }
                ((Application) contextQdl.getApplicationContext()).registerActivityLifecycleCallbacks(this.qdl);
                this.ud = true;
            }
        } catch (Throwable th) {
            ApmHelper.reportCustomError("registerActivityLifecycleError", "registerActivityLifecycle", th);
        }
    }

    public boolean lnr() {
        return this.ud;
    }

    public boolean mml() {
        return this.qdl.qdl();
    }

    public boolean qdl(boolean z) {
        return this.qdl.qdl(z);
    }

    public com.bytedance.sdk.openadsdk.utils.qdl mzz() {
        return this.qdl;
    }
}
