package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzerk implements zzgtq {
    static final /* synthetic */ zzerk zza = new zzerk();

    private /* synthetic */ zzerk() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return appSetIdInfo == null ? zzgui.zza(new zzero(null, -1)) : zzgui.zza(new zzero(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
