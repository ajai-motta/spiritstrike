package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbdk extends PushbackInputStream {
    final /* synthetic */ zzbdn zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbdk(zzbdn zzbdnVar, InputStream inputStream, int i) {
        super(inputStream, 1);
        Objects.requireNonNull(zzbdnVar);
        this.zza = zzbdnVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.zza.zzc.zzb();
        super.close();
    }
}
