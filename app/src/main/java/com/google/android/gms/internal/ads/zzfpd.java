package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfpd extends TimerTask {
    final /* synthetic */ zzfpf zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ zzfpg zzc;

    zzfpd(zzfpg zzfpgVar, zzfpf zzfpfVar, Timer timer) {
        this.zza = zzfpfVar;
        this.zzb = timer;
        Objects.requireNonNull(zzfpgVar);
        this.zzc = zzfpgVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzc.zze();
        this.zza.zza(true);
        this.zzb.cancel();
    }
}
