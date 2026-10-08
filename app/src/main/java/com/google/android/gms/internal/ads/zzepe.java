package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzepe {
    private final zzepj zza;
    private final String zzb;
    private com.google.android.gms.ads.internal.client.zzea zzc;

    public zzepe(zzepj zzepjVar, String str) {
        this.zza = zzepjVar;
        this.zzb = str;
    }

    public final synchronized boolean zza() throws RemoteException {
        return this.zza.zzb();
    }

    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, int i) throws RemoteException {
        this.zzc = null;
        zzepk zzepkVar = new zzepk(i);
        zzepd zzepdVar = new zzepd(this);
        this.zza.zza(zzmVar, this.zzb, zzepkVar, zzepdVar);
    }

    public final synchronized String zzc() {
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        try {
            zzeaVar = this.zzc;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return zzeaVar != null ? zzeaVar.zze() : null;
    }

    public final synchronized String zzd() {
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        try {
            zzeaVar = this.zzc;
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return zzeaVar != null ? zzeaVar.zze() : null;
    }

    final /* synthetic */ void zze(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zzc = zzeaVar;
    }
}
