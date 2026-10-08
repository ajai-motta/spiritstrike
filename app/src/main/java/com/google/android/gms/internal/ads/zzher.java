package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzher implements zzheq {
    static final /* synthetic */ zzher zza = new zzher();

    private /* synthetic */ zzher() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        int i = zzhes.zza;
        zzhla zzhlaVarZzc = ((zzhej) zzgwjVar).zzb().zzc();
        zzgvu zzgvuVarZzd = zzhdw.zza().zzd(zzhlaVarZzc.zza());
        if (!zzhdw.zza().zze(zzhlaVarZzc.zza())) {
            throw new GeneralSecurityException("Creating new keys is not allowed.");
        }
        zzhkx zzhkxVarZzd = zzgvuVarZzd.zzd(zzhlaVarZzc.zzb());
        return new zzhei(zzhfw.zza(zzhkxVarZzd.zza(), zzhkxVarZzd.zzb(), zzhkxVarZzd.zzc(), zzhlaVarZzc.zzc(), num), zzgvr.zza());
    }
}
