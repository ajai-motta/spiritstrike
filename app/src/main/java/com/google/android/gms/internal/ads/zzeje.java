package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeje implements zzdjl {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzffu zzd;
    private final zzcgy zze;
    private final zzfgn zzf;
    private final zzbma zzg;
    private final boolean zzh;
    private final zzegj zzi;
    private final zzdvi zzj;

    zzeje(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzffu zzffuVar, zzcgy zzcgyVar, zzfgn zzfgnVar, boolean z, zzbma zzbmaVar, zzegj zzegjVar, zzdvi zzdviVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzffuVar;
        this.zze = zzcgyVar;
        this.zzf = zzfgnVar;
        this.zzg = zzbmaVar;
        this.zzh = z;
        this.zzi = zzegjVar;
        this.zzj = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z, Context context, zzczb zzczbVar) {
        zzdhx zzdhxVar = (zzdhx) zzgui.zzt(this.zzc);
        zzcgy zzcgyVar = this.zze;
        zzcgyVar.zzag(true);
        boolean z2 = this.zzh;
        boolean zZzc = z2 ? this.zzg.zzc(false) : false;
        com.google.android.gms.ads.internal.zzt.zzc();
        boolean zZzM = com.google.android.gms.ads.internal.util.zzs.zzM(this.zza);
        boolean z3 = z2 && this.zzg.zzd();
        float fZze = z2 ? this.zzg.zze() : 0.0f;
        zzffu zzffuVar = this.zzd;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zZzc, zZzM, z3, fZze, -1, z, zzffuVar.zzO, false);
        if (zzczbVar != null) {
            zzczbVar.zzb();
        }
        com.google.android.gms.ads.internal.zzt.zzb();
        zzdja zzdjaVarZzj = zzdhxVar.zzj();
        int i = zzffuVar.zzQ;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String str = zzffuVar.zzB;
        zzffz zzffzVar = zzffuVar.zzs;
        String str2 = zzffzVar.zzb;
        String str3 = zzffzVar.zza;
        zzfgn zzfgnVar = this.zzf;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzdjaVarZzj, null, zzcgyVar, i, versionInfoParcel, str, zzlVar, str2, str3, zzfgnVar.zzg, zzczbVar, zzffuVar.zzb() ? this.zzi : null, zzcgyVar.zzn()), true, this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final zzffu zzb() {
        return this.zzd;
    }
}
