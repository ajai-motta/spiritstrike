package com.applovin.impl.sdk;

import com.applovin.impl.h7;
import com.applovin.impl.sdk.a;
import com.applovin.impl.t1;
import com.applovin.impl.y4;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f622a;
    private final WeakReference b;
    private final WeakReference c;
    private h7 d;

    private b(t1 t1Var, a.InterfaceC0157a interfaceC0157a, k kVar) {
        this.b = new WeakReference(t1Var);
        this.c = new WeakReference(interfaceC0157a);
        this.f622a = kVar;
    }

    public static b a(t1 t1Var, a.InterfaceC0157a interfaceC0157a, k kVar) {
        b bVar = new b(t1Var, interfaceC0157a, kVar);
        bVar.a(t1Var.getTimeToLiveMillis());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f622a.f().a(this);
    }

    public t1 b() {
        return (t1) this.b.get();
    }

    public void d() {
        a();
        t1 t1VarB = b();
        if (t1VarB == null) {
            return;
        }
        t1VarB.setExpired();
        a.InterfaceC0157a interfaceC0157a = (a.InterfaceC0157a) this.c.get();
        if (interfaceC0157a == null) {
            return;
        }
        interfaceC0157a.onAdExpired(t1VarB);
    }

    public void a(long j) {
        a();
        if (((Boolean) this.f622a.a(y4.g1)).booleanValue() || !this.f622a.n0().isApplicationPaused()) {
            this.d = h7.a(j, this.f622a, new Runnable() { // from class: com.applovin.impl.sdk.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c();
                }
            });
        }
    }

    public void a() {
        h7 h7Var = this.d;
        if (h7Var != null) {
            h7Var.a();
            this.d = null;
        }
    }
}
