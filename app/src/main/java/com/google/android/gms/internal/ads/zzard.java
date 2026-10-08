package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzard extends zzies implements Closeable {
    static {
        zziez.zzb(zzard.class);
    }

    public zzard(zziet zzietVar, zzarc zzarcVar) throws IOException {
        zzd(zzietVar, zzietVar.zzb(), zzarcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzies, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzies
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
