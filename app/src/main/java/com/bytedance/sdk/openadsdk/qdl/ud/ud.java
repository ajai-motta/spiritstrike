package com.bytedance.sdk.openadsdk.qdl.ud;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.core.exu.ud.mo;
import com.bytedance.sdk.openadsdk.core.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.multipro.ud.qdl;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends jpc implements lnr.InterfaceC0175lnr, lnr.mml, qdl.InterfaceC0270qdl {
    private long exu;
    private AdSlot fs;
    private lnr jpc;
    private boolean rq;
    private boolean to;
    private final com.bytedance.sdk.openadsdk.multipro.ud.qdl tvp;

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void g_() {
    }

    public ud(Context context, ljh ljhVar, int i, AdSlot adSlot) {
        super(context, ljhVar, i, true);
        this.to = false;
        this.rq = true;
        this.mzz = i;
        this.fs = adSlot;
        this.tvp = new com.bytedance.sdk.openadsdk.multipro.ud.qdl();
        qdl(this.mo);
        qdl("embeded_ad");
        this.mml.qdl(this);
    }

    public ud(Context context, ljh ljhVar, int i, AdSlot adSlot, qdl qdlVar, jtx jtxVar) {
        super(context, ljhVar, i, false);
        this.to = false;
        this.rq = true;
        this.mml = qdlVar;
        this.qdl = jtxVar;
        this.mzz = i;
        this.fs = adSlot;
        this.tvp = new com.bytedance.sdk.openadsdk.multipro.ud.qdl();
        qdl(this.mo);
        qdl("embeded_ad");
        qdlVar.qdl(this);
    }

    public View mzz() {
        com.bytedance.sdk.openadsdk.core.exu.ud.mo moVar;
        if (this.ud != null && this.lnr != null) {
            if (ljh.mzz(this.ud)) {
                try {
                    moVar = new com.bytedance.sdk.openadsdk.core.exu.ud.mo(this.lnr, this.ud, this.qdl.qdl());
                    if (this.ud != null && this.ud.uj()) {
                        com.bytedance.sdk.openadsdk.core.fs.mo moVarQdl = moVar.qdl((List<Pair<View, FriendlyObstructionPurpose>>) null);
                        if (this.mml != null) {
                            this.mml.qdl(moVarQdl);
                        }
                    }
                    this.qdl.qdl(moVar.getNativeVideoController());
                    if (this.mml != null) {
                        this.mml.qdl(moVar);
                    }
                    moVar.setVideoAdClickListenerTTNativeAd(this);
                    moVar.setAdCreativeClickListener(new mo.qdl() { // from class: com.bytedance.sdk.openadsdk.qdl.ud.ud.1
                        @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo.qdl
                        public void qdl(View view, int i) {
                            if (ud.this.qdl != null) {
                                ud.this.qdl.qdl(view, i);
                            }
                        }
                    });
                    moVar.setControllerStatusCallBack(new mo.ud() { // from class: com.bytedance.sdk.openadsdk.qdl.ud.ud.2
                        @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo.ud
                        public void qdl(boolean z, long j, long j2, long j3, boolean z2) {
                            ud.this.tvp.qdl = z;
                            ud.this.tvp.mzz = j;
                            ud.this.tvp.mo = j2;
                            ud.this.tvp.wd = j3;
                            ud.this.tvp.mml = z2;
                        }
                    });
                    moVar.setVideoAdLoadListener(this);
                    moVar.setVideoAdInteractionListener(this);
                    if (5 == this.mzz) {
                        moVar.setIsAutoPlay(this.to ? this.fs.isAutoPlay() : this.rq);
                    } else {
                        moVar.setIsAutoPlay(this.rq);
                    }
                    moVar.qdl(yt.mml().lnr(String.valueOf(this.mo)), "feedGetAdView");
                } catch (Exception e) {
                    ApmHelper.reportCustomError("", "getAdView null", e);
                    moVar = null;
                }
                if (!ljh.mzz(this.ud) && moVar != null && moVar.qdl(0L, true, false)) {
                    return moVar;
                }
                ApmHelper.reportCustomError(this.ud.vxg() + "," + moVar, "getAdView null", new RuntimeException());
            } else {
                moVar = null;
                if (!ljh.mzz(this.ud)) {
                }
                ApmHelper.reportCustomError(this.ud.vxg() + "," + moVar, "getAdView null", new RuntimeException());
            }
        }
        return null;
    }

    private void qdl(int i) {
        int iUd = yt.mml().ud(i);
        int iLnr = jl.lnr(yt.qdl());
        if (3 == iUd) {
            this.to = false;
            this.rq = false;
        } else {
            if (1 == iUd && gy.mml(iLnr)) {
                this.to = false;
            } else if (2 == iUd) {
                if (gy.mzz(iLnr) || gy.mml(iLnr) || gy.mo(iLnr)) {
                    this.to = false;
                }
            } else if (4 == iUd) {
                this.to = true;
            } else if (5 == iUd && (gy.mml(iLnr) || gy.mo(iLnr))) {
            }
            this.rq = true;
        }
        if (this.mml != null) {
            this.mml.qdl(this.to);
        }
    }

    public void qdl(lnr lnrVar) {
        this.jpc = lnrVar;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.mml
    public void qdl(int i, int i2) {
        lnr lnrVar = this.jpc;
        if (lnrVar != null) {
            lnrVar.qdl(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void e_() {
        lnr lnrVar = this.jpc;
        if (lnrVar != null) {
            lnrVar.qdl(this);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void f_() {
        lnr lnrVar = this.jpc;
        if (lnrVar != null) {
            lnrVar.ud(this);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void qdl(long j, long j2) {
        this.exu = j;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr.InterfaceC0175lnr
    public void h_() {
        lnr lnrVar = this.jpc;
        if (lnrVar != null) {
            lnrVar.lnr(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.ud.qdl.InterfaceC0270qdl
    public com.bytedance.sdk.openadsdk.multipro.ud.qdl mo() {
        return this.tvp;
    }

    @Override // com.bytedance.sdk.openadsdk.qdl.ud.jpc
    protected void qdl(String str) {
        super.qdl(str);
    }

    @Override // com.bytedance.sdk.openadsdk.qdl.ud.jpc, com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
        if (this.mml != null) {
            this.mml.fs();
        }
    }
}
