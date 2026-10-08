package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzacd implements zzabu {
    final zzaci zza;
    final int zzb;
    final zzaex zzc;
    final boolean zzd;

    zzacd(zzaci zzaciVar, int i, zzaex zzaexVar, boolean z, boolean z2) {
        this.zza = zzaciVar;
        this.zzb = i;
        this.zzc = zzaexVar;
        this.zzd = z;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzb - ((zzacd) obj).zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final zzadk zzb(zzadk zzadkVar, zzadl zzadlVar) {
        zzaca zzacaVar = (zzaca) zzadkVar;
        zzacaVar.zzA((zzacf) zzadlVar);
        return zzacaVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final zzadq zzc(zzadq zzadqVar, zzadq zzadqVar2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final zzaex zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final zzaey zze() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzabu
    public final boolean zzg() {
        return this.zzd;
    }
}
