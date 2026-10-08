package com.fyber.inneractive.sdk.flow.endcard;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.x0;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1044a = IAlog.a(this);
    public JSONArray b = null;
    public final x0 c;
    public n d;
    public int e;
    public int f;

    public b(int i, x0 x0Var) {
        this.c = x0Var;
        this.f = i;
    }

    public abstract void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar);

    public void a(JSONArray jSONArray) {
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final View b() {
        return f().b();
    }

    public abstract n c();

    public com.fyber.inneractive.sdk.player.ui.c d() {
        com.fyber.inneractive.sdk.config.global.features.u uVar = this.c.g;
        com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
        cVar.f1521a = l();
        cVar.f = i();
        boolean zB = b(uVar);
        Integer numValueOf = Integer.valueOf(a(uVar));
        if (zB) {
            cVar.d = numValueOf;
        }
        return cVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public void destroy() {
        e();
        n nVar = this.d;
        if (nVar != null) {
            nVar.destroy();
            this.d = null;
        }
    }

    public void e() {
        a();
    }

    public final n f() {
        if (this.d == null) {
            this.d = c();
        }
        return this.d;
    }

    public abstract com.fyber.inneractive.sdk.util.g g();

    public abstract l h();

    public abstract com.fyber.inneractive.sdk.model.vast.i i();

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public abstract boolean l();

    public void m() {
        IAlog.a("%s loading success for %s", i(), this.f1044a);
    }

    public static boolean b(com.fyber.inneractive.sdk.config.global.features.u uVar) {
        Boolean boolC;
        return (uVar == null || (boolC = uVar.c("shouldEnableEndCardAutoClick")) == null || !boolC.booleanValue()) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final void a() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.a();
        }
    }

    public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s loading failed for %s", inneractiveInfrastructureError.getCause(), i(), this.f1044a);
    }

    public static int a(com.fyber.inneractive.sdk.config.global.features.u uVar) {
        if (uVar == null) {
            return 3;
        }
        Integer numA = uVar.a("autoClickDelay");
        int iIntValue = numA != null ? numA.intValue() : 3;
        if (iIntValue < 0 || iIntValue > 10) {
            return 3;
        }
        return iIntValue;
    }
}
