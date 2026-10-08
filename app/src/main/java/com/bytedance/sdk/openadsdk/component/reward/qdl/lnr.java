package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.R;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.common.bjy;
import com.bytedance.sdk.openadsdk.core.model.aaj;
import com.bytedance.sdk.openadsdk.core.model.vu;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private TTAdDislikeToast lnr;
    private final qdl qdl;
    private com.bytedance.sdk.openadsdk.common.bjy ud;

    public lnr(qdl qdlVar) {
        this.qdl = qdlVar;
    }

    public void qdl(com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        if (this.qdl.ag.isFinishing()) {
            return;
        }
        if (this.qdl.fs.get() || (this.qdl.lq != null && this.qdl.lq.cx().uw())) {
            if (this.lnr == null) {
                this.lnr = new TTAdDislikeToast(this.qdl.ag);
                ((FrameLayout) this.qdl.ag.findViewById(R.id.content)).addView(this.lnr);
            }
            this.lnr.show(TTAdDislikeToast.getDislikeTip());
            this.qdl.fs.set(true);
            return;
        }
        if (this.ud == null) {
            try {
                ud(udVar);
            } catch (Throwable th) {
                ApmHelper.reportCustomError("initDislike error", "RewardFullDislikeManager", th);
            }
        }
        com.bytedance.sdk.openadsdk.common.bjy bjyVar = this.ud;
        if (bjyVar != null) {
            bjyVar.qdl();
        }
    }

    public void qdl() {
        TTAdDislikeToast tTAdDislikeToast = this.lnr;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.hide();
        }
    }

    public void ud() {
        TTAdDislikeToast tTAdDislikeToast = this.lnr;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.onDestroy();
        }
    }

    private void ud(final com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        if (this.ud == null) {
            com.bytedance.sdk.openadsdk.common.bjy bjyVar = new com.bytedance.sdk.openadsdk.common.bjy(this.qdl.ag, this.qdl.ud);
            this.ud = bjyVar;
            bjyVar.setCallback(new bjy.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.lnr.1
                @Override // com.bytedance.sdk.openadsdk.common.bjy.qdl
                public void qdl(View view) {
                    lnr.this.qdl.rq.set(true);
                    String str = "landing_page";
                    if (!aaj.ud(lnr.this.qdl.ud) && !aaj.mml(lnr.this.qdl.ud) && !aaj.mo(lnr.this.qdl.ud) && !aaj.wd(lnr.this.qdl.ud)) {
                        if (lnr.this.qdl.to.get()) {
                            if (!vu.ud(lnr.this.qdl.ud)) {
                                if (!lnr.this.qdl.ud.zpu()) {
                                    str = "endcard";
                                }
                            } else {
                                str = "playable";
                            }
                        } else {
                            str = "video_player";
                        }
                    }
                    lnr.this.ud.setDislikeSource(str);
                    if (lnr.this.qdl.bch.mzz) {
                        if (lnr.this.qdl.bqt != null) {
                            lnr.this.qdl.bqt.qdl(8, false);
                            return;
                        }
                        return;
                    }
                    udVar.jtx();
                    if (lnr.this.qdl.bch.mo()) {
                        lnr.this.qdl.bch.jyq();
                    }
                    if (lnr.this.lnr()) {
                        lnr.this.qdl.lq.cx().ud(lnr.this.qdl.lq, 2);
                    }
                    com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(lnr.this.qdl.ud, 8);
                    lnr.this.qdl.xmv.mo();
                    lnr.this.qdl.xmv.jpc();
                    if (lnr.this.qdl.kab != null) {
                        lnr.this.qdl.kab.ud();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.common.bjy.qdl
                public void ud(View view) {
                    lnr.this.qdl.rq.set(false);
                    if (lnr.this.qdl.bch.mzz) {
                        if (lnr.this.qdl.bqt != null) {
                            lnr.this.qdl.bqt.qdl(0, true);
                            return;
                        }
                        return;
                    }
                    lnr.this.qdl.bch.qdl(udVar);
                    if (lnr.this.qdl.bch.tvp()) {
                        lnr.this.qdl.bch.aaj();
                    }
                    if (lnr.this.lnr()) {
                        lnr.this.qdl.lq.cx().ud(lnr.this.qdl.lq, 1);
                    }
                    com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(lnr.this.qdl.ud, 4);
                    lnr.this.qdl.xmv.qdl(0);
                    lnr.this.qdl.xmv.mzz();
                    if (lnr.this.qdl.kab != null) {
                        lnr.this.qdl.kab.qdl();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.common.bjy.qdl
                public void qdl(FilterWord filterWord) {
                    if (lnr.this.qdl.fs.get() || filterWord == null || filterWord.hasSecondOptions()) {
                        return;
                    }
                    lnr.this.qdl.fs.set(true);
                    if (lnr.this.qdl.lq != null) {
                        lnr.this.qdl.lq.cx().ud(true);
                    }
                    lnr.this.mml();
                }
            });
            ((FrameLayout) this.qdl.ag.findViewById(R.id.content)).addView(this.ud);
        }
        if (this.lnr == null) {
            this.lnr = new TTAdDislikeToast(this.qdl.ag);
            ((FrameLayout) this.qdl.ag.findViewById(R.id.content)).addView(this.lnr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lnr() {
        return this.qdl.blf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml() {
        TTAdDislikeToast tTAdDislikeToast = this.lnr;
        if (tTAdDislikeToast != null) {
            tTAdDislikeToast.show(TTAdDislikeToast.getDislikeSendTip());
        }
    }
}
