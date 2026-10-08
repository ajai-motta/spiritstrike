package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhal extends zzgxa {
    private final zzhar zza;
    private final zzhtb zzb;
    private final zzhsz zzc;

    @Nullable
    private final Integer zzd;

    private zzhal(zzhar zzharVar, zzhtb zzhtbVar, zzhsz zzhszVar, @Nullable Integer num) {
        this.zza = zzharVar;
        this.zzb = zzhtbVar;
        this.zzc = zzhszVar;
        this.zzd = num;
    }

    public static zzhal zzd(zzhaq zzhaqVar, zzhtb zzhtbVar, @Nullable Integer num) throws GeneralSecurityException {
        zzhsz zzhszVarZzb;
        zzhaq zzhaqVar2 = zzhaq.zzc;
        if (zzhaqVar != zzhaqVar2 && num == null) {
            String string = zzhaqVar.toString();
            StringBuilder sb = new StringBuilder(string.length() + 62);
            sb.append("For given Variant ");
            sb.append(string);
            sb.append(" the value of idRequirement must be non-null");
            throw new GeneralSecurityException(sb.toString());
        }
        if (zzhaqVar == zzhaqVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzhtbVar.zzd() != 32) {
            int iZzd = zzhtbVar.zzd();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzd).length() + 75);
            sb2.append("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ");
            sb2.append(iZzd);
            throw new GeneralSecurityException(sb2.toString());
        }
        zzhar zzharVarZzb = zzhar.zzb(zzhaqVar);
        if (zzharVarZzb.zzc() == zzhaqVar2) {
            zzhszVarZzb = zzhfc.zza;
        } else if (zzharVarZzb.zzc() == zzhaq.zzb) {
            zzhszVarZzb = zzhfc.zza(num.intValue());
        } else {
            if (zzharVarZzb.zzc() != zzhaq.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzharVarZzb.zzc().toString()));
            }
            zzhszVarZzb = zzhfc.zzb(num.intValue());
        }
        return new zzhal(zzharVarZzb, zzhtbVar, zzhszVarZzb, num);
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

    public final zzhar zzf() {
        return this.zza;
    }
}
