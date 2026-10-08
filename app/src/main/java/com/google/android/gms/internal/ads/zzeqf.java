package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzeqf implements zzgtq {
    static final /* synthetic */ zzeqf zza = new zzeqf();

    private /* synthetic */ zzeqf() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        return ((Throwable) obj) instanceof TimeoutException ? zzgui.zza(new zzeqi(Integer.toString(17))) : zzgui.zza(new zzeqi(null));
    }
}
