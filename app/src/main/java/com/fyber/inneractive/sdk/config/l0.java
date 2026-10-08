package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.b1;
import com.fyber.inneractive.sdk.util.c1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f962a = null;
    public UnitDisplayType b;
    public Boolean c;
    public Integer d;

    @Override // com.fyber.inneractive.sdk.util.b1
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        c1.a(jSONObject, "refresh", this.f962a);
        c1.a(jSONObject, "unitDisplayType", this.b);
        c1.a(jSONObject, "close", this.c);
        c1.a(jSONObject, "hideDelay", this.d);
        return jSONObject;
    }
}
