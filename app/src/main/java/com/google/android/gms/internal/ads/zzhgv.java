package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhgv {

    @Nullable
    private zzhhf zza = null;

    @Nullable
    private zzhtb zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhgv() {
    }

    /* synthetic */ zzhgv(byte[] bArr) {
    }

    public final zzhgv zza(zzhhf zzhhfVar) {
        this.zza = zzhhfVar;
        return this;
    }

    public final zzhgv zzb(zzhtb zzhtbVar) {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzhgv zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhgw zzd() throws GeneralSecurityException {
        zzhtb zzhtbVar;
        zzhsz zzhszVarZza;
        zzhhf zzhhfVar = this.zza;
        if (zzhhfVar == null || (zzhtbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzhhfVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzhhfVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzhhe.zzd) {
            zzhszVarZza = zzhfc.zza;
        } else if (this.zza.zzf() == zzhhe.zzc || this.zza.zzf() == zzhhe.zzb) {
            zzhszVarZza = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhhe.zza) {
                String strValueOf = String.valueOf(this.zza.zzf());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zzhszVarZza = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzhgw(this.zza, this.zzb, zzhszVarZza, this.zzc, null);
    }
}
