package com.bytedance.sdk.openadsdk.activity;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public class TTBaseLandingPageActivity extends TTBaseActivity {
    private long qdl;
    private long ud;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.bytedance.sdk.openadsdk.utils.mzz.lnr()) {
            this.ud = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.ud > 0) {
            this.qdl += SystemClock.elapsedRealtime() - this.ud;
            this.ud = 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        long j = this.qdl;
        if (j > 0) {
            com.bytedance.sdk.openadsdk.utils.mzz.qdl(j);
        }
    }
}
