package com.applovin.impl;

import com.applovin.impl.c5;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e5 extends k3 {
    private final a3 k;

    public e5(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        super(a3Var.e(), jSONObject, jSONObject2, kVar);
        this.k = a3Var;
    }

    public boolean A() {
        return a("use_cached_adapter", Boolean.TRUE).booleanValue();
    }

    public c5.b t() {
        return c5.b.values()[a("signal_cache_level", ((Integer) this.f440a.a(r3.V7)).intValue())];
    }

    @Override // com.applovin.impl.k3
    public String toString() {
        return "SignalProviderSpec{adObject=" + a() + AbstractJsonLexerKt.END_OBJ;
    }

    public a3 u() {
        return this.k;
    }

    public long v() {
        return a("signal_expiration_ms", ((Long) this.f440a.a(r3.U7)).longValue());
    }

    public boolean w() {
        return a("only_collect_signal_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean x() {
        return a("prefer_collect_signal_when_initialized", Boolean.TRUE).booleanValue();
    }

    public boolean y() {
        return a("fail_collection_for_empty_signal", (Boolean) this.f440a.a(r3.C8)).booleanValue();
    }

    public boolean z() {
        return a("ignore_init_failure", Boolean.FALSE).booleanValue();
    }
}
