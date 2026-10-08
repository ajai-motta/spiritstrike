package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbsn extends zzbro {
    private final Adapter zza;
    private final zzbyg zzb;

    zzbsn(Adapter adapter, zzbyg zzbygVar) {
        this.zza = adapter;
        this.zzb = zzbygVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zze() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzl(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzf() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzg(int i) throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzm(ObjectWrapper.wrap(this.zza), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzh() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzi() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzh(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzj() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzg(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzk() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzl(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzm(zzbjc zzbjcVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzo() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzp(zzbyh zzbyhVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzr(zzbyl zzbylVar) throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzk(ObjectWrapper.wrap(this.zza), new zzbyh(zzbylVar.zze(), zzbylVar.zzf()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzs(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzt() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzu() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzv(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzw(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzx(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzy(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbrp
    public final void zzz() throws RemoteException {
        zzbyg zzbygVar = this.zzb;
        if (zzbygVar != null) {
            zzbygVar.zzp(ObjectWrapper.wrap(this.zza));
        }
    }
}
