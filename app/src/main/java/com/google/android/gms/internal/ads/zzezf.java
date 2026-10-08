package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzezf implements zzeya {
    private final Executor zza;
    private final String zzb;

    public zzezf(zzcbb zzcbbVar, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zza = executor;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza = zzgui.zza(this.zzb);
        zzeze zzezeVar = zzeze.zza;
        Executor executor = this.zza;
        return zzgui.zzh(zzgui.zzk(listenableFutureZza, zzezeVar, executor), Throwable.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzezd
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 41;
    }

    final /* synthetic */ ListenableFuture zzc(Throwable th) {
        return zzgui.zza(new zzezg(this.zzb));
    }
}
