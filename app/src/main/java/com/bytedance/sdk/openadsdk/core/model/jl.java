package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class jl {
    private int lnr;
    private double mml;
    private String mo;
    private boolean mzz;
    private String qdl;
    private int ud;

    public String qdl() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public int ud() {
        return this.ud;
    }

    public void qdl(int i) {
        this.ud = i;
    }

    public int lnr() {
        return this.lnr;
    }

    public void ud(int i) {
        this.lnr = i;
    }

    public double mml() {
        return this.mml;
    }

    public boolean mzz() {
        return !TextUtils.isEmpty(this.qdl) && this.ud > 0 && this.lnr > 0;
    }

    public boolean mo() {
        return this.mzz;
    }

    public void qdl(boolean z) {
        this.mzz = z;
    }

    public String wd() {
        return this.mo;
    }

    public void ud(String str) {
        this.mo = str;
    }
}
