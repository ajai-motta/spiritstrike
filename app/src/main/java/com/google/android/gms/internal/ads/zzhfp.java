package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhfp {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzhfp(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhfp zzd(zzhfo zzhfoVar, Class cls, Class cls2) {
        return new zzhfn(cls, cls2, zzhfoVar);
    }

    public abstract Object zza(zzgvt zzgvtVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
