package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgra extends zzgpe {
    final /* synthetic */ zzgrb zza;

    zzgra(zzgrb zzgrbVar) {
        Objects.requireNonNull(zzgrbVar);
        this.zza = zzgrbVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzgrb zzgrbVar = this.zza;
        zzgmd.zzm(i, zzgrbVar.zzw(), FirebaseAnalytics.Param.INDEX);
        int i2 = i + i;
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(zzgrbVar.zzv()[i2]), Objects.requireNonNull(zzgrbVar.zzv()[i2 + 1]));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    public final boolean zzf() {
        return true;
    }
}
