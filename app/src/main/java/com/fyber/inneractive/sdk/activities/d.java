package com.fyber.inneractive.sdk.activities;

import android.view.View;
import com.fyber.inneractive.sdk.util.r;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements View.OnSystemUiVisibilityChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveFullscreenAdActivity f865a;

    public d(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f865a = inneractiveFullscreenAdActivity;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        if ((i & 2) == 0) {
            r.b.postDelayed(this.f865a.mHideNavigationBarTask, 3000L);
        }
    }
}
