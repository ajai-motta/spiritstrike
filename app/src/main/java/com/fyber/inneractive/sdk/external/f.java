package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveAdViewUnitController f1023a;

    public f(InneractiveAdViewUnitController inneractiveAdViewUnitController) {
        this.f1023a = inneractiveAdViewUnitController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1023a.a();
    }
}
