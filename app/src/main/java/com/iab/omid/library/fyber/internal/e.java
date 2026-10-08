package com.iab.omid.library.fyber.internal;

import android.view.View;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.fyber.weakreference.a f1899a;
    private final String b;
    private final FriendlyObstructionPurpose c;
    private final String d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f1899a = new com.iab.omid.library.fyber.weakreference.a(view);
        this.b = view.getClass().getCanonicalName();
        this.c = friendlyObstructionPurpose;
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public FriendlyObstructionPurpose b() {
        return this.c;
    }

    public com.iab.omid.library.fyber.weakreference.a c() {
        return this.f1899a;
    }

    public String d() {
        return this.b;
    }
}
