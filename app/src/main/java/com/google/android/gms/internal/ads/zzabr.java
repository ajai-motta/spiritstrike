package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzabr {
    private final Handler zza;
    private final zzabs zzb;

    public zzabr(Handler handler, zzabs zzabsVar) {
        if (zzabsVar != null) {
            handler.getClass();
        } else {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzabsVar;
    }

    public final void zza(final zzhs zzhsVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzk(zzhsVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzl(str, j, j2);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, final zzht zzhtVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzm(zzvVar, zzhtVar);
                }
            });
        }
    }

    public final void zzd(final int i, final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzn(i, j);
                }
            });
        }
    }

    public final void zze(final long j, final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(j, i);
                }
            });
        }
    }

    public final void zzf(final zzbv zzbvVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(zzbvVar);
                }
            });
        }
    }

    public final void zzg(final Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(obj, jElapsedRealtime);
                }
            });
        }
    }

    public final void zzh(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(str);
                }
            });
        }
    }

    public final void zzi(final zzhs zzhsVar) {
        zzhsVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(zzhsVar);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(exc);
                }
            });
        }
    }

    final /* synthetic */ void zzk(zzhs zzhsVar) {
        String str = zzep.zza;
        this.zzb.zza(zzhsVar);
    }

    final /* synthetic */ void zzl(String str, long j, long j2) {
        String str2 = zzep.zza;
        this.zzb.zzb(str, j, j2);
    }

    final /* synthetic */ void zzm(zzv zzvVar, zzht zzhtVar) {
        String str = zzep.zza;
        this.zzb.zzc(zzvVar, zzhtVar);
    }

    final /* synthetic */ void zzn(int i, long j) {
        String str = zzep.zza;
        this.zzb.zzd(i, j);
    }

    final /* synthetic */ void zzo(long j, int i) {
        String str = zzep.zza;
        this.zzb.zzi(j, i);
    }

    final /* synthetic */ void zzp(zzbv zzbvVar) {
        String str = zzep.zza;
        this.zzb.zze(zzbvVar);
    }

    final /* synthetic */ void zzq(Object obj, long j) {
        String str = zzep.zza;
        this.zzb.zzf(obj, j);
    }

    final /* synthetic */ void zzr(String str) {
        String str2 = zzep.zza;
        this.zzb.zzg(str);
    }

    final /* synthetic */ void zzs(zzhs zzhsVar) {
        zzhsVar.zza();
        String str = zzep.zza;
        this.zzb.zzh(zzhsVar);
    }

    final /* synthetic */ void zzt(Exception exc) {
        String str = zzep.zza;
        this.zzb.zzj(exc);
    }
}
