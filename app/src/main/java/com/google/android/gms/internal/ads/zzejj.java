package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzejj implements zzdjl {
    final /* synthetic */ zzehn zza;
    final /* synthetic */ zzffu zzb;
    final /* synthetic */ zzejk zzc;

    zzejj(zzejk zzejkVar, zzehn zzehnVar, zzffu zzffuVar) {
        this.zza = zzehnVar;
        this.zzb = zzffuVar;
        Objects.requireNonNull(zzejkVar);
        this.zzc = zzejkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z, Context context, zzczb zzczbVar) throws zzdjk {
        try {
            zzfhl zzfhlVar = (zzfhl) this.zza.zzb;
            zzfhlVar.zzs(z);
            if (this.zzc.zzc().clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaZ)).intValue()) {
                zzfhlVar.zzd();
            } else {
                zzfhlVar.zze(context);
            }
        } catch (zzfgu e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Cannot show interstitial.");
            throw new zzdjk(e.getCause());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final zzffu zzb() {
        return this.zzb;
    }
}
