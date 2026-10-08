package com.fyber.inneractive.sdk.mraid;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.web.c0 f1177a;

    public b0(com.fyber.inneractive.sdk.web.c0 c0Var) {
        this.f1177a = c0Var;
    }

    @Override // com.fyber.inneractive.sdk.mraid.y
    public final String a() {
        return "placementType: '" + this.f1177a.toString().toLowerCase(Locale.US) + "'";
    }
}
