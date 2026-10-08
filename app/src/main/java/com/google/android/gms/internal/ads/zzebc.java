package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzflc;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzebc implements zzeci {
    private static final Pattern zzh = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzead zza;
    private final zzgus zzb;
    private final zzfgn zzc;
    private final ScheduledExecutorService zzd;
    private final zzeev zze;
    private final zzflm zzf;
    private final Context zzg;

    zzebc(Context context, zzfgn zzfgnVar, zzead zzeadVar, zzgus zzgusVar, ScheduledExecutorService scheduledExecutorService, zzeev zzeevVar, zzflm zzflmVar) {
        this.zzg = context;
        this.zzc = zzfgnVar;
        this.zza = zzeadVar;
        this.zzb = zzgusVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzeevVar;
        this.zzf = zzflmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final ListenableFuture zza(zzbxj zzbxjVar) {
        Context context = this.zzg;
        ListenableFuture listenableFutureZza = this.zza.zza(zzbxjVar);
        zzflc zzflcVarZzn = zzflc.CC.zzn(context, 11);
        zzfll.zzb(listenableFutureZza, zzflcVarZzn);
        ListenableFuture listenableFutureZzj = zzgui.zzj(listenableFutureZza, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzebb
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb((zzeck) obj);
            }
        }, this.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgh)).booleanValue()) {
            listenableFutureZzj = zzgui.zzh(zzgui.zzi(listenableFutureZzj, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgi)).intValue(), TimeUnit.SECONDS, this.zzd), TimeoutException.class, zzeba.zza, zzcbv.zzg);
        }
        zzfll.zzd(listenableFutureZzj, this.zzf, zzflcVarZzn);
        zzgui.zzr(listenableFutureZzj, new zzeaz(this), zzcbv.zzg);
        return listenableFutureZzj;
    }

    final /* synthetic */ ListenableFuture zzb(zzeck zzeckVar) {
        return zzgui.zza(new zzfgf(new zzfgc(this.zzc), zzfge.zza(new InputStreamReader(zzeckVar.zza()), zzeckVar.zzb().zzm)));
    }

    final /* synthetic */ zzeev zzc() {
        return this.zze;
    }
}
