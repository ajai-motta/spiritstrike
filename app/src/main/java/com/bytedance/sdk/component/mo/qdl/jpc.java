package com.bytedance.sdk.component.mo.qdl;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class jpc {
    private static jpc exu;
    private static volatile com.bytedance.sdk.component.mo.qdl.mzz.qdl to;
    private long bjy;
    private volatile Map<Integer, com.bytedance.sdk.component.mo.qdl.ud.lnr> fs;
    private volatile boolean jpc;
    private volatile com.bytedance.sdk.component.mo.qdl.mml.ud.qdl lnr;
    private volatile com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mml;
    private volatile com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mo;
    private volatile com.bytedance.sdk.component.mo.qdl.mml.ud.qdl mzz;
    private volatile Context qdl;
    private final AtomicBoolean rdp = new AtomicBoolean(false);
    private volatile com.bytedance.sdk.component.mo.qdl.ud.lnr rq;
    private volatile mzz tvp;
    private volatile com.bytedance.sdk.component.mo.qdl.mml.ud.qdl ud;
    private volatile com.bytedance.sdk.component.mo.qdl.qdl.mzz wd;

    public boolean qdl() {
        return this.rdp.get();
    }

    public void qdl(boolean z) {
        this.rdp.set(z);
    }

    public boolean ud() {
        return this.jpc;
    }

    public void ud(boolean z) {
        this.jpc = z;
    }

    public Map<Integer, com.bytedance.sdk.component.mo.qdl.ud.lnr> lnr() {
        return this.fs;
    }

    public com.bytedance.sdk.component.mo.qdl.qdl.mzz mml() {
        return this.wd;
    }

    public static com.bytedance.sdk.component.mo.qdl.mzz.qdl mzz() {
        if (to == null) {
            synchronized (jpc.class) {
                if (to == null) {
                    to = new com.bytedance.sdk.component.mo.qdl.mzz.ud();
                }
            }
        }
        return to;
    }

    public void qdl(com.bytedance.sdk.component.mo.qdl.qdl.mzz mzzVar) {
        this.wd = mzzVar;
    }

    public Context mo() {
        return this.qdl;
    }

    public void qdl(Context context) {
        this.qdl = context;
    }

    private jpc() {
    }

    public static synchronized jpc wd() {
        if (exu == null) {
            exu = new jpc();
        }
        return exu;
    }

    public void qdl(com.bytedance.sdk.component.mo.qdl.ud.lnr lnrVar) {
        this.rq = lnrVar;
    }

    public com.bytedance.sdk.component.mo.qdl.ud.lnr jpc() {
        return this.rq;
    }

    public void tvp() {
        com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.ud();
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl to() {
        return this.mo;
    }

    public void qdl(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        this.mo = qdlVar;
    }

    public void rq() {
        com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.lnr();
    }

    public void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar) {
        if (qdlVar == null) {
            return;
        }
        qdlVar.qdl(System.currentTimeMillis());
        com.bytedance.sdk.component.mo.qdl.ud.mml.qdl.qdl(qdlVar, qdlVar.mml());
    }

    public void qdl(String str, boolean z) {
        com.bytedance.sdk.component.mo.qdl.mo.qdl.qdl().qdl(str, z);
    }

    public void qdl(String str, List<String> list, boolean z, Map<String, String> map, int i, String str2) {
        com.bytedance.sdk.component.mo.qdl.mo.qdl.qdl().qdl(str, list, z, map, i, str2);
    }

    public void ud(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        this.ud = qdlVar;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl fs() {
        return this.ud;
    }

    public void lnr(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        this.lnr = qdlVar;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl exu() {
        return this.lnr;
    }

    public void mml(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        this.mml = qdlVar;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl rdp() {
        return this.mml;
    }

    public com.bytedance.sdk.component.mo.qdl.mml.ud.qdl bjy() {
        return this.mzz;
    }

    public void mzz(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar) {
        this.mzz = qdlVar;
    }

    public void qdl(mzz mzzVar) {
        this.tvp = mzzVar;
    }

    public mzz jtx() {
        return this.tvp;
    }

    public void qdl(long j) {
        this.bjy = j;
    }

    public long yt() {
        return this.bjy * 86400000;
    }
}
