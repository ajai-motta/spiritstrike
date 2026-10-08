package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f339a;
    private final Map b = new HashMap();
    private final Object c = new Object();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f340a;

        static {
            int[] iArr = new int[b.values().length];
            f340a = iArr;
            try {
                iArr[b.AD_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f340a[b.AD_UNIT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f340a[b.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        AD_FORMAT,
        AD_UNIT_ID,
        ALL
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d5 f342a;
        private final long b;
        private final long c;

        /* synthetic */ c(d5 d5Var, long j, a aVar) {
            this(d5Var, j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public d5 c() {
            return this.f342a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a((Object) this) || b() != cVar.b() || a() != cVar.a()) {
                return false;
            }
            d5 d5VarC = c();
            d5 d5VarC2 = cVar.c();
            return d5VarC != null ? d5VarC.equals(d5VarC2) : d5VarC2 == null;
        }

        public int hashCode() {
            long jB = b();
            long jA = a();
            d5 d5VarC = c();
            return ((((((int) (jB ^ (jB >>> 32))) + 59) * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (d5VarC == null ? 43 : d5VarC.hashCode());
        }

        public String toString() {
            return "SignalCacheManager.SignalWrapper(signal=" + c() + ", expirationTimeMillis=" + b() + ", cacheTimestampMillis=" + a() + ")";
        }

        private c(d5 d5Var, long j) {
            this.f342a = d5Var;
            this.b = j;
            this.c = SystemClock.elapsedRealtime();
        }

        public long b() {
            return this.b;
        }

        public long a() {
            return this.c;
        }
    }

    public c5(com.applovin.impl.sdk.k kVar) {
        this.f339a = kVar;
    }

    public void a(d5 d5Var, e5 e5Var, String str, MaxAdFormat maxAdFormat) {
        if (d5Var == null) {
            return;
        }
        long jV = e5Var.v();
        if (jV <= 0) {
            return;
        }
        this.f339a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f339a.O().a("SignalCacheManager", "Caching signal for: " + e5Var);
        }
        String strA = a(e5Var, str, maxAdFormat);
        c cVar = new c(d5Var, jV, null);
        synchronized (this.c) {
            this.b.put(strA, cVar);
        }
    }

    public d5 b(e5 e5Var, String str, MaxAdFormat maxAdFormat) {
        String strA = a(e5Var, str, maxAdFormat);
        synchronized (this.c) {
            c cVar = (c) this.b.get(strA);
            if (cVar == null) {
                return null;
            }
            if (cVar.d()) {
                this.b.remove(strA);
                return null;
            }
            this.f339a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f339a.O().a("SignalCacheManager", "Returning cached signal for: " + e5Var);
            }
            return cVar.f342a;
        }
    }

    private String a(e5 e5Var, String str, MaxAdFormat maxAdFormat) {
        String strC = e5Var.c();
        int i = a.f340a[e5Var.t().ordinal()];
        if (i == 1) {
            return strC + "_" + maxAdFormat.getLabel();
        }
        if (i != 2) {
            return strC;
        }
        return strC + "_" + str;
    }
}
