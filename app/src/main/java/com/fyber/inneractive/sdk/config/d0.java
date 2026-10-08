package com.fyber.inneractive.sdk.config;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f936a;

    public d0(IAConfigManager iAConfigManager) {
        this.f936a = iAConfigManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAConfigManager iAConfigManager = this.f936a;
        if (iAConfigManager.p == null) {
            iAConfigManager.p = j.a(iAConfigManager.f);
        }
        com.fyber.inneractive.sdk.util.r.b.post(new c0(this));
    }
}
