package com.applovin.impl.sdk;

import com.applovin.impl.y2;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f665a;
    private final Map b = new HashMap(5);
    private final Object c = new Object();
    private final Map d = Collections.synchronizedMap(new HashMap(5));
    private final Map e = Collections.synchronizedMap(new HashMap(5));

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f666a;
        private final String b;
        private final String c;

        public a(String str, String str2, String str3) {
            this.f666a = str;
            this.b = str2;
            this.c = str3;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public String b() {
            return this.f666a;
        }

        public String c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strB = b();
            String strB2 = aVar.b();
            if (strB != null ? !strB.equals(strB2) : strB2 != null) {
                return false;
            }
            String strA = a();
            String strA2 = aVar.a();
            if (strA != null ? !strA.equals(strA2) : strA2 != null) {
                return false;
            }
            String strC = c();
            String strC2 = aVar.c();
            return strC != null ? strC.equals(strC2) : strC2 == null;
        }

        public int hashCode() {
            String strB = b();
            int iHashCode = strB == null ? 43 : strB.hashCode();
            String strA = a();
            int iHashCode2 = ((iHashCode + 59) * 59) + (strA == null ? 43 : strA.hashCode());
            String strC = c();
            return (iHashCode2 * 59) + (strC != null ? strC.hashCode() : 43);
        }

        public String toString() {
            return "MediationWaterfallWinnerTracker.WinningAd(bCode=" + b() + ", adapterName=" + a() + ", networkName=" + c() + ")";
        }

        public String a() {
            return this.b;
        }
    }

    p(k kVar) {
        this.f665a = kVar.O();
    }

    public String a(String str) {
        return (String) this.e.get(str);
    }

    public void b(y2 y2Var) {
        this.d.put(y2Var.getAdUnitId(), y2Var.O());
    }

    public void c(y2 y2Var) {
        synchronized (this.c) {
            if (o.a()) {
                this.f665a.a("MediationWaterfallWinnerTracker", "Tracking winning ad: " + y2Var);
            }
            this.b.put(y2Var.getAdUnitId(), new a(y2Var.B(), y2Var.c(), y2Var.getNetworkName()));
        }
        this.e.put(y2Var.getAdUnitId(), y2Var.O());
    }

    public void a(y2 y2Var) {
        synchronized (this.c) {
            String adUnitId = y2Var.getAdUnitId();
            a aVar = (a) this.b.get(adUnitId);
            if (aVar == null) {
                if (o.a()) {
                    this.f665a.a("MediationWaterfallWinnerTracker", "No previous winner to clear.");
                }
                return;
            }
            if (y2Var.B().equals(aVar.b())) {
                if (o.a()) {
                    this.f665a.a("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + aVar);
                }
                this.b.remove(adUnitId);
            } else if (o.a()) {
                this.f665a.a("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + y2Var + " , since it could have already been updated with a new ad: " + aVar);
            }
        }
    }

    public String b(String str) {
        return (String) this.d.get(str);
    }

    public a c(String str) {
        a aVar;
        synchronized (this.c) {
            aVar = (a) this.b.get(str);
        }
        return aVar;
    }
}
