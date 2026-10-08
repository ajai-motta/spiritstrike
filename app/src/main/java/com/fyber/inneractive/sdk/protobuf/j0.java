package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public static void a(c0 c0Var, Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        if (w0Var.d) {
            switch (i0.f1557a[w0Var.c.ordinal()]) {
                case 1:
                    u2.b(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 2:
                    u2.f(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 3:
                    u2.h(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 4:
                    u2.n(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 5:
                    u2.g(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 6:
                    u2.e(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 7:
                    u2.d(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 8:
                    u2.a(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 9:
                    u2.m(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 10:
                    u2.i(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 11:
                    u2.j(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 12:
                    u2.k(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 13:
                    u2.l(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 14:
                    u2.g(w0Var.b, (List) entry.getValue(), c0Var, w0Var.e);
                    break;
                case 15:
                    u2.a(w0Var.b, (List) entry.getValue(), c0Var);
                    break;
                case 16:
                    u2.b(w0Var.b, (List) entry.getValue(), c0Var);
                    break;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        u2.a(w0Var.b, (List) entry.getValue(), c0Var, p2.c.a(list.get(0).getClass()));
                        break;
                    }
                    break;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        u2.b(w0Var.b, (List) entry.getValue(), c0Var, p2.c.a(list2.get(0).getClass()));
                        break;
                    }
                    break;
            }
        }
        switch (i0.f1557a[w0Var.c.ordinal()]) {
            case 1:
                c0Var.a(w0Var.b, ((Double) entry.getValue()).doubleValue());
                break;
            case 2:
                c0Var.a(w0Var.b, ((Float) entry.getValue()).floatValue());
                break;
            case 3:
                c0Var.f1543a.b(w0Var.b, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                c0Var.f1543a.b(w0Var.b, ((Long) entry.getValue()).longValue());
                break;
            case 5:
                c0Var.f1543a.b(w0Var.b, ((Integer) entry.getValue()).intValue());
                break;
            case 6:
                c0Var.f1543a.a(w0Var.b, ((Long) entry.getValue()).longValue());
                break;
            case 7:
                c0Var.f1543a.a(w0Var.b, ((Integer) entry.getValue()).intValue());
                break;
            case 8:
                c0Var.f1543a.a(w0Var.b, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 9:
                c0Var.f1543a.d(w0Var.b, ((Integer) entry.getValue()).intValue());
                break;
            case 10:
                c0Var.f1543a.a(w0Var.b, ((Integer) entry.getValue()).intValue());
                break;
            case 11:
                c0Var.f1543a.a(w0Var.b, ((Long) entry.getValue()).longValue());
                break;
            case 12:
                c0Var.a(w0Var.b, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                c0Var.a(w0Var.b, ((Long) entry.getValue()).longValue());
                break;
            case 14:
                c0Var.f1543a.b(w0Var.b, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                c0Var.f1543a.a(w0Var.b, (s) entry.getValue());
                break;
            case 16:
                int i = w0Var.b;
                c0Var.f1543a.a((String) entry.getValue(), i);
                break;
            case 17:
                c0Var.a(w0Var.b, entry.getValue(), p2.c.a(entry.getValue().getClass()));
                break;
            case 18:
                int i2 = w0Var.b;
                Object value = entry.getValue();
                c0Var.f1543a.a(i2, (d2) value, p2.c.a(entry.getValue().getClass()));
                break;
        }
    }

    public static Object a(s2 s2Var, x0 x0Var, h0 h0Var, n0 n0Var, Object obj, o3 o3Var) {
        Object objValueOf;
        ArrayList arrayList;
        w0 w0Var = x0Var.d;
        int i = w0Var.b;
        if (w0Var.d && w0Var.e) {
            switch (i0.f1557a[w0Var.c.ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    s2Var.j(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    s2Var.d(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    s2Var.k(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    s2Var.a(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    s2Var.o(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    s2Var.n(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    s2Var.e(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    s2Var.l(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    s2Var.i(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    s2Var.f(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    s2Var.m(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    s2Var.c(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    s2Var.g(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    s2Var.p(arrayList);
                    obj = u2.a(i, arrayList, x0Var.d.f1585a, obj, o3Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + x0Var.d.c);
            }
            n0Var.c(x0Var.d, arrayList);
        } else {
            j4 j4Var = w0Var.c;
            if (j4Var == j4.ENUM) {
                int iD = s2Var.d();
                if (x0Var.d.f1585a.a(iD) == null) {
                    return u2.a(i, iD, obj, o3Var);
                }
                objValueOf = Integer.valueOf(iD);
            } else {
                switch (i0.f1557a[j4Var.ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(s2Var.h());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(s2Var.k());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(s2Var.o());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(s2Var.f());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(s2Var.d());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(s2Var.g());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(s2Var.q());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(s2Var.r());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(s2Var.c());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(s2Var.m());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(s2Var.t());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(s2Var.j());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(s2Var.l());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = s2Var.a();
                        break;
                    case 16:
                        objValueOf = s2Var.n();
                        break;
                    case 17:
                        objValueOf = s2Var.a(x0Var.c.getClass(), h0Var);
                        break;
                    case 18:
                        objValueOf = s2Var.b(x0Var.c.getClass(), h0Var);
                        break;
                    default:
                        objValueOf = null;
                        break;
                }
            }
            w0 w0Var2 = x0Var.d;
            if (w0Var2.d) {
                n0Var.a(w0Var2, objValueOf);
            } else {
                int i2 = i0.f1557a[w0Var2.c.ordinal()];
                if (i2 == 17 || i2 == 18) {
                    Object obj2 = n0Var.f1568a.get(x0Var.d);
                    if (obj2 != null) {
                        objValueOf = l1.a(obj2, objValueOf);
                    }
                }
                n0Var.c(x0Var.d, objValueOf);
            }
        }
        return obj;
    }
}
