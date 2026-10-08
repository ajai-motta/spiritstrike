package com.facebook.ads.redexgen.core;

import android.os.ConditionVariable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1413Mp extends Thread {
    public final /* synthetic */ ConditionVariable A00;
    public final /* synthetic */ C2374kM A01;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1413Mp(C2374kM c2374kM, String str, ConditionVariable conditionVariable) {
        super(str);
        this.A01 = c2374kM;
        this.A00 = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            synchronized (this.A01) {
                try {
                    this.A00.open();
                    this.A01.A05();
                } finally {
                    th = th;
                    while (true) {
                        try {
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            WU.A00(th2, this);
        }
    }
}
