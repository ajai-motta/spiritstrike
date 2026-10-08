package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaqw extends ByteArrayOutputStream {
    private final zzaql zza;

    public zzaqw(zzaql zzaqlVar, int i) {
        this.zza = zzaqlVar;
        this.buf = zzaqlVar.zza(Math.max(i, 256));
    }

    private final void zza(int i) {
        if (this.count + i <= this.buf.length) {
            return;
        }
        zzaql zzaqlVar = this.zza;
        int i2 = this.count + i;
        byte[] bArrZza = zzaqlVar.zza(i2 + i2);
        System.arraycopy(this.buf, 0, bArrZza, 0, this.count);
        zzaqlVar.zzb(this.buf);
        this.buf = bArrZza;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.zzb(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zzb(this.buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zza(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zza(i2);
        super.write(bArr, i, i2);
    }
}
