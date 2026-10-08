package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzenw extends com.google.android.gms.ads.internal.client.zzbp {
    private final zzepe zza;

    public zzenw(Context context, zzcjn zzcjnVar, zzfgm zzfgmVar, zzdma zzdmaVar, com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        zzepg zzepgVar = new zzepg(zzdmaVar, zzcjnVar.zzD());
        zzepgVar.zza(zzbkVar);
        this.zza = new zzepe(new zzepq(zzcjnVar, context, zzepgVar, zzfgmVar), zzfgmVar.zzh());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zze(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        this.zza.zzb(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzf() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized boolean zzg() throws RemoteException {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized String zzh() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, int i) throws RemoteException {
        this.zza.zzb(zzmVar, i);
    }
}
