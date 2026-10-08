package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgiz implements zzgia, zzfzj {
    static final String[] zza = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    private final Context zzb;
    private final ExecutorService zzc;
    private final String[] zzd;
    private long zze = 0;
    private long zzf = 0;
    private long zzg = -1;
    private boolean zzh = false;

    zzgiz(Context context, zzfxa zzfxaVar, ExecutorService executorService, String[] strArr) {
        this.zzb = context;
        this.zzc = executorService;
        this.zzd = strArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final ListenableFuture zza() {
        return Build.VERSION.SDK_INT < 30 ? zzgui.zzb() : zzgui.zze(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgiy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzf();
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzb(Map map) {
        long j;
        long j2;
        zze();
        synchronized (this) {
            j = this.zzh ? this.zzf - this.zze : -1L;
        }
        map.put("vs", Long.valueOf(j));
        synchronized (this) {
            j2 = this.zzg;
            this.zzg = -1L;
        }
        map.put("vf", Long.valueOf(j2));
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzc(Map map, Context context, View view) {
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzd(Map map) {
        zze();
    }

    final void zze() {
        synchronized (this) {
            if (this.zzh) {
                this.zzf = System.currentTimeMillis();
            }
        }
    }

    final /* synthetic */ void zzf() {
        zzgix zzgixVar = new zzgix(this);
        try {
            Object systemService = this.zzb.getSystemService("appops");
            systemService.getClass();
            ((AppOpsManager) systemService).startWatchingActive(this.zzd, this.zzc, zzgixVar);
        } catch (Throwable unused) {
        }
    }

    final /* synthetic */ void zzg(long j) {
        this.zze = j;
    }

    final /* synthetic */ long zzh() {
        return this.zzf;
    }

    final /* synthetic */ void zzi(long j) {
        this.zzg = j;
    }

    final /* synthetic */ void zzj(boolean z) {
        this.zzh = z;
    }
}
