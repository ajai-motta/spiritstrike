package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhmw {
    private zzhmz zza = null;
    private zzhmx zzb = null;
    private zzhmy zzc = null;
    private zzhna zzd = zzhna.zzd;

    private zzhmw() {
    }

    /* synthetic */ zzhmw(byte[] bArr) {
    }

    public final zzhmw zza(zzhmz zzhmzVar) {
        this.zza = zzhmzVar;
        return this;
    }

    public final zzhmw zzb(zzhmx zzhmxVar) {
        this.zzb = zzhmxVar;
        return this;
    }

    public final zzhmw zzc(zzhmy zzhmyVar) {
        this.zzc = zzhmyVar;
        return this;
    }

    public final zzhmw zzd(zzhna zzhnaVar) {
        this.zzd = zzhnaVar;
        return this;
    }

    public final zzhnb zze() throws GeneralSecurityException {
        zzhmz zzhmzVar = this.zza;
        if (zzhmzVar == null) {
            throw new GeneralSecurityException("signature encoding is not set");
        }
        zzhmx zzhmxVar = this.zzb;
        if (zzhmxVar == null) {
            throw new GeneralSecurityException("EC curve type is not set");
        }
        zzhmy zzhmyVar = this.zzc;
        if (zzhmyVar == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        zzhna zzhnaVar = this.zzd;
        if (zzhnaVar == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (zzhmxVar == zzhmx.zza && zzhmyVar != zzhmy.zza) {
            throw new GeneralSecurityException("NIST_P256 requires SHA256");
        }
        if (zzhmxVar == zzhmx.zzb && zzhmyVar != zzhmy.zzb && zzhmyVar != zzhmy.zzc) {
            throw new GeneralSecurityException("NIST_P384 requires SHA384 or SHA512");
        }
        if (zzhmxVar != zzhmx.zzc || zzhmyVar == zzhmy.zzc) {
            return new zzhnb(zzhmzVar, zzhmxVar, zzhmyVar, zzhnaVar, null);
        }
        throw new GeneralSecurityException("NIST_P521 requires SHA512");
    }
}
