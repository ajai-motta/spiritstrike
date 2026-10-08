package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcbf extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcbj zza;

    zzcbf(zzcbj zzcbjVar) {
        Objects.requireNonNull(zzcbjVar);
        this.zza = zzcbjVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcbj zzcbjVar = this.zza;
        zzbex zzbexVar = new zzbex(zzcbjVar.zzy(), zzcbjVar.zzz().afmaVersion);
        synchronized (zzcbjVar.zzx()) {
            try {
                com.google.android.gms.ads.internal.zzt.zzm();
                zzbfa.zza(zzcbjVar.zzA(), zzbexVar);
            } catch (IllegalArgumentException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot config CSI reporter.", e);
            }
        }
    }
}
