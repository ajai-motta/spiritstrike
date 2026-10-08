package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfno extends zzbcp {
    final /* synthetic */ zzgvb zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzft zzb;
    final /* synthetic */ zzfnp zzc;

    zzfno(zzfnp zzfnpVar, zzgvb zzgvbVar, com.google.android.gms.ads.internal.client.zzft zzftVar) {
        this.zza = zzgvbVar;
        this.zzb = zzftVar;
        Objects.requireNonNull(zzfnpVar);
        this.zzc = zzfnpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final void zzb(zzbcn zzbcnVar) {
        Objects.requireNonNull(this.zzc);
        zzfnj.zza(zzbcnVar, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final void zzc(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbcq
    public final void zzd(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        String str = this.zzb.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 60 + String.valueOf(str).length());
        sb.append("Failed to load app open ad with error parcel: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.zzi(sb.toString());
        zzfnp zzfnpVar = this.zzc;
        Objects.requireNonNull(zzfnpVar);
        zzfnpVar.zzv(zzeVar);
    }
}
