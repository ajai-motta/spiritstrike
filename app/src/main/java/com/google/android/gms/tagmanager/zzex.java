package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzex implements Handler.Callback {
    final /* synthetic */ zzey zza;

    zzex(zzey zzeyVar) {
        this.zza = zzeyVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1 && zzfa.zza.equals(message.obj)) {
            this.zza.zza.zza();
            zzey zzeyVar = this.zza;
            if (!zzeyVar.zza.zzm()) {
                zzeyVar.zzc(1800000L);
            }
        }
        return true;
    }
}
