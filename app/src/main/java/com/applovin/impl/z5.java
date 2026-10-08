package com.applovin.impl;

import com.applovin.impl.sdk.AppLovinError;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z5 extends s5 {
    private final AppLovinAdLoadListener i;

    public z5(u uVar, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        this(uVar, appLovinAdLoadListener, "TaskFetchNextAd", kVar);
    }

    @Override // com.applovin.impl.s5
    protected j5 a(JSONObject jSONObject) {
        return new f6(jSONObject, this.g, this.i, this.f428a);
    }

    @Override // com.applovin.impl.s5
    protected String e() {
        return r0.a(this.f428a);
    }

    @Override // com.applovin.impl.s5
    protected String f() {
        return r0.b(this.f428a);
    }

    public z5(u uVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, com.applovin.impl.sdk.k kVar) {
        super(uVar, str, kVar);
        this.i = appLovinAdLoadListener;
    }

    @Override // com.applovin.impl.s5
    protected void a(int i, String str) {
        super.a(i, str);
        AppLovinAdLoadListener appLovinAdLoadListener = this.i;
        if (!(appLovinAdLoadListener instanceof m2)) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        } else {
            ((m2) this.i).failedToReceiveAdV2(new AppLovinError(i, str));
        }
    }
}
