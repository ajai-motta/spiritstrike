package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzekf {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzctr zzc;
    private final zzekv zzd;
    private final zzfnc zze;
    private final zzgvb zzf = zzgvb.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzekg zzh;
    private zzfgf zzi;

    zzekf(Executor executor, ScheduledExecutorService scheduledExecutorService, zzctr zzctrVar, zzekv zzekvVar, zzfnc zzfncVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzctrVar;
        this.zzd = zzekvVar;
        this.zze = zzfncVar;
    }

    private final synchronized ListenableFuture zzd(zzffu zzffuVar) {
        Iterator it = zzffuVar.zza.iterator();
        while (it.hasNext()) {
            zzehk zzehkVarZza = this.zzc.zza(zzffuVar.zzb, (String) it.next());
            if (zzehkVarZza != null && zzehkVarZza.zza(this.zzi, zzffuVar)) {
                return zzgui.zzi(zzehkVarZza.zzb(this.zzi, zzffuVar), zzffuVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgui.zzc(new zzdzv(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final void zzb(zzffu zzffuVar) {
        ListenableFuture listenableFutureZzd = zzd(zzffuVar);
        this.zzd.zze(this.zzi, zzffuVar, listenableFutureZzd, this.zze);
        zzgui.zzr(listenableFutureZzd, new zzeke(this, zzffuVar), this.zza);
    }

    public final synchronized ListenableFuture zza(zzfgf zzfgfVar) {
        if (!this.zzg.getAndSet(true)) {
            List list = zzfgfVar.zzb.zza;
            if (list.isEmpty()) {
                this.zzf.zzb(new zzekz(3, zzelc.zzb(zzfgfVar)));
            } else {
                this.zzi = zzfgfVar;
                zzekv zzekvVar = this.zzd;
                this.zzh = new zzekg(zzfgfVar, zzekvVar, this.zzf);
                zzekvVar.zzc(list);
                zzffu zzffuVarZza = this.zzh.zza();
                while (zzffuVarZza != null) {
                    zzb(zzffuVarZza);
                    zzffuVarZza = this.zzh.zza();
                }
            }
        }
        return this.zzf;
    }

    final /* synthetic */ zzekg zzc() {
        return this.zzh;
    }
}
