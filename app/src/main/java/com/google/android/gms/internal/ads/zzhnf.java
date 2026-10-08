package com.google.android.gms.internal.ads;

import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhnf extends zzhpr {
    private final zzhnb zza;
    private final ECPoint zzb;
    private final zzhsz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzhnf(zzhnb zzhnbVar, ECPoint eCPoint, zzhsz zzhszVar, Integer num, byte[] bArr) {
        this.zza = zzhnbVar;
        this.zzb = eCPoint;
        this.zzc = zzhszVar;
        this.zzd = num;
    }

    public static zzhne zzc() {
        return new zzhne(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhpr, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    public final ECPoint zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhpr
    public final zzhsz zze() {
        return this.zzc;
    }

    public final zzhnb zzf() {
        return this.zza;
    }
}
