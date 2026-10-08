package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaew implements zzaed {
    final /* synthetic */ zzaey zza;
    private final long zzb;

    public zzaew(zzaey zzaeyVar, long j) {
        Objects.requireNonNull(zzaeyVar);
        this.zza = zzaeyVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzaey zzaeyVar = this.zza;
        zzaeb zzaebVarZzg = zzaeyVar.zzg()[0].zzg(j);
        for (int i = 1; i < zzaeyVar.zzg().length; i++) {
            zzaeb zzaebVarZzg2 = zzaeyVar.zzg()[i].zzg(j);
            if (zzaebVarZzg2.zza.zzc < zzaebVarZzg.zza.zzc) {
                zzaebVarZzg = zzaebVarZzg2;
            }
        }
        return zzaebVarZzg;
    }
}
