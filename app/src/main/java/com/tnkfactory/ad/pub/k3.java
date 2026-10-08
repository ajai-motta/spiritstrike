package com.tnkfactory.ad.pub;

import java.io.DataInputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.zip.InflaterInputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class k3 extends DataInputStream implements ObjectInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3148a;
    public final ArrayList b;
    public final ArrayList c;
    public byte[] d;

    public k3(InflaterInputStream inflaterInputStream) {
        super(inflaterInputStream);
        this.f3148a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f3148a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
    }

    public final String a() throws IOException {
        int iB = b();
        String str = (iB & 1) == 0 ? (String) this.f3148a.get(iB >> 1) : null;
        if (str != null) {
            return str;
        }
        int i = iB >> 1;
        if (i == 0) {
            return "";
        }
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < i) {
            this.d = new byte[i * 2];
        }
        byte[] bArr2 = this.d;
        readFully(bArr2, 0, i);
        String str2 = new String(bArr2, 0, i, "utf-8");
        this.f3148a.add(str2);
        return str2;
    }

    public final int b() throws IOException {
        byte b = readByte();
        int i = b & 255;
        if (i <= 127) {
            return i;
        }
        byte b2 = readByte();
        int i2 = b2 & 255;
        if (i2 <= 127) {
            return ((b & 127) << 7) | i2;
        }
        byte b3 = readByte();
        int i3 = b3 & 255;
        if (i3 <= 127) {
            return ((b & 127) << 14) | ((b2 & 127) << 7) | i3;
        }
        return ((b & 127) << 22) | ((b2 & 127) << 15) | ((b3 & 127) << 8) | (readByte() & 255);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.Object, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, long[]] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [double[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v33, types: [java.lang.Object] */
    @Override // java.io.ObjectInput
    public final Object readObject() throws IOException, ClassNotFoundException {
        ?? map;
        n3 n3Var;
        byte b = readByte();
        int i = 0;
        switch (b) {
            case 0:
            case 1:
                return null;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Boolean.TRUE;
            case 4:
                return Integer.valueOf((b() << 3) >> 3);
            case 5:
                return Double.valueOf(readDouble());
            case 6:
                return a();
            case 7:
                return Long.valueOf(readLong());
            case 8:
                Date date = (Date) a(b());
                if (date != null) {
                    return date;
                }
                Date date2 = new Date((long) readDouble());
                this.b.add(date2);
                return date2;
            case 9:
                int iB = b();
                Object objA = a(iB);
                if (objA != null) {
                    return objA;
                }
                int i2 = iB >> 1;
                map = new Object[i2];
                this.b.add(map);
                while (i < i2) {
                    map[i] = readObject();
                    i++;
                }
                break;
                break;
            case 10:
                int iB2 = b();
                Object objA2 = a(iB2);
                if (objA2 != null) {
                    return objA2;
                }
                if ((iB2 & 3) == 1) {
                    n3Var = (n3) this.c.get(iB2 >> 2);
                } else {
                    n3 n3Var2 = new n3(a(), (iB2 & 7) == 7);
                    this.c.add(n3Var2);
                    int i3 = iB2 >> 3;
                    for (int i4 = 0; i4 < i3; i4++) {
                        n3Var2.c.add(a());
                    }
                    n3Var = n3Var2;
                }
                String str = n3Var.f3166a;
                if (str.length() != 0) {
                    if (!n3Var.b) {
                        throw new IOException("not supported class. ".concat(str));
                    }
                    try {
                        Object objNewInstance = k3.class.getClassLoader().loadClass(str).newInstance();
                        this.b.add(objNewInstance);
                        if (!(objNewInstance instanceof Externalizable)) {
                            throw new IOException("Not externalizable class:".concat(objNewInstance.getClass().getName()));
                        }
                        ((Externalizable) objNewInstance).readExternal(this);
                        return objNewInstance;
                    } catch (ClassNotFoundException e) {
                        throw e;
                    } catch (Exception unused) {
                        throw new IOException("Cannot instantiate class: ".concat(str));
                    }
                }
                map = new HashMap();
                this.b.add(map);
                int size = n3Var.c.size();
                while (i < size) {
                    map.put((String) n3Var.c.get(i), readObject());
                    i++;
                }
                break;
                break;
            case 11:
            default:
                throw new IOException("Unknown message type :" + ((int) b));
            case 12:
                int iB3 = b();
                byte[] bArr = (byte[]) a(iB3);
                if (bArr != null) {
                    return bArr;
                }
                int i5 = iB3 >> 1;
                byte[] bArr2 = new byte[i5];
                this.b.add(bArr2);
                readFully(bArr2, 0, i5);
                return bArr2;
            case 13:
                int iB4 = b();
                Object objA3 = a(iB4);
                if (objA3 != null) {
                    return (int[]) objA3;
                }
                int i6 = iB4 >> 1;
                map = new int[i6];
                this.b.add(map);
                while (i < i6) {
                    map[i] = b();
                    i++;
                }
                break;
                break;
            case 14:
                int iB5 = b();
                Object objA4 = a(iB5);
                if (objA4 != null) {
                    return (long[]) objA4;
                }
                int i7 = iB5 >> 1;
                map = new long[i7];
                this.b.add(map);
                while (i < i7) {
                    map[i] = readLong();
                    i++;
                }
                break;
                break;
            case 15:
                int iB6 = b();
                Object objA5 = a(iB6);
                if (objA5 != null) {
                    return (double[]) objA5;
                }
                int i8 = iB6 >> 1;
                map = new double[i8];
                this.b.add(map);
                while (i < i8) {
                    map[i] = readDouble();
                    i++;
                }
                break;
                break;
        }
        return map;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final void reset() {
        this.f3148a.clear();
        this.b.clear();
        this.c.clear();
    }

    public final Object a(int i) {
        if ((i & 1) == 0) {
            return this.b.get(i >> 1);
        }
        return null;
    }
}
