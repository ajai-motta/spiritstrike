package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1558Sk extends Thread {
    public final long A00;

    public C1558Sk(long j) {
        this.A00 = j;
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        while (true) {
            try {
                try {
                    Thread.sleep(this.A00);
                } catch (InterruptedException unused) {
                }
                C1556Si.A01();
            } catch (Throwable th) {
                WU.A00(th, this);
                return;
            }
        }
    }
}
