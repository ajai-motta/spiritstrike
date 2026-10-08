package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhdi {
    final zzhdh zza;
    final long[] zzb;

    zzhdi() {
        this(new zzhdh(), new long[10]);
    }

    zzhdi(zzhdh zzhdhVar, long[] jArr) {
        this.zza = zzhdhVar;
        this.zzb = jArr;
    }

    static /* synthetic */ zzhdi zza(zzhdi zzhdiVar, zzhdg zzhdgVar) {
        zzb(zzhdiVar, zzhdgVar);
        return zzhdiVar;
    }

    private static zzhdi zzb(zzhdi zzhdiVar, zzhdg zzhdgVar) {
        zzhdh zzhdhVar = zzhdgVar.zza;
        zzhdh zzhdhVar2 = zzhdiVar.zza;
        long[] jArr = zzhdhVar2.zza;
        long[] jArr2 = zzhdhVar.zza;
        long[] jArr3 = zzhdgVar.zzb;
        zzhdq.zze(jArr, jArr2, jArr3);
        long[] jArr4 = zzhdhVar2.zzb;
        long[] jArr5 = zzhdhVar.zzb;
        long[] jArr6 = zzhdhVar.zzc;
        zzhdq.zze(jArr4, jArr5, jArr6);
        zzhdq.zze(zzhdhVar2.zzc, jArr6, jArr3);
        zzhdq.zze(zzhdiVar.zzb, jArr2, jArr5);
        return zzhdiVar;
    }

    zzhdi(zzhdg zzhdgVar) {
        this();
        zzb(this, zzhdgVar);
    }
}
