package com.google.android.recaptcha.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcz implements zzda {
    private final GoogleApiAvailabilityLight zza;

    public zzcz() {
        this.zza = GoogleApiAvailabilityLight.getInstance();
    }

    public zzcz(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zza = googleApiAvailabilityLight;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022 A[PHI: r5
  0x0022: PHI (r5v3 java.lang.String) = (r5v2 java.lang.String), (r5v5 java.lang.String) binds: [B:9:0x001f, B:6:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.recaptcha.internal.zzda
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zza(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch: java.lang.Exception -> L23
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Exception -> L23
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L23
            r3 = 30
            if (r2 < r3) goto L1b
            android.content.pm.InstallSourceInfo r5 = r1.getInstallSourceInfo(r5)     // Catch: java.lang.Exception -> L23
            java.lang.String r5 = r5.getInitiatingPackageName()     // Catch: java.lang.Exception -> L23
            if (r5 != 0) goto L22
            goto L23
        L1b:
            java.lang.String r5 = r1.getInstallerPackageName(r5)     // Catch: java.lang.Exception -> L23
            if (r5 != 0) goto L22
            goto L23
        L22:
            r0 = r5
        L23:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzcz.zza(android.content.Context):java.lang.String");
    }

    @Override // com.google.android.recaptcha.internal.zzda
    public final boolean zzb(Context context) {
        return zzd(context) == 3;
    }

    @Override // com.google.android.recaptcha.internal.zzda
    public final boolean zzc(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
            if ((installedPackages instanceof Collection) && installedPackages.isEmpty()) {
                return false;
            }
            Iterator<T> it = installedPackages.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((PackageInfo) it.next()).packageName, "com.android.vending")) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzda
    public final int zzd(Context context) {
        int iIsGooglePlayServicesAvailable = this.zza.isGooglePlayServicesAvailable(context);
        return (iIsGooglePlayServicesAvailable == 1 || iIsGooglePlayServicesAvailable == 3 || iIsGooglePlayServicesAvailable == 9) ? 4 : 3;
    }
}
