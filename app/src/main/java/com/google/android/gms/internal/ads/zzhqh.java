package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhqh {
    public static final /* synthetic */ int zza = 0;
    private static final zzhsz zzb;
    private static final zzhsz zzc;
    private static final zzhfi zzd;
    private static final zzhff zze;
    private static final zzhec zzf;
    private static final zzhdz zzg;
    private static final zzhec zzh;
    private static final zzhdz zzi;
    private static final zzhdp zzj;

    static {
        zzhsz zzhszVarZza = zzhgi.zza("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
        zzb = zzhszVarZza;
        zzhsz zzhszVarZza2 = zzhgi.zza("type.googleapis.com/google.crypto.tink.Ed25519PublicKey");
        zzc = zzhszVarZza2;
        zzd = zzhfi.zzd(zzhqg.zza, zzhnl.class, zzhfx.class);
        zze = zzhff.zzd(zzhqb.zza, zzhszVarZza, zzhfx.class);
        zzf = zzhec.zzd(zzhqc.zza, zzhns.class, zzhfw.class);
        zzg = zzhdz.zzd(zzhqd.zza, zzhszVarZza2, zzhfw.class);
        zzh = zzhec.zzd(zzhqe.zza, zzhnm.class, zzhfw.class);
        zzi = zzhdz.zzd(zzhqf.zza, zzhszVarZza, zzhfw.class);
        zzhdo zzhdoVarZza = zzhdp.zza();
        zzhdoVarZza.zza(zzhlt.RAW, zzhnk.zzd);
        zzhdoVarZza.zza(zzhlt.TINK, zzhnk.zza);
        zzhdoVarZza.zza(zzhlt.CRUNCHY, zzhnk.zzb);
        zzhdoVarZza.zza(zzhlt.LEGACY, zzhnk.zzc);
        zzj = zzhdoVarZza.zzb();
    }

    public static void zza(zzhfb zzhfbVar) throws GeneralSecurityException {
        zzhfbVar.zzd(zzd);
        zzhfbVar.zze(zze);
        zzhfbVar.zzb(zzf);
        zzhfbVar.zzc(zzg);
        zzhfbVar.zzb(zzh);
        zzhfbVar.zzc(zzi);
    }

    static /* synthetic */ zzhfx zzb(zzhnl zzhnlVar) {
        zzhkz zzhkzVarZze = zzhla.zze();
        zzhkzVarZze.zza("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
        zzhkzVarZze.zzb(zzhki.zzc().zzaM());
        zzhkzVarZze.zzc((zzhlt) zzj.zzb(zzhnlVar.zzc()));
        return zzhfx.zza((zzhla) zzhkzVarZze.zzbu());
    }

    static /* synthetic */ zzhnl zzc(zzhfx zzhfxVar) throws GeneralSecurityException {
        if (!zzhfxVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey")) {
            String strZza = zzhfxVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            if (zzhki.zzb(zzhfxVar.zzc().zzb(), zzhvy.zza()).zza() == 0) {
                return zzhnl.zzb((zzhnk) zzj.zzc(zzhfxVar.zzc().zzc()));
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhxd e) {
            throw new GeneralSecurityException("Parsing Ed25519Parameters failed: ", e);
        }
    }

    static /* synthetic */ zzhns zze(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.Ed25519PublicKey")) {
            String strZzg = zzhfwVar.zzg();
            String.valueOf(strZzg);
            throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parsePublicKey: ".concat(String.valueOf(strZzg)));
        }
        try {
            zzhkm zzhkmVarZzc = zzhkm.zzc(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhkmVarZzc.zza() == 0) {
                return zzhns.zzc((zzhnk) zzj.zzc(zzhfwVar.zzd()), zzhsz.zza(zzhkmVarZzc.zzb().zzv()), zzhfwVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhxd unused) {
            throw new GeneralSecurityException("Parsing Ed25519PublicKey failed");
        }
    }

    static /* synthetic */ zzhfw zzf(zzhnm zzhnmVar, zzgwn zzgwnVar) {
        zzhkj zzhkjVarZze = zzhkk.zze();
        zzhkjVarZze.zzb(zzh(zzhnmVar.zze()));
        byte[] bArrZzc = zzhnmVar.zzf().zzc(zzgwnVar);
        zzhkjVarZze.zza(zzhvi.zzr(bArrZzc, 0, bArrZzc.length));
        return zzhfw.zza("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey", ((zzhkk) zzhkjVarZze.zzbu()).zzaM(), zzhkw.ASYMMETRIC_PRIVATE, (zzhlt) zzj.zzb(zzhnmVar.zzd().zzc()), zzhnmVar.zze().zzb());
    }

    static /* synthetic */ zzhnm zzg(zzhfw zzhfwVar, zzgwn zzgwnVar) throws GeneralSecurityException {
        if (!zzhfwVar.zzg().equals("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey")) {
            String strZzg = zzhfwVar.zzg();
            String.valueOf(strZzg);
            throw new IllegalArgumentException("Wrong type URL in call to Ed25519ProtoSerialization.parsePrivateKey: ".concat(String.valueOf(strZzg)));
        }
        try {
            zzhkk zzhkkVarZzd = zzhkk.zzd(zzhfwVar.zzb(), zzhvy.zza());
            if (zzhkkVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhkm zzhkmVarZzc = zzhkkVarZzd.zzc();
            if (zzhkmVarZzc.zza() == 0) {
                return zzhnm.zzc(zzhns.zzc((zzhnk) zzj.zzc(zzhfwVar.zzd()), zzhsz.zza(zzhkmVarZzc.zzb().zzv()), zzhfwVar.zze()), zzhtb.zza(zzhkkVarZzd.zzb().zzv(), zzgwnVar));
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzhxd unused) {
            throw new GeneralSecurityException("Parsing Ed25519PrivateKey failed");
        }
    }

    private static zzhkm zzh(zzhns zzhnsVar) {
        zzhkl zzhklVarZzd = zzhkm.zzd();
        byte[] bArrZzc = zzhnsVar.zzd().zzc();
        zzhklVarZzd.zza(zzhvi.zzr(bArrZzc, 0, bArrZzc.length));
        return (zzhkm) zzhklVarZzd.zzbu();
    }
}
