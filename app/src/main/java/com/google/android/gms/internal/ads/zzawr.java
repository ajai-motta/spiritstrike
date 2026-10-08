package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzawr implements Runnable {
    final /* synthetic */ zzaws zza;

    zzawr(zzaws zzawsVar) {
        Objects.requireNonNull(zzawsVar);
        this.zza = zzawsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaws zzawsVar = this.zza;
        synchronized (zzawsVar.zzp()) {
            if (zzawsVar.zzq()) {
                return;
            }
            zzawsVar.zzr(true);
            try {
                zzawsVar.zzn();
            } catch (Exception e) {
                this.zza.zzo().zzc(2023, -1L, e);
            }
            zzaws zzawsVar2 = this.zza;
            synchronized (zzawsVar2.zzp()) {
                zzawsVar2.zzr(false);
            }
        }
    }
}
