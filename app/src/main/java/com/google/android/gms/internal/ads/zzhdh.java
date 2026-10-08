package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhdh {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    zzhdh() {
        this(new long[10], new long[10], new long[10]);
    }

    zzhdh(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }

    static zzhdh zza(zzhdh zzhdhVar, zzhdg zzhdgVar) {
        zzhdh zzhdhVar2 = zzhdgVar.zza;
        long[] jArr = zzhdhVar.zza;
        long[] jArr2 = zzhdhVar2.zza;
        long[] jArr3 = zzhdgVar.zzb;
        zzhdq.zze(jArr, jArr2, jArr3);
        long[] jArr4 = zzhdhVar.zzb;
        long[] jArr5 = zzhdhVar2.zzb;
        long[] jArr6 = zzhdhVar2.zzc;
        zzhdq.zze(jArr4, jArr5, jArr6);
        zzhdq.zze(zzhdhVar.zzc, jArr6, jArr3);
        return zzhdhVar;
    }

    final byte[] zzb() {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        int i = zzhdq.zza;
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        long[] jArr13 = new long[10];
        long[] jArr14 = this.zzc;
        zzhdq.zzf(jArr4, jArr14);
        zzhdq.zzf(jArr13, jArr4);
        zzhdq.zzf(jArr12, jArr13);
        zzhdq.zze(jArr5, jArr12, jArr14);
        zzhdq.zze(jArr6, jArr5, jArr4);
        zzhdq.zzf(jArr12, jArr6);
        zzhdq.zze(jArr7, jArr12, jArr5);
        zzhdq.zzf(jArr12, jArr7);
        zzhdq.zzf(jArr13, jArr12);
        zzhdq.zzf(jArr12, jArr13);
        zzhdq.zzf(jArr13, jArr12);
        zzhdq.zzf(jArr12, jArr13);
        zzhdq.zze(jArr8, jArr12, jArr7);
        zzhdq.zzf(jArr12, jArr8);
        zzhdq.zzf(jArr13, jArr12);
        for (int i2 = 2; i2 < 10; i2 += 2) {
            zzhdq.zzf(jArr12, jArr13);
            zzhdq.zzf(jArr13, jArr12);
        }
        zzhdq.zze(jArr9, jArr13, jArr8);
        zzhdq.zzf(jArr12, jArr9);
        zzhdq.zzf(jArr13, jArr12);
        for (int i3 = 2; i3 < 20; i3 += 2) {
            zzhdq.zzf(jArr12, jArr13);
            zzhdq.zzf(jArr13, jArr12);
        }
        zzhdq.zze(jArr12, jArr13, jArr9);
        zzhdq.zzf(jArr13, jArr12);
        zzhdq.zzf(jArr12, jArr13);
        for (int i4 = 2; i4 < 10; i4 += 2) {
            zzhdq.zzf(jArr13, jArr12);
            zzhdq.zzf(jArr12, jArr13);
        }
        zzhdq.zze(jArr10, jArr12, jArr8);
        zzhdq.zzf(jArr12, jArr10);
        zzhdq.zzf(jArr13, jArr12);
        for (int i5 = 2; i5 < 50; i5 += 2) {
            zzhdq.zzf(jArr12, jArr13);
            zzhdq.zzf(jArr13, jArr12);
        }
        zzhdq.zze(jArr11, jArr13, jArr10);
        zzhdq.zzf(jArr13, jArr11);
        zzhdq.zzf(jArr12, jArr13);
        for (int i6 = 2; i6 < 100; i6 += 2) {
            zzhdq.zzf(jArr13, jArr12);
            zzhdq.zzf(jArr12, jArr13);
        }
        zzhdq.zze(jArr13, jArr12, jArr11);
        zzhdq.zzf(jArr12, jArr13);
        zzhdq.zzf(jArr13, jArr12);
        for (int i7 = 2; i7 < 50; i7 += 2) {
            zzhdq.zzf(jArr12, jArr13);
            zzhdq.zzf(jArr13, jArr12);
        }
        zzhdq.zze(jArr12, jArr13, jArr10);
        zzhdq.zzf(jArr13, jArr12);
        zzhdq.zzf(jArr12, jArr13);
        zzhdq.zzf(jArr13, jArr12);
        zzhdq.zzf(jArr12, jArr13);
        zzhdq.zzf(jArr13, jArr12);
        zzhdq.zze(jArr, jArr13, jArr6);
        zzhdq.zze(jArr2, this.zza, jArr);
        zzhdq.zze(jArr3, this.zzb, jArr);
        byte[] bArrZzh = zzhdq.zzh(jArr3);
        bArrZzh[31] = (byte) ((zzhdj.zzf(jArr2) << 7) ^ bArrZzh[31]);
        return bArrZzh;
    }

    zzhdh(zzhdg zzhdgVar) {
        this();
        zza(this, zzhdgVar);
    }

    zzhdh(zzhdh zzhdhVar) {
        this.zza = Arrays.copyOf(zzhdhVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhdhVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhdhVar.zzc, 10);
    }
}
