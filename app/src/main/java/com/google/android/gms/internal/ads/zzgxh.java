package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxh extends zzgxa {
    private final zzgxp zza;
    private final zzhtb zzb;
    private final zzhtb zzc;
    private final zzhsz zzd;

    @Nullable
    private final Integer zze;

    /* synthetic */ zzgxh(zzgxp zzgxpVar, zzhtb zzhtbVar, zzhtb zzhtbVar2, zzhsz zzhszVar, Integer num, byte[] bArr) {
        this.zza = zzgxpVar;
        this.zzb = zzhtbVar;
        this.zzc = zzhtbVar2;
        this.zzd = zzhszVar;
        this.zze = num;
    }

    public static zzgxg zzd() {
        return new zzgxg(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgxa, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    @Nullable
    public final Integer zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgxa
    public final zzhsz zzc() {
        return this.zzd;
    }

    public final zzhtb zze() {
        return this.zzb;
    }

    public final zzhtb zzf() {
        return this.zzc;
    }

    public final zzgxp zzg() {
        return this.zza;
    }
}
