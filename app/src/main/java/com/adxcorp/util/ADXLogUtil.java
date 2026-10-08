package com.adxcorp.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.adxcorp.gdpr.ADXGDPR;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes2.dex */
public class ADXLogUtil {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final String EVENT_CLICK = "Click";
    public static final String EVENT_CLOSED = "Closed";
    public static final String EVENT_FAILED_TO_SHOW = "FailedToShow";
    public static final String EVENT_IMPRESSION = "Impression";
    public static final String EVENT_LOAD = "Load";
    public static final String EVENT_LOAD_FAILURE = "Failure";
    public static final String EVENT_LOAD_SUCCESS = "Success";
    public static final String EVENT_REWARD = "Reward";
    public static final int INFO = 4;
    public static final String INVENTORY_BANNER = "Banner";
    public static final String INVENTORY_INTERSTITIAL = "InterstitialAd";
    public static final String INVENTORY_NATIVE = "Native";
    public static final String INVENTORY_NATIVE_BANNER = "NativeBanner";
    public static final String INVENTORY_NATIVE_INTERSTITIAL = "NativeInterstitialAd";
    public static final String INVENTORY_RV = "RewardedAd";
    public static final String INVENTORY_RV_INTERSTITIAL = "RewardedInterstitialAd";
    public static final String PLATFORM_ADFIT = "AdFit";
    public static final String PLATFORM_ADMANAGER = "AdManager";
    public static final String PLATFORM_ADMOB = "AdMob";
    public static final String PLATFORM_ADPIE = "AdPie";
    public static final String PLATFORM_ADPIE_OR_INHOUSE = "AdPieOrInhouse";
    public static final String PLATFORM_ADX = "ADX";
    public static final String PLATFORM_APPLOVIN = "AppLovin";
    public static final String PLATFORM_CAULY = "Cauly";
    public static final String PLATFORM_CRITEO = "Criteo";
    public static final String PLATFORM_CUSTOMTABS = "CustomTabs";
    public static final String PLATFORM_FACEBOOK = "FAN";
    public static final String PLATFORM_FYBER = "Fyber";
    public static final String PLATFORM_MINTEGRAL = "Mintegral";
    public static final String PLATFORM_MOLOCO = "Moloco";
    public static final String PLATFORM_PANGLE = "Pangle";
    public static final String PLATFORM_TAPJOY = "Tapjoy";
    public static final String PLATFORM_TNK = "Tnk";
    public static final String PLATFORM_UNITYADS = "UnityAds";
    public static final String PLATFORM_VUNGLE = "Vungle";
    private static final String TAG = "ADX";
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static final String VERSION_NAME = ADXGDPR.ADX_SDK_VERSION;
    private static int logLevel = 2;
    private static boolean logEnable = false;

    public static void setLogLevel(int i) {
        logLevel = i;
    }

    public static void setLogEnable(boolean z) {
        logEnable = z;
    }

    private static void debug(String str, String str2) {
        if (!logEnable || logLevel > 3) {
            return;
        }
        if (str2 == null) {
            str2 = AbstractJsonLexerKt.NULL;
        }
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            while (i < str2.length()) {
                int i2 = i + 2048;
                Log.d("ADX-" + VERSION_NAME, str2.substring(i, Math.min(str2.length(), i2)));
                i = i2;
            }
            return;
        }
        while (i < str2.length()) {
            int i3 = i + 2048;
            Log.d("ADX-" + VERSION_NAME + "-" + str, str2.substring(i, Math.min(str2.length(), i3)));
            i = i3;
        }
    }

    private static void info(String str, String str2) {
        if (!logEnable || logLevel > 4) {
            return;
        }
        if (str2 == null) {
            str2 = AbstractJsonLexerKt.NULL;
        }
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            while (i < str2.length()) {
                int i2 = i + 2048;
                Log.i("ADX-" + VERSION_NAME, str2.substring(i, Math.min(str2.length(), i2)));
                i = i2;
            }
            return;
        }
        while (i < str2.length()) {
            int i3 = i + 2048;
            Log.i("ADX-" + VERSION_NAME + "-" + str, str2.substring(i, Math.min(str2.length(), i3)));
            i = i3;
        }
    }

    private static void error(String str, Throwable th) {
        if (!logEnable || logLevel > 6) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("ADX-" + VERSION_NAME, "" + th.toString(), new Throwable(th));
            return;
        }
        Log.e("ADX-" + VERSION_NAME + "-" + str, "" + th.toString(), new Throwable(th));
    }

    private static void error(String str, String str2, Throwable th) {
        if (!logEnable || logLevel > 6) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("ADX-" + VERSION_NAME, "" + str2, th);
            return;
        }
        Log.e("ADX-" + VERSION_NAME + "-" + str, "" + str2, th);
    }

    public static void d(String str, String str2) {
        debug(str, str2);
    }

    public static void i(String str, String str2) {
        info(str, str2);
    }

    public static void e(String str, Throwable th) {
        error(str, th);
    }

    public static void e(String str, String str2, Throwable th) {
        error(str, str2, th);
    }

    public static void logAdapterEvent(String str, String str2, String str3) {
        d("Adapter", "[(ADX)" + str + Marker.ANY_NON_NULL_MARKER + str2 + "] " + str3);
    }

    public static void logAdMobEvent(String str, String str2, String str3) {
        d("Adapter", "[(AdMob)" + str + Marker.ANY_NON_NULL_MARKER + str2 + "] " + str3);
    }

    public static void logAppLovinEvent(String str, String str2, String str3) {
        d("Adapter", "[(AppLovin)" + str + Marker.ANY_NON_NULL_MARKER + str2 + "] " + str3);
    }

    public static boolean isDebuggable(Context context) {
        try {
            return (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static String getSpaces(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
        return sb.toString();
    }

    public static void printViewHierarchy(View view) {
        printViewHierarchy(view, 0);
    }

    public static void printViewHierarchy(View view, int i) {
        if (!logEnable || logLevel > 3) {
            return;
        }
        Log.d("ADX", getSpaces(i) + view);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i2 = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            printViewHierarchy(viewGroup.getChildAt(i2), i + 1);
            i2++;
        }
    }
}
