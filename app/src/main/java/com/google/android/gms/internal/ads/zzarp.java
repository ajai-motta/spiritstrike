package com.google.android.gms.internal.ads;

import java.util.Locale;
import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzarp extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    public zzarp(zzaro zzaroVar, zzarm zzarmVar, long j) {
        int[] iArr = {2143124030, 85005376, 430547086, 878451808, 1894615585, -1294155075, 737454769, 1747844822, 1617876982};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        iArr[0] = 1434433518;
        iArr[1] = 1229726181;
        iArr[2] = 671269892;
        iArr[3] = 1096561121;
        iArr[4] = 546312716;
        iArr[5] = 1929952353;
        iArr[6] = 157272379;
        iArr[7] = 1830539036;
        iArr[8] = 1290127955;
        int i9 = (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)) ^ (i8 % 1617876982);
        Locale locale = Locale.US;
        Object[] objArr = new Object[i9];
        objArr[0] = Long.valueOf(zzaroVar.zza());
        objArr[1] = Long.valueOf(zzarmVar.zza());
        int i10 = (((((~1434433518) & 1229726181) | 671269892) + ((1434433518 & 1096561121) | 546312716)) - 1772679974) ^ (1830539036 % 1290127955);
        Long lValueOf = Long.valueOf(j);
        objArr[i10] = lValueOf;
        super(String.format(locale, zzase.zza("bk3t6gFTc30="), objArr));
        Optional.of(zzarmVar);
        Optional.of(lValueOf);
    }

    public zzarp(zzaro zzaroVar, Throwable th) {
        super(String.format(Locale.US, zzase.zza("bk0="), Long.valueOf(zzaroVar.zza())), th);
        Optional.empty();
        Optional.empty();
    }
}
