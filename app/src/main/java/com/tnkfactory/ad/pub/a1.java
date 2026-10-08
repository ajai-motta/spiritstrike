package com.tnkfactory.ad.pub;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: loaded from: classes6.dex */
public final class a1 extends HandlerThread implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3104a;
    public final Context b;
    public final /* synthetic */ b1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a1(b1 b1Var, Context context) {
        super(h1.a("e4790f98ec43b06fdf7065473beb"));
        this.c = b1Var;
        this.b = context;
    }

    public final void a() {
        if (this.f3104a == null) {
            this.f3104a = new Handler(getLooper(), this);
        }
        this.f3104a.sendEmptyMessage(1);
    }

    public final void b() {
        if (this.f3104a == null) {
            this.f3104a = new Handler(getLooper(), this);
        }
        this.f3104a.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        Handler handler;
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            b1 b1Var = this.c;
            if (b1Var.n != 0 && (handler = b1Var.o) != null) {
                handler.sendEmptyMessage(1);
            }
            return true;
        }
        b1 b1Var2 = this.c;
        if (b1Var2.n == 0 || !b1Var2.e(this.b)) {
            return true;
        }
        b1 b1Var3 = this.c;
        long j = b1Var3.q;
        if (j > 0) {
            b1Var3.q = j - 1;
            b(1000L);
            return true;
        }
        Handler handler2 = b1Var3.o;
        if (handler2 != null) {
            handler2.sendEmptyMessage(0);
        }
        return true;
    }

    public final void a(long j) {
        if (this.f3104a == null) {
            this.f3104a = new Handler(getLooper(), this);
        }
        this.f3104a.sendEmptyMessageDelayed(1, j);
    }

    public final void b(long j) {
        if (this.f3104a == null) {
            this.f3104a = new Handler(getLooper(), this);
        }
        this.f3104a.removeMessages(0);
        this.f3104a.sendEmptyMessageDelayed(0, j);
    }
}
