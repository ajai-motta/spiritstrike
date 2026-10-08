package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class RunnableC1920cj implements Runnable {
    public final /* synthetic */ C1328Ji A00;

    public RunnableC1920cj(C1328Ji c1328Ji) {
        this.A00 = c1328Ji;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A0C = true;
            if (this.A00.A0b.A0D() != null) {
                this.A00.A0b.A0D().AFw(true);
            }
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
