package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcbg extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzcbj zza;

    zzcbg(zzcbj zzcbjVar) {
        Objects.requireNonNull(zzcbjVar);
        this.zza = zzcbjVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzB().set(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzB().set(false);
    }
}
