package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcdl {
    private long zzb;
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzY)).longValue());
    private boolean zzc = true;

    zzcdl() {
    }

    public final void zza() {
        this.zzc = true;
    }

    public final void zzb(SurfaceTexture surfaceTexture, final zzccw zzccwVar) {
        if (zzccwVar == null) {
            return;
        }
        long timestamp = surfaceTexture.getTimestamp();
        if (!this.zzc) {
            long j = timestamp - this.zzb;
            if (Math.abs(j) < this.zza) {
                return;
            }
        }
        this.zzc = false;
        this.zzb = timestamp;
        zzfuz zzfuzVar = com.google.android.gms.ads.internal.util.zzs.zza;
        Objects.requireNonNull(zzccwVar);
        zzfuzVar.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzccwVar.zzi();
            }
        });
    }
}
