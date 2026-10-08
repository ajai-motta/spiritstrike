package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdbn implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzdbp zzdbpVar = (zzdbp) this.zza.get();
        if (zzdbpVar != null) {
            zzdbpVar.zzs(zzdbm.zza);
        }
    }
}
