package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class RunnableC3201l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerStatusQueryCallback f3320a;
    private long b;
    private String[] c;
    private int[] d;
    private int[] e;

    RunnableC3201l(IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback, long j, String[] strArr, int[] iArr, int[] iArr2) {
        this.f3320a = iAssetPackManagerStatusQueryCallback;
        this.b = j;
        this.c = strArr;
        this.d = iArr;
        this.e = iArr2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3320a.onStatusResult(this.b, this.c, this.d, this.e);
    }
}
