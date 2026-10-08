package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhgj {

    @Nullable
    private zzhgr zza = null;

    @Nullable
    private zzhtb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhgj() {
    }

    /* synthetic */ zzhgj(byte[] bArr) {
    }

    public final zzhgj zza(zzhgr zzhgrVar) {
        this.zza = zzhgrVar;
        return this;
    }

    public final zzhgj zzb(zzhtb zzhtbVar) throws GeneralSecurityException {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzhgj zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhgk zzd() throws GeneralSecurityException {
        zzhtb zzhtbVar;
        zzhsz zzhszVarZza;
        zzhgr zzhgrVar = this.zza;
        if (zzhgrVar == null || (zzhtbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhgrVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhgrVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzhgq.zzd) {
            zzhszVarZza = zzhfc.zza;
        } else if (this.zza.zzf() == zzhgq.zzc || this.zza.zzf() == zzhgq.zzb) {
            zzhszVarZza = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhgq.zza) {
                String strValueOf = String.valueOf(this.zza.zzf());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzhszVarZza = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzhgk(this.zza, this.zzb, zzhszVarZza, this.zzc, null);
    }
}
