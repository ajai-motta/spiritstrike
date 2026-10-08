package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzapg extends Thread {
    private static final boolean zza = zzaqg.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzape zzd;
    private volatile boolean zze = false;
    private final zzaqh zzf;
    private final zzapl zzg;

    public zzapg(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzape zzapeVar, zzapl zzaplVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzapeVar;
        this.zzg = zzaplVar;
        this.zzf = new zzaqh(this, blockingQueue2, zzaplVar);
    }

    private void zzc() throws InterruptedException {
        zzapu zzapuVar = (zzapu) this.zzb.take();
        zzapuVar.zzc("cache-queue-take");
        zzapuVar.zze(1);
        try {
            zzapuVar.zzl();
            zzape zzapeVar = this.zzd;
            zzapd zzapdVarZza = zzapeVar.zza(zzapuVar.zzi());
            if (zzapdVarZza == null) {
                zzapuVar.zzc("cache-miss");
                if (!this.zzf.zzc(zzapuVar)) {
                    this.zzc.put(zzapuVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzapdVarZza.zza(jCurrentTimeMillis)) {
                    zzapuVar.zzc("cache-hit-expired");
                    zzapuVar.zzj(zzapdVarZza);
                    if (!this.zzf.zzc(zzapuVar)) {
                        this.zzc.put(zzapuVar);
                    }
                } else {
                    zzapuVar.zzc("cache-hit");
                    zzaqa zzaqaVarZzr = zzapuVar.zzr(new zzapq(zzapdVarZza.zza, zzapdVarZza.zzg));
                    zzapuVar.zzc("cache-hit-parsed");
                    if (!zzaqaVarZzr.zzc()) {
                        zzapuVar.zzc("cache-parsing-failed");
                        zzapeVar.zzd(zzapuVar.zzi(), true);
                        zzapuVar.zzj(null);
                        if (!this.zzf.zzc(zzapuVar)) {
                            this.zzc.put(zzapuVar);
                        }
                    } else if (zzapdVarZza.zzf < jCurrentTimeMillis) {
                        zzapuVar.zzc("cache-hit-refresh-needed");
                        zzapuVar.zzj(zzapdVarZza);
                        zzaqaVarZzr.zzd = true;
                        if (this.zzf.zzc(zzapuVar)) {
                            this.zzg.zza(zzapuVar, zzaqaVarZzr, null);
                        } else {
                            this.zzg.zza(zzapuVar, zzaqaVarZzr, new zzapf(this, zzapuVar));
                        }
                    } else {
                        this.zzg.zza(zzapuVar, zzaqaVarZzr, null);
                    }
                }
            }
        } finally {
            zzapuVar.zze(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzaqg.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzc();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqg.zzc("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zze = true;
        interrupt();
    }

    final /* synthetic */ BlockingQueue zzb() {
        return this.zzc;
    }
}
