package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzph extends BroadcastReceiver {
    final /* synthetic */ zzpj zza;

    /* synthetic */ zzph(zzpj zzpjVar, byte[] bArr) {
        Objects.requireNonNull(zzpjVar);
        this.zza = zzpjVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        zzpj zzpjVar = this.zza;
        zzpjVar.zzf(zzpe.zzb(context, intent, zzpjVar.zzj(), zzpjVar.zzh()));
    }
}
