package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements com.fyber.inneractive.sdk.click.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g1 f1129a;
    public final /* synthetic */ com.fyber.inneractive.sdk.util.g b;
    public final /* synthetic */ com.fyber.inneractive.sdk.click.o c;
    public final /* synthetic */ b0 d;

    public z(b0 b0Var, g1 g1Var, com.fyber.inneractive.sdk.util.g gVar, com.fyber.inneractive.sdk.click.o oVar) {
        this.d = b0Var;
        this.f1129a = g1Var;
        this.b = gVar;
        this.c = oVar;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        b0 b0Var = this.d;
        b0Var.getClass();
        IAlog.a("%s super click result: %s", IAlog.a(b0Var), bVar);
        b0 b0Var2 = this.d;
        if (b0Var2.h == null) {
            IAlog.a("%s click handler is null. Probably cancelled", IAlog.a(b0Var2));
            return;
        }
        b0Var2.h = null;
        b0Var2.i = null;
        b0Var2.I();
        b0 b0Var3 = this.d;
        g1 g1Var = this.f1129a;
        com.fyber.inneractive.sdk.util.g gVar = this.b;
        b0Var3.getClass();
        com.fyber.inneractive.sdk.click.q qVar = bVar.f913a;
        if (qVar == com.fyber.inneractive.sdk.click.q.OPEN_IN_EXTERNAL_APPLICATION || qVar == com.fyber.inneractive.sdk.click.q.OPEN_GOOGLE_STORE) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external application", new Object[0]);
            ArrayList arrayList = bVar.f;
            com.fyber.inneractive.sdk.click.j jVar = (com.fyber.inneractive.sdk.click.j) arrayList.get(arrayList.size() - 1);
            com.fyber.inneractive.sdk.click.q qVar2 = jVar.c;
            if (qVar2 == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) {
                b0Var3.a(jVar.f920a, qVar2);
            }
            if (b0Var3.c != null) {
                b0Var3.H();
            }
        } else if (qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_INTERNAL_BROWSER) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in internal browser", new Object[0]);
            b0Var3.d = true;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(b0Var3);
        } else if (qVar == com.fyber.inneractive.sdk.click.q.OPENED_USING_CHROME_NAVIGATE || qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external browser", new Object[0]);
            b0Var3.a(bVar.d, bVar.f913a);
            if (b0Var3.c != null) {
                b0Var3.H();
            }
        }
        if (b0Var3.p() == com.fyber.inneractive.sdk.ignite.m.NONE || (!TextUtils.isEmpty(bVar.c) && !bVar.c.equals("IgniteGooglePlay"))) {
            b0Var3.b(bVar, g1Var, gVar);
        }
        com.fyber.inneractive.sdk.click.o oVar = this.c;
        if (oVar != null) {
            oVar.a(bVar);
        }
    }
}
