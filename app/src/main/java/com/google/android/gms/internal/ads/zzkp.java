package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzkp {
    public final zzus zza;
    public final Object zzb;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzkq zzg;
    public boolean zzh;
    private final zzlp[] zzj;
    private final zzyr zzk;
    private final zzle zzl;
    private zzkp zzm;
    private zzys zzo;
    private long zzp;
    private zzwv zzn = zzwv.zza;
    public final zzwk[] zzc = new zzwk[2];
    private final boolean[] zzi = new boolean[2];

    public zzkp(zzlp[] zzlpVarArr, long j, zzyr zzyrVar, zzyv zzyvVar, zzle zzleVar, zzkq zzkqVar, zzys zzysVar, long j2) {
        this.zzj = zzlpVarArr;
        this.zzp = j;
        this.zzk = zzyrVar;
        this.zzl = zzleVar;
        this.zzb = zzkqVar.zza.zza;
        this.zzg = zzkqVar;
        this.zzo = zzysVar;
        zzuu zzuuVar = zzkqVar.zza;
        long j3 = zzkqVar.zzb;
        long j4 = zzkqVar.zzd;
        zzus zzusVarZze = zzleVar.zze(zzuuVar, zzyvVar, j3);
        this.zza = j4 != C.TIME_UNSET ? new zzty(zzusVarZze, true, 0L, j4) : zzusVarZze;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzys zzysVar = this.zzo;
            if (i >= zzysVar.zza) {
                return;
            }
            zzysVar.zza(i);
            zzyk zzykVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i = 0;
        while (true) {
            zzys zzysVar = this.zzo;
            if (i >= zzysVar.zza) {
                return;
            }
            zzysVar.zza(i);
            zzyk zzykVar = this.zzo.zzc[i];
            i++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza() {
        return this.zzp;
    }

    public final void zzb(long j) {
        this.zzp = j;
    }

    public final long zzc() {
        return this.zzg.zzb + this.zzp;
    }

    public final boolean zzd() {
        if (this.zze) {
            return !this.zzf || this.zza.zzi() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zze() {
        if (this.zze) {
            return zzd() || zzf() - this.zzg.zzb >= C.TIME_UNSET;
        }
        return false;
    }

    public final long zzf() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long jZzi = this.zzf ? this.zza.zzi() : Long.MIN_VALUE;
        return jZzi == Long.MIN_VALUE ? this.zzg.zze : jZzi;
    }

    public final long zzg() {
        if (this.zze) {
            return this.zza.zzl();
        }
        return 0L;
    }

    public final void zzh(float f, zzbf zzbfVar, boolean z) throws zzib {
        this.zze = true;
        this.zzn = this.zza.zzd();
        zzys zzysVarZzk = zzk(f, zzbfVar, z);
        zzkq zzkqVar = this.zzg;
        long jMax = zzkqVar.zzb;
        long j = zzkqVar.zze;
        if (j != C.TIME_UNSET && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZzl = zzl(zzysVarZzk, jMax, false);
        long j2 = this.zzp;
        zzkq zzkqVar2 = this.zzg;
        this.zzp = j2 + (zzkqVar2.zzb - jZzl);
        this.zzg = zzkqVar2.zza(jZzl);
    }

    public final void zzi(long j) {
        zzgmd.zzh(zzw());
        if (this.zze) {
            this.zza.zzg(j - this.zzp);
        }
    }

    public final void zzj(zzkn zzknVar) {
        zzgmd.zzh(zzw());
        this.zza.zzm(zzknVar);
    }

    public final zzys zzk(float f, zzbf zzbfVar, boolean z) throws zzib {
        zzwv zzwvVar = this.zzn;
        zzuu zzuuVar = this.zzg.zza;
        zzyr zzyrVar = this.zzk;
        zzlp[] zzlpVarArr = this.zzj;
        zzys zzysVarZzq = zzyrVar.zzq(zzlpVarArr, zzwvVar, zzuuVar, zzbfVar);
        for (int i = 0; i < zzysVarZzq.zza; i++) {
            if (zzysVarZzq.zza(i)) {
                if (zzysVarZzq.zzc[i] == null) {
                    zzlpVarArr[i].zza();
                    z = false;
                }
                zzgmd.zzh(z);
            } else {
                zzgmd.zzh(zzysVarZzq.zzc[i] == null);
            }
        }
        for (zzyk zzykVar : zzysVarZzq.zzc) {
        }
        return zzysVarZzq;
    }

    public final long zzl(zzys zzysVar, long j, boolean z) {
        return zzm(zzysVar, j, false, new boolean[2]);
    }

    public final long zzm(zzys zzysVar, long j, boolean z, boolean[] zArr) {
        zzlp[] zzlpVarArr;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzysVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z || !zzysVar.zzb(this.zzo, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        int i2 = 0;
        while (true) {
            zzlpVarArr = this.zzj;
            if (i2 >= 2) {
                break;
            }
            zzlpVarArr[i2].zza();
            i2++;
        }
        zzv();
        this.zzo = zzysVar;
        zzu();
        zzus zzusVar = this.zza;
        zzyk[] zzykVarArr = zzysVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzwk[] zzwkVarArr = this.zzc;
        long jZze = zzusVar.zze(zzykVarArr, zArr3, zzwkVarArr, zArr, j);
        for (int i3 = 0; i3 < 2; i3++) {
            zzlpVarArr[i3].zza();
        }
        this.zzf = false;
        for (int i4 = 0; i4 < 2; i4++) {
            if (zzwkVarArr[i4] != null) {
                zzgmd.zzh(zzysVar.zza(i4));
                zzlpVarArr[i4].zza();
                this.zzf = true;
            } else {
                zzgmd.zzh(zzykVarArr[i4] == null);
            }
        }
        return jZze;
    }

    public final void zzn() {
        zzv();
        zzus zzusVar = this.zza;
        try {
            boolean z = zzusVar instanceof zzty;
            zzle zzleVar = this.zzl;
            if (z) {
                zzleVar.zzf(((zzty) zzusVar).zza);
            } else {
                zzleVar.zzf(zzusVar);
            }
        } catch (RuntimeException e) {
            zzdt.zzf("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(zzkp zzkpVar) {
        if (zzkpVar == this.zzm) {
            return;
        }
        zzv();
        this.zzm = zzkpVar;
        zzu();
    }

    public final zzkp zzp() {
        return this.zzm;
    }

    public final zzwv zzq() {
        return this.zzn;
    }

    public final zzys zzr() {
        return this.zzo;
    }

    public final void zzs() {
        zzus zzusVar = this.zza;
        if (zzusVar instanceof zzty) {
            long j = this.zzg.zzd;
            if (j == C.TIME_UNSET) {
                j = Long.MIN_VALUE;
            }
            ((zzty) zzusVar).zza(0L, j);
        }
    }

    public final void zzt(zzur zzurVar, long j) {
        this.zzd = true;
        this.zza.zzb(zzurVar, j);
    }
}
