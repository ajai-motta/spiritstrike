package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzem {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzem(long j) {
        zzd(0L);
    }

    public static long zzi(long j) {
        return zzep.zzt(j, 1000000L, 90000L, RoundingMode.DOWN);
    }

    public static long zzj(long j) {
        return zzep.zzt(j, 90000L, 1000000L, RoundingMode.DOWN);
    }

    public final synchronized long zza() {
        long j = this.zza;
        return (j == Long.MAX_VALUE || j == TimestampAdjuster.MODE_SHARED) ? C.TIME_UNSET : j;
    }

    public final synchronized long zzb() {
        long j;
        j = this.zzc;
        return j != C.TIME_UNSET ? j + this.zzb : zza();
    }

    public final synchronized long zzc() {
        return this.zzb;
    }

    public final synchronized void zzd(long j) {
        this.zza = j;
        this.zzb = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.zzc = C.TIME_UNSET;
    }

    public final synchronized long zze(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            long jZzj = zzj(j2);
            long j3 = (4294967296L + jZzj) / 8589934592L;
            long j4 = (((-1) + j3) * 8589934592L) + j;
            j += j3 * 8589934592L;
            if (Math.abs(j4 - jZzj) < Math.abs(j - jZzj)) {
                j = j4;
            }
        }
        return zzg(zzi(j));
    }

    public final synchronized long zzf(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            long jZzj = zzj(j2);
            long j3 = jZzj / 8589934592L;
            Long.signum(j3);
            long j4 = (j3 * 8589934592L) + j;
            j += (j3 + 1) * 8589934592L;
            if (j4 >= jZzj) {
                j = j4;
            }
        }
        return zzg(zzi(j));
    }

    public final synchronized long zzg(long j) {
        if (j == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (!zzh()) {
            long jLongValue = this.zza;
            if (jLongValue == TimestampAdjuster.MODE_SHARED) {
                Long l = (Long) this.zzd.get();
                l.getClass();
                jLongValue = l.longValue();
            }
            this.zzb = jLongValue - j;
            notifyAll();
        }
        this.zzc = j;
        return j + this.zzb;
    }

    public final synchronized boolean zzh() {
        return this.zzb != C.TIME_UNSET;
    }
}
