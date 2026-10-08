package com.bytedance.sdk.component.adexpress.dynamic.mml;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.io.encoding.Base64;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo {
    private String aaj;
    private int ag;
    private String auu;
    private int ax;
    private String bch;
    private String bjy;
    private int blf;
    private int bqt;
    private boolean bx;
    private int ca;
    private JSONObject car;
    private int cx;
    private int dk;
    private JSONObject dps;
    private String ekw;
    private int en;
    private String eta;
    private int ew;
    private String exc;
    private String exu;
    private boolean fco;
    private String fge;
    private double fs;
    private int fzn;
    private int gg;
    private int gsp;
    private String gsv;
    private boolean gt;
    private int gy;
    private boolean hcs;
    private String hd;
    private String hkc;
    private int hr;
    private String hzv;
    private int ijp;
    private int irn;
    private JSONObject iw;
    private int ji;
    private boolean jjk;
    private String jl;
    private boolean jle;
    private boolean jnw;
    private float jpc;
    private String jtx;
    private boolean jut;
    private String jyq;
    private int kab;
    private String kdv;
    private int kj;
    private double koa;
    private String kr;
    private String ljh;
    private int lme;
    private float lnr;
    private int lq;
    private boolean lte;
    private int mlb;
    private float mml;
    private float mo;
    private int mrf;
    private boolean mzz;
    private String nts;
    private int nz;
    private int od;
    private double om;
    private String oth;
    private float qdl;
    private String qk;
    private String ra;
    private String rc;
    private String rdp;
    private double rq;
    private List<qdl> rzg;
    private int se;
    private String sy;
    private JSONObject syy;
    private boolean taz;
    private int tdy;
    private boolean tid;
    private float to;
    private boolean tqd;
    private float tvp;
    private float ud;
    private boolean uw;
    private boolean vc;
    private int vm;
    private long vr = -1;
    private double vu;
    private int wak;
    private int wc;
    private float wd;
    private double xdk;
    private String xi;
    private int xmv;
    private boolean xx;
    private int ygv;
    private boolean yh;
    private String yt;
    private boolean zlt;
    private int zpu;
    private int zvv;
    private int zy;

    public static mo qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        mo moVar = new mo();
        moVar.ud(jSONObject.optString("adType", "embeded"));
        moVar.bjy(jSONObject.optString("clickArea", "creative"));
        moVar.jtx(jSONObject.optString("clickTigger", "click"));
        moVar.lnr(jSONObject.optString(TtmlNode.ATTR_TTS_FONT_FAMILY, "PingFangSC"));
        moVar.mml(jSONObject.optString(TtmlNode.ATTR_TTS_TEXT_ALIGN, "left"));
        moVar.mzz(jSONObject.optString("color", "#999999"));
        moVar.mo(jSONObject.optString("bgColor", "transparent"));
        moVar.wd(jSONObject.optString("bgImgUrl", ""));
        moVar.bqt(jSONObject.optString("bgImgData", ""));
        moVar.jpc(jSONObject.optString("borderColor", "#000000"));
        moVar.tvp(jSONObject.optString("borderStyle", "solid"));
        moVar.to(jSONObject.optString("heightMode", "auto"));
        moVar.rq(jSONObject.optString("widthMode", "fixed"));
        moVar.fs(jSONObject.optString("interactText", ""));
        moVar.lnr(jSONObject.optBoolean("isShowBgControl", false));
        moVar.exu(jSONObject.optString("interactBgColor", ""));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("interactPosition");
        if (jSONObjectOptJSONObject != null) {
            moVar.wd(jSONObjectOptJSONObject.optInt("translateY", 0));
            moVar.jpc(jSONObjectOptJSONObject.optInt("translateX", 0));
            moVar.mml(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
            moVar.mzz(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
        }
        moVar.rdp(jSONObject.optString("interactType", ""));
        moVar.mzz(jSONObject.optInt("interactSlideDirection", -1));
        moVar.yt(jSONObject.optString("justifyHorizontal", "space-around"));
        moVar.jl(jSONObject.optString("justifyVertical", "flex-start"));
        moVar.ud(jSONObject.optDouble("timingStart"));
        moVar.lnr(jSONObject.optDouble("timingEnd"));
        moVar.mml((float) jSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0.0d));
        moVar.lnr((float) jSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0.0d));
        moVar.qdl((float) jSONObject.optDouble("borderRadius", 0.0d));
        moVar.ud((float) jSONObject.optDouble("borderSize", 0.0d));
        moVar.ud(jSONObject.optBoolean("interactValidate", false));
        moVar.tvp((float) jSONObject.optDouble(TtmlNode.ATTR_TTS_FONT_SIZE, 0.0d));
        moVar.mzz((float) jSONObject.optDouble("paddingBottom", 0.0d));
        moVar.mo((float) jSONObject.optDouble("paddingLeft", 0.0d));
        moVar.wd((float) jSONObject.optDouble("paddingRight", 0.0d));
        moVar.jpc((float) jSONObject.optDouble("paddingTop", 0.0d));
        moVar.mml(jSONObject.optBoolean("lineFeed", false));
        moVar.tvp(jSONObject.optInt("lineCount", 0));
        moVar.mo(jSONObject.optDouble("lineHeight", 1.2d));
        moVar.rdp(jSONObject.optInt("letterSpacing", 0));
        moVar.mzz(jSONObject.optBoolean("isDataFixed", false));
        moVar.bjy(jSONObject.optInt(TtmlNode.ATTR_TTS_FONT_WEIGHT));
        moVar.mo(jSONObject.optBoolean("lineLimit"));
        moVar.jtx(jSONObject.optInt("position"));
        moVar.exc(jSONObject.optString("align"));
        moVar.wd(jSONObject.optBoolean("useLeft"));
        moVar.jpc(jSONObject.optBoolean("useRight"));
        moVar.tvp(jSONObject.optBoolean("useTop"));
        moVar.to(jSONObject.optBoolean("useBottom"));
        moVar.aaj(jSONObject.optString("data"));
        moVar.ud(jSONObject.optJSONObject("i18n"));
        moVar.fs(jSONObject.optInt("marginLeft"));
        moVar.exu(jSONObject.optInt("marginRight"));
        moVar.to(jSONObject.optInt("marginTop"));
        moVar.rq(jSONObject.optInt("marginBottom"));
        moVar.yt(jSONObject.optInt("tagMaxCount"));
        moVar.rq(jSONObject.optBoolean("allowTextFlow"));
        moVar.jl(jSONObject.optInt("textFlowType"));
        moVar.exc(jSONObject.optInt("textFlowDuration"));
        moVar.aaj(jSONObject.optInt("left"));
        moVar.jyq(jSONObject.optInt(TtmlNode.RIGHT));
        moVar.oth(jSONObject.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY));
        moVar.ljh(jSONObject.optInt("bottom"));
        moVar.jyq(jSONObject.optString("alignItems", "flex-start"));
        moVar.oth(jSONObject.optString("direction", ""));
        moVar.qdl(jSONObject.optBoolean("loop", false));
        moVar.bch(jSONObject.optInt("zIndex"));
        moVar.vu(jSONObject.optInt("interactVisibleTime"));
        moVar.uw(jSONObject.optInt("interactHiddenTime"));
        moVar.exu(jSONObject.optBoolean("interactEnableMask"));
        moVar.rdp(jSONObject.optBoolean("interactWontHide"));
        moVar.qdl(jSONObject.optString("bgGradient"));
        moVar.kdv(jSONObject.optInt("areaType"));
        moVar.ekw(jSONObject.optInt("interactSlideThreshold", 0));
        moVar.fco(jSONObject.optInt("interactBottomDistance", com.bytedance.sdk.component.adexpress.mml.ud() ? 0 : 120));
        moVar.jl(jSONObject.optBoolean("openPlayableLandingPage", false));
        moVar.lnr(jSONObject.optJSONObject("video"));
        moVar.mml(jSONObject.optJSONObject("image"));
        moVar.hkc(jSONObject.optInt("borderShadowExtent"));
        moVar.bjy(jSONObject.optBoolean("bgGauseBlur"));
        moVar.hzv(jSONObject.optInt("bgGauseBlurRadius"));
        moVar.jtx(jSONObject.optBoolean("showTimeProgress", false));
        moVar.yt(jSONObject.optBoolean("showPlayButton", false));
        moVar.qdl(jSONObject.optDouble("bgColorCg", 0.0d));
        moVar.mo(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        moVar.ud(jSONObject.optInt("borderTopLeftRadius", 0));
        moVar.qdl(jSONObject.optInt("borderTopRightRadius", 0));
        moVar.mml(jSONObject.optInt("borderBottomLeftRadius", 0));
        moVar.lnr(jSONObject.optInt("borderBottomRightRadius", 0));
        moVar.mzz(jSONObject.optJSONObject("interactI18n"));
        moVar.bch(jSONObject.optString("imageObjectFit"));
        moVar.uw(jSONObject.optString("interactTitle"));
        moVar.rc(jSONObject.optInt("interactTextPositionTop"));
        moVar.ljh(jSONObject.optString("imageLottieTosPath"));
        moVar.fs(jSONObject.optBoolean("animationsLoop"));
        moVar.xmv(jSONObject.optInt("lottieAppNameMaxLength"));
        moVar.koa(jSONObject.optInt("lottieAdDescMaxLength"));
        moVar.bqt(jSONObject.optInt("lottieAdTitleMaxLength"));
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("animations");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    qdl qdlVar = new qdl();
                    qdlVar.lnr(jSONObject2.optString("animationType"));
                    qdlVar.qdl(jSONObject2.optDouble("animationDuration"));
                    qdlVar.ud(jSONObject2.optDouble("animationScaleX"));
                    qdlVar.lnr(jSONObject2.optDouble("animationScaleY"));
                    qdlVar.mml(jSONObject2.optString("animationTimeFunction"));
                    qdlVar.mml(jSONObject2.optDouble("animationDelay"));
                    qdlVar.mo(jSONObject2.optInt("animationIterationCount"));
                    qdlVar.mzz(jSONObject2.optString("animationDirection"));
                    qdlVar.mzz(jSONObject2.optDouble("animationInterval"));
                    qdlVar.qdl(jSONObject2.optInt("animationBorderWidth"));
                    qdlVar.qdl(jSONObject2.optLong("key"));
                    qdlVar.ud(jSONObject2.optInt("animationEffectWidth"));
                    qdlVar.lnr(jSONObject2.optInt("animationSwing", 1));
                    qdlVar.mml(jSONObject2.optInt("animationTranslateX"));
                    qdlVar.mzz(jSONObject2.optInt("animationTranslateY"));
                    qdlVar.ud(jSONObject2.optString("animationRippleBackgroundColor"));
                    qdlVar.qdl(jSONObject2.optString("animationScaleDirection"));
                    qdlVar.wd(jSONObject2.optInt("animationFadeStart"));
                    qdlVar.jpc(jSONObject2.optInt("animationFadeEnd"));
                    qdlVar.mo(jSONObject2.optString("animationFillMode"));
                    qdlVar.tvp(jSONObject2.optInt("animationBounceHeight"));
                    if (moVar.exc() > 0.0d) {
                        qdlVar.mml(qdlVar.rdp() + moVar.exc());
                    }
                    arrayList.add(qdlVar);
                }
                moVar.qdl(arrayList);
            }
            if (jSONObject.has("triggerSlideMinDistance")) {
                moVar.xmv(jSONObject.optString("triggerSlideDirection", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                moVar.qdl(jSONObject.optLong("triggerSlideMinDistance", 0L));
            }
        } catch (Exception unused) {
        }
        return moVar;
    }

    public boolean qdl() {
        return this.tqd;
    }

    public void qdl(boolean z) {
        this.tqd = z;
    }

    public int ud() {
        return this.ca;
    }

    public void qdl(int i) {
        this.ca = i;
    }

    public int lnr() {
        return this.gsp;
    }

    public void ud(int i) {
        this.gsp = i;
    }

    public int mml() {
        return this.ygv;
    }

    public void lnr(int i) {
        this.ygv = i;
    }

    public int mzz() {
        return this.hr;
    }

    public void mml(int i) {
        this.hr = i;
    }

    public JSONObject mo() {
        return this.syy;
    }

    public int wd() {
        return this.lme;
    }

    public void mzz(int i) {
        this.lme = i;
    }

    public double jpc() {
        return this.xdk;
    }

    public void qdl(double d) {
        this.xdk = d;
    }

    public int tvp() {
        return this.tdy;
    }

    public void mo(int i) {
        this.tdy = i;
    }

    public String to() {
        return this.gsv;
    }

    public void qdl(String str) {
        this.gsv = str;
    }

    public float rq() {
        return this.qdl;
    }

    public void qdl(float f) {
        this.qdl = f;
    }

    public float fs() {
        return this.ud;
    }

    public void ud(float f) {
        this.ud = f;
    }

    public void lnr(float f) {
        this.lnr = f;
    }

    public void mml(float f) {
        this.mml = f;
    }

    public boolean exu() {
        return this.mzz;
    }

    public void ud(boolean z) {
        this.mzz = z;
    }

    public float rdp() {
        return this.mo;
    }

    public void mzz(float f) {
        this.mo = f;
    }

    public float bjy() {
        return this.wd;
    }

    public void mo(float f) {
        this.wd = f;
    }

    public float jtx() {
        return this.jpc;
    }

    public void wd(float f) {
        this.jpc = f;
    }

    public float yt() {
        return this.tvp;
    }

    public void jpc(float f) {
        this.tvp = f;
    }

    public float jl() {
        return this.to;
    }

    public void tvp(float f) {
        this.to = f;
    }

    public double exc() {
        return this.rq;
    }

    public void ud(double d) {
        this.rq = d;
    }

    public double aaj() {
        return this.fs;
    }

    public void lnr(double d) {
        this.fs = d;
    }

    public void ud(String str) {
        this.exu = str;
    }

    public void lnr(String str) {
        this.rdp = str;
    }

    public String jyq() {
        return this.bjy;
    }

    public void mml(String str) {
        this.bjy = str;
    }

    public String oth() {
        return this.jtx;
    }

    public void mzz(String str) {
        this.jtx = str;
    }

    public String ljh() {
        return this.yt;
    }

    public void mo(String str) {
        this.yt = str;
    }

    public void wd(String str) {
        this.jl = str;
    }

    public String bch() {
        return this.jl;
    }

    private void bqt(String str) {
        this.auu = str;
    }

    public String uw() {
        return this.auu;
    }

    public String xmv() {
        return this.exc;
    }

    public void jpc(String str) {
        this.exc = str;
    }

    public void tvp(String str) {
        this.aaj = str;
    }

    public String bqt() {
        return this.jyq;
    }

    public void to(String str) {
        this.jyq = str;
    }

    public String koa() {
        return this.oth;
    }

    public void rq(String str) {
        this.oth = str;
    }

    public String vu() {
        return this.ljh;
    }

    public void fs(String str) {
        this.ljh = str;
    }

    public String rc() {
        return this.bch;
    }

    public void exu(String str) {
        this.bch = str;
    }

    public boolean kdv() {
        return this.uw;
    }

    public void lnr(boolean z) {
        this.uw = z;
    }

    public int ekw() {
        return this.xmv;
    }

    public void wd(int i) {
        this.xmv = i;
    }

    public int hkc() {
        return this.bqt;
    }

    public void jpc(int i) {
        this.bqt = i;
    }

    public double hzv() {
        return this.koa;
    }

    public void mml(double d) {
        this.koa = d;
    }

    public double fco() {
        return this.vu;
    }

    public void mzz(double d) {
        this.vu = d;
    }

    public String mrf() {
        return this.rc;
    }

    public void rdp(String str) {
        this.rc = str;
    }

    public String gy() {
        return this.kdv;
    }

    public void bjy(String str) {
        this.kdv = str;
    }

    public String ax() {
        return this.ekw;
    }

    public void jtx(String str) {
        this.ekw = str;
    }

    public String ag() {
        return this.hkc;
    }

    public void yt(String str) {
        this.hkc = str;
    }

    public String wc() {
        return this.hzv;
    }

    public void jl(String str) {
        this.hzv = str;
    }

    public boolean om() {
        return this.fco;
    }

    public void mml(boolean z) {
        this.fco = z;
    }

    public void tvp(int i) {
        this.mrf = i;
    }

    public int cx() {
        return this.mrf;
    }

    public int yh() {
        return this.gy;
    }

    public void to(int i) {
        this.gy = i;
    }

    public int wak() {
        return this.ax;
    }

    public void rq(int i) {
        this.ax = i;
    }

    public int gt() {
        return this.ag;
    }

    public void fs(int i) {
        this.ag = i;
    }

    public int irn() {
        return this.wc;
    }

    public void exu(int i) {
        this.wc = i;
    }

    public double xi() {
        return this.om;
    }

    public void mo(double d) {
        this.om = d;
    }

    public int jjk() {
        return this.cx;
    }

    public void rdp(int i) {
        this.cx = i;
    }

    public boolean zlt() {
        return this.yh;
    }

    public void mzz(boolean z) {
        this.yh = z;
    }

    public int taz() {
        return this.wak;
    }

    public void bjy(int i) {
        this.wak = i;
    }

    public boolean tid() {
        return this.gt;
    }

    public void mo(boolean z) {
        this.gt = z;
    }

    public int sy() {
        return this.irn;
    }

    public void jtx(int i) {
        this.irn = i;
    }

    public String car() {
        return this.xi;
    }

    public void exc(String str) {
        this.xi = str;
    }

    public boolean mlb() {
        return this.jjk;
    }

    public void wd(boolean z) {
        this.jjk = z;
    }

    public boolean lte() {
        return this.zlt;
    }

    public void jpc(boolean z) {
        this.zlt = z;
    }

    public boolean dk() {
        return this.taz;
    }

    public void tvp(boolean z) {
        this.taz = z;
    }

    public boolean ijp() {
        return this.tid;
    }

    public void to(boolean z) {
        this.tid = z;
    }

    public String zy() {
        return this.sy;
    }

    public void aaj(String str) {
        this.sy = str;
    }

    public void ud(JSONObject jSONObject) {
        this.car = jSONObject;
    }

    public JSONObject en() {
        return this.car;
    }

    public int nz() {
        return this.mlb;
    }

    public void yt(int i) {
        this.mlb = i;
    }

    public boolean kab() {
        return this.lte;
    }

    public void rq(boolean z) {
        this.lte = z;
    }

    public int ra() {
        return this.dk;
    }

    public void jl(int i) {
        this.dk = i;
    }

    public int qk() {
        return this.ijp;
    }

    public void exc(int i) {
        this.ijp = i;
    }

    public int tqd() {
        return this.zy;
    }

    public void aaj(int i) {
        this.zy = i;
    }

    public int fzn() {
        return this.en;
    }

    public void jyq(int i) {
        this.en = i;
    }

    public int lq() {
        return this.nz;
    }

    public void oth(int i) {
        this.nz = i;
    }

    public int gg() {
        return this.kab;
    }

    public void ljh(int i) {
        this.kab = i;
    }

    public String rzg() {
        return this.ra;
    }

    public void jyq(String str) {
        this.ra = str;
    }

    public String ji() {
        return this.qk;
    }

    public void oth(String str) {
        this.qk = str;
    }

    public int ew() {
        return this.fzn;
    }

    public void bch(int i) {
        this.fzn = i;
    }

    public int blf() {
        return this.lq;
    }

    public void uw(int i) {
        this.lq = i;
    }

    public String zvv() {
        return this.fge;
    }

    public void ljh(String str) {
        this.fge = str;
    }

    public boolean bx() {
        return this.hcs;
    }

    public void fs(boolean z) {
        this.hcs = z;
    }

    public int jut() {
        return this.kj;
    }

    public void xmv(int i) {
        this.kj = i;
    }

    public int jnw() {
        return this.od;
    }

    public void bqt(int i) {
        this.od = i;
    }

    public int zpu() {
        return this.vm;
    }

    public void koa(int i) {
        this.vm = i;
    }

    public boolean jle() {
        return this.vc;
    }

    public void exu(boolean z) {
        this.vc = z;
    }

    public int xdk() {
        return this.gg;
    }

    public void vu(int i) {
        this.gg = i;
    }

    public void rdp(boolean z) {
        this.xx = z;
    }

    public boolean dps() {
        return this.xx;
    }

    public void bch(String str) {
        this.hd = str;
    }

    public String iw() {
        return this.hd;
    }

    public void rc(int i) {
        this.se = i;
    }

    public int lme() {
        return this.se;
    }

    public List<qdl> kr() {
        return this.rzg;
    }

    public int xx() {
        List<qdl> list = this.rzg;
        if (list == null) {
            return 0;
        }
        for (qdl qdlVar : list) {
            if ("translate".equals(qdlVar.tvp()) && qdlVar.wd() < 0) {
                return -qdlVar.wd();
            }
        }
        return 0;
    }

    public void qdl(List<qdl> list) {
        this.rzg = list;
    }

    public int syy() {
        return this.ji;
    }

    public void kdv(int i) {
        this.ji = i;
    }

    public int tdy() {
        return this.ew;
    }

    public void ekw(int i) {
        this.ew = i;
    }

    public int ca() {
        return this.blf;
    }

    public void hkc(int i) {
        this.blf = i;
    }

    public boolean gsp() {
        return this.bx;
    }

    public void bjy(boolean z) {
        this.bx = z;
    }

    public int ygv() {
        return this.zvv;
    }

    public void hzv(int i) {
        this.zvv = i;
    }

    public boolean hr() {
        return this.jut;
    }

    public void jtx(boolean z) {
        this.jut = z;
    }

    public boolean hd() {
        return this.jnw;
    }

    public void yt(boolean z) {
        this.jnw = z;
    }

    public int se() {
        return this.zpu;
    }

    public void fco(int i) {
        this.zpu = i;
    }

    public String vc() {
        return this.kr;
    }

    public boolean fge() {
        return this.jle;
    }

    public void jl(boolean z) {
        this.jle = z;
    }

    public void lnr(JSONObject jSONObject) {
        this.dps = jSONObject;
    }

    public JSONObject hcs() {
        return this.iw;
    }

    public void mml(JSONObject jSONObject) {
        this.iw = jSONObject;
    }

    public void mzz(JSONObject jSONObject) {
        this.syy = jSONObject;
    }

    public String kj() {
        return this.nts;
    }

    public void uw(String str) {
        this.nts = str;
    }

    public void od() {
        qdl(this, this.dps);
    }

    public void vm() {
        qdl(this, this.iw);
    }

    public String nts() {
        return this.eta;
    }

    public void xmv(String str) {
        this.eta = str;
    }

    public long eta() {
        return this.vr;
    }

    public void qdl(long j) {
        this.vr = j;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void qdl(mo moVar, JSONObject jSONObject) {
        if (moVar == null || jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            next.hashCode();
            byte b = -1;
            switch (next.hashCode()) {
                case -2067713583:
                    if (next.equals("isShowBgControl")) {
                        b = 0;
                    }
                    break;
                case -1965619659:
                    if (next.equals("clickArea")) {
                        b = 1;
                    }
                    break;
                case -1912831834:
                    if (next.equals("triggerSlideDirection")) {
                        b = 2;
                    }
                    break;
                case -1885934767:
                    if (next.equals("bgImgUrl")) {
                        b = 3;
                    }
                    break;
                case -1822062213:
                    if (next.equals("lineCount")) {
                        b = 4;
                    }
                    break;
                case -1821293778:
                    if (next.equals("openPlayableLandingPage")) {
                        b = 5;
                    }
                    break;
                case -1813937113:
                    if (next.equals("lineLimit")) {
                        b = 6;
                    }
                    break;
                case -1578250488:
                    if (next.equals("interactBgColor")) {
                        b = 7;
                    }
                    break;
                case -1501175880:
                    if (next.equals("paddingLeft")) {
                        b = 8;
                    }
                    break;
                case -1422965251:
                    if (next.equals("adType")) {
                        b = 9;
                    }
                    break;
                case -1383228885:
                    if (next.equals("bottom")) {
                        b = 10;
                    }
                    break;
                case -1224696685:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_FAMILY)) {
                        b = Ascii.VT;
                    }
                    break;
                case -1221029593:
                    if (next.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                        b = Ascii.FF;
                    }
                    break;
                case -1065511464:
                    if (next.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                        b = Ascii.CR;
                    }
                    break;
                case -1063257157:
                    if (next.equals("alignItems")) {
                        b = Ascii.SO;
                    }
                    break;
                case -1046708884:
                    if (next.equals("interactValidate")) {
                        b = Ascii.SI;
                    }
                    break;
                case -1044792121:
                    if (next.equals("marginTop")) {
                        b = Ascii.DLE;
                    }
                    break;
                case -1019884910:
                    if (next.equals("useBottom")) {
                        b = 17;
                    }
                    break;
                case -1005195314:
                    if (next.equals("triggerSlideMinDistance")) {
                        b = Ascii.DC2;
                    }
                    break;
                case -962590849:
                    if (next.equals("direction")) {
                        b = 19;
                    }
                    break;
                case -912366651:
                    if (next.equals("tagMaxCount")) {
                        b = Ascii.DC4;
                    }
                    break;
                case -848877971:
                    if (next.equals("interactHiddenTime")) {
                        b = Ascii.NAK;
                    }
                    break;
                case -836058546:
                    if (next.equals("useTop")) {
                        b = Ascii.SYN;
                    }
                    break;
                case -734428249:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                        b = Ascii.ETB;
                    }
                    break;
                case -731417480:
                    if (next.equals("zIndex")) {
                        b = Ascii.CAN;
                    }
                    break;
                case -709393864:
                    if (next.equals("timingStart")) {
                        b = Ascii.EM;
                    }
                    break;
                case -515807685:
                    if (next.equals("lineHeight")) {
                        b = Ascii.SUB;
                    }
                    break;
                case -321658193:
                    if (next.equals("textFlowDuration")) {
                        b = Ascii.ESC;
                    }
                    break;
                case -295409451:
                    if (next.equals("useRight")) {
                        b = Ascii.FS;
                    }
                    break;
                case -289173127:
                    if (next.equals("marginBottom")) {
                        b = Ascii.GS;
                    }
                    break;
                case -204859874:
                    if (next.equals("bgColor")) {
                        b = Ascii.RS;
                    }
                    break;
                case -148259282:
                    if (next.equals("useLeft")) {
                        b = Ascii.US;
                    }
                    break;
                case -51738487:
                    if (next.equals("widthMode")) {
                        b = 32;
                    }
                    break;
                case 115029:
                    if (next.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                        b = 33;
                    }
                    break;
                case 3076010:
                    if (next.equals("data")) {
                        b = 34;
                    }
                    break;
                case 3317767:
                    if (next.equals("left")) {
                        b = 35;
                    }
                    break;
                case 3327652:
                    if (next.equals("loop")) {
                        b = 36;
                    }
                    break;
                case 90130308:
                    if (next.equals("paddingTop")) {
                        b = 37;
                    }
                    break;
                case 92903173:
                    if (next.equals("align")) {
                        b = 38;
                    }
                    break;
                case 94842723:
                    if (next.equals("color")) {
                        b = 39;
                    }
                    break;
                case 108511772:
                    if (next.equals(TtmlNode.RIGHT)) {
                        b = 40;
                    }
                    break;
                case 113126854:
                    if (next.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                        b = 41;
                    }
                    break;
                case 164611121:
                    if (next.equals("timingEnd")) {
                        b = 42;
                    }
                    break;
                case 202355100:
                    if (next.equals("paddingBottom")) {
                        b = 43;
                    }
                    break;
                case 247204452:
                    if (next.equals("allowTextFlow")) {
                        b = 44;
                    }
                    break;
                case 302841174:
                    if (next.equals("interactWontHide")) {
                        b = 45;
                    }
                    break;
                case 365601008:
                    if (next.equals(TtmlNode.ATTR_TTS_FONT_SIZE)) {
                        b = 46;
                    }
                    break;
                case 428975654:
                    if (next.equals("justifyVertical")) {
                        b = 47;
                    }
                    break;
                case 439444041:
                    if (next.equals("interactVisibleTime")) {
                        b = 48;
                    }
                    break;
                case 713848971:
                    if (next.equals("paddingRight")) {
                        b = 49;
                    }
                    break;
                case 722830999:
                    if (next.equals("borderColor")) {
                        b = 50;
                    }
                    break;
                case 737768677:
                    if (next.equals("borderStyle")) {
                        b = 51;
                    }
                    break;
                case 747804969:
                    if (next.equals("position")) {
                        b = 52;
                    }
                    break;
                case 791643104:
                    if (next.equals("isDataFixed")) {
                        b = 53;
                    }
                    break;
                case 975087886:
                    if (next.equals("marginRight")) {
                        b = 54;
                    }
                    break;
                case 1110826708:
                    if (next.equals("justifyHorizontal")) {
                        b = 55;
                    }
                    break;
                case 1122368895:
                    if (next.equals("interactPosition")) {
                        b = 56;
                    }
                    break;
                case 1188229042:
                    if (next.equals("lineFeed")) {
                        b = 57;
                    }
                    break;
                case 1332036739:
                    if (next.equals("interactText")) {
                        b = 58;
                    }
                    break;
                case 1332055696:
                    if (next.equals("interactType")) {
                        b = 59;
                    }
                    break;
                case 1349188574:
                    if (next.equals("borderRadius")) {
                        b = 60;
                    }
                    break;
                case 1360828714:
                    if (next.equals("clickTigger")) {
                        b = Base64.padSymbol;
                    }
                    break;
                case 1490178922:
                    if (next.equals("heightMode")) {
                        b = 62;
                    }
                    break;
                case 1761274325:
                    if (next.equals("textFlowType")) {
                        b = 63;
                    }
                    break;
                case 1824903757:
                    if (next.equals("borderSize")) {
                        b = SignedBytes.MAX_POWER_OF_TWO;
                    }
                    break;
                case 1970934485:
                    if (next.equals("marginLeft")) {
                        b = 65;
                    }
                    break;
                case 2111078717:
                    if (next.equals("letterSpacing")) {
                        b = 66;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    moVar.lnr(jSONObject.optBoolean(next, false));
                    break;
                case 1:
                    moVar.bjy(jSONObject.optString(next));
                    break;
                case 2:
                    moVar.xmv(jSONObject.optString(next));
                    break;
                case 3:
                    moVar.wd(jSONObject.optString(next));
                    break;
                case 4:
                    moVar.tvp(jSONObject.optInt(next));
                    break;
                case 5:
                    moVar.jl(jSONObject.optBoolean(next));
                    break;
                case 6:
                    moVar.mo(jSONObject.optBoolean(next));
                    break;
                case 7:
                    moVar.exu(jSONObject.optString(next));
                    break;
                case 8:
                    moVar.mo((float) jSONObject.optDouble(next));
                    break;
                case 9:
                    moVar.ud(jSONObject.optString(next));
                    break;
                case 10:
                    moVar.ljh(jSONObject.optInt(next));
                    break;
                case 11:
                    moVar.lnr(jSONObject.optString(next));
                    break;
                case 12:
                    moVar.lnr((float) jSONObject.optDouble(next));
                    break;
                case 13:
                    moVar.mml(jSONObject.optString(next));
                    break;
                case 14:
                    moVar.jyq(jSONObject.optString(next));
                    break;
                case 15:
                    moVar.ud(jSONObject.optBoolean(next));
                    break;
                case 16:
                    moVar.to(jSONObject.optInt(next));
                    break;
                case 17:
                    moVar.to(jSONObject.optBoolean(next));
                    break;
                case 18:
                    moVar.qdl(jSONObject.optLong(next));
                    break;
                case 19:
                    moVar.oth(jSONObject.optString(next));
                    break;
                case 20:
                    moVar.yt(jSONObject.optInt(next));
                    break;
                case 21:
                    moVar.uw(jSONObject.optInt(next));
                    break;
                case 22:
                    moVar.tvp(jSONObject.optBoolean(next));
                    break;
                case 23:
                    moVar.bjy(jSONObject.optInt(next));
                    break;
                case 24:
                    moVar.bch(jSONObject.optInt(next));
                    break;
                case 25:
                    moVar.ud(jSONObject.optDouble(next));
                    break;
                case 26:
                    moVar.mo(jSONObject.optDouble(next));
                    break;
                case 27:
                    moVar.exc(jSONObject.optInt(next));
                    break;
                case 28:
                    moVar.jpc(jSONObject.optBoolean(next));
                    break;
                case 29:
                    moVar.rq(jSONObject.optInt(next));
                    break;
                case 30:
                    moVar.mo(jSONObject.optString(next));
                    break;
                case 31:
                    moVar.wd(jSONObject.optBoolean(next));
                    break;
                case 32:
                    moVar.rq(jSONObject.optString(next));
                    break;
                case 33:
                    moVar.oth(jSONObject.optInt(next));
                    break;
                case 34:
                    moVar.aaj(jSONObject.optString(next));
                    break;
                case 35:
                    moVar.aaj(jSONObject.optInt(next));
                    break;
                case 36:
                    moVar.qdl(jSONObject.optBoolean(next));
                    break;
                case 37:
                    moVar.jpc((float) jSONObject.optDouble(next));
                    break;
                case 38:
                    moVar.exc(jSONObject.optString(next));
                    break;
                case 39:
                    moVar.mzz(jSONObject.optString(next));
                    break;
                case 40:
                    moVar.jyq(jSONObject.optInt(next));
                    break;
                case 41:
                    moVar.mml((float) jSONObject.optDouble(next));
                    break;
                case 42:
                    moVar.lnr(jSONObject.optDouble(next));
                    break;
                case 43:
                    moVar.mzz((float) jSONObject.optDouble(next));
                    break;
                case 44:
                    moVar.rq(jSONObject.optBoolean(next));
                    break;
                case 45:
                    moVar.rdp(jSONObject.optBoolean(next));
                    break;
                case 46:
                    moVar.tvp((float) jSONObject.optDouble(next));
                    break;
                case 47:
                    moVar.jl(jSONObject.optString(next));
                    break;
                case 48:
                    moVar.vu(jSONObject.optInt(next));
                    break;
                case 49:
                    moVar.wd((float) jSONObject.optDouble(next));
                    break;
                case 50:
                    moVar.jpc(jSONObject.optString(next));
                    break;
                case 51:
                    moVar.tvp(jSONObject.optString(next));
                    break;
                case 52:
                    moVar.jtx(jSONObject.optInt(next));
                    break;
                case 53:
                    moVar.mzz(jSONObject.optBoolean(next));
                    break;
                case 54:
                    moVar.exu(jSONObject.optInt(next));
                    break;
                case 55:
                    moVar.yt(jSONObject.optString(next));
                    break;
                case 56:
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                    if (jSONObjectOptJSONObject != null) {
                        moVar.wd(jSONObjectOptJSONObject.optInt("translateY", 0));
                        moVar.jpc(jSONObjectOptJSONObject.optInt("translateX", 0));
                        moVar.mml(jSONObjectOptJSONObject.optDouble("scaleX", 0.0d));
                        moVar.mzz(jSONObjectOptJSONObject.optDouble("scaleY", 0.0d));
                    }
                    break;
                case 57:
                    moVar.mml(jSONObject.optBoolean(next));
                    break;
                case 58:
                    moVar.fs(jSONObject.optString(next));
                    break;
                case 59:
                    moVar.rdp(jSONObject.optString(next));
                    break;
                case 60:
                    moVar.qdl((float) jSONObject.optDouble(next));
                    break;
                case 61:
                    moVar.jtx(jSONObject.optString(next));
                    break;
                case 62:
                    moVar.to(jSONObject.optString(next));
                    break;
                case 63:
                    moVar.jl(jSONObject.optInt(next));
                    break;
                case 64:
                    moVar.ud((float) jSONObject.optDouble(next));
                    break;
                case 65:
                    moVar.fs(jSONObject.optInt(next));
                    break;
                case 66:
                    moVar.rdp(jSONObject.optInt(next));
                    break;
            }
        }
    }
}
