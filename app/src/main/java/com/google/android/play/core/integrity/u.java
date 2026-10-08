package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class u implements av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1786a;

    private u() {
        throw null;
    }

    /* synthetic */ u(t tVar) {
    }

    @Override // com.google.android.play.core.integrity.av
    public final aw b() {
        com.google.android.play.integrity.internal.ba.a(this.f1786a, Context.class);
        return new w(this.f1786a, null);
    }

    public final u a(Context context) {
        context.getClass();
        this.f1786a = context;
        return this;
    }
}
