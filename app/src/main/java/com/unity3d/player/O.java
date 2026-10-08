package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class O implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final long f3270a;
    final long b;

    public O(long j, long j2) {
        this.f3270a = j;
        this.b = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (ReflectionHelper.beginProxyCall(this.f3270a)) {
            try {
                ReflectionHelper.nativeProxyFinalize(this.b);
            } finally {
                ReflectionHelper.endProxyCall();
            }
        }
    }
}
