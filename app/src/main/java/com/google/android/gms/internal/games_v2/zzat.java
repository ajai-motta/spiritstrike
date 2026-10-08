package com.google.android.gms.internal.games_v2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzat {
    static final zzat zza = new zzat();
    private boolean zzb;
    private boolean zzc;

    zzat() {
    }

    final boolean zza(Activity activity) {
        Bundle bundle;
        ApplicationInfo applicationInfo;
        if (this.zzc) {
            return this.zzb;
        }
        ActivityInfo activityInfo = null;
        try {
            applicationInfo = Wrappers.packageManager(activity).getApplicationInfo(activity.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        Bundle bundle2 = applicationInfo == null ? null : applicationInfo.metaData;
        boolean zEquals = false;
        if (bundle2 != null && bundle2.getString("com.epicgames.unreal.GameActivity.EngineVersion", "").startsWith("5.")) {
            try {
                activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, "com.epicgames.unreal.GameActivity"), 128);
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (activityInfo != null && (bundle = activityInfo.metaData) != null) {
                zEquals = Objects.equals(bundle.getString("android.app.lib_name", ""), "Unreal");
            }
        }
        this.zzb = zEquals;
        this.zzc = true;
        return zEquals;
    }
}
