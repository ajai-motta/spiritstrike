package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.d1;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f986a;

    public x(IAConfigManager iAConfigManager) {
        this.f986a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public final void onGlobalConfigChanged(s sVar, o oVar) {
        if (oVar.a("dv_enabled_v3", 0, 0) == 1) {
            this.f986a.G.a();
        }
        com.fyber.inneractive.sdk.network.f fVar = this.f986a.I;
        fVar.getClass();
        int iA = IAConfigManager.O.u.b.a("send_events_batch_interval", 30, -1);
        int i = iA >= 0 ? iA : 30;
        String property = System.getProperty("fyber.marketplace.use_batch_interval");
        int i2 = (property == null || Boolean.getBoolean(property)) ? i : 0;
        fVar.f = true;
        fVar.e = i2;
        d1 d1Var = fVar.d;
        if (d1Var != null && d1Var.hasMessages(12312329)) {
            fVar.d.removeMessages(12312329);
        }
        long j = fVar.e * 1000;
        d1 d1Var2 = fVar.d;
        if (d1Var2 != null) {
            d1Var2.post(new com.fyber.inneractive.sdk.network.c(fVar, 12312329, j));
        }
    }
}
