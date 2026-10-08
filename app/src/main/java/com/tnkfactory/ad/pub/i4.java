package com.tnkfactory.ad.pub;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* JADX INFO: loaded from: classes6.dex */
public final class i4 extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3142a;

    public i4(int i) {
        this.f3142a = i;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        if (this.f3142a > 0) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f3142a);
            view.setClipToOutline(true);
        }
    }
}
