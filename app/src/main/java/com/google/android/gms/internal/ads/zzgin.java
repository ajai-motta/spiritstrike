package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgin implements zzgia, zzfzj {
    private final Context zza;
    private final ExecutorService zzb;
    private NetworkCapabilities zzc = null;

    zzgin(Context context, ExecutorService executorService) {
        this.zza = context;
        this.zzb = executorService;
    }

    @Override // com.google.android.gms.internal.ads.zzfzj
    public final ListenableFuture zza() {
        return Build.VERSION.SDK_INT < 24 ? zzgui.zzb() : zzgui.zze(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgim
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze();
            }
        }, this.zzb);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033 A[Catch: all -> 0x0040, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000a, B:9:0x000e, B:11:0x0015, B:13:0x0019, B:15:0x0022, B:17:0x0026, B:19:0x002f, B:21:0x0033), top: B:31:0x000a }] */
    @Override // com.google.android.gms.internal.ads.zzgia
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzb(java.util.Map r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.net.NetworkCapabilities r0 = r3.zzc     // Catch: java.lang.Throwable -> L43
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            java.lang.String r1 = "ntc"
            r4.put(r1, r0)
            monitor-enter(r3)
            android.net.NetworkCapabilities r0 = r3.zzc     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L33
            r1 = 4
            boolean r0 = r0.hasTransport(r1)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L19
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
            r0 = 2
            goto L36
        L19:
            android.net.NetworkCapabilities r0 = r3.zzc     // Catch: java.lang.Throwable -> L40
            r1 = 1
            boolean r0 = r0.hasTransport(r1)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L26
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
            r0 = 1
            goto L36
        L26:
            android.net.NetworkCapabilities r0 = r3.zzc     // Catch: java.lang.Throwable -> L40
            r1 = 0
            boolean r0 = r0.hasTransport(r1)     // Catch: java.lang.Throwable -> L40
            if (r0 == 0) goto L33
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
            r0 = 0
            goto L36
        L33:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
            r0 = -1
        L36:
            java.lang.String r2 = "nt"
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r4.put(r2, r0)
            return
        L40:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L40
            throw r4
        L43:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L43
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgin.zzb(java.util.Map):void");
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzc(Map map, Context context, View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzgia
    public final void zzd(Map map) {
    }

    final /* synthetic */ void zze() {
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        zzgil zzgilVar = new zzgil(this);
        try {
            Object systemService = this.zza.getSystemService("connectivity");
            systemService.getClass();
            ((ConnectivityManager) systemService).registerDefaultNetworkCallback(zzgilVar);
        } catch (Throwable unused) {
        }
    }

    final /* synthetic */ void zzf(NetworkCapabilities networkCapabilities) {
        this.zzc = networkCapabilities;
    }
}
