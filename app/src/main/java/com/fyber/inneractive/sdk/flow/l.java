package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements IAConfigManager.OnConfigurationReadyAndValidListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveAdRequest f1068a;
    public final /* synthetic */ m b;

    public l(m mVar, InneractiveAdRequest inneractiveAdRequest) {
        this.b = mVar;
        this.f1068a = inneractiveAdRequest;
    }

    @Override // com.fyber.inneractive.sdk.config.IAConfigManager.OnConfigurationReadyAndValidListener
    public final void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
        IAConfigManager.removeListener(this);
        if (z) {
            this.b.c(this.f1068a);
            return;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(exc instanceof com.fyber.inneractive.sdk.network.b ? InneractiveErrorCode.CONNECTION_ERROR : InneractiveErrorCode.SDK_NOT_INITIALIZED_OR_CONFIG_ERROR, i.NO_APP_CONFIG_AVAILABLE, exc);
        m mVar = this.b;
        mVar.a(this.f1068a, mVar.c(), inneractiveInfrastructureError);
    }
}
