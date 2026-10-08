package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzce extends zzbr {
    private final zzau zza;

    zzce(zzbu zzbuVar) {
        super(zzbuVar);
        this.zza = new zzau();
    }

    public final zzau zza() {
        zzV();
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbr
    protected final void zzd() {
        zzq().zzc().zzc(this.zza);
        zzfg zzfgVarZzB = zzB();
        zzfgVarZzB.zzV();
        String str = zzfgVarZzB.zzb;
        if (str != null) {
            this.zza.zzk(str);
        }
        zzfgVarZzB.zzV();
        String str2 = zzfgVarZzB.zza;
        if (str2 != null) {
            this.zza.zzl(str2);
        }
    }
}
