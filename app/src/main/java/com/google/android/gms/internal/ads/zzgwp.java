package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgwp {
    public static byte[] zza(zzgwj zzgwjVar) throws GeneralSecurityException {
        return ((zzhfx) zzhfb.zza().zzk(zzgwjVar, zzhfx.class)).zzc().zzaN();
    }

    public static zzgwj zzb(byte[] bArr) throws GeneralSecurityException {
        try {
            zzhla zzhlaVarZzd = zzhla.zzd(bArr, zzhvy.zza());
            zzhfb zzhfbVarZza = zzhfb.zza();
            zzhfx zzhfxVarZzb = zzhfx.zzb(zzhlaVarZzd);
            return !zzhfbVarZza.zzi(zzhfxVarZzb) ? new zzhej(zzhfxVarZzb) : zzhfbVarZza.zzj(zzhfxVarZzb);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }
}
