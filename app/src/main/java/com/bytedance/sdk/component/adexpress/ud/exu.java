package com.bytedance.sdk.component.adexpress.ud;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class exu {
    private int aaj;
    private double bch;
    private int bjy;
    private JSONObject bqt;
    private int ekw;
    private int exc;
    private String exu;
    private final String fco;
    private int fs;
    private final boolean hkc;
    private final String hzv;
    private int jl;
    private String jpc;
    private boolean jtx;
    private int jyq;
    private String kdv;
    private JSONObject koa;
    private String ljh;
    private String lnr;
    private tvp mml;
    private String mo;
    private int mzz;
    private int oth;
    private JSONObject qdl;
    private boolean rc;
    private Map<String, String> rdp;
    private long rq;
    private int to;
    private boolean tvp;
    private mzz ud;
    private int uw;
    private JSONObject vu;
    private String wd;
    private boolean xmv;
    private String yt;

    public exu(qdl qdlVar) {
        this.qdl = qdlVar.qdl;
        this.ud = qdlVar.ud;
        this.lnr = qdlVar.lnr;
        this.mml = qdlVar.mml;
        this.mzz = qdlVar.mzz;
        this.mo = qdlVar.mo;
        this.wd = qdlVar.wd;
        this.jpc = qdlVar.jpc;
        this.tvp = qdlVar.tvp;
        this.to = qdlVar.to;
        this.rq = qdlVar.rq;
        this.fs = qdlVar.fs;
        this.exu = qdlVar.exu;
        this.rdp = qdlVar.rdp;
        this.bjy = qdlVar.bjy;
        this.jtx = qdlVar.jtx;
        this.yt = qdlVar.yt;
        this.jl = qdlVar.jl;
        this.exc = qdlVar.exc;
        this.aaj = qdlVar.aaj;
        this.jyq = qdlVar.jyq;
        this.oth = qdlVar.oth;
        this.ljh = qdlVar.ljh;
        this.bch = qdlVar.bch;
        this.uw = qdlVar.uw;
        this.xmv = qdlVar.xmv;
        this.bqt = qdlVar.bqt;
        this.koa = qdlVar.koa;
        this.vu = qdlVar.vu;
        this.rc = qdlVar.rc;
        this.kdv = qdlVar.kdv;
        this.ekw = qdlVar.fco;
        this.hkc = qdlVar.ekw;
        this.hzv = qdlVar.hkc;
        this.fco = qdlVar.hzv;
    }

    public boolean qdl() {
        return this.xmv;
    }

    public double ud() {
        return this.bch;
    }

    public JSONObject lnr() {
        mzz mzzVar;
        if (this.qdl == null && (mzzVar = this.ud) != null) {
            this.qdl = mzzVar.qdl();
        }
        return this.qdl;
    }

    public String mml() {
        return this.lnr;
    }

    public tvp mzz() {
        return this.mml;
    }

    public int mo() {
        return this.mzz;
    }

    public int wd() {
        return this.uw;
    }

    public boolean jpc() {
        return this.tvp;
    }

    public long tvp() {
        return this.rq;
    }

    public int to() {
        return this.fs;
    }

    public Map<String, String> rq() {
        return this.rdp;
    }

    public int fs() {
        return this.bjy;
    }

    public boolean exu() {
        return this.jtx;
    }

    public String rdp() {
        return this.yt;
    }

    public int bjy() {
        return this.jl;
    }

    public int jtx() {
        return this.exc;
    }

    public int yt() {
        return this.aaj;
    }

    public JSONObject jl() {
        return this.bqt;
    }

    public JSONObject exc() {
        return this.koa;
    }

    public JSONObject aaj() {
        return this.vu;
    }

    public int jyq() {
        return this.jyq;
    }

    public int oth() {
        return this.oth;
    }

    public boolean ljh() {
        return this.rc;
    }

    public String bch() {
        return this.kdv;
    }

    public int uw() {
        return this.ekw;
    }

    public boolean xmv() {
        return this.hkc;
    }

    public String bqt() {
        return this.hzv;
    }

    public String koa() {
        return this.fco;
    }

    public static class qdl {
        private int aaj;
        private double bch;
        private int bjy;
        private JSONObject bqt;
        private int exc;
        private String exu;
        private int fco;
        private int fs;
        private String hkc;
        private String hzv;
        private int jl;
        private String jpc;
        private boolean jtx;
        private int jyq;
        private String kdv;
        private JSONObject koa;
        private String ljh;
        private String lnr;
        private tvp mml;
        private String mo;
        private int mzz;
        private int oth;
        private JSONObject qdl;
        private boolean rc;
        private Map<String, String> rdp;
        private long rq;
        private int to;
        private boolean tvp;
        private mzz ud;
        private int uw;
        private JSONObject vu;
        private String wd;
        private String yt;
        private boolean xmv = true;
        private boolean ekw = true;

        public qdl qdl(mzz mzzVar) {
            this.ud = mzzVar;
            return this;
        }

        public qdl qdl(boolean z) {
            this.xmv = z;
            return this;
        }

        public qdl qdl(String str) {
            this.lnr = str;
            return this;
        }

        public qdl qdl(tvp tvpVar) {
            this.mml = tvpVar;
            return this;
        }

        public qdl qdl(int i) {
            this.mzz = i;
            return this;
        }

        public qdl ud(String str) {
            this.mo = str;
            return this;
        }

        public qdl lnr(String str) {
            this.wd = str;
            return this;
        }

        public qdl mml(String str) {
            this.jpc = str;
            return this;
        }

        public qdl ud(boolean z) {
            this.tvp = z;
            return this;
        }

        public qdl lnr(boolean z) {
            this.ekw = z;
            return this;
        }

        public qdl ud(int i) {
            this.to = i;
            return this;
        }

        public qdl qdl(long j) {
            this.rq = j;
            return this;
        }

        public qdl lnr(int i) {
            this.fs = i;
            return this;
        }

        public qdl qdl(Map<String, String> map) {
            this.rdp = map;
            return this;
        }

        public qdl mml(int i) {
            this.bjy = i;
            return this;
        }

        public qdl mml(boolean z) {
            this.jtx = z;
            return this;
        }

        public qdl mzz(String str) {
            this.yt = str;
            return this;
        }

        public qdl mzz(int i) {
            this.uw = i;
            return this;
        }

        public qdl mzz(boolean z) {
            this.rc = z;
            return this;
        }

        public qdl mo(String str) {
            this.kdv = str;
            return this;
        }

        public qdl mo(int i) {
            this.fco = i;
            return this;
        }

        public exu qdl() {
            return new exu(this);
        }

        public qdl qdl(double d) {
            this.bch = d;
            return this;
        }

        public qdl wd(String str) {
            this.hkc = str;
            return this;
        }

        public qdl jpc(String str) {
            this.hzv = str;
            return this;
        }
    }
}
