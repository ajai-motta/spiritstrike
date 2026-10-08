package com.applovin.impl;

import androidx.core.util.Consumer;
import com.applovin.impl.b4;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinErrorCodes;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q0 {
    private static final List e = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f573a;
    private final com.applovin.impl.sdk.o b;
    private final b4 c;
    private d d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f574a;
        private long b;

        public long a() {
            return this.f574a;
        }

        public long b() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j) {
            this.f574a = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j) {
            this.b = j;
        }
    }

    private class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f575a;
        private final com.applovin.impl.sdk.network.a b;
        private final String c;
        private final Object d;
        private final boolean e;
        private final b f;
        private final e g;

        @Override // androidx.core.util.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(b4.d dVar) {
            int i;
            int iC;
            long jE = dVar.e();
            Object objA = null;
            try {
                try {
                    iC = dVar.c();
                } catch (MalformedURLException e) {
                    e = e;
                    i = 0;
                }
                try {
                    if (iC <= 0) {
                        q0.this.a(this.c, this.f575a, iC, jE, (Throwable) null);
                        this.g.a(this.f575a, iC, null, null);
                        return;
                    }
                    if (iC < 200 || iC >= 400) {
                        this.g.a(this.f575a, iC, null, null);
                        return;
                    }
                    b bVar = this.f;
                    if (bVar != null) {
                        bVar.a(jE);
                    }
                    q0.this.a(this.c, this.f575a, iC, jE);
                    byte[] bArrD = dVar.d();
                    if (o7.h(com.applovin.impl.sdk.k.o()) && (!this.e || v4.b(bArrD) != v4.a.V2)) {
                        q0.this.f573a.t().a(bArrD != null ? new String(dVar.d(), Charset.forName("UTF-8")) : "", this.f575a, this.b.b() != null ? this.b.b().toString() : "");
                    }
                    if (bArrD == null) {
                        this.g.a(this.f575a, this.d, iC);
                        return;
                    }
                    String str = new String(dVar.d(), Charset.forName("UTF-8"));
                    b bVar2 = this.f;
                    if (bVar2 != null) {
                        bVar2.b(bArrD.length);
                        if (this.b.r()) {
                            q0.this.d = new d(this.b.f(), bArrD.length, jE);
                        }
                    }
                    if (this.e) {
                        String strB = v4.b(bArrD, q0.this.f573a.j0(), q0.this.f573a);
                        if (strB == null) {
                            HashMap map = new HashMap(2);
                            map.put("request", StringUtils.getHostAndPath(this.f575a));
                            map.put("response", str);
                            q0.this.f573a.F().trackEvent("rdf", map);
                        }
                        str = strB;
                    }
                    try {
                        this.g.a(this.f575a, q0.this.a(str, this.d), iC);
                    } catch (Throwable th) {
                        String str2 = "Unable to parse response from " + StringUtils.getHostAndPath(this.f575a) + " because of " + th.getClass().getName() + " : " + th.getMessage();
                        com.applovin.impl.sdk.o unused = q0.this.b;
                        if (com.applovin.impl.sdk.o.a()) {
                            q0.this.b.a("ConnectionManager", str2, th);
                        }
                        q0.this.f573a.D().a("ConnectionManager", "failedToParseResponse", th, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(this.f575a)));
                        this.g.a(this.f575a, AppLovinErrorCodes.INVALID_RESPONSE, str2, null);
                    }
                } catch (MalformedURLException e2) {
                    e = e2;
                    i = iC;
                    if (this.d != null) {
                        q0.this.a(this.c, this.f575a, i, jE, e);
                        this.g.a(this.f575a, -901, e.getMessage(), null);
                    } else {
                        q0.this.a(this.c, this.f575a, i, jE);
                        this.g.a(this.f575a, this.d, -901);
                    }
                }
            } catch (Throwable th2) {
                int iB = dVar.b();
                try {
                    byte[] bArrF = dVar.f();
                    String str3 = new String(bArrF);
                    if (bArrF != null) {
                        if (this.e) {
                            str3 = v4.b(bArrF, q0.this.f573a.j0(), q0.this.f573a);
                        }
                        objA = q0.this.a(str3, this.d);
                    }
                } catch (Throwable unused2) {
                }
                q0.this.a(this.c, this.f575a, iB, jE, th2);
                this.g.a(this.f575a, iB, th2.getMessage(), objA);
            }
        }

        private c(String str, com.applovin.impl.sdk.network.a aVar, String str2, Object obj, boolean z, b bVar, e eVar) {
            this.f575a = str;
            this.b = aVar;
            this.c = str2;
            this.d = obj;
            this.e = z;
            this.f = bVar;
            this.g = eVar;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f576a = System.currentTimeMillis();
        private final String b;
        private final long c;
        private final long d;

        public d(String str, long j, long j2) {
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        protected boolean a(Object obj) {
            return obj instanceof d;
        }

        public long b() {
            return this.c;
        }

        public long c() {
            return this.f576a;
        }

        public String d() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this) || c() != dVar.c() || b() != dVar.b() || a() != dVar.a()) {
                return false;
            }
            String strD = d();
            String strD2 = dVar.d();
            return strD != null ? strD.equals(strD2) : strD2 == null;
        }

        public int hashCode() {
            long jC = c();
            long jB = b();
            int i = ((((int) (jC ^ (jC >>> 32))) + 59) * 59) + ((int) (jB ^ (jB >>> 32)));
            long jA = a();
            String strD = d();
            return (((i * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (strD == null ? 43 : strD.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + c() + ", urlHostAndPathString=" + d() + ", responseSizeBytes=" + b() + ", connectionTimeMillis=" + a() + ")";
        }

        public long a() {
            return this.d;
        }
    }

    public interface e {
        void a(String str, int i, String str2, Object obj);

        void a(String str, Object obj, int i);
    }

    public q0(com.applovin.impl.sdk.k kVar) {
        this.f573a = kVar;
        this.b = kVar.O();
        b4 b4Var = new b4(kVar);
        this.c = b4Var;
        b4Var.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x020e A[Catch: all -> 0x0260, TryCatch #0 {all -> 0x0260, blocks: (B:36:0x00f9, B:38:0x0109, B:42:0x0130, B:41:0x012c, B:43:0x013f, B:46:0x0164, B:48:0x0180, B:52:0x01a1, B:68:0x01f4, B:71:0x0203, B:73:0x020e, B:54:0x01a5, B:57:0x01ad, B:63:0x01c5, B:65:0x01cb, B:66:0x01e0, B:49:0x018e, B:74:0x0211, B:76:0x0217, B:77:0x022b, B:59:0x01be), top: B:90:0x00f9, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.applovin.impl.sdk.network.a r24, com.applovin.impl.q0.b r25, com.applovin.impl.q0.e r26) {
        /*
            Method dump skipped, instruction units count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.q0.a(com.applovin.impl.sdk.network.a, com.applovin.impl.q0$b, com.applovin.impl.q0$e):void");
    }

    public d a() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (obj instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (obj instanceof q8) {
                return r8.a(str, this.f573a);
            }
            if (obj instanceof String) {
                return str;
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.b.b("ConnectionManager", "Failed to process response of type '" + obj.getClass().getName() + "'");
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.d("ConnectionManager", "Successful " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + r0.g(this.f573a) + " to " + a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i, long j, Throwable th) {
        if (com.applovin.impl.sdk.o.a()) {
            this.b.a("ConnectionManager", "Failed " + str + " returned " + i + " in " + (j / 1000.0f) + " s over " + r0.g(this.f573a) + " to " + a(str2), th);
        }
    }

    private String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }
}
