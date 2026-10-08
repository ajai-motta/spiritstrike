package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.RSAPublicKeySpec;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhrd implements zzgwm {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = {0};
    private final RSAPublicKey zzc;
    private final String zzd;
    private final PSSParameterSpec zze;
    private final byte[] zzf;
    private final byte[] zzg;
    private final Provider zzh;

    private zzhrd(RSAPublicKey rSAPublicKey, zzhpd zzhpdVar, zzhpd zzhpdVar2, int i, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhcy.zza(2)) {
            throw new GeneralSecurityException("Cannot use RSA SSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        if (!zzhpdVar.equals(zzhpdVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zzhsx.zzc(rSAPublicKey.getModulus().bitLength());
        zzhsx.zzd(rSAPublicKey.getPublicExponent());
        this.zzc = rSAPublicKey;
        this.zzd = zzc(zzhpdVar);
        this.zze = zzd(zzhpdVar, zzhpdVar2, i);
        this.zzf = bArr;
        this.zzg = bArr2;
        this.zzh = provider;
    }

    @Nullable
    static Provider zzb() {
        if (!zzhgi.zzc() || zzhgi.zzd().intValue() > 23) {
            return zzhdc.zza();
        }
        return null;
    }

    static String zzc(zzhpd zzhpdVar) {
        if (zzhpdVar == zzhpd.zza) {
            return "SHA256withRSA/PSS";
        }
        if (zzhpdVar == zzhpd.zzb) {
            return "SHA384withRSA/PSS";
        }
        if (zzhpdVar == zzhpd.zzc) {
            return "SHA512withRSA/PSS";
        }
        String strValueOf = String.valueOf(zzhpdVar);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Unsupported hash: ".concat(String.valueOf(strValueOf)));
    }

    static PSSParameterSpec zzd(zzhpd zzhpdVar, zzhpd zzhpdVar2, int i) {
        String str;
        MGF1ParameterSpec mGF1ParameterSpec;
        zzhpd zzhpdVar3 = zzhpd.zza;
        if (zzhpdVar == zzhpdVar3) {
            str = "SHA-256";
        } else if (zzhpdVar == zzhpd.zzb) {
            str = "SHA-384";
        } else {
            if (zzhpdVar != zzhpd.zzc) {
                String strValueOf = String.valueOf(zzhpdVar);
                String.valueOf(strValueOf);
                throw new IllegalArgumentException("Unsupported MD hash: ".concat(String.valueOf(strValueOf)));
            }
            str = "SHA-512";
        }
        String str2 = str;
        if (zzhpdVar2 == zzhpdVar3) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
        } else if (zzhpdVar2 == zzhpd.zzb) {
            mGF1ParameterSpec = MGF1ParameterSpec.SHA384;
        } else {
            if (zzhpdVar2 != zzhpd.zzc) {
                String strValueOf2 = String.valueOf(zzhpdVar2);
                String.valueOf(strValueOf2);
                throw new IllegalArgumentException("Unsupported MGF1 hash: ".concat(String.valueOf(strValueOf2)));
            }
            mGF1ParameterSpec = MGF1ParameterSpec.SHA512;
        }
        return new PSSParameterSpec(str2, "MGF1", mGF1ParameterSpec, i, 1);
    }

    public static zzgwm zze(zzhpj zzhpjVar) throws GeneralSecurityException {
        Provider providerZzb = zzb();
        if (providerZzb == null) {
            throw new NoSuchProviderException("RSA SSA PSS using Conscrypt is not supported.");
        }
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA", providerZzb).generatePublic(new RSAPublicKeySpec(zzhpjVar.zzd(), zzhpjVar.zzf().zzd()));
        zzhpf zzhpfVarZzf = zzhpjVar.zzf();
        return new zzhrd(rSAPublicKey, zzhpfVarZzf.zzf(), zzhpfVarZzf.zzg(), zzhpfVarZzf.zzh(), zzhpjVar.zze().zzc(), zzhpjVar.zzf().zze().equals(zzhpe.zzc) ? zzb : zza, providerZzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzf;
        if (!zzhgi.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
        }
        String str = this.zzd;
        Provider provider = this.zzh;
        RSAPublicKey rSAPublicKey = this.zzc;
        Signature signature = Signature.getInstance(str, provider);
        signature.initVerify(rSAPublicKey);
        signature.setParameter(this.zze);
        signature.update(bArr2);
        byte[] bArr4 = this.zzg;
        if (bArr4.length > 0) {
            signature.update(bArr4);
        }
        int length = bArr.length;
        int length2 = bArr3.length;
        if (!signature.verify(bArr, length2, length - length2)) {
            throw new GeneralSecurityException("signature verification failed");
        }
    }
}
