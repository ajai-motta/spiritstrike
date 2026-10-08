package com.bytedance.sdk.component.wd;

import android.os.Bundle;
import com.bytedance.sdk.component.ud.qdl.jpc;
import com.bytedance.sdk.component.ud.qdl.qdl.qdl.mzz;
import com.bytedance.sdk.component.ud.qdl.rq;
import com.bytedance.sdk.component.wd.lnr.lnr;
import com.bytedance.sdk.component.wd.ud.mml;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static mzz qdl;
    private rq ud;

    private qdl(C0217qdl c0217qdl) {
        rq.qdl qdlVarUd = new rq.qdl().qdl(c0217qdl.qdl, TimeUnit.MILLISECONDS).lnr(c0217qdl.lnr, TimeUnit.MILLISECONDS).ud(c0217qdl.ud, TimeUnit.MILLISECONDS);
        if (c0217qdl.mml != null && c0217qdl.mml.size() > 0) {
            Iterator<jpc> it = c0217qdl.mml.iterator();
            while (it.hasNext()) {
                qdlVarUd.qdl(it.next());
            }
        }
        if (c0217qdl.mo != null) {
            Bundle unused = c0217qdl.mo;
        }
        Set unused2 = c0217qdl.mzz;
        this.ud = qdlVarUd.qdl();
    }

    public static void qdl() {
        lnr.qdl(lnr.qdl.DEBUG);
    }

    public mml ud() {
        return new mml(this.ud);
    }

    public com.bytedance.sdk.component.wd.ud.ud lnr() {
        return new com.bytedance.sdk.component.wd.ud.ud(this.ud);
    }

    public com.bytedance.sdk.component.wd.ud.qdl mml() {
        return new com.bytedance.sdk.component.wd.ud.qdl(this.ud);
    }

    public static boolean mzz() {
        mzz mzzVar = qdl;
        if (mzzVar == null) {
            return false;
        }
        return mzzVar.qdl();
    }

    public static void qdl(mzz mzzVar) {
        qdl = mzzVar;
    }

    public rq mo() {
        return this.ud;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.wd.qdl$qdl, reason: collision with other inner class name */
    public static final class C0217qdl {
        private Bundle mo;
        private Set<String> mzz;
        final List<jpc> mml = new ArrayList();
        int qdl = 10000;
        int ud = 10000;
        int lnr = 10000;

        public C0217qdl qdl(boolean z) {
            return this;
        }

        public C0217qdl qdl(long j, TimeUnit timeUnit) {
            this.qdl = qdl("timeout", j, timeUnit);
            return this;
        }

        public C0217qdl ud(long j, TimeUnit timeUnit) {
            this.ud = qdl("timeout", j, timeUnit);
            return this;
        }

        public C0217qdl lnr(long j, TimeUnit timeUnit) {
            this.lnr = qdl("timeout", j, timeUnit);
            return this;
        }

        public C0217qdl qdl(jpc jpcVar) {
            this.mml.add(jpcVar);
            return this;
        }

        private static int qdl(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public qdl qdl() {
            return new qdl(this);
        }
    }
}
