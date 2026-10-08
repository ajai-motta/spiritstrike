package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzelt implements zzdjl {
    private final Context zza;
    private final zzdse zzb;
    private final zzfgn zzc;
    private final VersionInfoParcel zzd;
    private final zzffu zze;
    private final ListenableFuture zzf;
    private final zzcgy zzg;
    private final zzbma zzh;
    private final boolean zzi;
    private final zzegj zzj;
    private final zzdvc zzk;
    private final zzdvi zzl;

    zzelt(Context context, zzdse zzdseVar, zzfgn zzfgnVar, VersionInfoParcel versionInfoParcel, zzffu zzffuVar, ListenableFuture listenableFuture, zzcgy zzcgyVar, zzbma zzbmaVar, boolean z, zzegj zzegjVar, zzdvc zzdvcVar, zzdvi zzdviVar) {
        this.zza = context;
        this.zzb = zzdseVar;
        this.zzc = zzfgnVar;
        this.zzd = versionInfoParcel;
        this.zze = zzffuVar;
        this.zzf = listenableFuture;
        this.zzg = zzcgyVar;
        this.zzh = zzbmaVar;
        this.zzi = z;
        this.zzj = zzegjVar;
        this.zzk = zzdvcVar;
        this.zzl = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z, Context context, zzczb zzczbVar) {
        zzdrj zzdrjVar = (zzdrj) zzgui.zzt(this.zzf);
        try {
            zzffu zzffuVar = this.zze;
            final zzcgy zzcgyVarZza = this.zzg;
            if (zzcgyVarZza.zzaB()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbe)).booleanValue()) {
                    zzcgyVarZza = this.zzb.zza(this.zzc.zzf, null, null);
                    zzbmq.zzb(zzcgyVarZza, zzdrjVar.zzk());
                    final zzdsi zzdsiVar = new zzdsi();
                    zzdrjVar.zzl().zzi(zzcgyVarZza, true, this.zzi ? this.zzh : null, this.zzk.zze());
                    zzcgyVarZza.zzP().zzG(new zzciu(zzdsiVar, zzcgyVarZza) { // from class: com.google.android.gms.internal.ads.zzels
                        private final /* synthetic */ zzcgy zza;

                        {
                            this.zza = zzcgyVarZza;
                        }

                        @Override // com.google.android.gms.internal.ads.zzciu
                        public final /* synthetic */ void zza(boolean z2, int i, String str, String str2) {
                            zzcgy zzcgyVar = this.zza;
                            zzcgyVar.zzJ();
                            zzcgyVar.zzP().zzq();
                        }
                    });
                    zzciw zzciwVarZzP = zzcgyVarZza.zzP();
                    Objects.requireNonNull(zzcgyVarZza);
                    zzciwVarZzP.zzH(new zzciv() { // from class: com.google.android.gms.internal.ads.zzelr
                        @Override // com.google.android.gms.internal.ads.zzciv
                        public final /* synthetic */ void zza() {
                            zzcgyVarZza.zzI();
                        }
                    });
                    zzffz zzffzVar = zzffuVar.zzs;
                    zzcgyVarZza.zzau(zzffzVar.zzb, zzffzVar.zza, null);
                }
            }
            zzcgy zzcgyVar = zzcgyVarZza;
            zzcgyVar.zzag(true);
            boolean z2 = this.zzi;
            boolean zZzc = z2 ? this.zzh.zzc(false) : false;
            com.google.android.gms.ads.internal.zzt.zzc();
            boolean zZzM = com.google.android.gms.ads.internal.util.zzs.zzM(this.zza);
            boolean z3 = z2 && this.zzh.zzd();
            float fZze = z2 ? this.zzh.zze() : 0.0f;
            zzffu zzffuVar2 = this.zze;
            com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZzc, zZzM, z3, fZze, -1, z, zzffuVar2.zzO, zzffuVar2.zzP);
            if (zzczbVar != null) {
                zzczbVar.zzb();
            }
            com.google.android.gms.ads.internal.zzt.zzb();
            zzdja zzdjaVarZzj = zzdrjVar.zzj();
            int i = zzffuVar2.zzQ;
            VersionInfoParcel versionInfoParcel = this.zzd;
            String str = zzffuVar2.zzB;
            zzffz zzffzVar2 = zzffuVar2.zzs;
            String str2 = zzffzVar2.zzb;
            String str3 = zzffzVar2.zza;
            zzfgn zzfgnVar = this.zzc;
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdjaVarZzj, null, zzcgyVar, i, versionInfoParcel, str, zzlVar, str2, str3, zzfgnVar.zzg, zzczbVar, zzffuVar2.zzb() ? this.zzj : null, zzcgyVar.zzn()), true, this.zzl);
        } catch (zzchn e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final zzffu zzb() {
        return this.zze;
    }
}
