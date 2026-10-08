package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {
    public static final n0 d = new n0(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e3 f1568a;
    public boolean b;
    public boolean c;

    public n0() {
        int i = e3.h;
        this.f1568a = new v2(16);
    }

    public static boolean b(Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        if (w0Var.c.a() != k4.MESSAGE) {
            return true;
        }
        if (!w0Var.d) {
            Object value = entry.getValue();
            if (value instanceof d2) {
                return ((d2) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        Iterator it = ((List) entry.getValue()).iterator();
        while (it.hasNext()) {
            if (!((d2) it.next()).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public final void a(n0 n0Var) {
        for (int i = 0; i < n0Var.f1568a.b.size(); i++) {
            c((Map.Entry) n0Var.f1568a.b.get(i));
        }
        Iterator it = n0Var.f1568a.b().iterator();
        while (it.hasNext()) {
            c((Map.Entry) it.next());
        }
    }

    public final boolean c() {
        for (int i = 0; i < this.f1568a.b.size(); i++) {
            if (!b((Map.Entry) this.f1568a.b.get(i))) {
                return false;
            }
        }
        Iterator it = this.f1568a.b().iterator();
        while (it.hasNext()) {
            if (!b((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator d() {
        return this.c ? new o1(this.f1568a.entrySet().iterator()) : this.f1568a.entrySet().iterator();
    }

    public final void e() {
        if (this.b) {
            return;
        }
        v2 v2Var = (v2) this.f1568a;
        if (!v2Var.d) {
            for (int i = 0; i < v2Var.b.size(); i++) {
                Map.Entry entry = (Map.Entry) v2Var.b.get(i);
                if (((w0) entry.getKey()).d) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            for (Map.Entry entry2 : v2Var.b()) {
                if (((w0) entry2.getKey()).d) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        if (!v2Var.d) {
            v2Var.c = v2Var.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(v2Var.c);
            v2Var.f = v2Var.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(v2Var.f);
            v2Var.d = true;
        }
        this.b = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n0) {
            return this.f1568a.equals(((n0) obj).f1568a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1568a.hashCode();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final n0 m4883clone() {
        n0 n0Var = new n0();
        for (int i = 0; i < this.f1568a.b.size(); i++) {
            Map.Entry entry = (Map.Entry) this.f1568a.b.get(i);
            n0Var.c((w0) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : this.f1568a.b()) {
            n0Var.c((w0) entry2.getKey(), entry2.getValue());
        }
        n0Var.c = this.c;
        return n0Var;
    }

    public n0(int i) {
        int i2 = e3.h;
        this.f1568a = new v2(0);
        e();
        e();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void d(com.fyber.inneractive.sdk.protobuf.w0 r4, java.lang.Object r5) {
        /*
            com.fyber.inneractive.sdk.protobuf.j4 r0 = r4.c
            java.nio.charset.Charset r1 = com.fyber.inneractive.sdk.protobuf.l1.f1565a
            r5.getClass()
            int[] r1 = com.fyber.inneractive.sdk.protobuf.m0.f1567a
            com.fyber.inneractive.sdk.protobuf.k4 r0 = r0.a()
            int r0 = r0.ordinal()
            r0 = r1[r0]
            switch(r0) {
                case 1: goto L3b;
                case 2: goto L38;
                case 3: goto L35;
                case 4: goto L32;
                case 5: goto L2f;
                case 6: goto L2c;
                case 7: goto L23;
                case 8: goto L1a;
                case 9: goto L17;
                default: goto L16;
            }
        L16:
            goto L40
        L17:
            boolean r0 = r5 instanceof com.fyber.inneractive.sdk.protobuf.d2
            goto L3d
        L1a:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L3f
            boolean r0 = r5 instanceof com.fyber.inneractive.sdk.protobuf.d1
            if (r0 == 0) goto L40
            goto L3f
        L23:
            boolean r0 = r5 instanceof com.fyber.inneractive.sdk.protobuf.s
            if (r0 != 0) goto L3f
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L40
            goto L3f
        L2c:
            boolean r0 = r5 instanceof java.lang.String
            goto L3d
        L2f:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L3d
        L32:
            boolean r0 = r5 instanceof java.lang.Double
            goto L3d
        L35:
            boolean r0 = r5 instanceof java.lang.Float
            goto L3d
        L38:
            boolean r0 = r5 instanceof java.lang.Long
            goto L3d
        L3b:
            boolean r0 = r5 instanceof java.lang.Integer
        L3d:
            if (r0 == 0) goto L40
        L3f:
            return
        L40:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r4.b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.fyber.inneractive.sdk.protobuf.j4 r4 = r4.c
            com.fyber.inneractive.sdk.protobuf.k4 r4 = r4.a()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r1
            r1 = 1
            r2[r1] = r4
            r4 = 2
            r2[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r2)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.n0.d(com.fyber.inneractive.sdk.protobuf.w0, java.lang.Object):void");
    }

    public final int a() {
        int iA = 0;
        for (int i = 0; i < this.f1568a.b.size(); i++) {
            iA += a((Map.Entry) this.f1568a.b.get(i));
        }
        Iterator it = this.f1568a.b().iterator();
        while (it.hasNext()) {
            iA += a((Map.Entry) it.next());
        }
        return iA;
    }

    public final void c(Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        Object value = entry.getValue();
        if (w0Var.d) {
            Object arrayList = this.f1568a.get(w0Var);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            for (Object obj : (List) value) {
                List list = (List) arrayList;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                list.add(obj);
            }
            this.f1568a.a(w0Var, arrayList);
            return;
        }
        if (w0Var.c.a() == k4.MESSAGE) {
            Object obj2 = this.f1568a.get(w0Var);
            if (obj2 == null) {
                e3 e3Var = this.f1568a;
                if (value instanceof byte[]) {
                    byte[] bArr3 = (byte[]) value;
                    byte[] bArr4 = new byte[bArr3.length];
                    System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                    value = bArr4;
                }
                e3Var.a(w0Var, value);
                return;
            }
            t0 t0Var = (t0) ((d2) obj2).toBuilder();
            t0Var.c();
            t0.a(t0Var.b, (z0) ((d2) value));
            this.f1568a.a(w0Var, t0Var.a());
            return;
        }
        e3 e3Var2 = this.f1568a;
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        e3Var2.a(w0Var, value);
    }

    public static int a(Map.Entry entry) {
        w0 w0Var = (w0) entry.getKey();
        Object value = entry.getValue();
        if (w0Var.c.a() == k4.MESSAGE && !w0Var.d && !w0Var.e) {
            int i = ((w0) entry.getKey()).b;
            int iC = b0.c(i) + b0.b(2) + (b0.b(1) * 2);
            int iB = b0.b(3);
            int serializedSize = ((d2) value).getSerializedSize();
            return l0.a(serializedSize, serializedSize, iB, iC);
        }
        return b(w0Var, value);
    }

    public final int b() {
        int iB = 0;
        for (int i = 0; i < this.f1568a.b.size(); i++) {
            Map.Entry entry = (Map.Entry) this.f1568a.b.get(i);
            iB += b((w0) entry.getKey(), entry.getValue());
        }
        for (Map.Entry entry2 : this.f1568a.b()) {
            iB += b((w0) entry2.getKey(), entry2.getValue());
        }
        return iB;
    }

    public static int b(w0 w0Var, Object obj) {
        int iB;
        int iA;
        j4 j4Var = w0Var.c;
        int i = w0Var.b;
        if (w0Var.d) {
            int iA2 = 0;
            if (w0Var.e) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iA2 += a(j4Var, it.next());
                }
                iB = b0.b(i) + iA2;
                iA = b0.c(iA2);
            } else {
                for (Object obj2 : (List) obj) {
                    int iB2 = b0.b(i);
                    if (j4Var == j4.GROUP) {
                        iB2 *= 2;
                    }
                    iA2 += a(j4Var, obj2) + iB2;
                }
                return iA2;
            }
        } else {
            iB = b0.b(i);
            if (j4Var == j4.GROUP) {
                iB *= 2;
            }
            iA = a(j4Var, obj);
        }
        return iA + iB;
    }

    public final void c(w0 w0Var, Object obj) {
        if (w0Var.d) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d(w0Var, it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            d(w0Var, obj);
        }
        this.f1568a.a(w0Var, obj);
    }

    public static int a(j4 j4Var, Object obj) {
        int serializedSize;
        int iC;
        switch (m0.b[j4Var.ordinal()]) {
            case 1:
                ((Double) obj).getClass();
                Logger logger = b0.b;
                return 8;
            case 2:
                ((Float) obj).getClass();
                Logger logger2 = b0.b;
                return 4;
            case 3:
                return b0.a(((Long) obj).longValue());
            case 4:
                return b0.a(((Long) obj).longValue());
            case 5:
                int iIntValue = ((Integer) obj).intValue();
                if (iIntValue >= 0) {
                    return b0.c(iIntValue);
                }
                Logger logger3 = b0.b;
                return 10;
            case 6:
                ((Long) obj).getClass();
                Logger logger4 = b0.b;
                return 8;
            case 7:
                ((Integer) obj).getClass();
                Logger logger5 = b0.b;
                return 4;
            case 8:
                ((Boolean) obj).getClass();
                Logger logger6 = b0.b;
                return 1;
            case 9:
                Logger logger7 = b0.b;
                return ((d2) obj).getSerializedSize();
            case 10:
                Logger logger8 = b0.b;
                serializedSize = ((d2) obj).getSerializedSize();
                iC = b0.c(serializedSize);
                break;
            case 11:
                if (obj instanceof s) {
                    return b0.a((s) obj);
                }
                return b0.a((String) obj);
            case 12:
                if (obj instanceof s) {
                    return b0.a((s) obj);
                }
                Logger logger9 = b0.b;
                serializedSize = ((byte[]) obj).length;
                iC = b0.c(serializedSize);
                break;
                break;
            case 13:
                return b0.c(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                Logger logger10 = b0.b;
                return 4;
            case 15:
                ((Long) obj).getClass();
                Logger logger11 = b0.b;
                return 8;
            case 16:
                return b0.c(b0.d(((Integer) obj).intValue()));
            case 17:
                return b0.a(b0.b(((Long) obj).longValue()));
            case 18:
                if (obj instanceof d1) {
                    return b0.a(((d1) obj).a());
                }
                return b0.a(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iC + serializedSize;
    }

    public final void a(w0 w0Var, Object obj) {
        List arrayList;
        if (w0Var.d) {
            d(w0Var, obj);
            Object obj2 = this.f1568a.get(w0Var);
            if (obj2 == null) {
                arrayList = new ArrayList();
                this.f1568a.a(w0Var, arrayList);
            } else {
                arrayList = (List) obj2;
            }
            arrayList.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }
}
