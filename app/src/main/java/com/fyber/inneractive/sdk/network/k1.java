package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes3.dex */
public class k1 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1204a;

    public k1(String str, int i) {
        super(str);
        this.f1204a = i;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return String.valueOf(this.f1204a);
    }
}
