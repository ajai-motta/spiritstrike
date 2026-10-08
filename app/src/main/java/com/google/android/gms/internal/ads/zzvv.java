package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvv implements zzwk {
    final /* synthetic */ zzvy zza;
    private final int zzb;

    public zzvv(zzvy zzvyVar, int i) {
        Objects.requireNonNull(zzvyVar);
        this.zza = zzvyVar;
        this.zzb = i;
    }

    final /* synthetic */ int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzb() {
        return this.zza.zzp(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzc() throws IOException {
        this.zza.zzq(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zzd(zzkj zzkjVar, zzhh zzhhVar, int i) {
        return this.zza.zzs(this.zzb, zzkjVar, zzhhVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zze(long j) {
        return this.zza.zzt(this.zzb, j);
    }
}
