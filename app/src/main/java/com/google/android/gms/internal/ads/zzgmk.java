package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgmk extends zzgmq {
    final /* synthetic */ zzgls zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgmk(zzgms zzgmsVar, CharSequence charSequence, zzgls zzglsVar) {
        super(zzgmsVar, charSequence);
        this.zza = zzglsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzc(int i) {
        Matcher matcher = ((zzglv) this.zza).zza;
        if (matcher.find(i)) {
            return matcher.start();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzd(int i) {
        return ((zzglv) this.zza).zza.end();
    }
}
