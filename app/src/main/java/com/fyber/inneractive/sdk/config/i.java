package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f957a;
    public WeakReference b;

    public i(Context context, Context context2) {
        h hVar = new h(this);
        this.f957a = context2;
        if (context instanceof Activity) {
            this.b = new WeakReference(context);
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(hVar);
        }
    }

    public final Context a() {
        Context context = (Context) com.fyber.inneractive.sdk.util.v.a(this.b);
        return context != null ? context : this.f957a;
    }
}
