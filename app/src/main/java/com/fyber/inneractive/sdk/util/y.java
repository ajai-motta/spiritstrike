package com.fyber.inneractive.sdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b0 f1678a;

    public y(b0 b0Var) {
        this.f1678a = b0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        b0 b0Var = this.f1678a;
        b0Var.getClass();
        IAlog.a("%sonReceive. action = %s", IAlog.a(b0Var), intent.getAction());
        b0.a(this.f1678a, context, intent);
    }
}
