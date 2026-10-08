package com.apm.insight.j;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f183a;
    private final long b = 0;
    private final long c;

    a(Handler handler, long j) {
        this.f183a = handler;
        this.c = j;
    }

    final void a() {
        this.f183a.post(this);
    }

    final void a(long j) {
        if (j > 0) {
            this.f183a.postDelayed(this, j);
        } else {
            this.f183a.post(this);
        }
    }

    final long b() {
        return this.c;
    }
}
