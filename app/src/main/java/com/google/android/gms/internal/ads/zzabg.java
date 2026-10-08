package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabg {
    private final zzaba zza;
    private final zzabb zzf;
    private long zzk;
    private final zzaaa zzl;
    private final zzaay zzb = new zzaay();
    private final zzel zzc = new zzel(10);
    private final zzel zzd = new zzel(10);
    private final zzdv zze = new zzdv(16);
    private long zzg = C.TIME_UNSET;
    private zzbv zzj = zzbv.zza;
    private long zzh = C.TIME_UNSET;
    private long zzi = C.TIME_UNSET;

    public zzabg(zzaaa zzaaaVar, zzaba zzabaVar, zzabb zzabbVar) {
        this.zzl = zzaaaVar;
        this.zza = zzabaVar;
        this.zzf = zzabbVar;
    }

    private static Object zzh(zzel zzelVar) {
        zzgmd.zza(zzelVar.zzc() > 0);
        while (zzelVar.zzc() > 1) {
            zzelVar.zzd();
        }
        Object objZzd = zzelVar.zzd();
        objZzd.getClass();
        return objZzd;
    }

    public final void zza() {
        this.zze.zze();
        this.zzg = C.TIME_UNSET;
        this.zzh = C.TIME_UNSET;
        this.zzi = C.TIME_UNSET;
        zzel zzelVar = this.zzd;
        if (zzelVar.zzc() > 0) {
            this.zzk = ((Long) zzh(zzelVar)).longValue();
        }
        zzel zzelVar2 = this.zzc;
        if (zzelVar2.zzc() > 0) {
            zzelVar2.zza(0L, (zzbv) zzh(zzelVar2));
        }
    }

    public final void zzb(long j, long j2) throws zzib {
        while (true) {
            zzdv zzdvVar = this.zze;
            if (zzdvVar.zzd()) {
                return;
            }
            zzel zzelVar = this.zzd;
            long jZzc = zzdvVar.zzc();
            Long l = (Long) zzelVar.zze(jZzc);
            if (l != null && l.longValue() != this.zzk) {
                this.zzk = l.longValue();
                this.zza.zza(2);
            }
            zzaba zzabaVar = this.zza;
            long j3 = this.zzk;
            zzaay zzaayVar = this.zzb;
            int iZzk = zzabaVar.zzk(jZzc, j, j2, j3, false, false, zzaayVar);
            if (iZzk != 5 && iZzk != 4) {
                this.zzf.zza(jZzc, zzaayVar.zza());
            }
            if (iZzk == 0 || iZzk == 1) {
                this.zzh = jZzc;
                long jZzb = zzdvVar.zzb();
                zzbv zzbvVar = (zzbv) this.zzc.zze(jZzb);
                if (zzbvVar != null && !zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzj)) {
                    this.zzj = zzbvVar;
                    this.zzl.zza(zzbvVar);
                }
                this.zzl.zzb(iZzk == 0 ? System.nanoTime() : zzaayVar.zzb(), jZzb, zzabaVar.zzf());
            } else if (iZzk == 2 || iZzk == 3) {
                this.zzh = jZzc;
                zzdvVar.zzb();
                final zzaaa zzaaaVar = this.zzl;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzzy
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzaaaVar.zza.zzB().zzc();
                    }
                };
                zzaab zzaabVar = zzaaaVar.zza;
                zzaabVar.zzC().execute(runnable);
                ((zzabv) zzaabVar.zzz().remove()).zzb();
            } else if (iZzk != 4) {
                return;
            } else {
                this.zzh = jZzc;
            }
        }
    }

    public final void zzc(int i, int i2) {
        long j = this.zzg;
        this.zzc.zza(j == C.TIME_UNSET ? 0L : j + 1, new zzbv(i, i2, 1.0f));
    }

    public final void zzd(int i, long j) {
        if (this.zze.zzd()) {
            this.zza.zza(i);
            this.zzk = j;
        } else {
            zzel zzelVar = this.zzd;
            long j2 = this.zzg;
            zzelVar.zza(j2 == C.TIME_UNSET ? -4611686018427387904L : j2 + 1, Long.valueOf(j));
        }
    }

    public final void zze(long j) {
        this.zze.zza(j);
        this.zzg = j;
        this.zzi = C.TIME_UNSET;
    }

    public final void zzf() {
        long j = this.zzg;
        if (j == C.TIME_UNSET) {
            j = Long.MIN_VALUE;
            this.zzg = Long.MIN_VALUE;
            this.zzh = Long.MIN_VALUE;
        }
        this.zzi = j;
    }

    public final boolean zzg() {
        long j = this.zzi;
        return j != C.TIME_UNSET && this.zzh == j;
    }
}
