package com.google.androidgamesdk;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes5.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ChoreographerCallback f1813a;

    a(ChoreographerCallback choreographerCallback) {
        this.f1813a = choreographerCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().postFrameCallback(this.f1813a);
    }
}
