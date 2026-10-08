package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaop {
    public final int zza;
    public final long zzb;

    private zzaop(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzaop zza(zzadb zzadbVar, zzeg zzegVar) throws IOException {
        zzadbVar.zzi(zzegVar.zzi(), 0, 8);
        zzegVar.zzh(0);
        return new zzaop(zzegVar.zzB(), zzegVar.zzA());
    }
}
