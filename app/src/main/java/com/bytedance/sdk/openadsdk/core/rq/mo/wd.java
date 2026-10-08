package com.bytedance.sdk.openadsdk.core.rq.mo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.core.bjy;
import com.bytedance.adsdk.ugeno.core.rq;
import com.bytedance.adsdk.ugeno.mml.mo;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.core.model.ekw;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.google.ads.mediation.fyber.FyberMediationAdapter;
import com.google.common.base.Ascii;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class wd extends mml {
    private com.bytedance.adsdk.ugeno.ud.lnr bqt;
    private boolean ekw;
    private float hkc;
    private float kdv;
    private com.bytedance.sdk.openadsdk.core.widget.mzz koa;
    private boolean rc;
    private com.bytedance.adsdk.ugeno.ud.lnr uw;
    private float vu;
    private com.bytedance.adsdk.ugeno.ud.lnr xmv;

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml, com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setSoundMute(boolean z) {
    }

    public wd(Context context, ljh ljhVar, boolean z, qdl qdlVar, ViewGroup viewGroup) {
        super(context, ljhVar, z, qdlVar, viewGroup);
        this.rc = false;
        this.ekw = true;
        if (TextUtils.equals(this.oth, "fullscreen_interstitial_ad")) {
            this.vu = this.mzz.ws();
        } else if (TextUtils.equals(this.oth, "rewarded_video")) {
            this.vu = this.mzz.qg();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    protected JSONObject qdl() {
        JSONObject jSONObjectLnr = this.mo.lnr();
        if (jSONObjectLnr != null) {
            return jSONObjectLnr.optJSONObject("xTemplate");
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    protected JSONObject ud() {
        return this.mo.lnr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    public void qdl(com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar) {
        this.koa = mzzVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml, com.bytedance.adsdk.ugeno.core.bjy
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, String str, mo.qdl qdlVar) {
        byte b;
        if (this.jpc == null || qdlVar == null) {
            return;
        }
        String strUd = qdlVar.ud();
        strUd.hashCode();
        int i = 7;
        int i2 = -1;
        switch (strUd.hashCode()) {
            case -1882810668:
                b = !strUd.equals("sendLogExtra") ? (byte) -1 : (byte) 0;
                break;
            case -1439599355:
                b = !strUd.equals("sendAdExtra") ? (byte) -1 : (byte) 1;
                break;
            case -511324706:
                b = !strUd.equals("openPrivacy") ? (byte) -1 : (byte) 2;
                break;
            case -55818203:
                b = !strUd.equals("pauseVideo") ? (byte) -1 : (byte) 3;
                break;
            case 3532159:
                b = !strUd.equals("skip") ? (byte) -1 : (byte) 4;
                break;
            case 72484600:
                b = !strUd.equals("openPlayable") ? (byte) -1 : (byte) 5;
                break;
            case 804386914:
                b = !strUd.equals("videoControl") ? (byte) -1 : (byte) 6;
                break;
            case 951590323:
                b = !strUd.equals("convert") ? (byte) -1 : (byte) 7;
                break;
            case 1151744482:
                b = !strUd.equals(FyberMediationAdapter.KEY_MUTE_VIDEO) ? (byte) -1 : (byte) 8;
                break;
            case 1528469391:
                b = !strUd.equals("openLinks") ? (byte) -1 : (byte) 9;
                break;
            case 1603466254:
                b = !strUd.equals("speedVideoOrTimer") ? (byte) -1 : (byte) 10;
                break;
            case 1671642405:
                b = !strUd.equals("dislike") ? (byte) -1 : Ascii.VT;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                new jpc().qdl("sendLogExtra", this.mzz, this.oth, qdlVar.lnr());
                return;
            case 1:
                new jpc().qdl("sendAdExtra", this.mzz, this.oth, qdlVar.lnr());
                return;
            case 2:
                break;
            case 3:
            case 6:
                i = 4;
                break;
            case 4:
                i = 6;
                break;
            case 5:
                if (this.tvp != null) {
                    this.tvp.ud((JSONObject) null);
                    return;
                }
                return;
            case 7:
                i = 2;
                break;
            case 8:
                i = 5;
                break;
            case 9:
                new mo().qdl(qdl(lnrVar.rq()), this.ud instanceof Activity, this.mzz, this.oth, qdlVar.lnr(), this.koa);
                return;
            case 10:
                aaj.ud("UGenRender", "onUGenEvent: " + qdlVar.lnr());
                i = 13;
                if (qdlVar.lnr() != null && !qdlVar.lnr().isEmpty()) {
                    try {
                        i2 = Integer.parseInt(qdlVar.lnr().get("switch"));
                    } catch (Throwable th) {
                        aaj.lnr("UGenRender", th);
                    }
                }
                break;
            case 11:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        this.jpc.qdl(lnrVar.rq(), i, new jtx.qdl().mml(this.rdp).lnr(this.bjy).ud(this.jtx).qdl(this.yt).ud(this.jl).qdl(this.exc).lnr(i2).qdl(this.ljh).qdl(true).qdl(lnrVar.hzv()).ud(false).qdl());
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    protected int mml() {
        if (this.mo.hkc()) {
            aaj.qdl("UGenRender", "renderWidget: only update data");
            return rdp();
        }
        return tvp();
    }

    protected int tvp() {
        exu();
        this.qdl.qdl((bjy) this);
        this.qdl.qdl((com.bytedance.adsdk.ugeno.core.jtx) this);
        if (bjy()) {
            this.qdl.qdl(new lnr());
        }
        ekw ekwVarKr = this.mzz.kr();
        if (ekwVarKr == null) {
            try {
                if (com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml.qdl(this.oth)) {
                    this.lnr = this.qdl.qdl(this.mml, this.bch, qdl(ekwVarKr));
                } else {
                    this.lnr = this.qdl.qdl(this.mml, this.bch, (JSONObject) null);
                }
            } catch (NoClassDefFoundError unused) {
                return 140;
            } catch (UnsatisfiedLinkError unused2) {
                return 139;
            } catch (Throwable unused3) {
                return 141;
            }
        } else {
            this.lnr = this.qdl.qdl(this.mml, this.bch, qdl(ekwVarKr));
        }
        if (this.lnr != null) {
            com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMo = this.lnr.mo("RVCountdown");
            this.uw = lnrVarMo;
            if (lnrVarMo == 0) {
                this.uw = this.lnr.mo("FVCountdown");
            }
            com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMo2 = this.lnr.mo("RVSkipView");
            this.xmv = lnrVarMo2;
            if (lnrVarMo2 == 0) {
                this.xmv = this.lnr.mo("FVSkipView");
            }
            this.bqt = this.lnr.mo("ProgressBar");
            fs();
        }
        if (this instanceof com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml) {
            return 0;
        }
        this.mo.ekw().ud();
        this.mo.ekw().lnr();
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    public com.bytedance.adsdk.ugeno.ud.lnr wd() {
        if (this.lnr == null) {
            return null;
        }
        return this.lnr.mo("Playable");
    }

    private void fs() {
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.uw;
        if (lnrVar != null) {
            lnrVar.lnr(8);
        }
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar2 = this.xmv;
        if (lnrVar2 != null) {
            lnrVar2.lnr(8);
        }
    }

    private void exu() {
        rq rqVar = new rq();
        HashMap map = new HashMap();
        map.put("image_info", this.mo.rq());
        map.put("cache_dir", this.mo.rdp());
        rqVar.qdl(map);
        rqVar.qdl(this.ud);
        rqVar.qdl(this.mml);
        rqVar.ud(this.bch);
        this.qdl.qdl("ad", rqVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    protected com.bytedance.adsdk.ugeno.ud.lnr jpc() {
        if (this.lnr == null) {
            return null;
        }
        return this.lnr.mo("VideoV3");
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml, com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.lnr == null) {
            return;
        }
        boolean z2 = i == 1;
        ud(charSequence, z2, i2, z);
        qdl(charSequence, z2, i2, z);
        lnr(charSequence, z2, i2, z);
    }

    private void qdl(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2;
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.uw;
        if (lnrVar != null && (lnrVar instanceof com.bytedance.sdk.openadsdk.core.rq.ud.ud)) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                aaj.lnr("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || this.rc) {
                this.uw.lnr(8);
                return;
            }
            this.uw.lnr(0);
            if (!z && this.mo.qdl() && com.bytedance.sdk.component.adexpress.mml.mo.ud(this.mo.mml())) {
                ((com.bytedance.sdk.openadsdk.core.rq.ud.ud) this.uw).rdp(String.valueOf(i));
            } else if (!"open_ad".equals(this.mo.mml()) && this.mo.qdl()) {
                this.rc = true;
                this.uw.lnr(8);
            } else {
                ((com.bytedance.sdk.openadsdk.core.rq.ud.ud) this.uw).rdp(String.valueOf(charSequence));
            }
        }
    }

    private void ud(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2;
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.bqt;
        if (lnrVar != null && (lnrVar instanceof com.bytedance.sdk.openadsdk.core.rq.ud.lnr.lnr)) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                aaj.lnr("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || z) {
                ((com.bytedance.sdk.openadsdk.core.rq.ud.lnr.lnr) this.bqt).lnr(8);
                return;
            }
            if (this.ekw) {
                this.kdv = i;
                this.ekw = false;
            }
            this.hkc = (float) (((double) this.hkc) + ((0.5d / ((double) this.kdv)) * 100.0d));
            this.qdl.ud(this.lnr, "ProgressBar://progress", Float.valueOf(this.hkc), Float.valueOf(this.vu));
            ((com.bytedance.sdk.openadsdk.core.rq.ud.lnr.lnr) this.bqt).wd(500);
            ((com.bytedance.sdk.openadsdk.core.rq.ud.lnr.lnr) this.bqt).qdl((int) this.hkc);
        }
    }

    private void lnr(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.xmv;
        if (lnrVar != null && (lnrVar instanceof com.bytedance.sdk.openadsdk.core.rq.ud.mo)) {
            int i2 = 0;
            if (!z && !z2) {
                i2 = 8;
            }
            lnrVar.lnr(i2);
        }
    }

    private Context qdl(View view) {
        Activity activityQdl = view != null ? com.bytedance.sdk.component.utils.ud.qdl(view) : null;
        return activityQdl == null ? this.ud : activityQdl;
    }

    public void to() {
        if (this.qdl != null) {
            this.qdl.qdl(this.lnr, "videoFail", new Object[0]);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.rq.mo.mml
    public void qdl(long j, long j2) {
        super.qdl(j, j2);
        if (this.qdl != null) {
            this.qdl.qdl(this.lnr, "videoProgress", Long.valueOf(j), Long.valueOf(j2));
        }
    }

    public void rq() {
        if (this.qdl != null) {
            this.qdl.qdl(this.lnr, "show", new Object[0]);
        }
    }

    private int rdp() {
        exu();
        try {
            this.qdl.qdl(this.bch, this.lnr);
            if (this.lnr != null) {
                if (TextUtils.equals(this.oth, "rewarded_video")) {
                    this.uw = this.lnr.mo("RVCountdown");
                    this.xmv = this.lnr.mo("RVSkipView");
                } else {
                    this.uw = this.lnr.mo("FVCountdown");
                    this.xmv = this.lnr.mo("FVSkipView");
                }
                fs();
            }
            if (this instanceof com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml) {
                return 0;
            }
            this.mo.ekw().ud();
            this.mo.ekw().lnr();
            return 0;
        } catch (NoClassDefFoundError unused) {
            return 140;
        } catch (UnsatisfiedLinkError unused2) {
            return 139;
        } catch (Throwable unused3) {
            return 141;
        }
    }

    private boolean bjy() {
        return this.mzz != null && this.mzz.iw() == 1;
    }

    public JSONObject qdl(ekw ekwVar) {
        if (ekwVar != null) {
            return ekwVar.mzz();
        }
        return null;
    }
}
