package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.core.fs;
import com.bytedance.adsdk.ugeno.mml.mo;
import com.bytedance.adsdk.ugeno.wd.jpc;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ud extends com.bytedance.adsdk.ugeno.ud.qdl<com.bytedance.adsdk.ugeno.mo.ud> implements com.bytedance.adsdk.ugeno.mo.lnr {
    private boolean auu;
    private float ca;
    private int dps;
    private int eta;
    private String fge;
    private float gsp;
    private boolean gsv;
    private float hcs;
    private boolean hd;
    private float hr;
    private boolean hvi;
    private boolean iw;
    private JSONArray kj;
    private float kr;
    private boolean lme;
    private float nts;
    private float od;
    private int oz;
    private int se;
    private String syy;
    private String tdy;
    private boolean uvi;
    private int vc;
    private float vm;
    private int vr;
    private float xx;
    private float ygv;

    public ud(Context context) {
        super(context);
        this.dps = 0;
        this.iw = true;
        this.lme = true;
        this.kr = 500.0f;
        this.xx = 2000.0f;
        this.syy = "slide";
        this.tdy = TtmlNode.TEXT_EMPHASIS_MARK_DOT;
        this.ca = 8.0f;
        this.gsp = 8.0f;
        this.ygv = 50.0f;
        this.hr = 90.0f;
        this.hd = false;
        this.se = Color.parseColor("#666666");
        this.vc = Color.parseColor("#ffffff");
        this.fge = "row";
        this.hcs = 1.0f;
        this.od = 0.0f;
        this.vm = 0.0f;
        this.nts = 0.0f;
        this.eta = 0;
        this.vr = 0;
        this.auu = true;
        this.gsv = false;
        this.hvi = true;
        float fQdl = jpc.qdl(this.ud, 8.0f);
        this.ca = fQdl;
        this.gsp = fQdl;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public View qdl() {
        this.mzz = new com.bytedance.adsdk.ugeno.mo.ud(this.ud);
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).qdl((mml) this);
        return this.mzz;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl, com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).lnr((int) this.kr).mzz(this.gsv).qdl(this.tdy).qdl(this.ca).ud(this.gsp).lnr(this.ygv).mml(this.hr).ud(this.fge).qdl(this.dps).ud().mml(this.iw).qdl(this.lme).ud((int) this.kr).mml((int) this.xx).ud(this.auu).lnr(this.hd).mo(this.se).mzz(this.vc).jpc((int) this.vm).tvp((int) this.nts).wd((int) this.od).mzz(this.hcs).lnr(this.syy).exu(this.vr);
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).setOnPageChangeListener(this);
        if (this.eta == 1) {
            taz();
        } else {
            zlt();
        }
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).lnr();
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        if (lnrVar == null) {
            return;
        }
        this.qdl.add(lnrVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, ViewGroup.LayoutParams layoutParams) {
        if (lnrVar == null) {
            return;
        }
        this.qdl.add(lnrVar);
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
            case -1593646704:
                if (str.equals("startIndex")) {
                    b = 0;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 1;
                }
                break;
            case -1560813342:
                if (str.equals("indicatorStyle")) {
                    b = 2;
                }
                break;
            case -1557466889:
                if (str.equals("indicatorWidth")) {
                    b = 3;
                }
                break;
            case -1469828074:
                if (str.equals("indicatorHeight")) {
                    b = 4;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 5;
                }
                break;
            case -1367379379:
                if (str.equals("driveMode")) {
                    b = 6;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 7;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b = 8;
                }
                break;
            case -855614293:
                if (str.equals("disableOnInteraction")) {
                    b = 9;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 10;
                }
                break;
            case -597162967:
                if (str.equals("indicatorX")) {
                    b = Ascii.VT;
                }
                break;
            case -597162966:
                if (str.equals("indicatorY")) {
                    b = Ascii.FF;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = Ascii.CR;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = Ascii.SO;
                }
                break;
            case 95467907:
                if (str.equals("delay")) {
                    b = Ascii.SI;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = Ascii.DLE;
                }
                break;
            case 195414576:
                if (str.equals("indicatorDirection")) {
                    b = 17;
                }
                break;
            case 497874535:
                if (str.equals("allowTouchMove")) {
                    b = Ascii.DC2;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 19;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = Ascii.DC4;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = Ascii.NAK;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = Ascii.SYN;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = Ascii.ETB;
                }
                break;
        }
        switch (b) {
            case 0:
                this.vr = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0);
                break;
            case 1:
                this.se = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2, this.se);
                break;
            case 2:
                this.tdy = str2;
                break;
            case 3:
                this.ca = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 8.0f));
                break;
            case 4:
                this.gsp = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 8.0f));
                break;
            case 5:
                this.nts = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 6:
                this.eta = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0);
                break;
            case 7:
                this.syy = str2;
                break;
            case 8:
                if (TextUtils.equals(str2, "vertical")) {
                    this.dps = 1;
                } else {
                    this.dps = 0;
                }
                break;
            case 9:
                this.gsv = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, false);
                break;
            case 10:
                this.hd = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, false);
                break;
            case 11:
                this.ygv = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 50.0f);
                break;
            case 12:
                this.hr = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 90.0f);
                break;
            case 13:
                this.vm = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 14:
                this.iw = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, true);
                break;
            case 15:
                this.xx = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 2000.0f);
                break;
            case 16:
                this.kr = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 500.0f);
                break;
            case 17:
                this.fge = str2;
                break;
            case 18:
                this.auu = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, true);
                break;
            case 19:
                this.hcs = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 1.0f);
                break;
            case 20:
                this.od = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 21:
                this.vc = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2, this.vc);
                break;
            case 22:
                this.lme = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, true);
                break;
            case 23:
                this.kj = com.bytedance.adsdk.ugeno.wd.ud.qdl(str2, (JSONArray) null);
                break;
        }
    }

    private void zlt() {
        if (this.qdl == null || this.qdl.isEmpty()) {
            return;
        }
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.qdl.get(0);
        if (this.kj == null) {
            return;
        }
        for (int i = 0; i < this.kj.length(); i++) {
            fs fsVar = new fs(this.ud);
            qdl(fsVar);
            fsVar.qdl(this.zvv);
            try {
                JSONObject jSONObjectOptJSONObject = this.kj.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("$chunk")) {
                        this.mml.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.mml.put("$item", jSONObjectOptJSONObject);
                    }
                    ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).qdl(fsVar.qdl(lnrVar.rc(), this.mml, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void taz() {
        for (int i = 0; i < this.qdl.size(); i++) {
            com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.qdl.get(i);
            if (lnrVar != null) {
                fs fsVar = new fs(this.ud);
                qdl(fsVar);
                fsVar.qdl(this.zvv);
                ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).qdl(fsVar.qdl(lnrVar.rc(), this.mml, (JSONObject) null));
            }
        }
    }

    private int tid() {
        if (this.eta == 1) {
            if (this.qdl != null) {
                return this.qdl.size();
            }
            return 0;
        }
        JSONArray jSONArray = this.kj;
        if (jSONArray != null) {
            return jSONArray.length();
        }
        return 0;
    }

    public void lnr() {
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).exu(((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).getCurrentItem() + 1);
    }

    public void mml() {
        ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).exu(((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).getCurrentItem() - 1);
    }

    public void qdl(int i) {
        if (((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).getCurrentItem() != i) {
            ((com.bytedance.adsdk.ugeno.mo.ud) this.mzz).exu(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mo.lnr
    public void qdl(boolean z, int i, float f, int i2) {
        Log.d("BaseSwiper", "onPageScrolled: loop=" + z + "; position=" + i + "; positionOffset=" + f + "; positionOffsetPixels=" + i2);
        qdl(z, i, f);
    }

    @Override // com.bytedance.adsdk.ugeno.mo.lnr
    public void qdl(boolean z, int i, int i2, boolean z2, boolean z3) {
        if (this.oz != i) {
            wd(i);
            jpc(i);
            this.oz = i;
        }
        Log.d("BaseSwiper", "onPageSelected: loop=" + z + "; position=" + i + "; loopPosition=" + i2 + "; isFirst=" + z2 + "; isLast=" + z3);
    }

    @Override // com.bytedance.adsdk.ugeno.mo.lnr
    public void qdl(boolean z, int i) {
        if (i == 0) {
            if (!z) {
                this.hvi = true;
            }
            this.uvi = false;
        } else if (i == 1) {
            this.uvi = true;
        }
        Log.d("BaseSwiper", "onPageScrollStateChanged: loop=" + z + "; state=" + i);
    }

    private void wd(int i) {
        if (this.xdk == null) {
            return;
        }
        if (this.oz == 0 && i == tid() - 1) {
            this.xdk.qdl("SwiperView://reloop", 1);
            Log.d("BaseSwiper", "onPageSelected: reloop monitor FIRST_TO_LAST");
        }
        if (this.oz == tid() - 1 && i == 0) {
            this.xdk.qdl("SwiperView://reloop", 0);
            Log.d("BaseSwiper", "onPageSelected: reloop monitor LAST_TO_FIRST");
        }
    }

    private void jpc(int i) {
        if (this.xdk == null) {
            return;
        }
        this.xdk.qdl("SwiperView://slide", Integer.valueOf(this.oz), Integer.valueOf(i), Integer.valueOf(!this.uvi ? 1 : 0));
    }

    private void qdl(boolean z, int i, float f) {
        if (this.xdk != null && !z && i == tid() - 1 && f == 0.0f && this.hvi) {
            this.xdk.qdl("SwiperView://finish", new Object[0]);
            Log.d("BaseSwiper", "onPageScrolled: finish monitor");
            this.hvi = false;
        }
    }

    private void qdl(fs fsVar) {
        if (this.gsv) {
            fsVar.qdl(new com.bytedance.adsdk.ugeno.core.mzz() { // from class: com.bytedance.adsdk.ugeno.ud.1
                @Override // com.bytedance.adsdk.ugeno.core.mzz
                public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, String str, List<mo.qdl> list) {
                    if ((TextUtils.equals(str, "tap") || TextUtils.equals(str, "slide") || TextUtils.equals(str, "touchStart") || TextUtils.equals(str, "touchEnd")) && ud.this.mzz != null) {
                        ((com.bytedance.adsdk.ugeno.mo.ud) ud.this.mzz).mo();
                    }
                }
            });
        }
    }
}
