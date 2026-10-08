package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhpz implements zzgwl {
    private static final byte[] zza = new byte[0];
    private static final byte[] zzb = {0};

    private zzhpz(ECPrivateKey eCPrivateKey, zzhsi zzhsiVar, zzhrs zzhrsVar, byte[] bArr, byte[] bArr2, Provider provider) throws GeneralSecurityException {
        if (!zzhcy.zza(2)) {
            throw new GeneralSecurityException("Can not use ECDSA in FIPS-mode, as BoringCrypto is not available.");
        }
        zzhsw.zza(zzhsiVar);
    }

    public static zzgwl zzb(zzhnd zzhndVar) throws GeneralSecurityException {
        Provider providerZza = zzhdc.zza();
        return new zzhpz((ECPrivateKey) (providerZza != null ? KeyFactory.getInstance("EC", providerZza) : (KeyFactory) zzhrz.zzf.zzb("EC")).generatePrivate(new ECPrivateKeySpec(zzhndVar.zzf().zzb(zzgvr.zza()), zzhrt.zzb((zzhrr) zzhqa.zzc.zzb(zzhndVar.zzd().zzd())))), (zzhsi) zzhqa.zza.zzb(zzhndVar.zzd().zze()), (zzhrs) zzhqa.zzb.zzb(zzhndVar.zzd().zzc()), zzhndVar.zze().zze().zzc(), zzhndVar.zzd().zzf().equals(zzhna.zzc) ? zzb : zza, providerZza);
    }

    @Override // com.google.android.gms.internal.ads.zzgwl
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
