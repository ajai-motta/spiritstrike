package com.bytedance.sdk.openadsdk.core.exu.ud;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bykv.vk.openvk.qdl.qdl.qdl.qdl;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.bqt;
import com.bytedance.sdk.component.utils.jl;
import com.bytedance.sdk.component.utils.tvp;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.exu.ud.mo;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.tvp.bch;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy;
import com.bytedance.sdk.openadsdk.mml.wd;
import com.bytedance.sdk.openadsdk.rdp.exu;
import com.bytedance.sdk.openadsdk.rdp.rdp;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends com.bytedance.sdk.openadsdk.core.exu.qdl.qdl {
    private final boolean ag;
    private final boolean ax;
    private boolean car;
    private WeakReference<qdl> cx;
    private long fco;
    private wd gt;
    private final String gy;
    private long hzv;
    private ud irn;
    private final qdl.InterfaceC0177qdl jjk;
    private final boolean mrf;
    private WeakReference<lnr.mml> om;
    private int sy;
    private final Runnable taz;
    private final bqt.qdl tid;
    private int wak;
    private boolean wc;
    private int xi;
    private int yh;
    private int zlt;

    public interface qdl {
        void mo();

        void qdl(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mml(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    public void mo(boolean z) {
        this.wc = z;
    }

    public void qdl(final mo.qdl qdlVar) {
        if (!this.bjy || this.wd == null) {
            return;
        }
        this.wd.qdl(new mo.qdl() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.2
            @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mo.qdl
            public void qdl(View view, int i) {
                mo.qdl qdlVar2 = qdlVar;
                if (qdlVar2 != null) {
                    qdlVar2.qdl(view, i);
                }
            }
        });
    }

    public void qdl(PAGNativeAd pAGNativeAd) {
        if (!this.bjy || this.wd == null) {
            return;
        }
        this.wd.qdl(pAGNativeAd);
    }

    public void qdl(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.yh = i;
        this.wak = i2;
    }

    public void ud(int i, int i2) {
        qdl(i, i2);
        if (this.wd == null || i <= 0 || i2 <= 0) {
            return;
        }
        this.wd.lnr(i, i2);
        this.wd.qdl(i, i2);
        om();
    }

    public void qdl(ud udVar) {
        this.irn = udVar;
    }

    private void qdl(Context context) {
        ViewGroup exuVar;
        if (this.bjy) {
            exuVar = new rdp(context);
        } else {
            exuVar = new exu(context);
        }
        ViewGroup viewGroup = exuVar;
        if (this.bjy) {
            this.wd = new mzz(context, viewGroup, true, 17, this.jpc, this, oth());
        } else {
            this.wd = new mml(context, viewGroup, true, 17, this.jpc, this, false);
        }
        this.wd.qdl(this);
    }

    public lnr(Context context, ViewGroup viewGroup, ljh ljhVar, String str, boolean z, boolean z2, boolean z3, wd wdVar) {
        super(context, ljhVar, viewGroup);
        this.hzv = 0L;
        this.fco = 0L;
        this.wc = true;
        this.yh = 0;
        this.wak = 0;
        this.jjk = new qdl.InterfaceC0177qdl() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1
            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void lnr(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i) {
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
                com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(lnr.this.jpc, 5);
                            com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(lnr.this.jpc, 5);
                            if (lnr.this.vu != null) {
                                lnr.this.vu.qdl(9);
                            }
                        } catch (Exception unused) {
                        }
                        lnr.this.ag();
                    }
                });
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = lnr.this.jpc.zm();
                if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
                    return;
                }
                mmlVarQdl.mml(lnr.this.tvp);
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, long j) {
                if (!lnr.this.jyq.get()) {
                    lnr.this.koa();
                }
                lnr.this.uw = false;
                lnr.this.lnr.removeCallbacks(lnr.this.taz);
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lnr.this.wd != null) {
                            lnr.this.wd.ud();
                        }
                        if (!lnr.this.bjy || lnr.this.cx == null || lnr.this.cx.get() == null) {
                            return;
                        }
                        ((qdl) lnr.this.cx.get()).mo();
                    }
                });
                lnr.this.hzv();
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(lnr.this.jpc, 0);
                if (lnr.this.vu != null) {
                    lnr.this.vu.lnr();
                }
                lnr lnrVar = lnr.this;
                lnrVar.qdl(lnrVar.gt);
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
                lnr.this.lnr.removeCallbacks(lnr.this.taz);
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lnr.this.om != null && lnr.this.om.get() != null) {
                            lnr.this.om.get();
                        }
                        if (lnr.this.wd != null) {
                            lnr.this.wd.ud();
                        }
                    }
                });
                if (lnr.this.mrf) {
                    return;
                }
                lnr lnrVar = lnr.this;
                lnrVar.qdl(lnrVar.gt);
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, final com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar2) {
                com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
                if (ljh.mo(lnr.this.jpc)) {
                    com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.5
                        @Override // com.bytedance.sdk.openadsdk.yt.mml
                        public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                            com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                            try {
                                qdlVar3.ud("video_player");
                                qdlVar3.mml(gy.qdl(lnr.this.jpc));
                                qdlVar3.qdl(BuildConfig.VERSION_NAME);
                            } catch (Throwable unused) {
                            }
                            return qdlVar3;
                        }
                    });
                }
                String unused = lnr.this.qdl;
                qdlVar2.qdl();
                qdlVar2.ud();
                qdlVar2.lnr();
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        int iQdl = qdlVar2.qdl();
                        int iUd = qdlVar2.ud();
                        if (!lnr.this.bqt() || iUd == -1004) {
                            if (lnr.this.mml(iQdl, iUd)) {
                                String unused2 = lnr.this.qdl;
                                lnr.this.wd.qdl(lnr.this.jpc, (WeakReference<Context>) null, false);
                                lnr.this.ud(true);
                                lnr.this.mzz();
                            }
                            if (lnr.this.wd != null) {
                                lnr.this.wd.ud();
                            }
                            if (lnr.this.koa != null) {
                                lnr.this.koa.ud(lnr.this.fco, com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(lnr.this.tvp, lnr.this.ekw));
                            }
                            if (lnr.this.om == null || lnr.this.om.get() == null || lnr.this.bqt()) {
                                return;
                            }
                            ((lnr.mml) lnr.this.om.get()).qdl(iQdl, iUd);
                        }
                    }
                });
                lnr.this.qdl(qdlVar2);
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = lnr.this.jpc.zm();
                if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                    mmlVarQdl.qdl(com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.GENERAL_LINEAR_AD_ERROR);
                }
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(lnr.this.jpc, 6);
                com.bytedance.sdk.openadsdk.bch.qdl.lnr.ud(lnr.this.jpc);
                if (lnr.this.vu != null) {
                    lnr.this.vu.qdl(14);
                }
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, boolean z4) {
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lnr.this.wd != null) {
                            lnr.this.wd.ud();
                        }
                    }
                });
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i, int i2) {
                tvp.qdl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        lnr.this.om();
                    }
                });
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i, int i2, int i3) {
                lnr.this.uw = true;
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (lnr.this.wd != null) {
                            lnr.this.wd.yt();
                            lnr.this.lnr.postDelayed(lnr.this.taz, 8000L);
                        }
                    }
                });
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(lnr.this.jpc, 2);
                if (lnr.this.vu != null) {
                    lnr.this.vu.qdl(4);
                }
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i) {
                lnr.this.uw = false;
                lnr.this.lnr.removeCallbacks(lnr.this.taz);
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.10
                    @Override // java.lang.Runnable
                    public void run() {
                        lnr.this.wd.ud();
                    }
                });
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(lnr.this.jpc, 0);
                if (lnr.this.vu != null) {
                    lnr.this.vu.qdl(5);
                }
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, final long j, final long j2) {
                if (Math.abs(j - lnr.this.tvp) < 50) {
                    return;
                }
                if (!lnr.this.jyq.get()) {
                    lnr.this.koa();
                }
                lnr lnrVar = lnr.this;
                lnrVar.qdl(lnrVar.gt);
                lnr.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        lnr.this.qdl(j, j2);
                        lnr.this.ud(j, j2);
                    }
                });
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void mml(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
                com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = lnr.this.jpc.zm();
                if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                    mmlVarQdl.ud(lnr.this.tvp);
                }
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(lnr.this.jpc, 3);
                if (lnr.this.vu != null) {
                    lnr.this.vu.qdl(0);
                }
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
            public void mzz(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
                com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = lnr.this.jpc.zm();
                if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                    mmlVarQdl.lnr(lnr.this.tvp);
                }
                if (lnr.this.vu != null) {
                    lnr.this.vu.qdl(1);
                }
            }
        };
        this.zlt = 0;
        this.taz = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.4
            @Override // java.lang.Runnable
            public void run() {
                if (lnr.this.wd != null) {
                    lnr.this.wd.qdl(lnr.this.jpc, (WeakReference<Context>) null, false);
                    lnr.this.wd.ud();
                    lnr.this.ud(true);
                    String unused = lnr.this.qdl;
                }
            }
        };
        this.tid = new bqt.qdl() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.6
            @Override // com.bytedance.sdk.component.utils.bqt.qdl
            public void qdl(Context context2, Intent intent, boolean z4, final int i) {
                fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        lnr.this.mo(i);
                    }
                });
            }
        };
        this.car = false;
        this.sy = jl.lnr(context);
        qdl(z);
        this.gy = str;
        try {
            this.yh = viewGroup.getWidth();
            this.wak = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        qdl(context);
        this.mrf = true;
        this.ax = z2;
        this.ag = z3;
        if (wdVar != null) {
            this.gt = wdVar;
        }
    }

    public com.bytedance.sdk.openadsdk.core.fs.mo qdl(View view, List<Pair<View, FriendlyObstructionPurpose>> list) {
        if (!this.jpc.qh()) {
            return null;
        }
        if (this.vu == null) {
            this.vu = com.bytedance.sdk.openadsdk.core.fs.mo.qdl();
        }
        this.vu.qdl(view, this.jpc);
        if (list != null && list.size() > 0) {
            for (Pair<View, FriendlyObstructionPurpose> pair : list) {
                if (pair != null) {
                    this.vu.qdl((View) pair.first, pair.second == null ? FriendlyObstructionPurpose.OTHER : (FriendlyObstructionPurpose) pair.second);
                }
            }
        }
        return this.vu;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.qdl.qdl
    public void qdl(lnr.mml mmlVar) {
        this.om = new WeakReference<>(mmlVar);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void qdl() {
        if (this.mo != null) {
            this.mo.tvp();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.qdl.qdl, com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public boolean qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        super.qdl(lnrVar);
        if (this.mo != null) {
            ApmHelper.reportCustomError("", "twice playVideoUrl", new IllegalStateException());
            return true;
        }
        if (TextUtils.isEmpty(lnrVar.jtx())) {
            return false;
        }
        ud(false);
        lnrVar.jtx();
        lnrVar.ud(com.bytedance.sdk.openadsdk.jyq.qdl.qdl("player_force_raw_url", 0) == 1);
        int i = this.xi + 1;
        this.xi = i;
        lnrVar.mzz = i;
        ud(lnrVar);
        kdv();
        if (this.vu != null) {
            this.vu.qdl(false, 0.0f);
        }
        if (!bch.ud(this.gy) || this.tvp <= 0) {
            this.tvp = lnrVar.to();
        }
        if (bch.ud(this.gy) && this.tvp == this.ekw) {
            this.tvp = 0L;
        }
        if (lnrVar.to() <= 0) {
            this.oth = false;
            this.aaj.set(false);
        } else {
            this.tvp = lnrVar.to();
            this.to = Math.max(this.to, this.tvp);
        }
        if (this.wd != null) {
            this.wd.qdl();
            if (this.zlt == 0) {
                this.wd.wd();
            }
            this.wd.lnr(lnrVar.jpc(), lnrVar.tvp());
            this.wd.lnr(this.xmv);
            this.wd.qdl(lnrVar.jpc(), lnrVar.tvp());
        }
        if (this.mo == null) {
            this.mo = new com.bytedance.sdk.openadsdk.core.exu.mml.lnr();
            this.mo.qdl(this.jjk);
        }
        jl();
        this.fco = 0L;
        try {
            lnr(lnrVar);
            return true;
        } catch (Exception e) {
            qdl(new com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl(-10, 0, e.getMessage()));
            aaj.lnr(this.qdl, "[video] invoke NativeVideoController#playVideo cause exception :".concat(String.valueOf(e)));
            return false;
        }
    }

    private void lnr(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        lnrVar.mml(0);
        this.mo.qdl(lnrVar);
        this.hzv = System.currentTimeMillis();
        this.wd.lnr(8);
        this.wd.lnr(0);
        qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.3
            @Override // java.lang.Runnable
            public void run() {
                if (lnr.this.mo == null) {
                    return;
                }
                lnr.this.hzv = System.currentTimeMillis();
                lnr.this.wd.mml(0);
                lnr.this.mo.qdl(true, lnr.this.tvp, lnr.this.jtx);
            }
        });
        if (this.bjy) {
            jtx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag() {
        this.zlt++;
        if (this.wd == null) {
            return;
        }
        this.wd.ud();
        if (this.koa != null) {
            this.koa.qdl(this.fco, com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(this.tvp, this.ekw));
        }
        this.fco = System.currentTimeMillis() - this.hzv;
        if (this.wc) {
            this.wd.qdl(this.jpc, (WeakReference<Context>) null, true);
        }
        if (!this.oth) {
            this.oth = true;
            ud(this.ekw, this.ekw);
            long j = this.ekw;
            this.tvp = j;
            this.to = j;
            ud(this.gt);
        }
        if (!this.bjy && this.exc) {
            mzz(this.wd, null);
        }
        this.rdp = true;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void lnr() {
        if (this.wd != null) {
            this.wd.qdl();
        }
        if (this.wd != null) {
            this.wd.jl();
        }
        wc();
    }

    public void wd(boolean z) {
        if (this.wd != null) {
            this.wd.qdl();
        }
        if (this.wd != null && z) {
            this.wd.jl();
        }
        wc();
    }

    private void wc() {
        Boolean.valueOf(this.exu);
        if (this.mo != null) {
            if (this.mo.wd()) {
                if (this.exu) {
                    aaj();
                } else {
                    ud(this.hkc);
                }
                Boolean.valueOf(this.exu);
            } else {
                this.mo.qdl(false, this.tvp, this.jtx);
            }
        }
        if (this.aaj.get()) {
            vu();
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void mml() {
        qdl(true, 3);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void qdl(boolean z, int i) {
        if (!this.oth && this.aaj.get()) {
            if (z) {
                qdl(i, false);
                this.oth = false;
            } else {
                rc();
            }
        }
        mzz();
        if (this.vu != null) {
            this.vu.mml();
        }
    }

    public final void qdl(int i, boolean z) {
        if (z || this.kdv) {
            if (z) {
                this.kdv = false;
            }
            if (this.oth || !this.aaj.get()) {
                return;
            }
            bjy.qdl qdlVar = new bjy.qdl();
            qdlVar.ud(mo());
            qdlVar.mml(tvp());
            qdlVar.lnr(wd());
            qdlVar.lnr(i);
            qdlVar.mml(jpc());
            com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(this.wd, qdlVar, this.gt);
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void mzz() {
        if (this.mo != null) {
            this.mo.fs();
            this.mo = null;
        }
        if (this.wc) {
            if (!"embeded_ad".equals(this.gy)) {
                this.wd.qdl(this.jpc, (WeakReference<Context>) null, true);
            } else {
                this.wd.aaj();
            }
            this.lnr.removeCallbacksAndMessages(null);
            this.fs.clear();
            if (this.bjy) {
                fco();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om() {
        int i;
        int i2;
        try {
            if (cx() != null && this.mo != null && this.xmv != null) {
                int iMml = this.mo.mml();
                int iMzz = this.mo.mzz();
                final int width = this.xmv.getWidth();
                final int height = this.xmv.getHeight();
                if (width > 0 && height > 0 && iMzz > 0 && iMml > 0) {
                    if (iMml == iMzz) {
                        i2 = width > height ? height : width;
                        i = i2;
                    } else if (iMml > iMzz) {
                        i2 = (int) ((((double) width) * 1.0d) / ((double) ((iMml * 1.0f) / iMzz)));
                        i = width;
                    } else {
                        i = (int) ((((double) height) * 1.0d) / ((double) ((iMzz * 1.0f) / iMml)));
                        i2 = height;
                    }
                    if (i2 <= height && i2 > 0) {
                        height = i2;
                    }
                    if (i <= width && i > 0) {
                        width = i;
                    }
                    this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.lnr.5
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                                layoutParams.addRule(13);
                                if (lnr.this.cx() instanceof TextureView) {
                                    ((TextureView) lnr.this.cx()).setLayoutParams(layoutParams);
                                    String unused = lnr.this.qdl;
                                } else if (lnr.this.cx() instanceof SurfaceView) {
                                    ((SurfaceView) lnr.this.cx()).setLayoutParams(layoutParams);
                                    String unused2 = lnr.this.qdl;
                                }
                            } catch (Throwable unused3) {
                                String unused4 = lnr.this.qdl;
                            }
                        }
                    });
                    return;
                }
                return;
            }
            Objects.toString(this.rq);
            Objects.toString(cx());
            com.bytedance.sdk.openadsdk.core.exu.mml.lnr lnrVar = this.mo;
            com.bytedance.sdk.openadsdk.core.exu.mml.lnr lnrVar2 = this.mo;
        } catch (Throwable th) {
            th.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud cx() {
        if (this.rq.getResources().getConfiguration().orientation != 1 || this.wd == null) {
            return null;
        }
        return this.wd.exu();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.qdl
    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud udVar, View view) {
        if (this.mo == null) {
            return;
        }
        if (this.mo.mo()) {
            ud();
            this.wd.ud(true, false);
            this.wd.mo();
        } else {
            if (!this.mo.wd()) {
                if (this.wd != null) {
                    this.wd.lnr(this.xmv);
                }
                mzz(this.tvp);
                if (this.wd != null) {
                    this.wd.ud(false, false);
                    return;
                }
                return;
            }
            wd(false);
            if (this.wd != null) {
                this.wd.ud(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(long j, long j2) {
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        this.jpc.lnr(j);
        this.tvp = j;
        this.ekw = j2;
        this.wd.qdl(j, j2);
        this.wd.qdl(com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(j, j2));
        try {
            if (this.koa != null) {
                this.koa.qdl(j, j2);
            }
        } catch (Throwable th) {
            aaj.qdl(this.qdl, "onProgressUpdate error: ", th);
        }
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = this.jpc.zm();
        if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        mmlVarQdl.qdl(j, j2, this.vu);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.qdl.qdl
    public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud udVar, View view, boolean z) {
        lnr(!this.exc);
        if (this.rq instanceof Activity) {
            if (this.wd != null) {
                this.wd.ud(this.xmv);
                this.wd.lnr(false);
            }
            qdl(1);
            lnr.ud udVar2 = this.bqt != null ? this.bqt.get() : null;
            if (udVar2 != null) {
                udVar2.qdl(this.exc);
            }
        }
    }

    private boolean lnr(int i, int i2) {
        if (i2 == 0) {
            ud();
            this.yt = true;
            if (this.wd != null) {
                this.wd.qdl(this.jpc, (WeakReference<Context>) null, false);
            }
        }
        if (i2 != 4 && i2 != 0) {
            if (this.wd != null) {
                this.wd.qdl();
            }
            ud();
            this.yt = true;
            this.jl = false;
            if (this.wd != null) {
                return this.wd.qdl(i, this.jpc.tdy(), this.ag);
            }
        } else if (i2 == 4) {
            this.yt = false;
            if (this.wd != null) {
                this.wd.bjy();
            }
        }
        return true;
    }

    private void mzz(int i) {
        if (this.sy == i) {
            return;
        }
        this.sy = i;
        if (i != 4 && i != 0) {
            this.jl = false;
        }
        if (!this.jl && !exu() && this.ax) {
            lnr(2, i);
        }
        WeakReference<qdl> weakReference = this.cx;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.cx.get().qdl(this.sy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mo(int i) {
        mzz(i);
        if (i == 4) {
            this.yt = false;
        }
    }

    public void lnr(int i) {
        mzz(i);
        if (i == 4) {
            this.yt = false;
            lnr();
        }
    }

    public void jtx() {
        if (this.car || !this.ljh) {
            return;
        }
        Context applicationContext = yt.qdl().getApplicationContext();
        this.car = true;
        bqt.qdl(this.tid, applicationContext);
    }

    public void fco() {
        if (this.car && this.ljh) {
            this.car = false;
            bqt.qdl(this.tid);
        }
    }

    public void qdl(qdl qdlVar) {
        this.cx = new WeakReference<>(qdlVar);
    }

    public void mrf() {
        if (this.vu != null) {
            this.vu.qdl(13);
        }
    }

    public void gy() {
        if (this.mo != null) {
            ud(false);
            kdv();
            this.aaj.set(false);
            this.oth = false;
            qdl(this.gt);
            this.mo.tvp();
        }
    }

    public void mml(int i) {
        this.xi = i;
    }

    public int ax() {
        return this.xi;
    }
}
