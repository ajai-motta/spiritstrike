package com.apm.insight.b;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f139a;
    private static g c;
    private final b b;

    public static f a(Context context) {
        if (f139a == null) {
            synchronized (f.class) {
                if (f139a == null) {
                    f139a = new f(context);
                }
            }
        }
        return f139a;
    }

    private f(Context context) {
        this.b = new b(context);
        g gVar = new g();
        c = gVar;
        gVar.a();
    }

    public final b a() {
        return this.b;
    }

    public static g b() {
        return c;
    }

    public final void c() {
        this.b.a();
    }

    public final void d() {
        this.b.b();
    }
}
