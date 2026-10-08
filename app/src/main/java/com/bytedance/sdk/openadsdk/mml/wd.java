package com.bytedance.sdk.openadsdk.mml;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    private long lnr;
    private long mml;
    private long mzz;
    private long qdl;
    private long ud;

    public void qdl(long j) {
        if (this.qdl <= 0) {
            this.qdl = j;
        }
    }

    public void ud(long j) {
        if (this.ud <= 0) {
            this.ud = j;
        }
    }

    public void lnr(long j) {
        if (this.lnr <= 0) {
            this.lnr = j;
        }
    }

    public void mml(long j) {
        if (this.mml <= 0) {
            this.mml = j;
        }
    }

    public void mzz(long j) {
        if (this.mzz <= 0) {
            this.mzz = j;
        }
    }

    public boolean qdl() {
        return this.qdl > 0;
    }

    public void qdl(long j, float f) {
        if (f > 0.0f) {
            qdl(j);
        }
        double d = f;
        if (d >= 0.25d) {
            qdl(j);
            ud(j);
        }
        if (d >= 0.5d) {
            qdl(j);
            ud(j);
            lnr(j);
        }
        if (d >= 0.75d) {
            qdl(j);
            ud(j);
            lnr(j);
            mml(j);
        }
        if (f >= 1.0f) {
            qdl(j);
            ud(j);
            lnr(j);
            mml(j);
            mzz(j);
        }
    }

    public JSONObject ud() {
        return qdl((JSONObject) null);
    }

    public JSONObject qdl(JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception unused) {
            }
        }
        long j = this.qdl;
        if (j > 0) {
            jSONObject.put("show_start", j);
            long j2 = this.ud;
            if (j2 > 0) {
                jSONObject.put("show_firstQuartile", j2);
                long j3 = this.lnr;
                if (j3 > 0) {
                    jSONObject.put("show_mid", j3);
                    long j4 = this.mml;
                    if (j4 > 0) {
                        jSONObject.put("show_thirdQuartile", j4);
                        long j5 = this.mzz;
                        if (j5 > 0) {
                            jSONObject.put("show_full", j5);
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
