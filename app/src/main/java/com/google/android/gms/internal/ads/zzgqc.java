package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgqc extends zzgrr {
    final /* synthetic */ zzgqd zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgqc(zzgqd zzgqdVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzgqdVar);
        this.zza = zzgqdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgrq
    final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
