package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhpj extends zzhpr {
    private final zzhpf zza;
    private final BigInteger zzb;
    private final zzhsz zzc;

    @Nullable
    private final Integer zzd;

    /* synthetic */ zzhpj(zzhpf zzhpfVar, BigInteger bigInteger, zzhsz zzhszVar, Integer num, byte[] bArr) {
        this.zza = zzhpfVar;
        this.zzb = bigInteger;
        this.zzc = zzhszVar;
        this.zzd = num;
    }

    public static zzhpi zzc() {
        return new zzhpi(null);
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

    public final BigInteger zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhpr
    public final zzhsz zze() {
        return this.zzc;
    }

    public final zzhpf zzf() {
        return this.zza;
    }
}
