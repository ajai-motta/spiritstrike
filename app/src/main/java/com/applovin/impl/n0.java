package com.applovin.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n0 extends j5 {
    private final String g;
    private final com.applovin.impl.sdk.network.a h;

    public n0(String str, com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
        super("CommunicatorRequestTask", kVar, str);
        this.g = str;
        this.h = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f428a.r0().a(new a(this.h, this.f428a, d()));
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z) {
            super(aVar, kVar, z);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            this.f428a.t().a(n0.this.g, n0.this.h.f(), i, jSONObject, null, true);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            this.f428a.t().a(n0.this.g, n0.this.h.f(), i, jSONObject, str2, false);
        }
    }
}
