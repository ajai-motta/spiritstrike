package com.fyber.inneractive.sdk.protobuf;

import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
public final class v3 extends w3 {
    public v3(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final boolean a() {
        if (!super.a()) {
            return false;
        }
        try {
            Class<?> cls = this.f1588a.getClass();
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            x3.a(th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c A[PHI: r2
  0x003c: PHI (r2v9 java.lang.reflect.Field) = (r2v5 java.lang.reflect.Field), (r2v12 java.lang.reflect.Field) binds: [B:19:0x0050, B:11:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.fyber.inneractive.sdk.protobuf.w3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean b() {
        /*
            r10 = this;
            java.lang.String r0 = "copyMemory"
            java.lang.String r1 = "getLong"
            sun.misc.Unsafe r2 = r10.f1588a
            r3 = 0
            if (r2 != 0) goto Lb
            goto Lc3
        Lb:
            java.lang.Class r2 = r2.getClass()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r4 = "objectFieldOffset"
            r5 = 1
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> Lbf
            java.lang.Class<java.lang.reflect.Field> r7 = java.lang.reflect.Field.class
            r6[r3] = r7     // Catch: java.lang.Throwable -> Lbf
            r2.getMethod(r4, r6)     // Catch: java.lang.Throwable -> Lbf
            java.lang.Class r4 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> Lbf
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> Lbf
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            r7[r3] = r8     // Catch: java.lang.Throwable -> Lbf
            r7[r5] = r4     // Catch: java.lang.Throwable -> Lbf
            r2.getMethod(r1, r7)     // Catch: java.lang.Throwable -> Lbf
            boolean r2 = com.fyber.inneractive.sdk.protobuf.d.a()     // Catch: java.lang.Throwable -> Lbf
            r7 = 0
            if (r2 == 0) goto L3e
            java.lang.String r2 = "effectiveDirectAddress"
            java.lang.Class<java.nio.Buffer> r8 = java.nio.Buffer.class
            java.lang.reflect.Field r2 = r8.getDeclaredField(r2)     // Catch: java.lang.Throwable -> L39
            goto L3a
        L39:
            r2 = r7
        L3a:
            if (r2 == 0) goto L3e
        L3c:
            r7 = r2
            goto L53
        L3e:
            java.lang.String r2 = "address"
            java.lang.Class<java.nio.Buffer> r8 = java.nio.Buffer.class
            java.lang.reflect.Field r2 = r8.getDeclaredField(r2)     // Catch: java.lang.Throwable -> L47
            goto L48
        L47:
            r2 = r7
        L48:
            if (r2 == 0) goto L53
            java.lang.Class r8 = r2.getType()     // Catch: java.lang.Throwable -> Lbf
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> Lbf
            if (r8 != r9) goto L53
            goto L3c
        L53:
            if (r7 != 0) goto L56
            goto Lc3
        L56:
            sun.misc.Unsafe r2 = r10.f1588a     // Catch: java.lang.Throwable -> Lba
            java.lang.Class r2 = r2.getClass()     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = "getByte"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> Lba
            r8[r3] = r4     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r7, r8)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = "putByte"
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> Lba
            r8[r3] = r4     // Catch: java.lang.Throwable -> Lba
            java.lang.Class r9 = java.lang.Byte.TYPE     // Catch: java.lang.Throwable -> Lba
            r8[r5] = r9     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r7, r8)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = "getInt"
            java.lang.Class[] r8 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> Lba
            r8[r3] = r4     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r7, r8)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r7 = "putInt"
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> Lba
            r8[r3] = r4     // Catch: java.lang.Throwable -> Lba
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> Lba
            r8[r5] = r9     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r7, r8)     // Catch: java.lang.Throwable -> Lba
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> Lba
            r7[r3] = r4     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r1, r7)     // Catch: java.lang.Throwable -> Lba
            java.lang.String r1 = "putLong"
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch: java.lang.Throwable -> Lba
            r7[r3] = r4     // Catch: java.lang.Throwable -> Lba
            r7[r5] = r4     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r1, r7)     // Catch: java.lang.Throwable -> Lba
            r1 = 3
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> Lba
            r7[r3] = r4     // Catch: java.lang.Throwable -> Lba
            r7[r5] = r4     // Catch: java.lang.Throwable -> Lba
            r7[r6] = r4     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r0, r7)     // Catch: java.lang.Throwable -> Lba
            r7 = 5
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Throwable -> Lba
            java.lang.Class<java.lang.Object> r8 = java.lang.Object.class
            r7[r3] = r8     // Catch: java.lang.Throwable -> Lba
            r7[r5] = r4     // Catch: java.lang.Throwable -> Lba
            r7[r6] = r8     // Catch: java.lang.Throwable -> Lba
            r7[r1] = r4     // Catch: java.lang.Throwable -> Lba
            r1 = 4
            r7[r1] = r4     // Catch: java.lang.Throwable -> Lba
            r2.getMethod(r0, r7)     // Catch: java.lang.Throwable -> Lba
            return r5
        Lba:
            r0 = move-exception
            com.fyber.inneractive.sdk.protobuf.x3.a(r0)
            return r3
        Lbf:
            r0 = move-exception
            com.fyber.inneractive.sdk.protobuf.x3.a(r0)
        Lc3:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.v3.b():boolean");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final double c(Object obj, long j) {
        return this.f1588a.getDouble(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final float d(Object obj, long j) {
        return this.f1588a.getFloat(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, byte b) {
        this.f1588a.putByte(obj, j, b);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final boolean a(Object obj, long j) {
        return this.f1588a.getBoolean(obj, j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, boolean z) {
        this.f1588a.putBoolean(obj, j, z);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, float f) {
        this.f1588a.putFloat(obj, j, f);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(Object obj, long j, double d) {
        this.f1588a.putDouble(obj, j, d);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final byte a(long j) {
        return this.f1588a.getByte(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final void a(long j, byte[] bArr, long j2) {
        this.f1588a.copyMemory((Object) null, j, bArr, x3.f, j2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w3
    public final byte b(Object obj, long j) {
        return this.f1588a.getByte(obj, j);
    }
}
