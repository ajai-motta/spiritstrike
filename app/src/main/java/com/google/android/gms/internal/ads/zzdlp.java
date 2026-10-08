package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdlp extends com.google.android.gms.ads.internal.client.zzec {
    private final Object zza = new Object();

    @Nullable
    private final com.google.android.gms.ads.internal.client.zzed zzb;

    @Nullable
    private final zzbry zzc;

    public zzdlp(@Nullable com.google.android.gms.ads.internal.client.zzed zzedVar, @Nullable zzbry zzbryVar) {
        this.zzb = zzedVar;
        this.zzc = zzbryVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zze() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzf() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzg(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzh() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final int zzi() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzj() throws RemoteException {
        zzbry zzbryVar = this.zzc;
        if (zzbryVar != null) {
            return zzbryVar.zzA();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzk() throws RemoteException {
        zzbry zzbryVar = this.zzc;
        if (zzbryVar != null) {
            return zzbryVar.zzB();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzl(@Nullable com.google.android.gms.ads.internal.client.zzeg zzegVar) throws RemoteException {
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.client.zzed zzedVar = this.zzb;
            if (zzedVar != null) {
                zzedVar.zzl(zzegVar);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final float zzm() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzn() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzeg zzo() throws RemoteException {
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.client.zzed zzedVar = this.zzb;
            if (zzedVar == null) {
                return null;
            }
            return zzedVar.zzo();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.ads.internal.client.zzed
    public final void zzq() throws RemoteException {
        throw new RemoteException();
    }
}
