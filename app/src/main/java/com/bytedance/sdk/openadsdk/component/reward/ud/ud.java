package com.bytedance.sdk.openadsdk.component.reward.ud;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.compose.animation.core.AnimationConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.tvp.mo;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.component.utils.ljh;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.activity.ud;
import com.bytedance.sdk.openadsdk.common.exu;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.component.reward.view.tvp;
import com.bytedance.sdk.openadsdk.core.model.aaj;
import com.bytedance.sdk.openadsdk.core.model.jl;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.rq;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.mml.ud;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.jtx;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ud extends com.bytedance.sdk.openadsdk.component.reward.ud.qdl {
    private com.bytedance.sdk.openadsdk.fs.mo bjy;
    public com.bytedance.sdk.openadsdk.core.widget.ud exu;
    protected com.bytedance.sdk.openadsdk.core.lnr.mzz fs;
    public LinearLayout rdp;
    protected String rq;

    public interface qdl {
        void qdl(boolean z);
    }

    public void exu() {
    }

    protected boolean koa() {
        return true;
    }

    public qdl mml() {
        return null;
    }

    public abstract boolean mo();

    public abstract boolean mzz();

    public abstract void qdl(FrameLayout frameLayout);

    public abstract void wd();

    public ud(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        super(qdlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.ud.qdl
    public void qdl(com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar, koa koaVar) {
        super.qdl(udVar, koaVar);
        if (this.qdl.ud.mo() && this.qdl.nz) {
            this.qdl.hkc.qdl(false);
        }
    }

    public void qdl(tvp tvpVar) {
        qdl(tvpVar, this.qdl);
    }

    public RFEndCardBackUpLayout jpc() {
        return new RFEndCardBackUpLayout(this.qdl.om);
    }

    public View tvp() {
        PAGLogoView pAGLogoViewCreatePAGLogoViewByMaterial;
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(this.qdl.ag);
        lnrVar.setId(jtx.uj);
        com.bytedance.sdk.openadsdk.core.mo.mml mmlVarUd = com.bytedance.sdk.openadsdk.core.widget.mo.ud(this.qdl.ag);
        mmlVarUd.setId(520093708);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        layoutParams.topMargin = ax.ud(this.qdl.ag, 20.0f);
        layoutParams.rightMargin = ax.ud(this.qdl.ag, 16.0f);
        mmlVarUd.setLayoutParams(layoutParams);
        mmlVarUd.setContentDescription(ljh.qdl(this.qdl.ag, "tt_ad_close_text"));
        mmlVarUd.setVisibility(8);
        if (this.qdl.lq == null || !this.qdl.lq.cx().bch()) {
            pAGLogoViewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.qdl.ag, this.qdl.ud);
            pAGLogoViewCreatePAGLogoViewByMaterial.setId(520093757);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, ax.ud(this.qdl.ag, 14.0f));
            layoutParams2.gravity = BadgeDrawable.BOTTOM_START;
            pAGLogoViewCreatePAGLogoViewByMaterial.setLayoutParams(layoutParams2);
        } else {
            pAGLogoViewCreatePAGLogoViewByMaterial = null;
        }
        com.bytedance.sdk.openadsdk.core.mo.mml mmlVar = new com.bytedance.sdk.openadsdk.core.mo.mml(this.qdl.ag);
        mmlVar.setId(jtx.xmr);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(ax.ud(this.qdl.ag, 32.0f), ax.ud(this.qdl.ag, 14.0f));
        layoutParams3.gravity = BadgeDrawable.BOTTOM_END;
        mmlVar.setLayoutParams(layoutParams3);
        mmlVar.setPadding(ax.ud(this.qdl.ag, 9.0f), 0, ax.ud(this.qdl.ag, 9.0f), 0);
        mmlVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (pAGLogoViewCreatePAGLogoViewByMaterial != null) {
            lnrVar.addView(pAGLogoViewCreatePAGLogoViewByMaterial);
        }
        lnrVar.addView(mmlVar);
        if (!this.qdl.ud.ax() || !this.qdl.ra || this.qdl.qdl != 1) {
            com.bytedance.sdk.openadsdk.component.reward.top.lnr lnrVar2 = new com.bytedance.sdk.openadsdk.component.reward.top.lnr(this.qdl.ag);
            lnrVar2.setId(jtx.mwc);
            lnrVar2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            lnrVar.addView(lnrVar2);
        }
        lnrVar.addView(mmlVarUd);
        return lnrVar;
    }

    public View to() {
        com.bytedance.sdk.openadsdk.core.mo.wd wdVar;
        if (this.ud.gg() != 5) {
            wdVar = new com.bytedance.sdk.openadsdk.core.mo.wd(this.qdl.ag);
            wdVar.setId(jtx.fc);
        } else {
            wdVar = null;
        }
        Objects.toString(wdVar);
        return wdVar;
    }

    public void rq() {
        this.qdl.koa.qdl(this.qdl.mml);
        this.qdl.gy.ud();
        this.qdl.mrf.qdl();
        if (!this.qdl.ud.uj()) {
            if (this.qdl.wd && TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.ljh.qdl(this.qdl.om, this.ud))) {
                fs();
            }
            this.qdl.hkc.qdl();
            this.qdl.hzv.qdl();
        }
        this.qdl.xmv.wd();
        this.qdl.fco.qdl();
        if (vu.mo(this.qdl.ud)) {
            this.qdl.gy.mml();
            ax.qdl((View) this.qdl.hkc.jpc(), 4);
        }
        if (aaj.mml(this.qdl.ud) || aaj.ud(this.qdl.ud) || aaj.wd(this.qdl.ud)) {
            return;
        }
        this.qdl.gy.qdl(ax.ud(this.qdl.om, this.qdl.tid), ax.ud(this.qdl.om, this.qdl.sy));
        this.qdl.uw.qdl();
        if (this.qdl.zy) {
            this.qdl.gy.qdl(0);
        }
    }

    public void fs() {
        LinearLayout linearLayout = (LinearLayout) this.qdl.ax.findViewById(jtx.exu);
        this.rdp = linearLayout;
        ax.qdl((View) linearLayout, 8);
        this.qdl.ijp = new exu(this.qdl.ag, this.qdl.ud, "landingpage_endcard");
        this.qdl.ijp.lnr().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.ud.ud.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ud.this.qdl.gy.to().performClick();
            }
        });
        this.rdp.addView(this.qdl.ijp.mzz(), new LinearLayout.LayoutParams(-1, -1));
        this.qdl.hkc.qdl(this.qdl.ijp);
    }

    public void qdl(boolean z, boolean z2, boolean z3, int i) {
        this.qdl.mrf.qdl(z, z2, z3, this, i);
    }

    public void rdp() {
        com.bytedance.sdk.openadsdk.core.widget.ud udVar = this.exu;
        if (udVar == null || !udVar.isShowing()) {
            return;
        }
        this.exu.dismiss();
    }

    public void bjy() {
        if (!this.qdl.wd && this.qdl.mml()) {
            this.qdl.fco.mzz();
            if (this.qdl.ra && (this.qdl.lq instanceof com.bytedance.sdk.openadsdk.activity.qdl)) {
                return;
            }
            this.qdl.gy.mo(0);
        }
    }

    public void jtx() {
        this.to.removeMessages(AnimationConstants.DefaultDurationMillis);
    }

    public void yt() {
        if (this.qdl.lq != null || ((!vu.ud(this.ud) && !vu.lnr(this.ud)) || (vu.jpc(this.ud) && this.qdl.hkc.vu() && !this.qdl.hkc.ekw()))) {
            jl();
        }
        if (this.qdl == null) {
            return;
        }
        if (this.qdl.kab != null) {
            this.qdl.kab.qdl();
        }
        this.qdl.qdl();
    }

    protected void jl() {
        if (this.qdl.to.get() && !this.qdl.wd && this.qdl.jyq.getAndSet(false) && (this.qdl.jpc >= 0 || this.qdl.jpc == -1)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = TypedValues.TransitionType.TYPE_DURATION;
            messageObtain.arg1 = this.qdl.jpc;
            this.qdl.cx.sendMessage(messageObtain);
        }
        if (this.qdl.tvp <= 0 || !this.qdl.oth.getAndSet(false)) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        messageObtain2.what = 900;
        messageObtain2.arg1 = this.qdl.tvp;
        this.qdl.cx.sendMessage(messageObtain2);
    }

    public void exc() {
        if (this.qdl == null) {
            return;
        }
        this.qdl.irn = false;
        boolean z = this.qdl.irn;
        boolean z2 = this.qdl.gt;
        if (!this.qdl.rq.get()) {
            this.qdl.bch.bjy();
        }
        jtx();
        this.qdl.hkc.jtx();
        this.qdl.xmv.jpc();
        this.qdl.oth.set(true);
        if (this.qdl.to.get()) {
            this.qdl.jyq.set(true);
        }
        if (this.qdl.kab != null) {
            this.qdl.kab.ud();
        }
        this.qdl.ud();
    }

    public void aaj() {
        if (this.qdl == null) {
            return;
        }
        if (this.qdl.gy != null) {
            this.qdl.gy.jtx();
        }
        boolean z = this.qdl.gt;
        this.qdl.ekw.qdl();
        DeviceUtils.wd();
        this.qdl.hkc.bjy();
        if (this.qdl.gt) {
            this.qdl.ag.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.ud.ud.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ud.this.qdl.ekw.qdl() > 0) {
                        ud.this.qdl.ekw.qdl(false);
                    }
                }
            });
        }
    }

    public void jyq() {
        ud(false);
    }

    public void ud(boolean z) {
        if (this.qdl.bqt != null && !z) {
            this.qdl.bqt.mo();
        }
        if (this.qdl.gy != null) {
            this.qdl.gy.rdp();
        }
        this.qdl.bch.ekw();
        if (!mzz()) {
            this.qdl.to.get();
        }
        if (this.qdl.hkc != null) {
            this.qdl.hkc.rq();
        }
        if (this.qdl.xmv != null) {
            this.qdl.xmv.lnr(com.bytedance.sdk.openadsdk.component.reward.qdl.jpc.qdl);
        }
        if (this.qdl.gy != null) {
            this.qdl.gy.fs();
        }
        if (this.qdl.mrf != null) {
            this.qdl.mrf.lnr();
        }
        if (this.qdl.kab != null) {
            this.qdl.kab.lnr();
        }
    }

    public void oth() {
        if (!this.qdl.xmv.rq() && yt.mml().jyq(String.valueOf(this.qdl.mo)) == 1) {
            int iQdl = qdl(this.qdl);
            if (ud(this.qdl)) {
                lnr(this.qdl);
            } else if (qdl(this.qdl, iQdl)) {
                mml(this.qdl);
            }
        }
    }

    private int qdl(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        if (vu.lnr(qdlVar.ud)) {
            return qdlVar.ud.sxp();
        }
        if (qdlVar.mml) {
            return qdlVar.ud.qg();
        }
        return qdlVar.ud.ws();
    }

    private boolean ud(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        return qdlVar.gy != null && qdlVar.gy.tvp();
    }

    private void lnr(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        if (qdlVar.gy == null || qdlVar.gy.to() == null) {
            return;
        }
        qdlVar.gy.to().performClick();
    }

    private boolean qdl(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar, int i) {
        if (i == -1) {
            return false;
        }
        return (!qdlVar.to.get() || vu.lnr(qdlVar.ud)) && ((qdlVar.bch != null && (qdlVar.bch.exu() > (((long) i) * 1000) ? 1 : (qdlVar.bch.exu() == (((long) i) * 1000) ? 0 : -1)) >= 0) || (qdlVar.xmv != null && qdlVar.xmv.mml()));
    }

    private void mml(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        if (qdlVar.fco != null) {
            qdlVar.fco.mml();
        }
    }

    public void ljh() {
        this.qdl.fco.lnr();
        this.qdl.fco.mzz(true);
    }

    public void bch() {
        this.fs = this.qdl.vu.lnr();
    }

    public void uw() {
        if (!mo() && ((this instanceof wd) || (this instanceof jpc))) {
            this.qdl.vu.ud();
            return;
        }
        if (!this.tvp.qdl(this.mzz.rdp(), false)) {
            this.to.removeMessages(AnimationConstants.DefaultDurationMillis);
            if (this.qdl.ra && (this.qdl.lq instanceof com.bytedance.sdk.openadsdk.activity.qdl)) {
                ((com.bytedance.sdk.openadsdk.activity.qdl) this.qdl.lq).uw();
            } else {
                qdl(ud.C0269ud.qdl);
                this.mzz.qdl(!this.mzz.hzv() ? 1 : 0, 4);
            }
        }
        if (this.qdl == null || this.qdl.ud == null || this.qdl.kab == null || !this.qdl.ud.au()) {
            return;
        }
        this.qdl.kab.qdl(this.qdl.bch.xmv());
    }

    public void qdl(int i) {
        this.mzz.exc();
        qdl(false, true, false, i);
        if (this.qdl.mml) {
            this.tvp.ud(10000);
        }
    }

    public void xmv() {
        lnr();
        if (!this.qdl.ud.uj() && koa()) {
            bqt();
        }
        if (koa()) {
            this.qdl.mrf.ud();
        }
        if (aaj.mml(this.qdl.ud) || aaj.wd(this.qdl.ud)) {
            this.to.sendEmptyMessageDelayed(500, 100L);
        }
        this.qdl.gy.qdl(this.qdl.taz == 100.0f);
        bch();
        wd();
    }

    public final void bqt() {
        if (this.qdl.ag.isFinishing()) {
            return;
        }
        this.qdl.hkc.to();
        String str = this.qdl.mml ? "reward_endcard" : "fullscreen_endcard";
        this.qdl.hkc.qdl(this.bjy, str, this.qdl.wc);
        if (this.qdl.rzg) {
            this.qdl.xmv.qdl(this.qdl.gt);
        }
        this.qdl.hkc.qdl(str, this.qdl.wc);
        this.qdl.hkc.mzz();
    }

    public void qdl(Message message) {
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        int i = message.what;
        int i2 = message.what;
        if (i2 == 1) {
            ljh();
            return;
        }
        if (i2 == 300) {
            if (this.qdl.ra && (this.qdl.lq instanceof com.bytedance.sdk.openadsdk.activity.qdl)) {
                ((com.bytedance.sdk.openadsdk.activity.qdl) this.qdl.lq).uw();
            } else {
                qdl(ud.C0269ud.ud);
                this.qdl.bch.qdl(!this.qdl.bch.hzv() ? 1 : 0, 1 ^ (this.qdl.bch.hzv() ? 1 : 0));
            }
            com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm = this.qdl.ud.zm();
            if (mmlVarZm != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
                mmlVarQdl.qdl(com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.GENERAL_LINEAR_AD_ERROR);
            }
            if (this.qdl.gy == null || this.qdl.gy.bjy == null) {
                return;
            }
            this.qdl.gy.bjy.to();
            return;
        }
        if (i2 == 400) {
            this.qdl.bch.exc();
            qdl(false, true, false, 3);
            return;
        }
        if (i2 == 500) {
            if (!vu.mzz(this.qdl.ud)) {
                this.qdl.fco.lnr(false);
            }
            com.bytedance.sdk.component.tvp.mo moVarJpc = this.qdl.hkc.jpc();
            if (moVarJpc != null && moVarJpc.getWebView() != null) {
                moVarJpc.exu();
                moVarJpc.getWebView().resumeTimers();
            }
            if (this.qdl.hkc.jpc() != null) {
                this.qdl.hkc.qdl(1.0f);
                this.qdl.gy.qdl(1.0f);
            }
            if (!this.qdl.ud.mq() && this.qdl.bch.mo() && this.qdl.jl.get()) {
                this.qdl.bch.exc();
                return;
            }
            return;
        }
        if (i2 == 600) {
            bjy();
            return;
        }
        if (i2 == 700) {
            int i3 = message.arg1;
            if (this.qdl.jyq.get()) {
                return;
            }
            if (i3 > 0) {
                this.qdl.fco.ud();
                this.qdl.fco.qdl((CharSequence) ((i3 / 1000) + "s"));
                this.qdl.fco.mzz(false);
                Message messageObtain = Message.obtain();
                messageObtain.what = TypedValues.TransitionType.TYPE_DURATION;
                messageObtain.arg1 = i3 - 1000;
                com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.qdl;
                qdlVar.jpc -= 1000;
                this.to.sendMessageDelayed(messageObtain, 1000L);
                return;
            }
            this.to.removeMessages(TypedValues.TransitionType.TYPE_DURATION);
            if (vu.wd(this.ud)) {
                if (this.qdl.xmv.ud() || !this.qdl.hkc.exu()) {
                    bjy();
                    return;
                } else {
                    ljh();
                    return;
                }
            }
            bjy();
            return;
        }
        if (i2 == 800) {
            if (!vu.ud(this.qdl.ud)) {
                this.qdl.fco.lnr(false);
            }
            this.qdl.gy.qdl(1.0f);
            if (!this.qdl.ud.mq() && this.qdl.bch.mo() && this.qdl.jl.get()) {
                this.qdl.bch.exc();
                return;
            }
            return;
        }
        if (i2 == 900 && !this.qdl.oth.get()) {
            int i4 = message.arg1;
            double dFco = this.qdl.bch.fco();
            qdl(i4, (long) (1000.0d * dFco));
            if (i4 > 0) {
                this.qdl.fco.ud();
                this.qdl.fco.qdl((CharSequence) ((i4 / 1000) + "s"));
                this.qdl.fco.mzz(false);
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 900;
                messageObtain2.arg1 = i4 - 1000;
                this.qdl.tvp = messageObtain2.arg1;
                this.to.sendMessageDelayed(messageObtain2, 1000L);
                if (this.qdl.ra && (this.qdl.lq instanceof com.bytedance.sdk.openadsdk.activity.qdl) && dFco > 0.0d) {
                    ((com.bytedance.sdk.openadsdk.activity.qdl) this.qdl.lq).qdl((float) (1.0d - (((double) (i4 / 1000.0f)) / dFco)));
                    return;
                }
                return;
            }
            this.to.removeMessages(900);
            bjy();
            com.bytedance.sdk.openadsdk.activity.jpc jpcVar = this.qdl.lq;
            if (this.qdl.ra && (jpcVar instanceof com.bytedance.sdk.openadsdk.activity.qdl)) {
                jpcVar.cx().qdl(jpcVar, new ud.mzz(5, this.qdl));
            }
        }
    }

    private void qdl(long j, long j2) {
        long j3 = j2 - j;
        if (this.qdl.ag instanceof TTRewardVideoActivity) {
            ((TTRewardVideoActivity) this.qdl.ag).lnr(j3, j2);
        }
    }

    static void qdl(FrameLayout frameLayout, final com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        final com.bytedance.sdk.openadsdk.core.mo.mml mmlVar;
        Context context = frameLayout.getContext();
        if (qdlVar.nz) {
            com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
            lnrVar.setId(jtx.to);
            frameLayout.addView(lnrVar, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayoutQdl = qdl(context);
            String strQdl = "";
            if (com.bytedance.sdk.openadsdk.core.model.ljh.mzz(qdlVar.ud)) {
                com.bykv.vk.openvk.qdl.qdl.qdl.lnr.ud udVarTdy = qdlVar.ud.tdy();
                if (udVarTdy != null) {
                    strQdl = udVarTdy.to();
                }
            } else {
                List<jl> listVm = qdlVar.ud.vm();
                if (listVm != null && !listVm.isEmpty()) {
                    strQdl = listVm.get(0).qdl();
                }
            }
            if (TextUtils.isEmpty(strQdl)) {
                mmlVar = null;
            } else {
                mmlVar = new com.bytedance.sdk.openadsdk.core.mo.mml(context);
                mmlVar.setId(jtx.qh);
                mmlVar.setTag(jtx.qh, strQdl);
                mmlVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                frameLayoutQdl.addView(mmlVar);
            }
            lnrVar.addView(frameLayoutQdl);
            lnrVar.addView(new rq(context), new FrameLayout.LayoutParams(-1, -1));
            com.bytedance.sdk.openadsdk.component.reward.view.mzz mzzVar = new com.bytedance.sdk.openadsdk.component.reward.view.mzz(context);
            mzzVar.setId(jtx.fs);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(mzzVar, layoutParams);
            mzzVar.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.ud.ud.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int height = view.getHeight();
                    if (height <= 0) {
                        return;
                    }
                    View viewFindViewById = qdlVar.ax.findViewById(520093757);
                    if (viewFindViewById != null) {
                        ViewGroup.LayoutParams layoutParams2 = viewFindViewById.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = height;
                        }
                    }
                    View viewFindViewById2 = qdlVar.ax.findViewById(jtx.xmr);
                    if (viewFindViewById2 != null) {
                        ViewGroup.LayoutParams layoutParams3 = viewFindViewById2.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = height;
                        }
                    }
                    View viewFindViewById3 = qdlVar.ax.findViewById(jtx.guw);
                    if (viewFindViewById3 != null) {
                        ViewGroup.LayoutParams layoutParams4 = viewFindViewById3.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = height;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.mo.mml mmlVar2 = mmlVar;
                    if (mmlVar2 != null) {
                        ViewGroup.LayoutParams layoutParams5 = mmlVar2.getLayoutParams();
                        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = height;
                            mmlVar.setLayoutParams(layoutParams5);
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar2 = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
            mzzVar2.setId(jtx.exu);
            mzzVar2.setOrientation(1);
            mzzVar2.setVisibility(8);
            frameLayout.addView(mzzVar2, new FrameLayout.LayoutParams(-1, -1));
        }
        if (qdlVar.yh) {
            com.bytedance.sdk.component.tvp.mo moVar = new com.bytedance.sdk.component.tvp.mo(context, true, mo.lnr.ENDCARD);
            moVar.setId(jtx.rdp);
            moVar.setLayerType(2, null);
            moVar.setVisibility(4);
            if (!qdlVar.ew && aaj.mo(qdlVar.ud)) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams2.topMargin = ax.ud(qdlVar.om, 58.0f);
                frameLayout.addView(moVar, layoutParams2);
            } else {
                frameLayout.addView(moVar, new FrameLayout.LayoutParams(-1, -1));
            }
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(jtx.bjy);
            frameLayout2.setVisibility(4);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            if (vu.ud(qdlVar.ud)) {
                com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar2 = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
                lnrVar2.setId(jtx.aoy);
                lnrVar2.setVisibility(4);
                frameLayout.addView(lnrVar2, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    protected static FrameLayout qdl(Context context) {
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
        lnrVar.setId(jtx.rq);
        lnrVar.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        lnrVar.setLayoutParams(layoutParams);
        return lnrVar;
    }
}
