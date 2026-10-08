package com.fyber.inneractive.sdk.player.mediaplayer;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1508a;

    public g(p pVar) {
        this.f1508a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.b(this.f1508a);
        Handler handler = this.f1508a.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f1508a.o = null;
        }
        this.f1508a.n = null;
        Looper.myLooper().quit();
    }
}
