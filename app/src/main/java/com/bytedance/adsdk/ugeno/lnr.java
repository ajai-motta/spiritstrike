package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.adjust.sdk.Constants;
import com.bytedance.adsdk.ugeno.core.fs;
import com.bytedance.adsdk.ugeno.wd.jpc;
import com.google.common.base.Ascii;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class lnr extends com.bytedance.adsdk.ugeno.ud.qdl<com.bytedance.adsdk.ugeno.mo.ud> {
    private int ca;
    private String dps;
    private float fge;
    private int gsp;
    private com.bytedance.adsdk.ugeno.ud.lnr hd;
    private JSONArray hr;
    private boolean iw;
    private float kr;
    private boolean lme;
    private float se;
    private String syy;
    private boolean tdy;
    private float vc;
    private float xx;
    private float ygv;

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(JSONObject jSONObject) {
    }

    public lnr(Context context) {
        super(context);
        this.iw = true;
        this.lme = true;
        this.kr = 0.0f;
        this.xx = 2000.0f;
        this.syy = Constants.NORMAL;
        this.tdy = true;
        this.ca = Color.parseColor("#666666");
        this.gsp = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public View qdl() {
        this.mzz = new com.bytedance.adsdk.ugeno.mo.ud(this.ud);
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).qdl((mml) this);
        return this.mzz;
    }

    public void qdl(com.bytedance.adsdk.ugeno.mo.lnr lnrVar) {
        if (this.mzz != 0) {
            ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).setOnPageChangeListener(lnrVar);
        }
    }

    public void qdl(int i) {
        if (this.mzz != 0) {
            ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).exu(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl, com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        JSONArray jSONArray = this.hr;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).wd((int) this.se).jpc((int) this.vc).tvp((int) this.fge).lnr(this.tdy).mzz(this.gsp).mo(this.ca).lnr(this.syy).mml(this.iw).mzz(this.ygv).qdl(this.lme).mml((int) this.xx).lnr(this.tdy);
        for (int i = 0; i < this.hr.length(); i++) {
            fs fsVar = new fs(this.ud);
            fsVar.qdl(this.zvv);
            com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVarUd = fsVar.ud(this.hd.rc(), (com.bytedance.adsdk.ugeno.ud.lnr<View>) null);
            fsVar.ud(this.hr.optJSONObject(i));
            ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).qdl(lnrVarUd);
        }
        if (this.lme) {
            ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).lnr();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        this.hd = lnrVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        super.qdl(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    b = 0;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 1;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 2;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 3;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 4;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 5;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = 6;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 7;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 8;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 9;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = 10;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = Ascii.VT;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = Ascii.FF;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = Ascii.CR;
                }
                break;
        }
        switch (b) {
            case 0:
                this.kr = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f);
                break;
            case 1:
                this.ca = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                break;
            case 2:
                this.fge = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 3:
                this.syy = str2;
                break;
            case 4:
                this.dps = str2;
                break;
            case 5:
                this.tdy = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, true);
                break;
            case 6:
                this.vc = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 7:
                this.iw = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, true);
                break;
            case 8:
                this.xx = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 500.0f);
                break;
            case 9:
                this.ygv = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 1.0f);
                break;
            case 10:
                this.se = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 11:
                this.gsp = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                break;
            case 12:
                this.lme = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, true);
                break;
            case 13:
                this.hr = com.bytedance.adsdk.ugeno.wd.ud.qdl(str2, (JSONArray) null);
                break;
        }
    }
}
