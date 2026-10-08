package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhk extends BroadcastReceiver {
    private final zzdm zza;

    public zzhk(zzhm zzhmVar, zzdm zzdmVar, zzhl zzhlVar) {
        Objects.requireNonNull(zzhmVar);
        this.zza = zzdmVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zza.zzm(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzhj
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                }
            });
        }
    }
}
