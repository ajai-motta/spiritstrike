package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzelk extends zzbte {
    private final zzehn zza;

    /* synthetic */ zzelk(zzell zzellVar, zzehn zzehnVar, byte[] bArr) {
        Objects.requireNonNull(zzellVar);
        this.zza = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zze() throws RemoteException {
        ((zzeiz) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzf(String str) throws RemoteException {
        ((zzeiz) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzeiz) this.zza.zzc).zzx(zzeVar);
    }
}
