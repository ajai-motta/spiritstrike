package com.bytedance.sdk.openadsdk.qdl.ud.qdl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.rq.mml;
import com.bytedance.sdk.openadsdk.core.tvp.aaj;
import com.bytedance.sdk.openadsdk.core.tvp.exc;
import com.bytedance.sdk.openadsdk.qdl.ud.jpc;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends jpc {
    private boolean fs;
    protected final Context jpc;
    protected String rq;
    protected aaj to;
    protected AdSlot tvp;

    public lnr(Context context, ljh ljhVar, AdSlot adSlot) {
        super(context, ljhVar, 5, true);
        this.rq = "embeded_ad";
        this.fs = false;
        this.ud.bjy(1);
        this.mml.qdl(this);
        this.jpc = context;
        this.tvp = adSlot;
        qdl();
        ud();
    }

    protected void qdl() {
        this.to = new aaj(this.jpc, this.ud, this.tvp, this.rq);
        lnr();
    }

    private void ud() {
        aaj aajVar = this.to;
        if (aajVar != null) {
            aajVar.setBackupListener(new com.bytedance.sdk.component.adexpress.ud.lnr() { // from class: com.bytedance.sdk.openadsdk.qdl.ud.qdl.lnr.1
                @Override // com.bytedance.sdk.component.adexpress.ud.lnr
                public boolean qdl(ViewGroup viewGroup, int i) {
                    qdl qdlVar = new qdl(lnr.this.to.getContext());
                    qdlVar.setExtraFuncationHelper(lnr.this.mml);
                    qdlVar.qdl(lnr.this.to);
                    return true;
                }
            });
        }
    }

    protected void lnr() {
        aaj aajVar = this.to;
        if (aajVar != null) {
            aajVar.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.qdl.ud.qdl.lnr.2
                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f, float f2) {
                    if (!lnr.this.to.jyq()) {
                        lnr.this.qdl(f, f2);
                        if (lnr.this.fs) {
                            lnr.this.to.jl();
                            return;
                        }
                        return;
                    }
                    com.bytedance.sdk.openadsdk.qdl.ud.ud udVar = new com.bytedance.sdk.openadsdk.qdl.ud.ud(lnr.this.jpc, lnr.this.ud, 5, lnr.this.tvp, lnr.this.mml, lnr.this.qdl);
                    lnr lnrVar = lnr.this;
                    if (lnrVar instanceof ud) {
                        udVar.qdl(((exc) lnrVar.mml()).getVideoAdListener());
                    }
                    lnr.this.mml.qdl((com.bytedance.sdk.openadsdk.core.lnr.qdl) lnr.this.to.getClickCreativeListener());
                    PAGMediaView pAGMediaViewTvp = lnr.this.mml.tvp();
                    if (pAGMediaViewTvp == null) {
                        pAGMediaViewTvp = new PAGMediaView(lnr.this.jpc);
                    }
                    lnr.this.to.addView(pAGMediaViewTvp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(float f, float f2) {
        aaj aajVar = this.to;
        if (aajVar != null && mml.qdl(aajVar.getDynamicShowType())) {
            ViewGroup.LayoutParams layoutParams = this.to.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.to.setLayoutParams(layoutParams);
            return;
        }
        int iUd = ax.ud(this.jpc, f);
        int iUd2 = ax.ud(this.jpc, f2);
        ViewGroup.LayoutParams layoutParams2 = this.to.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new ViewGroup.LayoutParams(iUd, iUd2);
        } else {
            layoutParams2.width = iUd;
            layoutParams2.height = iUd2;
        }
        this.to.setLayoutParams(layoutParams2);
    }

    public aaj mml() {
        return this.to;
    }

    public void qdl(boolean z) {
        this.fs = z;
    }

    public void mzz() {
        aaj aajVar = this.to;
        if (aajVar != null) {
            aajVar.exc();
        }
    }
}
