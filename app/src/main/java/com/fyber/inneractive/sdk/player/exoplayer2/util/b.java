package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileOutputStream f1462a;
    public boolean b = false;

    public b(File file) {
        this.f1462a = new FileOutputStream(file);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f1462a.flush();
        try {
            this.f1462a.getFD().sync();
        } catch (IOException e) {
            Log.w("AtomicFile", "Failed to sync file descriptor:", e);
        }
        this.f1462a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f1462a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i) throws IOException {
        this.f1462a.write(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        this.f1462a.write(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        this.f1462a.write(bArr, i, i2);
    }
}
