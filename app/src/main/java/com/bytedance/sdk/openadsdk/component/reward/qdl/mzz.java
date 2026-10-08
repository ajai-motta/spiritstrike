package com.bytedance.sdk.openadsdk.component.reward.qdl;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.model.aaj;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.mml.ud;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.oth;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mzz {
    private qdl lnr;
    private final com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdl;
    private final com.bytedance.sdk.openadsdk.component.reward.view.jpc ud;

    public interface qdl {
        void qdl(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar, int i);
    }

    public mzz(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        this.qdl = qdlVar;
        this.ud = new com.bytedance.sdk.openadsdk.component.reward.view.jpc(qdlVar);
    }

    public void qdl() {
        this.ud.qdl();
    }

    public void ud() {
        this.ud.lnr();
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.lnr.mzz mzzVar) {
        this.ud.qdl(mzzVar);
    }

    public void qdl(boolean z, boolean z2, boolean z3, com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar, int i) {
        if (this.qdl != null) {
            com.bytedance.sdk.openadsdk.mo.ud.qdl().qdl("videoForceBreak", this.qdl.ud);
            com.bytedance.sdk.openadsdk.bch.qdl.lnr.ud(this.qdl.ud);
        }
        Objects.toString(udVar);
        if (this.qdl.ag.isFinishing() || udVar == null) {
            return;
        }
        this.qdl.gy.fs();
        if (z2) {
            this.qdl.bjy.set(true);
        }
        boolean z4 = false;
        if (this.qdl.nz && !this.qdl.jtx.get() && !aaj.fs(this.qdl.ud) && !aaj.rq(this.qdl.ud) && (!aaj.ud(this.qdl.ud) || !this.qdl.bjy.get() || !this.qdl.yt.get())) {
            if ((aaj.ud(this.qdl.ud) && z3) || !ud(z2)) {
                return;
            }
            if (aaj.ud(this.qdl.ud) || aaj.mml(this.qdl.ud) || aaj.wd(this.qdl.ud)) {
                this.qdl.fco.lnr(false);
                udVar.bjy();
                return;
            }
        }
        if (this.qdl.ag.isDestroyed() || this.qdl.ag.isFinishing()) {
            return;
        }
        if (this.qdl.ud.au()) {
            com.bytedance.sdk.openadsdk.component.reward.view.to toVar = this.qdl.bqt;
            com.bytedance.sdk.openadsdk.core.tvp.lnr brandBannerController = (toVar == null || toVar.qdl() == null) ? null : toVar.qdl().getBrandBannerController();
            if (brandBannerController != null) {
                brandBannerController.ud();
            }
            this.qdl.ag.finish();
            return;
        }
        qdl qdlVar = this.lnr;
        if (qdlVar != null) {
            qdlVar.qdl(z, z2, z3, udVar, i);
            return;
        }
        this.qdl.bch.exc();
        this.qdl.hkc.oth();
        this.qdl.rq.set(false);
        if (!this.qdl.qk || !(this.qdl.lq instanceof com.bytedance.sdk.openadsdk.activity.mzz) || this.qdl.lq.ag()) {
            this.qdl.fs.set(false);
        }
        this.qdl.kdv.qdl();
        fs fsVar = this.qdl.fco;
        if (!this.qdl.wd && this.qdl.ud.tvf()) {
            z4 = true;
        }
        fsVar.qdl(z4);
        if (this.qdl.to.getAndSet(true)) {
            return;
        }
        if (vu.ud(this.qdl.ud) && this.qdl.rzg) {
            qdl(z, z2, z3, i);
            this.qdl.gy.mml(8);
            this.qdl.fco.lnr(true);
            this.qdl.gy.lnr();
            if (this.qdl.bqt != null) {
                this.qdl.bqt.mo();
            }
            this.qdl.xmv.to();
            return;
        }
        qdl(z, udVar);
    }

    private void qdl(boolean z, boolean z2, boolean z3, int i) {
        int i2;
        HashMap map = new HashMap();
        if (this.qdl.hkc.koa()) {
            i2 = 1;
        } else {
            i2 = !this.qdl.hkc.rdp() ? -1 : 2;
        }
        map.put("webview_state", Integer.valueOf(i2));
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(this.qdl.ud, this.qdl.mzz, z, z2, z3, this.qdl.ag.isFinishing(), i, map);
    }

    public void qdl(boolean z, com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        this.qdl.jl.set(z);
        udVar.rdp();
        this.qdl.ud.uj();
        this.qdl.fco.mml(false);
        this.qdl.fco.lnr(false);
        this.qdl.hkc.ljh();
        if (this.qdl.gy.bjy != null) {
            this.qdl.gy.bjy.mzz();
        }
        this.qdl.gy.lnr();
        if (this.qdl.bqt != null) {
            this.qdl.bqt.mo();
        }
        if (this.qdl.xmv != null) {
            this.qdl.xmv.lnr(jpc.ud);
        }
        if (!TextUtils.isEmpty(ljh.qdl(this.qdl.om, this.qdl.ud))) {
            oth.qdl(this.qdl.ag, vu.fs(this.qdl.ud), this.qdl.ud, ud.qdl.lnr);
            return;
        }
        if (ljh.lnr(this.qdl.ud) && this.qdl.hzv != null) {
            this.qdl.hzv.mo();
        }
        if (ljh.qdl(this.qdl.ud) || ((!ljh.lnr(this.qdl.ud) && this.qdl.hkc.rc()) || !ljh.qdl(this.qdl.ud, this.qdl.hkc.exu(), this.qdl.hkc.hkc(), this.qdl.hzv.fs(), this.qdl.hkc.bch()))) {
            mml();
            return;
        }
        if (!ljh.mml(this.qdl.ud) && !ljh.lnr(this.qdl.ud)) {
            this.qdl.hkc.qdl(true, 0, (String) null);
        }
        ud(udVar);
        qdl(udVar);
    }

    void qdl(com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        if (!ljh.lnr(this.qdl.ud)) {
            this.qdl.hzv.qdl(8);
            this.qdl.hkc.qdl(0);
            this.qdl.hkc.kdv();
        } else {
            this.qdl.hkc.qdl(8);
            this.qdl.hzv.qdl(0);
            this.qdl.hzv.wd();
        }
        if (this.qdl.wd) {
            ax.qdl((View) udVar.rdp, 0);
            this.qdl.gy.mo(8);
        }
        this.qdl.gy.mml(8);
        this.qdl.gy.wd();
        if (ljh.lnr(this.qdl.ud)) {
            this.qdl.cx.sendEmptyMessageDelayed(800, 100L);
            return;
        }
        this.qdl.hkc.qdl(this.qdl.gt, true);
        this.qdl.hkc.lnr(true);
        this.qdl.hkc.ud(true);
        hkc hkcVarTvp = this.qdl.hkc.tvp();
        if (hkcVarTvp != null) {
            hkcVarTvp.qdl("prerender_page_show", (JSONObject) null);
        }
        if (!vu.ud(this.qdl.ud)) {
            this.qdl.fco.lnr(false);
        }
        com.bytedance.sdk.component.tvp.mo moVarJpc = this.qdl.hkc.jpc();
        if (moVarJpc == null || moVarJpc.getWebView() == null) {
            return;
        }
        moVarJpc.exu();
        moVarJpc.getWebView().resumeTimers();
    }

    public boolean ud(com.bytedance.sdk.openadsdk.component.reward.ud.ud udVar) {
        this.qdl.jpc = mo();
        int i = this.qdl.jpc;
        boolean z = false;
        if (this.qdl.ud.jtx()) {
            return false;
        }
        if (this.qdl.jpc == -1) {
            if (this.qdl.lq == null && vu.jpc(this.qdl.ud) && this.qdl.hkc.exu()) {
                udVar.ljh();
            } else {
                udVar.bjy();
                z = true;
            }
        } else if (this.qdl.jpc >= 0) {
            this.qdl.jyq.set(false);
            Message messageObtain = Message.obtain();
            messageObtain.what = TypedValues.TransitionType.TYPE_DURATION;
            messageObtain.arg1 = this.qdl.jpc;
            this.qdl.cx.sendMessage(messageObtain);
            if (!vu.wd(this.qdl.ud)) {
                z = true;
            }
        }
        if (this.qdl.hkc.aaj() || !z || this.qdl.kab == null || !this.qdl.mml()) {
            return true;
        }
        this.qdl.kab.qdl(this.qdl.jpc);
        return true;
    }

    private int mo() {
        int iGuw = this.qdl.ud.guw();
        if (iGuw <= 5000 && iGuw >= 0) {
            if (iGuw < 1000) {
                iGuw += 1000;
            }
            int iQdl = com.bytedance.sdk.openadsdk.core.yt.mml().qdl(this.qdl.ud.fz());
            if (iQdl <= 5000 && iQdl >= 0) {
                if (iQdl < 1000) {
                    iQdl += 1000;
                }
                return Math.min(iGuw, iQdl);
            }
        }
        return -1;
    }

    public void lnr() {
        this.ud.mml();
    }

    public void mml() {
        qdl(true);
    }

    public void qdl(boolean z) {
        if (!ljh.mml(this.qdl.ud)) {
            this.qdl.hkc.qdl(false, TTAdConstant.DOWNLOAD_URL_CODE, "end_card_timeout");
        }
        this.qdl.hkc.uw();
        this.qdl.hkc.qdl(8);
        this.qdl.hzv.qdl(8);
        if (this.qdl.wd) {
            ax.qdl((View) this.qdl.en.rdp, 8);
            this.qdl.gy.mo(0);
        }
        this.qdl.gy.mml(8);
        if (this.qdl.ud.uj()) {
            if (!this.ud.qdl(this.qdl.bch)) {
                this.qdl.ag.finish();
            }
        } else {
            com.bytedance.sdk.openadsdk.activity.jpc jpcVar = this.qdl.lq;
            if (jpcVar != null) {
                this.ud.qdl(jpcVar.cx().tvp());
            }
            this.ud.ud();
        }
        this.qdl.gy.wd();
        if (z) {
            ud(this.qdl.en);
        }
        this.qdl.fco.lnr(false);
        this.qdl.vu.qdl(this.qdl.ud.mq());
    }

    public void qdl(qdl qdlVar) {
        this.lnr = qdlVar;
    }

    public boolean mzz() {
        return this.ud.mzz();
    }

    private boolean ud(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.view.mml mmlVarQdl;
        if (!aaj.lnr(this.qdl.ud) || (mmlVarQdl = this.qdl.bqt.qdl()) == null || mmlVarQdl.mml != 0 || z) {
            return true;
        }
        this.qdl.fco.lnr(false);
        return false;
    }
}
