package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f288a;
    private final String b;

    public a4(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        this.f288a = JsonUtils.getString(jSONObject, "id", "");
        this.b = JsonUtils.getString(jSONObject, "price", null);
    }

    public String a() {
        return this.f288a;
    }

    public String b() {
        return this.b;
    }
}
