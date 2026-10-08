package com.fyber.inneractive.sdk.network;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class v0 extends t0 {
    public final Context p;
    public final com.fyber.inneractive.sdk.cache.a q;
    public d0 r;

    public v0(f0 f0Var, Context context, com.fyber.inneractive.sdk.cache.a aVar) {
        super(f0Var, g0.c.a(), null);
        this.p = context;
        this.q = aVar;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public o0 a(l lVar, Map map, int i) throws Exception {
        o0 o0Var = new o0();
        try {
            String string = com.fyber.inneractive.sdk.util.v.b(lVar.c).toString();
            o0Var.f1211a = this.q.a(string);
            o0Var.b = string;
            return o0Var;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            if (e instanceof InvalidAppIdException) {
                throw e;
            }
            throw new n0(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final int g() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final String h() {
        return this.q.c();
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public a i() throws Throwable {
        d0 d0Var = new d0(this.p, this.q);
        this.r = d0Var;
        com.fyber.inneractive.sdk.cache.m mVarA = d0Var.a();
        String str = mVarA.b;
        Object obj = mVarA.f902a;
        this.q.c();
        return new a(obj, str);
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final m0 m() {
        return m0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final g1 o() {
        return g1.LOW;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final String r() {
        return this.q.a();
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public final boolean u() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.network.t0
    public void a(o0 o0Var, String str, String str2) {
        d0 d0Var = this.r;
        if (d0Var != null) {
            d0Var.b(str2);
            if (o0Var == null || o0Var.b.isEmpty() || str.isEmpty()) {
                return;
            }
            if (!this.r.a(str, o0Var.b)) {
                IAlog.b("Failed to cache file", new Object[0]);
            } else {
                this.q.a(o0Var.f1211a);
            }
        }
    }
}
