package com.pgl.ssdk;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes6.dex */
public class m implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileChannel f3086a;
    private final long b;
    private final long c;

    public m(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.f3086a = fileChannel;
        this.b = j;
        this.c = j2;
    }

    @Override // com.pgl.ssdk.q
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m a(long j, long j2) {
        long jA = a();
        a(j, j2, jA);
        return (j == 0 && j2 == jA) ? this : new m(this.f3086a, this.b + j, j2);
    }

    private static void a(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 <= j3) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
    }

    @Override // com.pgl.ssdk.q
    public long a() {
        long j = this.c;
        if (j != -1) {
            return j;
        }
        try {
            return this.f3086a.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public void a(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        a(j, i, a());
        if (i == 0) {
            return;
        }
        if (i <= byteBuffer.remaining()) {
            long j2 = this.b + j;
            int iLimit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                while (i > 0) {
                    synchronized (this.f3086a) {
                        this.f3086a.position(j2);
                        i2 = this.f3086a.read(byteBuffer);
                    }
                    j2 += (long) i2;
                    i -= i2;
                }
                return;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
        throw new BufferOverflowException();
    }

    @Override // com.pgl.ssdk.q
    public ByteBuffer a(long j, int i) throws IOException {
        if (i >= 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            a(j, i, byteBufferAllocate);
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        }
        throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
    }
}
