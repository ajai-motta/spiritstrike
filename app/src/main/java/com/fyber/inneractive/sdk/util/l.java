package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.a f1657a;

    public l(com.fyber.inneractive.sdk.cache.a aVar) {
        this.f1657a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.cache.a aVar;
        try {
            if (o.f1662a == null || (aVar = this.f1657a) == null) {
                return;
            }
            o.f1662a.getSharedPreferences("IAConfigurationPreferences", 0).edit().remove(aVar.b()).apply();
        } catch (Throwable unused) {
        }
    }
}
