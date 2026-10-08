package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzfx;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzee implements zzad {
    private final String zza;
    private final Context zzb;
    private ScheduledFuture zzd;
    private boolean zze;
    private final zzak zzf;
    private String zzg;
    private zzdb zzh;
    private final ScheduledExecutorService zzc = zzfx.zza().zzb(1, 2);
    private final zzed zzi = new zzed(this);

    zzee(Context context, String str, zzak zzakVar, zzec zzecVar, zzed zzedVar) {
        this.zzf = zzakVar;
        this.zzb = context;
        this.zza = str;
    }

    private final synchronized void zzd() {
        if (this.zze) {
            throw new IllegalStateException("called method after closed");
        }
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final synchronized void release() {
        zzd();
        ScheduledFuture scheduledFuture = this.zzd;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzc.shutdown();
        this.zze = true;
    }

    @Override // com.google.android.gms.tagmanager.zzad
    public final synchronized void zza(long j, String str) {
        zzdc.zzb.zzd("loadAfterDelay: containerId=" + this.zza + " delay=" + j);
        zzd();
        if (this.zzh == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        ScheduledFuture scheduledFuture = this.zzd;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        ScheduledExecutorService scheduledExecutorService = this.zzc;
        zzed zzedVar = this.zzi;
        zzak zzakVar = this.zzf;
        zzee zzeeVar = zzedVar.zza;
        zzeb zzebVar = new zzeb(zzeeVar.zzb, zzeeVar.zza, zzakVar);
        zzebVar.zzb(this.zzh);
        zzebVar.zza(this.zzg);
        zzebVar.zzc(str);
        this.zzd = scheduledExecutorService.schedule(zzebVar, j, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.tagmanager.zzad
    public final synchronized void zzb(String str) {
        zzd();
        this.zzg = str;
    }

    @Override // com.google.android.gms.tagmanager.zzad
    public final synchronized void zzc(zzdb zzdbVar) {
        zzd();
        this.zzh = zzdbVar;
    }
}
