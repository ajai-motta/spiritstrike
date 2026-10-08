package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfpi {
    private final String zza;
    private final String zzb;

    private zzfpi(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public static zzfpi zza(String str, String str2) {
        zzfqs.zzc(str, "Name is null or empty");
        zzfqs.zzc(str2, "Version is null or empty");
        return new zzfpi(str, str2);
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }
}
