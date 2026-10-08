package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile p f260a;
    private static volatile Handler b;

    private static HandlerThread b() {
        if (f260a == null) {
            synchronized (m.class) {
                if (f260a == null) {
                    p pVar = new p("default_npth_thread");
                    f260a = pVar;
                    pVar.b();
                }
            }
        }
        return f260a.c();
    }

    public static p a() {
        if (f260a == null) {
            b();
        }
        return f260a;
    }
}
