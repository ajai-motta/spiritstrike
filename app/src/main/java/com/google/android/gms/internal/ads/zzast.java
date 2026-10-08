package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzast {
    public final ArrayList zza = new ArrayList();
    public int zzb = 0;

    public zzast(int i) {
    }

    public final int zza(long j) throws zzasr {
        long j2;
        int[] iArr = {2001100545, 2130723407, 140753313, -149863858, -2003236720, 202391198, 23353437, 1141616124, 84353895};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = i8 % 84353895;
        long[] jArr = {269441500, 1994078854, 158128940, -158130045, -1992289935, 556430036, 8936987, 2147469841, 438792350};
        long j3 = jArr[0];
        long j4 = jArr[1];
        long j5 = jArr[2];
        long j6 = jArr[3];
        long j7 = jArr[4];
        long j8 = jArr[5];
        long j9 = jArr[6];
        long j10 = jArr[7];
        long j11 = j9 + (((((~j3) & j4) | j5) + ((j3 & j6) | j7)) - j8);
        long j12 = j10 % 438792350;
        if (j >= 0) {
            j2 = ((long) (this.zzb + (i9 ^ i10))) - j;
        } else {
            j2 = (j11 ^ j12) + (-j);
        }
        if (j2 < 0 || j2 >= this.zzb) {
            throw new zzasr();
        }
        return (int) j2;
    }

    public final void zzb(zzatc zzatcVar) throws zzass {
        int[] iArr = {524133589, 740889625, 408955079, 621796408, 24562149, 1207357565, 297783268, 1066077375, 937558955};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = this.zzb;
        if (i10 >= ((i8 % 937558955) ^ i9)) {
            throw new zzass();
        }
        ArrayList arrayList = this.zza;
        if (i10 == arrayList.size()) {
            arrayList.add(zzatcVar);
        } else {
            arrayList.set(this.zzb, zzatcVar);
        }
        this.zzb++;
    }

    public final zzatc zzc() throws zzasr {
        int[] iArr = {91119157, 1459677288, 586253619, -183145911, -1567288443, 919325394, 146725508, 787086305, 459541652};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        int i10 = i8 % 459541652;
        int i11 = this.zzb;
        if (i11 <= 0) {
            throw new zzasr();
        }
        int i12 = i10 ^ i9;
        ArrayList arrayList = this.zza;
        zzatc zzatcVar = (zzatc) arrayList.get(i11 + i12);
        arrayList.set(this.zzb + i12, null);
        this.zzb += i12;
        return zzatcVar;
    }

    public final zzatc zzd(long j) throws zzasr {
        return (zzatc) this.zza.get(zza(j));
    }

    public final void zze(long j, zzatc zzatcVar) throws zzasr {
        this.zza.set(zza(j), zzatcVar);
    }
}
