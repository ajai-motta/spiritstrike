package com.fyber.inneractive.sdk.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1537a;

    public a(InputStream inputStream, int i) {
        super(inputStream);
        this.f1537a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() {
        return Math.min(super.available(), this.f1537a);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.f1537a <= 0) {
            return -1;
        }
        int i = super.read();
        if (i >= 0) {
            this.f1537a--;
        }
        return i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j) throws IOException {
        long jSkip = super.skip(Math.min(j, this.f1537a));
        if (jSkip >= 0) {
            this.f1537a = (int) (((long) this.f1537a) - jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f1537a;
        if (i3 <= 0) {
            return -1;
        }
        int i4 = super.read(bArr, i, Math.min(i2, i3));
        if (i4 >= 0) {
            this.f1537a -= i4;
        }
        return i4;
    }
}
