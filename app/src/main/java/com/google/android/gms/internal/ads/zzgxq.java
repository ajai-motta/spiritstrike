package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxq {

    @Nullable
    private zzgxx zza = null;

    @Nullable
    private zzhtb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgxq() {
    }

    /* synthetic */ zzgxq(byte[] bArr) {
    }

    public final zzgxq zza(zzgxx zzgxxVar) {
        this.zza = zzgxxVar;
        return this;
    }

    public final zzgxq zzb(zzhtb zzhtbVar) {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzgxq zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgxr zzd() throws GeneralSecurityException {
        zzhtb zzhtbVar;
        zzhsz zzhszVarZzb;
        zzgxx zzgxxVar = this.zza;
        if (zzgxxVar == null || (zzhtbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgxxVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgxxVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zze() == zzgxw.zzc) {
            zzhszVarZzb = zzhfc.zza;
        } else if (this.zza.zze() == zzgxw.zzb) {
            zzhszVarZzb = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zze() != zzgxw.zza) {
                String strValueOf = String.valueOf(this.zza.zze());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzhszVarZzb = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzgxr(this.zza, this.zzb, zzhszVarZzb, this.zzc, null);
    }
}
