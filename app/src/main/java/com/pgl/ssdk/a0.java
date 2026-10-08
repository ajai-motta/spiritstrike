package com.pgl.ssdk;

import android.os.HandlerThread;
import com.pgl.ssdk.a4;

/* JADX INFO: loaded from: classes6.dex */
public class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a3<a1> f3052a;
    private a4 b;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a0 f3053a = new a0();
    }

    public static a0 a() {
        return b.f3053a;
    }

    public a4 b() {
        if (this.b == null) {
            synchronized (a0.class) {
                if (this.b == null) {
                    this.b = a("ssdk_net_handler");
                }
            }
        }
        return this.b;
    }

    public a4 c() {
        if (this.b == null) {
            synchronized (a0.class) {
                if (this.b == null) {
                    this.b = a("ssdk_handler");
                }
            }
        }
        return this.b;
    }

    private a0() {
        this.f3052a = a3.a(2);
    }

    public a4 a(String str) {
        return b(null, str);
    }

    private a1 a(a4.a aVar, String str) {
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            return new a1(handlerThread, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public a4 b(a4.a aVar, String str) {
        a1 a1Var = (a1) this.f3052a.a();
        if (a1Var != null) {
            a1Var.a(aVar);
            a1Var.a(str);
            return a1Var;
        }
        return a(aVar, str);
    }
}
