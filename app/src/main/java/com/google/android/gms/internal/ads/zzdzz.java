package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzdzz implements zzgtq {
    static final /* synthetic */ zzdzz zza = new zzdzz();

    private /* synthetic */ zzdzz() {
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        ExecutionException executionException = (ExecutionException) obj;
        Throwable cause = executionException.getCause();
        ExecutionException cause2 = executionException;
        if (cause != null) {
            cause2 = executionException.getCause();
        }
        return zzgui.zzc(cause2);
    }
}
