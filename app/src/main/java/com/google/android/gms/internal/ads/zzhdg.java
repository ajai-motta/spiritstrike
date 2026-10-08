package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhdg {
    final zzhdh zza;
    final long[] zzb;

    zzhdg() {
        this(new zzhdh(), new long[10]);
    }

    zzhdg(zzhdh zzhdhVar, long[] jArr) {
        this.zza = zzhdhVar;
        this.zzb = jArr;
    }

    zzhdg(zzhdg zzhdgVar) {
        this.zza = new zzhdh(zzhdgVar.zza);
        this.zzb = Arrays.copyOf(zzhdgVar.zzb, 10);
    }
}
