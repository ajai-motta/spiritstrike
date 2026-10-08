package com.tnkfactory.ad.pub;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l4 f3102a;

    public a(l4 l4Var) {
        super(Looper.getMainLooper());
        this.f3102a = l4Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            Object obj = message.obj;
            if (message.what == 1) {
                if (obj instanceof Throwable) {
                    this.f3102a.a((Throwable) obj);
                } else {
                    this.f3102a.a(obj);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
