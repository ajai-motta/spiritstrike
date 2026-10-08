package com.fyber.inneractive.sdk.protobuf;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public final class i2 implements t2 {
    public static final int[] q = new int[0];
    public static final Unsafe r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f1559a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final d2 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int[] i;
    public final int j;
    public final int k;
    public final k2 l;
    public final t1 m;
    public final o3 n;
    public final j0 o;
    public final z1 p;

    static {
        Unsafe unsafe;
        try {
            unsafe = (Unsafe) AccessController.doPrivileged(new s3());
        } catch (Throwable unused) {
            unsafe = null;
        }
        r = unsafe;
    }

    public i2(int[] iArr, Object[] objArr, int i, int i2, d2 d2Var, boolean z, int[] iArr2, int i3, int i4, k2 k2Var, t1 t1Var, o3 o3Var, j0 j0Var, z1 z1Var) {
        this.f1559a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i2;
        this.g = d2Var instanceof z0;
        this.h = z;
        this.f = j0Var != null && (d2Var instanceof GeneratedMessageLite$ExtendableMessage);
        this.i = iArr2;
        this.j = i3;
        this.k = i4;
        this.l = k2Var;
        this.m = t1Var;
        this.n = o3Var;
        this.o = j0Var;
        this.e = d2Var;
        this.p = z1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fyber.inneractive.sdk.protobuf.i2 a(com.fyber.inneractive.sdk.protobuf.r2 r33, com.fyber.inneractive.sdk.protobuf.k2 r34, com.fyber.inneractive.sdk.protobuf.t1 r35, com.fyber.inneractive.sdk.protobuf.o3 r36, com.fyber.inneractive.sdk.protobuf.j0 r37, com.fyber.inneractive.sdk.protobuf.z1 r38) {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.a(com.fyber.inneractive.sdk.protobuf.r2, com.fyber.inneractive.sdk.protobuf.k2, com.fyber.inneractive.sdk.protobuf.t1, com.fyber.inneractive.sdk.protobuf.o3, com.fyber.inneractive.sdk.protobuf.j0, com.fyber.inneractive.sdk.protobuf.z1):com.fyber.inneractive.sdk.protobuf.i2");
    }

    public static long d(int i) {
        return i & 1048575;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final boolean b(Object obj, Object obj2) {
        boolean zA;
        int length = this.f1559a.length;
        for (int i = 0; i < length; i += 3) {
            int[] iArr = this.f1559a;
            int i2 = iArr[i + 1];
            long j = i2 & 1048575;
            switch ((i2 & 267386880) >>> 20) {
                case 0:
                    if (a(i, obj, obj2)) {
                        w3 w3Var = x3.c;
                        if (Double.doubleToLongBits(w3Var.c(obj, j)) == Double.doubleToLongBits(w3Var.c(obj2, j))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 1:
                    if (a(i, obj, obj2)) {
                        w3 w3Var2 = x3.c;
                        if (Float.floatToIntBits(w3Var2.d(obj, j)) == Float.floatToIntBits(w3Var2.d(obj2, j))) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 2:
                    if (!a(i, obj, obj2) || x3.d(obj, j) != x3.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!a(i, obj, obj2) || x3.d(obj, j) != x3.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!a(i, obj, obj2) || x3.c(obj, j) != x3.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!a(i, obj, obj2) || x3.d(obj, j) != x3.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!a(i, obj, obj2) || x3.c(obj, j) != x3.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (a(i, obj, obj2)) {
                        w3 w3Var3 = x3.c;
                        if (w3Var3.a(obj, j) == w3Var3.a(obj2, j)) {
                            continue;
                            break;
                        }
                    }
                    return false;
                case 8:
                    if (!a(i, obj, obj2) || !u2.a(x3.e(obj, j), x3.e(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!a(i, obj, obj2) || !u2.a(x3.e(obj, j), x3.e(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!a(i, obj, obj2) || !u2.a(x3.e(obj, j), x3.e(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!a(i, obj, obj2) || x3.c(obj, j) != x3.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!a(i, obj, obj2) || x3.c(obj, j) != x3.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!a(i, obj, obj2) || x3.c(obj, j) != x3.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!a(i, obj, obj2) || x3.d(obj, j) != x3.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!a(i, obj, obj2) || x3.c(obj, j) != x3.c(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!a(i, obj, obj2) || x3.d(obj, j) != x3.d(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!a(i, obj, obj2) || !u2.a(x3.e(obj, j), x3.e(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zA = u2.a(x3.e(obj, j), x3.e(obj2, j));
                    break;
                case 50:
                    zA = u2.a(x3.e(obj, j), x3.e(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long j2 = iArr[i + 2] & 1048575;
                    if (x3.c(obj, j2) != x3.c(obj2, j2) || !u2.a(x3.e(obj, j), x3.e(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zA) {
                return false;
            }
        }
        this.n.getClass();
        n3 n3Var = ((z0) obj).unknownFields;
        this.n.getClass();
        if (!n3Var.equals(((z0) obj2).unknownFields)) {
            return false;
        }
        if (!this.f) {
            return true;
        }
        this.o.getClass();
        n0 n0Var = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
        this.o.getClass();
        return n0Var.equals(((GeneratedMessageLite$ExtendableMessage) obj2).extensions);
    }

    public final t2 c(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.b;
        t2 t2Var = (t2) objArr[i2];
        if (t2Var != null) {
            return t2Var;
        }
        t2 t2VarA = p2.c.a((Class) objArr[i2 + 1]);
        this.b[i2] = t2VarA;
        return t2VarA;
    }

    public final void e(int i, Object obj, Object obj2) {
        int[] iArr = this.f1559a;
        int i2 = iArr[i + 1];
        int i3 = iArr[i];
        long j = i2 & 1048575;
        if (a(obj2, i3, i)) {
            Object objE = a(obj, i3, i) ? x3.e(obj, j) : null;
            Object objE2 = x3.e(obj2, j);
            if (objE != null && objE2 != null) {
                x3.a(j, obj, l1.a(objE, objE2));
                b(obj, i3, i);
            } else if (objE2 != null) {
                x3.a(j, obj, objE2);
                b(obj, i3, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x0228 A[PHI: r2
  0x0228: PHI (r2v30 int) = (r2v10 int), (r2v31 int) binds: [B:81:0x0225, B:40:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.t2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int d(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 820
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.d(java.lang.Object):int");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void c(Object obj) {
        int i;
        int i2 = this.j;
        while (true) {
            i = this.k;
            if (i2 >= i) {
                break;
            }
            long j = this.f1559a[this.i[i2] + 1] & 1048575;
            Object objE = x3.e(obj, j);
            if (objE != null) {
                this.p.getClass();
                ((y1) objE).f1593a = false;
                x3.a(j, obj, objE);
            }
            i2++;
        }
        int length = this.i.length;
        while (i < length) {
            this.m.a(obj, this.i[i]);
            i++;
        }
        this.n.getClass();
        ((z0) obj).unknownFields.e = false;
        if (this.f) {
            this.o.getClass();
            ((GeneratedMessageLite$ExtendableMessage) obj).extensions.e();
        }
    }

    public final void c(int i, Object obj, Object obj2) {
        long j = this.f1559a[i + 1] & 1048575;
        Object objE = x3.e(obj, j);
        if (objE != null) {
            this.p.getClass();
            if (!((y1) objE).f1593a) {
                this.p.getClass();
                y1 y1Var = y1.b;
                y1 y1Var2 = y1Var.isEmpty() ? new y1() : new y1(y1Var);
                this.p.getClass();
                z1.a(y1Var2, objE);
                x3.a(j, obj, y1Var2);
                objE = y1Var2;
            }
        } else {
            this.p.getClass();
            y1 y1Var3 = y1.b;
            objE = y1Var3.isEmpty() ? new y1() : new y1(y1Var3);
            x3.a(j, obj, objE);
        }
        this.p.getClass();
        this.p.getClass();
        obj2.getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0634 A[PHI: r6
  0x0634: PHI (r6v70 int) = (r6v8 int), (r6v72 int) binds: [B:236:0x062d, B:59:0x017e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0a28  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0ad6  */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0ca8 A[PHI: r4
  0x0ca8: PHI (r4v68 int) = (r4v5 int), (r4v70 int) binds: [B:487:0x0ca1, B:311:0x080b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.t2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(java.lang.Object r22) {
        /*
            Method dump skipped, instruction units count: 3628
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.b(java.lang.Object):int");
    }

    public final void d(int i, Object obj, Object obj2) {
        long j = this.f1559a[i + 1] & 1048575;
        if (a(i, obj2)) {
            Object objE = x3.e(obj, j);
            Object objE2 = x3.e(obj2, j);
            if (objE != null && objE2 != null) {
                x3.a(j, obj, l1.a(objE, objE2));
                b(i, obj);
            } else if (objE2 != null) {
                x3.a(j, obj, objE2);
                b(i, obj);
            }
        }
    }

    public static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final Object a() {
        k2 k2Var = this.l;
        d2 d2Var = this.e;
        k2Var.getClass();
        return ((z0) d2Var).dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void a(Object obj, Object obj2) {
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.f1559a;
            if (i < iArr.length) {
                int i2 = iArr[i + 1];
                long j = 1048575 & i2;
                int i3 = iArr[i];
                switch ((i2 & 267386880) >>> 20) {
                    case 0:
                        if (a(i, obj2)) {
                            w3 w3Var = x3.c;
                            w3Var.a(obj, j, w3Var.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 1:
                        if (a(i, obj2)) {
                            w3 w3Var2 = x3.c;
                            w3Var2.a(obj, j, w3Var2.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 2:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 3:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 4:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 5:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 6:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 7:
                        if (a(i, obj2)) {
                            w3 w3Var3 = x3.c;
                            w3Var3.a(obj, j, w3Var3.a(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 8:
                        if (a(i, obj2)) {
                            x3.a(j, obj, x3.e(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 9:
                        d(i, obj, obj2);
                        break;
                    case 10:
                        if (a(i, obj2)) {
                            x3.a(j, obj, x3.e(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 11:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 12:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 13:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 14:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 15:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.c(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 16:
                        if (a(i, obj2)) {
                            x3.a(obj, j, x3.d(obj2, j));
                            b(i, obj);
                        }
                        break;
                    case 17:
                        d(i, obj, obj2);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.m.a(j, obj, obj2);
                        break;
                    case 50:
                        z1 z1Var = this.p;
                        Class cls = u2.f1583a;
                        Object objE = x3.e(obj, j);
                        Object objE2 = x3.e(obj2, j);
                        z1Var.getClass();
                        x3.a(j, obj, z1.a(objE, objE2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (a(obj2, i3, i)) {
                            x3.a(j, obj, x3.e(obj2, j));
                            b(obj, i3, i);
                        }
                        break;
                    case 60:
                        e(i, obj, obj2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (a(obj2, i3, i)) {
                            x3.a(j, obj, x3.e(obj2, j));
                            b(obj, i3, i);
                        }
                        break;
                    case 68:
                        e(i, obj, obj2);
                        break;
                }
                i += 3;
            } else {
                o3 o3Var = this.n;
                Class cls2 = u2.f1583a;
                o3Var.getClass();
                z0 z0Var = (z0) obj;
                n3 n3VarA = z0Var.unknownFields;
                n3 n3Var = ((z0) obj2).unknownFields;
                if (!n3Var.equals(n3.f)) {
                    n3VarA = n3.a(n3VarA, n3Var);
                }
                z0Var.unknownFields = n3VarA;
                if (this.f) {
                    this.o.getClass();
                    n0 n0Var = ((GeneratedMessageLite$ExtendableMessage) obj2).extensions;
                    if (n0Var.f1568a.isEmpty()) {
                        return;
                    }
                    ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable().a(n0Var);
                    return;
                }
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0558  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x05b4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05d8  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0643  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0727  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x078e  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x07a5  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x07bc  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x07ea  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0816  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x082b  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0845  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0867  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0876  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0894  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x08c1  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x08d0  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x08fd  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x092a  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0948  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0957  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0966  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0975  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0986  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0994  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x09a6  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x09b3  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x09b6  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x09c6  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x09d6  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x09e6  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x09f6  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0a06  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0a16  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0a26  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0a36  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0a48  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0a56  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0a64  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0a74  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0a84  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0a94  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0aa4  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0ab6  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0acc  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0ada  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x0aeb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0afa  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0b09  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0b18  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0b27  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0b36  */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0b45  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x05fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02fa  */
    @Override // com.fyber.inneractive.sdk.protobuf.t2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r20, com.fyber.inneractive.sdk.protobuf.c0 r21) {
        /*
            Method dump skipped, instruction units count: 3234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.a(java.lang.Object, com.fyber.inneractive.sdk.protobuf.c0):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0447  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0377  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.Object r12, com.fyber.inneractive.sdk.protobuf.c0 r13) {
        /*
            Method dump skipped, instruction units count: 1636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.b(java.lang.Object, com.fyber.inneractive.sdk.protobuf.c0):void");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void a(Object obj, s2 s2Var, h0 h0Var) {
        h0Var.getClass();
        a(this.n, this.o, obj, s2Var, h0Var);
    }

    public final void a(o3 o3Var, j0 j0Var, Object obj, s2 s2Var, h0 h0Var) {
        x0 x0VarA;
        Object objA;
        Object objB = null;
        n0 n0VarEnsureExtensionsAreMutable = null;
        while (true) {
            try {
                int iS = s2Var.s();
                int iA = (iS < this.c || iS > this.d) ? -1 : a(iS, 0);
                if (iA < 0) {
                    if (iS == Integer.MAX_VALUE) {
                        if (objB != null) {
                            return;
                        } else {
                            return;
                        }
                    }
                    if (this.f) {
                        d2 d2Var = this.e;
                        j0Var.getClass();
                        x0VarA = h0Var.a(iS, d2Var);
                    } else {
                        x0VarA = null;
                    }
                    if (x0VarA != null) {
                        if (n0VarEnsureExtensionsAreMutable == null) {
                            j0Var.getClass();
                            n0VarEnsureExtensionsAreMutable = ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable();
                        }
                        j0Var.getClass();
                        objA = j0.a(s2Var, x0VarA, h0Var, n0VarEnsureExtensionsAreMutable, objB, o3Var);
                        objB = objA;
                    } else {
                        o3Var.getClass();
                        if (objB == null) {
                            z0 z0Var = (z0) obj;
                            n3 n3Var = z0Var.unknownFields;
                            if (n3Var == n3.f) {
                                n3Var = new n3();
                                z0Var.unknownFields = n3Var;
                            }
                            objB = n3Var;
                        }
                        if (!o3.a(objB, s2Var)) {
                            for (int i = this.j; i < this.k; i++) {
                                objB = b(this.i[i], obj, objB);
                            }
                            if (objB != null) {
                                o3.a(obj, objB);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    int i2 = this.f1559a[iA + 1];
                    switch ((267386880 & i2) >>> 20) {
                        case 0:
                            x3.c.a(obj, d(i2), s2Var.h());
                            b(iA, obj);
                            break;
                        case 1:
                            x3.c.a(obj, d(i2), s2Var.k());
                            b(iA, obj);
                            break;
                        case 2:
                            x3.a(obj, d(i2), s2Var.o());
                            b(iA, obj);
                            break;
                        case 3:
                            x3.a(obj, d(i2), s2Var.f());
                            b(iA, obj);
                            break;
                        case 4:
                            x3.a(obj, d(i2), s2Var.d());
                            b(iA, obj);
                            break;
                        case 5:
                            x3.a(obj, d(i2), s2Var.g());
                            b(iA, obj);
                            break;
                        case 6:
                            x3.a(obj, d(i2), s2Var.q());
                            b(iA, obj);
                            break;
                        case 7:
                            x3.c.a(obj, d(i2), s2Var.r());
                            b(iA, obj);
                            break;
                        case 8:
                            if ((i2 & 536870912) != 0) {
                                x3.a(i2 & 1048575, obj, s2Var.p());
                            } else if (this.g) {
                                x3.a(i2 & 1048575, obj, s2Var.n());
                            } else {
                                x3.a(i2 & 1048575, obj, s2Var.a());
                            }
                            b(iA, obj);
                            break;
                        case 9:
                            if (a(iA, obj)) {
                                x3.a(d(i2), obj, l1.a(x3.e(obj, d(i2)), s2Var.b(c(iA), h0Var)));
                            } else {
                                x3.a(d(i2), obj, s2Var.b(c(iA), h0Var));
                                b(iA, obj);
                            }
                            break;
                        case 10:
                            x3.a(d(i2), obj, s2Var.a());
                            b(iA, obj);
                            break;
                        case 11:
                            x3.a(obj, d(i2), s2Var.c());
                            b(iA, obj);
                            break;
                        case 12:
                            int iB = s2Var.b();
                            a(iA);
                            x3.a(obj, d(i2), iB);
                            b(iA, obj);
                            break;
                        case 13:
                            x3.a(obj, d(i2), s2Var.m());
                            b(iA, obj);
                            break;
                        case 14:
                            x3.a(obj, d(i2), s2Var.t());
                            b(iA, obj);
                            break;
                        case 15:
                            x3.a(obj, d(i2), s2Var.j());
                            b(iA, obj);
                            break;
                        case 16:
                            x3.a(obj, d(i2), s2Var.l());
                            b(iA, obj);
                            break;
                        case 17:
                            if (a(iA, obj)) {
                                x3.a(d(i2), obj, l1.a(x3.e(obj, d(i2)), s2Var.a(c(iA), h0Var)));
                            } else {
                                x3.a(d(i2), obj, s2Var.a(c(iA), h0Var));
                                b(iA, obj);
                            }
                            break;
                        case 18:
                            s2Var.j(this.m.b(obj, d(i2)));
                            break;
                        case 19:
                            s2Var.d(this.m.b(obj, d(i2)));
                            break;
                        case 20:
                            s2Var.k(this.m.b(obj, d(i2)));
                            break;
                        case 21:
                            s2Var.a(this.m.b(obj, d(i2)));
                            break;
                        case 22:
                            s2Var.o(this.m.b(obj, d(i2)));
                            break;
                        case 23:
                            s2Var.n(this.m.b(obj, d(i2)));
                            break;
                        case 24:
                            s2Var.e(this.m.b(obj, d(i2)));
                            break;
                        case 25:
                            s2Var.l(this.m.b(obj, d(i2)));
                            break;
                        case 26:
                            a(obj, i2, s2Var);
                            break;
                        case 27:
                            a(obj, i2, s2Var, c(iA), h0Var);
                            break;
                        case 28:
                            s2Var.h(this.m.b(obj, d(i2)));
                            break;
                        case 29:
                            s2Var.i(this.m.b(obj, d(i2)));
                            break;
                        case 30:
                            List listB = this.m.b(obj, d(i2));
                            s2Var.p(listB);
                            a(iA);
                            objA = u2.a(iS, listB, objB, o3Var);
                            objB = objA;
                            break;
                        case 31:
                            s2Var.f(this.m.b(obj, d(i2)));
                            break;
                        case 32:
                            s2Var.m(this.m.b(obj, d(i2)));
                            break;
                        case 33:
                            s2Var.c(this.m.b(obj, d(i2)));
                            break;
                        case 34:
                            s2Var.g(this.m.b(obj, d(i2)));
                            break;
                        case 35:
                            s2Var.j(this.m.b(obj, d(i2)));
                            break;
                        case 36:
                            s2Var.d(this.m.b(obj, d(i2)));
                            break;
                        case 37:
                            s2Var.k(this.m.b(obj, d(i2)));
                            break;
                        case 38:
                            s2Var.a(this.m.b(obj, d(i2)));
                            break;
                        case 39:
                            s2Var.o(this.m.b(obj, d(i2)));
                            break;
                        case 40:
                            s2Var.n(this.m.b(obj, d(i2)));
                            break;
                        case 41:
                            s2Var.e(this.m.b(obj, d(i2)));
                            break;
                        case 42:
                            s2Var.l(this.m.b(obj, d(i2)));
                            break;
                        case 43:
                            s2Var.i(this.m.b(obj, d(i2)));
                            break;
                        case 44:
                            List listB2 = this.m.b(obj, d(i2));
                            s2Var.p(listB2);
                            a(iA);
                            objA = u2.a(iS, listB2, objB, o3Var);
                            objB = objA;
                            break;
                        case 45:
                            s2Var.f(this.m.b(obj, d(i2)));
                            break;
                        case 46:
                            s2Var.m(this.m.b(obj, d(i2)));
                            break;
                        case 47:
                            s2Var.c(this.m.b(obj, d(i2)));
                            break;
                        case 48:
                            s2Var.g(this.m.b(obj, d(i2)));
                            break;
                        case 49:
                            a(obj, d(i2), s2Var, c(iA), h0Var);
                            break;
                        case 50:
                            c(iA, obj, b(iA));
                            throw null;
                        case 51:
                            x3.a(d(i2), obj, Double.valueOf(s2Var.h()));
                            b(obj, iS, iA);
                            break;
                        case 52:
                            x3.a(d(i2), obj, Float.valueOf(s2Var.k()));
                            b(obj, iS, iA);
                            break;
                        case 53:
                            x3.a(d(i2), obj, Long.valueOf(s2Var.o()));
                            b(obj, iS, iA);
                            break;
                        case 54:
                            x3.a(d(i2), obj, Long.valueOf(s2Var.f()));
                            b(obj, iS, iA);
                            break;
                        case 55:
                            x3.a(d(i2), obj, Integer.valueOf(s2Var.d()));
                            b(obj, iS, iA);
                            break;
                        case 56:
                            x3.a(d(i2), obj, Long.valueOf(s2Var.g()));
                            b(obj, iS, iA);
                            break;
                        case 57:
                            x3.a(d(i2), obj, Integer.valueOf(s2Var.q()));
                            b(obj, iS, iA);
                            break;
                        case 58:
                            x3.a(d(i2), obj, Boolean.valueOf(s2Var.r()));
                            b(obj, iS, iA);
                            break;
                        case 59:
                            if ((i2 & 536870912) != 0) {
                                x3.a(i2 & 1048575, obj, s2Var.p());
                            } else if (this.g) {
                                x3.a(i2 & 1048575, obj, s2Var.n());
                            } else {
                                x3.a(i2 & 1048575, obj, s2Var.a());
                            }
                            b(obj, iS, iA);
                            break;
                        case 60:
                            if (a(obj, iS, iA)) {
                                x3.a(d(i2), obj, l1.a(x3.e(obj, d(i2)), s2Var.b(c(iA), h0Var)));
                            } else {
                                x3.a(d(i2), obj, s2Var.b(c(iA), h0Var));
                                b(iA, obj);
                            }
                            b(obj, iS, iA);
                            break;
                        case 61:
                            x3.a(d(i2), obj, s2Var.a());
                            b(obj, iS, iA);
                            break;
                        case 62:
                            x3.a(d(i2), obj, Integer.valueOf(s2Var.c()));
                            b(obj, iS, iA);
                            break;
                        case 63:
                            int iB2 = s2Var.b();
                            a(iA);
                            x3.a(d(i2), obj, Integer.valueOf(iB2));
                            b(obj, iS, iA);
                            break;
                        case 64:
                            x3.a(d(i2), obj, Integer.valueOf(s2Var.m()));
                            b(obj, iS, iA);
                            break;
                        case 65:
                            x3.a(d(i2), obj, Long.valueOf(s2Var.t()));
                            b(obj, iS, iA);
                            break;
                        case 66:
                            x3.a(d(i2), obj, Integer.valueOf(s2Var.j()));
                            b(obj, iS, iA);
                            break;
                        case 67:
                            x3.a(d(i2), obj, Long.valueOf(s2Var.l()));
                            b(obj, iS, iA);
                            break;
                        case 68:
                            x3.a(d(i2), obj, s2Var.a(c(iA), h0Var));
                            b(obj, iS, iA);
                            break;
                        default:
                            if (objB == null) {
                                try {
                                    o3Var.getClass();
                                    objB = new n3();
                                } catch (m1 unused) {
                                    o3Var.getClass();
                                    if (objB == null) {
                                        z0 z0Var2 = (z0) obj;
                                        n3 n3Var2 = z0Var2.unknownFields;
                                        if (n3Var2 == n3.f) {
                                            n3Var2 = new n3();
                                            z0Var2.unknownFields = n3Var2;
                                        }
                                        objB = n3Var2;
                                    }
                                    if (!o3.a(objB, s2Var)) {
                                        for (int i3 = this.j; i3 < this.k; i3++) {
                                            objB = b(this.i[i3], obj, objB);
                                        }
                                        if (objB != null) {
                                            o3.a(obj, objB);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                break;
                            }
                            o3Var.getClass();
                            if (!o3.a(objB, s2Var)) {
                                for (int i4 = this.j; i4 < this.k; i4++) {
                                    objB = b(this.i[i4], obj, objB);
                                }
                                if (objB != null) {
                                    o3.a(obj, objB);
                                    return;
                                }
                                return;
                            }
                            break;
                            break;
                    }
                }
            } finally {
                for (int i5 = this.j; i5 < this.k; i5++) {
                    objB = b(this.i[i5], obj, objB);
                }
                if (objB != null) {
                    o3Var.getClass();
                    o3.a(obj, objB);
                }
            }
        }
    }

    public final Object b(int i) {
        return this.b[(i / 3) * 2];
    }

    public final Object b(int i, Object obj, Object obj2) {
        int i2 = this.f1559a[i];
        if (x3.e(obj, r0[i + 1] & 1048575) == null) {
            return obj2;
        }
        a(i);
        return obj2;
    }

    public final void b(int i, Object obj) {
        int i2 = this.f1559a[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        x3.a(obj, j, (1 << (i2 >>> 20)) | x3.c(obj, j));
    }

    public final void b(Object obj, int i, int i2) {
        x3.a(obj, this.f1559a[i2 + 2] & 1048575, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int a(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, long j, int i6, long j2, f fVar) throws n1 {
        int iD;
        int i7;
        int iA = i;
        Unsafe unsafe = r;
        k1 k1VarB = (k1) unsafe.getObject(obj, j2);
        if (!((c) k1VarB).f1542a) {
            int size = k1VarB.size();
            k1VarB = k1VarB.b(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j2, k1VarB);
        }
        switch (i6) {
            case 18:
            case 35:
                if (i4 == 2) {
                    d0 d0Var = (d0) k1VarB;
                    int iD2 = g.d(bArr, iA, fVar);
                    int i8 = fVar.f1551a + iD2;
                    while (iD2 < i8) {
                        d0Var.a(Double.longBitsToDouble(g.b(iD2, bArr)));
                        iD2 += 8;
                    }
                    if (iD2 == i8) {
                        return iD2;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 1) {
                    d0 d0Var2 = (d0) k1VarB;
                    d0Var2.a(Double.longBitsToDouble(g.b(iA, bArr)));
                    while (true) {
                        int i9 = iA + 8;
                        if (i9 >= i2) {
                            return i9;
                        }
                        iA = i9 + 1;
                        byte b = bArr[i9];
                        if (b >= 0) {
                            fVar.f1551a = b;
                        } else {
                            iA = g.a(b, bArr, iA, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return i9;
                        }
                        d0Var2.a(Double.longBitsToDouble(g.b(iA, bArr)));
                    }
                }
                return iA;
            case 19:
            case 36:
                if (i4 == 2) {
                    q0 q0Var = (q0) k1VarB;
                    int iD3 = g.d(bArr, iA, fVar);
                    int i10 = fVar.f1551a + iD3;
                    while (iD3 < i10) {
                        q0Var.a(Float.intBitsToFloat(g.a(iD3, bArr)));
                        iD3 += 4;
                    }
                    if (iD3 == i10) {
                        return iD3;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 5) {
                    q0 q0Var2 = (q0) k1VarB;
                    q0Var2.a(Float.intBitsToFloat(g.a(iA, bArr)));
                    while (true) {
                        int i11 = iA + 4;
                        if (i11 >= i2) {
                            return i11;
                        }
                        iA = i11 + 1;
                        byte b2 = bArr[i11];
                        if (b2 >= 0) {
                            fVar.f1551a = b2;
                        } else {
                            iA = g.a(b2, bArr, iA, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return i11;
                        }
                        q0Var2.a(Float.intBitsToFloat(g.a(iA, bArr)));
                    }
                }
                return iA;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i4 == 2) {
                    u1 u1Var = (u1) k1VarB;
                    int iD4 = g.d(bArr, iA, fVar);
                    int i12 = fVar.f1551a + iD4;
                    while (iD4 < i12) {
                        iD4 = g.e(bArr, iD4, fVar);
                        u1Var.a(fVar.b);
                    }
                    if (iD4 == i12) {
                        return iD4;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 0) {
                    u1 u1Var2 = (u1) k1VarB;
                    int iE = g.e(bArr, iA, fVar);
                    u1Var2.a(fVar.b);
                    while (iE < i2) {
                        int iA2 = iE + 1;
                        byte b3 = bArr[iE];
                        if (b3 >= 0) {
                            fVar.f1551a = b3;
                        } else {
                            iA2 = g.a(b3, bArr, iA2, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return iE;
                        }
                        iE = g.e(bArr, iA2, fVar);
                        u1Var2.a(fVar.b);
                    }
                    return iE;
                }
                return iA;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i4 == 2) {
                    return g.a(bArr, iA, k1VarB, fVar);
                }
                if (i4 == 0) {
                    return g.c(i3, bArr, i, i2, k1VarB, fVar);
                }
                return iA;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i4 == 2) {
                    u1 u1Var3 = (u1) k1VarB;
                    int iD5 = g.d(bArr, iA, fVar);
                    int i13 = fVar.f1551a + iD5;
                    while (iD5 < i13) {
                        u1Var3.a(g.b(iD5, bArr));
                        iD5 += 8;
                    }
                    if (iD5 == i13) {
                        return iD5;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 1) {
                    u1 u1Var4 = (u1) k1VarB;
                    u1Var4.a(g.b(iA, bArr));
                    while (true) {
                        int i14 = iA + 8;
                        if (i14 >= i2) {
                            return i14;
                        }
                        iA = i14 + 1;
                        byte b4 = bArr[i14];
                        if (b4 >= 0) {
                            fVar.f1551a = b4;
                        } else {
                            iA = g.a(b4, bArr, iA, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return i14;
                        }
                        u1Var4.a(g.b(iA, bArr));
                    }
                }
                return iA;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i4 == 2) {
                    a1 a1Var = (a1) k1VarB;
                    int iD6 = g.d(bArr, iA, fVar);
                    int i15 = fVar.f1551a + iD6;
                    while (iD6 < i15) {
                        a1Var.c(g.a(iD6, bArr));
                        iD6 += 4;
                    }
                    if (iD6 == i15) {
                        return iD6;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 5) {
                    a1 a1Var2 = (a1) k1VarB;
                    a1Var2.c(g.a(iA, bArr));
                    while (true) {
                        int i16 = iA + 4;
                        if (i16 >= i2) {
                            return i16;
                        }
                        iA = i16 + 1;
                        byte b5 = bArr[i16];
                        if (b5 >= 0) {
                            fVar.f1551a = b5;
                        } else {
                            iA = g.a(b5, bArr, iA, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return i16;
                        }
                        a1Var2.c(g.a(iA, bArr));
                    }
                }
                return iA;
            case 25:
            case 42:
                if (i4 == 2) {
                    j jVar = (j) k1VarB;
                    iD = g.d(bArr, iA, fVar);
                    int i17 = fVar.f1551a + iD;
                    while (iD < i17) {
                        iD = g.e(bArr, iD, fVar);
                        jVar.a(fVar.b != 0);
                    }
                    if (iD != i17) {
                        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                    }
                    return iD;
                }
                if (i4 == 0) {
                    j jVar2 = (j) k1VarB;
                    iA = g.e(bArr, iA, fVar);
                    jVar2.a(fVar.b != 0);
                    while (iA < i2) {
                        int iA3 = iA + 1;
                        byte b6 = bArr[iA];
                        if (b6 >= 0) {
                            fVar.f1551a = b6;
                        } else {
                            iA3 = g.a(b6, bArr, iA3, fVar);
                        }
                        if (i3 == fVar.f1551a) {
                            iA = g.e(bArr, iA3, fVar);
                            jVar2.a(fVar.b != 0);
                        }
                    }
                }
                return iA;
            case 26:
                if (i4 == 2) {
                    if ((j & 536870912) == 0) {
                        return g.a(i3, bArr, i, i2, k1VarB, fVar);
                    }
                    return g.b(i3, bArr, i, i2, k1VarB, fVar);
                }
                return iA;
            case 27:
                if (i4 == 2) {
                    t2 t2VarC = c(i5);
                    iA = g.a(t2VarC, bArr, iA, i2, fVar);
                    k1VarB.add(fVar.c);
                    while (iA < i2) {
                        int iA4 = iA + 1;
                        byte b7 = bArr[iA];
                        if (b7 >= 0) {
                            fVar.f1551a = b7;
                        } else {
                            iA4 = g.a(b7, bArr, iA4, fVar);
                        }
                        if (i3 == fVar.f1551a) {
                            iA = g.a(t2VarC, bArr, iA4, i2, fVar);
                            k1VarB.add(fVar.c);
                        }
                    }
                }
                return iA;
            case 28:
                if (i4 == 2) {
                    int iD7 = g.d(bArr, iA, fVar);
                    int i18 = fVar.f1551a;
                    if (i18 >= 0) {
                        if (i18 > bArr.length - iD7) {
                            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                        }
                        if (i18 == 0) {
                            k1VarB.add(s.b);
                            i7 = iD7;
                        } else {
                            i7 = iD7 + i18;
                            s.a(iD7, i7, bArr.length);
                            k1VarB.add(new q(s.c.a(bArr, iD7, i18)));
                        }
                        while (i7 < i2) {
                            int iA5 = i7 + 1;
                            byte b8 = bArr[i7];
                            if (b8 >= 0) {
                                fVar.f1551a = b8;
                            } else {
                                iA5 = g.a(b8, bArr, iA5, fVar);
                            }
                            if (i3 != fVar.f1551a) {
                                return i7;
                            }
                            int iA6 = iA5 + 1;
                            byte b9 = bArr[iA5];
                            if (b9 >= 0) {
                                fVar.f1551a = b9;
                            } else {
                                iA6 = g.a(b9, bArr, iA6, fVar);
                            }
                            int i19 = fVar.f1551a;
                            if (i19 >= 0) {
                                if (i19 > bArr.length - iA6) {
                                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                }
                                if (i19 == 0) {
                                    k1VarB.add(s.b);
                                    i7 = iA6;
                                } else {
                                    i7 = iA6 + i19;
                                    s.a(iA6, i7, bArr.length);
                                    k1VarB.add(new q(s.c.a(bArr, iA6, i19)));
                                }
                            } else {
                                throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                            }
                        }
                        return i7;
                    }
                    throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                }
                return iA;
            case 30:
            case 44:
                if (i4 != 2) {
                    if (i4 == 0) {
                        iD = g.c(i3, bArr, i, i2, k1VarB, fVar);
                    }
                    return iA;
                }
                iD = g.a(bArr, iA, k1VarB, fVar);
                z0 z0Var = (z0) obj;
                n3 n3Var = z0Var.unknownFields;
                if (n3Var == n3.f) {
                    n3Var = null;
                }
                a(i5);
                Class cls = u2.f1583a;
                if (n3Var != null) {
                    z0Var.unknownFields = n3Var;
                }
                return iD;
            case 33:
            case 47:
                if (i4 == 2) {
                    a1 a1Var3 = (a1) k1VarB;
                    int iD8 = g.d(bArr, iA, fVar);
                    int i20 = fVar.f1551a + iD8;
                    while (iD8 < i20) {
                        int i21 = iD8 + 1;
                        byte b10 = bArr[iD8];
                        if (b10 >= 0) {
                            fVar.f1551a = b10;
                            iD8 = i21;
                        } else {
                            iD8 = g.a(b10, bArr, i21, fVar);
                        }
                        a1Var3.c(w.b(fVar.f1551a));
                    }
                    if (iD8 == i20) {
                        return iD8;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 0) {
                    a1 a1Var4 = (a1) k1VarB;
                    int iD9 = g.d(bArr, iA, fVar);
                    a1Var4.c(w.b(fVar.f1551a));
                    while (iD9 < i2) {
                        int iA7 = iD9 + 1;
                        byte b11 = bArr[iD9];
                        if (b11 >= 0) {
                            fVar.f1551a = b11;
                        } else {
                            iA7 = g.a(b11, bArr, iA7, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return iD9;
                        }
                        iD9 = iA7 + 1;
                        byte b12 = bArr[iA7];
                        if (b12 >= 0) {
                            fVar.f1551a = b12;
                        } else {
                            iD9 = g.a(b12, bArr, iD9, fVar);
                        }
                        a1Var4.c(w.b(fVar.f1551a));
                    }
                    return iD9;
                }
                return iA;
            case 34:
            case 48:
                if (i4 == 2) {
                    u1 u1Var5 = (u1) k1VarB;
                    int iD10 = g.d(bArr, iA, fVar);
                    int i22 = fVar.f1551a + iD10;
                    while (iD10 < i22) {
                        iD10 = g.e(bArr, iD10, fVar);
                        u1Var5.a(w.a(fVar.b));
                    }
                    if (iD10 == i22) {
                        return iD10;
                    }
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                if (i4 == 0) {
                    u1 u1Var6 = (u1) k1VarB;
                    int iE2 = g.e(bArr, iA, fVar);
                    u1Var6.a(w.a(fVar.b));
                    while (iE2 < i2) {
                        int iA8 = iE2 + 1;
                        byte b13 = bArr[iE2];
                        if (b13 >= 0) {
                            fVar.f1551a = b13;
                        } else {
                            iA8 = g.a(b13, bArr, iA8, fVar);
                        }
                        if (i3 != fVar.f1551a) {
                            return iE2;
                        }
                        iE2 = g.e(bArr, iA8, fVar);
                        u1Var6.a(w.a(fVar.b));
                    }
                    return iE2;
                }
                return iA;
            case 49:
                if (i4 == 3) {
                    t2 t2VarC2 = c(i5);
                    int i23 = (i3 & (-8)) | 4;
                    iA = g.a(t2VarC2, bArr, i, i2, i23, fVar);
                    k1VarB.add(fVar.c);
                    while (iA < i2) {
                        int iD11 = g.d(bArr, iA, fVar);
                        if (i3 == fVar.f1551a) {
                            iA = g.a(t2VarC2, bArr, iD11, i2, i23, fVar);
                            k1VarB.add(fVar.c);
                        }
                    }
                }
                return iA;
            default:
                return iA;
        }
    }

    public final int a(Object obj, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, f fVar) throws n1 {
        Unsafe unsafe = r;
        long j2 = this.f1559a[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Double.valueOf(Double.longBitsToDouble(g.b(i, bArr))));
                int i9 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i9;
            case 52:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Float.valueOf(Float.intBitsToFloat(g.a(i, bArr))));
                int i10 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i10;
            case 53:
            case 54:
                if (i5 != 0) {
                    return i;
                }
                int iE = g.e(bArr, i, fVar);
                unsafe.putObject(obj, j, Long.valueOf(fVar.b));
                unsafe.putInt(obj, j2, i4);
                return iE;
            case 55:
            case 62:
                if (i5 != 0) {
                    return i;
                }
                int iD = g.d(bArr, i, fVar);
                unsafe.putObject(obj, j, Integer.valueOf(fVar.f1551a));
                unsafe.putInt(obj, j2, i4);
                return iD;
            case 56:
            case 65:
                if (i5 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j, Long.valueOf(g.b(i, bArr)));
                int i11 = i + 8;
                unsafe.putInt(obj, j2, i4);
                return i11;
            case 57:
            case 64:
                if (i5 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j, Integer.valueOf(g.a(i, bArr)));
                int i12 = i + 4;
                unsafe.putInt(obj, j2, i4);
                return i12;
            case 58:
                if (i5 != 0) {
                    return i;
                }
                int iE2 = g.e(bArr, i, fVar);
                unsafe.putObject(obj, j, Boolean.valueOf(fVar.b != 0));
                unsafe.putInt(obj, j2, i4);
                return iE2;
            case 59:
                if (i5 != 2) {
                    return i;
                }
                int iD2 = g.d(bArr, i, fVar);
                int i13 = fVar.f1551a;
                if (i13 == 0) {
                    unsafe.putObject(obj, j, "");
                } else {
                    if ((i6 & 536870912) != 0) {
                        if (!d4.f1547a.b(bArr, iD2, iD2 + i13)) {
                            throw new n1("Protocol message had invalid UTF-8.");
                        }
                    }
                    unsafe.putObject(obj, j, new String(bArr, iD2, i13, l1.f1565a));
                    iD2 += i13;
                }
                unsafe.putInt(obj, j2, i4);
                return iD2;
            case 60:
                if (i5 != 2) {
                    return i;
                }
                int iA = g.a(c(i8), bArr, i, i2, fVar);
                Object object = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object == null) {
                    unsafe.putObject(obj, j, fVar.c);
                } else {
                    unsafe.putObject(obj, j, l1.a(object, fVar.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iA;
            case 61:
                if (i5 != 2) {
                    return i;
                }
                int iA2 = g.a(bArr, i, fVar);
                unsafe.putObject(obj, j, fVar.c);
                unsafe.putInt(obj, j2, i4);
                return iA2;
            case 63:
                if (i5 != 0) {
                    return i;
                }
                int iD3 = g.d(bArr, i, fVar);
                int i14 = fVar.f1551a;
                a(i8);
                unsafe.putObject(obj, j, Integer.valueOf(i14));
                unsafe.putInt(obj, j2, i4);
                return iD3;
            case 66:
                if (i5 != 0) {
                    return i;
                }
                int iD4 = g.d(bArr, i, fVar);
                unsafe.putObject(obj, j, Integer.valueOf(w.b(fVar.f1551a)));
                unsafe.putInt(obj, j2, i4);
                return iD4;
            case 67:
                if (i5 != 0) {
                    return i;
                }
                int iE3 = g.e(bArr, i, fVar);
                unsafe.putObject(obj, j, Long.valueOf(w.a(fVar.b)));
                unsafe.putInt(obj, j2, i4);
                return iE3;
            case 68:
                if (i5 != 3) {
                    return i;
                }
                int iA3 = g.a(c(i8), bArr, i, i2, (i3 & (-8)) | 4, fVar);
                Object object2 = unsafe.getInt(obj, j2) == i4 ? unsafe.getObject(obj, j) : null;
                if (object2 == null) {
                    unsafe.putObject(obj, j, fVar.c);
                } else {
                    unsafe.putObject(obj, j, l1.a(object2, fVar.c));
                }
                unsafe.putInt(obj, j2, i4);
                return iA3;
            default:
                return i;
        }
    }

    public final void a(int i) {
        if (this.b[((i / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:318:0x0898, code lost:
    
        if (r5 == 1048575) goto L320;
     */
    /* JADX WARN: Code restructure failed: missing block: B:319:0x089a, code lost:
    
        r29.putInt(r13, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:320:0x08a0, code lost:
    
        r2 = r32.j;
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:322:0x08a8, code lost:
    
        if (r2 >= r32.k) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x08aa, code lost:
    
        r4 = (com.fyber.inneractive.sdk.protobuf.n3) b(r32.i[r2], r13, r4);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:324:0x08b7, code lost:
    
        if (r4 == null) goto L326;
     */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x08b9, code lost:
    
        r32.n.getClass();
        ((com.fyber.inneractive.sdk.protobuf.z0) r13).unknownFields = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x08c5, code lost:
    
        if (r9 != 0) goto L332;
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x08c7, code lost:
    
        if (r0 != r7) goto L330;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x08cf, code lost:
    
        throw new com.fyber.inneractive.sdk.protobuf.n1("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:332:0x08d0, code lost:
    
        if (r0 > r7) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:333:0x08d2, code lost:
    
        if (r3 != r9) goto L335;
     */
    /* JADX WARN: Code restructure failed: missing block: B:334:0x08d4, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:0x08da, code lost:
    
        throw new com.fyber.inneractive.sdk.protobuf.n1("Failed to parse the message.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:170:0x04b0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x081f  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x084e  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0864  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(java.lang.Object r33, byte[] r34, int r35, int r36, int r37, com.fyber.inneractive.sdk.protobuf.f r38) throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            Method dump skipped, instruction units count: 2380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.a(java.lang.Object, byte[], int, int, int, com.fyber.inneractive.sdk.protobuf.f):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x02fc, code lost:
    
        if (r0 != r20) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0393, code lost:
    
        if (r0 != r14) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0395, code lost:
    
        r14 = r30;
        r13 = r32;
        r11 = r34;
        r12 = r35;
        r2 = r17;
        r8 = r18;
        r9 = r19;
        r1 = r24;
        r5 = r27;
        r6 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03aa, code lost:
    
        r2 = r0;
        r9 = r17;
        r6 = r28;
        r16 = r16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:36:0x009f. Please report as an issue. */
    @Override // com.fyber.inneractive.sdk.protobuf.t2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r31, byte[] r32, int r33, int r34, com.fyber.inneractive.sdk.protobuf.f r35) throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            Method dump skipped, instruction units count: 1080
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.a(java.lang.Object, byte[], int, int, com.fyber.inneractive.sdk.protobuf.f):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    @Override // com.fyber.inneractive.sdk.protobuf.t2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.i2.a(java.lang.Object):boolean");
    }

    public static void a(int i, Object obj, c0 c0Var) {
        if (obj instanceof String) {
            c0Var.f1543a.a((String) obj, i);
        } else {
            c0Var.f1543a.a(i, (s) obj);
        }
    }

    public final void a(Object obj, int i, s2 s2Var) {
        if ((536870912 & i) != 0) {
            s2Var.b(this.m.b(obj, i & 1048575));
        } else {
            s2Var.q(this.m.b(obj, i & 1048575));
        }
    }

    public final void a(Object obj, int i, s2 s2Var, t2 t2Var, h0 h0Var) {
        s2Var.b(this.m.b(obj, i & 1048575), t2Var, h0Var);
    }

    public final void a(Object obj, long j, s2 s2Var, t2 t2Var, h0 h0Var) {
        s2Var.a(this.m.b(obj, j), t2Var, h0Var);
    }

    public final boolean a(int i, Object obj) {
        int[] iArr = this.f1559a;
        int i2 = iArr[i + 2];
        long j = i2 & 1048575;
        if (j != 1048575) {
            return ((1 << (i2 >>> 20)) & x3.c(obj, j)) != 0;
        }
        int i3 = iArr[i + 1];
        long j2 = i3 & 1048575;
        switch ((i3 & 267386880) >>> 20) {
            case 0:
                return x3.c.c(obj, j2) != 0.0d;
            case 1:
                return x3.c.d(obj, j2) != 0.0f;
            case 2:
                return x3.d(obj, j2) != 0;
            case 3:
                return x3.d(obj, j2) != 0;
            case 4:
                return x3.c(obj, j2) != 0;
            case 5:
                return x3.d(obj, j2) != 0;
            case 6:
                return x3.c(obj, j2) != 0;
            case 7:
                return x3.c.a(obj, j2);
            case 8:
                Object objE = x3.e(obj, j2);
                if (objE instanceof String) {
                    return !((String) objE).isEmpty();
                }
                if (objE instanceof s) {
                    return !s.b.equals(objE);
                }
                throw new IllegalArgumentException();
            case 9:
                return x3.e(obj, j2) != null;
            case 10:
                return !s.b.equals(x3.e(obj, j2));
            case 11:
                return x3.c(obj, j2) != 0;
            case 12:
                return x3.c(obj, j2) != 0;
            case 13:
                return x3.c(obj, j2) != 0;
            case 14:
                return x3.d(obj, j2) != 0;
            case 15:
                return x3.c(obj, j2) != 0;
            case 16:
                return x3.d(obj, j2) != 0;
            case 17:
                return x3.e(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean a(Object obj, int i, int i2) {
        return x3.c(obj, (long) (this.f1559a[i2 + 2] & 1048575)) == i;
    }

    public final boolean a(int i, Object obj, Object obj2) {
        return a(i, obj) == a(i, obj2);
    }

    public final int a(int i, int i2) {
        int length = (this.f1559a.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f1559a[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
