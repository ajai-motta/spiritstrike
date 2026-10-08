package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzern implements zzeya {
    final zzcbj zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgus zzd;
    private final Context zze;

    zzern(Context context, zzcbj zzcbjVar, ScheduledExecutorService scheduledExecutorService, zzgus zzgusVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdx)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcbjVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdt)).booleanValue()) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdy)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdu)).booleanValue()) {
                    return zzgui.zzk(zzfxf.zza(this.zzb.getAppSetIdInfo(), null), zzerm.zza, zzcbv.zzg);
                }
                Task<AppSetIdInfo> taskZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdx)).booleanValue() ? zzfhs.zzb(this.zze) : this.zzb.getAppSetIdInfo();
                if (taskZzb == null) {
                    return zzgui.zza(new zzero(null, -1));
                }
                ListenableFuture listenableFutureZzj = zzgui.zzj(zzfxf.zza(taskZzb, null), zzerk.zza, zzcbv.zzg);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdv)).booleanValue()) {
                    listenableFutureZzj = zzgui.zzi(listenableFutureZzj, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdw)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgui.zzg(listenableFutureZzj, Exception.class, new zzglu() { // from class: com.google.android.gms.internal.ads.zzerl
                    @Override // com.google.android.gms.internal.ads.zzglu
                    public final /* synthetic */ Object apply(Object obj) {
                        this.zza.zza.zzg((Exception) obj, "AppSetIdInfoSignal");
                        return new zzero(null, -1);
                    }
                }, this.zzd);
            }
        }
        return zzgui.zza(new zzero(null, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 11;
    }
}
