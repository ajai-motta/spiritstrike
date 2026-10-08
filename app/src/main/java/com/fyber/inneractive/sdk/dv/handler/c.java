package com.fyber.inneractive.sdk.dv.handler;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdFormat f994a;
    public final /* synthetic */ e b;

    public c(e eVar, AdFormat adFormat) {
        this.b = eVar;
        this.f994a = adFormat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            QueryInfo.generate(o.f1662a, this.f994a, e.a(this.b), new b(this));
        } catch (Throwable th) {
            IAlog.a("Error in resolveDVTokens", th, new Object[0]);
        }
    }
}
