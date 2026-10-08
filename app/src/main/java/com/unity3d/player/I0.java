package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class I0 implements Runnable {
    I0() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC3183c.a();
        } catch (Exception e) {
            AbstractC3229z.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}
