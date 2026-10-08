package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgqr extends zzgqq {
    final /* synthetic */ zzgqs zza;

    zzgqr(zzgqs zzgqsVar, int i) {
        Objects.requireNonNull(zzgqsVar);
        this.zza = zzgqsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqq
    public final zzgpz zza() {
        return new zzgqu(this.zza.zza(), new zzgqp(2));
    }
}
