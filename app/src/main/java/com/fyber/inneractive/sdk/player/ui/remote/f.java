package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.ignite.m;
import com.fyber.inneractive.sdk.player.ui.o;
import com.fyber.inneractive.sdk.player.ui.s;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements com.fyber.inneractive.sdk.web.remoteui.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f1533a;
    public boolean h;
    public boolean b = false;
    public boolean c = false;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean i = false;
    public boolean j = false;
    public m k = m.NONE;
    public String l = "";

    public f(o oVar) {
        this.f1533a = null;
        this.h = false;
        this.f1533a = oVar;
        this.h = oVar.H;
    }

    @Override // com.fyber.inneractive.sdk.web.remoteui.a
    public final void a(com.fyber.inneractive.sdk.network.events.b bVar, String str, boolean z, HashMap map) {
        s sVar = this.f1533a;
        if (sVar == null) {
            IAlog.a("%s: showFallback: fallback won't be displayed because it is null", "RemoteUiFallbackHandler");
            return;
        }
        sVar.g(this.b);
        this.f1533a.d(this.i);
        this.f1533a.f(this.f);
        this.f1533a.a(this.e, this.k);
        this.f1533a.c(this.h);
        this.f1533a.a(this.j, this.l);
        this.f1533a.b(this.g);
        this.f1533a.e(this.c);
        this.f1533a.a(this.d);
    }
}
