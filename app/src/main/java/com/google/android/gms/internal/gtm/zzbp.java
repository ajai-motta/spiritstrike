package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbp extends zzbr {
    private final zzcj zza;

    public zzbp(zzbu zzbuVar, zzbv zzbvVar) {
        super(zzbuVar);
        Preconditions.checkNotNull(zzbvVar);
        this.zza = new zzcj(zzbuVar, zzbvVar);
    }

    public final long zza(zzbw zzbwVar) {
        zzV();
        Preconditions.checkNotNull(zzbwVar);
        com.google.android.gms.analytics.zzr.zzh();
        long jZzb = this.zza.zzb(zzbwVar, true);
        if (jZzb != 0) {
            return jZzb;
        }
        this.zza.zzk(zzbwVar);
        return 0L;
    }

    public final void zzc() {
        zzV();
        Context contextZzo = zzo();
        if (!zzev.zzb(contextZzo) || !zzfa.zzh(contextZzo)) {
            zze(null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsService"));
        contextZzo.startService(intent);
    }

    @Override // com.google.android.gms.internal.gtm.zzbr
    protected final void zzd() {
        this.zza.zzW();
    }

    public final void zze(zzcy zzcyVar) {
        zzV();
        zzq().zzi(new zzbn(this, zzcyVar));
    }

    public final void zzf(String str, Runnable runnable) {
        Preconditions.checkNotEmpty(str, "campaign param can't be empty");
        zzq().zzi(new zzbj(this, str, runnable));
    }

    public final void zzg() {
        zzV();
        zzw();
        zzq().zzi(new zzbm(this));
    }

    public final void zzh(zzek zzekVar) {
        Preconditions.checkNotNull(zzekVar);
        zzV();
        zzF("Hit delivery requested", zzekVar);
        zzq().zzi(new zzbl(this, zzekVar));
    }

    final void zzi() {
        com.google.android.gms.analytics.zzr.zzh();
        this.zza.zzl();
    }

    final void zzj() {
        com.google.android.gms.analytics.zzr.zzh();
        this.zza.zzm();
    }

    public final void zzk() {
        zzV();
        com.google.android.gms.analytics.zzr.zzh();
        com.google.android.gms.analytics.zzr.zzh();
        zzcj zzcjVar = this.zza;
        zzcjVar.zzV();
        zzcjVar.zzN("Service disconnected");
    }

    public final void zzl(int i) {
        zzV();
        zzF("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zzq().zzi(new zzbk(this, i));
    }

    public final void zzm() {
        this.zza.zzZ();
    }

    public final boolean zzn() {
        zzV();
        try {
            zzq().zzg(new zzbo(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzR("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zzJ("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzR("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }
}
