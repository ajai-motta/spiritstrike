package com.bytedance.sdk.openadsdk.core.mml;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.aaj;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends com.bytedance.sdk.openadsdk.core.mo.lnr {
    private int jpc;
    protected ljh lnr;
    protected AdSlot mml;
    protected String mo;
    protected PAGBannerAdWrapperListener mzz;
    protected final Context qdl;
    private boolean tvp;
    protected aaj ud;
    protected boolean wd;

    public mml(Context context, ljh ljhVar, AdSlot adSlot, boolean z) {
        super(context);
        this.mo = "banner_ad";
        this.wd = false;
        this.jpc = -1;
        this.tvp = false;
        if (ljhVar != null && ljhVar.dk() != 2) {
            ljhVar.bjy(1);
        }
        this.wd = z;
        this.qdl = context;
        this.lnr = ljhVar;
        this.mml = adSlot;
        lnr();
        AdSlot adSlot2 = this.mml;
        if (adSlot2 != null) {
            qdl(adSlot2.getExpressViewAcceptedWidth(), this.mml.getExpressViewAcceptedHeight());
        }
    }

    public void setCurrentIndex(int i) {
        this.jpc = i;
    }

    protected void lnr() {
        aaj aajVar = new aaj(this.qdl, this.lnr, this.mml, this.mo) { // from class: com.bytedance.sdk.openadsdk.core.mml.mml.1
            @Override // com.bytedance.sdk.openadsdk.core.tvp.aaj
            protected mzz.qdl lnr(int i) {
                return mml.this.qdl(super.lnr(i));
            }
        };
        this.ud = aajVar;
        addView(aajVar, new ViewGroup.LayoutParams(-1, -1));
        PAGBannerAdWrapperListener pAGBannerAdWrapperListener = this.mzz;
        if (pAGBannerAdWrapperListener != null) {
            setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    protected mzz.qdl qdl(mzz.qdl qdlVar) {
        int i;
        if (this.wd && (i = this.jpc) >= 0) {
            qdlVar.ud = i;
        }
        return qdlVar;
    }

    public void setExpressInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.mzz = pAGBannerAdWrapperListener;
        aaj aajVar = this.ud;
        if (aajVar != null) {
            aajVar.setJsbLandingPageOpenListener(new com.bytedance.sdk.openadsdk.core.widget.mzz() { // from class: com.bytedance.sdk.openadsdk.core.mml.mml.2
                @Override // com.bytedance.sdk.openadsdk.core.widget.mzz
                public void qdl() {
                    mml.this.mzz.onAdClicked();
                }
            });
            this.ud.setExpressInteractionListener(new PAGExpressAdWrapperListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.mml.3
                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdDismissed() {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
                public void onAdClicked() {
                    if (mml.this.lnr == null || !mml.this.lnr.vxm() || mml.this.mzz == null) {
                        return;
                    }
                    mml.this.mzz.onAdClicked();
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderFail(View view, String str, int i) {
                    if (mml.this.mzz != null) {
                        mml.this.mzz.onRenderFail(mml.this, str, i);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener
                public void onRenderSuccess(View view, float f, float f2) {
                    if (mml.this.ud != null) {
                        mml.this.ud.setSoundMute(true);
                        if (!com.bytedance.sdk.openadsdk.core.rq.mml.qdl(mml.this.ud.getDynamicShowType())) {
                            mml.this.qdl(f, f2);
                        } else if (mml.this.mml != null) {
                            mml mmlVar = mml.this;
                            mmlVar.qdl(mmlVar.mml.getExpressViewAcceptedWidth(), mml.this.mml.getExpressViewAcceptedHeight());
                        }
                    }
                    if (mml.this.tvp) {
                        mml.this.ud.jl();
                    }
                    if (mml.this.mzz != null) {
                        mml.this.mzz.onRenderSuccess(mml.this, f, f2);
                    }
                }
            });
        }
    }

    protected void qdl(float f, float f2) {
        int iUd = ax.ud(this.qdl, f);
        int iUd2 = ax.ud(this.qdl, f2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iUd, iUd2);
        }
        layoutParams.width = iUd;
        layoutParams.height = iUd2;
        setLayoutParams(layoutParams);
    }

    public void mzz() {
        aaj aajVar = this.ud;
        if (aajVar != null) {
            aajVar.exc();
        }
    }

    public void mml() {
        if (this.ud != null) {
            com.bytedance.sdk.openadsdk.core.tvp.ud().mo(this.ud.getClosedListenerKey());
            removeView(this.ud);
            this.ud.fs();
            this.ud = null;
        }
        com.bytedance.sdk.openadsdk.core.tvp.ud().jyq();
    }

    public aaj getCurView() {
        return this.ud;
    }

    public void setIsShow(boolean z) {
        this.tvp = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ud == null) {
            lnr();
        }
        com.bytedance.sdk.openadsdk.utils.mml.qdl(this, this.lnr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
