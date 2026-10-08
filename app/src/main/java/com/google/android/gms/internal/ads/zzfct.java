package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdz;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfct implements zzfdm {
    private final zzfdm zza;
    private final zzfdm zzb;
    private final zzfiy zzc;
    private final String zzd;
    private zzcxv zze;
    private final Executor zzf;

    public zzfct(zzfdm zzfdmVar, zzfdm zzfdmVar2, zzfiy zzfiyVar, String str, Executor executor) {
        this.zza = zzfdmVar;
        this.zzb = zzfdmVar2;
        this.zzc = zzfiyVar;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzfil zzfilVar, zzfdn zzfdnVar) {
        zzcxv zzcxvVar = zzfilVar.zza;
        this.zze = zzcxvVar;
        if (zzfilVar.zzc != null) {
            if (zzcxvVar.zzc() != null) {
                zzfilVar.zzc.zzp().zzu(zzfilVar.zza.zzc());
            }
            return zzgui.zza(zzfilVar.zzc);
        }
        zzcxvVar.zza().zzh(zzfilVar.zzb);
        return ((zzfdd) this.zza).zzb(zzfdnVar, null, zzfilVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcxv zzd() {
        return this.zze;
    }

    public final synchronized ListenableFuture zzb(final zzfdn zzfdnVar, final zzfdl zzfdlVar, zzcxv zzcxvVar) {
        zzcxu zzcxuVarZza = zzfdlVar.zza(zzfdnVar.zzb);
        zzcxuVarZza.zzi(new zzfcu(this.zzd));
        final zzcxv zzcxvVar2 = (zzcxv) zzcxuVarZza.zzh();
        zzcxvVar2.zzb();
        zzcxvVar2.zzb();
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzcxvVar2.zzb().zzd;
        if (zzmVar.zzs == null && zzmVar.zzx == null) {
            zzfgn zzfgnVarZzb = zzcxvVar2.zzb();
            com.google.android.gms.ads.internal.client.zzm zzmVar2 = zzfgnVarZzb.zzd;
            String str = zzfgnVarZzb.zzg;
            com.google.android.gms.ads.internal.client.zzx zzxVar = zzfgnVarZzb.zzk;
            Executor executor = this.zzf;
            final zzfcs zzfcsVar = new zzfcs(zzfdlVar, zzfdnVar, zzmVar2, str, executor, zzxVar, null);
            return (zzgua) zzgui.zzj(zzgua.zzw(((zzfcz) this.zzb).zza(zzfdnVar, zzfdlVar, zzcxvVar2)), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfcr
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zze(zzfdnVar, zzfcsVar, zzfdlVar, zzcxvVar2, (zzfcy) obj);
                }
            }, executor);
        }
        this.zze = zzcxvVar2;
        return ((zzfdd) this.zza).zzb(zzfdnVar, zzfdlVar, zzcxvVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, Object obj) {
        return zzb(zzfdnVar, zzfdlVar, null);
    }

    final /* synthetic */ ListenableFuture zze(zzfdn zzfdnVar, zzfcs zzfcsVar, zzfdl zzfdlVar, zzcxv zzcxvVar, zzfcy zzfcyVar) {
        if (zzfcyVar != null) {
            zzfcs zzfcsVar2 = new zzfcs(zzfcsVar.zza, zzfcsVar.zzb, zzfcsVar.zzc, zzfcsVar.zzd, zzfcsVar.zze, zzfcsVar.zzf, zzfcyVar.zza);
            zzfil zzfilVar = zzfcyVar.zzc;
            if (zzfilVar != null) {
                this.zze = null;
                this.zzc.zza(zzfcsVar2);
                return zzg(zzfilVar, zzfdnVar);
            }
            zzfiy zzfiyVar = this.zzc;
            ListenableFuture listenableFutureZzb = zzfiyVar.zzb(zzfcsVar2);
            if (listenableFutureZzb != null) {
                this.zze = null;
                return zzgui.zzj(listenableFutureZzb, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfcq
                    @Override // com.google.android.gms.internal.ads.zzgtq
                    public final /* synthetic */ ListenableFuture zza(Object obj) {
                        return this.zza.zzf((zzfiu) obj);
                    }
                }, this.zzf);
            }
            zzfiyVar.zza(zzfcsVar2);
            zzfdnVar = new zzfdn(zzfdnVar.zzb, zzfcyVar.zzb);
        }
        ListenableFuture listenableFutureZzb2 = ((zzfdd) this.zza).zzb(zzfdnVar, zzfdlVar, zzcxvVar);
        this.zze = zzcxvVar;
        return listenableFutureZzb2;
    }

    final /* synthetic */ ListenableFuture zzf(zzfiu zzfiuVar) throws zzdzv {
        zzfil zzfilVar;
        zzfiw zzfiwVar;
        if (zzfiuVar == null || (zzfilVar = zzfiuVar.zza) == null || (zzfiwVar = zzfiuVar.zzb) == null) {
            throw new zzdzv(1, "Empty prefetch");
        }
        zzbdz.zzb.zzc zzcVarZzs = zzbdz.zzb.zzs();
        zzbdz.zzb.zza.C0306zza c0306zzaZzs = zzbdz.zzb.zza.zzs();
        c0306zzaZzs.zzc(zzbdz.zzb.zzd.IN_MEMORY);
        c0306zzaZzs.zzg(zzbdz.zzb.zze.zzs());
        zzcVarZzs.zzh(c0306zzaZzs);
        zzfilVar.zza.zza().zzd().zzl(zzcVarZzs.zzbu());
        return zzg(zzfilVar, ((zzfcs) zzfiwVar).zzb);
    }
}
