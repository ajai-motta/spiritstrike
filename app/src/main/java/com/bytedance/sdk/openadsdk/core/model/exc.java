package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class exc {
    public static int qdl = 1;
    public static int ud = 2;
    private int lnr = 5;
    private int mml = 30;
    private int mzz = 70;
    private int mo = 1;
    private int wd = qdl;
    private int jpc = 0;
    private int tvp = 0;
    private int to = 3;

    public int qdl() {
        return this.to;
    }

    public void qdl(int i) {
        this.to = i;
    }

    public int ud() {
        return this.tvp;
    }

    public void ud(int i) {
        this.tvp = i;
    }

    public int lnr() {
        return this.jpc;
    }

    public void lnr(int i) {
        this.jpc = i;
    }

    public int mml() {
        return this.lnr;
    }

    public void mml(int i) {
        this.lnr = i;
    }

    public int mzz() {
        return this.mml;
    }

    public void mzz(int i) {
        this.mml = i;
    }

    public int mo() {
        return this.mzz;
    }

    public void mo(int i) {
        this.mzz = i;
    }

    public int wd() {
        return this.mo;
    }

    public void wd(int i) {
        this.mo = i;
    }

    public int jpc() {
        return this.wd;
    }

    public void jpc(int i) {
        this.wd = i;
    }

    public boolean qdl(boolean z) {
        if (z) {
            int i = this.jpc;
            return i == 1 || i == 3;
        }
        int i2 = this.jpc;
        return i2 == 3 || i2 == 2;
    }

    public JSONObject qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ceiling_time", this.lnr);
            jSONObject.put("ceiling_ratio", this.mml);
            jSONObject.put("expand_ratio", this.mzz);
            jSONObject.put("back_type", this.mo);
            jSONObject.put("boc_return_type", this.wd);
            jSONObject.put("pre_render_status", this.jpc);
            jSONObject.put("pre_render_use_gecko", this.tvp);
            jSONObject.put("pre_render_add_type", this.to);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("InteractionParams", th.getMessage());
        }
        return jSONObject;
    }
}
