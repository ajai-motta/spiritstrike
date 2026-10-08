package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhdz {
    private final zzhsz zza;
    private final Class zzb;

    /* synthetic */ zzhdz(zzhsz zzhszVar, Class cls, byte[] bArr) {
        this.zza = zzhszVar;
        this.zzb = cls;
    }

    public static zzhdz zzd(zzhdy zzhdyVar, zzhsz zzhszVar, Class cls) {
        return new zzhdx(zzhszVar, cls, zzhdyVar);
    }

    public abstract zzgvt zza(zzhgb zzhgbVar, @Nullable zzgwn zzgwnVar) throws GeneralSecurityException;

    public final zzhsz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
