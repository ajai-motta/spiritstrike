package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbbm implements Runnable {
    final /* synthetic */ zzbbn zza;

    zzbbm(zzbbn zzbbnVar) {
        Objects.requireNonNull(zzbbnVar);
        this.zza = zzbbnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbbn zzbbnVar = this.zza;
        synchronized (zzbbnVar.zzf()) {
            if (zzbbnVar.zzg().get() && zzbbnVar.zzh()) {
                zzbbnVar.zzg().set(false);
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("App went background");
                Iterator it = zzbbnVar.zzi().iterator();
                while (it.hasNext()) {
                    try {
                        ((zzbbo) it.next()).zza(false);
                    } catch (Exception e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
                    }
                }
            } else {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd("App is still foreground");
            }
        }
    }
}
