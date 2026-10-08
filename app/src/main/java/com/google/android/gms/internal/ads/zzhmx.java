package com.google.android.gms.internal.ads;

import java.security.spec.ECParameterSpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhmx {
    public static final zzhmx zza = new zzhmx("NIST_P256", zzhdn.zza);
    public static final zzhmx zzb = new zzhmx("NIST_P384", zzhdn.zzb);
    public static final zzhmx zzc = new zzhmx("NIST_P521", zzhdn.zzc);
    private final String zzd;
    private final ECParameterSpec zze;

    private zzhmx(String str, ECParameterSpec eCParameterSpec) {
        this.zzd = str;
        this.zze = eCParameterSpec;
    }

    public final String toString() {
        return this.zzd;
    }

    public final ECParameterSpec zza() {
        return this.zze;
    }
}
