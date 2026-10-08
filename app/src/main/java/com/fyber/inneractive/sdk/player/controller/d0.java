package com.fyber.inneractive.sdk.player.controller;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1240a;

    public d0(f0 f0Var) {
        this.f1240a = f0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1240a.b.dismiss();
        v vVar = this.f1240a.f1243a;
        vVar.b.d(vVar.f1255a);
    }
}
