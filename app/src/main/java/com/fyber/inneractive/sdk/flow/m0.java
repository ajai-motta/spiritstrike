package com.fyber.inneractive.sdk.flow;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f1070a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(p0 p0Var, long j) {
        super(j, 1000L);
        this.f1070a = p0Var;
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        m0 m0Var = this.f1070a.v;
        if (m0Var != null) {
            m0Var.cancel();
        }
        this.f1070a.d(false);
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        int i = ((int) j) / 1000;
        com.fyber.inneractive.sdk.interfaces.e eVar = this.f1070a.k;
        if (eVar != null) {
            eVar.updateCloseCountdown(i);
        }
    }
}
