package com.applovin.impl.mediation.ads;

import android.view.ViewGroup;
import com.applovin.impl.d3;
import com.applovin.impl.g8;
import com.applovin.impl.h8;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;

/* JADX INFO: loaded from: classes2.dex */
public class b implements h8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f496a;
    private final d3 b;
    private final h8 c;
    private final g8 d;
    private final a.InterfaceC0152a e;

    public b(d3 d3Var, ViewGroup viewGroup, a.InterfaceC0152a interfaceC0152a, k kVar) {
        this.f496a = kVar;
        this.b = d3Var;
        this.e = interfaceC0152a;
        this.d = new g8(viewGroup, kVar);
        h8 h8Var = new h8(viewGroup, kVar, this);
        this.c = h8Var;
        h8Var.a(d3Var);
        kVar.O();
        if (o.a()) {
            kVar.O().a("MaxNativeAdView", "Created new MaxNativeAdView (" + this + ")");
        }
    }

    public void a() {
        this.c.b();
    }

    public d3 b() {
        return this.b;
    }

    public void c() {
        this.f496a.O();
        if (o.a()) {
            this.f496a.O().a("MaxNativeAdView", "Handling view attached to window");
        }
        if (this.b.n0().compareAndSet(false, true)) {
            this.f496a.O();
            if (o.a()) {
                this.f496a.O().a("MaxNativeAdView", "Scheduling impression for ad manually...");
            }
            if (this.b.getNativeAd().isExpired()) {
                o.h("MaxNativeAdView", "Attempting to display an expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            } else {
                this.f496a.f().a(this.b);
            }
            this.f496a.X().processRawAdImpression(this.b, this.e);
        }
    }

    @Override // com.applovin.impl.h8.a
    public void onLogVisibilityImpression() {
        a(this.d.a(this.b));
    }

    private void a(long j) {
        if (this.b.o0().compareAndSet(false, true)) {
            this.f496a.O();
            if (o.a()) {
                this.f496a.O().a("MaxNativeAdView", "Scheduling viewability impression for ad...");
            }
            this.f496a.X().processViewabilityAdImpressionPostback(this.b, j, this.e);
        }
    }
}
