package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhne {

    @Nullable
    private zzhnb zza = null;

    @Nullable
    private ECPoint zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhne() {
    }

    /* synthetic */ zzhne(byte[] bArr) {
    }

    public final zzhne zza(zzhnb zzhnbVar) {
        this.zza = zzhnbVar;
        return this;
    }

    public final zzhne zzb(ECPoint eCPoint) {
        this.zzb = eCPoint;
        return this;
    }

    public final zzhne zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhnf zzd() throws GeneralSecurityException {
        zzhsz zzhszVarZza;
        zzhnb zzhnbVar = this.zza;
        if (zzhnbVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        ECPoint eCPoint = this.zzb;
        if (eCPoint == null) {
            throw new GeneralSecurityException("Cannot build without public point");
        }
        zzhdn.zza(eCPoint, zzhnbVar.zzd().zza().getCurve());
        if (this.zza.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzhna.zzd) {
            zzhszVarZza = zzhfc.zza;
        } else if (this.zza.zzf() == zzhna.zzc || this.zza.zzf() == zzhna.zzb) {
            zzhszVarZza = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhna.zza) {
                throw new IllegalStateException("Unknown EcdsaParameters.Variant: ".concat(this.zza.zzf().toString()));
            }
            zzhszVarZza = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzhnf(this.zza, this.zzb, zzhszVarZza, this.zzc, null);
    }
}
