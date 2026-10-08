package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhff {
    private final zzhsz zza;
    private final Class zzb;

    /* synthetic */ zzhff(zzhsz zzhszVar, Class cls, byte[] bArr) {
        this.zza = zzhszVar;
        this.zzb = cls;
    }

    public static zzhff zzd(zzhfe zzhfeVar, zzhsz zzhszVar, Class cls) {
        return new zzhfd(zzhszVar, cls, zzhfeVar);
    }

    public abstract zzgwj zza(zzhgb zzhgbVar) throws GeneralSecurityException;

    public final zzhsz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
