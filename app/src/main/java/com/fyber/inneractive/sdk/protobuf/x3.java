package com.fyber.inneractive.sdk.protobuf;

import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f1592a;
    public static final Class b;
    public static final w3 c;
    public static final boolean d;
    public static final boolean e;
    public static final long f;
    public static final long g;
    public static final boolean h;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4 A[PHI: r3
  0x00a4: PHI (r3v21 java.lang.reflect.Field) = (r3v19 java.lang.reflect.Field), (r3v24 java.lang.reflect.Field) binds: [B:39:0x00b8, B:31:0x00a2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    static {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.x3.<clinit>():void");
    }

    public static int a(Class cls) {
        if (e) {
            return c.f1588a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static void b(Class cls) {
        if (e) {
            c.f1588a.arrayIndexScale(cls);
        }
    }

    public static int c(Object obj, long j) {
        return c.f1588a.getInt(obj, j);
    }

    public static long d(Object obj, long j) {
        return c.f1588a.getLong(obj, j);
    }

    public static Object e(Object obj, long j) {
        return c.f1588a.getObject(obj, j);
    }

    public static void a(Object obj, long j, int i) {
        c.f1588a.putInt(obj, j, i);
    }

    public static byte b(Object obj, long j) {
        return (byte) ((c(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean c(Class cls) {
        if (!d.a()) {
            return false;
        }
        try {
            Class cls2 = b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void b(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (c(obj, j2) & (~(255 << i))));
    }

    public static void a(Object obj, long j, long j2) {
        c.f1588a.putLong(obj, j, j2);
    }

    public static void a(long j, Object obj, Object obj2) {
        c.f1588a.putObject(obj, j, obj2);
    }

    public static byte a(Object obj, long j) {
        return (byte) ((c(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255);
    }

    public static void a(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int iC = c(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (iC & (~(255 << i))));
    }

    public static void a(Throwable th) {
        Logger.getLogger(x3.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }
}
