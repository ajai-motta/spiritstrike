package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxy {

    @Nullable
    private zzgyg zza = null;

    @Nullable
    private zzhtb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzgxy() {
    }

    /* synthetic */ zzgxy(byte[] bArr) {
    }

    public final zzgxy zza(zzgyg zzgygVar) {
        this.zza = zzgygVar;
        return this;
    }

    public final zzgxy zzb(zzhtb zzhtbVar) {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzgxy zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgxz zzd() throws GeneralSecurityException {
        zzhtb zzhtbVar;
        zzhsz zzhszVarZzb;
        zzgyg zzgygVar = this.zza;
        if (zzgygVar == null || (zzhtbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgygVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgygVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzgyf.zzc) {
            zzhszVarZzb = zzhfc.zza;
        } else if (this.zza.zzd() == zzgyf.zzb) {
            zzhszVarZzb = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzgyf.zza) {
                String strValueOf = String.valueOf(this.zza.zzd());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzhszVarZzb = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzgxz(this.zza, this.zzb, zzhszVarZzb, this.zzc, null);
    }
}
