package com.fyber.inneractive.sdk.external;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUnitController f1025a;

    public h(NativeAdUnitController nativeAdUnitController) {
        this.f1025a = nativeAdUnitController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1025a.a();
    }
}
