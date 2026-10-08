package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcud {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcud(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    public final void zza(zzguf zzgufVar) {
        zzgui.zzr(this.zzc, new zzctx(this, zzgufVar), this.zza);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    final /* synthetic */ ListenableFuture zzc(zzguf zzgufVar, ListenableFuture listenableFuture, zzcto zzctoVar) {
        if (zzctoVar != null) {
            zzgufVar.zzb(zzctoVar);
        }
        return zzgui.zzi(listenableFuture, ((Long) zzbhi.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    final /* synthetic */ void zze(List list, final zzguf zzgufVar) {
        if (list == null || list.isEmpty()) {
            this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcuc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzgufVar.zza(new zzdzv(3));
                }
            });
            return;
        }
        ListenableFuture listenableFutureZza = zzgui.zza(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final ListenableFuture listenableFuture = (ListenableFuture) it.next();
            zzgtq zzgtqVar = new zzgtq() { // from class: com.google.android.gms.internal.ads.zzctz
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    zzgufVar.zza((Throwable) obj);
                    return zzgui.zza(null);
                }
            };
            Executor executor = this.zza;
            listenableFutureZza = zzgui.zzj(zzgui.zzh(listenableFutureZza, Throwable.class, zzgtqVar, executor), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzcua
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzc(zzgufVar, listenableFuture, (zzcto) obj);
                }
            }, executor);
        }
        zzgui.zzr(listenableFutureZza, new zzcty(this, zzgufVar), this.zza);
    }

    final /* synthetic */ void zzf() {
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcub
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        });
    }
}
