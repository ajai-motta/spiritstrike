package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class al implements com.google.android.play.integrity.internal.ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.bd f1749a;
    private final com.google.android.play.integrity.internal.bd b;
    private final com.google.android.play.integrity.internal.bd c;

    public al(com.google.android.play.integrity.internal.bd bdVar, com.google.android.play.integrity.internal.bd bdVar2, com.google.android.play.integrity.internal.bd bdVar3, com.google.android.play.integrity.internal.bd bdVar4) {
        this.f1749a = bdVar;
        this.b = bdVar2;
        this.c = bdVar3;
    }

    @Override // com.google.android.play.integrity.internal.bd, com.google.android.play.integrity.internal.bc
    public final /* bridge */ /* synthetic */ Object a() {
        return new aj((Context) this.f1749a.a(), (com.google.android.play.integrity.internal.s) this.b.a(), ((au) this.c).a(), new i());
    }
}
