package com.tnkfactory.ad.pub;

import android.view.View;
import com.tnkfactory.ad.AdListener;

/* JADX INFO: loaded from: classes6.dex */
public final class r1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3185a;

    public r1(x1 x1Var) {
        this.f3185a = x1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x1 x1Var = this.f3185a;
        int i = AdListener.CLOSE_EXIT;
        u uVar = x1Var.j;
        if (uVar != null) {
            uVar.sendEmptyMessage(i);
        }
    }
}
