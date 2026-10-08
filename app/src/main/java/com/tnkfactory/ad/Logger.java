package com.tnkfactory.ad;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class Logger {
    public static final String TNKAD_LOG = "TNK_AD";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3099a;

    public static void d(String str) {
        if (f3099a) {
            Log.d(TNKAD_LOG, str);
        }
    }

    public static void e(String str) {
        Log.e(TNKAD_LOG, str);
    }

    public static void enableLogging(boolean z) {
        f3099a = z;
    }

    public static void i(String str) {
        if (f3099a) {
            Log.i(TNKAD_LOG, str);
        }
    }

    public static void v(String str) {
        if (f3099a) {
            Log.v(TNKAD_LOG, str);
        }
    }

    public static void w(String str) {
        if (f3099a) {
            Log.w(TNKAD_LOG, str);
        }
    }
}
