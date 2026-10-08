package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzawt implements Runnable {
    final /* synthetic */ zzawu zza;

    zzawt(zzawu zzawuVar) {
        Objects.requireNonNull(zzawuVar);
        this.zza = zzawuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzawu zzawuVar = this.zza;
        if (zzawuVar.zzb != null) {
            return;
        }
        synchronized (zzawu.zzd) {
            if (zzawuVar.zzb != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzbeu.zzcU.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzawu.zza = zzfto.zzb(this.zza.zzb().zza, "ADSHIELD", null);
                    z = zBooleanValue;
                } catch (Throwable unused2) {
                }
            } else {
                z = zBooleanValue;
            }
            this.zza.zzb = Boolean.valueOf(z);
            zzawu.zzd.open();
        }
    }
}
