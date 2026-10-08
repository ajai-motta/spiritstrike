package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class v4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3209a;
    public final /* synthetic */ int b;

    public v4(String str, int i) {
        this.f3209a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k4.a();
        k4.a(this.f3209a, this.b);
    }
}
