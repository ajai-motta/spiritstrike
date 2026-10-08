package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.IntentFilter;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1710a;

    public r(i0 i0Var) {
        this.f1710a = i0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 i0Var = this.f1710a;
        if (i0Var.V == null) {
            try {
                i0Var.getClass();
                IAlog.a("%sregistering orientation broadcast receiver", IAlog.a(i0Var));
                this.f1710a.V = new e0(this.f1710a);
                if (com.fyber.inneractive.sdk.util.o.a(this.f1710a.b) != null) {
                    i0 i0Var2 = this.f1710a;
                    e0 e0Var = i0Var2.V;
                    Context contextA = com.fyber.inneractive.sdk.util.o.a(i0Var2.b);
                    i0 i0Var3 = e0Var.c;
                    i0Var3.getClass();
                    IAlog.a("%sregister screen broadcast receiver", IAlog.a(i0Var3));
                    e0Var.f1690a = contextA;
                    contextA.registerReceiver(e0Var, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
                }
            } catch (Exception e) {
                i0 i0Var4 = this.f1710a;
                i0Var4.getClass();
                IAlog.f("%sfailed registering orientation broadcast recevier", IAlog.a(i0Var4));
                if (IAlog.f1642a >= 3) {
                    e.printStackTrace();
                }
            }
        }
    }
}
