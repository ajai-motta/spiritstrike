package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhfi {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzhfi(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhfi zzd(zzhfh zzhfhVar, Class cls, Class cls2) {
        return new zzhfg(cls, cls2, zzhfhVar);
    }

    public abstract zzhgb zza(zzgwj zzgwjVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
