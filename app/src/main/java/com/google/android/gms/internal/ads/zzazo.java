package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazo extends zzazr {
    private final View zzh;

    public zzazo(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2, View view) {
        super(zzaydVar, "UGogIgDf9q+IGA3QKHqW/91b9ZzRTVJqtfmUoLBkD310fwrDg1hJZvDQk8/WK1MH", "sEqRe1gPhw/PwjhUj/qVAEUjKSVJDrXHsmrE44pcjTE=", zzaucVar, i, 57);
        this.zzh = view;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzh;
        if (view != null) {
            Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdU);
            Boolean bool2 = (Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlX);
            zzayh zzayhVar = new zzayh((String) this.zze.invoke(null, view, this.zza.zzb().getResources().getDisplayMetrics(), bool, bool2));
            zzaux zzauxVarZza = zzauy.zza();
            zzauxVarZza.zzb(zzayhVar.zza.longValue());
            zzauxVarZza.zzc(zzayhVar.zzb.longValue());
            zzauxVarZza.zzd(zzayhVar.zzc.longValue());
            if (bool2.booleanValue()) {
                zzauxVarZza.zza(zzayhVar.zze.longValue());
            }
            if (bool.booleanValue()) {
                zzauxVarZza.zze(zzayhVar.zzd.longValue());
            }
            this.zzd.zzM((zzauy) zzauxVarZza.zzbu());
        }
    }
}
