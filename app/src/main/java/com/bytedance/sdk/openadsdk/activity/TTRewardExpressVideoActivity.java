package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TTRewardExpressVideoActivity extends TTRewardVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean jyq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public boolean oth() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void wd() {
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ljh();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public FrameLayout xmv() {
        return this.ud.bqt.ud();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public Map<String, Object> koa() {
        return this.ud.mo();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void qdl(long j, long j2) {
        int iQg = this.ud.ud.qg();
        boolean z = this.ud.bqt.tvp() && iQg >= 0;
        int i = (int) (j / 1000);
        lnr(j, j2);
        if (this.ud.bqt != null && this.ud.bqt.qdl() != null) {
            this.ud.bqt.qdl().setTime(String.valueOf(this.mo), i, 0, false);
            this.ud.bqt.qdl().qdl(j, j2);
        }
        if (this.mo > 0) {
            if (!z) {
                this.ud.fco.qdl(String.valueOf(this.mo), null);
                return;
            }
            if (i < iQg) {
                this.ud.fco.qdl(String.valueOf(this.mo), null);
                return;
            }
            if (this.ud.ud.taz() == 5 || this.ud.ud.taz() == 33) {
                this.ud.fco.qdl(String.valueOf(this.mo), null);
                return;
            }
            this.ud.qdl(true);
            this.ud.fco.qdl(String.valueOf(this.mo), TTAdDislikeToast.getSkipText());
            this.ud.fco.mzz(true);
        }
    }
}
