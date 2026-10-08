package com.bytedance.sdk.openadsdk.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.facebook.appevents.AppEventsConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class TTFullScreenExpressVideoActivity extends TTFullScreenVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
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

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ljh();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public FrameLayout xmv() {
        if (this.lnr != null && (this.lnr instanceof com.bytedance.sdk.openadsdk.component.reward.ud.jpc) && !this.ud.jjk) {
            return ((com.bytedance.sdk.openadsdk.component.reward.ud.jpc) this.lnr).vu();
        }
        return this.ud.bqt.ud();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public Map<String, Object> koa() {
        return this.ud.mo();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    public void bqt() {
        if (ljh.mzz(this.ud.ud)) {
            finish();
            return;
        }
        if (this.ud.bqt == null || this.ud.bqt.qdl() == null) {
            return;
        }
        this.ud.bqt.qdl().setTime(AppEventsConstants.EVENT_PARAM_VALUE_NO, 0, 0, false);
        if (this.ud.bqt.tvp()) {
            this.ud.fco.qdl(AppEventsConstants.EVENT_PARAM_VALUE_NO, "X");
            this.ud.fco.mzz(true);
            this.ud.fco.lnr();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTFullScreenVideoActivity, com.bytedance.sdk.openadsdk.activity.TTBaseVideoActivity
    protected void qdl(long j, long j2) {
        int i = (int) (j / 1000);
        if (this.ud.bqt != null && this.ud.bqt.qdl() != null) {
            this.ud.bqt.qdl().setTime(String.valueOf(this.mo), i, 0, false);
            this.ud.bqt.qdl().qdl(j, j2);
        }
        if ((this.ud.bqt == null || !this.ud.bqt.tvp()) && !this.ud.ud.au()) {
            return;
        }
        lnr(i);
        if (this.mo >= 0) {
            this.ud.fco.mml(true);
            this.ud.fco.qdl(String.valueOf(this.mo), null);
        }
    }
}
