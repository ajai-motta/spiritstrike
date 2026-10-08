package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzlv {
    public static final zzlv zza;
    public static final zzlv zzb;
    public static final zzlv zzc;
    public final long zzd;
    public final long zze;

    static {
        zzlv zzlvVar = new zzlv(0L, 0L);
        zza = zzlvVar;
        new zzlv(Long.MAX_VALUE, Long.MAX_VALUE);
        zzb = new zzlv(Long.MAX_VALUE, 0L);
        new zzlv(0L, Long.MAX_VALUE);
        zzc = zzlvVar;
    }

    public zzlv(long j, long j2) {
        zzgmd.zza(j >= 0);
        zzgmd.zza(j2 >= 0);
        this.zzd = j;
        this.zze = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzlv zzlvVar = (zzlv) obj;
            if (this.zzd == zzlvVar.zzd && this.zze == zzlvVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzd) * 31) + ((int) this.zze);
    }
}
