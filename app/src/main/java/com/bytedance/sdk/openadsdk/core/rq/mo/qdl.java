package com.bytedance.sdk.openadsdk.core.rq.mo;

import com.bytedance.adsdk.ugeno.core.jl;
import com.bytedance.sdk.component.adexpress.ud.exu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends exu {
    private float lnr;
    private float mml;
    private boolean mzz;
    private JSONObject qdl;
    private jl ud;

    public qdl(C0245qdl c0245qdl) {
        super(c0245qdl);
        this.qdl = c0245qdl.qdl;
        this.ud = c0245qdl.ud;
        this.lnr = c0245qdl.lnr;
        this.mml = c0245qdl.mml;
        this.mzz = c0245qdl.mzz;
    }

    public float vu() {
        return this.lnr;
    }

    public float rc() {
        return this.mml;
    }

    public JSONObject kdv() {
        return this.qdl;
    }

    public jl ekw() {
        return this.ud;
    }

    public boolean hkc() {
        return this.mzz;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.rq.mo.qdl$qdl, reason: collision with other inner class name */
    public static class C0245qdl extends exu.qdl {
        private float lnr;
        private float mml;
        private boolean mzz;
        private JSONObject qdl;
        private jl ud;

        public C0245qdl qdl(JSONObject jSONObject) {
            this.qdl = jSONObject;
            return this;
        }

        public C0245qdl qdl(jl jlVar) {
            this.ud = jlVar;
            return this;
        }

        public C0245qdl qdl(float f) {
            this.lnr = f;
            return this;
        }

        public C0245qdl ud(float f) {
            this.mml = f;
            return this;
        }

        public C0245qdl mo(boolean z) {
            this.mzz = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.adexpress.ud.exu.qdl
        /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
        public qdl qdl() {
            return new qdl(this);
        }
    }
}
