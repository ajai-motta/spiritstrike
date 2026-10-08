package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.InputDevice;

/* JADX INFO: loaded from: classes6.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3093a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    public static volatile boolean g;
    private static boolean h;
    private static InputManager i;

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3094a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;

        a(String str, Context context, int i) {
            this.f3094a = str;
            this.b = context;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.g) {
                com.pgl.ssdk.ces.a.meta(171, null, this.f3094a);
            }
            InputManager inputManagerB = y.b(this.b);
            if (inputManagerB == null) {
                return;
            }
            InputDevice inputDevice = inputManagerB.getInputDevice(this.c);
            y.h();
            if (inputDevice == null) {
                y.b();
                y.c();
                y.c("nihc");
            } else if (inputDevice.isVirtual()) {
                y.d();
                y.e();
                y.c("vihc");
            } else {
                if (Build.VERSION.SDK_INT < 29 || !inputDevice.isExternal()) {
                    return;
                }
                y.f();
                y.g();
                y.c("eihc");
            }
        }
    }

    static /* synthetic */ int b() {
        int i2 = c;
        c = i2 + 1;
        return i2;
    }

    static /* synthetic */ int c() {
        int i2 = f;
        f = i2 + 1;
        return i2;
    }

    static /* synthetic */ int d() {
        int i2 = f3093a;
        f3093a = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e() {
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f() {
        int i2 = b;
        b = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g() {
        int i2 = e;
        e = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (h) {
            return;
        }
        try {
            SharedPreferences sharedPreferencesA = ax.a(z.a());
            if (sharedPreferencesA != null) {
                f = sharedPreferencesA.getInt("nihc", 0);
                e = sharedPreferencesA.getInt("eihc", 0);
                d = sharedPreferencesA.getInt("vihc", 0);
                h = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        h();
        str.hashCode();
        str.hashCode();
        switch (str) {
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        try {
            SharedPreferences sharedPreferencesA = ax.a(z.a());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putInt(str, sharedPreferencesA.getInt(str, 0) + 1).apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.view.MotionEvent r2, android.content.Context r3) {
        /*
            if (r2 == 0) goto L4f
            if (r3 == 0) goto L4f
            boolean r0 = com.pgl.ssdk.y.g
            if (r0 == 0) goto L42
            r0 = 0
            int r0 = r2.getToolType(r0)     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1c
            int r0 = r2.getSource()     // Catch: java.lang.Throwable -> L42
            if (r0 == 0) goto L1c
            int r0 = r2.getSource()     // Catch: java.lang.Throwable -> L42
            r1 = 2
            if (r0 != r1) goto L42
        L1c:
            java.lang.Exception r0 = new java.lang.Exception     // Catch: java.lang.Throwable -> L42
            r0.<init>()     // Catch: java.lang.Throwable -> L42
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()     // Catch: java.lang.Throwable -> L42
            java.lang.String r0 = java.util.Arrays.toString(r0)     // Catch: java.lang.Throwable -> L42
            java.lang.String r1 = "android.view.InputEventReceiver"
            boolean r1 = r0.contains(r1)     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L42
            java.lang.String r1 = "android.view.ViewRootImpl$WindowInputEventReceiver"
            boolean r1 = r0.contains(r1)     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L42
            java.lang.String r1 = "android.view.ViewRootImpl$InputStage"
            boolean r1 = r0.contains(r1)     // Catch: java.lang.Throwable -> L42
            if (r1 != 0) goto L42
            goto L43
        L42:
            r0 = 0
        L43:
            int r2 = r2.getDeviceId()
            com.pgl.ssdk.y$a r1 = new com.pgl.ssdk.y$a
            r1.<init>(r0, r3, r2)
            com.pgl.ssdk.ar.b(r1)
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.y.a(android.view.MotionEvent, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputManager b(Context context) {
        if (i == null) {
            i = (InputManager) context.getSystemService("input");
        }
        return i;
    }
}
