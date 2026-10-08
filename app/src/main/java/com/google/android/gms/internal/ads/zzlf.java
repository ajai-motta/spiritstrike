package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzlf {
    private static final zzuu zzu = new zzuu(new Object(), -1);
    public final zzbf zza;
    public final zzuu zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zzib zzf;
    public final boolean zzg;
    public final zzwv zzh;
    public final zzys zzi;
    public final List zzj;
    public final zzuu zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzav zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzlf(zzbf zzbfVar, zzuu zzuuVar, long j, long j2, int i, zzib zzibVar, boolean z, zzwv zzwvVar, zzys zzysVar, List list, zzuu zzuuVar2, boolean z2, int i2, int i3, zzav zzavVar, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzbfVar;
        this.zzb = zzuuVar;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zzibVar;
        this.zzg = z;
        this.zzh = zzwvVar;
        this.zzi = zzysVar;
        this.zzj = list;
        this.zzk = zzuuVar2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = i3;
        this.zzo = zzavVar;
        this.zzq = j3;
        this.zzr = j4;
        this.zzs = j5;
        this.zzt = j6;
    }

    public static zzlf zza(zzys zzysVar) {
        zzbf zzbfVar = zzbf.zza;
        zzuu zzuuVar = zzu;
        return new zzlf(zzbfVar, zzuuVar, C.TIME_UNSET, 0L, 1, null, false, zzwv.zza, zzysVar, zzgpe.zzi(), zzuuVar, false, 1, 0, zzav.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzuu zzb() {
        return zzu;
    }

    public final zzlf zzc(zzuu zzuuVar, long j, long j2, long j3, long j4, zzwv zzwvVar, zzys zzysVar, List list) {
        zzuu zzuuVar2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        int i2 = this.zzn;
        zzav zzavVar = this.zzo;
        long j5 = this.zzq;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzlf(this.zza, zzuuVar, j2, j3, this.zze, this.zzf, this.zzg, zzwvVar, zzysVar, list, zzuuVar2, z, i, i2, zzavVar, j5, j4, j, jElapsedRealtime, false);
    }

    public final zzlf zzd(zzbf zzbfVar) {
        return new zzlf(zzbfVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlf zze(int i) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, i, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlf zzf(zzib zzibVar) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzibVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlf zzg(boolean z) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, z, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlf zzh(zzuu zzuuVar) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzuuVar, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final zzlf zzi(boolean z, int i, int i2) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, i2, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzj() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
