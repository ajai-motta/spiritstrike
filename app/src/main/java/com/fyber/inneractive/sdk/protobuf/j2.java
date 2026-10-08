package com.fyber.inneractive.sdk.protobuf;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class j2 implements t2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d2 f1561a;
    public final o3 b;
    public final boolean c;
    public final j0 d;

    public j2(o3 o3Var, j0 j0Var, d2 d2Var) {
        this.b = o3Var;
        j0Var.getClass();
        this.c = d2Var instanceof GeneratedMessageLite$ExtendableMessage;
        this.d = j0Var;
        this.f1561a = d2Var;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final Object a() {
        return ((t0) this.f1561a.newBuilderForType()).b();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final boolean b(Object obj, Object obj2) {
        this.b.getClass();
        n3 n3Var = ((z0) obj).unknownFields;
        this.b.getClass();
        if (!n3Var.equals(((z0) obj2).unknownFields)) {
            return false;
        }
        if (!this.c) {
            return true;
        }
        this.d.getClass();
        n0 n0Var = ((GeneratedMessageLite$ExtendableMessage) obj).extensions;
        this.d.getClass();
        return n0Var.equals(((GeneratedMessageLite$ExtendableMessage) obj2).extensions);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void c(Object obj) {
        this.b.getClass();
        ((z0) obj).unknownFields.e = false;
        this.d.getClass();
        ((GeneratedMessageLite$ExtendableMessage) obj).extensions.e();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final int d(Object obj) {
        this.b.getClass();
        int iHashCode = ((z0) obj).unknownFields.hashCode();
        if (!this.c) {
            return iHashCode;
        }
        this.d.getClass();
        return (iHashCode * 53) + ((GeneratedMessageLite$ExtendableMessage) obj).extensions.f1568a.hashCode();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void a(Object obj, Object obj2) {
        o3 o3Var = this.b;
        Class cls = u2.f1583a;
        o3Var.getClass();
        z0 z0Var = (z0) obj;
        n3 n3VarA = z0Var.unknownFields;
        n3 n3Var = ((z0) obj2).unknownFields;
        if (!n3Var.equals(n3.f)) {
            n3VarA = n3.a(n3VarA, n3Var);
        }
        z0Var.unknownFields = n3VarA;
        if (this.c) {
            this.d.getClass();
            n0 n0Var = ((GeneratedMessageLite$ExtendableMessage) obj2).extensions;
            if (n0Var.f1568a.isEmpty()) {
                return;
            }
            ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable().a(n0Var);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final int b(Object obj) {
        this.b.getClass();
        n3 n3Var = ((z0) obj).unknownFields;
        int i = n3Var.d;
        if (i == -1) {
            int iA = 0;
            for (int i2 = 0; i2 < n3Var.f1570a; i2++) {
                int i3 = n3Var.b[i2] >>> 3;
                iA += b0.a((s) n3Var.c[i2]) + b0.b(3) + b0.c(i3) + b0.b(2) + (b0.b(1) * 2);
            }
            n3Var.d = iA;
            i = iA;
        }
        if (!this.c) {
            return i;
        }
        this.d.getClass();
        return i + ((GeneratedMessageLite$ExtendableMessage) obj).extensions.a();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void a(Object obj, c0 c0Var) {
        this.d.getClass();
        Iterator itD = ((GeneratedMessageLite$ExtendableMessage) obj).extensions.d();
        while (itD.hasNext()) {
            Map.Entry entry = (Map.Entry) itD.next();
            w0 w0Var = (w0) entry.getKey();
            if (w0Var.c.a() == k4.MESSAGE && !w0Var.d && !w0Var.e) {
                int i = w0Var.b;
                Object value = entry.getValue();
                c0Var.getClass();
                if (value instanceof s) {
                    c0Var.f1543a.b(i, (s) value);
                } else {
                    c0Var.f1543a.a(i, (d2) value);
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        this.b.getClass();
        n3 n3Var = ((z0) obj).unknownFields;
        n3Var.getClass();
        c0Var.getClass();
        if (q4.ASCENDING == q4.DESCENDING) {
            for (int i2 = n3Var.f1570a - 1; i2 >= 0; i2--) {
                int i3 = n3Var.b[i2] >>> 3;
                Object obj2 = n3Var.c[i2];
                if (obj2 instanceof s) {
                    c0Var.f1543a.b(i3, (s) obj2);
                } else {
                    c0Var.f1543a.a(i3, (d2) obj2);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < n3Var.f1570a; i4++) {
            int i5 = n3Var.b[i4] >>> 3;
            Object obj3 = n3Var.c[i4];
            if (obj3 instanceof s) {
                c0Var.f1543a.b(i5, (s) obj3);
            } else {
                c0Var.f1543a.a(i5, (d2) obj3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c8 A[SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.protobuf.t2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.Object r11, byte[] r12, int r13, int r14, com.fyber.inneractive.sdk.protobuf.f r15) throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.j2.a(java.lang.Object, byte[], int, int, com.fyber.inneractive.sdk.protobuf.f):void");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final void a(Object obj, s2 s2Var, h0 h0Var) {
        o3 o3Var = this.b;
        j0 j0Var = this.d;
        o3Var.getClass();
        z0 z0Var = (z0) obj;
        n3 n3Var = z0Var.unknownFields;
        if (n3Var == n3.f) {
            n3Var = new n3();
            z0Var.unknownFields = n3Var;
        }
        n3 n3Var2 = n3Var;
        j0Var.getClass();
        n0 n0VarEnsureExtensionsAreMutable = ((GeneratedMessageLite$ExtendableMessage) obj).ensureExtensionsAreMutable();
        while (s2Var.s() != Integer.MAX_VALUE && a(s2Var, h0Var, j0Var, n0VarEnsureExtensionsAreMutable, o3Var, n3Var2)) {
            try {
            } finally {
                z0Var.unknownFields = n3Var2;
            }
        }
    }

    public final boolean a(s2 s2Var, h0 h0Var, j0 j0Var, n0 n0Var, o3 o3Var, n3 n3Var) throws n1 {
        byte[] bArr;
        int iE = s2Var.e();
        if (iE != 11) {
            if ((iE & 7) == 2) {
                d2 d2Var = this.f1561a;
                j0Var.getClass();
                x0 x0VarA = h0Var.a(iE >>> 3, d2Var);
                if (x0VarA != null) {
                    n0Var.c(x0VarA.d, s2Var.b(x0VarA.c.getClass(), h0Var));
                    return true;
                }
                o3Var.getClass();
                return o3.a((Object) n3Var, s2Var);
            }
            return s2Var.i();
        }
        x0 x0VarA2 = null;
        int iC = 0;
        s sVarA = null;
        while (s2Var.s() != Integer.MAX_VALUE) {
            int iE2 = s2Var.e();
            if (iE2 == 16) {
                iC = s2Var.c();
                d2 d2Var2 = this.f1561a;
                j0Var.getClass();
                x0VarA2 = h0Var.a(iC, d2Var2);
            } else if (iE2 == 26) {
                if (x0VarA2 != null) {
                    j0Var.getClass();
                    n0Var.c(x0VarA2.d, s2Var.b(x0VarA2.c.getClass(), h0Var));
                } else {
                    sVarA = s2Var.a();
                }
            } else if (!s2Var.i()) {
                break;
            }
        }
        if (s2Var.e() != 12) {
            throw new n1("Protocol message end-group tag did not match expected tag.");
        }
        if (sVarA != null) {
            if (x0VarA2 != null) {
                j0Var.getClass();
                z0 z0VarB = ((t0) x0VarA2.c.newBuilderForType()).b();
                int size = sVarA.size();
                if (size == 0) {
                    bArr = l1.b;
                } else {
                    byte[] bArr2 = new byte[size];
                    sVarA.a(size, bArr2);
                    bArr = bArr2;
                }
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                if (byteBufferWrap.hasArray()) {
                    h hVar = new h(byteBufferWrap);
                    p2 p2Var = p2.c;
                    p2Var.getClass();
                    p2Var.a(z0VarB.getClass()).a(z0VarB, hVar, h0Var);
                    n0Var.c(x0VarA2.d, z0VarB);
                    if (hVar.s() != Integer.MAX_VALUE) {
                        throw new n1("Protocol message end-group tag did not match expected tag.");
                    }
                } else {
                    throw new IllegalArgumentException("Direct buffers not yet supported");
                }
            } else {
                o3Var.getClass();
                n3Var.a((iC << 3) | 2, sVarA);
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t2
    public final boolean a(Object obj) {
        this.d.getClass();
        return ((GeneratedMessageLite$ExtendableMessage) obj).extensions.c();
    }
}
