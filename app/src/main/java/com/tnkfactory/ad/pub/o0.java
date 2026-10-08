package com.tnkfactory.ad.pub;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes6.dex */
public final class o0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3169a;
    public final LinkedBlockingQueue b = new LinkedBlockingQueue();

    public o0() {
        this.f3169a = false;
        this.f3169a = false;
    }

    public final IBinder a() {
        if (this.f3169a) {
            throw new IllegalStateException();
        }
        this.f3169a = true;
        return (IBinder) this.b.take();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.b.put(iBinder);
        } catch (InterruptedException unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
