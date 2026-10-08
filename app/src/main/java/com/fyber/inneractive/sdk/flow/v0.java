package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.IAConfigManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1119a = true;
    public String b;

    public boolean getAllowFullscreen() {
        return this.f1119a;
    }

    public String getMediationName() {
        return IAConfigManager.O.l;
    }

    public String getMediationVersion() {
        return IAConfigManager.O.n;
    }
}
