package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeax {
    private final ScheduledExecutorService zza;
    private final zzgus zzb;
    private final zzgus zzc;
    private final zzebw zzd;
    private final zzifb zze;

    public zzeax(ScheduledExecutorService scheduledExecutorService, zzgus zzgusVar, zzgus zzgusVar2, zzebw zzebwVar, zzifb zzifbVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgusVar;
        this.zzc = zzgusVar2;
        this.zzd = zzebwVar;
        this.zze = zzifbVar;
    }

    public final ListenableFuture zza(final zzbxj zzbxjVar) {
        ListenableFuture listenableFutureZzc;
        String str = zzbxjVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzc();
        if (com.google.android.gms.ads.internal.util.zzs.zzG(str)) {
            listenableFutureZzc = zzgui.zzc(new zzecj(1));
        } else {
            listenableFutureZzc = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzia)).booleanValue() || ((Boolean) zzbhf.zza.zze()).booleanValue()) ? this.zzc.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeau
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    return this.zza.zzc(zzbxjVar);
                }
            }) : this.zzd.zza(zzbxjVar);
        }
        final int callingUid = Binder.getCallingUid();
        return (zzgua) zzgui.zzh((zzgua) zzgui.zzi(zzgua.zzw(listenableFutureZzc), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgi)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeaw
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzbxjVar, callingUid, (Throwable) obj);
            }
        }, this.zzb);
    }

    final /* synthetic */ ListenableFuture zzb(final zzbxj zzbxjVar, int i, Throwable th) {
        Bundle bundle;
        if (zzbxjVar != null && (bundle = zzbxjVar.zzm) != null) {
            bundle.putBoolean("ls", true);
        }
        return zzgui.zzj(((zzeea) this.zze.zzb()).zzk(zzbxjVar, i), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeav
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return zzgui.zza(new zzeck((InputStream) obj, zzbxjVar));
            }
        }, this.zzb);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzeck zzc(zzbxj zzbxjVar) {
        return (zzeck) this.zzd.zza(zzbxjVar).get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgi)).intValue(), TimeUnit.SECONDS);
    }
}
