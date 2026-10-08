package com.fyber.inneractive.sdk.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f1645a = new CopyOnWriteArrayList();
    public boolean b;
    public Context c;
    public y d;

    public static void a(b0 b0Var, Context context, Intent intent) {
        boolean zIsKeyguardLocked;
        synchronized (b0Var) {
            try {
                zIsKeyguardLocked = ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardLocked();
            } catch (Exception unused) {
                IAlog.a("%sFailed to get lock screen status", IAlog.a(b0Var));
                zIsKeyguardLocked = false;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                b0Var.b = true;
            } else if (("android.intent.action.SCREEN_ON".equals(intent.getAction()) && !zIsKeyguardLocked) || "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                b0Var.b = false;
            }
            IAlog.a("%sNew screen state is locked: %s. number of listeners: %d", IAlog.a(b0Var), Boolean.valueOf(b0Var.b), Integer.valueOf(b0Var.f1645a.size()));
            for (a0 a0Var : b0Var.f1645a) {
                boolean z = b0Var.b;
                com.fyber.inneractive.sdk.renderers.l lVar = (com.fyber.inneractive.sdk.renderers.l) a0Var;
                lVar.getClass();
                IAlog.a("%sgot onLockScreenStateChanged with: %s", IAlog.a(lVar), Boolean.valueOf(z));
                if (z) {
                    lVar.c(false);
                    com.fyber.inneractive.sdk.renderers.d dVar = lVar.y;
                    if (dVar != null && dVar.g) {
                        dVar.g = false;
                        r.b.removeCallbacks(dVar.j);
                    }
                } else {
                    lVar.O();
                    com.fyber.inneractive.sdk.renderers.d dVar2 = lVar.y;
                    if (dVar2 != null && !dVar2.h && !dVar2.g && dVar2.f != 0) {
                        dVar2.f = 0L;
                        dVar2.g = true;
                        dVar2.a();
                    }
                }
            }
        }
    }
}
