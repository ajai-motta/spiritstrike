package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzev;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzev zza;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.zza == null) {
            this.zza = new zzev();
        }
        this.zza.zza(context, intent);
    }
}
