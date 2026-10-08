package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgve extends zzgtz {
    private ListenableFuture zza;
    private ScheduledFuture zzb;

    static ListenableFuture zze(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzgve zzgveVar = new zzgve(listenableFuture);
        zzgvc zzgvcVar = new zzgvc(zzgveVar);
        zzgveVar.zzb = scheduledExecutorService.schedule(zzgvcVar, j, timeUnit);
        listenableFuture.addListener(zzgvcVar, zzgtx.INSTANCE);
        return zzgveVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    protected final void zzc() {
        zzm(this.zza);
        ScheduledFuture scheduledFuture = this.zzb;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zza = null;
        this.zzb = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgtb
    protected final String zzd() {
        ListenableFuture listenableFuture = this.zza;
        ScheduledFuture scheduledFuture = this.zzb;
        if (listenableFuture == null) {
            return null;
        }
        String string = listenableFuture.toString();
        StringBuilder sb = new StringBuilder(string.length() + 14);
        sb.append("inputFuture=[");
        sb.append(string);
        sb.append("]");
        String string2 = sb.toString();
        if (scheduledFuture == null) {
            return string2;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return string2;
        }
        StringBuilder sb2 = new StringBuilder(string2.length() + 19 + String.valueOf(delay).length() + 4);
        sb2.append(string2);
        sb2.append(", remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    final /* synthetic */ ListenableFuture zzf() {
        return this.zza;
    }

    final /* synthetic */ ScheduledFuture zzx() {
        return this.zzb;
    }

    final /* synthetic */ void zzy(ScheduledFuture scheduledFuture) {
        this.zzb = null;
    }

    private zzgve(ListenableFuture listenableFuture) {
        listenableFuture.getClass();
        this.zza = listenableFuture;
    }
}
