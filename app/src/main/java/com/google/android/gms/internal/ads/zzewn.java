package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewn implements zzeya {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;
    private final Context zzc;

    zzewn(ApplicationInfo applicationInfo, PackageInfo packageInfo, Context context) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
        this.zzc = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    @Override // com.google.android.gms.internal.ads.zzeya
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            r10 = this;
            android.content.pm.ApplicationInfo r0 = r10.zza
            java.lang.String r2 = r0.packageName
            android.content.pm.PackageInfo r0 = r10.zzb
            r1 = 0
            if (r0 != 0) goto Lb
            r3 = r1
            goto L11
        Lb:
            int r3 = r0.versionCode
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
        L11:
            if (r0 != 0) goto L15
            r4 = r1
            goto L18
        L15:
            java.lang.String r0 = r0.versionName
            r4 = r0
        L18:
            android.content.Context r0 = r10.zzc     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            com.google.android.gms.internal.ads.zzfuz r5 = com.google.android.gms.ads.internal.util.zzs.zza     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.CharSequence r0 = r0.getApplicationLabel(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L2a
            r5 = r0
            goto L2b
        L2a:
            r5 = r1
        L2b:
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 30
            if (r0 < r6) goto L86
            com.google.android.gms.internal.ads.zzbel r0 = com.google.android.gms.internal.ads.zzbeu.zznN
            com.google.android.gms.internal.ads.zzbes r6 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r0 = r6.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L86
            android.content.Context r0 = r10.zzc     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            android.content.pm.InstallSourceInfo r0 = r0.getInstallSourceInfo(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            if (r0 == 0) goto L86
            java.lang.String r6 = r0.getInstallingPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            if (r7 == 0) goto L5f
            java.lang.String r7 = "No installing package name found"
            com.google.android.gms.ads.internal.util.zze.zza(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            r6 = r1
        L5f:
            java.lang.String r0 = r0.getInitiatingPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L72
            boolean r7 = android.text.TextUtils.isEmpty(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L70
            if (r7 == 0) goto L84
            java.lang.String r7 = "No initiating package name found"
            com.google.android.gms.ads.internal.util.zze.zza(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L70
            r7 = r1
            goto L88
        L70:
            r1 = move-exception
            goto L7b
        L72:
            r0 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L7b
        L77:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L7b:
            java.lang.String r7 = "PackageInfoSignalSource.getInstallSourceInfo"
            com.google.android.gms.internal.ads.zzcbj r8 = com.google.android.gms.ads.internal.zzt.zzh()
            r8.zzg(r1, r7)
        L84:
            r7 = r0
            goto L88
        L86:
            r6 = r1
            r7 = r6
        L88:
            com.google.android.gms.internal.ads.zzewo r0 = new com.google.android.gms.internal.ads.zzewo
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgui.zza(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewn.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 29;
    }
}
