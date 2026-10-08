package com.bytedance.sdk.component.mzz.mml.lnr;

import com.bytedance.sdk.component.mzz.rq;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class mml<T> implements rq {
    private boolean jpc;
    private T lnr;
    private T mml;
    private int mo;
    private int mzz;
    private String qdl;
    private int rq;
    private com.bytedance.sdk.component.mzz.wd to;
    private boolean tvp;
    private String ud;
    private Map<String, String> wd;

    public mml qdl(lnr lnrVar, T t) {
        this.lnr = t;
        this.qdl = lnrVar.to();
        this.ud = lnrVar.qdl();
        this.mzz = lnrVar.ud();
        this.mo = lnrVar.lnr();
        this.tvp = lnrVar.exu();
        this.to = lnrVar.bjy();
        this.rq = lnrVar.jtx();
        return this;
    }

    public mml qdl(lnr lnrVar, T t, Map<String, String> map, boolean z) {
        this.wd = map;
        this.jpc = z;
        return qdl(lnrVar, t);
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public String qdl() {
        return this.ud;
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public T ud() {
        return this.lnr;
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public T lnr() {
        return this.mml;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.mzz.rq
    public void qdl(Object obj) {
        this.mml = this.lnr;
        this.lnr = obj;
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public Map<String, String> mml() {
        return this.wd;
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public boolean mzz() {
        return this.jpc;
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public boolean mo() {
        return this.tvp;
    }

    @Override // com.bytedance.sdk.component.mzz.rq
    public int wd() {
        return this.rq;
    }
}
