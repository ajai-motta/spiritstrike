package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzace extends zzabo {
    final zzadl zza;
    final Object zzb;
    final zzadl zzc;
    final zzacd zzd;

    zzace(zzadl zzadlVar, Object obj, zzadl zzadlVar2, zzacd zzacdVar, Class cls) {
        if (zzadlVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (zzacdVar.zzc == zzaex.MESSAGE && zzadlVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.zza = zzadlVar;
        this.zzb = obj;
        this.zzc = zzadlVar2;
        this.zzd = zzacdVar;
    }

    final Object zza(Object obj) {
        if (this.zzd.zzc.zza() != zzaey.ENUM) {
            return obj;
        }
        zzacd zzacdVar = this.zzd;
        return zzacdVar.zza.zza(((Integer) obj).intValue());
    }
}
