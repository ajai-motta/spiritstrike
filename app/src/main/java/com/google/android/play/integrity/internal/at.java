package com.google.android.play.integrity.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class at extends ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ar f1802a = new at(new Object[0], 0);
    final transient Object[] b;

    at(Object[] objArr, int i) {
        this.b = objArr;
    }

    @Override // com.google.android.play.integrity.internal.ar, com.google.android.play.integrity.internal.ao
    final int a(Object[] objArr, int i) {
        System.arraycopy(this.b, 0, objArr, 0, 0);
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    final int b() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    final int c() {
        return 0;
    }

    @Override // com.google.android.play.integrity.internal.ao
    final Object[] e() {
        return this.b;
    }

    @Override // java.util.List
    public final Object get(int i) {
        al.a(i, 0, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.b[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return 0;
    }
}
