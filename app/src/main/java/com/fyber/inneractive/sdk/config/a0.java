package com.fyber.inneractive.sdk.config;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f926a;
    public final /* synthetic */ Context b;

    public a0(IAConfigManager iAConfigManager, Context context) {
        this.f926a = iAConfigManager;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Class.forName("com.iab.omid.library.fyber.Omid");
            com.fyber.inneractive.sdk.util.r.b.post(new z(this));
        } catch (Throwable unused) {
        }
    }
}
