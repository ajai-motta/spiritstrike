package com.fyber.inneractive.sdk.util;

import com.fyber.inneractive.sdk.logger.FMPLogger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IAlog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1642a = 4;
    public static final com.fyber.inneractive.sdk.logger.a b = new com.fyber.inneractive.sdk.logger.a();
    public static final x0 c = new x0();

    public static void a(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).debug(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).error(str, null, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).info(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).log(1, null, str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).verbose(str, objArr);
        }
    }

    public static void f(String str, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).warning(str, objArr);
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((FMPLogger) it.next()).error(str, th, objArr);
        }
    }

    public static String a(Object obj) {
        return "(" + Thread.currentThread().getName() + "): " + obj.getClass().getSimpleName() + "[" + Integer.toHexString(System.identityHashCode(obj)) + "] ";
    }

    public static String a(Class cls) {
        return "(" + Thread.currentThread().getName() + "): " + cls.getSimpleName() + "[" + Integer.toHexString(System.identityHashCode(cls)) + "] ";
    }
}
