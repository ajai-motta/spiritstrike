package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1713a;

    public s(i0 i0Var) {
        this.f1713a = i0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i0 i0Var = this.f1713a;
            if (i0Var.V != null) {
                i0Var.getClass();
                IAlog.a("%sunregistering orientation broadcast receiver", IAlog.a(i0Var));
                this.f1713a.V.a();
            }
        } catch (IllegalArgumentException e) {
            if (e.getMessage() != null && !e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        this.f1713a.V = null;
    }
}
