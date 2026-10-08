package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhsv implements zzgwm {
    static final zzhdp zza;
    private static final byte[] zzb;
    private static final byte[] zzc;

    static {
        zzhdo zzhdoVarZza = zzhdp.zza();
        zzhdoVarZza.zza(zzhsi.SHA256, zzhpd.zza);
        zzhdoVarZza.zza(zzhsi.SHA384, zzhpd.zzb);
        zzhdoVarZza.zza(zzhsi.SHA512, zzhpd.zzc);
        zza = zzhdoVarZza.zzb();
        zzb = new byte[0];
        zzc = new byte[]{0};
    }

    public static zzgwm zzb(zzhpj zzhpjVar) throws GeneralSecurityException {
        try {
            return zzhrd.zze(zzhpjVar);
        } catch (NoSuchProviderException unused) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) ((KeyFactory) zzhrz.zzf.zzb("RSA")).generatePublic(new RSAPublicKeySpec(zzhpjVar.zzd(), zzhpjVar.zzf().zzd()));
            zzhpf zzhpfVarZzf = zzhpjVar.zzf();
            zzhdp zzhdpVar = zza;
            return new zzhsu(rSAPublicKey, (zzhsi) zzhdpVar.zzb(zzhpfVarZzf.zzf()), (zzhsi) zzhdpVar.zzb(zzhpfVarZzf.zzg()), zzhpfVarZzf.zzh(), zzhpjVar.zze().zzc(), zzhpjVar.zzf().zze().equals(zzhpe.zzc) ? zzc : zzb, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
