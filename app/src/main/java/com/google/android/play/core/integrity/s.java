package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.bb f1785a;
    private final com.google.android.play.integrity.internal.bb b;
    private final com.google.android.play.integrity.internal.bb c;
    private final com.google.android.play.integrity.internal.bb d;
    private final com.google.android.play.integrity.internal.bb e;

    /* synthetic */ s(Context context, r rVar) {
        com.google.android.play.integrity.internal.ay ayVarB = com.google.android.play.integrity.internal.az.b(context);
        this.f1785a = ayVarB;
        com.google.android.play.integrity.internal.bb bbVarB = com.google.android.play.integrity.internal.ax.b(ac.f1742a);
        this.b = bbVarB;
        au auVar = new au(ayVarB, l.f1780a);
        this.c = auVar;
        com.google.android.play.integrity.internal.bb bbVarB2 = com.google.android.play.integrity.internal.ax.b(new al(ayVarB, bbVarB, auVar, l.f1780a));
        this.d = bbVarB2;
        this.e = com.google.android.play.integrity.internal.ax.b(new ab(bbVarB2));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.e.a();
    }
}
