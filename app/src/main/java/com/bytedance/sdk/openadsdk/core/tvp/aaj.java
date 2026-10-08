package com.bytedance.sdk.openadsdk.core.tvp;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.adexpress.ud.exu;
import com.bytedance.sdk.component.adexpress.ud.to;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.api.PAGExpressAdWrapperListener;
import com.bytedance.sdk.openadsdk.bch.ud.mzz;
import com.bytedance.sdk.openadsdk.core.fco;
import com.bytedance.sdk.openadsdk.core.hkc;
import com.bytedance.sdk.openadsdk.core.hzv;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.mml.wd;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.moloco.sdk.internal.services.init.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class aaj extends com.bytedance.sdk.openadsdk.core.mo.lnr implements com.bytedance.sdk.component.adexpress.dynamic.mml, com.bytedance.sdk.component.adexpress.ud.bjy, com.bytedance.sdk.component.adexpress.ud.jpc, qdl.InterfaceC0238qdl, bjy {
    protected HashSet<String> aaj;
    private final AtomicBoolean ag;
    private oth ax;
    boolean bch;
    protected boolean bjy;
    protected com.bytedance.sdk.component.adexpress.ud.ud bqt;
    private com.bytedance.sdk.component.adexpress.ud.tvp car;
    private final Runnable cx;
    private final SparseArray<lnr.qdl> dk;
    private String ekw;
    private float en;
    protected String exc;
    public FrameLayout exu;
    private String fco;
    protected com.bytedance.sdk.openadsdk.core.model.ljh fs;
    private ThemeStatusBroadcastReceiver gt;
    private boolean gy;
    private com.bytedance.sdk.openadsdk.core.rq.lnr.ud hkc;
    private boolean hzv;
    private float ijp;
    private bch irn;
    private List<com.bytedance.sdk.component.adexpress.ud.to> jjk;
    protected int jl;
    private String jpc;
    protected com.bytedance.sdk.component.adexpress.ud.lnr jtx;
    protected ViewGroup jyq;
    private long kab;
    private com.bytedance.sdk.openadsdk.mml.mml.mzz kdv;
    public com.bytedance.sdk.component.adexpress.ud.mml<? extends View> koa;
    int ljh;
    private com.bytedance.sdk.openadsdk.lnr.lnr lnr;
    private int lte;
    private com.bytedance.sdk.component.adexpress.ud.exu mlb;
    private TTDislikeDialogAbstract mml;
    private jpc mo;
    private wd.qdl mrf;
    private PAGExpressAdWrapperListener mzz;
    private float nz;
    private final ViewTreeObserver.OnScrollChangedListener om;
    public boolean oth;
    private boolean qdl;
    private com.bytedance.sdk.openadsdk.core.mml.tvp ra;
    private float rc;
    protected boolean rdp;
    protected AdSlot rq;
    private com.bytedance.sdk.openadsdk.core.rq.mo.mml sy;
    private com.bytedance.sdk.component.adexpress.ud.mo taz;
    private com.bytedance.sdk.openadsdk.core.rq.ud.wd tid;
    protected String to;
    protected final Context tvp;
    private int ud;
    public com.bytedance.sdk.openadsdk.mml.wd uw;
    private float vu;
    private final Runnable wak;
    private lnr wc;
    private tvp wd;
    private to.qdl xi;
    long xmv;
    private final Runnable yh;
    boolean yt;
    private com.bytedance.sdk.component.adexpress.ud.jtx zlt;
    private float zy;

    protected boolean jpc() {
        return true;
    }

    public long lnr() {
        return 0L;
    }

    protected void lnr(JSONObject jSONObject) {
    }

    public long mml() {
        return 0L;
    }

    public void mo() {
    }

    public int mzz() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void onvideoComplate() {
    }

    public void qdl() {
    }

    public void qdl(int i) {
    }

    public void qdl(int i, com.bytedance.sdk.component.adexpress.ud.rdp rdpVar) {
    }

    public void qdl(int i, String str) {
    }

    protected void qdl(exu.qdl qdlVar) {
    }

    public void qdl(String str, JSONObject jSONObject) {
    }

    public void qdl(boolean z, String str) {
    }

    public boolean qdl(JSONObject jSONObject) {
        return false;
    }

    public void rq() {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTimeUpdate(int i) {
    }

    protected boolean tvp() {
        return true;
    }

    public void ud() {
    }

    public void ud(int i) {
    }

    protected boolean ud(com.bytedance.sdk.component.adexpress.ud.rdp rdpVar) {
        return true;
    }

    public boolean ud(JSONObject jSONObject) {
        return false;
    }

    public void setJsbLandingPageOpenListener(com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar) {
        if (this.irn != null && getJsObject() != null) {
            getJsObject().qdl(mzzVar);
        }
        com.bytedance.sdk.openadsdk.core.rq.mo.mml mmlVar = this.sy;
        if (mmlVar != null) {
            mmlVar.qdl(mzzVar);
        }
    }

    public com.bytedance.sdk.openadsdk.mml.wd getAdShowTime() {
        return this.uw;
    }

    public void setClosedListenerKey(String str) {
        this.fco = str;
        lnr lnrVar = this.wc;
        if (lnrVar != null) {
            lnrVar.qdl(str);
        }
    }

    public lnr getBrandBannerController() {
        return this.wc;
    }

    public String getClosedListenerKey() {
        return this.fco;
    }

    public void setBannerClickClosedListener(wd.qdl qdlVar) {
        this.mrf = qdlVar;
    }

    public aaj(Context context, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, AdSlot adSlot, String str) {
        super(context);
        this.qdl = true;
        this.ud = 0;
        this.to = "embeded_ad";
        this.jpc = null;
        this.bjy = false;
        this.yt = true;
        this.jl = -1;
        this.ekw = "";
        this.oth = false;
        this.gy = true;
        this.ljh = -1;
        this.uw = new com.bytedance.sdk.openadsdk.mml.wd();
        this.xmv = 0L;
        this.ag = new AtomicBoolean(false);
        this.om = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (aaj.this.yt && aaj.this.tvp()) {
                    aaj.this.bqt();
                    aaj aajVar = aaj.this;
                    aajVar.removeCallbacks(aajVar.cx);
                    aaj aajVar2 = aaj.this;
                    aajVar2.postDelayed(aajVar2.cx, 500L);
                }
            }
        };
        this.cx = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.2
            @Override // java.lang.Runnable
            public void run() {
                if (hzv.qdl(aaj.this, 0, 5, false)) {
                    aaj aajVar = aaj.this;
                    aajVar.mo(aajVar.getVisibility());
                } else {
                    aaj.this.mo(8);
                }
            }
        };
        this.yh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.3
            @Override // java.lang.Runnable
            public void run() {
                aaj.this.mo(0);
            }
        };
        this.wak = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.4
            @Override // java.lang.Runnable
            public void run() {
                aaj.this.mo(8);
            }
        };
        this.lte = 8;
        this.dk = new SparseArray<>();
        this.ijp = -1.0f;
        this.zy = -1.0f;
        this.en = -1.0f;
        this.nz = -1.0f;
        this.kab = 0L;
        this.to = str;
        this.tvp = context;
        this.fs = ljhVar;
        this.rq = adSlot;
        this.oth = false;
        wd();
    }

    public aaj(Context context, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, AdSlot adSlot, String str, boolean z, boolean z2) {
        super(context);
        this.qdl = true;
        this.ud = 0;
        this.to = "embeded_ad";
        this.jpc = null;
        this.bjy = false;
        this.yt = true;
        this.jl = -1;
        this.ekw = "";
        this.oth = false;
        this.gy = true;
        this.ljh = -1;
        this.uw = new com.bytedance.sdk.openadsdk.mml.wd();
        this.xmv = 0L;
        this.ag = new AtomicBoolean(false);
        this.om = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                if (aaj.this.yt && aaj.this.tvp()) {
                    aaj.this.bqt();
                    aaj aajVar = aaj.this;
                    aajVar.removeCallbacks(aajVar.cx);
                    aaj aajVar2 = aaj.this;
                    aajVar2.postDelayed(aajVar2.cx, 500L);
                }
            }
        };
        this.cx = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.2
            @Override // java.lang.Runnable
            public void run() {
                if (hzv.qdl(aaj.this, 0, 5, false)) {
                    aaj aajVar = aaj.this;
                    aajVar.mo(aajVar.getVisibility());
                } else {
                    aaj.this.mo(8);
                }
            }
        };
        this.yh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.3
            @Override // java.lang.Runnable
            public void run() {
                aaj.this.mo(0);
            }
        };
        this.wak = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.4
            @Override // java.lang.Runnable
            public void run() {
                aaj.this.mo(8);
            }
        };
        this.lte = 8;
        this.dk = new SparseArray<>();
        this.ijp = -1.0f;
        this.zy = -1.0f;
        this.en = -1.0f;
        this.nz = -1.0f;
        this.kab = 0L;
        this.to = str;
        this.tvp = context;
        this.fs = ljhVar;
        this.rq = adSlot;
        this.oth = z;
        this.gy = z2;
        wd();
    }

    protected void wd() {
        this.aaj = new HashSet<>();
        this.gt = new ThemeStatusBroadcastReceiver();
        AdSlot adSlot = this.rq;
        if (adSlot != null) {
            this.vu = adSlot.getExpressViewAcceptedWidth();
            this.rc = this.rq.getExpressViewAcceptedHeight();
            exu();
            this.jpc = this.rq.getCodeId();
            if (TextUtils.equals(this.to, "fullscreen_interstitial_ad")) {
                this.ljh = this.fs.ws();
            } else if (TextUtils.equals(this.to, "rewarded_video")) {
                this.ljh = this.fs.qg();
            } else if (TextUtils.equals(this.to, "open_ad")) {
                com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.fs;
                if (ljhVar != null && ljhVar.ud() >= 0) {
                    this.ljh = this.fs.ud();
                } else {
                    this.ljh = com.bytedance.sdk.openadsdk.core.yt.mml().oth(this.jpc);
                }
                if (this.ljh < 0) {
                    this.ljh = 5;
                }
            }
        }
        setBackgroundColor(0);
        if (this.fs.vxm()) {
            this.wc = new lnr(this.tvp, this, this.fs, this.to);
            return;
        }
        rdp();
        this.jjk = new ArrayList();
        bjy();
        com.bytedance.sdk.component.adexpress.ud.jtx jtxVar = this.zlt;
        if (jtxVar != null) {
            this.irn = (bch) jtxVar.ud();
        }
        hkc jsObject = getJsObject();
        if (jsObject != null) {
            jsObject.mo(this.to);
        }
    }

    private void exu() {
        ljh.qdl qdlVarXdk = this.fs.xdk();
        if (!TextUtils.equals(this.to, "embeded_ad") || qdlVarXdk == null) {
            return;
        }
        String str = qdlVarXdk.to();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            int iOptInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            if (iOptInt == 0 || iOptInt2 == 0) {
                return;
            }
            this.rc = iOptInt2;
            this.vu = iOptInt;
        } catch (Exception unused) {
        }
    }

    public com.bytedance.sdk.component.tvp.mo getWebView() {
        bch bchVar = this.irn;
        if (bchVar == null) {
            return null;
        }
        return bchVar.qdl();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void rdp() {
        /*
            Method dump skipped, instruction units count: 472
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.tvp.aaj.rdp():void");
    }

    public String getUgenTemplateErrorReason() {
        return this.ekw;
    }

    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.core.yt.mml().fco();
    }

    private void bjy() {
        if (this.fs.vz() == 1 && this.fs.uj()) {
            yt();
            this.xi = new com.bytedance.sdk.component.adexpress.ud.fs(this.jjk, this.car);
            return;
        }
        if (kdv()) {
            jtx();
            return;
        }
        try {
            uw();
            bch bchVar = new bch(this.tvp, this.mlb, this.gt, this.kdv, this.fs);
            this.irn = bchVar;
            com.bytedance.sdk.component.adexpress.ud.jtx jtxVar = new com.bytedance.sdk.component.adexpress.ud.jtx(this.tvp, this.mlb, bchVar, this);
            this.zlt = jtxVar;
            this.jjk.add(jtxVar);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.qdl("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        yt();
        this.xi = new com.bytedance.sdk.component.adexpress.ud.fs(this.jjk, this.car);
    }

    private void jtx() {
        this.ud = this.fs.ra();
        try {
            uw();
            xmv();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.qdl("NativeExpressView", "NativeExpressView dynamicRender fail", e);
        }
        boolean z = this.fs.qk() == 1;
        this.qdl = z;
        if (z) {
            yt();
        }
        Objects.toString(this.jjk);
        this.xi = new com.bytedance.sdk.component.adexpress.ud.fs(this.jjk, this.car);
    }

    private void yt() {
        if (com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml.qdl(this.to)) {
            com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml mmlVar = new com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml(this.tvp, this.fs, this.oth, (com.bytedance.sdk.openadsdk.core.rq.mo.qdl) this.mlb, this, this.vu, this.rc, this.bjy, this.to);
            com.bytedance.sdk.openadsdk.core.rq.ud.wd wdVar = new com.bytedance.sdk.openadsdk.core.rq.ud.wd(this.tvp, mmlVar, this, this.mlb);
            mmlVar.qdl((bjy) this);
            this.jjk.add(wdVar);
            return;
        }
        com.bytedance.sdk.component.adexpress.ud.mo moVar = new com.bytedance.sdk.component.adexpress.ud.mo(this.tvp, this.mlb, new jyq(this, this.gt, this.mlb));
        this.taz = moVar;
        this.jjk.add(moVar);
    }

    private void uw() {
        if (com.bytedance.sdk.openadsdk.core.rdp.mzz()) {
            return;
        }
        fs.qdl();
    }

    private void xmv() {
        com.bytedance.sdk.openadsdk.core.rq.mo.mml mmlVar;
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar;
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar2 = this.fs;
        if (ljhVar2 == null || ljhVar2.vz() != 1 || this.fs.dk() == 2) {
            if (!com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml.qdl(this.to) || (ljhVar = this.fs) == null || ljhVar.dk() == 2) {
                com.bytedance.sdk.openadsdk.core.wd.qdl.qdl qdlVar = new com.bytedance.sdk.openadsdk.core.wd.qdl.qdl();
                int i = this.ud;
                if (i != 0) {
                    if (i == 3) {
                        com.bytedance.sdk.component.adexpress.dynamic.mzz.wd wdVar = new com.bytedance.sdk.component.adexpress.dynamic.mzz.wd();
                        Context applicationContext = this.tvp.getApplicationContext();
                        com.bytedance.sdk.component.adexpress.ud.exu exuVar = this.mlb;
                        ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver = this.gt;
                        boolean z = this.oth;
                        com.bytedance.sdk.component.adexpress.ud.ud udVar = new com.bytedance.sdk.component.adexpress.ud.ud(applicationContext, exuVar, themeStatusBroadcastReceiver, z, wdVar, this, qdlVar, new mo(this.tvp, themeStatusBroadcastReceiver, z, wdVar, exuVar, qdlVar));
                        this.bqt = udVar;
                        this.jjk.add(udVar);
                        return;
                    }
                    if (i == 7) {
                        com.bytedance.sdk.openadsdk.core.rq.mo.mml mmlVar2 = new com.bytedance.sdk.openadsdk.core.rq.mo.mml(this.tvp, this.fs, this.oth, (com.bytedance.sdk.openadsdk.core.rq.mo.qdl) this.mlb, this);
                        this.sy = mmlVar2;
                        com.bytedance.sdk.openadsdk.core.rq.ud.wd wdVar2 = new com.bytedance.sdk.openadsdk.core.rq.ud.wd(this.tvp, mmlVar2, this, this.mlb);
                        this.tid = wdVar2;
                        wdVar2.qdl(this);
                        this.jjk.add(this.tid);
                        return;
                    }
                    if (i != 9) {
                        if (i != 10) {
                            return;
                        }
                        if (this.hzv && (mmlVar = this.sy) != null) {
                            mmlVar.qdl(this.fs, this.oth, (com.bytedance.sdk.openadsdk.core.rq.mo.qdl) this.mlb, this);
                        } else {
                            this.sy = new com.bytedance.sdk.openadsdk.core.rq.mo.wd(this.tvp, this.fs, this.oth, (com.bytedance.sdk.openadsdk.core.rq.mo.qdl) this.mlb, this);
                        }
                        com.bytedance.sdk.openadsdk.core.rq.ud.wd wdVar3 = new com.bytedance.sdk.openadsdk.core.rq.ud.wd(this.tvp, this.sy, this, this.mlb);
                        this.tid = wdVar3;
                        wdVar3.qdl(this);
                        this.jjk.add(this.tid);
                        return;
                    }
                }
                bch bchVar = new bch(this.tvp, this.mlb, this.gt, this.kdv, this.fs);
                this.irn = bchVar;
                com.bytedance.sdk.component.adexpress.ud.jtx jtxVar = new com.bytedance.sdk.component.adexpress.ud.jtx(this.tvp, this.mlb, bchVar, this);
                this.zlt = jtxVar;
                this.jjk.add(jtxVar);
            }
        }
    }

    public void setOuterDislike(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        qdl qdlVar;
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar != null && (mmlVar instanceof jyq) && (qdlVar = (qdl) mmlVar.mzz()) != null) {
            qdlVar.setDislikeOuter(tTDislikeDialogAbstract);
        }
        lnr lnrVar = this.wc;
        if (lnrVar != null) {
            lnrVar.qdl(tTDislikeDialogAbstract);
        }
        this.mml = tTDislikeDialogAbstract;
    }

    public void setDislike(com.bytedance.sdk.openadsdk.lnr.lnr lnrVar) {
        qdl qdlVar;
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar != null && (mmlVar instanceof jyq) && (qdlVar = (qdl) mmlVar.mzz()) != null) {
            qdlVar.setDislikeInner(lnrVar);
        }
        lnr lnrVar2 = this.wc;
        if (lnrVar2 != null) {
            lnrVar2.qdl(lnrVar);
        }
        this.lnr = lnrVar;
    }

    public void setExpressInteractionListener(PAGExpressAdWrapperListener pAGExpressAdWrapperListener) {
        this.mzz = pAGExpressAdWrapperListener;
        lnr lnrVar = this.wc;
        if (lnrVar != null) {
            lnrVar.qdl(pAGExpressAdWrapperListener);
        }
    }

    public void setClickCreativeListener(jpc jpcVar) {
        this.mo = jpcVar;
        if (jpcVar != null) {
            jpcVar.qdl((qdl.InterfaceC0238qdl) this);
        }
    }

    public jpc getClickCreativeListener() {
        return this.mo;
    }

    public tvp getClickListener() {
        return this.wd;
    }

    public void setClickListener(tvp tvpVar) {
        this.wd = tvpVar;
    }

    public void setBackupListener(com.bytedance.sdk.component.adexpress.ud.lnr lnrVar) {
        this.jtx = lnrVar;
        com.bytedance.sdk.component.adexpress.ud.mo moVar = this.taz;
        if (moVar != null) {
            moVar.qdl(lnrVar);
        }
    }

    public void jl() {
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm;
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar instanceof bch) {
            if (mmlVar == null) {
                return;
            }
            ((bch) mmlVar).jpc();
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.fs;
            com.bytedance.sdk.component.utils.tvp.ud().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.6
                @Override // java.lang.Runnable
                public void run() {
                    aaj.this.mzz(1);
                }
            }, ((long) (ljhVar != null ? ljhVar.oth().mml() : 5)) * 1000);
        } else if (mmlVar instanceof com.bytedance.sdk.openadsdk.core.rq.mo.wd) {
            ((com.bytedance.sdk.openadsdk.core.rq.mo.wd) mmlVar).rq();
        }
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar2 = this.fs;
        if (ljhVar2 != null && (mmlVarZm = ljhVar2.zm()) != null && (mmlVarQdl = mmlVarZm.qdl()) != null) {
            mmlVarQdl.qdl(0L);
        }
        if ((this.koa instanceof com.bytedance.sdk.openadsdk.core.rq.mo.wd) && com.bytedance.sdk.openadsdk.core.model.yt.qdl(this.fs)) {
            qdl(this.koa);
        }
    }

    public void mzz(int i) {
        if (com.bytedance.sdk.openadsdk.core.model.aaj.lnr(this.fs)) {
            com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
            if (mmlVar instanceof bch) {
                ((bch) mmlVar).ud(i);
            }
        }
    }

    public void mo(int i) {
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar == null || !(mmlVar instanceof bch)) {
            return;
        }
        ((bch) mmlVar).qdl(i);
        this.lte = i;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        qdl(i, true, false);
    }

    public void qdl(int i, boolean z, boolean z2) {
        this.yt = z;
        removeCallbacks(this.wak);
        removeCallbacks(this.yh);
        if (i == 0) {
            if (z2) {
                this.yh.run();
                return;
            } else {
                postDelayed(this.yh, 50L);
                return;
            }
        }
        if (z2) {
            this.wak.run();
        } else {
            postDelayed(this.wak, 50L);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (Build.VERSION.SDK_INT < 28) {
            onWindowVisibilityChanged(z ? getVisibility() : 8);
        }
        bqt();
        com.bytedance.sdk.openadsdk.bch.qdl.lnr.qdl(this.fs, z);
        if (z) {
            com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.fs, 4);
        } else {
            com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.fs, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqt() {
        if (this.ag.get()) {
            this.uw.qdl(System.currentTimeMillis(), hzv.qdl(this));
        }
    }

    public void exc() {
        if (this.fs == null) {
            return;
        }
        this.xmv = SystemClock.elapsedRealtime();
        if (this.fs.vxm()) {
            lnr lnrVar = this.wc;
            if (lnrVar == null) {
                a_(106);
                return;
            } else {
                lnrVar.qdl((com.bytedance.sdk.component.adexpress.ud.bjy) this);
                this.wc.qdl();
                return;
            }
        }
        this.kdv.qdl();
        to.qdl qdlVar = this.xi;
        if (qdlVar != null) {
            qdlVar.qdl(this);
        }
        try {
            this.xi.qdl();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.tvp.aaj.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void qdl(View view, int i, com.bytedance.sdk.component.adexpress.lnr lnrVar) {
        View view2;
        JSONObject jSONObject;
        com.bytedance.sdk.component.utils.aaj.qdl("ClickCreativeListener", "trigger Class2 method1", Integer.valueOf(i));
        if (i == -1 || lnrVar == null) {
            return;
        }
        HashMap map = new HashMap();
        if (vu.lnr(this.fs)) {
            map.put("click_scence", 3);
        } else {
            map.put("click_scence", 1);
        }
        com.bytedance.sdk.openadsdk.core.model.jtx jtxVar = (com.bytedance.sdk.openadsdk.core.model.jtx) lnrVar;
        if (com.bytedance.sdk.openadsdk.core.model.aaj.lnr(this.fs)) {
            try {
                JSONObject jSONObject2 = jtxVar.exu;
                if (jSONObject2 != null) {
                    int iOptInt = jSONObject2.optInt("click_type", 0);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("click_type", iOptInt);
                    map.put("pag_json_data", jSONObject3.toString());
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr(th.toString(), new Object[0]);
            }
        }
        jpc jpcVar = this.mo;
        if (jpcVar != null) {
            jpcVar.mml(getDynamicShowType());
            this.mo.qdl(map);
        }
        tvp tvpVar = this.wd;
        if (tvpVar != null) {
            tvpVar.mml(getDynamicShowType());
            this.wd.qdl(map);
        }
        float f = jtxVar.qdl;
        float f2 = jtxVar.ud;
        float f3 = jtxVar.lnr;
        float f4 = jtxVar.mml;
        boolean z = jtxVar.rq;
        SparseArray<lnr.qdl> sparseArray = jtxVar.to;
        if (sparseArray == null || sparseArray.size() == 0) {
            sparseArray = this.dk;
        }
        SparseArray<lnr.qdl> sparseArray2 = sparseArray;
        String str = jtxVar.wd;
        if (view == null) {
            view2 = this;
        } else {
            jSONObjectQdl = view != this ? qdl(view) : null;
            view2 = view;
        }
        if (jtxVar != null) {
            jtxVar.jpc = i;
            if (jSONObjectQdl != null && jtxVar.tvp == null) {
                jtxVar.tvp = jSONObjectQdl;
            }
        }
        if (i != 13) {
            switch (i) {
                case 1:
                    FrameLayout frameLayout = this.exu;
                    if (frameLayout != null) {
                        frameLayout.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.fs;
                    if (ljhVar == null || ljhVar.sy() != 1 || z) {
                        tvp tvpVar2 = this.wd;
                        if (tvpVar2 != null) {
                            tvpVar2.qdl(jtxVar);
                            this.wd.qdl(str);
                            this.wd.qdl(view2, f, f2, f3, f4, sparseArray2, z);
                        }
                        if (this.mzz != null && !jtxVar.rdp) {
                            this.mzz.onAdClicked();
                            break;
                        }
                    }
                    break;
                case 2:
                    if (jtxVar.fs > 0) {
                        fco.qdl(true);
                    }
                    jpc jpcVar2 = this.mo;
                    if (jpcVar2 != null) {
                        jpcVar2.qdl(jtxVar);
                        this.mo.qdl(str);
                        if (com.bytedance.sdk.openadsdk.core.model.aaj.lnr(this.fs) && (jSONObject = jtxVar.exu) != null) {
                            this.mo.mml(jSONObject.optBoolean("is_ceiling_page", false));
                        }
                        this.mo.qdl(view2, f, f2, f3, f4, sparseArray2, z);
                    }
                    if (this.mzz != null && !jtxVar.rdp) {
                        this.mzz.onAdClicked();
                    }
                    fco.qdl(false);
                    com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.fs, 9);
                    break;
                case 3:
                    TTDislikeDialogAbstract tTDislikeDialogAbstract = this.mml;
                    if (tTDislikeDialogAbstract != null) {
                        tTDislikeDialogAbstract.show();
                    } else {
                        com.bytedance.sdk.openadsdk.lnr.lnr lnrVar2 = this.lnr;
                        if (lnrVar2 != null) {
                            lnrVar2.qdl();
                        } else {
                            TTDelegateActivity.qdl(this.fs, this.fco);
                        }
                    }
                    break;
                case 4:
                    FrameLayout frameLayout2 = this.exu;
                    if (frameLayout2 != null) {
                        frameLayout2.dispatchTouchEvent(MotionEvent.obtain(0L, 0L, 0, 0.0f, 0.0f, 0));
                    }
                    com.bytedance.sdk.openadsdk.core.model.ljh ljhVar2 = this.fs;
                    if (ljhVar2 == null || ljhVar2.sy() != 1 || z) {
                        gy.lnr(this.fs);
                        if ("embeded_ad".equals(this.to) && koa() && !this.rdp && gy.lnr(this.fs)) {
                            jpc jpcVar3 = this.mo;
                            if (jpcVar3 != null) {
                                jpcVar3.qdl(jtxVar);
                                this.mo.qdl(str);
                                this.mo.qdl(view2, f, f2, f3, f4, sparseArray2, z);
                            }
                        } else {
                            tvp tvpVar3 = this.wd;
                            if (tvpVar3 != null) {
                                tvpVar3.qdl(jtxVar);
                                this.wd.qdl(str);
                                this.wd.qdl(view2, f, f2, f3, f4, sparseArray2, z);
                            }
                        }
                        if (this.mzz != null && !jtxVar.rdp) {
                            this.mzz.onAdClicked();
                            break;
                        }
                    }
                    break;
                case 5:
                    qdl(!this.oth, "dynamicClick");
                    break;
                case 6:
                    qdl();
                    break;
                case 7:
                    TTWebsiteActivity.qdl(this.tvp, this.fs, this.to);
                    break;
            }
            return;
        }
        int i2 = jtxVar.bjy;
        if (i2 >= 0) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("switch", i2);
                qdl(jSONObject4);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lnr.qdl.InterfaceC0238qdl
    public long getVideoProgress() {
        com.bytedance.sdk.openadsdk.core.mml.tvp tvpVar = this.ra;
        if (tvpVar != null) {
            return tvpVar.getVideoProgress();
        }
        return 0L;
    }

    public static JSONObject qdl(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, view.getWidth());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, view.getHeight());
            jSONObject.put("left", iArr[0]);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, iArr[1]);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean koa() {
        return com.bytedance.sdk.openadsdk.core.model.ljh.mzz(this.fs);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        bqt();
        vu();
        getViewTreeObserver().addOnScrollChangedListener(this.om);
        com.bytedance.sdk.openadsdk.core.tvp.ud().qdl(this.fco, this.mrf);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        bqt();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    private void vu() {
        List<com.bytedance.sdk.component.adexpress.ud.to> list = this.jjk;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.ud.to> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void rc() {
        List<com.bytedance.sdk.component.adexpress.ud.to> list = this.jjk;
        if (list == null) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.ud.to> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void to() {
        bch bchVar = this.irn;
        if (bchVar == null || bchVar.mzz() == null) {
            return;
        }
        this.irn.mo();
    }

    public void fs() {
        try {
            lnr lnrVar = this.wc;
            if (lnrVar != null) {
                lnrVar.ud();
            }
            oth();
            removeAllViews();
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            List<com.bytedance.sdk.component.adexpress.ud.to> list = this.jjk;
            if (list != null) {
                Iterator<com.bytedance.sdk.component.adexpress.ud.to> it = list.iterator();
                while (it.hasNext()) {
                    it.next().qdl();
                }
            }
            com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this.fs);
            com.bytedance.sdk.openadsdk.bch.qdl.lnr.ud(this.fs);
            this.lnr = null;
            this.mml = null;
            this.rq = null;
            this.fs = null;
            this.mzz = null;
            this.mo = null;
            this.jtx = null;
            this.wd = null;
            com.bytedance.sdk.openadsdk.core.rq.lnr.ud udVar = this.hkc;
            if (udVar != null) {
                udVar.mml();
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.qdl("NativeExpressView", "detach error", th);
        }
    }

    public void aaj() {
        try {
            FrameLayout frameLayout = this.exu;
            if (frameLayout == null || frameLayout.getParent() == null) {
                return;
            }
            removeView(this.exu);
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.om);
        com.bytedance.sdk.openadsdk.core.tvp.ud().mo(this.fco);
        rc();
        qdl(8, true, true);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void qdl(com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar, com.bytedance.sdk.component.adexpress.ud.rdp rdpVar) {
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar;
        this.ag.set(true);
        this.koa = mmlVar;
        Integer.valueOf(mmlVar.lnr());
        if (this.lte != getWindowVisibility() && jpc()) {
            mo(getWindowVisibility());
        }
        if (mmlVar.lnr() == 3 && (ljhVar = this.fs) != null && ljhVar.taz() == 1) {
            this.fs.jpc(0);
        }
        if (mmlVar.lnr() != 1 || (mmlVar instanceof com.bytedance.sdk.openadsdk.core.rq.mo.mml)) {
            View viewMzz = mmlVar.mzz();
            if (viewMzz.getParent() != null) {
                ((ViewGroup) viewMzz.getParent()).removeView(viewMzz);
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < getChildCount(); i++) {
                arrayList.add(getChildAt(i));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2) instanceof com.bytedance.sdk.component.tvp.mo) {
                    removeView((View) arrayList.get(i2));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.model.aaj.lnr(this.fs)) {
                addView(mmlVar.mzz(), new FrameLayout.LayoutParams(-1, -1));
            } else {
                addView(mmlVar.mzz());
            }
        }
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar2 = this.fs;
        if (ljhVar2 != null) {
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl(ljhVar2.jpc(), this.xmv, this.to, mmlVar.lnr());
        }
        com.bytedance.sdk.component.adexpress.ud.tvp tvpVar = this.car;
        if (tvpVar != null) {
            ((exu) tvpVar).rq();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.mzz;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderSuccess(this, (float) rdpVar.lnr(), (float) rdpVar.mml());
        }
        if ((this.koa instanceof com.bytedance.sdk.openadsdk.core.rq.mo.wd) && com.bytedance.sdk.openadsdk.core.model.yt.qdl(this.fs)) {
            bch();
        }
        if (ud(rdpVar)) {
            com.bytedance.sdk.openadsdk.bch.ud.mzz.qdl(this, this.fs, lnr(getDynamicShowType()));
        }
        oth othVar = this.ax;
        if (othVar != null) {
            othVar.qdl(this.fs, this.to);
        }
    }

    protected mzz.qdl lnr(int i) {
        return new mzz.qdl(i);
    }

    @Override // com.bytedance.sdk.component.adexpress.ud.bjy
    public void a_(int i) {
        com.bytedance.sdk.component.adexpress.ud.tvp tvpVar = this.car;
        if (tvpVar != null) {
            if (!this.qdl) {
                tvpVar.jpc();
            }
            this.car.tvp();
            ((exu) this.car).rq();
        }
        PAGExpressAdWrapperListener pAGExpressAdWrapperListener = this.mzz;
        if (pAGExpressAdWrapperListener != null) {
            pAGExpressAdWrapperListener.onRenderFail(this, com.bytedance.sdk.openadsdk.core.jpc.qdl(i), i);
        }
        oth othVar = this.ax;
        if (othVar != null) {
            othVar.qdl(this.fs, this.to);
        }
    }

    public boolean jyq() {
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        return mmlVar != null && (mmlVar instanceof jyq);
    }

    public int getDynamicShowType() {
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar != null) {
            return mmlVar.lnr();
        }
        return 0;
    }

    public JSONObject qdl(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        if (!(this.koa instanceof bch)) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            int renderEngineCacheType = getRenderEngineCacheType();
            if (ljhVar != null) {
                if (ljhVar.xdk() != null && ljhVar.xdk().fs()) {
                    jSONObject.put("engine_version", ljhVar.xdk().rq());
                } else if (ljhVar.kr() != null) {
                    jSONObject.put("engine_version", "v3");
                } else {
                    jSONObject.put("engine_version", i.f2373a);
                }
            }
            jSONObject.put("engine_type", renderEngineCacheType);
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    public int getRenderEngineCacheType() {
        to toVarBjy;
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (!(mmlVar instanceof bch) || (toVarBjy = ((bch) mmlVar).bjy()) == null) {
            return 0;
        }
        return toVarBjy.qdl();
    }

    public int getExpectExpressWidth() {
        return Float.valueOf(this.vu).intValue();
    }

    public int getExpectExpressHeight() {
        return Float.valueOf(this.rc).intValue();
    }

    public hkc getJsObject() {
        bch bchVar = this.irn;
        if (bchVar != null) {
            return bchVar.jtx();
        }
        return null;
    }

    private boolean kdv() {
        return TextUtils.equals(this.to, "fullscreen_interstitial_ad") || TextUtils.equals(this.to, "rewarded_video") || TextUtils.equals("open_ad", this.to) || bch.ud(this.to) || TextUtils.equals(this.to, "embeded_ad");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        try {
            int i3 = Integer.parseInt(String.valueOf(charSequence));
            ud(i3, i);
            com.bytedance.sdk.openadsdk.core.rq.lnr.ud udVar = this.hkc;
            if (udVar != null) {
                udVar.qdl(i3);
            }
        } catch (NumberFormatException unused) {
        }
    }

    public void setSoundMute(boolean z) {
        this.oth = z;
        com.bytedance.sdk.component.adexpress.ud.ud udVar = this.bqt;
        if (udVar != null && udVar.ud() != null) {
            this.bqt.ud().setSoundMute(z);
        }
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar instanceof com.bytedance.sdk.openadsdk.core.rq.mo.mml) {
            ((com.bytedance.sdk.openadsdk.core.rq.mo.mml) mmlVar).setSoundMute(z);
        }
    }

    protected void ud(int i, int i2) {
        int iMin;
        if (TextUtils.equals(this.to, "banner_ad")) {
            return;
        }
        int i3 = this.ljh;
        int i4 = ((i2 < i3 || i3 < 0 || !(this.bch || TextUtils.equals(this.to, "open_ad"))) && !((i == 0 && TextUtils.equals(this.to, "open_ad")) || mzz() == 5)) ? 0 : 1;
        if (i2 <= this.ljh) {
            com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.fs;
            if (ljhVar != null && ljhVar.tdy() != null) {
                iMin = (int) (Math.min(this.ljh, this.fs.tdy().mo() * ((double) this.fs.tdy().oth())) - ((double) i2));
            } else {
                iMin = this.ljh - i2;
            }
        } else {
            iMin = 0;
        }
        com.bytedance.sdk.component.adexpress.ud.ud udVar = this.bqt;
        if (udVar != null && udVar.ud() != null) {
            this.bqt.ud().setTime(String.valueOf(i), i4, iMin, false);
        }
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar instanceof com.bytedance.sdk.openadsdk.core.rq.mo.mml) {
            ((com.bytedance.sdk.openadsdk.core.rq.mo.mml) mmlVar).setTime(String.valueOf(i), i4, iMin, false);
        }
    }

    public void oth() {
        com.bytedance.sdk.openadsdk.core.model.mml mmlVarZm;
        com.bytedance.sdk.openadsdk.core.fs.mml mmlVarQdl;
        com.bytedance.sdk.openadsdk.core.model.ljh ljhVar = this.fs;
        if (ljhVar == null || (mmlVarZm = ljhVar.zm()) == null || (mmlVarQdl = mmlVarZm.qdl()) == null) {
            return;
        }
        mmlVarQdl.mzz(getVideoProgress());
    }

    public void setVastVideoHelper(com.bytedance.sdk.openadsdk.core.mml.tvp tvpVar) {
        this.ra = tvpVar;
    }

    public boolean ljh() {
        return this.ag.get();
    }

    public void ud(int i, String str) {
        hkc hkcVarJtx;
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if (mmlVar == null || !(mmlVar instanceof bch) || (hkcVarJtx = ((bch) mmlVar).jtx()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", i);
            jSONObject.put("flag", str);
            hkcVarJtx.qdl("onVideoPaused", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void bch() {
        com.bytedance.sdk.openadsdk.core.rq.lnr.ud udVar = new com.bytedance.sdk.openadsdk.core.rq.lnr.ud(this.tvp, this.fs);
        this.hkc = udVar;
        udVar.qdl(this);
        this.hkc.qdl(new com.bytedance.sdk.openadsdk.core.rq.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.core.tvp.aaj.7
            @Override // com.bytedance.sdk.openadsdk.core.rq.lnr.qdl
            public void qdl(View view, int i, com.bytedance.sdk.component.adexpress.lnr lnrVar) {
                qdl(view, i, lnrVar);
            }
        });
    }

    public void qdl(com.bytedance.sdk.component.adexpress.ud.mml mmlVar) {
        if (this.hkc == null) {
            return;
        }
        try {
            if (mmlVar instanceof com.bytedance.sdk.openadsdk.core.rq.mo.wd) {
                ViewGroup viewGroup = (ViewGroup) ((com.bytedance.sdk.openadsdk.core.rq.mo.wd) mmlVar).mo().rq();
                this.jyq = viewGroup;
                if (viewGroup != null) {
                    this.hkc.ud();
                    View viewLnr = this.hkc.lnr();
                    if (viewLnr != null) {
                        ViewGroup viewGroup2 = (ViewGroup) viewLnr.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(viewLnr);
                        }
                        this.jyq.addView(viewLnr, new ViewGroup.LayoutParams(-1, -1));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setVideoFrameChangeListener(com.bytedance.sdk.openadsdk.fs.wd wdVar) {
        if (this.irn == null || getJsObject() == null) {
            return;
        }
        getJsObject().qdl(wdVar);
    }

    public void setVideoBusiness(com.bytedance.sdk.openadsdk.core.exu.mml.ud udVar) {
        bch bchVar = this.irn;
        if (bchVar != null) {
            bchVar.qdl(udVar);
        }
    }

    public void wd(int i) {
        com.bytedance.sdk.component.adexpress.ud.mml<? extends View> mmlVar = this.koa;
        if ((mmlVar instanceof com.bytedance.sdk.openadsdk.core.rq.mo.wd) && i == 4) {
            ((com.bytedance.sdk.openadsdk.core.rq.mo.wd) mmlVar).to();
        }
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, AdSlot adSlot, String str, boolean z, boolean z2) {
        if (ljhVar == null) {
            return;
        }
        this.to = str;
        this.fs = ljhVar;
        this.rq = adSlot;
        this.oth = z;
        this.gy = z2;
        int iRa = ljhVar.ra();
        this.ud = iRa;
        if (iRa != 10) {
            return;
        }
        this.hzv = true;
        wd();
        exc();
        this.hzv = false;
    }
}
