package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgml extends zzgmq {
    zzgml(zzgms zzgmsVar, CharSequence charSequence, int i) {
        super(zzgmsVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzc(int i) {
        int i2 = i + 4000;
        if (i2 < this.zzb.length()) {
            return i2;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgmq
    public final int zzd(int i) {
        return i;
    }
}
