package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgzk {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhfi zzc;
    private static final zzhff zzd;
    private static final zzhec zze;
    private static final zzhdz zzf;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzhszVarZza;
        zzc = zzhfi.zzd(zzgzj.zza, zzgzf.class, zzhfx.class);
        zzd = zzhff.zzd(zzgzg.zza, zzhszVarZza, zzhfx.class);
        zze = zzhec.zzd(zzgzh.zza, zzgzd.class, zzhfw.class);
        zzf = zzhdz.zzd(zzgzi.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzc);
        zzhfbVar.zze(zzd);
        zzhfbVar.zzb(zze);
        zzhfbVar.zzc(zzf);
    }

    static /* synthetic */ zzhfx zzb(zzgzf zzgzfVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzhln zzhlnVarZzc = zzhlo.zzc();
        zzhlnVarZzc.zza(zzgzfVar.zzc());
        zzhkzVarZze.zzb(((zzhlo) zzhlnVarZzc.zzbu()).zzaM());
        zzhkzVarZze.zzc(zzf(zzgzfVar.zzd()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    static /* synthetic */ zzgzf zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                return zzgzf.zzb(zzhlo.zzb(zzhfxVar.zzc().zzb(), zzhvy.zza()).zza(), zzg(zzhfxVar.zzc().zzc()));
            } catch (zzhxd e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        }
        String strZza = zzhfxVar.zzc().zza();
        String.valueOf(strZza);
        throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
    }

    static /* synthetic */ zzhfw zzd(zzgzd zzgzdVar, zzgwn zzgwnVar) {
        zzhll zzhllVarZzd = zzhlm.zzd();
        zzhln zzhlnVarZzc = zzhlo.zzc();
        zzhlnVarZzc.zza(zzgzdVar.zze().zzc());
        zzhllVarZzd.zza((zzhlo) zzhlnVarZzc.zzbu());
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey", ((zzhlm) zzhllVarZzd.zzbu()).zzaM(), zzhkw.REMOTE, zzf(zzgzdVar.zze().zzd()), zzgzdVar.zzb());
    }

    static /* synthetic */ zzgzd zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        }
        try {
            zzhlm zzhlmVarZzc = zzhlm.zzc(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhlmVarZzc.zza() == 0) {
                return zzgzd.zzd(zzgzf.zzb(zzhlmVarZzc.zzb().zza(), zzg(zzhfwVar.zzd())), zzhfwVar.zze());
            }
            String strValueOf = String.valueOf(zzhlmVarZzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 49);
            sb.append("KmsAeadKey are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
        }
    }

    private static zzhlt zzf(zzgze zzgzeVar) throws GeneralSecurityException {
        if (zzgze.zza.equals(zzgzeVar)) {
            return zzhlt.TINK;
        }
        if (zzgze.zzb.equals(zzgzeVar)) {
            return zzhlt.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzgzeVar.toString()));
    }

    private static zzgze zzg(zzhlt zzhltVar) throws GeneralSecurityException {
        int iOrdinal = zzhltVar.ordinal();
        if (iOrdinal == 1) {
            return zzgze.zza;
        }
        if (iOrdinal == 3) {
            return zzgze.zzb;
        }
        int iZza = zzhltVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }
}
