package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfqb extends BroadcastReceiver {
    final /* synthetic */ zzfqc zza;

    zzfqb(zzfqc zzfqcVar) {
        Objects.requireNonNull(zzfqcVar);
        this.zza = zzfqcVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
            zzfqc zzfqcVar = this.zza;
            zzfqcVar.zzd(true, zzfqcVar.zzf());
            zzfqcVar.zze(true);
        } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
            zzfqc zzfqcVar2 = this.zza;
            zzfqcVar2.zzd(false, zzfqcVar2.zzf());
            zzfqcVar2.zze(false);
        }
    }
}
