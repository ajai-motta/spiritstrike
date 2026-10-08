package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class p2 {
    public static final p2 c = new p2();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x1 f1573a = new x1();

    public final t2 a(Class cls) {
        t2 t2VarA;
        j2 j2Var;
        Class cls2;
        Charset charset = l1.f1565a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        t2 t2Var = (t2) this.b.get(cls);
        if (t2Var != null) {
            return t2Var;
        }
        x1 x1Var = this.f1573a;
        x1Var.getClass();
        Class cls3 = u2.f1583a;
        if (!z0.class.isAssignableFrom(cls) && (cls2 = u2.f1583a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        r2 r2VarB = x1Var.f1591a.b(cls);
        if ((r2VarB.d & 2) == 2) {
            if (z0.class.isAssignableFrom(cls)) {
                j2Var = new j2(u2.d, k0.f1562a, r2VarB.f1577a);
            } else {
                o3 o3Var = u2.b;
                j0 j0Var = k0.b;
                if (j0Var == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                j2Var = new j2(o3Var, j0Var, r2VarB.f1577a);
            }
            t2VarA = j2Var;
        } else if (z0.class.isAssignableFrom(cls)) {
            t2VarA = ((r2VarB.d & 1) == 1 ? o2.PROTO2 : o2.PROTO3) == o2.PROTO2 ? i2.a(r2VarB, l2.b, t1.b, u2.d, k0.f1562a, a2.b) : i2.a(r2VarB, l2.b, t1.b, u2.d, (j0) null, a2.b);
        } else {
            if (((r2VarB.d & 1) == 1 ? o2.PROTO2 : o2.PROTO3) == o2.PROTO2) {
                k2 k2Var = l2.f1566a;
                r1 r1Var = t1.f1582a;
                o3 o3Var2 = u2.b;
                j0 j0Var2 = k0.b;
                if (j0Var2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                t2VarA = i2.a(r2VarB, k2Var, r1Var, o3Var2, j0Var2, a2.f1538a);
            } else {
                t2VarA = i2.a(r2VarB, l2.f1566a, t1.f1582a, u2.c, (j0) null, a2.f1538a);
            }
        }
        t2 t2Var2 = (t2) this.b.putIfAbsent(cls, t2VarA);
        return t2Var2 != null ? t2Var2 : t2VarA;
    }
}
