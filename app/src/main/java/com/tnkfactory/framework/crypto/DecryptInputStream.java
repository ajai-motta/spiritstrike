package com.tnkfactory.framework.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class DecryptInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cryptor f3234a;

    public DecryptInputStream(InputStream inputStream, Cryptor cryptor) {
        super(inputStream);
        this.f3234a = cryptor;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        return this.f3234a.decrypt(super.read());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 > 0) {
            this.f3234a.decrypt(bArr, i, i3);
        }
        return i3;
    }
}
