package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class l1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3152a;

    public l1(x1 x1Var) {
        this.f3152a = x1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u uVar = this.f3152a.j;
        if (uVar != null) {
            uVar.sendEmptyMessage(8);
        }
    }
}
