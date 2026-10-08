package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.gms.internal.ads.zzada;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaff implements zzada {
    private final zzeg zza = new zzeg(4);
    private final zzaef zzb = new zzaef(-1, -1, "image/avif");

    private final boolean zzg(zzadb zzadbVar, int i) throws IOException {
        zzeg zzegVar = this.zza;
        zzegVar.zza(4);
        ((zzacr) zzadbVar).zzh(zzegVar.zzi(), 0, 4, false);
        return zzegVar.zzz() == ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        ((zzacr) zzadbVar).zzj(4, false);
        return zzg(zzadbVar, Atom.TYPE_ftyp) && zzg(zzadbVar, 1635150182);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzb.zzc(zzaddVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        return this.zzb.zzd(zzadbVar, zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzb.zze(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }
}
