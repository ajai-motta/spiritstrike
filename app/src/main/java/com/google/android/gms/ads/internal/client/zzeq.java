package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeq extends zzcd {
    final /* synthetic */ PreloadCallback zza;

    zzeq(zzex zzexVar, PreloadCallback preloadCallback) {
        this.zza = preloadCallback;
        Objects.requireNonNull(zzexVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zze(zzft zzftVar) {
        PreloadConfiguration preloadConfigurationZzr = com.google.android.gms.ads.internal.util.client.zzf.zzr(zzftVar);
        if (preloadConfigurationZzr != null) {
            this.zza.onAdsAvailable(preloadConfigurationZzr);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final void zzf(zzft zzftVar) {
        PreloadConfiguration preloadConfigurationZzr = com.google.android.gms.ads.internal.util.client.zzf.zzr(zzftVar);
        if (preloadConfigurationZzr != null) {
            this.zza.onAdsExhausted(preloadConfigurationZzr);
        }
    }
}
