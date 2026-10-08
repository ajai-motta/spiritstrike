package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhdj {
    private static final zzhde zzb = new zzhde(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final zzhdg zzc = new zzhdg(new zzhdh(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] zza = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};

    public static byte[] zza(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 + i2;
            bArr2[i3] = (byte) (bArr[i2] & Ascii.SI);
            bArr2[i3 + 1] = (byte) ((bArr[i2] & 255) >> 4);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr2[i4] + i5);
            bArr2[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr2[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr2[63] = (byte) (bArr2[63] + i5);
        zzhdg zzhdgVar = new zzhdg(zzc);
        zzhdi zzhdiVar = new zzhdi();
        for (i = 1; i < 64; i += 2) {
            zzhde zzhdeVar = new zzhde(zzb);
            zzk(zzhdeVar, i / 2, bArr2[i]);
            zzhdi.zza(zzhdiVar, zzhdgVar);
            zzg(zzhdgVar, zzhdiVar, zzhdeVar);
        }
        zzhdh zzhdhVar = new zzhdh();
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        zzhdh.zza(zzhdhVar, zzhdgVar);
        zzi(zzhdgVar, zzhdhVar);
        for (int i7 = 0; i7 < 64; i7 += 2) {
            zzhde zzhdeVar2 = new zzhde(zzb);
            zzk(zzhdeVar2, i7 / 2, bArr2[i7]);
            zzhdi.zza(zzhdiVar, zzhdgVar);
            zzg(zzhdgVar, zzhdiVar, zzhdeVar2);
        }
        zzhdh zzhdhVar2 = new zzhdh(zzhdgVar);
        long[] jArr = new long[10];
        zzhdq.zzf(jArr, zzhdhVar2.zza);
        long[] jArr2 = new long[10];
        zzhdq.zzf(jArr2, zzhdhVar2.zzb);
        long[] jArr3 = new long[10];
        zzhdq.zzf(jArr3, zzhdhVar2.zzc);
        long[] jArr4 = new long[10];
        zzhdq.zzf(jArr4, jArr3);
        long[] jArr5 = new long[10];
        zzhdq.zzb(jArr5, jArr2, jArr);
        zzhdq.zze(jArr5, jArr5, jArr3);
        long[] jArr6 = new long[10];
        zzhdq.zze(jArr6, jArr, jArr2);
        zzhdq.zze(jArr6, jArr6, zzhdl.zza);
        zzhdq.zza(jArr6, jArr6, jArr4);
        zzhdq.zzc(jArr6, jArr6);
        if (MessageDigest.isEqual(zzhdq.zzh(jArr5), zzhdq.zzh(jArr6))) {
            return zzhdhVar2.zzb();
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        MessageDigest messageDigest = (MessageDigest) zzhrz.zzd.zzb("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        int i = bArrDigest[31] & 127;
        bArrDigest[31] = (byte) i;
        bArrDigest[31] = (byte) (i | 64);
        return bArrDigest;
    }

    public static boolean zzc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        char c;
        byte b;
        int i;
        byte b2;
        byte[] bArr4 = bArr2;
        if (bArr4.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, 32, 64);
        int i2 = 31;
        while (true) {
            if (i2 < 0) {
                break;
            }
            int i3 = bArrCopyOfRange[i2] & 255;
            int i4 = zza[i2] & 255;
            if (i3 == i4) {
                i2--;
                bArrCopyOfRange = bArrCopyOfRange;
                bArr4 = bArr2;
            } else if (i3 < i4) {
                MessageDigest messageDigest = (MessageDigest) zzhrz.zzd.zzb("SHA-512");
                messageDigest.update(bArr4, 0, 32);
                messageDigest.update(bArr3);
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                long jZzn = zzn(bArrDigest, 0) & 2097151;
                long jZzo = zzo(bArrDigest, 2) >> 5;
                long jZzn2 = zzn(bArrDigest, 5) >> 2;
                long jZzo2 = zzo(bArrDigest, 7) >> 7;
                long jZzo3 = zzo(bArrDigest, 10) >> 4;
                long jZzn3 = zzn(bArrDigest, 13) >> 1;
                long jZzo4 = zzo(bArrDigest, 15) >> 6;
                long jZzn4 = zzn(bArrDigest, 18) >> 3;
                long jZzn5 = zzn(bArrDigest, 21) & 2097151;
                long jZzo5 = zzo(bArrDigest, 23) >> 5;
                long jZzn6 = zzn(bArrDigest, 26) >> 2;
                long jZzo6 = zzo(bArrDigest, 28) >> 7;
                long jZzo7 = zzo(bArrDigest, 31) >> 4;
                long jZzn7 = zzn(bArrDigest, 34) >> 1;
                long jZzo8 = zzo(bArrDigest, 36) >> 6;
                long jZzn8 = zzn(bArrDigest, 39) >> 3;
                long jZzn9 = zzn(bArrDigest, 42) & 2097151;
                long jZzo9 = zzo(bArrDigest, 44) >> 5;
                long jZzn10 = (zzn(bArrDigest, 47) >> 2) & 2097151;
                long jZzo10 = (zzo(bArrDigest, 49) >> 7) & 2097151;
                long jZzo11 = (zzo(bArrDigest, 52) >> 4) & 2097151;
                long jZzn11 = (zzn(bArrDigest, 55) >> 1) & 2097151;
                long jZzo12 = (zzo(bArrDigest, 57) >> 6) & 2097151;
                long jZzo13 = zzo(bArrDigest, 60) >> 3;
                long j = (jZzo4 & 2097151) + (jZzn10 * 666643);
                long j2 = (j + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j3 = j2 << 21;
                long j4 = jZzn5 + (jZzo11 * 666643) + (jZzo10 * 470296) + (jZzn10 * 654183);
                long j5 = (j4 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j6 = j5 << 21;
                long j7 = (((((jZzn6 & 2097151) + (jZzo12 * 666643)) + (jZzn11 * 470296)) + (jZzo11 * 654183)) - (jZzo10 * 997805)) + (jZzn10 * 136657);
                long j8 = (j7 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j9 = j8 << 21;
                long j10 = (((((jZzo7 & 2097151) + (jZzo13 * 470296)) + (jZzo12 * 654183)) - (jZzn11 * 997805)) + (jZzo11 * 136657)) - (jZzo10 * 683901);
                long j11 = (j10 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j12 = (((jZzo8 & 2097151) - (jZzo13 * 997805)) + (jZzo12 * 136657)) - (jZzn11 * 683901);
                long j13 = (j12 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j14 = jZzn9 - (jZzo13 * 683901);
                long j15 = (j14 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j16 = jZzn4 + (jZzo10 * 666643) + (jZzn10 * 470296) + j2;
                long j17 = (j16 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j18 = j17 << 21;
                long j19 = (((((jZzo5 & 2097151) + (jZzn11 * 666643)) + (jZzo11 * 470296)) + (jZzo10 * 654183)) - (jZzn10 * 997805)) + j5;
                long j20 = (j19 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j21 = j20 << 21;
                long j22 = (((((((jZzo6 & 2097151) + (jZzo13 * 666643)) + (jZzo12 * 470296)) + (jZzn11 * 654183)) - (jZzo11 * 997805)) + (jZzo10 * 136657)) - (jZzn10 * 683901)) + j8;
                long j23 = (j22 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j24 = j23 << 21;
                long j25 = (((((jZzn7 & 2097151) + (jZzo13 * 654183)) - (jZzo12 * 997805)) + (jZzn11 * 136657)) - (jZzo11 * 683901)) + j11;
                long j26 = (j25 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j27 = ((jZzn8 + (jZzo13 * 136657)) - (jZzo12 * 683901)) + j13;
                long j28 = (j27 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j29 = (j10 - (j11 << 21)) + j23;
                long j30 = jZzn + (j29 * 666643);
                long j31 = (j30 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j32 = j31 << 21;
                long j33 = (j12 - (j13 << 21)) + j26;
                long j34 = j25 - (j26 << 21);
                long j35 = (jZzn2 & 2097151) + (j33 * 666643) + (j34 * 470296) + (j29 * 654183);
                long j36 = (j35 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j37 = j36 << 21;
                long j38 = (j14 - (j15 << 21)) + j28;
                long j39 = j27 - (j28 << 21);
                long j40 = (((((jZzo3 & 2097151) + (j38 * 666643)) + (j39 * 470296)) + (j33 * 654183)) - (j34 * 997805)) + (j29 * 136657);
                long j41 = (j40 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j42 = j41 << 21;
                long j43 = (jZzo9 & 2097151) + j15;
                long j44 = (((((j - j3) + (j43 * 470296)) + (j38 * 654183)) - (j39 * 997805)) + (j33 * 136657)) - (j34 * 683901);
                long j45 = (j44 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j46 = j45 << 21;
                long j47 = ((((j4 - j6) + j17) - (j43 * 997805)) + (j38 * 136657)) - (j39 * 683901);
                long j48 = (j47 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j49 = j48 << 21;
                long j50 = ((j7 - j9) + j20) - (j43 * 683901);
                long j51 = (j50 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j52 = (jZzo & 2097151) + (j34 * 666643) + (j29 * 470296) + j31;
                long j53 = (j52 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j54 = (((((jZzo2 & 2097151) + (j39 * 666643)) + (j33 * 470296)) + (j34 * 654183)) - (j29 * 997805)) + j36;
                long j55 = (j54 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j56 = (((((((jZzn3 & 2097151) + (j43 * 666643)) + (j38 * 470296)) + (j39 * 654183)) - (j33 * 997805)) + (j34 * 136657)) - (j29 * 683901)) + j41;
                long j57 = (j56 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j58 = (((((j16 - j18) + (j43 * 654183)) - (j38 * 997805)) + (j39 * 136657)) - (j33 * 683901)) + j45;
                long j59 = (j58 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j60 = (((j19 - j21) + (j43 * 136657)) - (j38 * 683901)) + j48;
                long j61 = (j60 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j62 = (j22 - j24) + j51;
                long j63 = (j62 + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) >> 21;
                long j64 = j63 << 21;
                long j65 = (j30 - j32) + (j63 * 666643);
                long j66 = j65 >> 21;
                long j67 = j66 << 21;
                long j68 = (j52 - (j53 << 21)) + (j63 * 470296) + j66;
                long j69 = j68 >> 21;
                long j70 = j69 << 21;
                long j71 = (j35 - j37) + j53 + (j63 * 654183) + j69;
                long j72 = j71 >> 21;
                long j73 = j72 << 21;
                long j74 = ((j54 - (j55 << 21)) - (j63 * 997805)) + j72;
                long j75 = j74 >> 21;
                long j76 = j75 << 21;
                long j77 = (j40 - j42) + j55 + (j63 * 136657) + j75;
                long j78 = j77 >> 21;
                long j79 = j78 << 21;
                long j80 = ((j56 - (j57 << 21)) - (j63 * 683901)) + j78;
                long j81 = j80 >> 21;
                long j82 = j81 << 21;
                long j83 = (j44 - j46) + j57 + j81;
                long j84 = j83 >> 21;
                long j85 = j84 << 21;
                long j86 = (j58 - (j59 << 21)) + j84;
                long j87 = j86 >> 21;
                long j88 = j87 << 21;
                long j89 = (j47 - j49) + j59 + j87;
                long j90 = j89 >> 21;
                long j91 = j90 << 21;
                long j92 = (j60 - (j61 << 21)) + j90;
                long j93 = j92 >> 21;
                long j94 = j93 << 21;
                long j95 = (j50 - (j51 << 21)) + j61 + j93;
                long j96 = j95 >> 21;
                long j97 = j96 << 21;
                long j98 = (j62 - j64) + j96;
                long j99 = j98 >> 21;
                long j100 = j99 << 21;
                long j101 = (j65 - j67) + (666643 * j99);
                long j102 = j101 >> 21;
                long j103 = j102 << 21;
                long j104 = (j68 - j70) + (470296 * j99) + j102;
                long j105 = j104 >> 21;
                long j106 = j105 << 21;
                long j107 = (j71 - j73) + (654183 * j99) + j105;
                long j108 = j107 >> 21;
                long j109 = j108 << 21;
                long j110 = ((j74 - j76) - (997805 * j99)) + j108;
                long j111 = j110 >> 21;
                long j112 = j111 << 21;
                long j113 = (j77 - j79) + (136657 * j99) + j111;
                long j114 = j113 >> 21;
                long j115 = ((j80 - j82) - (j99 * 683901)) + j114;
                long j116 = j115 >> 21;
                long j117 = j116 << 21;
                long j118 = (j83 - j85) + j116;
                long j119 = j118 >> 21;
                long j120 = j119 << 21;
                long j121 = (j86 - j88) + j119;
                long j122 = j121 >> 21;
                long j123 = j122 << 21;
                long j124 = (j89 - j91) + j122;
                long j125 = j124 >> 21;
                long j126 = j125 << 21;
                long j127 = (j92 - j94) + j125;
                long j128 = j127 >> 21;
                long j129 = j128 << 21;
                long j130 = (j95 - j97) + j128;
                long j131 = j130 >> 21;
                bArrDigest[0] = (byte) (j101 - j103);
                long j132 = j121 - j123;
                long j133 = j118 - j120;
                long j134 = j115 - j117;
                long j135 = j113 - (j114 << 21);
                long j136 = j110 - j112;
                long j137 = j107 - j109;
                long j138 = j104 - j106;
                bArrDigest[1] = (byte) (r8 >> 8);
                bArrDigest[2] = (byte) ((r8 >> 16) | (j138 << 5));
                bArrDigest[3] = (byte) (j138 >> 3);
                bArrDigest[4] = (byte) (j138 >> 11);
                bArrDigest[5] = (byte) ((j138 >> 19) | (j137 << 2));
                bArrDigest[6] = (byte) (j137 >> 6);
                bArrDigest[7] = (byte) ((j137 >> 14) | (j136 << 7));
                bArrDigest[8] = (byte) (j136 >> 1);
                bArrDigest[9] = (byte) (j136 >> 9);
                bArrDigest[10] = (byte) ((j136 >> 17) | (j135 << 4));
                bArrDigest[11] = (byte) (j135 >> 4);
                bArrDigest[12] = (byte) (j135 >> 12);
                bArrDigest[13] = (byte) ((j135 >> 20) | (j134 + j134));
                bArrDigest[14] = (byte) (j134 >> 7);
                bArrDigest[15] = (byte) ((j134 >> 15) | (j133 << 6));
                bArrDigest[16] = (byte) (j133 >> 2);
                bArrDigest[17] = (byte) (j133 >> 10);
                bArrDigest[18] = (byte) ((j133 >> 18) | (j132 << 3));
                long j139 = j130 - (j131 << 21);
                long j140 = (j98 - j100) + j131;
                long j141 = j127 - j129;
                bArrDigest[19] = (byte) (j132 >> 5);
                bArrDigest[20] = (byte) (j132 >> 13);
                bArrDigest[21] = (byte) (j124 - j126);
                bArrDigest[22] = (byte) (r6 >> 8);
                bArrDigest[23] = (byte) ((r6 >> 16) | (j141 << 5));
                bArrDigest[24] = (byte) (j141 >> 3);
                bArrDigest[25] = (byte) (j141 >> 11);
                bArrDigest[26] = (byte) ((j141 >> 19) | (j139 << 2));
                bArrDigest[27] = (byte) (j139 >> 6);
                bArrDigest[28] = (byte) ((j139 >> 14) | (j140 << 7));
                bArrDigest[29] = (byte) (j140 >> 1);
                bArrDigest[30] = (byte) (j140 >> 9);
                bArrDigest[31] = (byte) (j140 >> 17);
                long[] jArr = new long[10];
                long[] jArrZzg = zzhdq.zzg(bArr3);
                long[] jArr2 = new long[10];
                jArr2[0] = 1;
                long[] jArr3 = new long[10];
                long[] jArr4 = new long[10];
                long[] jArr5 = new long[10];
                long[] jArr6 = new long[10];
                long[] jArr7 = new long[10];
                zzhdq.zzf(jArr4, jArrZzg);
                zzhdq.zze(jArr5, jArr4, zzhdl.zza);
                zzhdq.zzb(jArr4, jArr4, jArr2);
                zzhdq.zza(jArr5, jArr5, jArr2);
                long[] jArr8 = new long[10];
                zzhdq.zzf(jArr8, jArr5);
                zzhdq.zze(jArr8, jArr8, jArr5);
                zzhdq.zzf(jArr, jArr8);
                zzhdq.zze(jArr, jArr, jArr5);
                zzhdq.zze(jArr, jArr, jArr4);
                long[] jArr9 = new long[10];
                long[] jArr10 = new long[10];
                long[] jArr11 = new long[10];
                zzhdq.zzf(jArr9, jArr);
                zzhdq.zzf(jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr10);
                zzhdq.zze(jArr10, jArr, jArr10);
                zzhdq.zze(jArr9, jArr9, jArr10);
                zzhdq.zzf(jArr9, jArr9);
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr9);
                byte[] bArr5 = bArrCopyOfRange;
                for (int i5 = 1; i5 < 5; i5++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr9);
                for (int i6 = 1; i6 < 10; i6++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr10, jArr10, jArr9);
                zzhdq.zzf(jArr11, jArr10);
                for (int i7 = 1; i7 < 20; i7++) {
                    zzhdq.zzf(jArr11, jArr11);
                }
                zzhdq.zze(jArr10, jArr11, jArr10);
                zzhdq.zzf(jArr10, jArr10);
                for (int i8 = 1; i8 < 10; i8++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr10, jArr9);
                for (int i9 = 1; i9 < 50; i9++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr10, jArr10, jArr9);
                zzhdq.zzf(jArr11, jArr10);
                for (int i10 = 1; i10 < 100; i10++) {
                    zzhdq.zzf(jArr11, jArr11);
                }
                zzhdq.zze(jArr10, jArr11, jArr10);
                zzhdq.zzf(jArr10, jArr10);
                for (int i11 = 1; i11 < 50; i11++) {
                    zzhdq.zzf(jArr10, jArr10);
                }
                zzhdq.zze(jArr9, jArr10, jArr9);
                zzhdq.zzf(jArr9, jArr9);
                zzhdq.zzf(jArr9, jArr9);
                zzhdq.zze(jArr, jArr9, jArr);
                zzhdq.zze(jArr, jArr, jArr8);
                zzhdq.zze(jArr, jArr, jArr4);
                zzhdq.zzf(jArr6, jArr);
                zzhdq.zze(jArr6, jArr6, jArr5);
                zzhdq.zzb(jArr7, jArr6, jArr4);
                if (zze(jArr7)) {
                    zzhdq.zza(jArr7, jArr6, jArr4);
                    if (zze(jArr7)) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                    }
                    zzhdq.zze(jArr, jArr, zzhdl.zzc);
                }
                if (zze(jArr)) {
                    c = 31;
                    b = 255;
                    i = 7;
                } else {
                    c = 31;
                    b = 255;
                    i = 7;
                    if (((bArr3[31] & 255) >> 7) != 0) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                    }
                }
                if (zzf(jArr) == ((bArr3[c] & b) >> i)) {
                    zzm(jArr, jArr);
                }
                zzhdq.zze(jArr3, jArr, jArrZzg);
                zzhdi zzhdiVar = new zzhdi(new zzhdh(jArr, jArrZzg, jArr2), jArr3);
                zzhdf[] zzhdfVarArr = new zzhdf[8];
                zzhdfVarArr[0] = new zzhdf(zzhdiVar);
                zzhdg zzhdgVar = new zzhdg(new zzhdh(), new long[10]);
                zzi(zzhdgVar, zzhdiVar.zza);
                zzhdi zzhdiVar2 = new zzhdi(zzhdgVar);
                for (int i12 = 1; i12 < 8; i12++) {
                    zzg(zzhdgVar, zzhdiVar2, zzhdfVarArr[i12 - 1]);
                    zzhdfVarArr[i12] = new zzhdf(new zzhdi(zzhdgVar));
                }
                byte[] bArrZzl = zzl(bArrDigest);
                byte[] bArrZzl2 = zzl(bArr5);
                zzhdg zzhdgVar2 = new zzhdg(zzc);
                zzhdi zzhdiVar3 = new zzhdi();
                int i13 = b;
                while (i13 >= 0 && bArrZzl[i13] == 0 && bArrZzl2[i13] == 0) {
                    i13--;
                }
                while (i13 >= 0) {
                    zzi(zzhdgVar2, new zzhdh(zzhdgVar2));
                    byte b3 = bArrZzl[i13];
                    if (b3 > 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        b2 = 2;
                        zzg(zzhdgVar2, zzhdiVar3, zzhdfVarArr[bArrZzl[i13] / 2]);
                    } else {
                        b2 = 2;
                        if (b3 < 0) {
                            zzhdi.zza(zzhdiVar3, zzhdgVar2);
                            zzh(zzhdgVar2, zzhdiVar3, zzhdfVarArr[(-bArrZzl[i13]) / 2]);
                        }
                    }
                    byte b4 = bArrZzl2[i13];
                    if (b4 > 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        zzg(zzhdgVar2, zzhdiVar3, zzhdl.zze[bArrZzl2[i13] / b2]);
                    } else if (b4 < 0) {
                        zzhdi.zza(zzhdiVar3, zzhdgVar2);
                        zzh(zzhdgVar2, zzhdiVar3, zzhdl.zze[(-bArrZzl2[i13]) / b2]);
                    }
                    i13--;
                }
                byte[] bArrZzb = new zzhdh(zzhdgVar2).zzb();
                for (int i14 = 0; i14 < 32; i14++) {
                    if (bArrZzb[i14] != bArr2[i14]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void zzd() {
        if (zzhdl.zza == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    static /* synthetic */ boolean zze(long[] jArr) {
        long[] jArr2 = new long[11];
        System.arraycopy(jArr, 0, jArr2, 0, 10);
        zzhdq.zzd(jArr2);
        byte[] bArrZzh = zzhdq.zzh(jArr2);
        for (int i = 0; i < 32; i++) {
            if (bArrZzh[i] != 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ int zzf(long[] jArr) {
        return zzhdq.zzh(jArr)[0] & 1;
    }

    private static void zzg(zzhdg zzhdgVar, zzhdi zzhdiVar, zzhde zzhdeVar) {
        zzhdh zzhdhVar = zzhdiVar.zza;
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhdhVar2.zza;
        long[] jArr3 = zzhdhVar.zzb;
        long[] jArr4 = zzhdhVar.zza;
        zzhdq.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhdhVar2.zzb;
        zzhdq.zzb(jArr5, jArr3, jArr4);
        zzhdq.zze(jArr5, jArr5, zzhdeVar.zzb);
        long[] jArr6 = zzhdeVar.zza;
        long[] jArr7 = zzhdhVar2.zzc;
        zzhdq.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhdgVar.zzb;
        zzhdq.zze(jArr8, zzhdiVar.zzb, zzhdeVar.zzc);
        zzhdeVar.zza(jArr2, zzhdhVar.zzc);
        zzhdq.zza(jArr, jArr2, jArr2);
        zzhdq.zzb(jArr2, jArr7, jArr5);
        zzhdq.zza(jArr5, jArr7, jArr5);
        zzhdq.zza(jArr7, jArr, jArr8);
        zzhdq.zzb(jArr8, jArr, jArr8);
    }

    private static void zzh(zzhdg zzhdgVar, zzhdi zzhdiVar, zzhde zzhdeVar) {
        zzhdh zzhdhVar = zzhdiVar.zza;
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhdhVar2.zza;
        long[] jArr3 = zzhdhVar.zzb;
        long[] jArr4 = zzhdhVar.zza;
        zzhdq.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhdhVar2.zzb;
        zzhdq.zzb(jArr5, jArr3, jArr4);
        zzhdq.zze(jArr5, jArr5, zzhdeVar.zza);
        long[] jArr6 = zzhdeVar.zzb;
        long[] jArr7 = zzhdhVar2.zzc;
        zzhdq.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhdgVar.zzb;
        zzhdq.zze(jArr8, zzhdiVar.zzb, zzhdeVar.zzc);
        zzhdeVar.zza(jArr2, zzhdhVar.zzc);
        zzhdq.zza(jArr, jArr2, jArr2);
        zzhdq.zzb(jArr2, jArr7, jArr5);
        zzhdq.zza(jArr5, jArr7, jArr5);
        zzhdq.zzb(jArr7, jArr, jArr8);
        zzhdq.zza(jArr8, jArr, jArr8);
    }

    private static void zzi(zzhdg zzhdgVar, zzhdh zzhdhVar) {
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = zzhdhVar2.zza;
        long[] jArr2 = zzhdhVar.zza;
        long[] jArr3 = new long[10];
        zzhdq.zzf(jArr, jArr2);
        long[] jArr4 = zzhdhVar2.zzc;
        long[] jArr5 = zzhdhVar.zzb;
        zzhdq.zzf(jArr4, jArr5);
        long[] jArr6 = zzhdgVar.zzb;
        zzhdq.zzf(jArr6, zzhdhVar.zzc);
        zzhdq.zza(jArr6, jArr6, jArr6);
        long[] jArr7 = zzhdhVar2.zzb;
        zzhdq.zza(jArr7, jArr2, jArr5);
        zzhdq.zzf(jArr3, jArr7);
        zzhdq.zza(jArr7, jArr4, jArr);
        zzhdq.zzb(jArr4, jArr4, jArr);
        zzhdq.zzb(jArr, jArr3, jArr7);
        zzhdq.zzb(jArr6, jArr6, jArr4);
    }

    private static int zzj(int i, int i2) {
        int i3 = (~(i ^ i2)) & 255;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return (i5 & (i5 + i5)) >> 7;
    }

    private static void zzk(zzhde zzhdeVar, int i, byte b) {
        zzhde[][] zzhdeVarArr = zzhdl.zzd;
        int i2 = (b & 255) >> 7;
        int i3 = (-i2) & b;
        int i4 = b - (i3 + i3);
        zzhdeVar.zzb(zzhdeVarArr[i][0], zzj(i4, 1));
        zzhdeVar.zzb(zzhdeVarArr[i][1], zzj(i4, 2));
        zzhdeVar.zzb(zzhdeVarArr[i][2], zzj(i4, 3));
        zzhdeVar.zzb(zzhdeVarArr[i][3], zzj(i4, 4));
        zzhdeVar.zzb(zzhdeVarArr[i][4], zzj(i4, 5));
        zzhdeVar.zzb(zzhdeVarArr[i][5], zzj(i4, 6));
        zzhdeVar.zzb(zzhdeVarArr[i][6], zzj(i4, 7));
        zzhdeVar.zzb(zzhdeVarArr[i][7], zzj(i4, 8));
        long[] jArr = zzhdeVar.zzc;
        long[] jArr2 = zzhdeVar.zza;
        long[] jArrCopyOf = Arrays.copyOf(zzhdeVar.zzb, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(jArr, 10);
        zzm(jArrCopyOf3, jArrCopyOf3);
        zzhdeVar.zzb(new zzhde(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i2);
    }

    private static byte[] zzl(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & ((bArr[i2 >> 3] & 255) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        int i5 = b << i4;
                        int i6 = b2 + i5;
                        if (i6 <= 15) {
                            bArr2[i3] = (byte) i6;
                            bArr2[i] = 0;
                        } else {
                            int i7 = b2 - i5;
                            if (i7 >= -15) {
                                bArr2[i3] = (byte) i7;
                                while (true) {
                                    if (i >= 256) {
                                        break;
                                    }
                                    if (bArr2[i] == 0) {
                                        bArr2[i] = 1;
                                        break;
                                    }
                                    bArr2[i] = 0;
                                    i++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void zzm(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    private static long zzn(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long zzo(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | zzn(bArr, i);
    }
}
