package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzpz {
    private final Handler zza;
    private final zzqa zzb;

    public zzpz(Handler handler, zzqa zzqaVar) {
        if (zzqaVar == null) {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzqaVar;
    }

    public final void zza(final zzhs zzhsVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzn(zzhsVar);
                }
            });
        }
    }

    public final void zzb(final String str, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzo(str, j, j2);
                }
            });
        }
    }

    public final void zzc(final zzv zzvVar, final zzht zzhtVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzp(zzvVar, zzhtVar);
                }
            });
        }
    }

    public final void zzd(final long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzq(j);
                }
            });
        }
    }

    public final void zze(final int i, final long j, final long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzr(i, j, j2);
                }
            });
        }
    }

    public final void zzf(final String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzps
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzs(str);
                }
            });
        }
    }

    public final void zzg(final zzhs zzhsVar) {
        zzhsVar.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpt
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzt(zzhsVar);
                }
            });
        }
    }

    public final void zzh(final boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpu
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(z);
                }
            });
        }
    }

    public final void zzi(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzv(exc);
                }
            });
        }
    }

    public final void zzj(final Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzw(exc);
                }
            });
        }
    }

    public final void zzk(final zzqb zzqbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzx(zzqbVar);
                }
            });
        }
    }

    public final void zzl(final zzqb zzqbVar) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzy(zzqbVar);
                }
            });
        }
    }

    public final void zzm(final int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzpo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzz(i);
                }
            });
        }
    }

    final /* synthetic */ void zzn(zzhs zzhsVar) {
        String str = zzep.zza;
        this.zzb.zzk(zzhsVar);
    }

    final /* synthetic */ void zzo(String str, long j, long j2) {
        String str2 = zzep.zza;
        this.zzb.zzl(str, j, j2);
    }

    final /* synthetic */ void zzp(zzv zzvVar, zzht zzhtVar) {
        String str = zzep.zza;
        this.zzb.zzm(zzvVar, zzhtVar);
    }

    final /* synthetic */ void zzq(long j) {
        String str = zzep.zza;
        this.zzb.zzn(j);
    }

    final /* synthetic */ void zzr(int i, long j, long j2) {
        String str = zzep.zza;
        this.zzb.zzo(i, j, j2);
    }

    final /* synthetic */ void zzs(String str) {
        String str2 = zzep.zza;
        this.zzb.zzp(str);
    }

    final /* synthetic */ void zzt(zzhs zzhsVar) {
        zzhsVar.zza();
        String str = zzep.zza;
        this.zzb.zzq(zzhsVar);
    }

    final /* synthetic */ void zzu(boolean z) {
        String str = zzep.zza;
        this.zzb.zzr(z);
    }

    final /* synthetic */ void zzv(Exception exc) {
        String str = zzep.zza;
        this.zzb.zzs(exc);
    }

    final /* synthetic */ void zzw(Exception exc) {
        String str = zzep.zza;
        this.zzb.zzt(exc);
    }

    final /* synthetic */ void zzx(zzqb zzqbVar) {
        String str = zzep.zza;
        this.zzb.zzu(zzqbVar);
    }

    final /* synthetic */ void zzy(zzqb zzqbVar) {
        String str = zzep.zza;
        this.zzb.zzv(zzqbVar);
    }

    final /* synthetic */ void zzz(int i) {
        String str = zzep.zza;
        this.zzb.zzw(i);
    }
}
