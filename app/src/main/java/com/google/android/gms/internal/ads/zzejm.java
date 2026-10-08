package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzejm extends zzbsy {
    private final zzehn zza;

    /* synthetic */ zzejm(zzejn zzejnVar, zzehn zzehnVar, byte[] bArr) {
        Objects.requireNonNull(zzejnVar);
        this.zza = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zze() throws RemoteException {
        ((zzeiz) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzf(String str) throws RemoteException {
        ((zzeiz) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbsz
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzeiz) this.zza.zzc).zzx(zzeVar);
    }
}
