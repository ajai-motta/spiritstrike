package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgzl extends zzgxa {
    private final zzgzp zza;
    private final zzhsz zzb;

    @Nullable
    private final Integer zzc;

    private zzgzl(zzgzp zzgzpVar, zzhsz zzhszVar, @Nullable Integer num) {
        this.zza = zzgzpVar;
        this.zzb = zzhszVar;
        this.zzc = num;
    }

    public static zzgzl zzd(zzgzp zzgzpVar, @Nullable Integer num) throws GeneralSecurityException {
        zzhsz zzhszVarZzb;
        if (zzgzpVar.zzc() == zzgzo.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zzhszVarZzb = zzhfc.zza;
        } else {
            if (zzgzpVar.zzc() != zzgzo.zza) {
                String strValueOf = String.valueOf(zzgzpVar.zzc());
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(strValueOf)));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zzhszVarZzb = zzhfc.zzb(num.intValue());
        }
        return new zzgzl(zzgzpVar, zzhszVarZzb, num);
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

    public final zzgzp zze() {
        return this.zza;
    }
}
