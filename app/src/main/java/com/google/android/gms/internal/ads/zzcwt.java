package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcwt implements zzdbu, zzdhh {
    private final Context zza;
    private final zzfgn zzb;
    private final VersionInfoParcel zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzdxt zze;
    private final zzflp zzf;
    private final zzdyo zzg;

    public zzcwt(Context context, zzfgn zzfgnVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.util.zzg zzgVar, zzdxt zzdxtVar, zzflp zzflpVar, zzdyo zzdyoVar) {
        this.zza = context;
        this.zzb = zzfgnVar;
        this.zzc = versionInfoParcel;
        this.zzd = zzgVar;
        this.zze = zzdxtVar;
        this.zzf = zzflpVar;
        this.zzg = zzdyoVar;
    }

    private final void zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeB)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzg zzgVar = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzfgn zzfgnVar = this.zzb;
            zzflp zzflpVar = this.zzf;
            zzdyo zzdyoVar = this.zzg;
            com.google.android.gms.ads.internal.zzt.zzl().zzb(context, versionInfoParcel, zzfgnVar.zzg, zzgVar.zzi(), zzflpVar, zzdyoVar.zzs());
        }
        this.zze.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zzd(com.google.android.gms.ads.nonagon.signalgeneration.zzbj zzbjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeC)).booleanValue()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdT(zzbxj zzbxjVar) {
        zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdU(zzfgf zzfgfVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhh
    public final void zze(String str) {
    }
}
