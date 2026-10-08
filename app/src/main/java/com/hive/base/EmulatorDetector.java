package com.hive.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.InputDevice;
import androidx.core.content.ContextCompat;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import androidx.webkit.Profile;
import com.facebook.internal.AnalyticsEvents;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\b\u001a\b\u0018\u00010\tR\u00020\u0000J\f\u0010\n\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u000b\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\f\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\r\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u000e\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u000f\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u0010\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u0011\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u0012\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u0013\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u0014\u001a\u00060\tR\u00020\u0000H\u0004J\f\u0010\u0015\u001a\u00060\tR\u00020\u0000H\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/hive/base/EmulatorDetector;", "", "_activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "_logger", "Ljava/util/logging/Logger;", "checkEmulator", "Lcom/hive/base/EmulatorDetector$Emulator;", "checkGenymotion", "checkBlueStacks", "checkAndyEmulator", "checkNoxEmulator", "checkMemuEmulator", "checkKoPlayerEmulator", "checkLDPlayerEmulator", "checkMuMuEmulator", "checkDefaultAndroidEmulator", "checkGPGEmulator", "checkUnknownEmulator", "checkIrreguarNetwork", "getSystemProperty", "", "name", "FileExist", "", "filepath", "isAppInstalled", "packageName", "deviceListing", "getDeviceListing", "()Ljava/lang/String;", "Emulator", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmulatorDetector {
    private final Activity _activity;
    private Logger _logger;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "EmulatorDetector";
    private static final String Genymotion = "Genymotion";
    private static final String BlueStacks = "BlueStacks";
    private static final String Andy = "Andy";
    private static final String Nox = "Nox";
    private static final String MEmu = "MEmu";
    private static final String KoPlayer = "KoPlayer";
    private static final String LDPlayer = "LDPlayer";
    private static final String MuMu = "MuMu";
    private static final String Default = "DefaultAndroid";
    private static final String Gpg = "GPGEmulator";
    private static final String Unknown = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    private static final String Network = "IrregularNetwork";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u0014\u0010\u001d\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/hive/base/EmulatorDetector$Companion;", "", "<init>", "()V", "TAG", "", "Genymotion", "getGenymotion", "()Ljava/lang/String;", "BlueStacks", "getBlueStacks", "Andy", "getAndy", "Nox", "getNox", "MEmu", "getMEmu", "KoPlayer", "getKoPlayer", "LDPlayer", "getLDPlayer", "MuMu", "getMuMu", Profile.DEFAULT_PROFILE_NAME, "getDefault", "Gpg", "getGpg", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "getUnknown", AndroidInitializeBoldSDK.MSG_NETWORK, "getNetwork", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getAndy() {
            return EmulatorDetector.Andy;
        }

        public final String getBlueStacks() {
            return EmulatorDetector.BlueStacks;
        }

        public final String getDefault() {
            return EmulatorDetector.Default;
        }

        public final String getGenymotion() {
            return EmulatorDetector.Genymotion;
        }

        public final String getGpg() {
            return EmulatorDetector.Gpg;
        }

        public final String getKoPlayer() {
            return EmulatorDetector.KoPlayer;
        }

        public final String getLDPlayer() {
            return EmulatorDetector.LDPlayer;
        }

        public final String getMEmu() {
            return EmulatorDetector.MEmu;
        }

        public final String getMuMu() {
            return EmulatorDetector.MuMu;
        }

        public final String getNetwork() {
            return EmulatorDetector.Network;
        }

        public final String getNox() {
            return EmulatorDetector.Nox;
        }

        public final String getUnknown() {
            return EmulatorDetector.Unknown;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0006J\u0011\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/hive/base/EmulatorDetector$Emulator;", "", "", "iWeight", "", "name", "", "<init>", "(Lcom/hive/base/EmulatorDetector;ILjava/lang/String;)V", "iRate", "emulatorName", "getEmulatorName", "()Ljava/lang/String;", "setEmulatorName", "(Ljava/lang/String;)V", "cause", "getCause", "setCause", "rate", "getRate", "()I", "increaseRate", "", "compareTo", "arg0", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class Emulator implements Comparable<Object> {
        private String cause;
        private String emulatorName;
        private int iRate;
        private final int iWeight;
        final /* synthetic */ EmulatorDetector this$0;

        public Emulator(EmulatorDetector emulatorDetector, int i, String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = emulatorDetector;
            this.iWeight = i;
            this.cause = "";
            this.emulatorName = name;
            this.cause += name;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            if (arg0 instanceof Emulator) {
                return getRate() < ((Emulator) arg0).getRate() ? 1 : -1;
            }
            return 0;
        }

        public final String getCause() {
            return this.cause;
        }

        public final String getEmulatorName() {
            return this.emulatorName;
        }

        public final int getRate() {
            return this.iRate * this.iWeight;
        }

        public final void increaseRate(String cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            this.iRate++;
            this.cause += '\n' + cause;
        }

        public final void setCause(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cause = str;
        }

        public final void setEmulatorName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.emulatorName = str;
        }
    }

    public EmulatorDetector(Activity _activity) {
        Intrinsics.checkNotNullParameter(_activity, "_activity");
        this._activity = _activity;
        try {
            try {
                this._logger = Logger.getLogger(TAG, null);
            } catch (Exception unused) {
                this._logger = Logger.getAnonymousLogger();
            }
        } catch (Exception unused2) {
        }
    }

    private final boolean FileExist(String filepath) {
        try {
            return new File(filepath).exists();
        } catch (Throwable th) {
            com.hive.core.Logger.INSTANCE.w("[EmulatorDetector] FileExist()\ne: " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkBlueStacks$lambda$0(Emulator emulator) {
        try {
            String strGlGetString = GLES20.glGetString(7937);
            if (strGlGetString == null || !StringsKt.contains$default((CharSequence) strGlGetString, (CharSequence) "Bluestacks", false, 2, (Object) null)) {
                return;
            }
            emulator.increaseRate("GLES20.GL_RENDERER = " + strGlGetString);
        } catch (Throwable th) {
            com.hive.core.Logger.INSTANCE.w("[EmulatorDetector] checkBlueStacks()\ne: " + th.getMessage());
        }
    }

    private final String getSystemProperty(String name) throws IllegalAccessException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName("android.os.SystemProperties");
        Object objInvoke = cls.getMethod("get", String.class).invoke(cls, name);
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
        return (String) objInvoke;
    }

    private final boolean isAppInstalled(String packageName) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            PackageManager packageManager = this._activity.getPackageManager();
            objM7415constructorimpl = Result.m7415constructorimpl(Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0L)) : packageManager.getPackageInfo(packageName, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m7418exceptionOrNullimpl(objM7415constructorimpl) == null;
    }

    public final Emulator checkAndyEmulator() {
        Emulator emulator = new Emulator(this, 5, Andy);
        String PRODUCT = Build.PRODUCT;
        Intrinsics.checkNotNullExpressionValue(PRODUCT, "PRODUCT");
        if (StringsKt.contains$default((CharSequence) PRODUCT, (CharSequence) "Andy", false, 2, (Object) null)) {
            emulator.increaseRate("Build.PRODUCT = " + PRODUCT);
        }
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        if (StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Andy", false, 2, (Object) null)) {
            emulator.increaseRate("Build.MANUFACTURER = " + MANUFACTURER);
        }
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        if (StringsKt.contains$default((CharSequence) BRAND, (CharSequence) "Andy", false, 2, (Object) null)) {
            emulator.increaseRate("Build.BRAND = " + BRAND);
        }
        String str = Build.DEVICE;
        if (Intrinsics.areEqual(str, "Andy")) {
            emulator.increaseRate("Build.DEVICE = " + str);
        }
        String str2 = Build.MODEL;
        if (Intrinsics.areEqual(str2, "Andy")) {
            emulator.increaseRate("Build.MODEL = " + str2);
        }
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "Andy", false, 2, (Object) null)) {
            emulator.increaseRate("Build.FINGERPRINT = " + FINGERPRINT);
        }
        if (FileExist("/init.andy.rc")) {
            emulator.increaseRate("/init.andy.rc is Exist");
        }
        return emulator;
    }

    public final Emulator checkBlueStacks() {
        final Emulator emulator = new Emulator(this, 10, BlueStacks);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.base.EmulatorDetector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                EmulatorDetector.checkBlueStacks$lambda$0(emulator);
            }
        });
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory());
            char c = File.separatorChar;
            sb.append(c);
            sb.append("windows");
            sb.append(c);
            sb.append("BstSharedFolder");
            if (new File(sb.toString()).exists()) {
                emulator.increaseRate("Environment.getExternalStorageDirectory() has \"windows/BstShredFolder\"");
            }
        } catch (Exception e) {
            com.hive.core.Logger.INSTANCE.w("[EmulatorDetector] checkBlueStacks()\ne: " + e.getMessage());
        }
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if (device != null) {
                String name = device.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                if (StringsKt.contains$default((CharSequence) name, (CharSequence) "BlueStacks", false, 2, (Object) null)) {
                    emulator.increaseRate("InputDevice contain " + device.getName());
                }
            }
        }
        if ((isAppInstalled("gg.now.accounts") || isAppInstalled("gg.now.billing.service2")) && isAppInstalled("com.uncube.launcher3")) {
            emulator.increaseRate("App Install Package ('gg.now.accounts' or 'gg.now.billing.service2') and 'com.uncube.launcher3'");
        }
        if (this._activity.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            Object systemService = this._activity.getApplicationContext().getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            if (wifiManager.isWifiEnabled() && Build.VERSION.SDK_INT < 31) {
                String ssid = wifiManager.getConnectionInfo().getSSID();
                Intrinsics.checkNotNullExpressionValue(ssid, "getSSID(...)");
                String lowerCase = ssid.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "bluestacks", false, 2, (Object) null)) {
                    emulator.increaseRate("wifi SSID is BlueStacks");
                }
            }
        }
        return emulator;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.hive.base.EmulatorDetector.Emulator checkDefaultAndroidEmulator() {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.base.EmulatorDetector.checkDefaultAndroidEmulator():com.hive.base.EmulatorDetector$Emulator");
    }

    public final Emulator checkEmulator() {
        Emulator emulatorCheckGenymotion = checkGenymotion();
        Emulator emulatorCheckBlueStacks = checkBlueStacks();
        Emulator emulatorCheckAndyEmulator = checkAndyEmulator();
        Emulator emulatorCheckNoxEmulator = checkNoxEmulator();
        Emulator emulatorCheckMemuEmulator = checkMemuEmulator();
        Emulator emulatorCheckKoPlayerEmulator = checkKoPlayerEmulator();
        Emulator emulatorCheckLDPlayerEmulator = checkLDPlayerEmulator();
        Emulator emulatorCheckMuMuEmulator = checkMuMuEmulator();
        Emulator emulatorCheckDefaultAndroidEmulator = checkDefaultAndroidEmulator();
        Emulator emulatorCheckGPGEmulator = checkGPGEmulator();
        Emulator emulatorCheckIrreguarNetwork = checkIrreguarNetwork();
        Emulator emulatorCheckUnknownEmulator = checkUnknownEmulator();
        List listAsList = Arrays.asList(emulatorCheckGenymotion, emulatorCheckBlueStacks, emulatorCheckAndyEmulator, emulatorCheckNoxEmulator, emulatorCheckMemuEmulator, emulatorCheckKoPlayerEmulator, emulatorCheckLDPlayerEmulator, emulatorCheckMuMuEmulator, emulatorCheckDefaultAndroidEmulator, emulatorCheckGPGEmulator);
        Collections.sort(listAsList);
        List listAsList2 = Arrays.asList(emulatorCheckUnknownEmulator, emulatorCheckIrreguarNetwork);
        Collections.sort(listAsList2);
        if (((Emulator) listAsList.get(0)).getRate() > 0) {
            return (Emulator) listAsList.get(0);
        }
        if (((Emulator) listAsList2.get(0)).getRate() > 0) {
            return (Emulator) listAsList2.get(0);
        }
        return null;
    }

    public final Emulator checkGPGEmulator() {
        Emulator emulator = new Emulator(this, 50, Gpg);
        if (Android.INSTANCE.isGPGEmulator()) {
            emulator.increaseRate("Has System Feature com.google.android.play.feature.HPE_EXPERIENCE");
        }
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "HPE", false, 2, (Object) null)) {
            emulator.increaseRate("Build.MODEL = " + MODEL);
        }
        return emulator;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.hive.base.EmulatorDetector.Emulator checkGenymotion() {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.base.EmulatorDetector.checkGenymotion():com.hive.base.EmulatorDetector$Emulator");
    }

    public final Emulator checkIrreguarNetwork() {
        boolean z;
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Emulator emulator = new Emulator(this, 3, Network);
        boolean zHasTransport = false;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            z = false;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                    String name = networkInterfaceNextElement.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (StringsKt.startsWith$default(name, "eth", false, 2, (Object) null)) {
                        z = true;
                    } else {
                        String name2 = networkInterfaceNextElement.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                        StringsKt.startsWith$default(name2, "wlan", false, 2, (Object) null);
                    }
                } catch (Exception e) {
                    e = e;
                    com.hive.core.Logger.INSTANCE.w("[EmulatorDetector] checkIrreguarNetwork()\ne: " + e.getMessage());
                }
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        if (ContextCompat.checkSelfPermission(this._activity, "android.permission.ACCESS_NETWORK_STATE") == 0 && (connectivityManager = (ConnectivityManager) ContextCompat.getSystemService(this._activity, ConnectivityManager.class)) != null && (activeNetwork = connectivityManager.getActiveNetwork()) != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null) {
            networkCapabilities.hasTransport(3);
            zHasTransport = networkCapabilities.hasTransport(1);
        }
        if (z && zHasTransport) {
            emulator.increaseRate("Connect WIFI on Ethernet Adapter");
        }
        return emulator;
    }

    public final Emulator checkKoPlayerEmulator() {
        Emulator emulator = new Emulator(this, 5, KoPlayer);
        String BOOTLOADER = Build.BOOTLOADER;
        Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
        if (StringsKt.contains$default((CharSequence) BOOTLOADER, (CharSequence) "Hdragon", false, 2, (Object) null)) {
            emulator.increaseRate("Build.BOOTLOADER = " + BOOTLOADER);
        }
        String HARDWARE = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
        if (StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "androidVM_x86", false, 2, (Object) null)) {
            emulator.increaseRate("Build.HARDWARE = " + HARDWARE);
        }
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if (device != null) {
                String name = device.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String upperCase = name.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "TTVM", false, 2, (Object) null)) {
                    emulator.increaseRate("InputDevice contain " + device.getName());
                }
            }
        }
        Object systemService = this._activity.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        for (Sensor sensor : ((SensorManager) systemService).getSensorList(-1)) {
            if (sensor != null) {
                String name2 = sensor.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                if (StringsKt.contains$default((CharSequence) name2, (CharSequence) "TiantianVM", false, 2, (Object) null)) {
                    emulator.increaseRate("Sensor contain " + sensor.getName());
                }
            }
        }
        String[] strArr = {"/ueventd.ttVM_x86.rc", "/init.ttVM_x86.rc", "fstab.ttVM_x86", "/ueventd.androidVM_x86.rc", "/init.androidVM_x86.rc"};
        for (int i2 = 0; i2 < 5; i2++) {
            String str = strArr[i2];
            if (FileExist(str)) {
                emulator.increaseRate(str + " is Exist");
            }
        }
        if (isAppInstalled("com.koplay.launcher")) {
            emulator.increaseRate("App Install Package 'com.koplay.launcher'");
        }
        return emulator;
    }

    public final Emulator checkLDPlayerEmulator() {
        Emulator emulator = new Emulator(this, 5, LDPlayer);
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "android_x86_64", false, 2, (Object) null)) {
            String str = Build.DEVICE;
            if (Intrinsics.areEqual(str, "aosp")) {
                emulator.increaseRate("Build.FINGERPRINT = " + FINGERPRINT);
                emulator.increaseRate("Build.DEVICE = " + str);
            }
        }
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (StringsKt.contains$default((CharSequence) FINGERPRINT, (CharSequence) "aosp_marlin", false, 2, (Object) null)) {
            emulator.increaseRate("Build.FINGERPRINT = " + FINGERPRINT);
        }
        return emulator;
    }

    public final Emulator checkMemuEmulator() {
        Emulator emulator = new Emulator(this, 5, MEmu);
        String BOOTLOADER = Build.BOOTLOADER;
        Intrinsics.checkNotNullExpressionValue(BOOTLOADER, "BOOTLOADER");
        if (StringsKt.contains$default((CharSequence) BOOTLOADER, (CharSequence) "uboot", false, 2, (Object) null)) {
            emulator.increaseRate("Build.BOOTLOADER = " + BOOTLOADER);
        }
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if (device != null) {
                String name = device.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String upperCase = name.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "MEMU", false, 2, (Object) null)) {
                    emulator.increaseRate("InputDevice contain " + device.getName());
                }
            }
        }
        if (!isAppInstalled("com.microvirt.launcher") && !isAppInstalled("com.microvirt.launcher2")) {
            return emulator;
        }
        emulator.increaseRate("App Install Package 'com.microvirt.launcher'");
        return emulator;
    }

    public final Emulator checkMuMuEmulator() {
        Emulator emulator = new Emulator(this, 5, MuMu);
        if (!isAppInstalled("com.mumu.launcher") && !isAppInstalled("com.mumu.store")) {
            return emulator;
        }
        emulator.increaseRate("App Install Package 'com.mumu.launcher' or 'com.mumu.store'");
        return emulator;
    }

    public final Emulator checkNoxEmulator() {
        Emulator emulator = new Emulator(this, 5, Nox);
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if (device != null) {
                String name = device.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String upperCase = name.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "NOX", false, 2, (Object) null)) {
                    emulator.increaseRate("InputDevice contain " + device.getName());
                }
            }
        }
        if (FileExist("/init.nox.rc")) {
            emulator.increaseRate("/init.nox.rc is Exist");
        }
        String strInternalGetAndroidId$hive_service_release = Android.INSTANCE.internalGetAndroidId$hive_service_release();
        if (strInternalGetAndroidId$hive_service_release != null && this._activity.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            Object systemService = this._activity.getApplicationContext().getSystemService("wifi");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService;
            if (wifiManager.isWifiEnabled() && Build.VERSION.SDK_INT < 31) {
                String ssid = wifiManager.getConnectionInfo().getSSID();
                Intrinsics.checkNotNullExpressionValue(ssid, "getSSID(...)");
                if (StringsKt.contains$default((CharSequence) ssid, (CharSequence) strInternalGetAndroidId$hive_service_release, false, 2, (Object) null)) {
                    emulator.increaseRate("wifi SSID contain ANDROID_ID");
                }
            }
        }
        if (isAppInstalled("com.vphone.launcher")) {
            emulator.increaseRate("com.vphone.launcher");
        }
        return emulator;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c0 A[Catch: Exception -> 0x01c6, TRY_LEAVE, TryCatch #1 {Exception -> 0x01c6, blocks: (B:51:0x0170, B:53:0x0181, B:55:0x0189, B:57:0x0198, B:59:0x01ae, B:61:0x01c0), top: B:68:0x0170 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.hive.base.EmulatorDetector.Emulator checkUnknownEmulator() {
        /*
            Method dump skipped, instruction units count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.base.EmulatorDetector.checkUnknownEmulator():com.hive.base.EmulatorDetector$Emulator");
    }

    public final String getDeviceListing() {
        String str;
        File[] fileArrListFiles;
        File[] fileArrListFiles2;
        File[] fileArrListFiles3;
        String str2 = ((((((("\n BuildInfo\n\n  Build.PRODUCT: " + Build.PRODUCT) + "\n  Build.MANUFACTURER: " + Build.MANUFACTURER) + "\n  Build.BRAND: " + Build.BRAND) + "\n  Build.DEVICE: " + Build.DEVICE) + "\n  Build.MODEL: " + Build.MODEL) + "\n  Build.HARDWARE: " + Build.HARDWARE) + "\n  Build.FINGERPRINT: " + Build.FINGERPRINT) + "\n InputDevice Lists\n";
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if (device != null) {
                str2 = str2 + "\n  InputDevice name [" + device.getName() + "]\n";
            }
        }
        String str3 = str2 + "\n SensorDevice Lists\n";
        Object systemService = this._activity.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
        Iterator<Sensor> it = ((SensorManager) systemService).getSensorList(-1).iterator();
        while (it.hasNext()) {
            str3 = str3 + "\n  SensorDevice name [" + it.next().getName() + AbstractJsonLexerKt.END_LIST;
        }
        String str4 = str3 + "\n Network WIFI Info\n";
        if (this._activity.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            str = str4 + "\n  ACCESS_WIFI_STATE : PERMISSION_GRANTED";
            Object systemService2 = this._activity.getApplicationContext().getSystemService("wifi");
            Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            WifiManager wifiManager = (WifiManager) systemService2;
            if (wifiManager.getWifiState() == 3 && Build.VERSION.SDK_INT < 31) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                str = (str + "\n  SSID : " + connectionInfo.getSSID()) + "\n  BSSID : " + connectionInfo.getBSSID();
            }
        } else {
            str = str4 + "\n  ACCESS_WIFI_STATE : PERMISSION_DENIED";
        }
        String str5 = str + "\n RootFile Lists\n";
        try {
            File rootDirectory = Environment.getRootDirectory();
            Intrinsics.checkNotNullExpressionValue(rootDirectory, "getRootDirectory(...)");
            Iterator it2 = ArrayIteratorKt.iterator(rootDirectory.list());
            while (it2.hasNext()) {
                str5 = str5 + "  " + rootDirectory.getPath() + FileSystemKt.UnixPathSeparator + ((String) it2.next()) + '\n';
            }
            if (!Intrinsics.areEqual(rootDirectory.getPath(), DomExceptionUtils.SEPARATOR)) {
                File file = new File(DomExceptionUtils.SEPARATOR);
                Iterator it3 = ArrayIteratorKt.iterator(file.list());
                while (it3.hasNext()) {
                    str5 = str5 + "  " + file.getPath() + ((String) it3.next()) + '\n';
                }
            }
        } catch (Throwable th) {
            com.hive.core.Logger.INSTANCE.w("[EmulatorDetector] FileExist()\ne: " + th.getMessage());
        }
        String str6 = (str5 + "\n Context Path Lists\n") + "\n  Context.getFilesDir() : " + this._activity.getFilesDir();
        if (Build.VERSION.SDK_INT > 24) {
            str6 = str6 + "\n  Context.getDataDir() : " + this._activity.getDataDir();
        }
        String str7 = str6 + "\n  Context.getCacheDir() : " + this._activity.getCacheDir();
        Iterator it4 = ArrayIteratorKt.iterator(this._activity.getExternalMediaDirs());
        while (it4.hasNext()) {
            str7 = str7 + "\n  Context.getExternalMediaDirs() : " + ((File) it4.next());
        }
        String str8 = ((((str7 + "\n  Context.getExternalCacheDir()  : " + this._activity.getExternalCacheDir()) + "\n  Context.getExternalFilesDir(null) : " + this._activity.getExternalFilesDir(null)) + "\n  Context.getExternalFilesDir(DIRECTORY_PICTURES) : " + this._activity.getExternalFilesDir(Environment.DIRECTORY_PICTURES)) + "\n  Context.getExternalFilesDir(DIRECTORY_DCIM) : " + this._activity.getExternalFilesDir(Environment.DIRECTORY_DCIM)) + "\n Environment Path Lists\n";
        boolean z = this._activity.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
        String str9 = z ? str8 + "\n  READ_EXTERNAL_STORAGE : PERMISSION_GRANTED" : str8 + "\n  READ_EXTERNAL_STORAGE : PERMISSION_DEINED";
        if (z) {
            String str10 = (str9 + "\n Environment.getDownloadCacheDirectory() : " + Environment.getDownloadCacheDirectory()) + "\n Environment.getExternalStorageState() : " + Environment.getExternalStorageState();
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String str11 = (str10 + "\n Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) : " + externalStoragePublicDirectory) + "\n Environment.getExternalStorageState(DIRECTORY_PICTURES) : " + Environment.getExternalStorageState(externalStoragePublicDirectory);
            if (externalStoragePublicDirectory.exists() && (fileArrListFiles3 = externalStoragePublicDirectory.listFiles()) != null) {
                Iterator it5 = ArrayIteratorKt.iterator(fileArrListFiles3);
                while (it5.hasNext()) {
                    str11 = str11 + "\n  " + ((File) it5.next()).getName();
                }
            }
            File externalStoragePublicDirectory2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            str9 = (str11 + "\n Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) : " + externalStoragePublicDirectory2) + "\n Environment.getExternalStorageState(DIRECTORY_DCIM) : " + Environment.getExternalStorageState(externalStoragePublicDirectory2);
            if (externalStoragePublicDirectory2.exists() && (fileArrListFiles = externalStoragePublicDirectory2.listFiles()) != null) {
                Iterator it6 = ArrayIteratorKt.iterator(fileArrListFiles);
                while (it6.hasNext()) {
                    File file2 = (File) it6.next();
                    str9 = str9 + "\n  " + file2.getName();
                    if (file2.isDirectory() && (fileArrListFiles2 = file2.listFiles()) != null) {
                        Iterator it7 = ArrayIteratorKt.iterator(fileArrListFiles2);
                        while (it7.hasNext()) {
                            str9 = str9 + "\n  " + ((File) it7.next()).getName();
                        }
                    }
                }
            }
        }
        String str12 = str9 + "\n PackageManager.getSystemAvailableFeatures()";
        PackageManager packageManager = this._activity.getPackageManager();
        FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
        Intrinsics.checkNotNullExpressionValue(systemAvailableFeatures, "getSystemAvailableFeatures(...)");
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            String str13 = featureInfo.name;
            if (str13 == null || !packageManager.hasSystemFeature(str13)) {
                str12 = str12 + "\n  OpenGL ES : " + featureInfo.reqGlEsVersion + FileSystemKt.UnixPathSeparator + featureInfo.getGlEsVersion();
            } else if (featureInfo.flags > 1) {
                str12 = str12 + "\n  Requested " + featureInfo.name;
            } else {
                str12 = str12 + "\n  Not Requested " + featureInfo.name;
            }
        }
        Object systemService3 = this._activity.getSystemService("activity");
        Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.app.ActivityManager");
        int i2 = ((ActivityManager) systemService3).getDeviceConfigurationInfo().reqGlEsVersion;
        StringBuilder sb = new StringBuilder();
        sb.append(((-65536) & i2) >> 16);
        sb.append('.');
        sb.append(i2 & 65535);
        String str14 = (str12 + "\n  OpenGL ES Version: " + sb.toString()) + "\n System.getenv()";
        Map<String, String> map = System.getenv();
        Intrinsics.checkNotNull(map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            str14 = str14 + "\n  " + entry.getKey() + " = " + entry.getValue();
        }
        String str15 = str14 + "\n System.getProperties()";
        Properties properties = System.getProperties();
        for (String str16 : properties.stringPropertyNames()) {
            str15 = str15 + "\n  " + str16 + " = " + properties.getProperty(str16);
        }
        return str15;
    }
}
