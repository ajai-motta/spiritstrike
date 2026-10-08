package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfnr extends com.google.android.gms.ads.internal.client.zzbm {
    final /* synthetic */ zzgvb zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx zzb;
    final /* synthetic */ zzfns zzc;

    zzfnr(zzfns zzfnsVar, zzgvb zzgvbVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zza = zzgvbVar;
        this.zzb = zzbxVar;
        Objects.requireNonNull(zzfnsVar);
        this.zzc = zzfnsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb() {
        Objects.requireNonNull(this.zzc);
        zzfnj.zza(this.zzb, this.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        zzfns zzfnsVar = this.zzc;
        String str = zzfnsVar.zze.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 57 + String.valueOf(str).length());
        sb.append("Failed to load interstitial ad with error: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.zzi(sb.toString());
        Objects.requireNonNull(zzfnsVar);
        zzfnsVar.zzv(zzeVar);
    }
}
