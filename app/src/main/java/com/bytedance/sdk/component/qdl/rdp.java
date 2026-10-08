package com.bytedance.sdk.component.qdl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class rdp {
    public final String jpc;
    public final String lnr;
    public final String mml;
    public final String mo;
    public final String mzz;
    public final int qdl;
    public final String ud;
    public final String wd;

    public static qdl qdl() {
        return new qdl();
    }

    public static rdp qdl(String str, int i) {
        return new rdp(str, i);
    }

    private rdp(String str, int i) {
        this.ud = null;
        this.lnr = null;
        this.mml = null;
        this.mzz = null;
        this.mo = str;
        this.wd = null;
        this.qdl = i;
        this.jpc = null;
    }

    private rdp(qdl qdlVar) {
        this.ud = qdlVar.qdl;
        this.lnr = qdlVar.ud;
        this.mml = qdlVar.lnr;
        this.mzz = qdlVar.mml;
        this.mo = qdlVar.mzz;
        this.wd = qdlVar.mo;
        this.qdl = 1;
        this.jpc = qdlVar.wd;
    }

    public static boolean qdl(rdp rdpVar) {
        return rdpVar == null || rdpVar.qdl != 1 || TextUtils.isEmpty(rdpVar.mml) || TextUtils.isEmpty(rdpVar.mzz);
    }

    public String toString() {
        return "methodName: " + this.mml + ", params: " + this.mzz + ", callbackId: " + this.mo + ", type: " + this.lnr + ", version: " + this.ud + ", ";
    }

    public static final class qdl {
        private String lnr;
        private String mml;
        private String mo;
        private String mzz;
        private String qdl;
        private String ud;
        private String wd;

        private qdl() {
        }

        public qdl qdl(String str) {
            this.qdl = str;
            return this;
        }

        public qdl ud(String str) {
            this.ud = str;
            return this;
        }

        public qdl lnr(String str) {
            this.lnr = str;
            return this;
        }

        public qdl mml(String str) {
            this.mml = str;
            return this;
        }

        public qdl mzz(String str) {
            this.mzz = str;
            return this;
        }

        public qdl mo(String str) {
            this.mo = str;
            return this;
        }

        public qdl wd(String str) {
            this.wd = str;
            return this;
        }

        public rdp qdl() {
            return new rdp(this);
        }
    }
}
