package com.bytedance.sdk.component.ud.qdl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class rq implements Cloneable {
    public TimeUnit lnr;
    public long mml;
    public long mo;
    public TimeUnit mzz;
    public List<jpc> qdl;
    public long ud;
    public TimeUnit wd;

    public abstract mml qdl();

    public abstract ud qdl(fs fsVar);

    public rq(qdl qdlVar) {
        this.ud = qdlVar.ud;
        this.mml = qdlVar.mml;
        this.mo = qdlVar.mo;
        this.qdl = qdlVar.qdl;
        this.lnr = qdlVar.lnr;
        this.mzz = qdlVar.mzz;
        this.wd = qdlVar.wd;
        this.qdl = qdlVar.qdl;
    }

    public static final class qdl {
        public TimeUnit lnr;
        public long mml;
        public long mo;
        public TimeUnit mzz;
        public final List<jpc> qdl;
        public long ud;
        public TimeUnit wd;

        public qdl() {
            this.qdl = new ArrayList();
            this.ud = 10000L;
            this.lnr = TimeUnit.MILLISECONDS;
            this.mml = 10000L;
            this.mzz = TimeUnit.MILLISECONDS;
            this.mo = 10000L;
            this.wd = TimeUnit.MILLISECONDS;
        }

        public qdl(String str) {
            this.qdl = new ArrayList();
            this.ud = 10000L;
            this.lnr = TimeUnit.MILLISECONDS;
            this.mml = 10000L;
            this.mzz = TimeUnit.MILLISECONDS;
            this.mo = 10000L;
            this.wd = TimeUnit.MILLISECONDS;
        }

        public qdl(rq rqVar) {
            this.qdl = new ArrayList();
            this.ud = 10000L;
            this.lnr = TimeUnit.MILLISECONDS;
            this.mml = 10000L;
            this.mzz = TimeUnit.MILLISECONDS;
            this.mo = 10000L;
            this.wd = TimeUnit.MILLISECONDS;
            this.ud = rqVar.ud;
            this.lnr = rqVar.lnr;
            this.mml = rqVar.mml;
            this.mzz = rqVar.mzz;
            this.mo = rqVar.mo;
            this.wd = rqVar.wd;
        }

        public qdl qdl(long j, TimeUnit timeUnit) {
            this.ud = j;
            this.lnr = timeUnit;
            return this;
        }

        public qdl ud(long j, TimeUnit timeUnit) {
            this.mml = j;
            this.mzz = timeUnit;
            return this;
        }

        public qdl lnr(long j, TimeUnit timeUnit) {
            this.mo = j;
            this.wd = timeUnit;
            return this;
        }

        public qdl qdl(jpc jpcVar) {
            this.qdl.add(jpcVar);
            return this;
        }

        public rq qdl() {
            return com.bytedance.sdk.component.ud.qdl.qdl.qdl.qdl(this);
        }
    }

    public qdl ud() {
        return new qdl(this);
    }
}
