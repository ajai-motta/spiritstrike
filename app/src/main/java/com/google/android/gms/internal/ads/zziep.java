package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zziep extends zzies implements zzarf {
    protected final String zza = "moov";

    public zziep(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarf
    public final void zzb(zziet zzietVar, ByteBuffer byteBuffer, long j, zzarc zzarcVar) throws IOException {
        zzietVar.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzietVar;
        this.zze = zzietVar.zzc();
        zzietVar.zzd(zzietVar.zzc() + j);
        this.zzf = zzietVar.zzc();
        this.zzb = zzarcVar;
    }
}
