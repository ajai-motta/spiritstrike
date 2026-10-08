package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgsj {
    public static final /* synthetic */ int zza = 0;

    static {
        Math.log(2.0d);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long zza(double r8, java.math.RoundingMode r10) {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsj.zza(double, java.math.RoundingMode):long");
    }

    public static boolean zzb(double d) {
        if (d > 0.0d && zzgsk.zzb(d)) {
            long jZza = zzgsk.zza(d);
            if ((jZza & ((-1) + jZza)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzc(double r5, java.math.RoundingMode r7) {
        /*
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L10
            boolean r0 = com.google.android.gms.internal.ads.zzgsk.zzb(r5)
            if (r0 == 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            java.lang.String r3 = "x must be positive and finite"
            com.google.android.gms.internal.ads.zzgmd.zzb(r0, r3)
            int r0 = java.lang.Math.getExponent(r5)
            int r3 = java.lang.Math.getExponent(r5)
            r4 = -1022(0xfffffffffffffc02, float:NaN)
            if (r3 < r4) goto L6f
            int[] r3 = com.google.android.gms.internal.ads.zzgsi.zza
            int r7 = r7.ordinal()
            r7 = r3[r7]
            switch(r7) {
                case 1: goto L67;
                case 2: goto L66;
                case 3: goto L5e;
                case 4: goto L54;
                case 5: goto L4c;
                case 6: goto L33;
                case 7: goto L33;
                case 8: goto L33;
                default: goto L2d;
            }
        L2d:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L33:
            long r5 = java.lang.Double.doubleToRawLongBits(r5)
            r3 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r5 = r5 & r3
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            long r5 = r5 | r3
            double r5 = java.lang.Double.longBitsToDouble(r5)
            double r5 = r5 * r5
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 <= 0) goto L66
            goto L65
        L4c:
            if (r0 < 0) goto L4f
            r1 = r2
        L4f:
            boolean r5 = zzb(r5)
            goto L5b
        L54:
            if (r0 >= 0) goto L57
            r1 = r2
        L57:
            boolean r5 = zzb(r5)
        L5b:
            r5 = r5 ^ r2
            r5 = r5 & r1
            goto L63
        L5e:
            boolean r5 = zzb(r5)
            r5 = r5 ^ r2
        L63:
            if (r5 == 0) goto L66
        L65:
            int r0 = r0 + r2
        L66:
            return r0
        L67:
            boolean r5 = zzb(r5)
            com.google.android.gms.internal.ads.zzgsp.zzb(r5)
            return r0
        L6f:
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r5 = r5 * r0
            int r5 = zzc(r5, r7)
            int r5 = r5 + (-52)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgsj.zzc(double, java.math.RoundingMode):int");
    }

    public static boolean zzd(double d) {
        if (zzgsk.zzb(d)) {
            return d == 0.0d || 52 - Long.numberOfTrailingZeros(zzgsk.zza(d)) <= Math.getExponent(d);
        }
        return false;
    }
}
