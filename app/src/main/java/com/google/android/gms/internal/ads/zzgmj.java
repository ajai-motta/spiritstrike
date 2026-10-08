package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgmj extends zzgmq {
    final /* synthetic */ zzglr zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgmj(zzgms zzgmsVar, CharSequence charSequence, zzglr zzglrVar) {
        super(zzgmsVar, charSequence);
        this.zza = zzglrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    final int zzc(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzgmd.zzn(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (this.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    final int zzd(int i) {
        return i + 1;
    }
}
