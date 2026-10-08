package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhzh extends zzhzi {
    zzhzh(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zza(Object obj, long j, byte b) {
        if (zzhzj.zzb) {
            zzhzj.zzG(obj, j, b);
        } else {
            zzhzj.zzH(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final boolean zzb(Object obj, long j) {
        return zzhzj.zzb ? zzhzj.zzx(obj, j) : zzhzj.zzy(obj, j);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhzj.zzA(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhzj.zzz(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.ads.zzhzj.zzA(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.ads.zzhzj.zzz(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zzc(Object obj, long j, boolean z) {
        if (zzhzj.zzb) {
            zzhzj.zzz(obj, j, z);
        } else {
            zzhzj.zzA(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zze(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zzg(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final byte zzh(long j) {
        return Memory.peekByte(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zzi(long j, byte[] bArr, long j2, long j3) {
        Memory.peekByteArray(j, bArr, (int) j2, (int) j3);
    }
}
