package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgil extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzgin zza;

    zzgil(zzgin zzginVar) {
        Objects.requireNonNull(zzginVar);
        this.zza = zzginVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        zzgin zzginVar = this.zza;
        synchronized (zzginVar) {
            zzginVar.zzf(networkCapabilities);
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        zzgin zzginVar = this.zza;
        synchronized (zzginVar) {
            zzginVar.zzf(null);
        }
    }
}
