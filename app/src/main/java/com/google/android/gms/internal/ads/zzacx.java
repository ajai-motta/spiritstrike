package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacx implements zzaem {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzu(zzv zzvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final int zzv(zzj zzjVar, int i, boolean z, int i2) throws IOException {
        int iZza = zzjVar.zza(this.zza, 0, Math.min(4096, i));
        if (iZza != -1) {
            return iZza;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzw(zzeg zzegVar, int i, int i2) {
        zzegVar.zzk(i);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzx(long j, int i, int i2, int i3, zzael zzaelVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public /* synthetic */ int zzy(zzj zzjVar, int i, boolean z) {
        return zzv(zzjVar, i, z, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public /* synthetic */ void zzz(zzeg zzegVar, int i) {
        zzw(zzegVar, i, 0);
    }
}
