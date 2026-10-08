package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhia implements zzhgs {
    public zzhia(zzhgk zzhgkVar) {
    }

    public static zzhgs zza(zzhgk zzhgkVar) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerZza = zzhdc.zza();
        if (providerZza != null) {
            try {
                return zzhhz.zza(zzhgkVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzhia(zzhgkVar);
    }
}
