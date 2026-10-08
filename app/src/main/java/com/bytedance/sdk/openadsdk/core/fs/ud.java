package com.bytedance.sdk.openadsdk.core.fs;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.core.fs.lnr.qdl;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends lnr {
    private long rq;
    private long to;

    public ud(int i, int i2, long j, long j2, qdl.EnumC0233qdl enumC0233qdl, qdl.ud udVar, String str, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list, List<com.bytedance.sdk.openadsdk.core.fs.ud.lnr> list2, String str2) {
        super(i, i2, enumC0233qdl, udVar, str, list, list2, str2);
        this.to = j;
        this.rq = j2;
        this.tvp = "icon_click";
    }

    @Override // com.bytedance.sdk.openadsdk.core.fs.lnr
    public JSONObject qdl() throws JSONException {
        JSONObject jSONObjectQdl = super.qdl();
        if (jSONObjectQdl != null) {
            jSONObjectQdl.put(TypedValues.CycleType.S_WAVE_OFFSET, this.to);
            jSONObjectQdl.put(TypedValues.TransitionType.S_DURATION, this.rq);
        }
        return jSONObjectQdl;
    }

    public static ud qdl(JSONObject jSONObject) {
        lnr lnrVarUd = lnr.ud(jSONObject);
        if (lnrVarUd == null) {
            return null;
        }
        return new ud(lnrVarUd.qdl, lnrVarUd.ud, jSONObject.optLong(TypedValues.CycleType.S_WAVE_OFFSET, -1L), jSONObject.optLong(TypedValues.TransitionType.S_DURATION, -1L), lnrVarUd.lnr, lnrVarUd.mml, lnrVarUd.mzz, lnrVarUd.mo, lnrVarUd.wd, lnrVarUd.jpc);
    }
}
