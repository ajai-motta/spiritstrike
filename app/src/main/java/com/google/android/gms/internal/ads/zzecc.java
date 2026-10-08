package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzecc implements zzdbu {
    private final Context zza;
    private final zzcaf zzb;

    zzecc(Context context, zzcaf zzcafVar) {
        this.zza = context;
        this.zzb = zzcafVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdT(zzbxj zzbxjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdU(zzfgf zzfgfVar) {
        String str = zzfgfVar.zzb.zzb.zze;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzcaf zzcafVar = this.zzb;
        Context context = this.zza;
        zzcafVar.zzc(context, zzfgfVar.zza.zza.zzd);
        zzcafVar.zzm(context, str);
    }
}
