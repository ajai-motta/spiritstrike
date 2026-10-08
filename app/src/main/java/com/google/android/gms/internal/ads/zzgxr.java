package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxr extends zzgxa {
    private final zzgxx zza;
    private final zzhtb zzb;
    private final zzhsz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzgxr(zzgxx zzgxxVar, zzhtb zzhtbVar, zzhsz zzhszVar, Integer num, byte[] bArr) {
        this.zza = zzgxxVar;
        this.zzb = zzhtbVar;
        this.zzc = zzhszVar;
        this.zzd = num;
    }

    public static zzgxq zzd() {
        return new zzgxq(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgxa, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgxa
    public final zzhsz zzc() {
        return this.zzc;
    }

    public final zzhtb zze() {
        return this.zzb;
    }

    public final zzgxx zzf() {
        return this.zza;
    }
}
