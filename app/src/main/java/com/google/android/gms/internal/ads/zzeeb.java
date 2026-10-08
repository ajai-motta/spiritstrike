package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeeb implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;
    private final zzifq zzd;
    private final zzifq zze;

    private zzeeb(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4, zzifq zzifqVar5, zzifq zzifqVar6, zzifq zzifqVar7, zzifq zzifqVar8) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar4;
        this.zzc = zzifqVar5;
        this.zzd = zzifqVar6;
        this.zze = zzifqVar8;
    }

    public static zzeeb zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4, zzifq zzifqVar5, zzifq zzifqVar6, zzifq zzifqVar7, zzifq zzifqVar8) {
        return new zzeeb(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4, zzifqVar5, zzifqVar6, zzifqVar7, zzifqVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeea(((zzcjv) this.zza).zza(), zzfjn.zzc(), zzcku.zza(), ((zzckh) this.zzb).zzb(), ((zzeej) this.zzc).zzb(), (ArrayDeque) this.zzd.zzb(), zzckr.zza(), (zzflp) this.zze.zzb());
    }
}
