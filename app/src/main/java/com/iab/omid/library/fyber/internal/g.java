package com.iab.omid.library.fyber.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class g {
    private static g b = new g();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1901a;

    private g() {
    }

    public static g b() {
        return b;
    }

    public Context a() {
        return this.f1901a;
    }

    public void a(Context context) {
        this.f1901a = context != null ? context.getApplicationContext() : null;
    }
}
