package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfpn implements Runnable {
    final /* synthetic */ zzfpo zza;

    zzfpn(zzfpo zzfpoVar) {
        Objects.requireNonNull(zzfpoVar);
        this.zza = zzfpoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfpo zzfpoVar = this.zza;
        AtomicBoolean atomicBooleanZzf = zzfpoVar.zzf();
        float fZzc = zzfpoVar.zzc();
        atomicBooleanZzf.set(false);
        if (((Float) zzfpoVar.zze().getAndSet(Float.valueOf(fZzc))).floatValue() != fZzc) {
            zzfpoVar.zzd().post(new zzfpm(this, fZzc));
        }
    }
}
