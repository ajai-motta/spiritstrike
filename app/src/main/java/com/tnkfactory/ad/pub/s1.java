package com.tnkfactory.ad.pub;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class s1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3191a;

    public s1(x1 x1Var) {
        this.f3191a = x1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        x1 x1Var = this.f3191a;
        if (view != null) {
            x1Var.getClass();
            try {
                i = Integer.parseInt((String) view.getTag());
            } catch (Exception unused) {
                i = 0;
            }
        } else {
            i = 0;
        }
        u uVar = x1Var.j;
        if (uVar != null) {
            x1Var.j.sendMessage(uVar.obtainMessage(1, i, 0));
        }
    }
}
