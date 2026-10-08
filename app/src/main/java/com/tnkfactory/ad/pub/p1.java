package com.tnkfactory.ad.pub;

import android.view.View;
import com.tnkfactory.ad.AdListener;

/* JADX INFO: loaded from: classes6.dex */
public final class p1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3175a;

    public p1(x1 x1Var) {
        this.f3175a = x1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x1 x1Var = this.f3175a;
        int i = AdListener.CLOSE_SIMPLE;
        u uVar = x1Var.j;
        if (uVar != null) {
            uVar.sendEmptyMessage(i);
        }
    }
}
