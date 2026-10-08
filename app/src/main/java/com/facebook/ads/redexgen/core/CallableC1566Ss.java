package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ss, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class CallableC1566Ss implements Callable<Boolean> {
    public final BlockingQueue<Boolean> A00 = new LinkedBlockingQueue();
    public final /* synthetic */ C1571Sx A01;

    public CallableC1566Ss(C1571Sx c1571Sx, C1567St c1567St) {
        this.A01 = c1571Sx;
        new Handler(Looper.getMainLooper()).post(new C2168gl(this, c1571Sx, c1567St));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Boolean call() throws Exception {
        return this.A00.take();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C1567St c1567St) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        C2096fb c2096fbA06 = C2096fb.A06(this.A01.A04.A02());
        Uri uriA00 = XB.A00(c1567St.A08);
        long jA0S = c1567St.A00;
        if (jA0S == -1) {
            jA0S = C1615Up.A0S(this.A01.A04);
        }
        c2096fbA06.A0I(uriA00, new C2167gk(this, c1567St, jA0S, jCurrentTimeMillis), jA0S);
    }
}
