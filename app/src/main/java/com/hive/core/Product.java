package com.hive.core;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.hive.Const;
import com.hive.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Product.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005¨\u0006\f"}, d2 = {"Lcom/hive/core/Product;", "", "<init>", "()V", "getAppIdentifier", "", "getApplicationName", "getBuildVersion", "getAppVersionCode", "", "getValue", "name", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Product {
    public static final Product INSTANCE = new Product();

    private Product() {
    }

    public final String getAppIdentifier() {
        try {
            return HiveCoreInitializer.INSTANCE.getInitContext().getPackageName();
        } catch (Exception e) {
            Log.w(Const.TAG, "[Product] getAppIdentifier() e: " + e.getMessage());
            return null;
        }
    }

    public final String getApplicationName() {
        int i = HiveCoreInitializer.INSTANCE.getInitContext().getApplicationInfo().labelRes;
        if (i == 0) {
            return "";
        }
        String string = HiveCoreInitializer.INSTANCE.getInitContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String getBuildVersion() {
        PackageInfo packageInfo;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = HiveCoreInitializer.INSTANCE.getInitContext().getPackageManager().getPackageInfo(HiveCoreInitializer.INSTANCE.getInitContext().getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageInfo = HiveCoreInitializer.INSTANCE.getInitContext().getPackageManager().getPackageInfo(HiveCoreInitializer.INSTANCE.getInitContext().getPackageName(), 0);
            }
            return packageInfo.versionName;
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Product] getBuildVersion() e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }

    public final long getAppVersionCode() {
        PackageInfo packageInfo;
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = HiveCoreInitializer.INSTANCE.getInitContext().getPackageManager().getPackageInfo(HiveCoreInitializer.INSTANCE.getInitContext().getPackageName(), PackageManager.PackageInfoFlags.of(0L));
            } else {
                packageInfo = HiveCoreInitializer.INSTANCE.getInitContext().getPackageManager().getPackageInfo(HiveCoreInitializer.INSTANCE.getInitContext().getPackageName(), 0);
            }
            return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Product] getAppVersionCode() e: " + e.getMessage(), Logger.LogType.Warning);
            return -1L;
        }
    }

    public final String getValue(String name) {
        ApplicationInfo applicationInfo;
        Intrinsics.checkNotNullParameter(name, "name");
        try {
            PackageManager packageManager = HiveCoreInitializer.INSTANCE.getInitContext().getPackageManager();
            String packageName = HiveCoreInitializer.INSTANCE.getInitContext().getPackageName();
            if (Build.VERSION.SDK_INT >= 33) {
                applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(128L));
            } else {
                applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            }
            Intrinsics.checkNotNull(applicationInfo);
            return applicationInfo.metaData.getString(name);
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Product] getValue(name: " + name + ") e: " + e.getMessage(), Logger.LogType.Warning);
            return null;
        }
    }
}
