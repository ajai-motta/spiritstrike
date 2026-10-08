package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzify extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzify(zzbfv zzbfvVar) {
        this.zza = new WeakReference(zzbfvVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbfv zzbfvVar = (zzbfv) this.zza.get();
        if (zzbfvVar != null) {
            zzbfvVar.zzf(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbfv zzbfvVar = (zzbfv) this.zza.get();
        if (zzbfvVar != null) {
            zzbfvVar.zzg();
        }
    }
}
