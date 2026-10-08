package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzehi {
    private final Context zza;

    zzehi(Context context) {
        this.zza = context;
    }

    public final ListenableFuture zza(boolean z) {
        try {
            GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setAdsSdkName(MobileAds.ERROR_DOMAIN).setShouldRecordObservation(z).build();
            TopicsManagerFutures topicsManagerFuturesFrom = TopicsManagerFutures.from(this.zza);
            return topicsManagerFuturesFrom != null ? topicsManagerFuturesFrom.getTopicsAsync(getTopicsRequestBuild) : zzgui.zzc(new IllegalStateException());
        } catch (Exception e) {
            return zzgui.zzc(e);
        }
    }
}
