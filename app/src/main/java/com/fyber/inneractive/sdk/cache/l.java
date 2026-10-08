package com.fyber.inneractive.sdk.cache;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f901a;
    public final String b;

    public l(String str) {
        this.f901a = str;
        this.b = String.format("template_%d.html", Integer.valueOf(str.hashCode()));
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final Object a(String str) {
        return str;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String b() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String c() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final boolean d() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    @Override // com.fyber.inneractive.sdk.cache.a
    public final String a() {
        return this.f901a;
    }
}
