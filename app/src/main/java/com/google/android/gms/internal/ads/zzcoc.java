package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzcoc implements zzgtq {
    static final /* synthetic */ zzcoc zza = new zzcoc();

    private /* synthetic */ zzcoc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        Throwable th = (Throwable) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlv)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzi(th, "GetTopicsApiWithRecordObservationActionHandlerUnsampled");
        } else {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "GetTopicsApiWithRecordObservationActionHandler");
        }
        return zzgui.zza(new GetTopicsResponse(zzgpe.zzi()));
    }
}
