package com.bykv.vk.openvk.qdl.qdl.qdl.lnr;

import android.os.Build;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class lnr implements Serializable {
    private int aaj;
    private int bjy;
    private boolean exc;
    private String exu;
    private boolean jl;
    private String jpc;
    private String jtx;
    private int jyq;
    public int lnr;
    private ud mo;
    private int rdp;
    private boolean tvp;
    public String ud;
    private ud wd;
    private int xmv;
    private long yt;
    private int to = 204800;
    private int rq = 0;
    private int fs = 0;
    protected float qdl = -1.0f;
    public final HashMap<String, Object> mml = new HashMap<>();
    private int oth = 10000;
    private int ljh = 10000;
    private int bch = 10000;
    private int uw = 0;
    public int mzz = 1;
    private JSONObject bqt = new JSONObject();

    public lnr(String str, ud udVar, ud udVar2, int i, int i2) {
        this.aaj = 0;
        this.jyq = 0;
        this.jpc = str;
        this.mo = udVar;
        this.wd = udVar2;
        this.aaj = i;
        this.jyq = i2;
    }

    public void qdl(int i) {
        this.xmv = i;
    }

    public boolean qdl() {
        int i = this.xmv;
        return i == 1 || i == 2;
    }

    public boolean ud() {
        return this.xmv == 2;
    }

    public JSONObject lnr() {
        return this.bqt;
    }

    public int mml() {
        return this.bqt.optInt("pitaya_cache_size", 0);
    }

    public String mzz() {
        return this.jpc;
    }

    public void qdl(String str) {
        this.jpc = str;
    }

    public int mo() {
        if (rdp()) {
            return this.wd.bjy();
        }
        ud udVar = this.mo;
        if (udVar != null) {
            return udVar.bjy();
        }
        return 0;
    }

    public boolean wd() {
        return this.exc;
    }

    public void ud(String str) {
        this.exu = str;
    }

    public int jpc() {
        return this.rdp;
    }

    public void ud(int i) {
        this.rdp = i;
    }

    public int tvp() {
        return this.bjy;
    }

    public void lnr(int i) {
        this.bjy = i;
    }

    public void lnr(String str) {
        this.jtx = str;
    }

    public long to() {
        return this.yt;
    }

    public void qdl(long j) {
        this.yt = j;
    }

    public boolean rq() {
        return this.jl;
    }

    public void qdl(boolean z) {
        this.jl = z;
    }

    public long fs() {
        if (rdp()) {
            return this.wd.mzz();
        }
        ud udVar = this.mo;
        if (udVar != null) {
            return udVar.mzz();
        }
        return 0L;
    }

    public boolean exu() {
        if (rdp()) {
            return this.wd.jyq();
        }
        ud udVar = this.mo;
        if (udVar != null) {
            return udVar.jyq();
        }
        return true;
    }

    public void mml(String str) {
        this.ud = str;
    }

    public void mml(int i) {
        this.lnr = i;
    }

    public boolean rdp() {
        ud udVar;
        if (this.jyq == 1 && (udVar = this.wd) != null && !TextUtils.isEmpty(udVar.rq())) {
            if (com.bykv.vk.openvk.qdl.qdl.qdl.lnr.mo() == 2) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return true;
                }
            } else if (this.aaj == 1) {
                return true;
            }
        }
        return false;
    }

    public float bjy() {
        float f = this.qdl;
        if (f != -1.0f) {
            return f;
        }
        if (rdp()) {
            return this.wd.jpc();
        }
        ud udVar = this.mo;
        if (udVar != null) {
            return udVar.jpc();
        }
        return -1.0f;
    }

    public String jtx() {
        if (rdp()) {
            return this.wd.rq();
        }
        ud udVar = this.mo;
        if (udVar != null) {
            return udVar.rq();
        }
        return null;
    }

    public String yt() {
        if (rdp()) {
            return this.wd.rdp();
        }
        ud udVar = this.mo;
        if (udVar != null) {
            return udVar.rdp();
        }
        return null;
    }

    public int jl() {
        return this.aaj;
    }

    public synchronized void qdl(String str, Object obj) {
        this.mml.put(str, obj);
    }

    public synchronized Object mzz(String str) {
        return this.mml.get(str);
    }

    public int exc() {
        return this.oth;
    }

    public void mzz(int i) {
        this.oth = i;
    }

    public int aaj() {
        return this.ljh;
    }

    public void mo(int i) {
        this.ljh = i;
    }

    public int jyq() {
        return this.bch;
    }

    public void wd(int i) {
        this.bch = i;
    }

    public int oth() {
        return this.uw;
    }

    public void jpc(int i) {
        this.uw = i;
    }

    public ud ljh() {
        return this.mo;
    }

    public ud bch() {
        return this.wd;
    }

    public void ud(boolean z) {
        this.tvp = z;
    }

    public boolean uw() {
        return this.tvp;
    }
}
