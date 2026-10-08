package com.applovin.impl;

import com.applovin.impl.e6;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k6 extends j5 {
    private final JSONObject g;
    private final JSONObject h;
    private final AppLovinAdLoadListener i;

    public k6(JSONObject jSONObject, JSONObject jSONObject2, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskRenderAppLovinAd", kVar);
        this.g = jSONObject;
        this.h = jSONObject2;
        this.i = appLovinAdLoadListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendering ad...");
        }
        com.applovin.impl.sdk.ad.a aVar = new com.applovin.impl.sdk.ad.a(this.g, this.h, this.f428a);
        boolean zBooleanValue = JsonUtils.getBoolean(this.g, "gs_load_immediately", Boolean.FALSE).booleanValue();
        boolean zBooleanValue2 = JsonUtils.getBoolean(this.g, "vs_load_immediately", Boolean.TRUE).booleanValue();
        n5 n5Var = new n5(aVar, this.f428a, this.i);
        n5Var.c(zBooleanValue2);
        n5Var.b(zBooleanValue);
        this.f428a.r0().a((j5) n5Var, e6.b.CACHING);
    }
}
