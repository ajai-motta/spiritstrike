package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.DtsUtil;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacz {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzc = {-1, 8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, OpusUtil.SAMPLE_RATE, -1, -1};
    private static final int[] zzd = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, RendererCapabilities.MODE_SUPPORT_MASK, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};
    private static final int[] zze = {8000, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, OpusUtil.SAMPLE_RATE, 96000, DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND, 384000};
    private static final int[] zzf = {5, 8, 10, 12};
    private static final int[] zzg = {6, 9, 12, 15};
    private static final int[] zzh = {2, 4, 6, 8};
    private static final int[] zzi = {9, 11, 13, 16};
    private static final int[] zzj = {5, 8, 10, 12};

    public static int zza(int i) {
        if (i == 2147385345 || i == -25230976 || i == 536864768 || i == -14745368) {
            return 1;
        }
        if (i == 1683496997 || i == 622876772) {
            return 2;
        }
        if (i == 1078008818 || i == -233094848) {
            return 3;
        }
        return (i == 1908687592 || i == -398277519) ? 4 : 0;
    }

    public static zzv zzb(byte[] bArr, String str, String str2, int i, String str3, zzq zzqVar) {
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(60);
        int i2 = zzb[zzefVarZzi.zzj(6)];
        int i3 = zzc[zzefVarZzi.zzj(4)];
        int iZzj = zzefVarZzi.zzj(5);
        int i4 = iZzj >= 29 ? -1 : (zzd[iZzj] * 1000) / 2;
        zzefVarZzi.zzh(10);
        int i5 = i2 + (zzefVarZzi.zzj(2) > 0 ? 1 : 0);
        zzt zztVar = new zzt();
        zztVar.zza(str);
        zztVar.zzl(MimeTypes.VIDEO_MP2T);
        zztVar.zzm(MimeTypes.AUDIO_DTS);
        zztVar.zzh(i4);
        zztVar.zzE(i5);
        zztVar.zzF(i3);
        zztVar.zzq(null);
        zztVar.zze(str2);
        zztVar.zzg(i);
        return zztVar.zzM();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzc(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L48
            r2 = -1
            if (r1 == r2) goto L30
            r2 = 31
            if (r1 == r2) goto L20
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r7 = r7[r4]
            goto L55
        L20:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r2 = 8
            r7 = r7[r2]
            goto L3f
        L30:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r2 = 9
            r7 = r7[r2]
        L3f:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r0 = r0 | r1
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = r5
            goto L5b
        L48:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r7 = r7[r3]
        L55:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r1 = r1 | r2
            r7 = r7 | r1
            int r7 = r7 + r5
        L5b:
            if (r0 == 0) goto L61
            int r7 = r7 * 16
            int r7 = r7 / 14
        L61:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacz.zzc(byte[]):int");
    }

    public static zzacy zzd(byte[] bArr) throws zzat {
        int iZzj;
        int i;
        int iZzj2;
        long jZzt;
        int i2;
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(40);
        int iZzj3 = zzefVarZzi.zzj(2);
        boolean zZzi = zzefVarZzi.zzi();
        int i3 = true != zZzi ? 16 : 20;
        zzefVarZzi.zzh(true != zZzi ? 8 : 12);
        int iZzj4 = zzefVarZzi.zzj(i3) + 1;
        boolean zZzi2 = zzefVarZzi.zzi();
        int i4 = 0;
        if (zZzi2) {
            iZzj = zzefVarZzi.zzj(2);
            int iZzj5 = zzefVarZzi.zzj(3) + 1;
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(36);
            }
            int iZzj6 = zzefVarZzi.zzj(3) + 1;
            int iZzj7 = zzefVarZzi.zzj(3) + 1;
            if (iZzj6 != 1 || iZzj7 != 1) {
                throw zzat.zzc("Multiple audio presentations or assets not supported");
            }
            int i5 = iZzj3 + 1;
            int iZzj8 = zzefVarZzi.zzj(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                if (((iZzj8 >> i6) & 1) == 1) {
                    zzefVarZzi.zzh(8);
                }
            }
            int i7 = iZzj5 * 512;
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(2);
                int iZzj9 = (zzefVarZzi.zzj(2) + 1) << 2;
                int iZzj10 = zzefVarZzi.zzj(2) + 1;
                while (i4 < iZzj10) {
                    zzefVarZzi.zzh(iZzj9);
                    i4++;
                }
            }
            i4 = i7;
        } else {
            iZzj = -1;
        }
        zzefVarZzi.zzh(i3);
        zzefVarZzi.zzh(12);
        if (zZzi2) {
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(4);
            }
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(24);
            }
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzo(zzefVarZzi.zzj(10) + 1);
            }
            zzefVarZzi.zzh(5);
            int i8 = zze[zzefVarZzi.zzj(4)];
            iZzj2 = zzefVarZzi.zzj(8) + 1;
            i = i8;
        } else {
            i = -2147483647;
            iZzj2 = -1;
        }
        if (zZzi2) {
            if (iZzj == 0) {
                i2 = 32000;
            } else if (iZzj == 1) {
                i2 = 44100;
            } else {
                if (iZzj != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj).length() + 51);
                    sb.append("Unsupported reference clock code in DTS HD header: ");
                    sb.append(iZzj);
                    throw zzat.zzb(sb.toString(), null);
                }
                i2 = OpusUtil.SAMPLE_RATE;
            }
            jZzt = zzep.zzt(i4, 1000000L, i2, RoundingMode.DOWN);
        } else {
            jZzt = C.TIME_UNSET;
        }
        return new zzacy(MimeTypes.AUDIO_DTS_EXPRESS, iZzj2, i, iZzj4, jZzt, 0, null);
    }

    public static int zze(byte[] bArr) {
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(42);
        return zzefVarZzi.zzj(true != zzefVarZzi.zzi() ? 8 : 12) + 1;
    }

    public static zzacy zzf(byte[] bArr, AtomicInteger atomicInteger) throws zzat {
        long jZzt;
        int iZzj;
        int i;
        int i2;
        zzef zzefVarZzi = zzi(bArr);
        int iZzj2 = zzefVarZzi.zzj(32);
        int iZzh = zzh(zzefVarZzi, zzf, true);
        int i3 = iZzh + 1;
        char c = iZzj2 == 1078008818 ? (char) 1 : (char) 0;
        if (c == 0) {
            jZzt = C.TIME_UNSET;
            iZzj = C.RATE_UNSET_INT;
        } else {
            if (!zzefVarZzi.zzi()) {
                throw zzat.zzc("Only supports full channel mask-based audio presentation");
            }
            int i4 = iZzh - 1;
            if (((bArr[iZzh] & 255) | ((char) (bArr[i4] << 8))) != zzep.zzI(bArr, 0, i4, 65535)) {
                throw zzat.zzb("CRC check failed", null);
            }
            int iZzj3 = zzefVarZzi.zzj(2);
            if (iZzj3 == 0) {
                i = 512;
            } else if (iZzj3 == 1) {
                i = 480;
            } else {
                if (iZzj3 != 2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 51);
                    sb.append("Unsupported base duration index in DTS UHD header: ");
                    sb.append(iZzj3);
                    throw zzat.zzb(sb.toString(), null);
                }
                i = RendererCapabilities.MODE_SUPPORT_MASK;
            }
            int iZzj4 = zzefVarZzi.zzj(3) + 1;
            int iZzj5 = zzefVarZzi.zzj(2);
            if (iZzj5 == 0) {
                i2 = 32000;
            } else if (iZzj5 == 1) {
                i2 = 44100;
            } else {
                if (iZzj5 != 2) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzj5).length() + 48);
                    sb2.append("Unsupported clock rate index in DTS UHD header: ");
                    sb2.append(iZzj5);
                    throw zzat.zzb(sb2.toString(), null);
                }
                i2 = OpusUtil.SAMPLE_RATE;
            }
            if (zzefVarZzi.zzi()) {
                zzefVarZzi.zzh(36);
            }
            iZzj = (1 << zzefVarZzi.zzj(2)) * i2;
            jZzt = zzep.zzt(i * iZzj4, 1000000L, i2, RoundingMode.DOWN);
        }
        int i5 = iZzj;
        long j = jZzt;
        int iZzh2 = 0;
        for (char c2 = 0; c2 < c; c2 = 1) {
            iZzh2 += zzh(zzefVarZzi, zzg, true);
        }
        for (int i6 = 0; i6 <= 0; i6++) {
            if (c != 0) {
                atomicInteger.set(zzh(zzefVarZzi, zzh, true));
            }
            iZzh2 += atomicInteger.get() != 0 ? zzh(zzefVarZzi, zzi, true) : 0;
        }
        return new zzacy(MimeTypes.AUDIO_DTS_X, 2, i5, i3 + iZzh2, j, 0, null);
    }

    public static int zzg(byte[] bArr) {
        zzef zzefVarZzi = zzi(bArr);
        zzefVarZzi.zzh(32);
        return zzh(zzefVarZzi, zzj, true) + 1;
    }

    private static int zzh(zzef zzefVar, int[] iArr, boolean z) {
        int i = 0;
        for (int i2 = 0; i2 < 3 && zzefVar.zzi(); i2++) {
            i++;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 += 1 << iArr[i4];
        }
        return i3 + zzefVar.zzj(iArr[i]);
    }

    private static zzef zzi(byte[] bArr) {
        byte b = bArr[0];
        if (b == 127 || b == 100 || b == 64 || b == 113) {
            return new zzef(bArr, bArr.length);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        byte b2 = bArrCopyOf[0];
        if (b2 == -2 || b2 == -1 || b2 == 37 || b2 == -14 || b2 == -24) {
            for (int i = 0; i < bArrCopyOf.length - 1; i += 2) {
                byte b3 = bArrCopyOf[i];
                int i2 = i + 1;
                bArrCopyOf[i] = bArrCopyOf[i2];
                bArrCopyOf[i2] = b3;
            }
        }
        int length = bArrCopyOf.length;
        zzef zzefVar = new zzef(bArrCopyOf, length);
        if (bArrCopyOf[0] == 31) {
            zzef zzefVar2 = new zzef(bArrCopyOf, length);
            while (zzefVar2.zzc() >= 16) {
                zzefVar2.zzh(2);
                zzefVar.zzp(zzefVar2.zzj(14), 14);
            }
        }
        zzefVar.zzb(bArrCopyOf, bArrCopyOf.length);
        return zzefVar;
    }
}
