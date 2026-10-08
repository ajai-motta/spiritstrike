package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhbi {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhfi zzc;
    private static final zzhff zzd;
    private static final zzhec zze;
    private static final zzhdz zzf;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzhszVarZza;
        zzc = zzhfi.zzd(zzhbh.zza, zzgyg.class, zzhfx.class);
        zzd = zzhff.zzd(zzhbe.zza, zzhszVarZza, zzhfx.class);
        zze = zzhec.zzd(zzhbf.zza, zzgxz.class, zzhfw.class);
        zzf = zzhdz.zzd(zzhbg.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzc);
        zzhfbVar.zze(zzd);
        zzhfbVar.zzb(zze);
        zzhfbVar.zzc(zzf);
    }

    static /* synthetic */ zzhfx zzb(zzgyg zzgygVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzhjo zzhjoVarZzd = zzhjp.zzd();
        zzhjoVarZzd.zza(zzgygVar.zzc());
        zzhkzVarZze.zzb(((zzhjp) zzhjoVarZzd.zzbu()).zzaM());
        zzhkzVarZze.zzc(zzf(zzgygVar.zzd()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    static /* synthetic */ zzgyg zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            String strZza = zzhfxVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhjp zzhjpVarZzc = zzhjp.zzc(zzhfxVar.zzc().zzb(), zzhvy.zza());
            if (zzhjpVarZzc.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzgye zzgyeVarZzb = zzgyg.zzb();
            zzgyeVarZzb.zza(zzhjpVarZzc.zza());
            zzgyeVarZzb.zzb(12);
            zzgyeVarZzb.zzc(16);
            zzgyeVarZzb.zzd(zzg(zzhfxVar.zzc().zzc()));
            return zzgyeVarZzb.zze();
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhfw zzd(zzgxz zzgxzVar, zzgwn zzgwnVar) {
        zzhjm zzhjmVarZzd = zzhjn.zzd();
        byte[] bArrZzc = zzgxzVar.zze().zzc(zzgwnVar);
        zzhjmVarZzd.zza(zzhvi.zzr(bArrZzc, 0, bArrZzc.length));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.AesGcmKey", ((zzhjn) zzhjmVarZzd.zzbu()).zzaM(), zzhkw.SYMMETRIC, zzf(zzgxzVar.zzf().zzd()), zzgxzVar.zzb());
    }

    static /* synthetic */ zzgxz zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmProtoSerialization.parseKey");
        }
        try {
            zzhjn zzhjnVarZzc = zzhjn.zzc(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhjnVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzgye zzgyeVarZzb = zzgyg.zzb();
            zzgyeVarZzb.zza(zzhjnVarZzc.zzb().zzc());
            zzgyeVarZzb.zzb(12);
            zzgyeVarZzb.zzc(16);
            zzgyeVarZzb.zzd(zzg(zzhfwVar.zzd()));
            zzgyg zzgygVarZze = zzgyeVarZzb.zze();
            zzgxy zzgxyVarZzd = zzgxz.zzd();
            zzgxyVarZzd.zza(zzgygVarZze);
            zzgxyVarZzd.zzb(zzhtb.zza(zzhjnVarZzc.zzb().zzv(), zzgwnVar));
            zzgxyVarZzd.zzc(zzhfwVar.zze());
            return zzgxyVarZzd.zzd();
        } catch (zzhxd unused) {
            throw new GeneralSecurityException("Parsing AesGcmKey failed");
        }
    }

    private static zzhlt zzf(zzgyf zzgyfVar) throws GeneralSecurityException {
        if (zzgyf.zza.equals(zzgyfVar)) {
            return zzhlt.TINK;
        }
        if (zzgyf.zzb.equals(zzgyfVar)) {
            return zzhlt.CRUNCHY;
        }
        if (zzgyf.zzc.equals(zzgyfVar)) {
            return zzhlt.RAW;
        }
        String strValueOf = String.valueOf(zzgyfVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzgyf zzg(zzhlt zzhltVar) throws GeneralSecurityException {
        int iOrdinal = zzhltVar.ordinal();
        if (iOrdinal == 1) {
            return zzgyf.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzgyf.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhltVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzgyf.zzb;
    }
}
