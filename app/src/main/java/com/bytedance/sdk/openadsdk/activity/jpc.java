package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.activity.ud;
import com.bytedance.sdk.openadsdk.component.reward.rq;
import com.bytedance.sdk.openadsdk.core.ljh;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.oth;
import com.bytedance.sdk.openadsdk.core.widget.jl;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.bytedance.sdk.openadsdk.utils.uw;
import com.facebook.AccessToken;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class jpc implements com.bytedance.sdk.openadsdk.core.exu.mml.ud {
    public String bjy;
    protected boolean exc;
    public boolean exu;
    public boolean fs;
    protected IListenerManager jl;
    protected final AtomicBoolean jpc = new AtomicBoolean(false);
    public boolean jtx = false;
    private jl lnr;
    protected ljh mo;
    private boolean qdl;
    public String rdp;
    public int rq;
    public int to;
    protected com.bytedance.sdk.openadsdk.component.reward.qdl.qdl tvp;
    private boolean ud;
    protected final ud wd;
    public boolean yt;

    protected abstract boolean a_();

    public void ax() {
    }

    public abstract String b_();

    protected abstract String bch();

    public boolean bqt() {
        return false;
    }

    public abstract void c_();

    public abstract boolean d_();

    public void exu() {
    }

    public boolean fco() {
        return false;
    }

    public boolean hzv() {
        return false;
    }

    public void jyq() {
    }

    public abstract boolean ljh();

    public void lnr() {
    }

    public abstract void lnr(boolean z);

    public void mml() {
    }

    public abstract com.bytedance.sdk.openadsdk.component.reward.view.tvp qdl();

    public void qdl(Activity activity) {
    }

    public void qdl(Activity activity, Bundle bundle) {
    }

    protected abstract void qdl(Activity activity, ud.mzz mzzVar);

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void qdl(Bundle bundle) {
    }

    public void qdl(jpc jpcVar, jpc jpcVar2, ud.mzz mzzVar) {
    }

    public abstract void qdl(String str);

    public void qdl(Map<String, Object> map, float f, float f2) {
    }

    public void rc() {
    }

    public void rdp() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void ud(int i) {
    }

    public abstract com.bytedance.sdk.openadsdk.component.reward.qdl.qdl xmv();

    public jpc(ud udVar, ljh ljhVar, int i, int i2, boolean z) {
        this.wd = udVar;
        this.mo = ljhVar;
        this.to = i;
        this.rq = i2;
        this.yt = z;
    }

    public boolean ag() {
        ud udVar = this.wd;
        return udVar != null && udVar.qdl(this, this.to);
    }

    public boolean wc() {
        return this.yt;
    }

    public int om() {
        return this.rq;
    }

    protected void qdl(boolean z, boolean z2, boolean z3, int i) {
        this.wd.qdl(this, z, z2, z3, i);
    }

    public ud cx() {
        return this.wd;
    }

    public void aaj() {
        jl jlVar = this.lnr;
        if (jlVar != null) {
            jlVar.tvp();
            this.lnr = null;
        }
        this.qdl = false;
    }

    public final void ud(Activity activity, ud.mzz mzzVar) {
        if (this.qdl) {
            return;
        }
        this.qdl = true;
        qdl(activity, mzzVar);
    }

    public Activity yh() {
        return this.wd.wd();
    }

    protected void wak() {
        if (this.mo != null) {
            com.bytedance.sdk.openadsdk.mo.ud.qdl().qdl("videoForceBreak", this.mo);
        }
        this.wd.mo();
    }

    protected void ud(String str) {
        if (a_()) {
            qdl(str, false, 0, "", 0, "");
        } else {
            lnr(str);
        }
    }

    private void qdl(final String str, final boolean z, final int i, final String str2, final int i2, final String str3) {
        fco.lnr(new com.bytedance.sdk.component.jpc.jpc("Reward_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.jpc.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    jpc.this.lnr(0).executeRewardVideoCallback(jpc.this.bch(), str, z, i, str2, i2, str3);
                } catch (Throwable th) {
                    aaj.lnr("Scene", "rewarded_video", "executeRewardVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    private void lnr(final String str) {
        fco.lnr(new com.bytedance.sdk.component.jpc.jpc("FullScreen_executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.activity.jpc.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    jpc.this.lnr(1).executeFullVideoCallback(jpc.this.bch(), str);
                } catch (Throwable th) {
                    aaj.lnr("Scene", "fullscreen_interstitial_ad", "executeFullVideoCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    protected final IListenerManager lnr(int i) {
        if (this.jl == null) {
            this.jl = com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl().qdl(i));
        }
        return this.jl;
    }

    public void ud(Activity activity) {
        if (com.bytedance.sdk.openadsdk.jyq.qdl.jpc() && activity != null && activity.isChangingConfigurations()) {
            aaj.qdl("BVA", "callback close is invoke by config change.");
        } else if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            ud("onAdClose");
        } else {
            this.wd.exu();
        }
    }

    protected void gt() {
        ud udVar = this.wd;
        if (udVar == null || udVar.yt()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            ud("onAdShow");
        } else {
            this.wd.rdp();
        }
        this.wd.exc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void mrf() {
        irn();
    }

    protected final void irn() {
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            ud("onAdVideoBarClick");
        } else {
            this.wd.fs();
        }
    }

    protected final void qdl(boolean z, int i, String str, int i2, String str2, int i3) {
        if (this.wd.bjy()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
            qdl("onRewardVerify", z, i, str, i2, str2);
        } else {
            this.wd.qdl(this, z, i, str, i2, str2);
        }
        rq.qdl(this.mo, z, i3);
    }

    public void xi() {
        mml(0);
    }

    public void mml(final int i) {
        if (this.wd.rq().getBoolean("reward_verify", false) || this.wd.bjy() || this.wd.rq().getBoolean("user_has_give_up_reward", false)) {
            return;
        }
        this.wd.rq().putBoolean("reward_verify", true);
        if (xmv() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVarXmv = xmv();
        if (yt.mml().jtx(String.valueOf(qdlVarXmv.mo))) {
            qdl(true, qdlVarXmv.ud.lte(), qdlVarXmv.ud.mlb(), 0, "", i);
        } else {
            yt.lnr().qdl(jjk(), new oth.ud() { // from class: com.bytedance.sdk.openadsdk.activity.jpc.3
                @Override // com.bytedance.sdk.openadsdk.core.oth.ud
                public void qdl(int i2, String str) {
                    jpc.this.qdl(false, 0, "", i2, str, i);
                }

                @Override // com.bytedance.sdk.openadsdk.core.oth.ud
                public void qdl(ljh.ud udVar) {
                    jpc.this.qdl(udVar.ud, udVar.lnr.qdl(), udVar.lnr.ud(), 0, "", i);
                }
            });
        }
    }

    public JSONObject jjk() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oversea_version_type", 1);
            jSONObject.put("sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("media_extra", this.bjy);
            jSONObject.put("play_start_ts", 0);
            jSONObject.put("play_end_ts", 0);
            jSONObject.put(AccessToken.USER_ID_KEY, this.rdp);
            jSONObject.put("trans_id", uw.qdl().replace("-", ""));
            if (xmv() != null) {
                com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVarXmv = xmv();
                jSONObject.put(TypedValues.TransitionType.S_DURATION, (int) qdlVarXmv.bch.xmv());
                jSONObject.put("reward_name", qdlVarXmv.ud.mlb());
                jSONObject.put("reward_amount", qdlVarXmv.ud.lte());
                jSONObject.put("network", com.bytedance.sdk.component.utils.jl.lnr(qdlVarXmv.om));
                JSONObject jSONObjectUzn = qdlVarXmv.ud.uzn();
                jSONObjectUzn.put("gaid", com.bytedance.sdk.openadsdk.exc.qdl.ud.qdl.qdl().ud());
                jSONObject.put("extra", jSONObjectUzn);
                jSONObject.put("video_duration", qdlVarXmv.ud.tdy().mo());
                String strMml = "unKnow";
                int iJle = qdlVarXmv.ud.jle();
                if (iJle == 2) {
                    strMml = gy.ud();
                } else if (iJle == 1) {
                    strMml = gy.mml();
                }
                jSONObject.put("user_agent", strMml);
            }
            return jSONObject;
        } catch (Throwable th) {
            aaj.qdl("Scene", "", th);
            return null;
        }
    }

    public void zlt() {
        aaj.qdl("Scene", "tryPreloadVideo scene = " + this + ",index =" + this.to);
        com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = com.bytedance.sdk.openadsdk.core.model.ljh.qdl(CacheDirFactory.getICacheDir(this.mo.lhl()).qdl(), this.mo);
        udVarQdl.qdl("material_meta", this.mo);
        udVarQdl.qdl("ad_slot", this.mo.ji());
        com.bytedance.sdk.openadsdk.core.exu.mzz.qdl.qdl(udVarQdl, new com.bykv.vk.openvk.qdl.qdl.qdl.mzz.ud() { // from class: com.bytedance.sdk.openadsdk.activity.jpc.4
            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i) {
            }

            @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mzz.qdl.InterfaceC0176qdl
            public void qdl(com.bykv.vk.openvk.qdl.qdl.qdl.lnr.lnr lnrVar, int i, String str) {
            }
        });
    }

    public void mzz(boolean z) {
        this.ud = z;
    }

    public boolean taz() {
        return this.ud;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, int i, int i2) {
        this.mo = ljhVar;
        this.to = i;
        this.rq = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void gy() {
        mml(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public List<com.bytedance.sdk.openadsdk.core.model.ljh> tid() {
        return this.wd.xmv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void sy() {
        ud udVar = this.wd;
        if (udVar != null) {
            udVar.qdl(this, true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public final void car() {
        irn();
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar = this.tvp;
        if (qdlVar == null || qdlVar.ud == null) {
            return;
        }
        this.tvp.ud.cor();
        this.tvp.ud.lnr(true);
        if (com.bytedance.sdk.openadsdk.core.model.ljh.mzz(this.tvp.ud)) {
            com.bytedance.sdk.openadsdk.mml.lnr.ud(this.tvp.ud, this.tvp.mzz, this.tvp.ud.wb());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.mml.ud
    public void rq() {
        if (this.jpc.compareAndSet(false, true)) {
            aaj.qdl("BVA", "invoke callback onShow, ".concat(String.valueOf(this)));
            gt();
        }
    }

    public void mo(boolean z) {
        this.exc = z;
    }

    public void qdl(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        if (qdlVar == null) {
            return;
        }
        try {
            int iRc = this.wd.rc();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("click_countdown_remaining", Math.max(iRc, 0));
            com.bytedance.sdk.openadsdk.mml.lnr.mzz(this.mo, qdlVar.mzz, jSONObject);
        } catch (Throwable unused) {
        }
        ud(qdlVar);
    }

    public void ud(com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVar) {
        if (ag()) {
            return;
        }
        ud.mzz mzzVar = new ud.mzz(8, qdlVar);
        mzzVar.mml = qdlVar.gt;
        ud udVar = this.wd;
        if (udVar != null) {
            udVar.ud(this, mzzVar);
        }
    }

    public boolean mlb() {
        com.bytedance.sdk.openadsdk.component.reward.qdl.qdl qdlVarXmv;
        jl jlVar;
        if (wc() || (qdlVarXmv = xmv()) == null || !qdlVarXmv.ud.vg() || (jlVar = this.lnr) == null) {
            return false;
        }
        return jlVar.qdl(qdlVarXmv.ag);
    }

    public void lte() {
        if (wc() || xmv() == null || xmv().ax == null || !xmv().ud.vg()) {
            return;
        }
        jl jlVar = new jl(xmv(), new jl.qdl() { // from class: com.bytedance.sdk.openadsdk.activity.jpc.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
            public void qdl() {
                jpc jpcVar = jpc.this;
                jpcVar.ud(jpcVar.xmv());
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
            public void ud() {
                if (jpc.this.wd != null) {
                    jpc.this.wd.koa();
                }
                jpc.this.mzz(1);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
            public void lnr() {
                if (jpc.this.wd != null) {
                    jpc.this.wd.vu();
                }
                jpc.this.mzz(2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
            public int mml() {
                if (jpc.this.wd != null) {
                    return jpc.this.wd.rc();
                }
                return 0;
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
            public void mzz() {
                jpc.this.mzz(2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.jl.qdl
            public void mo() {
                jpc.this.mzz(1);
            }
        });
        this.lnr = jlVar;
        jlVar.qdl(xmv().ax);
    }

    public void mzz(int i) {
        ud udVar = this.wd;
        if (udVar != null) {
            udVar.qdl(i);
        }
    }
}
