package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhec {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzhec(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhec zzd(zzheb zzhebVar, Class cls, Class cls2) {
        return new zzhea(cls, cls2, zzhebVar);
    }

    public abstract zzhgb zza(zzgvt zzgvtVar, @Nullable zzgwn zzgwnVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
