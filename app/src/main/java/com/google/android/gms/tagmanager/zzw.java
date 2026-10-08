package com.google.android.gms.tagmanager;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzfy;
import com.google.android.gms.tagmanager.ContainerHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzw extends zzfy {
    final /* synthetic */ zzx zza;
    private final ContainerHolder.ContainerAvailableListener zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzw(zzx zzxVar, ContainerHolder.ContainerAvailableListener containerAvailableListener, Looper looper) {
        super(looper);
        this.zza = zzxVar;
        this.zzb = containerAvailableListener;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            Log.e("GoogleTagManager", "Don't know how to handle this message.");
        } else {
            this.zzb.onContainerAvailable(this.zza, (String) message.obj);
        }
    }
}
