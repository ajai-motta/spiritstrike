package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxn {
    public static final zzgxn zza = new zzgxn("SHA1");
    public static final zzgxn zzb = new zzgxn("SHA224");
    public static final zzgxn zzc = new zzgxn("SHA256");
    public static final zzgxn zzd = new zzgxn("SHA384");
    public static final zzgxn zze = new zzgxn("SHA512");
    private final String zzf;

    private zzgxn(String str) {
        this.zzf = str;
    }

    public final String toString() {
        return this.zzf;
    }
}
