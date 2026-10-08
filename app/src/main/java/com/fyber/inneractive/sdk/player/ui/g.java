package com.fyber.inneractive.sdk.player.ui;

import android.view.TextureView;
import android.view.View;
import com.fyber.inneractive.sdk.util.v;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1524a;

    public g(s sVar) {
        super(sVar.getContext());
        this.f1524a = new WeakReference(sVar);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        s sVar = (s) v.a(this.f1524a);
        if (sVar instanceof i) {
            sVar = ((i) sVar).y;
        }
        if (sVar != null) {
            i = View.MeasureSpec.makeMeasureSpec(sVar.t.f1654a, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(sVar.t.b, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
