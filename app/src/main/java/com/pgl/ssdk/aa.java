package com.pgl.ssdk;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;

/* JADX INFO: loaded from: classes6.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile DisplayManager.DisplayListener f3057a;
    private static volatile boolean b;
    private static String c;
    private static String d;
    private static String e;
    private static volatile boolean f;
    private static volatile boolean g;
    private static DisplayManager h;

    static class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            aa.b(i, 1);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
            aa.b(i, 3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            aa.b(i, 2);
        }
    }

    public static void b(Context context) {
        Handler handlerB;
        if (b) {
            return;
        }
        if (f3057a == null) {
            f3057a = new a();
        }
        if (h == null) {
            h = (DisplayManager) context.getSystemService("display");
        }
        if (h == null || (handlerB = ar.b()) == null) {
            return;
        }
        try {
            h.registerDisplayListener(f3057a, handlerB);
            b = true;
        } catch (Exception unused) {
        }
    }

    private static String a(Display display) {
        String name = display.getName();
        Object objA = av.a(display, display.getClass(), "getType", new Class[0], new Object[0]);
        Object objA2 = av.a(display, display.getClass(), "getOwnerPackageName", new Class[0], new Object[0]);
        Object objA3 = av.a(null, display.getClass(), "TYPE_VIRTUAL", null);
        return String.format("%s#%s#%b", objA2, name, Boolean.valueOf((objA == null || objA3 == null || ((Integer) objA).intValue() != ((Integer) objA3).intValue()) ? false : true));
    }

    private static String a(int i) {
        Display display = h.getDisplay(i);
        return display != null ? a(display) : "pd";
    }

    public static boolean a(Context context) {
        Display[] displays;
        if (b && (c != null || d != null || e != null)) {
            return true;
        }
        if (b && f) {
            return g;
        }
        int i = 0;
        if (context == null) {
            return false;
        }
        if (h == null) {
            h = (DisplayManager) context.getSystemService("display");
        }
        DisplayManager displayManager = h;
        if (displayManager != null && (displays = displayManager.getDisplays()) != null) {
            int length = displays.length;
            while (true) {
                if (i < length) {
                    Display display = displays[i];
                    if (display != null && display.getDisplayId() != 0) {
                        g = true;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        f = true;
        return g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, int i2) {
        if (i == 0) {
            return;
        }
        try {
            String strA = a(i);
            if (i2 == 1) {
                if (strA.equals(c)) {
                    return;
                }
                c = strA;
            } else {
                if (i2 != 2) {
                    if (i2 != 3 || strA.equals(e)) {
                        return;
                    }
                    e = strA;
                    return;
                }
                if (strA.equals(d)) {
                    return;
                }
                d = strA;
            }
        } catch (Throwable unused) {
        }
    }
}
