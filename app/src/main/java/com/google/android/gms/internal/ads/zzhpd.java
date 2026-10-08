package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhpd {
    public static final zzhpd zza = new zzhpd("SHA256");
    public static final zzhpd zzb = new zzhpd("SHA384");
    public static final zzhpd zzc = new zzhpd("SHA512");
    private final String zzd;

    private zzhpd(String str) {
        this.zzd = str;
    }

    public final String toString() {
        return this.zzd;
    }
}
