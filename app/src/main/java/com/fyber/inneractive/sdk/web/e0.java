package com.fyber.inneractive.sdk.web;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1690a;
    public int b = -1;
    public final /* synthetic */ i0 c;

    public e0(i0 i0Var) {
        this.c = i0Var;
    }

    public final void a() {
        try {
            i0 i0Var = this.c;
            i0Var.getClass();
            IAlog.a("%sunregister screen broadcast receiver called", IAlog.a(i0Var));
            if (this.f1690a != null) {
                i0 i0Var2 = this.c;
                i0Var2.getClass();
                IAlog.a("%sunregistering broadcast receiver", IAlog.a(i0Var2));
                this.f1690a.unregisterReceiver(this);
                this.f1690a = null;
            }
        } catch (Throwable th) {
            IAlog.f("IAmraidWebViewControllerBase: OrientationBroadcastReceiver: unregister: exception: %s", th.toString());
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int iB;
        if (this.f1690a == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (iB = com.fyber.inneractive.sdk.util.o.b()) == this.b) {
            return;
        }
        this.b = iB;
        i0 i0Var = this.c;
        m mVar = i0Var.b;
        if (mVar != null) {
            mVar.getViewTreeObserver().removeOnPreDrawListener(i0Var.n0);
            i0Var.b.getViewTreeObserver().addOnPreDrawListener(i0Var.n0);
        }
    }
}
