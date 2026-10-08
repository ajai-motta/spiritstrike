package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbkh extends zzbjo {
    final /* synthetic */ zzbki zza;

    /* synthetic */ zzbkh(zzbki zzbkiVar, byte[] bArr) {
        Objects.requireNonNull(zzbkiVar);
        this.zza = zzbkiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjp
    public final void zze(zzbjc zzbjcVar) {
        zzbki zzbkiVar = this.zza;
        zzbkiVar.zzc().zzb(zzbkiVar.zze(zzbjcVar));
    }
}
