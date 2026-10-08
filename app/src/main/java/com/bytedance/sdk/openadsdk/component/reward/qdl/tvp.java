package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.app.Activity;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.activity.mml;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.widget.jl;
import com.bytedance.sdk.openadsdk.core.xmv;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class tvp {
    protected boolean bjy;
    protected AtomicBoolean exc = new AtomicBoolean(false);
    protected boolean exu;
    protected final qdl fs;
    protected com.bytedance.sdk.openadsdk.aaj.qdl.qdl jl;
    protected volatile boolean jpc;
    protected boolean jtx;
    private boolean lnr;
    private jl qdl;
    protected boolean rdp;
    protected final String rq;
    protected final ljh to;
    protected final Activity tvp;
    private mml.mo ud;
    protected FrameLayout yt;

    public void qdl(int i) {
    }

    public boolean to() {
        return false;
    }

    public int wd() {
        return 0;
    }

    public tvp(qdl qdlVar) {
        this.fs = qdlVar;
        this.tvp = qdlVar.ag;
        this.rq = qdlVar.mzz;
        ljh ljhVar = qdlVar.ud;
        this.to = ljhVar;
        this.rdp = vu.mzz(ljhVar);
    }

    public void qdl() {
        if (this.rdp && !this.exu) {
            this.exu = true;
        }
    }

    private void jtx() {
        if (this.fs.ud.vg()) {
            jl jlVar = new jl(this.fs, new jl.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.tvp.1
                @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
                public void qdl() {
                    tvp.this.fs.wc.qdl("skipToNextAd", (JSONObject) null);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
                public void ud() {
                    hkc hkcVarWd = tvp.this.jl.wd();
                    if (hkcVarWd != null) {
                        hkcVarWd.qdl("popupDidDismiss", (JSONObject) null);
                    }
                    tvp.this.mml(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
                public void lnr() {
                    com.bytedance.sdk.openadsdk.activity.jpc jpcVar;
                    com.bytedance.sdk.openadsdk.activity.ud udVarCx;
                    hkc hkcVarWd = tvp.this.jl.wd();
                    if (hkcVarWd != null) {
                        hkcVarWd.qdl("popupDidShow", (JSONObject) null);
                    }
                    if (!tvp.this.fs.ra || (jpcVar = tvp.this.fs.lq) == null || (udVarCx = jpcVar.cx()) == null) {
                        return;
                    }
                    udVarCx.vu();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
                public int mml() {
                    if (tvp.this.fs.ra) {
                        return tvp.this.fs();
                    }
                    return tvp.this.jpc();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
                public void mzz() {
                    tvp.this.yt();
                }

                @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
                public void mo() {
                    tvp.this.mml(false);
                }
            });
            this.qdl = jlVar;
            jlVar.qdl(this.fs.ax);
            hkc hkcVarWd = this.jl.wd();
            if (hkcVarWd != null) {
                hkcVarWd.qdl(new xmv() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.tvp.2
                    @Override // com.bytedance.sdk.openadsdk.core.xmv
                    public void p_() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.xmv
                    public void k_() {
                        if (tvp.this.qdl != null) {
                            tvp.this.qdl.qdl(tvp.this.fs.ag);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.xmv
                    public void l_() {
                        if (tvp.this.qdl != null) {
                            tvp.this.qdl.l_();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.xmv
                    public int m_() {
                        if (tvp.this.fs.ra) {
                            return tvp.this.fs();
                        }
                        return tvp.this.jpc();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.xmv
                    public void n_() {
                        tvp.this.yt();
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.xmv
                    public void o_() {
                        tvp.this.mml(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml(boolean z) {
        com.bytedance.sdk.openadsdk.activity.ud udVarCx;
        if (this.fs.ra) {
            com.bytedance.sdk.openadsdk.activity.jpc jpcVar = this.fs.lq;
            if (jpcVar == null || (udVarCx = jpcVar.cx()) == null) {
                return;
            }
            if (z) {
                udVarCx.koa();
            }
            udVarCx.qdl(1);
            return;
        }
        if (this instanceof wd) {
            qdl(0L);
        } else {
            mml.mo moVar = this.ud;
            if (moVar != null) {
                moVar.lnr();
            }
        }
        this.lnr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yt() {
        com.bytedance.sdk.openadsdk.activity.ud udVarCx;
        if (this.fs.ra) {
            com.bytedance.sdk.openadsdk.activity.jpc jpcVar = this.fs.lq;
            if (jpcVar == null || (udVarCx = jpcVar.cx()) == null) {
                return;
            }
            udVarCx.qdl(2);
            return;
        }
        if (this instanceof wd) {
            tvp();
        } else {
            mml.mo moVar = this.ud;
            if (moVar != null) {
                moVar.ud();
            }
        }
        this.lnr = true;
    }

    public boolean rq() {
        return !this.lnr;
    }

    public void ud(boolean z) {
        if (this.rdp && this.fs.yh) {
            this.yt = (FrameLayout) this.fs.ax.findViewById(com.bytedance.sdk.openadsdk.utils.jtx.aoy);
            qdl(z);
            jtx();
        }
    }

    protected void qdl(boolean z) {
        if (this.yt != null) {
            com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar = new com.bytedance.sdk.openadsdk.aaj.qdl.qdl(this.fs.om, this.to, this.fs.zlt, z, this.yt, false, this.fs.lq != null ? this.fs.lq.om() : 0);
            this.jl = qdlVar;
            qdlVar.qdl(this.fs.wc);
            this.jl.qdl(true, ud());
        }
    }

    protected com.bytedance.sdk.openadsdk.fs.mo ud() {
        return new com.bytedance.sdk.openadsdk.fs.mo() { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.tvp.3
            @Override // com.bytedance.sdk.openadsdk.fs.mo
            public void qdl() {
                tvp.this.fs.wc.ud(false);
            }
        };
    }

    public void lnr() {
        if (this.rdp) {
            this.jpc = true;
            lnr(this.fs.gt);
            this.jl.qdl();
            jl();
            if (vu.jpc(this.to)) {
                this.fs.hkc.mo();
            }
        }
    }

    private void jl() {
        int iIgn = this.to.ign();
        if (iIgn == -1) {
            if (vu.wd(this.to)) {
                com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar = this.jl;
                if (qdlVar != null && qdlVar.mzz()) {
                    this.fs.exc.set(true);
                    this.fs.en.bjy();
                } else {
                    this.fs.en.ljh();
                    return;
                }
            } else {
                this.fs.exc.set(true);
                this.fs.en.bjy();
            }
        } else {
            if (iIgn < 0) {
                return;
            }
            this.fs.fco.mml(false);
            if (vu.wd(this.to)) {
                com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar2 = this.jl;
                if (qdlVar2 != null && qdlVar2.mzz()) {
                    mml.mo moVar = new mml.mo(iIgn) { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.tvp.4
                        @Override // com.bytedance.sdk.openadsdk.activity.mml.mo
                        public void qdl() {
                            tvp.this.fs.cx.sendEmptyMessage(600);
                        }
                    };
                    this.ud = moVar;
                    moVar.mzz();
                } else {
                    mml.mo moVar2 = new mml.mo(iIgn) { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.tvp.5
                        @Override // com.bytedance.sdk.openadsdk.activity.mml.mo
                        public void qdl() {
                            tvp.this.fs.cx.sendEmptyMessage(1);
                        }
                    };
                    this.ud = moVar2;
                    moVar2.mzz();
                    return;
                }
            } else {
                mml.mo moVar3 = new mml.mo(iIgn) { // from class: com.bytedance.sdk.openadsdk.component.reward.qdl.tvp.6
                    @Override // com.bytedance.sdk.openadsdk.activity.mml.mo
                    public void qdl() {
                        tvp.this.fs.cx.sendEmptyMessage(600);
                    }
                };
                this.ud = moVar3;
                moVar3.mzz();
            }
        }
        if (this.fs.kab == null || !this.fs.mml()) {
            return;
        }
        this.fs.kab.qdl(iIgn);
    }

    public void mml() {
        if (!this.rdp || this.exc.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar = this.jl;
        if (qdlVar != null) {
            qdlVar.ud();
        }
        if (this.ud == null || !rq()) {
            return;
        }
        this.ud.lnr();
    }

    public void mzz() {
        if (!this.rdp || this.exc.get()) {
            return;
        }
        com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar = this.jl;
        if (qdlVar != null) {
            qdlVar.lnr();
        }
        mml.mo moVar = this.ud;
        if (moVar != null) {
            moVar.ud();
        }
    }

    public void mo() {
        if (this.rdp && !this.jtx) {
            this.jtx = true;
            com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar = this.jl;
            if (qdlVar != null) {
                qdlVar.mml();
            }
            FrameLayout frameLayout = this.yt;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            jl jlVar = this.qdl;
            if (jlVar != null) {
                jlVar.tvp();
                this.qdl = null;
            }
            mml.mo moVar = this.ud;
            if (moVar != null) {
                moVar.mml();
                this.ud = null;
            }
        }
    }

    public void qdl(long j) {
        mml.mo moVar = this.ud;
        if (moVar != null) {
            moVar.lnr();
        }
    }

    public void tvp() {
        mml.mo moVar = this.ud;
        if (moVar != null) {
            moVar.ud();
        }
    }

    public int fs() {
        com.bytedance.sdk.openadsdk.activity.ud udVarCx;
        com.bytedance.sdk.openadsdk.activity.jpc jpcVar = this.fs.lq;
        if (jpcVar == null || (udVarCx = jpcVar.cx()) == null) {
            return 0;
        }
        return udVarCx.rc();
    }

    public int jpc() {
        mml.mo moVar = this.ud;
        if (moVar != null) {
            return (int) (moVar.mo() / 1000);
        }
        return 0;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.lnr.mzz mzzVar) {
        com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar;
        if (this.rdp && (qdlVar = this.jl) != null) {
            qdlVar.qdl(mzzVar);
        }
    }

    public void lnr(boolean z) {
        if (this.rdp && this.jl != null && this.jpc) {
            this.jl.qdl(z);
        }
    }

    public boolean exu() {
        return this.jpc;
    }

    public void rdp() {
        if (this.exc.compareAndSet(false, true)) {
            com.bytedance.sdk.openadsdk.aaj.qdl.qdl qdlVar = this.jl;
            if (qdlVar != null) {
                qdlVar.qdl(true);
            }
            this.fs.hkc.wd(true);
            this.fs.mrf.qdl(true, this.fs.en);
            if (this.fs.mrf.mzz()) {
                this.fs.kab.qdl(this.fs.jpc);
                return;
            }
            this.fs.hkc.qdl(this.fs.gt, true);
            this.fs.hkc.lnr(true);
            this.fs.hkc.ud(true);
            this.fs.cx.removeMessages(600);
            return;
        }
        this.fs.hkc.wd();
    }

    public boolean bjy() {
        jl jlVar = this.qdl;
        if (jlVar != null) {
            return jlVar.to();
        }
        return false;
    }
}
