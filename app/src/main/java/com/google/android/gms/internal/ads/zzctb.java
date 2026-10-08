package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzctb implements zzdac, zzczi {
    private final Context zza;
    private final zzcgy zzb;
    private final zzffu zzc;
    private final VersionInfoParcel zzd;
    private zzehf zze;
    private boolean zzf;
    private final zzehd zzg;

    public zzctb(Context context, zzcgy zzcgyVar, zzffu zzffuVar, VersionInfoParcel versionInfoParcel, zzehd zzehdVar) {
        this.zza = context;
        this.zzb = zzcgyVar;
        this.zzc = zzffuVar;
        this.zzd = versionInfoParcel;
        this.zzg = zzehdVar;
    }

    private final synchronized void zza() {
        zzcgy zzcgyVar;
        zzehc zzehcVar;
        zzehb zzehbVar;
        zzffu zzffuVar = this.zzc;
        if (zzffuVar.zzT && (zzcgyVar = this.zzb) != null) {
            if (com.google.android.gms.ads.internal.zzt.zzu().zza(this.zza)) {
                VersionInfoParcel versionInfoParcel = this.zzd;
                int i = versionInfoParcel.buddyApkVersion;
                int i2 = versionInfoParcel.clientJarVersion;
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 1 + String.valueOf(i2).length());
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                String string = sb.toString();
                zzfgq zzfgqVar = zzffuVar.zzV;
                String strZza = zzfgqVar.zza();
                if (zzfgqVar.zzc() == 1) {
                    zzehbVar = zzehb.VIDEO;
                    zzehcVar = zzehc.DEFINED_BY_JAVASCRIPT;
                } else {
                    int i3 = zzffuVar.zze;
                    zzehb zzehbVar2 = zzehb.HTML_DISPLAY;
                    zzehcVar = i3 == 1 ? zzehc.ONE_PIXEL : zzehc.BEGIN_TO_RENDER;
                    zzehbVar = zzehbVar2;
                }
                zzehf zzehfVarZzc = com.google.android.gms.ads.internal.zzt.zzu().zzc(string, zzcgyVar.zzD(), "", "javascript", strZza, zzehcVar, zzehbVar, zzffuVar.zzal);
                this.zze = zzehfVarZzc;
                if (zzehfVarZzc != null) {
                    zzfou zzfouVarZza = zzehfVarZzc.zza();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfR)).booleanValue()) {
                        com.google.android.gms.ads.internal.zzt.zzu().zzh(zzfouVarZza, zzcgyVar.zzD());
                        Iterator it = zzcgyVar.zzF().iterator();
                        while (it.hasNext()) {
                            com.google.android.gms.ads.internal.zzt.zzu().zzg(zzfouVarZza, (View) it.next());
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzt.zzu().zzh(zzfouVarZza, zzcgyVar.zzE());
                    }
                    zzcgyVar.zzak(this.zze);
                    com.google.android.gms.ads.internal.zzt.zzu().zze(zzfouVarZza);
                    this.zzf = true;
                    zzcgyVar.zze("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    private final boolean zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfS)).booleanValue() && this.zzg.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzczi
    public final synchronized void zzdw() {
        zzcgy zzcgyVar;
        if (zzb()) {
            this.zzg.zzd();
            return;
        }
        if (!this.zzf) {
            zza();
        }
        if (!this.zzc.zzT || this.zze == null || (zzcgyVar = this.zzb) == null) {
            return;
        }
        zzcgyVar.zze("onSdkImpression", new ArrayMap());
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final synchronized void zzg() {
        if (zzb()) {
            this.zzg.zzc();
        } else {
            if (this.zzf) {
                return;
            }
            zza();
        }
    }
}
