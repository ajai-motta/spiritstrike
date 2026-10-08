package com.fyber.inneractive.sdk.protobuf;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s implements Iterable, Serializable {
    public static final q b = new q(l1.b);
    public static final o c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1579a = 0;

    static {
        c = d.a() ? new r() : new m();
    }

    public static q a(String str) {
        return new q(str.getBytes(l1.f1565a));
    }

    public abstract int a(int i, int i2);

    public abstract void a(int i, byte[] bArr);

    public abstract void a(k kVar);

    public abstract byte c(int i);

    public abstract boolean c();

    public abstract byte d(int i);

    public abstract w d();

    public abstract s e(int i);

    public abstract String e();

    public final String f() {
        Charset charset = l1.f1565a;
        return size() == 0 ? "" : e();
    }

    public final int hashCode() {
        int iA = this.f1579a;
        if (iA == 0) {
            int size = size();
            iA = a(size, size);
            if (iA == 0) {
                iA = 1;
            }
            this.f1579a = iA;
        }
        return iA;
    }

    public abstract int size();

    public final String toString() {
        String strA;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int size = size();
        if (size() <= 50) {
            strA = h3.a(this);
        } else {
            strA = h3.a(e(47)) + "...";
        }
        return "<ByteString@" + hexString + " size=" + size + " contents=\"" + strA + "\">";
    }

    public static int a(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }
}
