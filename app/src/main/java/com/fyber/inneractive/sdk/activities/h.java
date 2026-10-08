package com.fyber.inneractive.sdk.activities;

import com.fyber.inneractive.sdk.click.q;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.fyber.inneractive.sdk.click.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f869a;

    public h(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f869a = inneractiveInternalBrowserActivity;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        if (bVar.f913a != q.FAILED) {
            InneractiveInternalBrowserActivity.a(this.f869a, bVar);
            this.f869a.finish();
        }
    }
}
