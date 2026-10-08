package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdss {
    private final zzdvi zza;

    zzdss(zzdvi zzdviVar) {
        this.zza = zzdviVar;
    }

    public final boolean zza(zzfvg zzfvgVar) {
        if (zzfvgVar.zzj()) {
            zzdvh zzdvhVarZza = this.zza.zza();
            zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "aq_ad_closed");
            zzdvhVarZza.zzc("gqi", zzfvgVar.zza());
            zzdvhVarZza.zzc("aq_ad_duration", String.valueOf(zzfvgVar.zzb()));
            zzdvhVarZza.zzc("aq_ad_bounce_cnt", String.valueOf(zzfvgVar.zzc()));
            zzdvhVarZza.zzc("aq_time_away", String.valueOf(zzfvgVar.zzg()));
            boolean zEquals = zzdvhVarZza.zze().equals(com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
            Boolean.valueOf(zEquals).getClass();
            return zEquals;
        }
        zzdvh zzdvhVarZza2 = this.zza.zza();
        zzdvhVarZza2.zzc(NativeProtocol.WEB_DIALOG_ACTION, "aq_ad_kill");
        zzdvhVarZza2.zzc("gqi", zzfvgVar.zza());
        zzdvhVarZza2.zzc("aq_ad_duration", String.valueOf(zzfvgVar.zzb()));
        zzdvhVarZza2.zzc("aq_ad_bounce_cnt", String.valueOf(zzfvgVar.zzc()));
        zzdvhVarZza2.zzc("aq_time_away", String.valueOf(zzfvgVar.zzg()));
        zzdvhVarZza2.zzc("aq_is_os_kill", String.valueOf(zzfvgVar.zze()));
        boolean zEquals2 = zzdvhVarZza2.zze().equals(com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
        Boolean.valueOf(zEquals2).getClass();
        return zEquals2;
    }
}
