package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgyh {

    @Nullable
    private zzgyp zza = null;

    @Nullable
    private zzhtb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgyh() {
    }

    /* synthetic */ zzgyh(byte[] bArr) {
    }

    public final zzgyh zza(zzgyp zzgypVar) {
        this.zza = zzgypVar;
        return this;
    }

    public final zzgyh zzb(zzhtb zzhtbVar) {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzgyh zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgyi zzd() throws GeneralSecurityException {
        zzhtb zzhtbVar;
        zzhsz zzhszVarZzb;
        zzgyp zzgypVar = this.zza;
        if (zzgypVar == null || (zzhtbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgypVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgypVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzgyo.zzc) {
            zzhszVarZzb = zzhfc.zza;
        } else if (this.zza.zzd() == zzgyo.zzb) {
            zzhszVarZzb = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzgyo.zza) {
                String strValueOf = String.valueOf(this.zza.zzd());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzhszVarZzb = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzgyi(this.zza, this.zzb, zzhszVarZzb, this.zzc, null);
    }
}
