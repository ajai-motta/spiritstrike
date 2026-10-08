package com.applovin.impl;

import com.applovin.impl.v;

/* JADX INFO: loaded from: classes2.dex */
public class p5 extends j5 {
    private final a g;

    public interface a {
        void a(v.a aVar);
    }

    public p5(com.applovin.impl.sdk.k kVar, a aVar) {
        super("TaskCollectAdvertisingId", kVar, true);
        this.g = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.g.a(this.f428a.A().f());
    }
}
