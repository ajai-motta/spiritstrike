package com.unity3d.player;

import android.content.Context;
import android.net.ConnectivityManager;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkConnectivityNougat extends NetworkConnectivity {
    private int b;
    private final ConnectivityManager.NetworkCallback c;

    public NetworkConnectivityNougat(Context context) {
        super(context);
        this.b = 0;
        A a2 = new A(this);
        this.c = a2;
        if (this.f3269a == null) {
            return;
        }
        this.b = super.b();
        this.f3269a.registerDefaultNetworkCallback(a2);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    public final void a() {
        ConnectivityManager connectivityManager = this.f3269a;
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(this.c);
    }

    @Override // com.unity3d.player.NetworkConnectivity
    public final int b() {
        return this.b;
    }
}
