package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcqo {
    private final zzdvi zza;
    private final zzfgf zzb;

    zzcqo(zzdvi zzdviVar, zzfgf zzfgfVar) {
        this.zza = zzdviVar;
        this.zzb = zzfgfVar;
    }

    public final void zza(long j, int i) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zza(this.zzb.zzb.zzb);
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "ad_closed");
        zzdvhVarZza.zzc("show_time", String.valueOf(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        int i2 = i - 1;
        zzdvhVarZza.zzc("acr", i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zzdvhVarZza.zzd();
    }
}
