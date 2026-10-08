package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzada;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzajp implements zzada {
    private zzadd zza;
    private zzajw zzb;
    private boolean zzc;

    static {
        int i = zzajo.zza;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = true)
    private final boolean zzg(zzadb zzadbVar) throws IOException {
        zzajr zzajrVar = new zzajr();
        if (zzajrVar.zzc(zzadbVar, true) && (zzajrVar.zza & 2) == 2) {
            int iMin = Math.min(zzajrVar.zze, 8);
            zzeg zzegVar = new zzeg(iMin);
            zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
            zzegVar.zzh(0);
            if (zzegVar.zzd() >= 5 && zzegVar.zzs() == 127 && zzegVar.zzz() == 1179402563) {
                this.zzb = new zzajn();
            } else {
                zzegVar.zzh(0);
                if (zzaes.zzd(1, zzegVar, true)) {
                    this.zzb = new zzajy();
                } else {
                    zzegVar.zzh(0);
                    if (zzajt.zzd(zzegVar)) {
                        this.zzb = new zzajt();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        try {
            return zzg(zzadbVar);
        } catch (zzat unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zza = zzaddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        this.zza.getClass();
        if (this.zzb == null) {
            if (!zzg(zzadbVar)) {
                throw zzat.zzb("Failed to determine bitstream type", null);
            }
            zzadbVar.zzl();
        }
        if (!this.zzc) {
            zzaem zzaemVarZzu = this.zza.zzu(0, 1);
            this.zza.zzv();
            this.zzb.zze(this.zza, zzaemVarZzu);
            this.zzc = true;
        }
        return this.zzb.zzg(zzadbVar, zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        zzajw zzajwVar = this.zzb;
        if (zzajwVar != null) {
            zzajwVar.zzf(j, j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }
}
