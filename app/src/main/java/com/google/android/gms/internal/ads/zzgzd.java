package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgzd extends zzgxa {
    private final zzgzf zza;
    private final zzhsz zzb;

    @Nullable
    private final Integer zzc;

    private zzgzd(zzgzf zzgzfVar, zzhsz zzhszVar, @Nullable Integer num) {
        this.zza = zzgzfVar;
        this.zzb = zzhszVar;
        this.zzc = num;
    }

    public static zzgzd zzd(zzgzf zzgzfVar, @Nullable Integer num) throws GeneralSecurityException {
        zzhsz zzhszVarZza;
        if (zzgzfVar.zzd() == zzgze.zza) {
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzhszVarZza = zzhsz.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
        } else {
            if (zzgzfVar.zzd() != zzgze.zzb) {
                throw new GeneralSecurityException("Unknown Variant: ".concat(zzgzfVar.zzd().toString()));
            }
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzhszVarZza = zzhsz.zza(new byte[0]);
        }
        return new zzgzd(zzgzfVar, zzhszVarZza, num);
    }

    @Override // com.google.android.gms.internal.ads.zzgxa, com.google.android.gms.internal.ads.zzgvt
    public final /* synthetic */ zzgwj zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    public final Integer zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgxa
    public final zzhsz zzc() {
        return this.zzb;
    }

    public final zzgzf zze() {
        return this.zza;
    }
}
