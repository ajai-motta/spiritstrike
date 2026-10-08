package com.google.android.gms.internal.gtm;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaer extends zzaes {
    zzaer(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.gtm.zzaes
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.gtm.zzaes
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.gtm.zzaet.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.gtm.zzaet.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.gtm.zzaet.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z' boolean)' in method call: com.google.android.gms.internal.gtm.zzaet.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.gtm.zzaes
    public final void zzc(Object obj, long j, boolean z) {
        if (zzaet.zzb) {
            zzaet.zzi(obj, j, z);
        } else {
            zzaet.zzj(obj, j, z);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaes
    public final void zzd(Object obj, long j, byte b) {
        if (zzaet.zzb) {
            zzaet.zzD(obj, j, b);
        } else {
            zzaet.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzaes
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.gtm.zzaes
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.gtm.zzaes
    public final boolean zzg(Object obj, long j) {
        return zzaet.zzb ? zzaet.zzt(obj, j) : zzaet.zzu(obj, j);
    }
}
