package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgzu {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhfi zzc;
    private static final zzhff zzd;
    private static final zzhec zze;
    private static final zzhdz zzf;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zzhszVarZza;
        zzc = zzhfi.zzd(zzgzt.zza, zzgzp.class, zzhfx.class);
        zzd = zzhff.zzd(zzgzq.zza, zzhszVarZza, zzhfx.class);
        zze = zzhec.zzd(zzgzr.zza, zzgzl.class, zzhfw.class);
        zzf = zzhdz.zzd(zzgzs.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzc);
        zzhfbVar.zze(zzd);
        zzhfbVar.zzb(zze);
        zzhfbVar.zzc(zzf);
    }

    static /* synthetic */ zzhfx zzb(zzgzp zzgzpVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzhkzVarZze.zzb(zzg(zzgzpVar).zzaM());
        zzhkzVarZze.zzc(zzf(zzgzpVar.zzc()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    static /* synthetic */ zzgzp zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            String strZza = zzhfxVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            return zzh(zzhls.zzc(zzhfxVar.zzc().zzb(), zzhvy.zza()), zzhfxVar.zzc().zzc());
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    static /* synthetic */ zzhfw zzd(zzgzl zzgzlVar, zzgwn zzgwnVar) {
        zzhlp zzhlpVarZzd = zzhlq.zzd();
        zzhlpVarZzd.zza(zzg(zzgzlVar.zze()));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzhlq) zzhlpVarZzd.zzbu()).zzaM(), zzhkw.REMOTE, zzf(zzgzlVar.zze().zzc()), zzgzlVar.zzb());
    }

    static /* synthetic */ zzgzl zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzhlq zzhlqVarZzc = zzhlq.zzc(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhlqVarZzc.zza() == 0) {
                return zzgzl.zzd(zzh(zzhlqVarZzc.zzb(), zzhfwVar.zzd()), zzhfwVar.zze());
            }
            String strValueOf = String.valueOf(zzhlqVarZzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 58);
            sb.append("KmsEnvelopeAeadKeys are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    private static zzhlt zzf(zzgzo zzgzoVar) throws GeneralSecurityException {
        if (zzgzo.zza.equals(zzgzoVar)) {
            return zzhlt.TINK;
        }
        if (zzgzo.zzb.equals(zzgzoVar)) {
            return zzhlt.RAW;
        }
        String strValueOf = String.valueOf(zzgzoVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzhls zzg(zzgzp zzgzpVar) throws GeneralSecurityException {
        try {
            zzhla zzhlaVarZzd = zzhla.zzd(zzgwp.zza(zzgzpVar.zzd()), zzhvy.zza());
            zzhlr zzhlrVarZzd = zzhls.zzd();
            zzhlrVarZzd.zza(zzgzpVar.zzb());
            zzhlrVarZzd.zzb(zzhlaVarZzd);
            return (zzhls) zzhlrVarZzd.zzbu();
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzgzp zzh(zzhls zzhlsVar, zzhlt zzhltVar) throws GeneralSecurityException {
        zzgzn zzgznVar;
        zzgzo zzgzoVar;
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza(zzhlsVar.zzb().zza());
        zzhkzVarZze.zzb(zzhlsVar.zzb().zzb());
        zzhkzVarZze.zzc(zzhlt.RAW);
        zzgwj zzgwjVarZzb = zzgwp.zzb(((zzhla) zzhkzVarZze.zzbu()).zzaN());
        if (zzgwjVarZzb instanceof zzgyg) {
            zzgznVar = zzgzn.zza;
        } else if (zzgwjVarZzb instanceof zzgyv) {
            zzgznVar = zzgzn.zzc;
        } else if (zzgwjVarZzb instanceof zzhar) {
            zzgznVar = zzgzn.zzb;
        } else if (zzgwjVarZzb instanceof zzgxp) {
            zzgznVar = zzgzn.zzd;
        } else if (zzgwjVarZzb instanceof zzgxx) {
            zzgznVar = zzgzn.zze;
        } else {
            if (!(zzgwjVarZzb instanceof zzgyp)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzgwjVarZzb.toString()));
            }
            zzgznVar = zzgzn.zzf;
        }
        zzgzm zzgzmVar = new zzgzm(null);
        int iOrdinal = zzhltVar.ordinal();
        if (iOrdinal == 1) {
            zzgzoVar = zzgzo.zza;
        } else {
            if (iOrdinal != 3) {
                int iZza = zzhltVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
            zzgzoVar = zzgzo.zzb;
        }
        zzgzmVar.zza(zzgzoVar);
        zzgzmVar.zzb(zzhlsVar.zza());
        zzgzmVar.zzd((zzgxb) zzgwjVarZzb);
        zzgzmVar.zzc(zzgznVar);
        return zzgzmVar.zze();
    }
}
