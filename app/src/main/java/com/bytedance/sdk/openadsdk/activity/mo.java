package com.bytedance.sdk.openadsdk.activity;

import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.core.bqt;
import com.bytedance.sdk.openadsdk.core.model.aaj;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends qdl {
    private boolean aaj;

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    protected boolean a_() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void gy() {
    }

    public mo(ud udVar, ljh ljhVar, int i, int i2, boolean z) {
        super(udVar, ljhVar, i, i2, z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl
    public void ud() {
        if (!ljh.mzz(this.tvp.ud) && !this.tvp.lnr) {
            this.tvp.fco.qdl(null, "X");
        } else {
            this.tvp.fco.qdl(null, TTAdDislikeToast.getSkipText());
        }
        this.tvp.fco.mzz(true);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl, com.bytedance.sdk.openadsdk.activity.jpc
    public void mml() {
        super.mml();
        if (this.tvp == null || !ud(this.tvp.ud) || qdl(this.tvp.ud)) {
            return;
        }
        if (this.aaj) {
            this.aaj = false;
            wak();
        } else if (this.tvp.hkc.bqt()) {
            wak();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public String b_() {
        return "fullscreen_interstitial_ad";
    }

    private boolean qdl(ljh ljhVar) {
        return ljhVar == null || ljhVar.nv() == 100.0f;
    }

    private boolean ud(ljh ljhVar) {
        if (ljhVar == null) {
            return false;
        }
        return yt.mml().aaj(String.valueOf(this.tvp.mo));
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl
    protected void mzz() {
        final View view = this.tvp.gy.to();
        if (view != null) {
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.mo.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (mo.this.tvp.hkc.aaj() && mo.this.tvp.to.get()) {
                        boolean zExu = mo.this.tvp.hzv.exu();
                        mo.this.tvp.hkc.mo(zExu);
                        mo.this.tvp.gy.mo(8);
                        mo.this.tvp.cx.sendEmptyMessageDelayed(600, 5000L);
                        if (!ljh.lnr(mo.this.tvp.ud)) {
                            return;
                        }
                        if (ljh.lnr(mo.this.tvp.ud) && zExu) {
                            return;
                        }
                    }
                    mo.this.tvp.hkc.jyq();
                    mo.this.tvp.hzv.rq();
                    mo.this.tvp.vu.mo();
                    mo.this.wak();
                }
            };
            view.setOnClickListener(onClickListener);
            view.setTag(view.getId(), onClickListener);
        }
        this.tvp.fco.qdl(new com.bytedance.sdk.openadsdk.component.reward.top.ud() { // from class: com.bytedance.sdk.openadsdk.activity.mo.2
            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void qdl(View view2) {
                com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
                if (aaj.qdl(mo.this.tvp.ud) && !mo.this.tvp.jtx.get()) {
                    mo.this.wak();
                    return;
                }
                mo.this.tvp.bch.rc();
                bjy.qdl qdlVar = new bjy.qdl();
                qdlVar.ud(mo.this.tvp.bch.fs());
                qdlVar.mml(mo.this.tvp.bch.uw());
                qdlVar.lnr(mo.this.tvp.bch.jtx());
                qdlVar.lnr(3);
                qdlVar.mml(mo.this.tvp.bch.bch());
                qdlVar.qdl(mo.this.tvp.bch.ud());
                com.bytedance.sdk.openadsdk.mml.mzz.qdl.qdl.qdl(mo.this.tvp.bch.jpc(), qdlVar, mo.this.tvp.bch.mzz());
                bqt.lnr(mo.this.tvp.mo);
                mo.this.tvp.bch.qdl("skip", false);
                mo.this.tvp.fco.mml(false);
                if (mo.this.tvp.lnr) {
                    mo.this.qdl(true, 4);
                } else {
                    mo.this.wak();
                }
                if (mo.this.tvp.ud != null && mo.this.tvp.ud.zm() != null && mo.this.tvp.bch != null && (mmlVarQdl = mo.this.tvp.ud.zm().qdl()) != null) {
                    mmlVarQdl.mo(mo.this.tvp.bch.fs());
                    mmlVarQdl.mzz(mo.this.tvp.bch.fs());
                }
                com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(mo.this.tvp.ud, 5);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void qdl(View view2, String str) {
                mo.this.qdl(str);
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void ud(View view2) {
                mo.this.c_();
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void lnr(View view2) {
                View view3 = view;
                if (view3 != null) {
                    view3.performClick();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.top.ud
            public void mml(View view2) {
                mo moVar = mo.this;
                moVar.qdl(moVar.tvp);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void c_() {
        this.tvp.kdv.qdl(this.ud);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public boolean d_() {
        return this.tvp.gt;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void qdl(String str) {
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm;
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        this.tvp.gt = !this.tvp.gt;
        if (this.tvp.bqt != null && this.tvp.bqt.qdl() != null) {
            this.tvp.bqt.qdl().setSoundMute(this.tvp.gt);
        }
        if (this.ud != null && this.ud.mml() != null) {
            this.ud.mml().qdl(this.tvp.gt);
        }
        this.tvp.bch.qdl(this.tvp.gt, str);
        this.tvp.hkc.mzz(this.tvp.gt);
        if (this.tvp.ud == null || (mmlVarZm = this.tvp.ud.zm()) == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        if (this.tvp.gt) {
            mmlVarQdl.jpc(this.tvp.bch.fs());
        } else {
            mmlVarQdl.tvp(this.tvp.bch.fs());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.qdl
    public FrameLayout jpc() {
        if (this.mo.mo()) {
            if (this.ud != null && (this.ud instanceof com.bytedance.sdk.openadsdk.component.reward.ud.jpc) && this.tvp != null && !this.tvp.jjk) {
                return ((com.bytedance.sdk.openadsdk.component.reward.ud.jpc) this.ud).vu();
            }
            if (this.tvp == null || this.tvp.bqt == null) {
                return null;
            }
            return this.tvp.bqt.ud();
        }
        if (this.ud != null && (this.ud instanceof com.bytedance.sdk.openadsdk.component.reward.ud.jpc)) {
            return ((com.bytedance.sdk.openadsdk.component.reward.ud.jpc) this.ud).vu();
        }
        if (this.tvp == null || this.tvp.gy == null) {
            return null;
        }
        return this.tvp.gy.mo();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc, com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mrf() {
        if (this.tvp.ud.nv() != 100.0f) {
            this.aaj = true;
        }
        super.mrf();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.jpc
    public void ax() {
        super.ax();
        this.mzz = false;
        this.tvp.bqt.ud(false);
        this.tvp.bch.wc();
    }
}
