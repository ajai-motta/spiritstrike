package com.bytedance.sdk.openadsdk.core.mml;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.GravityCompat;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.exu.ud.mo;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.aaj;
import com.bytedance.sdk.openadsdk.core.tvp.jl;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.fs;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.google.android.material.badge.BadgeDrawable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends com.bytedance.sdk.openadsdk.core.tvp.qdl implements lnr.InterfaceC0175lnr, lnr.mml {
    private com.bytedance.sdk.openadsdk.core.exu.ud.mo bjy;
    private aaj exu;
    private PAGBannerAdWrapperListener jl;
    private String jtx;
    public boolean qdl;
    private com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo rdp;
    private long yt;

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void e_() {
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void f_() {
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void g_() {
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void h_() {
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.mml
    public void qdl(int i, int i2) {
    }

    public tvp(Context context) {
        super(context);
        this.qdl = true;
        this.ud = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.qdl
    protected void qdl(View view, int i, jtx jtxVar) {
        aaj aajVar = this.exu;
        if (aajVar != null) {
            aajVar.qdl(view, i, jtxVar);
            com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar = this.bjy;
            if (moVar == null || !(moVar.getNativeVideoController() instanceof com.bytedance.sdk.openadsdk.core.exu.ud.lnr)) {
                return;
            }
            this.bjy.getNativeVideoController().mrf();
        }
    }

    public void setClosedListenerKey(String str) {
        this.jtx = str;
    }

    public void qdl(ljh ljhVar, aaj aajVar, com.bytedance.sdk.openadsdk.exc.qdl.qdl.mo moVar) {
        setBackgroundColor(-16777216);
        this.lnr = ljhVar;
        this.exu = aajVar;
        this.rdp = moVar;
        this.mo = "banner_ad";
        this.exu.addView(this, new ViewGroup.LayoutParams(-2, -2));
        mzz();
    }

    private void mzz() {
        jl jlVarQdl = ud.qdl(this.exu.getExpectExpressWidth(), this.exu.getExpectExpressHeight());
        if (this.exu.getExpectExpressWidth() > 0 && this.exu.getExpectExpressHeight() > 0) {
            this.wd = ax.ud(this.ud, this.exu.getExpectExpressWidth());
            this.jpc = ax.ud(this.ud, this.exu.getExpectExpressHeight());
        } else {
            this.wd = ax.lnr(this.ud);
            this.jpc = Float.valueOf(this.wd / jlVarQdl.ud).intValue();
        }
        if (this.wd > 0 && this.wd > ax.lnr(this.ud)) {
            this.wd = ax.lnr(this.ud);
            this.jpc = Float.valueOf(this.jpc * (ax.lnr(this.ud) / this.wd)).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.wd, this.jpc);
        }
        layoutParams.width = this.wd;
        layoutParams.height = this.jpc;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        qdl(jlVarQdl);
    }

    private void qdl(jl jlVar) {
        if (this.lnr != null) {
            int iVxg = this.lnr.vxg();
            qdl qdlVarUd = ud(jlVar);
            if (qdlVarUd == null || qdlVarUd.qdl == null) {
                return;
            }
            addView(qdlVarUd.qdl);
            com.bytedance.sdk.openadsdk.core.mo.mml mmlVar = qdlVarUd.lnr;
            PAGLogoView pAGLogoView = qdlVarUd.mml;
            com.bytedance.sdk.openadsdk.core.mo.mml mmlVar2 = qdlVarUd.mzz;
            if (mmlVar2 != null && this.lnr.exc()) {
                ax.qdl((View) mmlVar2, 0);
                com.bytedance.sdk.openadsdk.jl.ud.ud().qdl((int) ax.qdl(yt.qdl(), 11.0f, true), mmlVar2, this.lnr);
            }
            com.bytedance.sdk.openadsdk.core.exu.ud.mo videoView = getVideoView();
            if (videoView instanceof com.bytedance.sdk.openadsdk.core.exu.ud.mo) {
                this.bjy = videoView;
                videoView.setVideoAdLoadListener(this);
                this.bjy.setVideoAdInteractionListener(this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Pair(mmlVar, FriendlyObstructionPurpose.CLOSE_AD));
                arrayList.add(new Pair(pAGLogoView, FriendlyObstructionPurpose.OTHER));
                arrayList.add(new Pair(mmlVar2, FriendlyObstructionPurpose.OTHER));
                this.bjy.qdl(arrayList);
                this.bjy.setAdCreativeClickListener(new mo.qdl() { // from class: com.bytedance.sdk.openadsdk.core.mml.tvp.1
                    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo.qdl
                    public void qdl(View view, int i) {
                        if (tvp.this.jl != null) {
                            tvp.this.jl.onAdClicked();
                        }
                    }
                });
            }
            if (pAGLogoView != null) {
                pAGLogoView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.tvp.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TTWebsiteActivity.qdl(tvp.this.ud, tvp.this.lnr, tvp.this.mo);
                    }
                });
            }
            if (mmlVar != null) {
                mmlVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.mml.tvp.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        tvp.this.qdl();
                    }
                });
            }
            fs fsVar = qdlVarUd.ud;
            if (this.lnr != null && this.lnr.aoy() != null && fsVar != null) {
                int iRq = this.lnr.aoy().rq();
                float fFs = this.lnr.aoy().fs();
                if (iRq > 0 && fFs > 0.0f) {
                    fsVar.setRatio(iRq / fFs);
                } else if (iVxg == 15) {
                    fsVar.setRatio(0.5625f);
                } else if (iVxg == 5) {
                    fsVar.setRatio(1.7777778f);
                } else {
                    fsVar.setRatio(1.0f);
                }
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (videoView != null && fsVar != null) {
                fsVar.addView(videoView, layoutParams);
                videoView.setTag(520093762, Boolean.TRUE);
            }
            qdl((View) videoView, true);
            qdl((View) this, true);
            qdl(fsVar);
        }
    }

    private qdl ud(jl jlVar) {
        qdl qdlVar = new qdl();
        qdlVar.qdl = new FrameLayout(this.ud);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        qdlVar.qdl.setLayoutParams(layoutParams);
        qdlVar.ud = new fs(this.ud);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 17;
        qdlVar.ud.setLayoutParams(layoutParams2);
        qdlVar.qdl.addView(qdlVar.ud);
        int iUd = ax.ud(this.ud, 5.0f);
        if (jlVar != null && jlVar.qdl == 1) {
            qdlVar.lnr = com.bytedance.sdk.openadsdk.core.widget.mo.qdl(getContext());
        } else {
            qdlVar.lnr = com.bytedance.sdk.openadsdk.core.widget.mo.ud(getContext());
        }
        qdlVar.lnr.setId(520093697);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = GravityCompat.END;
        layoutParams3.setMargins(iUd, iUd, iUd, iUd);
        qdlVar.lnr.setLayoutParams(layoutParams3);
        qdlVar.qdl.addView(qdlVar.lnr);
        qdlVar.mml = PAGLogoView.createPAGLogoViewByMaterial(this.ud, this.lnr);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = BadgeDrawable.BOTTOM_START;
        layoutParams4.setMargins(iUd, iUd, iUd, iUd);
        qdlVar.mml.setLayoutParams(layoutParams4);
        qdlVar.qdl.addView(qdlVar.mml);
        qdlVar.mzz = new com.bytedance.sdk.openadsdk.core.mo.mml(this.ud);
        int iUd2 = ax.ud(this.ud, 11.0f);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(iUd2, iUd2);
        layoutParams5.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams5.rightMargin = iUd;
        layoutParams5.bottomMargin = iUd;
        qdlVar.mzz.setVisibility(8);
        qdlVar.mzz.setScaleType(ImageView.ScaleType.FIT_CENTER);
        qdlVar.mzz.setLayoutParams(layoutParams5);
        qdlVar.qdl.addView(qdlVar.mzz);
        return qdlVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.tvp.qdl
    public void qdl() {
        if (this.mzz != null) {
            this.mzz.show();
        } else if (this.mml != null) {
            this.mml.qdl();
        } else {
            TTDelegateActivity.qdl(this.lnr, this.jtx);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void qdl(long j, long j2) {
        this.yt = j;
    }

    public long getVideoProgress() {
        return this.yt;
    }

    public void setAdInteractionListener(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        this.jl = pAGBannerAdWrapperListener;
    }

    private static class qdl {
        public com.bytedance.sdk.openadsdk.core.mo.mml lnr;
        public PAGLogoView mml;
        public com.bytedance.sdk.openadsdk.core.mo.mml mzz;
        public FrameLayout qdl;
        public fs ud;

        private qdl() {
        }
    }
}
