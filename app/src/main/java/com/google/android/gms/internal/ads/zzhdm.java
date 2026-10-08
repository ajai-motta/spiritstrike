package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhdm {
    static final zzhdm zzd = new zzhdm(BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO);
    final BigInteger zza;
    final BigInteger zzb;
    final BigInteger zzc;

    zzhdm(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.zza = bigInteger;
        this.zzb = bigInteger2;
        this.zzc = bigInteger3;
    }

    final boolean zza() {
        return this.zzc.equals(BigInteger.ZERO);
    }
}
