package com.bytedance.sdk.openadsdk.core.mml;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.exc;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends mml {
    private com.bytedance.sdk.openadsdk.qdl.qdl.ud jpc;
    private int to;
    private int tvp;

    public lnr(Context context, ljh ljhVar, AdSlot adSlot, boolean z) {
        super(context, ljhVar, adSlot, z);
        this.tvp = 1;
        this.to = -1;
    }

    public void qdl(com.bytedance.sdk.openadsdk.qdl.qdl.ud udVar) {
        if (this.ud != null) {
            ((exc) this.ud).jtx();
            this.jpc = udVar;
            this.to = 3;
        }
    }

    public void qdl() {
        if (this.ud != null) {
            ((exc) this.ud).bjy();
            this.to = 2;
        }
    }

    public void ud() {
        if (this.ud != null) {
            ((exc) this.ud).yt();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.mml.mml
    protected void lnr() {
        this.ud = new exc(this.qdl, this.lnr, this.mml, this.mo, this.wd) { // from class: com.bytedance.sdk.openadsdk.core.mml.lnr.1
            @Override // com.bytedance.sdk.openadsdk.core.tvp.aaj
            protected mzz.qdl lnr(int i) {
                return lnr.this.qdl(super.lnr(i));
            }
        };
        com.bytedance.sdk.openadsdk.core.exu.ud.lnr videoController = ((exc) this.ud).getVideoController();
        if (videoController != null) {
            videoController.mml(this.tvp);
        }
        addView(this.ud, new ViewGroup.LayoutParams(-1, -1));
        if (this.mzz != null) {
            setExpressInteractionListener(this.mzz);
        }
        if (this.ud != null) {
            ((exc) this.ud).setVideoAdListener(new com.bytedance.sdk.openadsdk.qdl.ud.lnr() { // from class: com.bytedance.sdk.openadsdk.core.mml.lnr.2
                @Override // com.bytedance.sdk.openadsdk.qdl.ud.lnr
                public void qdl(int i, int i2) {
                }

                @Override // com.bytedance.sdk.openadsdk.qdl.ud.lnr
                public void ud(PAGNativeAd pAGNativeAd) {
                }

                @Override // com.bytedance.sdk.openadsdk.qdl.ud.lnr
                public void qdl(PAGNativeAd pAGNativeAd) {
                    if (lnr.this.to != 3) {
                        if (lnr.this.to == 2) {
                            lnr.this.qdl();
                        }
                    } else {
                        lnr lnrVar = lnr.this;
                        lnrVar.qdl(lnrVar.jpc);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.qdl.ud.lnr
                public void lnr(PAGNativeAd pAGNativeAd) {
                    if (lnr.this.jpc != null) {
                        lnr.this.jpc.qdl();
                    }
                }
            });
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.ud.qdl getVideoModel() {
        if (this.ud != null) {
            return ((exc) this.ud).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.mml.mml
    public void mml() {
        com.bytedance.sdk.openadsdk.core.exu.ud.lnr videoController;
        if ((this.ud instanceof exc) && (videoController = ((exc) this.ud).getVideoController()) != null) {
            this.tvp = videoController.ax();
        }
        super.mml();
    }
}
