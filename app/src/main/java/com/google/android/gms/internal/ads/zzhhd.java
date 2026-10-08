package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhhd {
    public static final zzhhd zza = new zzhhd("SHA1");
    public static final zzhhd zzb = new zzhhd("SHA224");
    public static final zzhhd zzc = new zzhhd("SHA256");
    public static final zzhhd zzd = new zzhhd("SHA384");
    public static final zzhhd zze = new zzhhd("SHA512");
    private final String zzf;

    private zzhhd(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
