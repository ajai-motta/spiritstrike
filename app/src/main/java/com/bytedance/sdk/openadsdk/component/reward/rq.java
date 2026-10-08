package com.bytedance.sdk.openadsdk.component.reward;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.gy;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class rq {
    private long lnr;
    private long mml;
    private boolean mo;
    private boolean mzz;
    private final qdl qdl;
    private long ud;

    public interface qdl {
        void qdl();
    }

    public rq(qdl qdlVar) {
        this.mzz = true;
        this.qdl = qdlVar;
        int iQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("reward_callback_fallback", 0);
        if (iQdl != 0) {
            this.mzz = false;
            if (iQdl == 2) {
                this.mo = true;
            }
        }
    }

    public static void qdl(ljh ljhVar, boolean z, final int i) {
        com.bytedance.sdk.openadsdk.mml.lnr.qdl(System.currentTimeMillis(), ljhVar, gy.qdl(ljhVar), z ? "reward_callback" : "reward_fail_callback", new com.bytedance.sdk.openadsdk.bjy.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.component.reward.rq.1
            @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
            public JSONObject qdl() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("reason", i);
                    return jSONObject;
                } catch (Throwable unused) {
                    return null;
                }
            }
        });
    }

    public void qdl(long j) {
        if (j <= this.ud) {
            return;
        }
        this.ud = j;
    }

    public void qdl() {
        if (!this.mzz && this.lnr > 0) {
            this.mml += SystemClock.elapsedRealtime() - this.lnr;
            this.lnr = 0L;
        }
    }

    public void ud() {
        if (this.mzz) {
            return;
        }
        this.lnr = SystemClock.elapsedRealtime();
    }

    public void lnr() {
        this.mzz = true;
    }

    public void mml() {
        if (this.qdl != null) {
            long jElapsedRealtime = (this.mml + (this.lnr > 0 ? SystemClock.elapsedRealtime() - this.lnr : 0L)) / 1000;
            if (this.mzz) {
                return;
            }
            if (this.mo || jElapsedRealtime >= this.ud) {
                this.qdl.qdl();
            }
        }
    }
}
