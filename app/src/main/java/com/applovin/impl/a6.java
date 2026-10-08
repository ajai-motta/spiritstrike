package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a6 extends s5 {
    private final AppLovinNativeAdLoadListener i;

    public a6(u uVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super(uVar, str, kVar);
        this.i = appLovinNativeAdLoadListener;
    }

    @Override // com.applovin.impl.s5
    protected j5 a(JSONObject jSONObject) {
        return new h6(jSONObject, this.i, this.f428a);
    }

    @Override // com.applovin.impl.s5
    protected String e() {
        return r0.d(this.f428a);
    }

    @Override // com.applovin.impl.s5
    protected String f() {
        return r0.e(this.f428a);
    }

    @Override // com.applovin.impl.s5
    protected void a(int i, String str) {
        super.a(i, str);
        this.i.onNativeAdLoadFailed(new AppLovinError(i, str));
    }
}
