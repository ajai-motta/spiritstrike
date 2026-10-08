package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbcc {
    final long zza;
    final String zzb;
    final int zzc;

    zzbcc(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbcc)) {
            return false;
        }
        zzbcc zzbccVar = (zzbcc) obj;
        return zzbccVar.zza == this.zza && zzbccVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
