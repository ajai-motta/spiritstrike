package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcso implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcso(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        this.zza = zzifqVar2;
        this.zzb = zzifqVar3;
    }

    public static zzcso zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        return new zzcso(zzifqVar, zzifqVar2, zzifqVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        boolean zBooleanValue = Boolean.valueOf(zzcsm.zza()).booleanValue();
        zzehk zzehkVarZzb = ((zzeko) this.zza).zzb();
        zzemm zzemmVarZzb = ((zzemn) this.zzb).zzb();
        if (true != zBooleanValue) {
            zzehkVarZzb = zzemmVarZzb;
        }
        return zzehkVarZzb;
    }
}
