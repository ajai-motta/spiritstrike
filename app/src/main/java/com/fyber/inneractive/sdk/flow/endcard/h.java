package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.config.o f1046a;
    public final int b;

    public h() {
        com.fyber.inneractive.sdk.config.o oVar = IAConfigManager.O.u.b;
        this.f1046a = oVar;
        this.b = oVar.a("vast_endcard_x_delay", 5, 0);
    }

    public final void a(b bVar, boolean z) {
        if (bVar == null) {
            IAlog.a("%sapplyVastCompanionEndCardTime was called with a null endcard", IAlog.a(this));
        } else {
            bVar.f = bVar.k() ? z ? this.f1046a.b("d_e_pl_dl_pl", this.b, 0) : this.f1046a.b("d_e_pl", this.b, 0) : z ? this.f1046a.b("d_e_npl_dl_npl", this.b, 0) : this.f1046a.b("d_e_npl", this.b, 0);
        }
    }

    public final void a(b bVar, boolean z, boolean z2) {
        int iB;
        if (bVar == null) {
            IAlog.a("%sapplyNonVastCompanionEndCardTime was called with a null endcard", IAlog.a(this));
            return;
        }
        if (!z) {
            iB = this.f1046a.b("d_e_def", this.b, 0);
        } else if (z2) {
            iB = this.f1046a.b("d_e_pl_dl_dl", this.b, 0);
        } else {
            iB = this.f1046a.b("d_e_npl_dl_dl", this.b, 0);
        }
        bVar.f = iB;
    }
}
