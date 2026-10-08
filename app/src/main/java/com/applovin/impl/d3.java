package com.applovin.impl;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d3 extends h3 implements t1 {
    private final AtomicBoolean t;
    private final AtomicBoolean u;

    public d3(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        super(a3Var, jSONObject, jSONObject2, null, kVar);
        this.t = new AtomicBoolean();
        this.u = new AtomicBoolean();
    }

    private long k0() {
        long jA = a("ad_expiration_ms", -1L);
        return jA < 0 ? b("ad_expiration_ms", ((Long) this.f440a.a(r3.X7)).longValue()) : jA;
    }

    @Override // com.applovin.impl.y2
    public y2 a(com.applovin.impl.mediation.h hVar) {
        return new d3(this, hVar);
    }

    @Override // com.applovin.impl.t1
    public long getTimeToLiveMillis() {
        return k0() - (SystemClock.elapsedRealtime() - G());
    }

    public MaxNativeAdView l0() {
        return this.n.f();
    }

    public ViewGroup m0() {
        return this.n.h();
    }

    public AtomicBoolean n0() {
        return this.t;
    }

    public AtomicBoolean o0() {
        return this.u;
    }

    public boolean p0() {
        return a("inacc", (Boolean) this.f440a.a(r3.r8)).booleanValue();
    }

    public boolean q0() {
        return this.n == null;
    }

    @Override // com.applovin.impl.t1
    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.n.a(maxNativeAdView);
    }

    public void a(ViewGroup viewGroup) {
        this.n.a(viewGroup);
    }

    private d3(d3 d3Var, com.applovin.impl.mediation.h hVar) {
        super(d3Var.L(), d3Var.a(), d3Var.g(), hVar, d3Var.f440a);
        this.t = new AtomicBoolean();
        this.u = new AtomicBoolean();
    }
}
