package com.bytedance.adsdk.ud;

import android.graphics.Bitmap;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class to {
    private final String jpc;
    private final String lnr;
    private final String mml;
    private final String mo;
    private final String mzz;
    private final int qdl;
    private Bitmap rq;
    private final JSONArray to;
    private final int[][] tvp;
    private final int ud;
    private final List<qdl> wd;

    public static class qdl {
        public String lnr;
        public String mml;
        public int mo;
        public int mzz;
        public int qdl;
        public int ud;
        public String wd;
    }

    public to(int i, int i2, String str, String str2, String str3, String str4, List<qdl> list, String str5, int[][] iArr, JSONArray jSONArray) {
        this.qdl = i;
        this.ud = i2;
        this.lnr = str;
        this.mml = str2;
        this.mzz = str3;
        this.mo = str4;
        this.wd = list;
        this.jpc = str5;
        this.tvp = iArr;
        this.to = jSONArray;
    }

    public int qdl() {
        return this.qdl;
    }

    public int ud() {
        return this.ud;
    }

    public List<qdl> lnr() {
        return this.wd;
    }

    public String mml() {
        return this.mo;
    }

    public String mzz() {
        return this.jpc;
    }

    public int[][] mo() {
        return this.tvp;
    }

    public JSONArray wd() {
        return this.to;
    }

    public String jpc() {
        return this.lnr;
    }

    public String tvp() {
        return this.mml;
    }

    public String to() {
        return this.mzz;
    }

    public Bitmap rq() {
        return this.rq;
    }

    public void qdl(Bitmap bitmap) {
        this.rq = bitmap;
    }
}
