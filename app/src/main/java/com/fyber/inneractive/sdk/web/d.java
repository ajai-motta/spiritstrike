package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1687a;

    public d(i1 i1Var) {
        this.f1687a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f1687a;
        if (iVar.k) {
            IAlog.a("No user web action detected for : %s blocking.", iVar.l);
            i iVar2 = this.f1687a;
            String strC = iVar2.l.c();
            String strA = this.f1687a.l.a();
            j1 j1Var = iVar2.g;
            if (j1Var != null) {
                j1Var.a(strC, strA);
            }
            IAlog.d("AD_AUTO_CLICK_DETECTED", new Object[0]);
            this.f1687a.l.b();
            this.f1687a.i();
        } else {
            IAlog.a("User web action detected for: %s", iVar.l);
            this.f1687a.l.d();
        }
        this.f1687a.l = null;
    }
}
