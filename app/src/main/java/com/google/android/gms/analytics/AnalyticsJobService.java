package com.google.android.gms.analytics;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfa;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class AnalyticsJobService extends JobService implements zzez {
    private zzfa zza;

    private final zzfa zzb() {
        if (this.zza == null) {
            this.zza = new zzfa(this);
        }
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzez
    public boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        zzb().zze();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        zzb().zzf();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzb().zza(intent, i, i2);
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        zzb().zzi(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzez
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
