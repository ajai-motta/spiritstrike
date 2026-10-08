package com.bytedance.sdk.component.mo.qdl.mo;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    private String jpc;
    private final boolean lnr;
    private final String mo;
    private final int mzz;
    private final String qdl;
    private boolean rq;
    private final String ud;
    private String wd;
    private int mml = -1;
    private int tvp = 0;
    private String to = null;

    mml(String str, String str2, boolean z, int i, String str3) {
        this.qdl = str;
        this.ud = str2;
        this.lnr = z;
        this.mzz = i;
        this.mo = str3;
    }

    public String qdl() {
        return this.qdl;
    }

    public String ud() {
        return this.ud;
    }

    public boolean lnr() {
        return this.lnr;
    }

    public int mml() {
        return this.mml;
    }

    public void qdl(int i) {
        this.mml = i;
    }

    public int mzz() {
        return this.mzz;
    }

    public String mo() {
        return this.mo;
    }

    public void qdl(String str) {
        this.wd = str;
    }

    public String wd() {
        return this.wd;
    }

    public void ud(int i) {
        this.tvp = i;
        if (i == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.wd)) {
            this.wd = String.valueOf(this.tvp);
            return;
        }
        this.wd += "," + this.tvp;
    }

    public int jpc() {
        return this.tvp;
    }

    public void ud(String str) {
        this.jpc = str;
    }

    public String tvp() {
        return this.jpc;
    }

    public void lnr(String str) {
        this.to = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.jpc)) {
            this.jpc = String.valueOf(this.to);
            return;
        }
        this.jpc += "," + this.to;
    }

    public void qdl(boolean z) {
        this.rq = z;
    }

    public boolean to() {
        return this.rq;
    }

    public Runnable qdl(String str, Map<String, String> map) {
        return qdl.qdl().qdl(this, str, map);
    }

    public boolean rq() {
        return this.mml == -1;
    }
}
