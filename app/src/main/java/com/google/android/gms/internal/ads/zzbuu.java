package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbuu extends zzbjo {
    final /* synthetic */ zzbuv zza;

    /* synthetic */ zzbuu(zzbuv zzbuvVar, byte[] bArr) {
        Objects.requireNonNull(zzbuvVar);
        this.zza = zzbuvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjp
    public final void zze(zzbjc zzbjcVar) {
        zzbuv zzbuvVar = this.zza;
        zzbuvVar.zzd().onCustomFormatAdLoaded(zzbuvVar.zzc(zzbjcVar));
    }
}
