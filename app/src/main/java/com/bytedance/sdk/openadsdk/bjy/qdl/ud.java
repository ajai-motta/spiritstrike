package com.bytedance.sdk.openadsdk.bjy.qdl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.gy;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private String lnr;
    private int mml;
    private String mo;
    private boolean mzz;
    private String qdl;
    private ljh ud;
    private int wd;
    private int jpc = 0;
    private int tvp = 0;

    public String qdl() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public ljh ud() {
        return this.ud;
    }

    public void qdl(ljh ljhVar) {
        this.ud = ljhVar;
    }

    public String lnr() {
        ljh ljhVar;
        if (TextUtils.isEmpty(this.lnr) && (ljhVar = this.ud) != null) {
            this.lnr = gy.qdl(ljhVar);
        }
        return this.lnr;
    }

    public void ud(String str) {
        this.lnr = str;
    }

    public int mml() {
        return this.mml;
    }

    public void qdl(int i) {
        this.mml = i;
    }

    public boolean mzz() {
        return this.mzz;
    }

    public void qdl(boolean z) {
        this.mzz = z;
    }

    public String mo() {
        return this.mo;
    }

    public void lnr(String str) {
        this.mo = str;
    }

    public int wd() {
        return this.wd;
    }

    public void ud(int i) {
        this.wd = i;
    }

    public int jpc() {
        return this.jpc;
    }

    public int tvp() {
        return this.tvp;
    }
}
