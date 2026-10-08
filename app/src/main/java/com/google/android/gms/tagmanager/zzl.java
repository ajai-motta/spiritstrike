package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzl extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.APP_VERSION_NAME.toString();
    private final Context zzb;

    public zzl(Context context) {
        super(zza, new String[0]);
        this.zzb = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        try {
            return zzfp.zzb(this.zzb.getPackageManager().getPackageInfo(this.zzb.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("GoogleTagManager", "Package name " + this.zzb.getPackageName() + " not found. " + e.getMessage());
            return zzfp.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
