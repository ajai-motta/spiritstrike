package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxg {

    @Nullable
    private zzgxp zza = null;

    @Nullable
    private zzhtb zzb = null;

    @Nullable
    private zzhtb zzc = null;

    @Nullable
    private Integer zzd = null;

    private zzgxg() {
    }

    /* synthetic */ zzgxg(byte[] bArr) {
    }

    public final zzgxg zza(zzgxp zzgxpVar) {
        this.zza = zzgxpVar;
        return this;
    }

    public final zzgxg zzb(zzhtb zzhtbVar) {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzgxg zzc(zzhtb zzhtbVar) {
        this.zzc = zzhtbVar;
        return this;
    }

    public final zzgxg zzd(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzgxh zze() throws GeneralSecurityException {
        zzhsz zzhszVarZzb;
        zzgxp zzgxpVar = this.zza;
        if (zzgxpVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzhtb zzhtbVar = this.zzb;
        if (zzhtbVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzgxpVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzgxpVar.zzd() != this.zzc.zzd()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzgxo.zzc) {
            zzhszVarZzb = zzhfc.zza;
        } else if (this.zza.zzg() == zzgxo.zzb) {
            zzhszVarZzb = zzhfc.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzg() != zzgxo.zza) {
                String strValueOf = String.valueOf(this.zza.zzg());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzhszVarZzb = zzhfc.zzb(this.zzd.intValue());
        }
        return new zzgxh(this.zza, this.zzb, this.zzc, zzhszVarZzb, this.zzd, null);
    }
}
