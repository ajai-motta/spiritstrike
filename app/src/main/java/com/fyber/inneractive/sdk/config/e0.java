package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 implements com.fyber.inneractive.sdk.network.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAConfigManager f938a;

    public e0(IAConfigManager iAConfigManager) {
        this.f938a = iAConfigManager;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.config.global.l lVar = (com.fyber.inneractive.sdk.config.global.l) obj;
        if (lVar != null) {
            IAlog.a("calling mergeRemoteFeaturesConfig fromCache: %b", Boolean.valueOf(z));
            IAConfigManager iAConfigManager = this.f938a;
            iAConfigManager.z.f942a = lVar;
            if (z) {
                return;
            }
            iAConfigManager.M.a(true, "");
            IAConfigManager.O.E.a(iAConfigManager.M);
            return;
        }
        if (exc != null) {
            if (exc instanceof com.fyber.inneractive.sdk.network.g) {
                IAlog.a("remote features config not modified", new Object[0]);
                IAConfigManager iAConfigManager2 = this.f938a;
                iAConfigManager2.M.a(true, "");
                IAConfigManager.O.E.a(iAConfigManager2.M);
                return;
            }
            IAlog.a("Config manager: Error getting or parsing remote config. Resetting configurable features", new Object[0]);
            IAConfigManager iAConfigManager3 = this.f938a;
            IAConfigManager iAConfigManager4 = IAConfigManager.O;
            iAConfigManager3.getClass();
            new com.fyber.inneractive.sdk.network.w(com.fyber.inneractive.sdk.network.t.FATAL_FEATURES_CONFIG_ERROR).a("exception", exc.getClass().getName(), "message", exc.getLocalizedMessage()).a((String) null);
        }
    }
}
