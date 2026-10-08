package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeiz extends zzbro implements zzczy {
    private zzbrp zza;
    private zzczx zzb;

    @Override // com.google.android.gms.internal.ads.zzczy
    public final synchronized void zza(zzczx zzczxVar) {
        this.zzb = zzczxVar;
    }

    public final synchronized void zzc(zzbrp zzbrpVar) {
        this.zza = zzbrpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zze() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzf() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzg(int i) throws RemoteException {
        zzczx zzczxVar = this.zzb;
        if (zzczxVar != null) {
            zzczxVar.zzb(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzh() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzi() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzj() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzj();
        }
        zzczx zzczxVar = this.zzb;
        if (zzczxVar != null) {
            zzczxVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzk() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzl(String str, String str2) throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzl(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzm(zzbjc zzbjcVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzn() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzo() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzp(zzbyh zzbyhVar) throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzp(zzbyhVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzq() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzr(zzbyl zzbylVar) throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzr(zzbylVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzs(int i) throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzs(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzt() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzu() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzv(String str) throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzv(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzw(int i, String str) throws RemoteException {
        zzczx zzczxVar = this.zzb;
        if (zzczxVar != null) {
            zzczxVar.zzc(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzx(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzczx zzczxVar = this.zzb;
        if (zzczxVar != null) {
            zzczxVar.zzd(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzy(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzy(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final synchronized void zzz() throws RemoteException {
        zzbrp zzbrpVar = this.zza;
        if (zzbrpVar != null) {
            zzbrpVar.zzz();
        }
    }
}
