package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzajw {
    private zzaem zzb;
    private zzadd zzc;
    private zzajs zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private long zzk;
    private boolean zzl;
    private boolean zzm;
    private final zzajq zza = new zzajq();
    private zzaju zzj = new zzaju();

    protected void zza(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzaju();
            this.zzf = 0L;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1L;
        this.zzg = 0L;
    }

    protected abstract long zzb(zzeg zzegVar);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected abstract boolean zzc(zzeg zzegVar, long j, zzaju zzajuVar) throws IOException;

    final void zze(zzadd zzaddVar, zzaem zzaemVar) {
        this.zzc = zzaddVar;
        this.zzb = zzaemVar;
        zza(true);
    }

    final void zzf(long j, long j2) {
        this.zza.zza();
        if (j == 0) {
            zza(!this.zzl);
            return;
        }
        if (this.zzh != 0) {
            this.zze = zzi(j2);
            zzajs zzajsVar = this.zzd;
            String str = zzep.zza;
            zzajsVar.zzb(this.zze);
            this.zzh = 2;
        }
    }

    final int zzg(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        this.zzb.getClass();
        String str = zzep.zza;
        int i = this.zzh;
        if (i == 0) {
            while (true) {
                zzajq zzajqVar = this.zza;
                if (!zzajqVar.zzb(zzadbVar)) {
                    this.zzh = 3;
                    return -1;
                }
                long jZzn = zzadbVar.zzn();
                long j = this.zzf;
                this.zzk = jZzn - j;
                if (zzc(zzajqVar.zzd(), j, this.zzj)) {
                    this.zzf = zzadbVar.zzn();
                } else {
                    zzv zzvVar = this.zzj.zza;
                    this.zzi = zzvVar.zzH;
                    if (!this.zzm) {
                        this.zzb.zzu(zzvVar);
                        this.zzm = true;
                    }
                    zzajs zzajsVar = this.zzj.zzb;
                    if (zzajsVar != null) {
                        this.zzd = zzajsVar;
                    } else if (zzadbVar.zzo() == -1) {
                        this.zzd = new zzajv(null);
                    } else {
                        zzajr zzajrVarZzc = zzajqVar.zzc();
                        this.zzd = new zzajl(this, this.zzf, zzadbVar.zzo(), zzajrVarZzc.zzd + zzajrVarZzc.zze, zzajrVarZzc.zzb, (zzajrVarZzc.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    zzajqVar.zze();
                }
            }
        } else {
            if (i == 1) {
                zzadbVar.zzf((int) this.zzf);
                this.zzh = 2;
                return 0;
            }
            if (i != 2) {
                return -1;
            }
            long jZza = this.zzd.zza(zzadbVar);
            if (jZza >= 0) {
                zzaeaVar.zza = jZza;
                return 1;
            }
            if (jZza < -1) {
                zzj(-(jZza + 2));
            }
            if (!this.zzl) {
                zzaed zzaedVarZzc = this.zzd.zzc();
                zzaedVarZzc.getClass();
                this.zzc.zzw(zzaedVarZzc);
                zzaedVarZzc.zza();
                this.zzl = true;
            }
            if (this.zzk <= 0 && !this.zza.zzb(zzadbVar)) {
                this.zzh = 3;
                return -1;
            }
            this.zzk = 0L;
            zzeg zzegVarZzd = this.zza.zzd();
            long jZzb = zzb(zzegVarZzd);
            if (jZzb >= 0) {
                long j2 = this.zzg;
                if (j2 + jZzb >= this.zze) {
                    long jZzh = zzh(j2);
                    this.zzb.zzz(zzegVarZzd, zzegVarZzd.zze());
                    this.zzb.zzx(jZzh, 1, zzegVarZzd.zze(), 0, null);
                    this.zze = -1L;
                }
            }
            this.zzg += jZzb;
        }
        return 0;
    }

    protected final long zzh(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    protected final long zzi(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    protected void zzj(long j) {
        this.zzg = j;
    }
}
