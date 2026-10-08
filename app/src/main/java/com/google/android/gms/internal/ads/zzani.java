package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzani implements zzanq {
    private zzv zza;
    private zzem zzb;
    private zzaem zzc;

    public zzani(String str, String str2) {
        zzt zztVar = new zzt();
        zztVar.zzl(MimeTypes.VIDEO_MP2T);
        zztVar.zzm(str);
        this.zza = zztVar.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
        this.zzb = zzemVar;
        zzaoeVar.zza();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 5);
        this.zzc = zzaemVarZzu;
        zzaemVarZzu.zzu(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zzb(zzeg zzegVar) {
        this.zzb.getClass();
        String str = zzep.zza;
        long jZzb = this.zzb.zzb();
        long jZzc = this.zzb.zzc();
        if (jZzb == C.TIME_UNSET || jZzc == C.TIME_UNSET) {
            return;
        }
        zzv zzvVar = this.zza;
        if (jZzc != zzvVar.zzt) {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzr(jZzc);
            zzv zzvVarZzM = zztVarZza.zzM();
            this.zza = zzvVarZzM;
            this.zzc.zzu(zzvVarZzM);
        }
        int iZzd = zzegVar.zzd();
        this.zzc.zzz(zzegVar, iZzd);
        this.zzc.zzx(jZzb, 1, iZzd, 0, null);
    }
}
