package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcsy implements zzbau {
    private final zzcgy zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    zzcsy(zzcgy zzcgyVar, Executor executor) {
        this.zza = zzcgyVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final synchronized void zzdo(zzbat zzbatVar) {
        final zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznE)).booleanValue()) {
                if (zzbatVar.zzj) {
                    if (!Boolean.TRUE.equals(this.zzc.getAndSet(true))) {
                        Executor executor = this.zzb;
                        Objects.requireNonNull(zzcgyVar);
                        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsx
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcgyVar.onResume();
                            }
                        });
                    }
                } else {
                    if (!Boolean.FALSE.equals(this.zzc.getAndSet(false))) {
                        Executor executor2 = this.zzb;
                        Objects.requireNonNull(zzcgyVar);
                        executor2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcsw
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzcgyVar.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
