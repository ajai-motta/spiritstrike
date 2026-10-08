package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhig {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhdp zzc;
    private static final zzhdp zzd;
    private static final zzhfi zze;
    private static final zzhff zzf;
    private static final zzhec zzg;
    private static final zzhdz zzh;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzhszVarZza;
        zzhdo zzhdoVarZza = zzhdp.zza();
        zzhdoVarZza.zza(zzhlt.RAW, zzhhe.zzd);
        zzhdoVarZza.zza(zzhlt.TINK, zzhhe.zza);
        zzhdoVarZza.zza(zzhlt.LEGACY, zzhhe.zzc);
        zzhdoVarZza.zza(zzhlt.CRUNCHY, zzhhe.zzb);
        zzc = zzhdoVarZza.zzb();
        zzhdo zzhdoVarZza2 = zzhdp.zza();
        zzhdoVarZza2.zza(zzhko.SHA1, zzhhd.zza);
        zzhdoVarZza2.zza(zzhko.SHA224, zzhhd.zzb);
        zzhdoVarZza2.zza(zzhko.SHA256, zzhhd.zzc);
        zzhdoVarZza2.zza(zzhko.SHA384, zzhhd.zzd);
        zzhdoVarZza2.zza(zzhko.SHA512, zzhhd.zze);
        zzd = zzhdoVarZza2.zzb();
        zze = zzhfi.zzd(zzhif.zza, zzhhf.class, zzhfx.class);
        zzf = zzhff.zzd(zzhic.zza, zzhszVarZza, zzhfx.class);
        zzg = zzhec.zzd(zzhid.zza, zzhgw.class, zzhfw.class);
        zzh = zzhdz.zzd(zzhie.zza, zzhszVarZza, zzhfw.class);
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zze);
        zzhfbVar.zze(zzf);
        zzhfbVar.zzb(zzg);
        zzhfbVar.zzc(zzh);
    }

    static /* synthetic */ zzhfx zzb(zzhhf zzhhfVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.HmacKey");
        zzhkr zzhkrVarZze = zzhks.zze();
        zzhkrVarZze.zza(zzf(zzhhfVar));
        zzhkrVarZze.zzb(zzhhfVar.zzc());
        zzhkzVarZze.zzb(((zzhks) zzhkrVarZze.zzbu()).zzaM());
        zzhkzVarZze.zzc((zzhlt) zzc.zzb(zzhhfVar.zzf()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    static /* synthetic */ zzhhf zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            String strZza = zzhfxVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhks zzhksVarZzd = zzhks.zzd(zzhfxVar.zzc().zzb(), zzhvy.zza());
            if (zzhksVarZzd.zzc() != 0) {
                int iZzc = zzhksVarZzd.zzc();
                StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 47);
                sb.append("Parsing HmacParameters failed: unknown Version ");
                sb.append(iZzc);
                throw new GeneralSecurityException(sb.toString());
            }
            zzhhc zzhhcVarZzb = zzhhf.zzb();
            zzhhcVarZzb.zza(zzhksVarZzd.zzb());
            zzhhcVarZzb.zzb(zzhksVarZzd.zza().zzb());
            zzhhcVarZzb.zzd((zzhhd) zzd.zzc(zzhksVarZzd.zza().zza()));
            zzhhcVarZzb.zzc((zzhhe) zzc.zzc(zzhfxVar.zzc().zzc()));
            return zzhhcVarZzb.zze();
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing HmacParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhfw zzd(zzhgw zzhgwVar, zzgwn zzgwnVar) {
        zzhkp zzhkpVarZze = zzhkq.zze();
        zzhkpVarZze.zza(zzf(zzhgwVar.zzf()));
        byte[] bArrZzc = zzhgwVar.zzd().zzc(zzgwnVar);
        zzhkpVarZze.zzb(zzhvi.zzr(bArrZzc, 0, bArrZzc.length));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.HmacKey", ((zzhkq) zzhkpVarZze.zzbu()).zzaM(), zzhkw.SYMMETRIC, (zzhlt) zzc.zzb(zzhgwVar.zzf().zzf()), zzhgwVar.zzb());
    }

    static /* synthetic */ zzhgw zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
        try {
            zzhkq zzhkqVarZzd = zzhkq.zzd(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhkqVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhhc zzhhcVarZzb = zzhhf.zzb();
            zzhhcVarZzb.zza(zzhkqVarZzd.zzc().zzc());
            zzhhcVarZzb.zzb(zzhkqVarZzd.zzb().zzb());
            zzhhcVarZzb.zzd((zzhhd) zzd.zzc(zzhkqVarZzd.zzb().zza()));
            zzhhcVarZzb.zzc((zzhhe) zzc.zzc(zzhfwVar.zzd()));
            zzhhf zzhhfVarZze = zzhhcVarZzb.zze();
            zzhgv zzhgvVarZzc = zzhgw.zzc();
            zzhgvVarZzc.zza(zzhhfVarZze);
            zzhgvVarZzc.zzb(zzhtb.zza(zzhkqVarZzd.zzc().zzv(), zzgwnVar));
            zzhgvVarZzc.zzc(zzhfwVar.zze());
            return zzhgvVarZzc.zzd();
        } catch (zzhxd | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing HmacKey failed");
        }
    }

    private static zzhku zzf(zzhhf zzhhfVar) throws GeneralSecurityException {
        zzhkt zzhktVarZzc = zzhku.zzc();
        zzhktVarZzc.zzb(zzhhfVar.zzd());
        zzhktVarZzc.zza((zzhko) zzd.zzb(zzhhfVar.zzg()));
        return (zzhku) zzhktVarZzc.zzbu();
    }
}
