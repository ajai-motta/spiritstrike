package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.google.android.gms.ads.AdFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzflm implements Runnable {
    private final zzflp zzb;
    private String zzc;
    private String zze;
    private zzfge zzf;
    private com.google.android.gms.ads.internal.client.zze zzg;
    private Future zzh;
    private final List zza = new ArrayList();
    private int zzi = 2;
    private zzflr zzd = zzflr.SCAR_REQUEST_TYPE_UNSPECIFIED;

    zzflm(zzflp zzflpVar) {
        this.zzb = zzflpVar;
    }

    @Override // java.lang.Runnable
    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzflm zza(zzflc zzflcVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzflcVar.zzc();
            list.add(zzflcVar);
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            this.zzh = zzcbv.zzd.schedule(this, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjG)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzflm zzb(ArrayList arrayList) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            if (arrayList.contains(ReportUtil.INVENTORY_TYPE_BANNER) || arrayList.contains(AdFormat.BANNER.name())) {
                this.zzi = 3;
            } else if (arrayList.contains(ReportUtil.INVENTORY_TYPE_INTERSTITIAL) || arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                this.zzi = 4;
            } else if (arrayList.contains("native") || arrayList.contains(AdFormat.NATIVE.name())) {
                this.zzi = 8;
            } else if (arrayList.contains("rewarded") || arrayList.contains(AdFormat.REWARDED.name())) {
                this.zzi = 5;
            } else if (arrayList.contains("app_open_ad")) {
                this.zzi = 7;
            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                this.zzi = 6;
            }
        }
        return this;
    }

    public final synchronized zzflm zzc(String str) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue() && zzfll.zza(str)) {
            this.zzc = str;
        }
        return this;
    }

    public final synchronized zzflm zzd(Bundle bundle) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            this.zzd = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzd(bundle);
        }
        return this;
    }

    public final synchronized zzflm zze(zzfge zzfgeVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            this.zzf = zzfgeVar;
        }
        return this;
    }

    public final synchronized zzflm zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            this.zzg = zzeVar;
        }
        return this;
    }

    public final synchronized zzflm zzg(String str) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized void zzh() {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            List<zzflc> list = this.zza;
            for (zzflc zzflcVar : list) {
                int i = this.zzi;
                if (i != 2) {
                    zzflcVar.zzp(i);
                }
                if (!TextUtils.isEmpty(this.zzc)) {
                    zzflcVar.zze(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zze) && !zzflcVar.zzl()) {
                    zzflcVar.zzi(this.zze);
                }
                zzfge zzfgeVar = this.zzf;
                if (zzfgeVar != null) {
                    zzflcVar.zzg(zzfgeVar);
                } else {
                    com.google.android.gms.ads.internal.client.zze zzeVar = this.zzg;
                    if (zzeVar != null) {
                        zzflcVar.zzh(zzeVar);
                    }
                }
                zzflcVar.zzf(this.zzd);
                this.zzb.zzb(zzflcVar.zzm());
            }
            list.clear();
        }
    }

    public final synchronized zzflm zzi(int i) {
        if (((Boolean) zzbgn.zzc.zze()).booleanValue()) {
            this.zzi = i;
        }
        return this;
    }
}
