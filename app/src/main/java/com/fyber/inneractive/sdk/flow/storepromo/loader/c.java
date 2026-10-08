package com.fyber.inneractive.sdk.flow.storepromo.loader;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1098a;
    public final /* synthetic */ d b;

    public c(d dVar, String str) {
        this.b = dVar;
        this.f1098a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.b.f1099a;
        String str = this.f1098a;
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = fVar.f1101a;
        if (aVar != null) {
            try {
                aVar.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
            } catch (Throwable th) {
                if (fVar.e != null) {
                    fVar.e.a(com.fyber.inneractive.sdk.network.events.b.WEB_VIEW_CRASH_ERROR, "Unable to load data: " + th.getMessage(), "");
                }
            }
        }
    }
}
