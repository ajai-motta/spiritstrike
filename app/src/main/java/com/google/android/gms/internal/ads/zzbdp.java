package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbdp {
    private zzbde zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzbdp(Context context) {
        this.zzc = context;
    }

    final Future zza(zzbdf zzbdfVar) {
        zzbdj zzbdjVar = new zzbdj(this);
        zzbdn zzbdnVar = new zzbdn(this, zzbdfVar, zzbdjVar);
        zzbdo zzbdoVar = new zzbdo(this, zzbdjVar);
        synchronized (this.zzd) {
            zzbde zzbdeVar = new zzbde(this.zzc, com.google.android.gms.ads.internal.zzt.zzs().zza(), zzbdnVar, zzbdoVar);
            this.zza = zzbdeVar;
            zzbdeVar.checkAvailabilityAndConnect();
        }
        return zzbdjVar;
    }

    final /* synthetic */ zzbde zzc() {
        return this.zza;
    }

    final /* synthetic */ boolean zzd() {
        return this.zzb;
    }

    final /* synthetic */ void zze(boolean z) {
        this.zzb = true;
    }

    final /* synthetic */ Object zzf() {
        return this.zzd;
    }

    final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            zzbde zzbdeVar = this.zza;
            if (zzbdeVar == null) {
                return;
            }
            zzbdeVar.disconnect();
            this.zza = null;
            Binder.flushPendingCommands();
        }
    }
}
