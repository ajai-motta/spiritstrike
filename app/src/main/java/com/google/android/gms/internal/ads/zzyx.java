package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzyx {
    private final Handler zza;
    private final zzyz zzb;
    private boolean zzc;

    public zzyx(Handler handler, zzyz zzyzVar) {
        this.zza = handler;
        this.zzb = zzyzVar;
    }

    public final void zza() {
        this.zzc = true;
    }

    final /* synthetic */ Handler zzb() {
        return this.zza;
    }

    final /* synthetic */ zzyz zzc() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzd() {
        return this.zzc;
    }
}
