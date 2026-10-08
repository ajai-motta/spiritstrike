package com.fyber.inneractive.sdk.mraid;

import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 extends y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f1181a;

    public d0(f0 f0Var) {
        this.f1181a = f0Var;
    }

    @Override // com.fyber.inneractive.sdk.mraid.y
    public final String a() {
        return "state: '" + this.f1181a.toString().toLowerCase(Locale.US) + "'";
    }
}
