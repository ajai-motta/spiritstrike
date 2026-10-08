package com.bytedance.sdk.openadsdk.core.model;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.lnr.lnr;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jtx implements com.bytedance.sdk.component.adexpress.lnr {
    public int bjy;
    public JSONObject exu;
    public int fs;
    public int jpc;
    public final float lnr;
    public final float mml;
    public final long mo;
    public final long mzz;
    public final float qdl;
    public boolean rdp;
    public final boolean rq;
    public SparseArray<lnr.qdl> to;
    public JSONObject tvp;
    public final float ud;
    public final String wd;

    private jtx(qdl qdlVar) {
        this.rdp = false;
        this.qdl = qdlVar.wd;
        this.ud = qdlVar.mo;
        this.lnr = qdlVar.mzz;
        this.mml = qdlVar.mml;
        this.mzz = qdlVar.lnr;
        this.mo = qdlVar.ud;
        this.wd = qdlVar.tvp;
        this.to = qdlVar.qdl;
        this.rq = qdlVar.bjy;
        this.jpc = qdlVar.to;
        this.tvp = qdlVar.rq;
        this.fs = qdlVar.fs;
        this.exu = qdlVar.exu;
        this.rdp = qdlVar.rdp;
        this.bjy = qdlVar.jpc;
    }

    public static class qdl {
        private boolean bjy;
        private JSONObject exu;
        private int fs;
        private int jpc;
        private long lnr;
        private float mml;
        private float mo;
        private float mzz;
        private JSONObject rq;
        private int to;
        private String tvp;
        private long ud;
        private float wd;
        private boolean rdp = false;
        protected SparseArray<lnr.qdl> qdl = new SparseArray<>();

        public qdl qdl(int i) {
            this.fs = i;
            return this;
        }

        public qdl ud(int i) {
            this.to = i;
            return this;
        }

        public qdl qdl(JSONObject jSONObject) {
            this.rq = jSONObject;
            return this;
        }

        public qdl qdl(boolean z) {
            this.bjy = z;
            return this;
        }

        public qdl lnr(int i) {
            this.jpc = i;
            return this;
        }

        public qdl qdl(long j) {
            this.ud = j;
            return this;
        }

        public qdl ud(long j) {
            this.lnr = j;
            return this;
        }

        public qdl qdl(float f) {
            this.mml = f;
            return this;
        }

        public qdl ud(float f) {
            this.mzz = f;
            return this;
        }

        public qdl lnr(float f) {
            this.mo = f;
            return this;
        }

        public qdl mml(float f) {
            this.wd = f;
            return this;
        }

        public qdl qdl(String str) {
            this.tvp = str;
            return this;
        }

        public qdl qdl(SparseArray<lnr.qdl> sparseArray) {
            this.qdl = sparseArray;
            return this;
        }

        public qdl ud(JSONObject jSONObject) {
            this.exu = jSONObject;
            return this;
        }

        public qdl ud(boolean z) {
            this.rdp = z;
            return this;
        }

        public jtx qdl() {
            return new jtx(this);
        }
    }
}
