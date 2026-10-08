package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.e0;
import com.applovin.impl.m5;
import com.applovin.impl.p7;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.x7;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
class o5 extends m5 {
    private final p7 q;

    class a implements e0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x7 f542a;

        a(x7 x7Var) {
            this.f542a = x7Var;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                this.f542a.a(uri);
                o5.this.q.b(true);
                return;
            }
            com.applovin.impl.sdk.o oVar = o5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                o5 o5Var = o5.this;
                o5Var.c.b(o5Var.b, "Failed to cache static companion ad");
            }
        }
    }

    class b implements m5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x7 f543a;

        b(x7 x7Var) {
            this.f543a = x7Var;
        }

        @Override // com.applovin.impl.m5.e
        public void a(String str) {
            this.f543a.a(str);
            o5.this.q.b(true);
        }
    }

    class c implements m5.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ x7 f544a;

        c(x7 x7Var) {
            this.f544a = x7Var;
        }

        @Override // com.applovin.impl.m5.e
        public void a(String str) {
            this.f544a.a(str);
            o5.this.q.b(true);
        }
    }

    class d implements e0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d8 f545a;

        d(d8 d8Var) {
            this.f545a = d8Var;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.o oVar = o5.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    o5 o5Var = o5.this;
                    o5Var.c.a(o5Var.b, "Video file successfully cached into: " + uri);
                }
                this.f545a.a(uri);
                return;
            }
            com.applovin.impl.sdk.o oVar2 = o5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                o5 o5Var2 = o5.this;
                o5Var2.c.b(o5Var2.b, "Failed to cache video file: " + this.f545a);
            }
        }
    }

    class e implements m5.e {
        e() {
        }

        @Override // com.applovin.impl.m5.e
        public void a(String str) {
            if (o5.this.q.isOpenMeasurementEnabled()) {
                str = o5.this.f428a.e0().a(str, f2.a((AppLovinAdImpl) o5.this.g));
            }
            o5.this.q.d(str);
            com.applovin.impl.sdk.o oVar = o5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                o5 o5Var = o5.this;
                o5Var.c.a(o5Var.b, "Finish caching HTML template " + o5.this.q.i1() + " for ad #" + o5.this.q.getAdIdNumber());
            }
        }
    }

    public o5(p7 p7Var, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", p7Var, kVar, appLovinAdLoadListener);
        this.q = p7Var;
    }

    private String d(String str) {
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f428a.a(y4.i5)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                Uri uriA = a(str2, Collections.emptyList(), false);
                if (uriA != null) {
                    str = str.replace(str2, uriA.toString());
                    this.g.a(uriA.toString(), str2);
                } else if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache JavaScript resource: " + str2);
                }
            }
        }
        return str;
    }

    private void m() {
        if (l()) {
            return;
        }
        if (!this.q.u1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Companion ad caching disabled. Skipping...");
                return;
            }
            return;
        }
        s7 s7VarG1 = this.q.g1();
        if (s7VarG1 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No companion ad provided. Skipping...");
                return;
            }
            return;
        }
        x7 x7VarE = s7VarG1.e();
        if (x7VarE == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to retrieve non-video resources from companion ad. Skipping...");
                return;
            }
            return;
        }
        Uri uriC = x7VarE.c();
        String string = uriC != null ? uriC.toString() : "";
        String strB = x7VarE.b();
        if (!URLUtil.isValidUrl(string) && !StringUtils.isValidString(strB)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k(this.b, "Companion ad does not have any resources attached. Skipping...");
                return;
            }
            return;
        }
        if (x7VarE.d() == x7.a.STATIC) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching static companion ad at " + string + "...");
            }
            Uri uriA = a(string, Collections.emptyList(), false);
            if (uriA != null) {
                x7VarE.a(uriA);
                this.q.b(true);
                return;
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache static companion ad");
                    return;
                }
                return;
            }
        }
        if (x7VarE.d() != x7.a.HTML) {
            if (x7VarE.d() == x7.a.IFRAME && com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of iFrame resource...");
                return;
            }
            return;
        }
        if (!StringUtils.isValidString(string)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
            }
            if (((Boolean) this.f428a.a(y4.h5)).booleanValue()) {
                strB = d(strB);
            }
            x7VarE.a(a(strB, Collections.emptyList(), this.q));
            this.q.b(true);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Begin caching HTML companion ad. Fetching from " + string + "...");
        }
        String strC = c(string, null, false);
        if (StringUtils.isValidString(strC)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "HTML fetched. Caching HTML now...");
            }
            x7VarE.a(a(strC, Collections.emptyList(), this.q));
            this.q.b(true);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to load companion ad resources from " + string);
        }
    }

    private void n() {
        if (l() || !b8.a(this.q)) {
            return;
        }
        String strI1 = this.q.i1();
        if (!StringUtils.isValidString(strI1)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to load HTML template");
                return;
            }
            return;
        }
        String strA = a(strI1, this.q.S(), this.g);
        if (this.q.isOpenMeasurementEnabled()) {
            strA = this.f428a.e0().a(strA, f2.a((AppLovinAdImpl) this.g));
        }
        this.q.d(strA);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching HTML template " + this.q.i1() + " for ad #" + this.q.getAdIdNumber());
        }
    }

    private void o() {
        d8 d8VarQ1;
        Uri uriE;
        if (l()) {
            return;
        }
        if (!this.q.v1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video caching disabled. Skipping...");
                return;
            }
            return;
        }
        if (this.q.p1() == null || (d8VarQ1 = this.q.q1()) == null || (uriE = d8VarQ1.e()) == null) {
            return;
        }
        Uri uriB = b(uriE.toString(), Collections.emptyList(), false);
        if (uriB != null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video file successfully cached into: " + uriB);
            }
            d8VarQ1.a(uriB);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Failed to cache video file: " + d8VarQ1);
        }
    }

    private c0 p() {
        if (!this.q.u1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        s7 s7VarG1 = this.q.g1();
        if (s7VarG1 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No companion ad provided. Skipping...");
            }
            return null;
        }
        x7 x7VarE = s7VarG1.e();
        if (x7VarE == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri uriC = x7VarE.c();
        String string = uriC != null ? uriC.toString() : "";
        String strB = x7VarE.b();
        if (URLUtil.isValidUrl(string) || StringUtils.isValidString(strB)) {
            if (x7VarE.d() == x7.a.STATIC) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Caching static companion ad at " + string + "...");
                }
                return new e0(string, this.q, Collections.emptyList(), false, this.i, this.f428a, new a(x7VarE));
            }
            if (x7VarE.d() == x7.a.HTML) {
                if (!StringUtils.isValidString(string)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "Caching provided HTML for companion ad. No fetch required. HTML: " + strB);
                    }
                    return a(strB, Collections.emptyList(), new c(x7VarE));
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Begin caching HTML companion ad. Fetching from " + string + "...");
                }
                String strC = c(string, null, false);
                if (StringUtils.isValidString(strC)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "HTML fetched. Caching HTML now...");
                    }
                    return a(strC, Collections.emptyList(), new b(x7VarE));
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to load companion ad resources from " + string);
                }
            } else if (x7VarE.d() == x7.a.IFRAME && com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of iFrame resource...");
            }
        } else if (com.applovin.impl.sdk.o.a()) {
            this.c.k(this.b, "Companion ad does not have any resources attached. Skipping...");
        }
        return null;
    }

    @Override // com.applovin.impl.m5
    void f() {
        this.q.getAdEventTracker().h();
        super.f();
    }

    protected d0 q() {
        if (!TextUtils.isEmpty(this.q.i1())) {
            return a(this.q.i1(), this.q.S(), new e());
        }
        if (!com.applovin.impl.sdk.o.a()) {
            return null;
        }
        this.c.a(this.b, "Unable to load HTML template");
        return null;
    }

    protected e0 r() {
        d8 d8VarQ1;
        Uri uriE;
        if (!this.q.v1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video caching disabled. Skipping...");
            }
            return null;
        }
        if (this.q.p1() == null || (d8VarQ1 = this.q.q1()) == null || (uriE = d8VarQ1.e()) == null) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video file " + d8VarQ1 + " creative...");
        }
        return a(uriE.toString(), Collections.emptyList(), false, new d(d8VarQ1));
    }

    @Override // com.applovin.impl.m5, java.lang.Runnable
    public void run() {
        super.run();
        boolean zC0 = this.q.C0();
        if (com.applovin.impl.sdk.o.a()) {
            com.applovin.impl.sdk.o oVar = this.c;
            String str = this.b;
            StringBuilder sb = new StringBuilder("Begin caching for VAST ");
            sb.append(zC0 ? "streaming " : "");
            sb.append("ad #");
            sb.append(this.g.getAdIdNumber());
            sb.append("...");
            oVar.a(str, sb.toString());
        }
        if (zC0) {
            if (((Boolean) this.f428a.a(y4.N0)).booleanValue()) {
                if (!o0.e()) {
                    a(e());
                }
                if (this.q.s1()) {
                    f();
                    ArrayList arrayList = new ArrayList();
                    c0 c0VarP = p();
                    if (c0VarP != null) {
                        arrayList.add(c0VarP);
                    }
                    d0 d0VarQ = q();
                    if (d0VarQ != null) {
                        arrayList.add(d0VarQ);
                    }
                    e0 e0VarR = r();
                    if (e0VarR != null) {
                        arrayList.add(e0VarR);
                    }
                    a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (this.q.j1() == p7.c.COMPANION_AD) {
                        c0 c0VarP2 = p();
                        if (c0VarP2 != null) {
                            arrayList2.add(c0VarP2);
                        }
                        d0 d0VarQ2 = q();
                        if (d0VarQ2 != null) {
                            arrayList2.add(d0VarQ2);
                        }
                        a(arrayList2);
                        f();
                        e0 e0VarR2 = r();
                        if (e0VarR2 != null) {
                            arrayList3.add(e0VarR2);
                        }
                        a(arrayList3);
                    } else {
                        e0 e0VarR3 = r();
                        if (e0VarR3 != null) {
                            arrayList2.add(e0VarR3);
                        }
                        a(arrayList2);
                        f();
                        c0 c0VarP3 = p();
                        if (c0VarP3 != null) {
                            arrayList3.add(c0VarP3);
                        }
                        d0 d0VarQ3 = q();
                        if (d0VarQ3 != null) {
                            arrayList3.add(d0VarQ3);
                        }
                        a(arrayList3);
                    }
                }
            } else {
                j();
                if (this.q.s1()) {
                    f();
                }
                p7.c cVarJ1 = this.q.j1();
                p7.c cVar = p7.c.COMPANION_AD;
                if (cVarJ1 == cVar) {
                    m();
                    n();
                    a(this.q);
                } else {
                    o();
                }
                if (!this.q.s1()) {
                    f();
                }
                if (this.q.j1() == cVar) {
                    o();
                } else {
                    m();
                    n();
                    a(this.q);
                }
            }
        } else if (((Boolean) this.f428a.a(y4.N0)).booleanValue()) {
            ArrayList arrayList4 = new ArrayList();
            if (!o0.e()) {
                arrayList4.addAll(e());
            }
            c0 c0VarP4 = p();
            if (c0VarP4 != null) {
                arrayList4.add(c0VarP4);
            }
            e0 e0VarR4 = r();
            if (e0VarR4 != null) {
                arrayList4.add(e0VarR4);
            }
            d0 d0VarQ4 = q();
            if (d0VarQ4 != null) {
                arrayList4.add(d0VarQ4);
            }
            a(arrayList4);
            f();
        } else {
            j();
            m();
            o();
            n();
            a(this.q);
            f();
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished caching VAST ad #" + this.q.getAdIdNumber());
        }
        this.q.t1();
        k();
    }

    @Override // com.applovin.impl.m5
    void a(int i) {
        this.q.getAdEventTracker().f();
        super.a(i);
    }
}
