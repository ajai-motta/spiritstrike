package com.fyber.inneractive.sdk.activities;

import android.window.OnBackInvokedCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements OnBackInvokedCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveBaseActivity f863a;

    public b(InneractiveBaseActivity inneractiveBaseActivity) {
        this.f863a = inneractiveBaseActivity;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f863a.onBackPressed();
    }
}
