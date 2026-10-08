package com.fyber.inneractive.sdk.ui;

import android.view.View;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FyberAdIdentifierLocal f1633a;

    public c(FyberAdIdentifierLocal fyberAdIdentifierLocal) {
        this.f1633a = fyberAdIdentifierLocal;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f1633a.q = this.f1633a.n.getWidth() + r1.n.getWidth();
        FyberAdIdentifierLocal fyberAdIdentifierLocal = this.f1633a;
        IFyberAdIdentifier.Corner corner = fyberAdIdentifierLocal.k;
        if (corner == IFyberAdIdentifier.Corner.TOP_LEFT || corner == IFyberAdIdentifier.Corner.BOTTOM_LEFT) {
            fyberAdIdentifierLocal.q *= -1.0f;
        }
        fyberAdIdentifierLocal.n.setTranslationX(fyberAdIdentifierLocal.q);
        FyberAdIdentifierLocal fyberAdIdentifierLocal2 = this.f1633a;
        if (fyberAdIdentifierLocal2.o) {
            fyberAdIdentifierLocal2.a();
        }
    }
}
