package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzgxt implements zzheq {
    static final /* synthetic */ zzgxt zza = new zzgxt();

    private /* synthetic */ zzgxt() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzgxx zzgxxVar = (zzgxx) zzgwjVar;
        int i = zzgxu.zza;
        if (zzgxxVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzgxq zzgxqVar = new zzgxq(null);
        zzgxqVar.zza(zzgxxVar);
        zzgxqVar.zzc(num);
        zzgxqVar.zzb(zzhtb.zzb(zzgxxVar.zzc()));
        return zzgxqVar.zzd();
    }
}
