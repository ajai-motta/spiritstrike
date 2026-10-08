package com.fyber.inneractive.sdk.flow.nativead;

import android.net.Uri;
import com.fyber.inneractive.sdk.network.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.response.nativead.f f1086a;
    public final s b;

    public t(com.fyber.inneractive.sdk.response.nativead.f fVar, s sVar) {
        this.f1086a = fVar;
        this.b = sVar;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        Uri uri = (Uri) obj;
        if (exc instanceof com.fyber.inneractive.sdk.network.g) {
            return;
        }
        if (exc != null || uri == null) {
            this.b.a(null, exc, this.f1086a);
            return;
        }
        s sVar = this.b;
        com.fyber.inneractive.sdk.response.nativead.f fVar = this.f1086a;
        sVar.a(new g(fVar.f1618a, uri), null, fVar);
    }
}
