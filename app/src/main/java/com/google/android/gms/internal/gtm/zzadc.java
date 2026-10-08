package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadc implements zzadj {
    private final zzadj[] zza;

    zzadc(zzadj... zzadjVarArr) {
        this.zza = zzadjVarArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzadj
    public final zzadi zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzadj zzadjVar = this.zza[i];
            if (zzadjVar.zzc(cls)) {
                return zzadjVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.gms.internal.gtm.zzadj
    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
