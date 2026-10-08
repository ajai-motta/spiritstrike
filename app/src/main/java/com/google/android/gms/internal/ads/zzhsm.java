package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhsm implements zzhik {
    public static zzhik zzb(zzhii zzhiiVar) throws GeneralSecurityException {
        zzhik zzhikVarZzb = zzhio.zzb(zzhiiVar);
        try {
            return new zzhsl(zzhikVarZzb, zzhip.zzb(zzhiiVar), null);
        } catch (GeneralSecurityException unused) {
            return zzhikVarZzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhik
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        throw null;
    }
}
