package com.tnkfactory.ad.pub;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class q1 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x1 f3180a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(x1 x1Var, Looper looper) {
        super(looper);
        this.f3180a = x1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        View view = this.f3180a.k;
        if (view != null) {
            view.setVisibility(0);
        }
    }
}
