package com.tnkfactory.framework.crypto;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class EncryptOutputStream extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cryptor f3235a;

    public EncryptOutputStream(OutputStream outputStream, Cryptor cryptor) {
        super(outputStream);
        this.f3235a = cryptor;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        super.write(this.f3235a.encrypt(i));
    }
}
