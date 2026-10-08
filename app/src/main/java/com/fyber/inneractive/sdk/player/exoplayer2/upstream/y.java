package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends Handler implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f1461a;
    public final x b;
    public final int c;
    public final long d;
    public IOException e;
    public int f;
    public volatile Thread g;
    public volatile boolean h;
    public final /* synthetic */ b0 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Looper looper, z zVar, x xVar, int i, long j) {
        super(looper);
        this.i = b0Var;
        this.f1461a = zVar;
        this.b = xVar;
        this.c = i;
        this.d = j;
    }

    public final void a(boolean z) {
        this.h = z;
        this.e = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.f1461a.b();
            if (this.g != null) {
                this.g.interrupt();
            }
        }
        if (z) {
            this.i.b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.b.a(this.f1461a, jElapsedRealtime, jElapsedRealtime - this.d, true);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.h) {
            return;
        }
        int i = message.what;
        if (i == 0) {
            this.e = null;
            b0 b0Var = this.i;
            b0Var.f1434a.execute(b0Var.b);
            return;
        }
        if (i == 4) {
            throw ((Error) message.obj);
        }
        this.i.b = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.d;
        if (this.f1461a.a()) {
            this.b.a(this.f1461a, jElapsedRealtime, j, false);
            return;
        }
        int i2 = message.what;
        if (i2 == 1) {
            this.b.a(this.f1461a, jElapsedRealtime, j, false);
            return;
        }
        if (i2 == 2) {
            this.b.a(this.f1461a, jElapsedRealtime, j);
            return;
        }
        if (i2 != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.e = iOException;
        int iA = this.b.a(this.f1461a, jElapsedRealtime, j, iOException);
        if (iA == 3) {
            this.i.c = this.e;
            return;
        }
        if (iA != 2) {
            int i3 = iA == 1 ? 1 : this.f + 1;
            this.f = i3;
            long jMin = Math.min((i3 - 1) * 1000, 5000);
            b0 b0Var2 = this.i;
            if (b0Var2.b != null) {
                throw new IllegalStateException();
            }
            b0Var2.b = this;
            if (jMin > 0) {
                sendEmptyMessageDelayed(0, jMin);
            } else {
                this.e = null;
                b0Var2.f1434a.execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.g = Thread.currentThread();
            if (!this.f1461a.a()) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.w.a("load:".concat(this.f1461a.getClass().getSimpleName()));
                try {
                    this.f1461a.load();
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                } catch (Throwable th) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.w.a();
                    throw th;
                }
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.h) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (InterruptedException unused) {
            if (!this.f1461a.a()) {
                throw new IllegalStateException();
            }
            if (this.h) {
                return;
            }
            sendEmptyMessage(2);
        } catch (Exception e2) {
            Log.e("LoadTask", "Unexpected exception loading stream", e2);
            if (this.h) {
                return;
            }
            obtainMessage(3, new a0(e2)).sendToTarget();
        } catch (OutOfMemoryError e3) {
            Log.e("LoadTask", "OutOfMemory error loading stream", e3);
            if (this.h) {
                return;
            }
            obtainMessage(3, new a0(e3)).sendToTarget();
        } catch (Error e4) {
            Log.e("LoadTask", "Unexpected error loading stream", e4);
            if (!this.h) {
                obtainMessage(4, e4).sendToTarget();
            }
            throw e4;
        }
    }
}
