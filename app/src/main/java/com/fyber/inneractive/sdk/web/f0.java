package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.mraid.e f1692a;
    public final /* synthetic */ i0 b;

    public f0(i0 i0Var, com.fyber.inneractive.sdk.mraid.e eVar) {
        this.b = i0Var;
        this.f1692a = eVar;
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final String a() {
        return this.f1692a.c();
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final void b() {
        com.fyber.inneractive.sdk.mraid.e eVar = this.f1692a;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final String c() {
        return this.f1692a.f1183a;
    }

    @Override // com.fyber.inneractive.sdk.web.f
    public final void d() {
        IAmraidWebViewController iAmraidWebViewController = (IAmraidWebViewController) this.b;
        if (iAmraidWebViewController.I != null) {
            iAmraidWebViewController.I.a();
        }
        this.f1692a.a();
    }

    public final String toString() {
        return "action = " + this.f1692a.f1183a + " url = " + this.f1692a.c();
    }
}
