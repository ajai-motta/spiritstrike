package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfwt {
    private final String zza;
    private final long zzb;

    public zzfwt() {
        this.zza = null;
        this.zzb = -1L;
    }

    public zzfwt(String str, long j) {
        this.zza = str;
        this.zzb = j;
    }

    public final String zza() {
        return this.zza;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zza != null && this.zzb > 0;
    }
}
