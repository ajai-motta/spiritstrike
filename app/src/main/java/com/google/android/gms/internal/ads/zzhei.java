package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhei extends zzgvt {
    private final zzhfw zza;

    public zzhei(zzhfw zzhfwVar, @Nullable zzgwn zzgwnVar) throws GeneralSecurityException {
        zze(zzhfwVar, zzgwnVar);
        this.zza = zzhfwVar;
    }

    private static void zze(zzhfw zzhfwVar, @Nullable zzgwn zzgwnVar) throws GeneralSecurityException {
        int i = zzheg.zzb[zzhfwVar.zzc().ordinal()];
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    public final zzgwj zza() {
        zzhfw zzhfwVar = this.zza;
        return new zzheh(zzhfwVar.zzg(), zzhfwVar.zzd(), null);
    }

    @Override // com.google.android.gms.internal.ads.zzgvt
    @Nullable
    public final Integer zzb() {
        return this.zza.zze();
    }

    public final zzhfw zzc(@Nullable zzgwn zzgwnVar) throws GeneralSecurityException {
        zzhfw zzhfwVar = this.zza;
        zze(zzhfwVar, zzgwnVar);
        return zzhfwVar;
    }

    public final zzhsz zzd() throws GeneralSecurityException {
        zzhfw zzhfwVar = this.zza;
        if (zzhfwVar.zzd().equals(zzhlt.RAW)) {
            return zzhsz.zza(new byte[0]);
        }
        if (zzhfwVar.zzd().equals(zzhlt.TINK)) {
            return zzhfc.zzb(zzhfwVar.zze().intValue());
        }
        if (zzhfwVar.zzd().equals(zzhlt.LEGACY) || zzhfwVar.zzd().equals(zzhlt.CRUNCHY)) {
            return zzhfc.zza(zzhfwVar.zze().intValue());
        }
        throw new GeneralSecurityException("Unknown output prefix type");
    }
}
