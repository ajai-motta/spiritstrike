package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcrb extends zzbcm {
    private final zzcra zza;
    private final com.google.android.gms.ads.internal.client.zzbx zzb;
    private final zzfbu zzc;
    private boolean zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaY)).booleanValue();
    private final zzdvi zze;

    public zzcrb(zzcra zzcraVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar, zzfbu zzfbuVar, zzdvi zzdviVar) {
        this.zza = zzcraVar;
        this.zzb = zzbxVar;
        this.zzc = zzfbuVar;
        this.zze = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final com.google.android.gms.ads.internal.client.zzbx zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzf(IObjectWrapper iObjectWrapper, zzbcu zzbcuVar) {
        try {
            this.zzc.zzp(zzbcuVar);
            this.zza.zzb((Activity) ObjectWrapper.unwrap(iObjectWrapper), zzbcuVar, this.zzd);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final com.google.android.gms.ads.internal.client.zzea zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhm)).booleanValue()) {
            return this.zza.zzn();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzh(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzi(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        if (this.zzc != null) {
            try {
                if (!zzdtVar.zzf()) {
                    this.zze.zzb();
                }
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Error in making CSI ping for reporting paid event callback", e);
            }
            this.zzc.zzr(zzdtVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final String zzj() {
        try {
            return this.zzb.zzu();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final long zzk() {
        zzcra zzcraVar = this.zza;
        if (zzcraVar == null || zzcraVar.zzo() == null) {
            return 0L;
        }
        return zzcraVar.zzo().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbcn
    public final void zzl(long j) {
        zzcra zzcraVar = this.zza;
        if (zzcraVar == null || zzcraVar.zzo() == null) {
            return;
        }
        zzcraVar.zzo().zzb(j);
    }
}
