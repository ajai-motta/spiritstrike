package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcpi implements zzcyr {
    private final zzffx zza;
    private final zzfgf zzb;
    private final zzfnc zzc;
    private final zzfng zzd;

    public zzcpi(zzfgf zzfgfVar, zzfng zzfngVar, zzfnc zzfncVar) {
        this.zzb = zzfgfVar;
        this.zzd = zzfngVar;
        this.zzc = zzfncVar;
        this.zza = zzfgfVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcyr
    public final void zzdN(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zza(this.zzc.zza(this.zzb, null, list), null);
    }
}
