package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzgua extends zzguj {
    zzgua() {
    }

    public static zzgua zzw(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzgua ? (zzgua) listenableFuture : new zzgub(listenableFuture);
    }
}
