package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfkd {
    public static final zzfkj zza(ListenableFuture listenableFuture, Object obj, zzfkk zzfkkVar) {
        return new zzfkj(zzfkkVar, obj, null, zzfkk.zza, Collections.emptyList(), listenableFuture, null);
    }

    public static final zzfkj zzb(Callable callable, Object obj, zzfkk zzfkkVar) {
        return zzc(callable, zzfkkVar.zze(), obj, zzfkkVar);
    }

    public static final zzfkj zzc(Callable callable, zzgus zzgusVar, Object obj, zzfkk zzfkkVar) {
        return new zzfkj(zzfkkVar, obj, null, zzfkk.zza, Collections.emptyList(), zzgusVar.zzc(callable), null);
    }

    public static final zzfkj zzd(final zzfjy zzfjyVar, zzgus zzgusVar, Object obj, zzfkk zzfkkVar) {
        return zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzfkc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws Exception {
                zzfjyVar.zza();
                return null;
            }
        }, zzgusVar, obj, zzfkkVar);
    }
}
