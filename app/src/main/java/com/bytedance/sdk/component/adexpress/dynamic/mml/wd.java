package com.bytedance.sdk.component.adexpress.dynamic.mml;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.adexpress.dynamic.mzz.rq;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    public JSONObject lnr;
    private mo mml;
    private String mo;
    private mzz mzz;
    public int qdl;
    public String ud;

    public wd(mzz mzzVar) {
        this.mzz = mzzVar;
        this.qdl = mzzVar.qdl();
        this.ud = mzzVar.lnr();
        this.lnr = mzzVar.mzz().en();
        this.mo = mzzVar.mml();
        if (com.bytedance.sdk.component.adexpress.mml.lnr() == 1) {
            this.mml = mzzVar.wd();
        } else {
            this.mml = mzzVar.mzz();
        }
        if (com.bytedance.sdk.component.adexpress.mml.ud()) {
            this.mml = mzzVar.mzz();
        }
    }

    public int qdl() {
        return (int) this.mml.rdp();
    }

    public int ud() {
        return (int) this.mml.yt();
    }

    public int lnr() {
        return (int) this.mml.bjy();
    }

    public int mml() {
        return (int) this.mml.jtx();
    }

    public float mzz() {
        return this.mml.jl();
    }

    public String mo() {
        if (this.qdl == 0) {
            if (!TextUtils.isEmpty(this.ud)) {
                return this.ud;
            }
            return this.lnr.optString(com.bytedance.sdk.component.adexpress.mml.wd.lnr(com.bytedance.sdk.component.adexpress.mml.qdl()));
        }
        return "";
    }

    public int wd() {
        return qdl(this.mml.oth());
    }

    public int jpc() {
        String strJyq = this.mml.jyq();
        if ("left".equals(strJyq)) {
            return 17;
        }
        if (TtmlNode.CENTER.equals(strJyq)) {
            return 4;
        }
        return TtmlNode.RIGHT.equals(strJyq) ? 3 : 2;
    }

    public int tvp() {
        int iJpc = jpc();
        if (iJpc == 4) {
            return 17;
        }
        return iJpc == 3 ? GravityCompat.END : GravityCompat.START;
    }

    public String to() {
        int i = this.qdl;
        if (i == 2 || i == 13) {
            return this.ud;
        }
        return "";
    }

    public String rq() {
        if (this.qdl == 1) {
            return this.ud;
        }
        return "";
    }

    public String fs() {
        return this.mo;
    }

    public double exu() {
        if (this.qdl == 11) {
            try {
                return !com.bytedance.sdk.component.adexpress.mml.ud() ? (int) r0 : Double.parseDouble(this.ud);
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double rdp() {
        return this.mml.exc();
    }

    public float bjy() {
        return this.mml.rq();
    }

    public int jtx() {
        return qdl(this.mml.xmv());
    }

    public float yt() {
        return this.mml.fs();
    }

    public int jl() {
        return this.mml.ca();
    }

    public int exc() {
        return this.mml.ygv();
    }

    public boolean aaj() {
        return this.mml.gsp();
    }

    public String jyq() {
        return this.mml.bch();
    }

    public void qdl(float f) {
        this.mml.qdl(f);
    }

    public boolean oth() {
        return this.mml.om();
    }

    public int ljh() {
        return this.mml.cx();
    }

    public String bch() {
        return this.mml.gy();
    }

    public String uw() {
        return this.mml.nts();
    }

    public long xmv() {
        return this.mml.eta();
    }

    public int bqt() {
        String strGy = this.mml.gy();
        if ("skip-with-time-skip-btn".equals(this.mzz.ud()) || "skip".equals(this.mzz.ud()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.mzz.ud())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.mzz.ud()) && !"skip-with-time".equals(this.mzz.ud())) {
            if (this.qdl == 10 && TextUtils.equals(this.mml.ax(), "click")) {
                return 5;
            }
            if (gg() && rzg()) {
                return 0;
            }
            if (gg()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.mzz.ud())) {
                return 3;
            }
            if (!TextUtils.isEmpty(strGy) && !strGy.equals("none")) {
                if (strGy.equals("video") || (this.mzz.qdl() == 7 && TextUtils.equals(strGy, Constants.NORMAL))) {
                    return (com.bytedance.sdk.component.adexpress.mml.ud() && this.mzz.mzz() != null && this.mzz.mzz().hd()) ? 11 : 4;
                }
                if (strGy.equals(Constants.NORMAL)) {
                    return 1;
                }
                return (strGy.equals("creative") || "slide".equals(this.mml.ax())) ? 2 : 0;
            }
        }
        return 0;
    }

    private boolean gg() {
        return (com.bytedance.sdk.component.adexpress.mml.ud() && (this.mzz.ud().contains("logo-union") || this.mzz.ud().contains("logounion") || this.mzz.ud().contains("logoad"))) || "logo-union".equals(this.mzz.ud()) || "logounion".equals(this.mzz.ud()) || "logoad".equals(this.mzz.ud());
    }

    public int koa() {
        return qdl(this.mml.ljh());
    }

    public double vu() {
        return this.mml.jpc();
    }

    public int rc() {
        return this.mml.lnr();
    }

    public int kdv() {
        return this.mml.ud();
    }

    public int ekw() {
        return this.mml.mzz();
    }

    public int hkc() {
        return this.mml.mml();
    }

    public int hzv() {
        return this.mml.tvp();
    }

    public String fco() {
        return this.mml.to();
    }

    public String mrf() {
        return this.mml.ax();
    }

    private boolean rzg() {
        if (com.bytedance.sdk.component.adexpress.mml.ud()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.ud) && this.ud.contains("adx:")) || rq.ud();
    }

    public static int qdl(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return -16777216;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (str.startsWith("rgba") && (strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) != null) {
            try {
                if (strArrSplit.length == 4) {
                    return (((int) ((Float.parseFloat(strArrSplit[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(strArrSplit[0])) << 16) | (((int) Float.parseFloat(strArrSplit[1])) << 8) | ((int) Float.parseFloat(strArrSplit[2]));
                }
            } catch (NumberFormatException unused) {
                return 0;
            }
        }
        return -16777216;
    }

    public static float[] ud(String str) {
        String[] strArrSplit = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (strArrSplit != null && strArrSplit.length == 4) {
            return new float[]{Float.parseFloat(strArrSplit[0]), Float.parseFloat(strArrSplit[1]), Float.parseFloat(strArrSplit[2]), Float.parseFloat(strArrSplit[3])};
        }
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public boolean qdl(int i) {
        mzz mzzVar = this.mzz;
        if (mzzVar == null) {
            return false;
        }
        if (i == 1) {
            this.mml = mzzVar.wd();
        } else {
            this.mml = mzzVar.mzz();
        }
        return this.mml != null;
    }

    public boolean gy() {
        return this.mml.kab();
    }

    public int ax() {
        return this.mml.qk();
    }

    public int ag() {
        return this.mml.ra();
    }

    public String wc() {
        return this.mml.mrf();
    }

    public boolean om() {
        return this.mml.jle();
    }

    public int cx() {
        return this.mml.wd();
    }

    public int yh() {
        return this.mml.tdy();
    }

    public int wak() {
        return this.mml.se();
    }

    public int gt() {
        return this.mml.xdk();
    }

    public int irn() {
        return this.mml.blf();
    }

    public boolean xi() {
        return this.mml.dps();
    }

    public String jjk() {
        return this.mml.vu();
    }

    public String zlt() {
        return this.mml.iw();
    }

    public String taz() {
        return this.mml.vc();
    }

    public boolean tid() {
        return this.mml.exu();
    }

    public boolean sy() {
        return this.mml.kdv();
    }

    public String car() {
        return this.mml.rc();
    }

    public int mlb() {
        return this.mml.ekw();
    }

    public int lte() {
        return this.mml.hkc();
    }

    public double dk() {
        return this.mml.hzv();
    }

    public double ijp() {
        return this.mml.fco();
    }

    public int zy() {
        return this.mml.lme();
    }

    public String en() {
        return this.mml.kj();
    }

    public String nz() {
        return this.mml.zvv();
    }

    public boolean kab() {
        return this.mml.bx();
    }

    public int ra() {
        return this.mml.zpu();
    }

    public int qk() {
        return this.mml.jnw();
    }

    public int tqd() {
        return this.mml.jut();
    }

    public boolean fzn() {
        return this.mml.dps();
    }

    public String lq() {
        return this.mml.uw();
    }
}
