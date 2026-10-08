package com.gomfactory.adpie.sdk.util;

import android.text.TextUtils;
import android.util.Log;
import com.gomfactory.adpie.sdk.AdPieSDK;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class AdPieLog {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static boolean logEnable = false;
    public static int logLevel = 2;

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
                Log.d(AdPieSDK.TAG + "-1.16.1", str2.substring(i, Math.min(str2.length(), i2)));
                i = i2;
            }
            return;
        }
        while (i < str2.length()) {
            int i3 = i + 2048;
            Log.d(AdPieSDK.TAG + "-1.16.1-" + str, str2.substring(i, Math.min(str2.length(), i3)));
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
                Log.i(AdPieSDK.TAG + "-1.16.1", str2.substring(i, Math.min(str2.length(), i2)));
                i = i2;
            }
            return;
        }
        while (i < str2.length()) {
            int i3 = i + 2048;
            Log.i(AdPieSDK.TAG + "-1.16.1-" + str, str2.substring(i, Math.min(str2.length(), i3)));
            i = i3;
        }
    }

    private static void error(String str, Exception exc) {
        if (!logEnable || logLevel > 6) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(AdPieSDK.TAG + "-1.16.1", "" + exc.toString(), new Throwable(exc));
            return;
        }
        Log.e(AdPieSDK.TAG + "-1.16.1-" + str, "" + exc.toString(), new Throwable(exc));
    }

    private static void error(String str, String str2, Throwable th) {
        if (!logEnable || logLevel > 6) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e(AdPieSDK.TAG + "-1.16.1", "" + str2, th);
            return;
        }
        Log.e(AdPieSDK.TAG + "-1.16.1-" + str, "" + str2, th);
    }

    public static void d(String str, String str2) {
        debug(str, str2);
    }

    public static void i(String str, String str2) {
        info(str, str2);
    }

    public static void e(String str, Exception exc) {
        error(str, exc);
    }

    public static void e(String str, String str2, Throwable th) {
        error(str, str2, th);
    }
}
