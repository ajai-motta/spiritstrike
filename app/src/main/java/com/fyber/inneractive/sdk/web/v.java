package com.fyber.inneractive.sdk.web;

import android.widget.Toast;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1718a;

    public v(String str) {
        this.f1718a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(com.fyber.inneractive.sdk.util.o.f1662a, this.f1718a, 0).show();
    }
}
