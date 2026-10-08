package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.az, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1812az implements Runnable {
    public final /* synthetic */ C1813b0 A00;
    public final /* synthetic */ InterfaceC1814b1 A01;

    public RunnableC1812az(C1813b0 c1813b0, InterfaceC1814b1 interfaceC1814b1) {
        this.A00 = c1813b0;
        this.A01 = interfaceC1814b1;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A01.ACz();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
