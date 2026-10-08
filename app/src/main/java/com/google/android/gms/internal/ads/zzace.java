package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzace {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8 A[PHI: r15
  0x00c8: PHI (r15v14 int) = (r15v6 int), (r15v2 int) binds: [B:137:0x01e6, B:42:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzv zza(com.google.android.gms.internal.ads.zzeg r18, java.lang.String r19, java.lang.String r20, com.google.android.gms.internal.ads.zzq r21) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 972
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzace.zza(com.google.android.gms.internal.ads.zzeg, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzq):com.google.android.gms.internal.ads.zzv");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzacd zzb(com.google.android.gms.internal.ads.zzef r12) {
        /*
            r0 = 16
            int r1 = r12.zzj(r0)
            int r0 = r12.zzj(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r12.zzj(r0)
            r2 = 7
            goto L19
        L18:
            r2 = r3
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r8 = r0
            r0 = 2
            int r1 = r12.zzj(r0)
            r2 = 0
            r4 = 3
            if (r1 != r4) goto L3d
            r1 = r2
        L2c:
            int r5 = r12.zzj(r0)
            int r1 = r1 + r5
            boolean r5 = r12.zzi()
            if (r5 != 0) goto L39
            int r1 = r1 + r4
            goto L3d
        L39:
            int r1 = r1 + 1
            int r1 = r1 << r0
            goto L2c
        L3d:
            r5 = r1
            r1 = 10
            int r1 = r12.zzj(r1)
            boolean r6 = r12.zzi()
            if (r6 == 0) goto L53
            int r6 = r12.zzj(r4)
            if (r6 <= 0) goto L53
            r12.zzh(r0)
        L53:
            boolean r6 = r12.zzi()
            r7 = 44100(0xac44, float:6.1797E-41)
            r9 = 48000(0xbb80, float:6.7262E-41)
            r10 = 1
            if (r10 == r6) goto L62
            r11 = r7
            goto L63
        L62:
            r11 = r9
        L63:
            int r12 = r12.zzj(r3)
            if (r11 != r7) goto L73
            r6 = 13
            if (r12 != r6) goto L73
            int[] r12 = com.google.android.gms.internal.ads.zzace.zzb
            r12 = r12[r6]
            r9 = r12
            goto L9f
        L73:
            if (r11 != r9) goto L9e
            r6 = 14
            if (r12 >= r6) goto L9e
            int[] r2 = com.google.android.gms.internal.ads.zzace.zzb
            r2 = r2[r12]
            int r1 = r1 % 5
            r6 = 8
            if (r1 == r10) goto L98
            r7 = 11
            if (r1 == r0) goto L93
            if (r1 == r4) goto L98
            if (r1 == r3) goto L8c
            goto L9e
        L8c:
            if (r12 == r4) goto L9c
            if (r12 == r6) goto L9c
            if (r12 != r7) goto L9e
            goto L9c
        L93:
            if (r12 == r6) goto L9c
            if (r12 != r7) goto L9e
            goto L9c
        L98:
            if (r12 == r4) goto L9c
            if (r12 != r6) goto L9e
        L9c:
            int r2 = r2 + 1
        L9e:
            r9 = r2
        L9f:
            com.google.android.gms.internal.ads.zzacd r12 = new com.google.android.gms.internal.ads.zzacd
            r6 = 2
            r10 = 0
            r4 = r12
            r7 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzace.zzb(com.google.android.gms.internal.ads.zzef):com.google.android.gms.internal.ads.zzacd");
    }

    public static void zzc(int i, zzeg zzegVar) {
        zzegVar.zza(7);
        byte[] bArrZzi = zzegVar.zzi();
        bArrZzi[0] = -84;
        bArrZzi[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrZzi[2] = -1;
        bArrZzi[3] = -1;
        bArrZzi[4] = (byte) ((i >> 16) & 255);
        bArrZzi[5] = (byte) ((i >> 8) & 255);
        bArrZzi[6] = (byte) (i & 255);
    }

    private static void zzd(zzef zzefVar, zzacc zzaccVar) throws zzat {
        int iZzj = zzefVar.zzj(5);
        zzefVar.zzh(2);
        if (zzefVar.zzi()) {
            zzefVar.zzh(5);
        }
        if (iZzj >= 7 && iZzj <= 10) {
            zzefVar.zzg();
        }
        if (zzefVar.zzi()) {
            int iZzj2 = zzefVar.zzj(3);
            if (zzaccVar.zzb == -1 && iZzj >= 0 && iZzj <= 15 && (iZzj2 == 0 || iZzj2 == 1)) {
                zzaccVar.zzb = iZzj;
            }
            if (zzefVar.zzi()) {
                zzf(zzefVar);
            }
        }
    }

    private static void zze(zzef zzefVar, zzacc zzaccVar) throws zzat {
        zzefVar.zzh(2);
        boolean zZzi = zzefVar.zzi();
        int iZzj = zzefVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzefVar.zzh(2);
            if (zzefVar.zzi()) {
                zzefVar.zzh(5);
            }
            if (zZzi) {
                zzefVar.zzh(24);
            } else {
                if (zzefVar.zzi()) {
                    if (!zzefVar.zzi()) {
                        zzefVar.zzh(4);
                    }
                    zzaccVar.zzc = zzefVar.zzj(6) + 1;
                }
                zzefVar.zzh(4);
            }
        }
        if (zzefVar.zzi()) {
            zzefVar.zzh(3);
            if (zzefVar.zzi()) {
                zzf(zzefVar);
            }
        }
    }

    private static void zzf(zzef zzefVar) throws zzat {
        int iZzj = zzefVar.zzj(6);
        if (iZzj < 2 || iZzj > 42) {
            throw zzat.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzj)));
        }
        zzefVar.zzh(iZzj * 8);
    }

    private static boolean zzg(zzef zzefVar) {
        if (zzefVar.zzc() < 66) {
            return false;
        }
        zzefVar.zzh(66);
        return true;
    }
}
