package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzgxi implements zzheq {
    static final /* synthetic */ zzgxi zza = new zzgxi();

    private /* synthetic */ zzgxi() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzgxp zzgxpVar = (zzgxp) zzgwjVar;
        int i = zzgxl.zza;
        if (zzgxpVar.zzc() != 16 && zzgxpVar.zzc() != 32) {
            throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
        }
        zzgxg zzgxgVar = new zzgxg(null);
        zzgxgVar.zza(zzgxpVar);
        zzgxgVar.zzd(num);
        zzgxgVar.zzb(zzhtb.zzb(zzgxpVar.zzc()));
        zzgxgVar.zzc(zzhtb.zzb(zzgxpVar.zzd()));
        return zzgxgVar.zze();
    }
}
