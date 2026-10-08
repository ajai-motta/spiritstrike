package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzezn implements zzeya {
    final zzgus zza;

    public zzezn(zzbdi zzbdiVar, zzgus zzgusVar, Context context) {
        this.zza = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzezm
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzezo(new JSONObject());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 45;
    }
}
