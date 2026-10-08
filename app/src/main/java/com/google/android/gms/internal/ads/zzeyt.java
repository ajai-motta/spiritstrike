package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzeyt implements zzgtq {
    static final /* synthetic */ zzeyt zza = new zzeyt();

    private /* synthetic */ zzeyt() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (getTopicsResponse == null) {
            return zzgui.zza(new zzeyv("", 1, null));
        }
        zzial zzialVarZzc = zziam.zzc();
        for (Topic topic : getTopicsResponse.getTopics()) {
            zziaj zziajVarZzc = zziak.zzc();
            zziajVarZzc.zza(topic.getTopicId());
            zziajVarZzc.zzb(topic.getModelVersion());
            zziajVarZzc.zzc(topic.getTaxonomyVersion());
            zzialVarZzc.zza((zziak) zziajVarZzc.zzbu());
        }
        return zzgui.zza(new zzeyv(Base64.encodeToString(((zziam) zzialVarZzc.zzbu()).zzaN(), 1), 1, null));
    }
}
