package com.google.android.play.integrity.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class aq extends ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final transient int f1799a;
    final transient int b;
    final /* synthetic */ ar c;

    aq(ar arVar, int i, int i2) {
        this.c = arVar;
        this.f1799a = i;
        this.b = i2;
    }

    @Override // com.google.android.play.integrity.internal.ao
    final int b() {
        return this.c.c() + this.f1799a + this.b;
    }

    @Override // com.google.android.play.integrity.internal.ao
    final int c() {
        return this.c.c() + this.f1799a;
    }

    @Override // com.google.android.play.integrity.internal.ao
    @CheckForNull
    final Object[] e() {
        return this.c.e();
    }

    @Override // com.google.android.play.integrity.internal.ar
    /* JADX INFO: renamed from: f */
    public final ar subList(int i, int i2) {
        al.c(i, i2, this.b);
        int i3 = this.f1799a;
        return this.c.subList(i + i3, i2 + i3);
    }

    @Override // java.util.List
    public final Object get(int i) {
        al.a(i, this.b, FirebaseAnalytics.Param.INDEX);
        return this.c.get(i + this.f1799a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.b;
    }

    @Override // com.google.android.play.integrity.internal.ar, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }
}
