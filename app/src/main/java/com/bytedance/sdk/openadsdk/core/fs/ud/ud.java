package com.bytedance.sdk.openadsdk.core.fs.ud;

import com.bytedance.sdk.openadsdk.core.fs.ud.lnr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends lnr implements Comparable<ud> {
    private final float qdl;

    private ud(float f, String str, lnr.EnumC0234lnr enumC0234lnr, Boolean bool) {
        super(str, enumC0234lnr, bool);
        this.qdl = f;
    }

    public boolean qdl(float f) {
        return this.qdl <= f && !mzz();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public int compareTo(ud udVar) {
        if (udVar == null) {
            return 1;
        }
        float f = this.qdl;
        float f2 = udVar.qdl;
        if (f > f2) {
            return 1;
        }
        return f < f2 ? -1 : 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.fs.ud.lnr
    public void j_() {
        super.j_();
    }

    public static class qdl {
        private lnr.EnumC0234lnr lnr = lnr.EnumC0234lnr.TRACKING_URL;
        private boolean mml = false;
        private final String qdl;
        private final float ud;

        public qdl(String str, float f) {
            this.qdl = str;
            this.ud = f;
        }

        public ud qdl() {
            return new ud(this.ud, this.qdl, this.lnr, Boolean.valueOf(this.mml));
        }
    }

    public JSONObject ud() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("content", lnr());
        jSONObject.put("trackingFraction", this.qdl);
        return jSONObject;
    }

    public String toString() {
        return super.toString();
    }
}
