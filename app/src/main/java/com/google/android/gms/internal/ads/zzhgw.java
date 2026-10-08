package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhgw extends zzhhh {
    private final zzhhf zza;
    private final zzhtb zzb;
    private final zzhsz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzhgw(zzhhf zzhhfVar, zzhtb zzhtbVar, zzhsz zzhszVar, Integer num, byte[] bArr) {
        this.zza = zzhhfVar;
        this.zzb = zzhtbVar;
        this.zzc = zzhszVar;
        this.zzd = num;
    }

    public static zzhgv zzc() {
        return new zzhgv(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhhh, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    public final zzhtb zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhhh
    public final zzhsz zze() {
        return this.zzc;
    }

    public final zzhhf zzf() {
        return this.zza;
    }
}
