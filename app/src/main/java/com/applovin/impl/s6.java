package com.applovin.impl;

/* JADX INFO: loaded from: classes2.dex */
public class s6 extends j5 {
    private final Runnable g;

    public s6(com.applovin.impl.sdk.k kVar, String str, Runnable runnable) {
        this(kVar, false, str, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.g.run();
    }

    public s6(com.applovin.impl.sdk.k kVar, boolean z, String str, Runnable runnable) {
        super("TaskRunnable:" + str, kVar, z);
        this.g = runnable;
    }
}
