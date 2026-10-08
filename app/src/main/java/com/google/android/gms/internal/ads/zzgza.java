package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzgza implements zzhfo {
    static final /* synthetic */ zzgza zza = new zzgza();

    private /* synthetic */ zzgza() {
    }

    @Override // com.google.android.gms.internal.ads.zzhfo
    public final /* synthetic */ Object zza(zzgvt zzgvtVar) throws GeneralSecurityException {
        zzgzl zzgzlVar = (zzgzl) zzgvtVar;
        int i = zzgzc.zza;
        String strZzb = zzgzlVar.zze().zzb();
        zzgxb zzgxbVarZzd = zzgzlVar.zze().zzd();
        zzgvm zzgvmVarZzb = zzgwh.zza(strZzb).zzb();
        int i2 = zzgyz.zza;
        try {
            return zzhce.zzc(new zzgyz(zzhla.zzd(zzgwp.zza(zzgxbVarZzd), zzhvy.zza()), zzgvmVarZzb), zzgzlVar.zzc());
        } catch (zzhxd e) {
            throw new GeneralSecurityException(e);
        }
    }
}
