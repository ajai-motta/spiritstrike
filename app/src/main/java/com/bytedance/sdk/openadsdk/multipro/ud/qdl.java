package com.bytedance.sdk.openadsdk.multipro.ud;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public boolean lnr;
    public boolean mml;
    public long mo;
    public long mzz;
    public boolean qdl;
    public boolean ud;
    public long wd;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.multipro.ud.qdl$qdl, reason: collision with other inner class name */
    public interface InterfaceC0270qdl {
        qdl mo();
    }

    public qdl qdl(boolean z) {
        this.mml = z;
        return this;
    }

    public qdl ud(boolean z) {
        this.qdl = z;
        return this;
    }

    public qdl lnr(boolean z) {
        this.ud = z;
        return this;
    }

    public qdl mml(boolean z) {
        this.lnr = z;
        return this;
    }

    public qdl qdl(long j) {
        this.mzz = j;
        return this;
    }

    public qdl ud(long j) {
        this.mo = j;
        return this;
    }

    public qdl lnr(long j) {
        this.wd = j;
        return this;
    }

    public JSONObject qdl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.qdl);
            jSONObject.put("isFromVideoDetailPage", this.ud);
            jSONObject.put("isFromDetailPage", this.lnr);
            jSONObject.put(TypedValues.TransitionType.S_DURATION, this.mzz);
            jSONObject.put("totalPlayDuration", this.mo);
            jSONObject.put("currentPlayPosition", this.wd);
            jSONObject.put("isAutoPlay", this.mml);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static qdl qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        qdl qdlVar = new qdl();
        qdlVar.ud(jSONObject.optBoolean("isCompleted"));
        qdlVar.lnr(jSONObject.optBoolean("isFromVideoDetailPage"));
        qdlVar.mml(jSONObject.optBoolean("isFromDetailPage"));
        qdlVar.qdl(jSONObject.optLong(TypedValues.TransitionType.S_DURATION));
        qdlVar.ud(jSONObject.optLong("totalPlayDuration"));
        qdlVar.lnr(jSONObject.optLong("currentPlayPosition"));
        qdlVar.qdl(jSONObject.optBoolean("isAutoPlay"));
        return qdlVar;
    }
}
