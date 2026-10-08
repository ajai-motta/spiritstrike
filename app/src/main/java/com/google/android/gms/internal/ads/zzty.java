package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzty implements zzus, zzur {
    public final zzus zza;
    long zzb;
    private zzur zzc;
    private zztx[] zzd = new zztx[0];
    private long zze = 0;

    public zzty(zzus zzusVar, boolean z, long j, long j2) {
        this.zza = zzusVar;
        this.zzb = j2;
    }

    private static long zzq(long j, long j2, long j3) {
        long jMax = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    public final void zza(long j, long j2) {
        this.zzb = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzc = zzurVar;
        this.zza.zzb(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        int length = zzwkVarArr.length;
        this.zzd = new zztx[length];
        zzwk[] zzwkVarArr2 = new zzwk[length];
        int i = 0;
        while (true) {
            zzwk zzwkVar = null;
            if (i >= zzwkVarArr.length) {
                break;
            }
            zztx[] zztxVarArr = this.zzd;
            zztx zztxVar = (zztx) zzwkVarArr[i];
            zztxVarArr[i] = zztxVar;
            if (zztxVar != null) {
                zzwkVar = zztxVar.zza;
            }
            zzwkVarArr2[i] = zzwkVar;
            i++;
        }
        long jZze = this.zza.zze(zzykVarArr, zArr, zzwkVarArr2, zArr2, j);
        long jZzq = zzq(jZze, j, this.zzb);
        boolean zZzo = zzo();
        long j2 = C.TIME_UNSET;
        if (zZzo) {
            if (jZze < j) {
                j2 = jZzq;
                break;
            }
            if (jZze != 0) {
                for (zzyk zzykVar : zzykVarArr) {
                    if (zzykVar != null) {
                        zzv zzvVarZzc = zzykVar.zzc();
                        if (!zzas.zzd(zzvVarZzc.zzo, zzvVarZzc.zzk)) {
                            j2 = jZzq;
                            break;
                        }
                    }
                }
            }
        }
        this.zze = j2;
        for (int i2 = 0; i2 < zzwkVarArr.length; i2++) {
            zzwk zzwkVar2 = zzwkVarArr2[i2];
            if (zzwkVar2 == null) {
                this.zzd[i2] = null;
            } else {
                zztx[] zztxVarArr2 = this.zzd;
                zztx zztxVar2 = zztxVarArr2[i2];
                if (zztxVar2 == null || zztxVar2.zza != zzwkVar2) {
                    zztxVarArr2[i2] = new zztx(this, zzwkVar2);
                }
            }
            zzwkVarArr[i2] = this.zzd[i2];
        }
        return jZzq;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z) {
        this.zza.zzf(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zza.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        if (!zzo()) {
            long jZzh = this.zza.zzh();
            return jZzh == C.TIME_UNSET ? C.TIME_UNSET : zzq(jZzh, 0L, this.zzb);
        }
        long j = this.zze;
        this.zze = C.TIME_UNSET;
        long jZzh2 = zzh();
        return jZzh2 != C.TIME_UNSET ? jZzh2 : j;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzi < j) {
                return jZzi;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        this.zze = C.TIME_UNSET;
        for (zztx zztxVar : this.zzd) {
            if (zztxVar != null) {
                zztxVar.zza();
            }
        }
        return zzq(this.zza.zzj(j), 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        if (j == 0) {
            return 0L;
        }
        long j2 = zzlvVar.zzd;
        String str = zzep.zza;
        long jMax = Math.max(0L, Math.min(j2, j));
        long j3 = zzlvVar.zze;
        long j4 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j3, j4 == Long.MIN_VALUE ? Long.MAX_VALUE : j4 - j));
        if (jMax != j2 || jMax2 != j3) {
            zzlvVar = new zzlv(jMax, jMax2);
        }
        return this.zza.zzk(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzl < j) {
                return jZzl;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        return this.zza.zzm(zzknVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zza.zzn();
    }

    final boolean zzo() {
        return this.zze != C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        zzur zzurVar = this.zzc;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        zzur zzurVar = this.zzc;
        zzurVar.getClass();
        zzurVar.zzp(this);
    }
}
