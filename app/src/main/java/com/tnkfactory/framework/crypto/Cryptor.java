package com.tnkfactory.framework.crypto;

/* JADX INFO: loaded from: classes6.dex */
public interface Cryptor {
    int decrypt(int i);

    void decrypt(byte[] bArr, int i, int i2);

    int encrypt(int i);

    void encrypt(byte[] bArr, int i, int i2);

    Cryptor init();
}
