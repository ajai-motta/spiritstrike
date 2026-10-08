package com.fyber.inneractive.sdk.activities;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f873a;

    public l(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f873a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f873a.finish();
    }
}
