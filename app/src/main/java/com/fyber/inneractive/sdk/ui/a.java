package com.fyber.inneractive.sdk.ui;

import android.view.View;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveFullscreenAdActivity f1631a;

    public a(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f1631a = inneractiveFullscreenAdActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1631a.dismissAd(true);
    }
}
