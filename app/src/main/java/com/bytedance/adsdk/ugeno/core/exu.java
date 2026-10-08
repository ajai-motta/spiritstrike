package com.bytedance.adsdk.ugeno.core;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class exu {
    private JSONObject lnr;
    private exu mml;
    private exu mzz;
    private com.bytedance.adsdk.ugeno.ud.lnr qdl;
    private int ud;

    public com.bytedance.adsdk.ugeno.ud.lnr qdl() {
        return this.qdl;
    }

    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        this.qdl = lnrVar;
    }

    public int ud() {
        return this.ud;
    }

    public void qdl(int i) {
        this.ud = i;
    }

    public JSONObject lnr() {
        return this.lnr;
    }

    public void qdl(JSONObject jSONObject) {
        this.lnr = jSONObject;
    }

    public exu mml() {
        return this.mml;
    }

    public void qdl(exu exuVar) {
        this.mml = exuVar;
    }

    public void ud(exu exuVar) {
        this.mzz = exuVar;
    }

    public String toString() {
        return "UGenEvent{mWidget=" + this.qdl + ", mEventType=" + this.ud + ", mEvent=" + this.lnr + AbstractJsonLexerKt.END_OBJ;
    }
}
