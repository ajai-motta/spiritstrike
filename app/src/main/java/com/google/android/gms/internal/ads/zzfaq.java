package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfaq implements zzeya {
    private final zzcbj zza;
    private final boolean zzb;
    private final ScheduledExecutorService zzc;
    private final zzgus zzd;
    private final int zze;
    private final int zzf;

    zzfaq(zzcbj zzcbjVar, boolean z, zzcaz zzcazVar, zzgus zzgusVar, String str, ScheduledExecutorService scheduledExecutorService, int i, int i2) {
        this.zza = zzcbjVar;
        this.zzb = z;
        this.zzd = zzgusVar;
        this.zzc = scheduledExecutorService;
        this.zze = i;
        this.zzf = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhA)).booleanValue() && this.zzb) {
            return zzgui.zza(new zzfar(null));
        }
        if (this.zzf == 2) {
            return zzgui.zza(new zzfar(null));
        }
        if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhC)).split(",")).contains(String.valueOf(this.zze))) {
            return zzgui.zza(new zzfar(null));
        }
        ListenableFuture listenableFutureZza = zzgui.zza(null);
        zzgus zzgusVar = this.zzd;
        return zzgui.zzg(zzgui.zzi(zzgui.zzk(listenableFutureZza, zzfap.zza, zzgusVar), ((Long) zzbhj.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzglu() { // from class: com.google.android.gms.internal.ads.zzfao
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzc((Exception) obj);
            }
        }, zzgusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 50;
    }

    final /* synthetic */ zzfar zzc(Exception exc) {
        this.zza.zzg(exc, "TrustlessTokenSignal");
        return new zzfar(null);
    }
}
