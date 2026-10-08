package com.google.android.gms.internal.ads;

import android.util.Range;
import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabb {
    private long zza;
    private long zzb;
    private double zzc;
    private Range zzd;

    public zzabb(float f) {
        Range range = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d));
        this.zzd = range;
        this.zzc = ((Double) range.getUpper()).doubleValue();
        this.zza = C.TIME_UNSET;
        this.zzb = C.TIME_UNSET;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(long r7, long r9) {
        /*
            r6 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r2 == 0) goto Ld
            r2 = r3
            goto Le
        Ld:
            r2 = r4
        Le:
            com.google.android.gms.internal.ads.zzgmd.zza(r2)
            int r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r2 == 0) goto L16
            goto L17
        L16:
            r3 = r4
        L17:
            com.google.android.gms.internal.ads.zzgmd.zza(r3)
            long r2 = r6.zza
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 == 0) goto L32
            long r4 = r6.zzb
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L32
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 == 0) goto L32
            long r0 = r9 - r4
            long r2 = r7 - r2
            double r0 = (double) r0
            double r2 = (double) r2
            double r0 = r0 / r2
            goto L3e
        L32:
            android.util.Range r0 = r6.zzd
            java.lang.Comparable r0 = r0.getUpper()
            java.lang.Double r0 = (java.lang.Double) r0
            double r0 = r0.doubleValue()
        L3e:
            android.util.Range r2 = r6.zzd
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            java.lang.Comparable r0 = r2.clamp(r0)
            java.lang.Double r0 = (java.lang.Double) r0
            double r0 = r0.doubleValue()
            double r2 = r6.zzc
            r4 = 4605380979056443392(0x3fe99999a0000000, double:0.800000011920929)
            double r2 = r2 * r4
            r4 = 4596373779801702400(0x3fc99999a0000000, double:0.20000000298023224)
            double r0 = r0 * r4
            double r2 = r2 + r0
            r6.zzc = r2
            r6.zza = r7
            r6.zzb = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabb.zza(long, long):void");
    }

    public final long zzb(long j) {
        if (this.zza == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return (long) (this.zzb + ((j - r0) * this.zzc));
    }

    public final void zzc(float f) {
        zzgmd.zza(f > 0.0f);
        this.zzd = new Range(Double.valueOf(0.0d), Double.valueOf(1.0d / ((double) f)));
        zzd();
    }

    public final void zzd() {
        this.zzc = ((Double) this.zzd.getUpper()).doubleValue();
        this.zza = C.TIME_UNSET;
        this.zzb = C.TIME_UNSET;
    }
}
