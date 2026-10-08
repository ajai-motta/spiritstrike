package com.unity3d.player;

import android.os.Build;
import com.facebook.internal.AnalyticsEvents;
import java.lang.Thread;
import java.util.Arrays;

/* JADX INFO: renamed from: com.unity3d.player.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3192g0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Thread.UncaughtExceptionHandler f3309a;
    private String b;

    C3192g0() {
    }

    static void a(String str) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof C3192g0) {
            C3192g0 c3192g0 = (C3192g0) defaultUncaughtExceptionHandler;
            int i = -1;
            int i2 = -1;
            while (true) {
                int iIndexOf = str.indexOf(47, i + 1);
                if (iIndexOf == -1) {
                    break;
                }
                i2 = i;
                i = iIndexOf;
            }
            c3192g0.b = i2 < 0 ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : str.substring(i2 + 1);
        }
    }

    final synchronized void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == this) {
            return;
        }
        this.f3309a = defaultUncaughtExceptionHandler;
        this.b = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        try {
            Error error = new Error(String.format("FATAL EXCEPTION [%s]\n", thread.getName()) + String.format("Unity version     : %s\n", "2022.3.62f2") + String.format("Device model      : %s %s\n", Build.MANUFACTURER, Build.MODEL) + String.format("Device fingerprint: %s\n", Build.FINGERPRINT) + String.format("CPU supported ABI : %s\n", Arrays.toString(Build.SUPPORTED_ABIS)) + String.format("Build Type        : %s\n", com.hive.core.BuildConfig.SDK_VERSION_TRACK) + String.format("Scripting Backend : %s\n", "IL2CPP") + String.format("Libs loaded from  : %s\n", this.b) + String.format("Strip Engine Code : %s\n", Boolean.TRUE));
            error.setStackTrace(new StackTraceElement[0]);
            error.initCause(th);
            this.f3309a.uncaughtException(thread, error);
        } catch (Throwable unused) {
            this.f3309a.uncaughtException(thread, th);
        }
    }
}
