package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbqr implements zzccc {
    final /* synthetic */ zzcca zza;
    final /* synthetic */ zzbpv zzb;

    zzbqr(zzbqt zzbqtVar, zzcca zzccaVar, zzbpv zzbpvVar) {
        this.zza = zzccaVar;
        this.zzb = zzbpvVar;
        Objects.requireNonNull(zzbqtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccc
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbqe("Unable to obtain a JavascriptEngine."));
        this.zzb.zza();
    }
}
