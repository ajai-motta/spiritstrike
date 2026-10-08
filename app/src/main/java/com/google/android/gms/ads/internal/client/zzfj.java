package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfj implements Runnable {
    final /* synthetic */ zzfk zza;

    zzfj(zzfk zzfkVar) {
        Objects.requireNonNull(zzfkVar);
        this.zza = zzfkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfk zzfkVar = this.zza;
        if (zzfkVar.zzL() != null) {
            try {
                zzfkVar.zzL().zzc(1);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
