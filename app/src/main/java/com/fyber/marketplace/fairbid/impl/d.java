package com.fyber.marketplace.fairbid.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.fyber.inneractive.sdk.network.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f1730a;
    public final /* synthetic */ String b;

    public d(Map map, String str) {
        this.f1730a = map;
        this.b = str;
    }

    @Override // com.fyber.inneractive.sdk.network.o
    public final StringBuffer a() {
        return new StringBuffer(this.b);
    }

    @Override // com.fyber.inneractive.sdk.network.o
    public final Map b() {
        return this.f1730a;
    }
}
