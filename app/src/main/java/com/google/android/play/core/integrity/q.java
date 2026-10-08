package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class q implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1784a;

    private q() {
        throw null;
    }

    /* synthetic */ q(p pVar) {
    }

    @Override // com.google.android.play.core.integrity.x
    public final s b() {
        com.google.android.play.integrity.internal.ba.a(this.f1784a, Context.class);
        return new s(this.f1784a, null);
    }

    public final q a(Context context) {
        context.getClass();
        this.f1784a = context;
        return this;
    }
}
