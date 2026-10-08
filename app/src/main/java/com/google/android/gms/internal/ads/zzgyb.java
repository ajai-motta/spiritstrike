package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzgyb implements zzheq {
    static final /* synthetic */ zzgyb zza = new zzgyb();

    private /* synthetic */ zzgyb() {
    }

    @Override // com.google.android.gms.internal.ads.zzheq
    public final /* synthetic */ zzgvt zza(zzgwj zzgwjVar, Integer num) throws GeneralSecurityException {
        zzgyg zzgygVar = (zzgyg) zzgwjVar;
        int i = zzgyd.zza;
        if (zzgygVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
        }
        zzgxy zzgxyVar = new zzgxy(null);
        zzgxyVar.zza(zzgygVar);
        zzgxyVar.zzc(num);
        zzgxyVar.zzb(zzhtb.zzb(zzgygVar.zzc()));
        return zzgxyVar.zzd();
    }
}
