package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzehd {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzffu zzc;
    private final zzcgy zzd;
    private final zzdvi zze;
    private zzfpg zzf;

    zzehd(Context context, VersionInfoParcel versionInfoParcel, zzffu zzffuVar, zzcgy zzcgyVar, zzdvi zzdviVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzffuVar;
        this.zzd = zzcgyVar;
        this.zze = zzdviVar;
    }

    public final synchronized boolean zza(boolean z) {
        zzcgy zzcgyVar;
        zzffu zzffuVar = this.zzc;
        if (zzffuVar.zzT) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfS)).booleanValue() && (zzcgyVar = this.zzd) != null) {
                    if (this.zzf != null) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid javascript session service already started for ad.");
                        return false;
                    }
                    if (!com.google.android.gms.ads.internal.zzt.zzu().zza(this.zza)) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to initialize omid.");
                        return false;
                    }
                    if (zzffuVar.zzV.zzb()) {
                        zzfpg zzfpgVarZzi = com.google.android.gms.ads.internal.zzt.zzu().zzi(this.zzb, zzcgyVar.zzD(), true);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfT)).booleanValue()) {
                            zzdvi zzdviVar = this.zze;
                            String str = zzfpgVarZzi != null ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                            zzdvh zzdvhVarZza = zzdviVar.zza();
                            zzdvhVarZza.zzc("omid_js_session_success", str);
                            zzdvhVarZza.zzd();
                        }
                        if (zzfpgVarZzi == null) {
                            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to create javascript session service.");
                            return false;
                        }
                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Created omid javascript session service.");
                        this.zzf = zzfpgVarZzi;
                        zzcgyVar.zzal(this);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final synchronized boolean zzb() {
        return this.zzf != null;
    }

    public final synchronized void zzc() {
        zzcgy zzcgyVar;
        zzfpg zzfpgVar = this.zzf;
        if (zzfpgVar == null || (zzcgyVar = this.zzd) == null) {
            return;
        }
        Iterator it = zzcgyVar.zzF().iterator();
        while (it.hasNext()) {
            com.google.android.gms.ads.internal.zzt.zzu().zzk(zzfpgVar, (View) it.next());
        }
        zzcgyVar.zze("onSdkLoaded", zzgph.zza());
    }

    public final synchronized void zzd() {
        zzcgy zzcgyVar;
        if (this.zzf == null || (zzcgyVar = this.zzd) == null) {
            return;
        }
        zzcgyVar.zze("onSdkImpression", zzgph.zza());
    }

    public final synchronized void zze(zzfpf zzfpfVar) {
        zzcgy zzcgyVar;
        zzfpg zzfpgVar = this.zzf;
        if (zzfpgVar == null || (zzcgyVar = this.zzd) == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzu().zzj(zzfpgVar, zzfpfVar);
        this.zzf = null;
        zzcgyVar.zzal(null);
    }

    public final synchronized void zzf(View view) {
        zzfpg zzfpgVar = this.zzf;
        if (zzfpgVar != null) {
            com.google.android.gms.ads.internal.zzt.zzu().zzk(zzfpgVar, view);
        }
    }
}
