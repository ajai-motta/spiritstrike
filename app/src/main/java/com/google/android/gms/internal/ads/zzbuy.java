package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbuy extends zzbjy {
    private final NativeAd.UnconfirmedClickListener zza;

    public zzbuy(NativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        this.zza = unconfirmedClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    public final void zze(String str) {
        this.zza.onUnconfirmedClickReceived(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbjz
    public final void zzf() {
        this.zza.onUnconfirmedClickCancelled();
    }
}
