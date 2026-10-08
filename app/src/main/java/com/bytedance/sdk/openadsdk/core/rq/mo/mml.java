package com.bytedance.sdk.openadsdk.core.rq.mo;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.bjy;
import com.bytedance.adsdk.ugeno.core.exu;
import com.bytedance.adsdk.ugeno.core.fs;
import com.bytedance.adsdk.ugeno.core.jtx;
import com.bytedance.adsdk.ugeno.mml.mo;
import com.bytedance.sdk.component.adexpress.ud.rdp;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import com.bytedance.sdk.openadsdk.core.model.jtx;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.model.vu;
import com.bytedance.sdk.openadsdk.core.settings.rq;
import com.bytedance.sdk.openadsdk.core.tvp.aaj;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.fco;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mml implements bjy, jtx, com.bytedance.sdk.component.adexpress.dynamic.mml, com.bytedance.sdk.component.adexpress.ud.mml<View> {
    private static long bqt = 0;
    protected static int jyq = 24;
    private static float kdv;
    private static float koa;
    private static float rc;
    private static float vu;
    protected JSONObject bch;
    protected float bjy;
    private mzz ekw;
    protected long exc;
    protected com.bytedance.adsdk.ugeno.ud.lnr exu;
    protected com.bytedance.adsdk.ugeno.ud.lnr fs;
    private aaj hkc;
    protected long jl;
    protected com.bytedance.sdk.component.adexpress.ud.jpc jpc;
    protected float jtx;
    protected com.bytedance.adsdk.ugeno.ud.lnr<View> lnr;
    protected JSONObject mml;
    protected qdl mo;
    protected ljh mzz;
    protected String oth;
    protected fs qdl;
    protected float rdp;
    protected rdp to;
    protected com.bytedance.sdk.openadsdk.core.tvp.bjy tvp;
    protected Context ud;
    private com.bytedance.sdk.component.adexpress.ud.wd uw;
    protected FrameLayout wd;
    private boolean xmv;
    protected float yt;
    protected boolean aaj = true;
    public SparseArray<lnr.qdl> ljh = new SparseArray<>();
    private String hzv = "";
    private final com.bytedance.sdk.component.jpc.jpc fco = new com.bytedance.sdk.component.jpc.jpc("ugen_render_template") { // from class: com.bytedance.sdk.openadsdk.core.rq.mo.mml.1
        @Override // java.lang.Runnable
        public void run() {
            mml mmlVar = mml.this;
            mmlVar.mml = mmlVar.qdl();
            if (mml.this.hkc == null) {
                mml.this.hzv = "expressView is null";
            } else {
                mml mmlVar2 = mml.this;
                mmlVar2.hzv = mmlVar2.hkc.getUgenTemplateErrorReason();
            }
            com.bytedance.sdk.openadsdk.core.rdp.lnr().post(mml.this.mrf);
        }
    };
    private final Runnable mrf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.rq.mo.mml.2
        @Override // java.lang.Runnable
        public void run() {
            if (mml.this.uw != null) {
                mml mmlVar = mml.this;
                mmlVar.ud(mmlVar.uw);
            }
        }
    };
    private boolean gy = false;
    protected AtomicBoolean rq = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void onvideoComplate() {
    }

    public void qdl(long j, long j2) {
    }

    @Override // com.bytedance.adsdk.ugeno.core.bjy
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, String str, mo.qdl qdlVar) {
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTimeUpdate(int i) {
    }

    public com.bytedance.adsdk.ugeno.ud.lnr wd() {
        return null;
    }

    static {
        if (yt.qdl() != null) {
            jyq = yt.ud();
        }
    }

    public mml(Context context, ljh ljhVar, boolean z, qdl qdlVar, ViewGroup viewGroup) {
        this.ud = context;
        this.xmv = z;
        this.qdl = new fs(context);
        this.mzz = ljhVar;
        this.mo = qdlVar;
        this.wd = new FrameLayout(context);
        if (viewGroup instanceof aaj) {
            this.hkc = (aaj) viewGroup;
        }
        this.oth = qdlVar.mml();
        JSONObject jSONObjectUd = ud();
        this.bch = jSONObjectUd;
        this.ekw = new mzz(this.ud, this.mzz, this.oth, jSONObjectUd);
    }

    public void qdl(ljh ljhVar, boolean z, qdl qdlVar, ViewGroup viewGroup) {
        this.mzz = ljhVar;
        this.mo = qdlVar;
        this.oth = qdlVar.mml();
        this.bch = ud();
        if (viewGroup instanceof aaj) {
            this.hkc = (aaj) viewGroup;
        }
        this.xmv = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.ud.mml
    public void qdl(com.bytedance.sdk.component.adexpress.ud.wd wdVar) {
        this.uw = wdVar;
        fco.ud(this.fco);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(com.bytedance.sdk.component.adexpress.ud.wd wdVar) {
        if (this instanceof com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml) {
            this.mo.mzz().mo();
        } else {
            this.mo.ekw().qdl();
        }
        if (this.mml == null) {
            wdVar.qdl(133, "ugen template is null real reason is " + this.hzv);
            return;
        }
        if (this.bch == null) {
            wdVar.qdl(133, "ugen data is null");
            return;
        }
        int iMml = mml();
        if (this.qdl.qdl()) {
            List<String> listUd = this.qdl.ud();
            if (listUd == null) {
                wdVar.qdl(TsExtractor.TS_STREAM_TYPE_DTS, "unknow widget");
                return;
            }
            wdVar.qdl(TsExtractor.TS_STREAM_TYPE_DTS, "unknow widget;" + listUd.toString());
            return;
        }
        if (iMml != 0) {
            wdVar.qdl(iMml, "ugen render fail");
            return;
        }
        if (this.lnr != null) {
            ud udVar = new ud();
            this.to = udVar;
            udVar.qdl(true);
            this.to.qdl(lnr());
            setSoundMute(this.xmv);
            tvp();
            com.bytedance.adsdk.ugeno.ud.lnr lnrVarJpc = jpc();
            this.fs = lnrVarJpc;
            if (lnrVarJpc != null && (lnrVarJpc instanceof com.bytedance.sdk.openadsdk.core.rq.ud.mzz.ud)) {
                ((ud) this.to).qdl((FrameLayout) ((com.bytedance.sdk.openadsdk.core.rq.ud.mzz.ud) lnrVarJpc).mml());
            }
            mzz mzzVar = this.ekw;
            if (mzzVar != null) {
                mzzVar.qdl();
            }
            com.bytedance.adsdk.ugeno.ud.lnr lnrVarMo = mo();
            this.exu = lnrVarMo;
            if (lnrVarMo != null && (lnrVarMo instanceof com.bytedance.adsdk.ugeno.tvp.ud.ud)) {
                ((ud) this.to).ud((FrameLayout) lnrVarMo.rq());
            }
            if (vu.lnr(this.mzz)) {
                com.bytedance.adsdk.ugeno.ud.lnr lnrVarWd = wd();
                if (lnrVarWd instanceof com.bytedance.sdk.openadsdk.core.rq.ud.ud.ud) {
                    ((ud) this.to).lnr(((com.bytedance.sdk.openadsdk.core.rq.ud.ud.ud) lnrVarWd).mml());
                }
            }
            int iFco = this.lnr.fco();
            int iMrf = this.lnr.mrf();
            this.wd.removeAllViews();
            this.wd.addView(this.lnr.rq(), new FrameLayout.LayoutParams(iFco, iMrf));
            float fVu = this.mo.vu();
            float fRc = this.mo.rc();
            float fUd = ax.ud(this.ud, fVu);
            float fUd2 = ax.ud(this.ud, fRc);
            if (lnr() != 7) {
                this.wd.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            } else if (fRc <= 0.0f) {
                this.wd.setLayoutParams(new FrameLayout.LayoutParams((int) fUd, -2));
            } else {
                this.wd.setLayoutParams(new FrameLayout.LayoutParams((int) fUd, (int) fUd2));
            }
            if (fRc <= 0.0f || fVu <= 0.0f) {
                this.wd.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                int iLnr = ax.lnr(this.ud, this.wd.getMeasuredWidth());
                int iLnr2 = ax.lnr(this.ud, this.wd.getMeasuredHeight());
                this.to.qdl(iLnr);
                this.to.ud(iLnr2);
            } else {
                this.to.qdl(fVu);
                this.to.ud(fRc);
            }
            if (this.rq.get()) {
                wdVar.qdl(137, "ugen render timeout");
                return;
            } else {
                this.qdl.qdl(this.lnr, "renderDidFinish", new Object[0]);
                wdVar.qdl(this.wd, this.to);
                return;
            }
        }
        wdVar.qdl(TsExtractor.TS_STREAM_TYPE_DTS, "ugen render error");
    }

    protected JSONObject qdl() {
        return this.mo.lnr();
    }

    protected JSONObject ud() {
        return this.mo.kdv();
    }

    protected int mml() {
        this.qdl.qdl((bjy) this);
        this.qdl.qdl((jtx) this);
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVarQdl = this.qdl.qdl(this.mml);
        this.lnr = lnrVarQdl;
        mzz mzzVar = this.ekw;
        if (mzzVar != null && lnrVarQdl != null) {
            mzzVar.qdl(lnrVarQdl);
        }
        if (!(this instanceof com.bytedance.sdk.openadsdk.core.rq.mo.qdl.mml)) {
            this.mo.ekw().ud();
            this.mo.ekw().lnr();
        }
        this.qdl.ud(this.bch);
        return 0;
    }

    public void qdl(boolean z) {
        this.rq.set(z);
    }

    public void qdl(com.bytedance.sdk.component.adexpress.ud.jpc jpcVar) {
        this.jpc = jpcVar;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.tvp.bjy bjyVar) {
        this.tvp = bjyVar;
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar) {
        mzz mzzVar2 = this.ekw;
        if (mzzVar2 != null) {
            mzzVar2.qdl(mzzVar);
        }
    }

    public com.bytedance.adsdk.ugeno.ud.lnr mo() {
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.lnr;
        if (lnrVar == null) {
            return null;
        }
        return lnrVar.mo("PlayableComponent");
    }

    @Override // com.bytedance.adsdk.ugeno.core.bjy
    public void qdl(exu exuVar, bjy.ud udVar, bjy.qdl qdlVar) {
        if (exuVar == null) {
            return;
        }
        if (exuVar.ud() == 1 || exuVar.ud() == 4) {
            qdl(exuVar);
        }
        if (exuVar.ud() == 10) {
            qdl(exuVar.lnr());
        }
        if (udVar == null || exuVar.mml() == null) {
            return;
        }
        udVar.qdl(exuVar.mml());
    }

    private void qdl(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz;
        if (this.lnr == null || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        String strOptString2 = jSONObject.optString("nodeId");
        if (TextUtils.isEmpty(strOptString2) || (lnrVarMzz = this.lnr.mzz(strOptString2)) == 0) {
            return;
        }
        if (TextUtils.equals(strOptString, "onShow")) {
            lnrVarMzz.lnr(0);
        } else if (TextUtils.equals(strOptString, "onDismiss")) {
            lnrVarMzz.lnr(8);
        }
    }

    private void qdl(exu exuVar) {
        int i;
        JSONObject jSONObjectMml;
        boolean zQdl;
        int i2;
        String str;
        mzz mzzVar;
        mzz mzzVar2;
        mzz mzzVar3;
        if (this.jpc == null) {
            return;
        }
        String strOptString = exuVar.lnr().optString("type");
        if ("swiperLeft".equals(strOptString) && (mzzVar3 = this.ekw) != null) {
            mzzVar3.ud();
            return;
        }
        if ("swiperRight".equals(strOptString) && (mzzVar2 = this.ekw) != null) {
            mzzVar2.lnr();
            return;
        }
        i = 2;
        if (!"swiperClick".equals(strOptString) || (mzzVar = this.ekw) == null) {
            jSONObjectMml = null;
            zQdl = false;
            i2 = 0;
        } else {
            zQdl = mzzVar.qdl(exuVar);
            jSONObjectMml = this.ekw.mml();
            i2 = 2;
        }
        strOptString.hashCode();
        switch (strOptString) {
            case "privacy":
                i = 7;
                break;
            case "feedback":
                i = 3;
                break;
            case "mute":
                i = 5;
                break;
            case "skip":
                i = 6;
                break;
            case "video":
                i = 4;
                break;
            case "creative":
                break;
            default:
                i = i2;
                break;
        }
        com.bytedance.adsdk.ugeno.ud.lnr lnrVarQdl = exuVar.qdl();
        jtx.qdl qdlVarQdl = new jtx.qdl().mml(this.rdp).lnr(this.bjy).ud(this.jtx).qdl(this.yt).ud(this.jl).qdl(this.exc).qdl(this.ljh).qdl(exuVar.ud() != 1 || this.aaj);
        if (lnrVarQdl == null) {
            str = "";
        } else {
            str = lnrVarQdl.hzv() + "_" + lnrVarQdl.hkc();
        }
        this.jpc.qdl(exuVar.qdl().rq(), i, qdlVarQdl.qdl(str).ud(zQdl).ud(jSONObjectMml).qdl());
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00af  */
    @Override // com.bytedance.adsdk.ugeno.core.jtx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rq.mo.mml.qdl(com.bytedance.adsdk.ugeno.ud.lnr, android.view.MotionEvent):void");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setTime(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.lnr == null) {
            return;
        }
        boolean z2 = i == 1;
        qdl(charSequence, z2, i2, z);
        ud(charSequence, z2, i2, z);
    }

    private void qdl(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz;
        int i2;
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.lnr;
        if (lnrVar == null || (lnrVarMzz = lnrVar.mzz("countdown")) == 0) {
            return;
        }
        View viewRq = lnrVarMzz.rq();
        if (viewRq instanceof TextView) {
            try {
                i2 = Integer.parseInt((String) charSequence);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.aaj.lnr("UGenRender", "parse duration exception", charSequence);
                i2 = 0;
            }
            if (z2 || i2 <= 0 || this.gy) {
                viewRq.setVisibility(8);
                return;
            }
            viewRq.setVisibility(0);
            if (!z && this.mo.qdl() && com.bytedance.sdk.component.adexpress.mml.mo.ud(this.mo.mml())) {
                ((TextView) viewRq).setText(String.format(com.bytedance.sdk.component.utils.ljh.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), "tt_reward_full_skip"), Integer.valueOf(i)));
                return;
            }
            if (!"open_ad".equals(this.mo.mml()) && this.mo.qdl()) {
                this.gy = true;
                viewRq.setVisibility(8);
            } else {
                ((TextView) viewRq).setText(((Object) charSequence) + "s");
            }
        }
    }

    private void ud(CharSequence charSequence, boolean z, int i, boolean z2) {
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz;
        View viewRq;
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.lnr;
        if (lnrVar == null || (lnrVarMzz = lnrVar.mzz("skip")) == 0 || (viewRq = lnrVarMzz.rq()) == null) {
            return;
        }
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        viewRq.setVisibility(i2);
    }

    private void tvp() {
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz;
        if (this.lnr == null) {
            return;
        }
        if (this.mzz.ks() && (lnrVarMzz = this.lnr.mzz("tvskip")) != 0) {
            lnrVarMzz.lnr(8);
        }
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz2 = this.lnr.mzz("skip");
        if (lnrVarMzz2 != 0 && (lnrVarMzz2 instanceof com.bytedance.adsdk.ugeno.tvp.mml.lnr)) {
            if (!rq.lnr().rdp(String.valueOf(this.mzz.fz())) || this.mzz.taz() == 5 || this.mzz.taz() == 6 || this.mzz.ok() == 3) {
                ((com.bytedance.adsdk.ugeno.tvp.mml.lnr) lnrVarMzz2).bjy("local://tt_close_btn");
                lnrVarMzz2.ud();
            }
        }
    }

    protected com.bytedance.adsdk.ugeno.ud.lnr jpc() {
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.lnr;
        if (lnrVar == null) {
            return null;
        }
        return lnrVar.mzz("video");
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.mml
    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz;
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.lnr;
        if (lnrVar == null || (lnrVarMzz = lnrVar.mzz("mute")) == 0) {
            return;
        }
        if (z) {
            ((com.bytedance.adsdk.ugeno.tvp.mml.lnr) lnrVarMzz).bjy("local://tt_reward_full_mute");
        } else {
            ((com.bytedance.adsdk.ugeno.tvp.mml.lnr) lnrVarMzz).bjy("local://tt_reward_full_unmute");
        }
        lnrVarMzz.ud();
    }

    @Override // com.bytedance.sdk.component.adexpress.ud.mml
    public View mzz() {
        return this.wd;
    }

    @Override // com.bytedance.sdk.component.adexpress.ud.mml
    public int lnr() {
        return this.mzz.ra();
    }
}
