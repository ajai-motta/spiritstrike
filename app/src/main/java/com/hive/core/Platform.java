package com.hive.core;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.exifinterface.media.ExifInterface;
import com.hive.core.Logger;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* JADX INFO: compiled from: Platform.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005J\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00058GX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b#\u0010 ¨\u0006%"}, d2 = {"Lcom/hive/core/Platform;", "", "<init>", "()V", "getAndroidId", "", "getMdn", "getMacAddress", "deviceCountry", "getCountry", "deviceLanguage", "getLanguage", "getOsVersion", "getOsAPILevel", "", "getCpuType", "getPlatform", "getDeviceModel", "isGrantedPermission", "", "permission", "readNetworkType", "context", "Landroid/content/Context;", "deviceGlVersion", "getDeviceGlVersion", "()Ljava/lang/String;", "deviceGlVersion$delegate", "Lkotlin/Lazy;", "deviceDiskSpace", "", "getDeviceDiskSpace", "()F", "deviceDiskSpace$delegate", "deviceMemorySize", "getDeviceMemorySize", "deviceMemorySize$delegate", "hive-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Platform {
    private static String deviceCountry;
    private static String deviceLanguage;
    public static final Platform INSTANCE = new Platform();

    /* JADX INFO: renamed from: deviceGlVersion$delegate, reason: from kotlin metadata */
    private static final Lazy deviceGlVersion = LazyKt.lazy(new Function0() { // from class: com.hive.core.Platform$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Platform.deviceGlVersion_delegate$lambda$7();
        }
    });

    /* JADX INFO: renamed from: deviceDiskSpace$delegate, reason: from kotlin metadata */
    private static final Lazy deviceDiskSpace = LazyKt.lazy(new Function0() { // from class: com.hive.core.Platform$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Float.valueOf(Platform.deviceDiskSpace_delegate$lambda$8());
        }
    });

    /* JADX INFO: renamed from: deviceMemorySize$delegate, reason: from kotlin metadata */
    private static final Lazy deviceMemorySize = LazyKt.lazy(new Function0() { // from class: com.hive.core.Platform$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Float.valueOf(Platform.deviceMemorySize_delegate$lambda$9());
        }
    });

    private Platform() {
    }

    public final String getAndroidId() {
        try {
            return Settings.Secure.getString(HiveCoreInitializer.INSTANCE.getInitContext().getContentResolver(), "android_id");
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Platform] getAndroidId() Exception : " + e, Logger.LogType.Warning);
            return null;
        }
    }

    @Deprecated(message = "4.15.3")
    public final String getMdn() {
        Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "[Platform] getMdn() default null", null, 2, null);
        return null;
    }

    @Deprecated(message = "4.0.0")
    public final String getMacAddress() {
        Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "[Platform] getMacAddress() default null", null, 2, null);
        return null;
    }

    public final String getCountry() {
        String str = deviceCountry;
        if (str == null || StringsKt.isBlank(str)) {
            try {
                String country = Locale.getDefault().getCountry();
                Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String upperCase = country.toUpperCase(US);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (StringsKt.isBlank(upperCase)) {
                    Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "[Platform] getCountry() Error : Country is Empty", null, 2, null);
                }
                deviceCountry = upperCase;
            } catch (Exception e) {
                Logger.INSTANCE.coreLog$hive_core_release("[Platform] getCountry() Exception : " + e, Logger.LogType.Warning);
            }
        }
        return deviceCountry;
    }

    public final String getLanguage() {
        String str = deviceLanguage;
        if (str == null || StringsKt.isBlank(str)) {
            try {
                String language = Locale.getDefault().getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = language.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.isBlank(lowerCase)) {
                    Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "[Platform] getLanguage() Error : Language is Empty", null, 2, null);
                }
                deviceLanguage = lowerCase;
                if (Intrinsics.areEqual(lowerCase, ScarConstants.IN_SIGNAL_KEY)) {
                    deviceLanguage = "id";
                }
            } catch (Exception e) {
                Logger.INSTANCE.coreLog$hive_core_release("[Platform] getLanguage() Exception : " + e, Logger.LogType.Warning);
            }
        }
        return deviceLanguage;
    }

    public final String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public final int getOsAPILevel() {
        return Build.VERSION.SDK_INT;
    }

    public final String getCpuType() {
        String str;
        String property = System.getProperty("os.arch");
        if (property == null) {
            return "unknown";
        }
        String str2 = property;
        if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "armeabi-v7", false, 2, (Object) null)) {
            String str3 = "armeabi";
            if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "armeabi", false, 2, (Object) null)) {
                if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "86", false, 2, (Object) null)) {
                    str = "x86";
                } else {
                    str3 = "mips";
                    if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "mips", false, 2, (Object) null)) {
                        str3 = "aarch64";
                        if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "aarch64", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str2, (CharSequence) "arm64-v8a", false, 2, (Object) null)) {
                            str3 = "armv7";
                            if (!StringsKt.contains$default((CharSequence) str2, (CharSequence) "armv7", false, 2, (Object) null)) {
                                return "unknown";
                            }
                        }
                    }
                }
            }
            return str3;
        }
        str = "armeabi-v7a";
        return str;
    }

    public final String getPlatform() {
        return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    }

    public final String getDeviceModel() {
        return Build.MODEL;
    }

    public final boolean isGrantedPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        try {
            return PermissionChecker.checkCallingOrSelfPermission(HiveCoreInitializer.INSTANCE.getInitContext(), permission) == 0;
        } catch (Exception e) {
            Logger.INSTANCE.coreLog$hive_core_release("[Platform] isGrantedPermission() Exception : " + e, Logger.LogType.Warning);
            return false;
        }
    }

    public static /* synthetic */ String readNetworkType$default(Platform platform, Context context, int i, Object obj) {
        if ((i & 1) != 0) {
            context = HiveCoreInitializer.INSTANCE.getInitContext();
        }
        return platform.readNetworkType(context);
    }

    public final String readNetworkType(Context context) {
        Object objM7415constructorimpl;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == -1) {
            throw new Exception("ACCESS_NETWORK_STATE Permission denied.");
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(context, ConnectivityManager.class);
        if (connectivityManager == null) {
            throw new Exception("getSystemService(ConnectivityManager) failed.");
        }
        android.net.Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            str = "notConnected";
        } else {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                str = "unknown";
            } else if (networkCapabilities.hasTransport(8)) {
                str = "usb";
            } else if (networkCapabilities.hasTransport(4)) {
                str = "vpn";
            } else if (networkCapabilities.hasTransport(3)) {
                str = "ethernet";
            } else if (networkCapabilities.hasTransport(2)) {
                str = "bluetooth";
            } else if (networkCapabilities.hasTransport(1)) {
                str = "wifi";
            } else {
                str = networkCapabilities.hasTransport(0) ? "cellular" : "other";
            }
        }
        objM7415constructorimpl = kotlin.Result.m7415constructorimpl(str);
        Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.coreLog$hive_core_release("[Platform] readNetworkType failed. " + thM7418exceptionOrNullimpl, Logger.LogType.Warning);
        }
        String str2 = (String) (kotlin.Result.m7421isFailureimpl(objM7415constructorimpl) ? "unknown" : objM7415constructorimpl);
        Logger.coreLog$hive_core_release$default(Logger.INSTANCE, "[Platform] readNetworkType: " + str2, null, 2, null);
        return str2;
    }

    public final String getDeviceGlVersion() {
        return (String) deviceGlVersion.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String deviceGlVersion_delegate$lambda$7() {
        return (String) BuildersKt__BuildersKt.runBlocking$default(null, new Platform$deviceGlVersion$2$1(null), 1, null);
    }

    public final float getDeviceDiskSpace() {
        return ((Number) deviceDiskSpace.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float deviceDiskSpace_delegate$lambda$8() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSizeLong = statFs.getBlockSizeLong() * statFs.getBlockCountLong();
        StatFs statFs2 = new StatFs(Environment.getRootDirectory().getPath());
        return (float) (((double) MathKt.roundToInt(((blockSizeLong + (statFs2.getBlockSizeLong() * statFs2.getBlockCountLong())) / ((double) 1000000000)) * ((double) 100))) / 100.0d);
    }

    public final float getDeviceMemorySize() {
        return ((Number) deviceMemorySize.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float deviceMemorySize_delegate$lambda$9() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        Object systemService = HiveCoreInitializer.INSTANCE.getInitContext().getSystemService("activity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
        return (float) (((double) MathKt.roundToInt((memoryInfo.totalMem / ((double) 1000000000)) * ((double) 100))) / 100.0d);
    }
}
