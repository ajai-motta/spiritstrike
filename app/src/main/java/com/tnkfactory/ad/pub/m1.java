package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class m1 implements h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3158a;

    public m1(x1 x1Var) {
        this.f3158a = x1Var;
    }

    public final void a(int i) {
        Logger.d("##### on Progress " + i);
        u uVar = this.f3158a.j;
        if (uVar != null) {
            uVar.sendEmptyMessage(i + 100);
        }
    }
}
