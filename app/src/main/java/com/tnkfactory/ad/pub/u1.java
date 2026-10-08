package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class u1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3201a;

    public u1(x1 x1Var) {
        this.f3201a = x1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x1 x1Var = this.f3201a;
        x1Var.getClass();
        String str = (String) view.getTag();
        if (str == null) {
            return;
        }
        x1Var.b(str);
    }
}
