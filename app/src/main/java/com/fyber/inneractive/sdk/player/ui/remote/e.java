package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.player.ui.n;
import com.fyber.inneractive.sdk.util.g1;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f1532a;
    public boolean c = false;
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    public e(d dVar) {
        this.f1532a = dVar;
    }

    public final void a(String str, String str2, boolean z) {
        if (!z) {
            this.b.put(str, str2);
            return;
        }
        d dVar = this.f1532a;
        if (dVar != null) {
            dVar.b.a(str2);
        }
    }

    public final void a(int i, g1 g1Var) {
        n nVar;
        d dVar = this.f1532a;
        if (dVar == null || (nVar = dVar.e) == null) {
            return;
        }
        ((z) nVar).a(i, g1Var);
    }
}
