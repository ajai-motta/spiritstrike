package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgjd {
    private final zzfzn zza;
    private final zzfxa zzb;

    zzgjd(zzfxa zzfxaVar, zzfzn zzfznVar) {
        this.zza = zzfznVar;
        this.zzb = zzfxaVar;
    }

    public final zzgjb zza(int i) {
        return new zzgjb(i, this.zzb, this.zza);
    }

    public final void zzb(int i) {
        this.zza.zzb(i - 1, -1L, null, null);
    }

    public final void zzc(int i, String str) {
        this.zza.zzb(i - 1, -1L, null, str);
    }

    public final void zzd(int i, Throwable th) {
        this.zza.zzb(i - 1, -1L, th, null);
    }

    public final ListenableFuture zze(int i, ListenableFuture listenableFuture) {
        zzgjb zzgjbVarZza = zza(i);
        zzgjbVarZza.zza();
        zzgui.zzr(listenableFuture, new zzgjc(this, zzgjbVarZza), zzguz.zza());
        return listenableFuture;
    }

    public final void zzf(int i, Runnable runnable) {
        try {
            zza(i).zza();
            runnable.run();
        } finally {
        }
    }
}
