package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzuu {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    public zzuu(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private zzuu(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public zzuu(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuu)) {
            return false;
        }
        zzuu zzuuVar = (zzuu) obj;
        return this.zza.equals(zzuuVar.zza) && this.zzb == zzuuVar.zzb && this.zzc == zzuuVar.zzc && this.zzd == zzuuVar.zzd && this.zze == zzuuVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzuu zza(Object obj) {
        return this.zza.equals(obj) ? this : new zzuu(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzuu(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
