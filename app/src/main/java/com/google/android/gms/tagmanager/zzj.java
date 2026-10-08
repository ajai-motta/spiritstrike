package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzj extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.APP_NAME.toString();
    private final Context zzb;

    public zzj(Context context) {
        super(zza, new String[0]);
        this.zzb = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        try {
            PackageManager packageManager = this.zzb.getPackageManager();
            return zzfp.zzb(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.zzb.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("GoogleTagManager", "App name is not found.", e);
            return zzfp.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
