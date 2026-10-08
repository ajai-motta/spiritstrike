package com.fyber.inneractive.sdk.privacysandbox;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1535a;

    public a(String str) {
        this.f1535a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.c("Registered source %s", this.f1535a);
    }
}
