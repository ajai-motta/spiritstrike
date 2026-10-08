package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwn {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzwn(int i) {
        this(0, new Random());
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final int zzb(int i) {
        int i2 = this.zzc[i] + 1;
        int[] iArr = this.zzb;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public final int zzc(int i) {
        int i2 = this.zzc[i] - 1;
        if (i2 >= 0) {
            return this.zzb[i2];
        }
        return -1;
    }

    public final int zzd() {
        int[] iArr = this.zzb;
        int length = iArr.length;
        if (length > 0) {
            return iArr[length - 1];
        }
        return -1;
    }

    public final int zze() {
        int[] iArr = this.zzb;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final zzwn zzf(int i, int i2) {
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            Random random = this.zza;
            iArr[i3] = random.nextInt(this.zzb.length + 1);
            int i4 = i3 + 1;
            int iNextInt = random.nextInt(i4);
            iArr2[i3] = iArr2[iNextInt];
            iArr2[iNextInt] = i3;
            i3 = i4;
        }
        Arrays.sort(iArr);
        int[] iArr3 = this.zzb;
        int[] iArr4 = new int[iArr3.length + i2];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iArr3.length + i2; i7++) {
            if (i5 >= i2 || i6 != iArr[i5]) {
                int i8 = i6 + 1;
                int i9 = iArr3[i6];
                iArr4[i7] = i9;
                if (i9 >= 0) {
                    iArr4[i7] = i9 + i2;
                }
                i6 = i8;
            } else {
                iArr4[i7] = iArr2[i5];
                i5++;
            }
        }
        return new zzwn(iArr4, new Random(this.zza.nextLong()));
    }

    public final zzwn zzg(int i, int i2) {
        int[] iArr = this.zzb;
        int[] iArr2 = new int[iArr.length - i2];
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            if (i5 < 0 || i5 >= i2) {
                int i6 = i4 - i3;
                if (i5 >= 0) {
                    i5 -= i2;
                }
                iArr2[i6] = i5;
            } else {
                i3++;
            }
        }
        return new zzwn(iArr2, new Random(this.zza.nextLong()));
    }

    public final zzwn zzh() {
        return new zzwn(0, new Random(this.zza.nextLong()));
    }

    private zzwn(int i, Random random) {
        this(new int[0], random);
    }

    private zzwn(int[] iArr, Random random) {
        this.zzb = iArr;
        this.zza = random;
        this.zzc = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            this.zzc[iArr[i]] = i;
        }
    }
}
