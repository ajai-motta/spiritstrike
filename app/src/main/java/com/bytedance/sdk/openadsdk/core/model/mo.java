package com.bytedance.sdk.openadsdk.core.model;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo {
    private int wd;
    private String qdl = "";
    private String ud = "";
    private String lnr = "";
    private String mml = "";
    private double mzz = -1.0d;
    private int mo = -1;

    public String qdl() {
        return this.qdl;
    }

    public void qdl(String str) {
        this.qdl = str;
    }

    public String ud() {
        return this.ud;
    }

    public void ud(String str) {
        this.ud = str;
    }

    public String lnr() {
        return this.lnr;
    }

    public void lnr(String str) {
        this.lnr = str;
    }

    public double mml() {
        return this.mzz;
    }

    public void qdl(double d) {
        if (d < 1.0d || d > 5.0d) {
            this.mzz = -1.0d;
        } else {
            this.mzz = d;
        }
    }

    public int mzz() {
        return this.mo;
    }

    public void qdl(int i) {
        if (i <= 0) {
            this.mo = -1;
        } else {
            this.mo = i;
        }
    }

    public int mo() {
        return this.wd;
    }

    public void ud(int i) {
        this.wd = i;
    }

    public String wd() {
        return this.mml;
    }

    public void mml(String str) {
        this.mml = str;
    }

    public JSONObject jpc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, ud());
            jSONObject.put("app_size", mo());
            jSONObject.put("comment_num", mzz());
            jSONObject.put("download_url", qdl());
            jSONObject.put("package_name", lnr());
            jSONObject.put(FirebaseAnalytics.Param.SCORE, mml());
            jSONObject.put("app_category", wd());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr(e.toString(), new Object[0]);
        }
        return jSONObject;
    }
}
