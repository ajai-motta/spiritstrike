package com.bytedance.sdk.openadsdk.core.exu.mml;

import android.content.Context;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.utils.tvp;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.exu.mml.lnr;
import com.bytedance.sdk.openadsdk.core.fs.mml;
import com.bytedance.sdk.openadsdk.core.fs.mo;
import com.bytedance.sdk.openadsdk.core.model.aaj;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.wd;
import com.bytedance.sdk.openadsdk.rdp.rdp;
import com.bytedance.sdk.openadsdk.utils.ag;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.jtx;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends com.bytedance.sdk.openadsdk.core.exu.qdl.qdl {
    private long ag;
    private long ax;
    private final AtomicBoolean cx;
    protected boolean fco;
    private InterfaceC0231qdl gt;
    private final wd gy;
    protected long hzv;
    final lnr.ud mrf;
    private final int om;
    private final Runnable wak;
    private boolean wc;
    private boolean yh;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.exu.mml.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0231qdl {
        void qdl(int i);
    }

    protected void jtx() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.qdl.qdl
    public boolean uw() {
        return true;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.exu.mml.qdl$1, reason: invalid class name */
    class AnonymousClass1 implements lnr.ud {
        private boolean ud = true;

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i) {
        }

        AnonymousClass1() {
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            mml mmlVarQdl;
            if (qdl.this.cx.compareAndSet(false, true)) {
                String unused = qdl.this.qdl;
                qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (qdl.this.vu != null) {
                            try {
                                qdl.this.vu.qdl(9);
                            } catch (Exception unused2) {
                            }
                        }
                        qdl.this.yh();
                    }
                });
                com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = qdl.this.jpc.zm();
                if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                    long jMo = qdl.this.mo();
                    mmlVarQdl.mml(jMo);
                    mmlVarQdl.mzz(jMo);
                }
                mzz.qdl(qdl.this.jpc, 5);
                com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(qdl.this.jpc, 5);
                if (qdl.this.gt != null) {
                    qdl.this.gt.qdl(3);
                }
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, long j) {
            String unused = qdl.this.qdl;
            if (!qdl.this.aaj.get()) {
                qdl.this.koa();
            }
            qdl.this.uw = false;
            qdl.this.lnr.removeCallbacks(qdl.this.wak);
            qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.wd != null) {
                        qdl.this.wd.ud();
                    }
                }
            });
            if (!qdl.this.aaj.get()) {
                qdl.this.hzv = j;
                qdl qdlVar2 = qdl.this;
                qdlVar2.qdl(qdlVar2.gy);
                qdl.this.hzv();
            }
            if (qdl.this.vu != null) {
                qdl.this.vu.lnr();
            }
            mzz.qdl(qdl.this.jpc, 0);
            if (qdl.this.gt != null) {
                qdl.this.gt.qdl(1);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void ud(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            String unused = qdl.this.qdl;
            qdl.this.lnr.removeCallbacks(qdl.this.wak);
            qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.4
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.wd != null) {
                        qdl.this.wd.ud();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, com.bykv.vk.openvk.qdl.qdl.qdl.lnr.qdl qdlVar2) {
            mml mmlVarQdl;
            String unused = qdl.this.qdl;
            qdlVar2.qdl();
            qdlVar2.ud();
            qdlVar2.lnr();
            if (ljh.mo(qdl.this.jpc)) {
                com.bytedance.sdk.openadsdk.yt.lnr.lnr(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.5
                    @Override // com.bytedance.sdk.openadsdk.yt.mml
                    public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                        com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar3 = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                        try {
                            qdlVar3.ud("video_player");
                            qdlVar3.mml(gy.qdl(qdl.this.jpc));
                            qdlVar3.qdl(BuildConfig.VERSION_NAME);
                        } catch (Throwable unused2) {
                        }
                        return qdlVar3;
                    }
                });
            }
            qdl.this.lnr.removeCallbacks(qdl.this.wak);
            qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.6
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.wd != null) {
                        qdl.this.wd.ud();
                    }
                    if (qdl.this.koa != null) {
                        qdl.this.koa.ud(qdl.this.ag, com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(qdl.this.tvp, qdl.this.ekw));
                    }
                }
            });
            qdl.this.qdl(qdlVar2);
            mzz.qdl(qdl.this.jpc, 6);
            com.bytedance.sdk.openadsdk.bch.qdl.lnr.ud(qdl.this.jpc);
            if (qdl.this.vu != null) {
                qdl.this.vu.qdl(14);
            }
            if (qdl.this.gt != null) {
                qdl.this.gt.qdl(4);
            }
            com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = qdl.this.jpc.zm();
            if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
                return;
            }
            mmlVarQdl.qdl(com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.GENERAL_LINEAR_AD_ERROR);
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, boolean z) {
            String unused = qdl.this.qdl;
            qdl.this.lnr.removeCallbacks(qdl.this.wak);
            qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.wd != null) {
                        qdl.this.wd.ud();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void lnr(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            String unused = qdl.this.qdl;
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i, int i2) {
            String unused = qdl.this.qdl;
            tvp.qdl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.mo == null) {
                        return;
                    }
                    try {
                        final float fMml = qdl.this.mo.mml();
                        final float fMzz = qdl.this.mo.mzz();
                        if (fMml == 0.0f || fMzz == 0.0f) {
                            return;
                        }
                        qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (qdl.this.wak()) {
                                    if (!aaj.ud(qdl.this.jpc) && qdl.this.bch.mo != 4) {
                                        if (!aaj.lnr(qdl.this.jpc)) {
                                            if (qdl.this.jpc.fzn() != 3) {
                                                if (qdl.this.jpc.fzn() == 0) {
                                                    qdl.this.lnr(fMml, fMzz);
                                                    return;
                                                } else {
                                                    qdl.this.ud(fMml, fMzz);
                                                    return;
                                                }
                                            }
                                            qdl.this.qdl(true, fMml, fMzz);
                                            return;
                                        }
                                        qdl.this.qdl(true, fMml, fMzz);
                                        return;
                                    }
                                    qdl.this.qdl(true, fMml, fMzz);
                                    return;
                                }
                                qdl.this.qdl(fMml, fMzz);
                            }
                        });
                    } catch (Throwable th) {
                        com.bytedance.sdk.component.utils.aaj.lnr(qdl.this.qdl, th.getMessage());
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i, int i2, int i3) {
            String unused = qdl.this.qdl;
            qdl.this.uw = true;
            qdl.this.cx();
            qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.wd != null) {
                        qdl.this.wd.yt();
                    }
                }
            });
            mzz.qdl(qdl.this.jpc, 3);
            if (qdl.this.vu != null) {
                qdl.this.vu.qdl(4);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, int i) {
            String unused = qdl.this.qdl;
            qdl.this.uw = false;
            qdl.this.lnr.removeCallbacks(qdl.this.wak);
            qdl.this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.10
                @Override // java.lang.Runnable
                public void run() {
                    if (qdl.this.wd != null) {
                        qdl.this.wd.ud();
                    }
                }
            });
            mzz.qdl(qdl.this.jpc, 0);
            if (qdl.this.vu != null) {
                qdl.this.vu.qdl(5);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void qdl(final com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar, long j, long j2) {
            mml mmlVarQdl;
            if (Math.abs(j - qdl.this.tvp) < 50) {
                return;
            }
            if (!qdl.this.aaj.get()) {
                qdl.this.koa();
            }
            qdl qdlVar2 = qdl.this;
            qdlVar2.qdl(qdlVar2.gy);
            qdl.this.qdl(j, j2);
            qdl.this.ud(j, j2);
            com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = qdl.this.jpc.zm();
            if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                mmlVarQdl.qdl(j, j2, qdl.this.vu);
            }
            if (!this.ud || j2 - j >= 500) {
                return;
            }
            this.ud = false;
            qdl.this.lnr.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.1.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1.this.qdl(qdlVar);
                }
            }, 1000L);
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void mml(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            mml mmlVarQdl;
            com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = qdl.this.jpc.zm();
            if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                mmlVarQdl.ud(qdl.this.tvp);
            }
            mzz.qdl(qdl.this.jpc, 3);
            if (qdl.this.vu != null) {
                qdl.this.vu.qdl(0);
            }
            if (qdl.this.gt != null) {
                qdl.this.gt.qdl(2);
            }
        }

        @Override // com.bykv.vk.openvk.qdl.qdl.qdl.qdl.InterfaceC0177qdl
        public void mzz(com.bykv.vk.openvk.qdl.qdl.qdl.qdl qdlVar) {
            mzz.qdl(qdl.this.jpc, 0);
            if (qdl.this.vu != null) {
                qdl.this.vu.qdl(1);
            }
            if (qdl.this.gt != null) {
                qdl.this.gt.qdl(1);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.exu.mml.lnr.ud
        public void qdl(int i, int i2) {
            qdl.this.wc();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc() {
        ud(this.gy);
        this.bch.mzz = this.mo.aaj();
        if (ljh.mo(this.jpc)) {
            com.bytedance.sdk.openadsdk.yt.lnr.qdl(new com.bytedance.sdk.openadsdk.yt.mml() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.2
                @Override // com.bytedance.sdk.openadsdk.yt.mml
                public com.bytedance.sdk.openadsdk.yt.ud.qdl generatorModel() {
                    com.bytedance.sdk.openadsdk.yt.ud.qdl qdlVar = new com.bytedance.sdk.openadsdk.yt.ud.qdl();
                    try {
                        qdlVar.ud("video_player");
                        qdlVar.mml(gy.qdl(qdl.this.jpc));
                        qdlVar.qdl(BuildConfig.VERSION_NAME);
                    } catch (Throwable unused) {
                    }
                    return qdlVar;
                }
            });
        }
        kdv();
        this.aaj.set(false);
        this.cx.set(false);
        qdl(this.gy);
    }

    public void fco() {
        this.mrf.qdl((com.bykv.vk.openvk.qdl.qdl.qdl.qdl) null, 0, 0);
    }

    protected void qdl(boolean z, float f, float f2) {
        try {
            Objects.toString(this.jpc.ji());
            if (!gt() || z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (gy() != null) {
                    if (gy() instanceof TextureView) {
                        ((TextureView) gy()).setLayoutParams(layoutParams);
                    } else if (gy() instanceof SurfaceView) {
                        ((SurfaceView) gy()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.xmv.getLayoutParams();
                    if (this.xmv.getHeight() > 0) {
                        float fMin = Math.min(this.xmv.getWidth() / f, this.xmv.getHeight() / f2);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (f * fMin);
                            layoutParams.height = (int) (f2 * fMin);
                            if (gy() instanceof TextureView) {
                                ((TextureView) gy()).setLayoutParams(layoutParams);
                            } else if (gy() instanceof SurfaceView) {
                                ((SurfaceView) gy()).setLayoutParams(layoutParams);
                            }
                            if (this.bch.mo == 4) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.xmv.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl(this.qdl, "changeSize error", th);
        }
    }

    public qdl(Context context, ViewGroup viewGroup, ljh ljhVar, wd wdVar) {
        super(context, ljhVar, viewGroup);
        this.ax = 0L;
        this.ag = 0L;
        this.wc = false;
        this.hzv = 0L;
        this.fco = false;
        this.cx = new AtomicBoolean(false);
        this.mrf = new AnonymousClass1();
        this.wak = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.4
            @Override // java.lang.Runnable
            public void run() {
                if (qdl.this.koa != null) {
                    qdl.this.jtx();
                    qdl.this.koa.qdl();
                }
            }
        };
        this.gy = wdVar;
        this.om = ljhVar.fz();
        if (ljhVar.qh() && this.xmv != null) {
            if (this.vu == null) {
                this.vu = mo.qdl();
            }
            this.vu.qdl(this.xmv, ljhVar);
        }
        this.wd = new com.bytedance.sdk.openadsdk.core.exu.ud.mzz(context.getApplicationContext(), new rdp(context), true, 17, this.jpc, this);
        this.wd.qdl(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.qdl.qdl, com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public boolean qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar) {
        int iWs;
        super.qdl(lnrVar);
        if (this.mo != null) {
            return false;
        }
        lnrVar.jtx();
        if (TextUtils.isEmpty(lnrVar.jtx())) {
            return false;
        }
        lnrVar.ud(com.bytedance.sdk.openadsdk.jyq.qdl.qdl("player_force_raw_url", 0) == 1);
        ud(lnrVar);
        lnrVar.mml(1);
        this.fco = !lnrVar.jtx().startsWith(ProxyConfig.MATCH_HTTP);
        if (this.vu != null) {
            if (this.bch.mo == 1) {
                iWs = this.jpc.qg();
            } else {
                iWs = this.jpc.ws();
            }
            if (this.xmv != null) {
                try {
                    int iOk = this.jpc.ok();
                    if (iOk == 7 || iOk == 8) {
                        View viewQdl = ag.qdl(this.xmv, (Class<? extends View>) com.bytedance.sdk.openadsdk.component.reward.view.tvp.class);
                        if (viewQdl != null) {
                            View viewFindViewById = viewQdl.findViewById(jtx.fs);
                            View viewFindViewById2 = viewQdl.findViewById(jtx.uj);
                            View viewFindViewById3 = viewQdl.findViewById(jtx.fc);
                            this.vu.qdl(viewFindViewById2, FriendlyObstructionPurpose.OTHER);
                            this.vu.qdl(viewFindViewById, FriendlyObstructionPurpose.OTHER);
                            this.vu.qdl(viewFindViewById3, FriendlyObstructionPurpose.OTHER);
                            if (this.yh) {
                                View viewQdl2 = ag.qdl(this.xmv, (Class<? extends View>) com.bytedance.sdk.openadsdk.core.rq.ud.mzz.qdl.class);
                                if (viewQdl2 instanceof com.bytedance.sdk.openadsdk.core.rq.ud.mzz.qdl) {
                                    this.vu.qdl(((com.bytedance.sdk.openadsdk.core.rq.ud.mzz.qdl) viewQdl2).getMarkView(), FriendlyObstructionPurpose.OTHER);
                                }
                            }
                        }
                        Iterator<View> it = ag.qdl(this.xmv, 1).iterator();
                        while (it.hasNext()) {
                            this.vu.qdl(it.next(), FriendlyObstructionPurpose.OTHER);
                        }
                    } else if (iOk == 3) {
                        Iterator<View> it2 = ag.qdl(this.xmv, 2).iterator();
                        while (it2.hasNext()) {
                            this.vu.qdl(it2.next(), FriendlyObstructionPurpose.OTHER);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            this.vu.qdl(iWs > 0, iWs / 1000.0f);
        }
        kdv();
        if (lnrVar.to() > 0) {
            this.tvp = lnrVar.to();
            this.to = Math.max(this.to, this.tvp);
        }
        if (this.tvp == this.ekw) {
            this.tvp = 0L;
        }
        if (this.wd != null) {
            this.wd.qdl();
            this.wd.wd();
            this.wd.lnr(lnrVar.jpc(), lnrVar.tvp());
            this.wd.lnr(this.xmv);
        }
        this.mo = new lnr();
        this.mo.qdl(this.mrf);
        jl();
        this.ag = 0L;
        om();
        return true;
    }

    private void om() {
        this.mo.lnr(ekw());
        this.mo.qdl(this.bch);
        this.ax = System.currentTimeMillis();
        this.wd.lnr(8);
        this.wd.lnr(0);
        qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.3
            @Override // java.lang.Runnable
            public void run() {
                if (qdl.this.mo == null) {
                    return;
                }
                qdl.this.ax = System.currentTimeMillis();
                qdl.this.wd.mml(0);
                qdl.this.mo.qdl(true, qdl.this.tvp, qdl.this.jtx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx() {
        int iXi;
        int i = this.bch.mo;
        if (i == 2 || i == 1) {
            iXi = yt.mml().xi() * 1000;
        } else {
            iXi = i == 4 ? yt.mml().tvp(String.valueOf(this.om)) : 5000;
        }
        this.lnr.removeCallbacks(this.wak);
        this.lnr.postDelayed(this.wak, iXi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        if (this.wd == null) {
            return;
        }
        this.lnr.removeCallbacks(this.wak);
        this.wd.ud();
        this.ag = System.currentTimeMillis() - this.ax;
        if (!this.wc) {
            this.wc = true;
            ud(this.ekw, this.ekw);
            long j = this.ekw;
            this.tvp = j;
            this.to = j;
            ud(this.gy);
        }
        if (this.koa != null) {
            this.koa.qdl(this.ag, com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(this.tvp, this.ekw));
        }
        this.rdp = true;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void lnr() {
        mml mmlVarQdl;
        if (this.wd != null) {
            this.wd.qdl();
            this.wd.bjy();
            this.wd.jl();
        }
        Boolean.valueOf(this.exu);
        if (this.mo != null) {
            if (this.mo.wd()) {
                if (this.exu) {
                    if (com.bytedance.sdk.openadsdk.core.tvp.oth()) {
                        this.mo.ud(3);
                        this.mo.qdl(false, this.mo.yt(), this.jtx);
                    } else {
                        aaj();
                    }
                } else {
                    ud(this.hkc);
                }
                Boolean.valueOf(this.exu);
            } else {
                this.mo.qdl(false, this.tvp, this.jtx);
            }
        }
        if (this.wc || !this.aaj.get()) {
            return;
        }
        vu();
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = this.jpc.zm();
        if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        mmlVarQdl.lnr(mo());
    }

    public void mrf() {
        mml mmlVarQdl;
        if (this.wc || !this.aaj.get()) {
            return;
        }
        vu();
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = this.jpc.zm();
        if (mmlVarZm == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        mmlVarQdl.lnr(mo());
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void mml() {
        if (this.mo == null) {
            return;
        }
        this.mo.fs();
        this.mo = null;
        if (this.wd != null) {
            this.wd.tvp();
        }
        this.lnr.removeCallbacks(this.wak);
        this.lnr.removeCallbacksAndMessages(null);
        if (this.vu != null) {
            this.vu.mml();
        }
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void qdl(boolean z, int i) {
        mml();
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void mzz() {
        mml();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wak() {
        return this.jpc.nv() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(float f, float f2) {
        try {
            if (gy() != null && this.mo != null && this.xmv != null) {
                float width = this.xmv.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.xmv.getHeight();
                if (f3 <= f2 / (1.0f * height)) {
                    width = f * (height / f2);
                } else {
                    height = f2 * (width / f);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                if (gy() instanceof TextureView) {
                    ((TextureView) gy()).setLayoutParams(layoutParams);
                } else if (gy() instanceof SurfaceView) {
                    ((SurfaceView) gy()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl(this.qdl, "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean gt() {
        return gy() == null || this.mo == null || (!com.bytedance.sdk.openadsdk.core.rq.mml.qdl(this.jpc.ra()) ? this.jpc.xdk() != null : this.jpc.kr() != null) || this.jpc.gg() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(float f, float f2) {
        try {
            Objects.toString(this.jpc.ji());
            if (gt()) {
                return;
            }
            int[] iArrUd = ax.ud(yt.qdl());
            boolean z = false;
            boolean z2 = this.jpc.jb() == 1;
            float f3 = iArrUd[0];
            float f4 = iArrUd[1];
            if (z2) {
                if (f > f2) {
                    qdl(f3, f4, f, f2, true);
                    return;
                }
            } else if (f < f2) {
                qdl(f3, f4, f, f2, false);
                return;
            }
            float f5 = f / f2;
            float f6 = f3 / f4;
            if (z2) {
                if (f6 < 0.5625f && f5 == 0.5625f) {
                    f = (9.0f * f4) / 16.0f;
                    z = true;
                    f2 = f4;
                }
            } else if (f6 > 1.7777778f && f5 == 1.7777778f) {
                f2 = (9.0f * f3) / 16.0f;
                z = true;
                f = f3;
            }
            if (z) {
                f3 = f;
                f4 = f2;
            }
            int i = (int) f3;
            int i2 = (int) f4;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(13);
            if (gy() != null) {
                if (gy() instanceof TextureView) {
                    ((TextureView) gy()).setLayoutParams(layoutParams);
                } else if (gy() instanceof SurfaceView) {
                    ((SurfaceView) gy()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.xmv.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i2;
                    layoutParams2.width = i;
                    this.xmv.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl(this.qdl, "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lnr(float f, float f2) {
        try {
            if (gy() != null && this.mo != null) {
                boolean z = this.jpc.jb() == 1;
                int[] iArrUd = ax.ud(yt.qdl());
                qdl(iArrUd[0], iArrUd[1], f, f2, z);
            }
        } catch (Throwable unused) {
        }
    }

    private void qdl(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = this.jpc.tdy().lnr();
                f4 = this.jpc.tdy().ud();
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            if (gy() != null) {
                if (gy() instanceof TextureView) {
                    ((TextureView) gy()).setLayoutParams(layoutParams);
                } else if (gy() instanceof SurfaceView) {
                    ((SurfaceView) gy()).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.xmv.getLayoutParams();
                if (!com.bytedance.sdk.component.adexpress.mml.ud.qdl(yt.qdl()) || this.xmv.getHeight() <= 0 || layoutParams2 == null) {
                    return;
                }
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
                this.xmv.setLayoutParams(layoutParams2);
            }
        }
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
            lnr();
            if (this.wd != null) {
                this.wd.ud(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(final long j, final long j2) {
        this.jpc.lnr(j);
        this.tvp = j;
        this.ekw = j2;
        final int iQdl = com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(j, j2);
        this.lnr.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.exu.mml.qdl.5
            @Override // java.lang.Runnable
            public void run() {
                qdl.this.wd.qdl(j, j2);
                qdl.this.wd.qdl(iQdl);
                try {
                    if (qdl.this.koa != null) {
                        qdl.this.koa.qdl(j, j2);
                    }
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.aaj.qdl(qdl.this.qdl, "onProgressUpdate error: ", th);
                }
            }
        });
    }

    public com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud gy() {
        if (this.wd != null) {
            return this.wd.exu();
        }
        return null;
    }

    public void ax() {
        if (this.vu != null) {
            this.vu.qdl(2);
        }
    }

    public void ag() {
        if (this.vu != null) {
            this.vu.qdl(13);
        }
    }

    public void qdl(InterfaceC0231qdl interfaceC0231qdl) {
        this.gt = interfaceC0231qdl;
    }

    public void mo(boolean z) {
        this.yh = z;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr
    public void qdl() {
        if (this.mo != null) {
            wc();
            this.mo.tvp();
        }
    }
}
