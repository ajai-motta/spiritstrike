package com.fyber.inneractive.sdk.web;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1695a;
    public final com.fyber.inneractive.sdk.util.g1 b;
    public final /* synthetic */ i c;

    public h(i iVar, String str, com.fyber.inneractive.sdk.util.g1 g1Var) {
        this.c = iVar;
        this.b = g1Var;
        this.f1695a = str;
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final String a() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final void b() {
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final String c() {
        return "open";
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final void d() {
        i iVar = this.c;
        String str = this.f1695a;
        com.fyber.inneractive.sdk.util.g1 g1Var = this.b;
        j1 j1Var = iVar.g;
        if (j1Var != null) {
            com.fyber.inneractive.sdk.util.g0 g0Var = j1Var.a(str, g1Var).f1648a;
        }
    }

    public final String toString() {
        return "action: open url: " + this.f1695a;
    }
}
