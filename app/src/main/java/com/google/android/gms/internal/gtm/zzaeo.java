package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaeo extends zzaem {
    zzaeo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* bridge */ /* synthetic */ Object zza(Object obj) {
        zzacf zzacfVar = (zzacf) obj;
        zzaen zzaenVar = zzacfVar.zzc;
        if (zzaenVar != zzaen.zzc()) {
            return zzaenVar;
        }
        zzaen zzaenVarZzf = zzaen.zzf();
        zzacfVar.zzc = zzaenVarZzf;
        return zzaenVarZzf;
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* synthetic */ Object zzb() {
        return zzaen.zzf();
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* synthetic */ Object zzc(Object obj) {
        zzaen zzaenVar = (zzaen) obj;
        zzaenVar.zzh();
        return zzaenVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* bridge */ /* synthetic */ void zzd(Object obj, int i, int i2) {
        ((zzaen) obj).zzj((i << 3) | 5, Integer.valueOf(i2));
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* bridge */ /* synthetic */ void zze(Object obj, int i, long j) {
        ((zzaen) obj).zzj((i << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* bridge */ /* synthetic */ void zzf(Object obj, int i, Object obj2) {
        ((zzaen) obj).zzj((i << 3) | 3, (zzaen) obj2);
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* bridge */ /* synthetic */ void zzg(Object obj, int i, zzyx zzyxVar) {
        ((zzaen) obj).zzj((i << 3) | 2, zzyxVar);
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* bridge */ /* synthetic */ void zzh(Object obj, int i, long j) {
        ((zzaen) obj).zzj(i << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final void zzi(Object obj) {
        ((zzacf) obj).zzc.zzh();
    }

    @Override // com.google.android.gms.internal.gtm.zzaem
    final /* synthetic */ void zzj(Object obj, Object obj2) {
        ((zzacf) obj).zzc = (zzaen) obj2;
    }
}
