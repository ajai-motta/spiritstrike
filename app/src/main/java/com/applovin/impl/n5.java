package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.e0;
import com.applovin.impl.m5;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class n5 extends m5 {
    private final com.applovin.impl.sdk.ad.a q;
    private boolean r;
    private boolean s;

    class a implements e0.a {
        a() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                n5.this.q.m1();
                n5.this.q.c(uri);
            }
        }
    }

    class b implements m5.e {
        b() {
        }

        @Override // com.applovin.impl.m5.e
        public void a(String str) {
            n5.this.q.d(n5.this.d(str));
            n5.this.q.b(true);
            com.applovin.impl.sdk.o oVar = n5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                n5 n5Var = n5.this;
                n5Var.c.a(n5Var.b, "Finish caching non-video resources for ad #" + n5.this.q.getAdIdNumber());
            }
            n5 n5Var2 = n5.this;
            n5Var2.c.f(n5Var2.b, "Ad updated with cachedHTML = " + n5.this.q.g1());
        }
    }

    public n5(com.applovin.impl.sdk.ad.a aVar, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, kVar, appLovinAdLoadListener);
        this.q = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (o7.j(com.applovin.impl.sdk.k.o())) {
            str = o7.c(str);
        }
        if (!this.q.isOpenMeasurementEnabled()) {
            return str;
        }
        return this.f428a.e0().a(str, f2.a((AppLovinAdImpl) this.g));
    }

    private void m() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching non-optional HTML resources...");
        }
        this.q.d(d(a(this.q.g1(), this.q.S(), this.q)));
        this.q.b(true);
        a(this.q);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching non-optional HTML resources for ad #" + this.q.getAdIdNumber());
        }
        this.c.f(this.b, "Ad HTML updated to reference locally cached non-optional resources = " + this.q.g1());
    }

    private void n() {
        Uri uriC;
        if (l() || (uriC = c(this.q.k1())) == null) {
            return;
        }
        this.q.m1();
        this.q.c(uriC);
    }

    private d0 o() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching HTML resources...");
        }
        return a(this.q.g1(), this.q.S(), new b());
    }

    private e0 p() {
        return b(this.q.k1(), new a());
    }

    private void q() {
        List<String> listH = this.q.H();
        if (CollectionUtils.isEmpty(listH)) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching optional HTML resources...");
        }
        String strG1 = this.q.g1();
        for (String str : listH) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching optional resource: " + str);
            }
            int iA = this.f428a.G().a(str, this.g);
            Map mapA = f2.a((AppLovinAdImpl) this.g);
            String strA = this.f428a.G().a(com.applovin.impl.sdk.k.o(), str, this.q.getCachePrefix(), this.q.S(), true, true, iA, this.i, mapA);
            if (StringUtils.isValidString(strA)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Updating HTML with cached optional resource: " + strA);
                }
                this.q.a(strA, str);
                strG1 = strG1.replace(str, strA);
                this.q.d(strG1);
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache optional resource: " + str);
                }
                a(str, "cacheOptionalHtmlResource", mapA);
            }
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching optional HTML resources for ad #" + this.q.getAdIdNumber());
        }
    }

    public void b(boolean z) {
        this.s = z;
    }

    public void c(boolean z) {
        this.r = z;
    }

    @Override // com.applovin.impl.m5, java.lang.Runnable
    public void run() {
        super.run();
        boolean zC0 = this.q.C0();
        boolean z = this.s;
        if (zC0 || z) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Begin caching for streaming ad #" + this.q.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f428a.a(y4.N0)).booleanValue()) {
                if (!o0.e()) {
                    a(e());
                }
                ArrayList arrayList = new ArrayList();
                if (!zC0) {
                    f();
                    d0 d0VarO = o();
                    if (d0VarO != null) {
                        arrayList.add(d0VarO);
                    }
                } else if (this.r) {
                    f();
                    d0 d0VarO2 = o();
                    if (d0VarO2 != null) {
                        arrayList.add(d0VarO2);
                    }
                    e0 e0VarP = p();
                    if (e0VarP != null) {
                        arrayList.add(e0VarP);
                    }
                } else {
                    d0 d0VarO3 = o();
                    if (d0VarO3 != null) {
                        a(Arrays.asList(d0VarO3));
                    }
                    f();
                    e0 e0VarP2 = p();
                    if (e0VarP2 != null) {
                        arrayList.add(e0VarP2);
                    }
                }
                a(arrayList);
                f();
            } else {
                j();
                if (zC0) {
                    if (this.r) {
                        f();
                    }
                    m();
                    if (!this.r) {
                        f();
                    }
                    n();
                } else {
                    f();
                    m();
                }
            }
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Begin processing for non-streaming ad #" + this.q.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f428a.a(y4.N0)).booleanValue()) {
                ArrayList arrayList2 = new ArrayList();
                if (!o0.e()) {
                    arrayList2.addAll(e());
                }
                d0 d0VarO4 = o();
                if (d0VarO4 != null) {
                    arrayList2.add(d0VarO4);
                }
                e0 e0VarP3 = p();
                if (e0VarP3 != null) {
                    arrayList2.add(e0VarP3);
                }
                a(arrayList2);
                f();
                q();
            } else {
                j();
                m();
                n();
                f();
                q();
            }
        }
        k();
    }
}
