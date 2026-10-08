package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzhzi {
    final Unsafe zza;

    zzhzi(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j, byte b);

    public abstract boolean zzb(Object obj, long j);

    public abstract void zzc(Object obj, long j, boolean z);

    public abstract float zzd(Object obj, long j);

    public abstract void zze(Object obj, long j, float f);

    public abstract double zzf(Object obj, long j);

    public abstract void zzg(Object obj, long j, double d);

    public abstract byte zzh(long j);

    public abstract void zzi(long j, byte[] bArr, long j2, long j3);
}
