package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class x0 extends t0 {
    public final String p;
    public final String q;
    public final AtomicInteger r;

    public x0(e eVar, String str, String str2) {
        super(eVar, g0.c.a(), null);
        this.r = new AtomicInteger();
        this.q = str;
        this.p = str2;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final o0 a(l lVar, Map map, int i) throws n0 {
        try {
            o0 o0Var = new o0();
            o0Var.f1211a = String.valueOf(i);
            return o0Var;
        } catch (Exception e) {
            IAlog.a("failed parse event network request", e, new Object[0]);
            throw new n0(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final byte[] f() {
        byte[] bArr = new byte[0];
        try {
            IAlog.a("NetworkRequestEvent: network request body %s", this.p);
            return this.p.getBytes(StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return bArr;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int g() {
        return ((int) Math.pow(2.0d, this.r.get())) * 1000;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final m0 m() {
        return m0.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final g1 o() {
        return g1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final String r() {
        return this.q;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final boolean u() {
        return this.r.getAndIncrement() < 4;
    }
}
