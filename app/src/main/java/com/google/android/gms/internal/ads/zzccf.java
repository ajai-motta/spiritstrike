package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzccf implements zzguf {
    final /* synthetic */ zzcch zza;

    zzccf(zzcch zzcchVar) {
        Objects.requireNonNull(zzcchVar);
        this.zza = zzcchVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zza.zzj().set(-1);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        this.zza.zzj().set(1);
    }
}
