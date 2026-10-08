package com.google.android.gms.internal.ads;

import android.content.Context;
import com.applovin.mediation.AppLovinUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.AdFormat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfnv {
    private final zzdvi zza;

    zzfnv(zzdvi zzdviVar, Context context) {
        this.zza = zzdviVar;
    }

    private final void zzq(String str, long j, String str2, String str3, AdFormat adFormat, int i, int i2, int i3, String str4) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, str);
        zzdvhVarZza.zzc("pat", Long.toString(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, adFormat.name().toLowerCase(Locale.ENGLISH));
        zzdvhVarZza.zzc("max_ads", Integer.toString(i));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i2));
        zzdvhVarZza.zzc("pas", Integer.toString(i3));
        zzdvhVarZza.zzc("pv", "2");
        zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, str3);
        zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, str2);
        zzdvhVarZza.zzd();
    }

    private final void zzr(String str, String str2, long j, int i, int i2, String str3, zzfoc zzfocVar, String str4) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(str2, Long.toString(j));
        if (zzfocVar != null) {
            zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, zzfocVar.zza());
            zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
            zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, zzfocVar.zzc());
        }
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, str);
        if (str3 != null) {
            zzdvhVarZza.zzc("gqi", str3);
        }
        if (i >= 0) {
            zzdvhVarZza.zzc("max_ads", Integer.toString(i));
        }
        if (i2 >= 0) {
            zzdvhVarZza.zzc("cache_size", Integer.toString(i2));
        }
        zzdvhVarZza.zzc("pv", str4);
        zzdvhVarZza.zzd();
    }

    public final void zza(int i, long j, zzfoc zzfocVar, String str) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "start_preload");
        zzdvhVarZza.zzc("sp_ts", Long.toString(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, zzfocVar.zza());
        zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, zzfocVar.zzc());
        zzdvhVarZza.zzc("max_ads", Integer.toString(i));
        zzdvhVarZza.zzc("pv", str);
        zzdvhVarZza.zzd();
    }

    public final void zzb(Map map, long j, String str) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "start_preload");
        zzdvhVarZza.zzc("sp_ts", Long.toString(j));
        zzdvhVarZza.zzc("pv", "1");
        for (AdFormat adFormat : map.keySet()) {
            String lowerCase = adFormat.name().toLowerCase(Locale.ENGLISH);
            String.valueOf(lowerCase);
            String strValueOf = String.valueOf(lowerCase);
            zzdvhVarZza.zzc(strValueOf.concat("_count"), Integer.toString(((Integer) map.get(adFormat)).intValue()));
        }
        zzdvhVarZza.zzd();
    }

    public final void zzc(int i, int i2, long j, zzfoc zzfocVar) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "cache_resize");
        zzdvhVarZza.zzc("cs_ts", Long.toString(j));
        zzdvhVarZza.zzc("orig_ma", Integer.toString(i));
        zzdvhVarZza.zzc("max_ads", Integer.toString(i2));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, zzfocVar.zza());
        zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, zzfocVar.zzc());
        zzdvhVarZza.zzc("pv", "1");
        zzdvhVarZza.zzd();
    }

    public final void zzd(int i, int i2, long j, Long l, String str, zzfoc zzfocVar, String str2) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("plaac_ts", Long.toString(j));
        zzdvhVarZza.zzc("max_ads", Integer.toString(i));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i2));
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "is_ad_available");
        if (zzfocVar != null) {
            zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, zzfocVar.zza());
            zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, zzfocVar.zzc());
            zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        }
        if (l != null) {
            zzdvhVarZza.zzc("plaay_ts", Long.toString(l.longValue()));
        }
        if (str != null) {
            zzdvhVarZza.zzc("gqi", str);
        }
        zzdvhVarZza.zzc("pv", str2);
        zzdvhVarZza.zzd();
    }

    public final void zze(long j, String str) {
        zzr("poll_ad", "ppacwe_ts", j, -1, -1, null, null, "2");
    }

    public final void zzf(long j, zzfoc zzfocVar, int i, int i2, String str) {
        zzr("poll_ad", "ppac_ts", j, i, i2, null, zzfocVar, str);
    }

    public final void zzg(long j, int i, int i2, String str, zzfoc zzfocVar, String str2) {
        zzr("poll_ad", "psvroc_ts", j, i, i2, str, zzfocVar, str2);
    }

    public final void zzh(long j, int i, int i2, String str, zzfoc zzfocVar, String str2) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("ppla_ts", Long.toString(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, zzfocVar.zza());
        zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, zzfocVar.zzc());
        zzdvhVarZza.zzc("max_ads", Integer.toString(i));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i2));
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "poll_ad");
        if (str != null) {
            zzdvhVarZza.zzc("gqi", str);
        }
        zzdvhVarZza.zzc("pv", str2);
        zzdvhVarZza.zzd();
    }

    public final void zzi(long j, String str, zzfoc zzfocVar, int i, int i2, String str2) {
        zzr("paa", "pano_ts", j, i, i2, str, zzfocVar, str2);
    }

    public final void zzj(long j, zzfoc zzfocVar, int i, String str) {
        zzr("pae", "paeo_ts", j, i, 0, null, zzfocVar, str);
    }

    public final void zzk(long j, zzfoc zzfocVar, com.google.android.gms.ads.internal.client.zze zzeVar, int i, int i2, String str) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "pftla");
        zzdvhVarZza.zzc("pftlat_ts", Long.toString(j));
        zzdvhVarZza.zzc("pftlaec", Integer.toString(zzeVar.zza));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, zzfocVar.zzb());
        zzdvhVarZza.zzc("max_ads", Integer.toString(i));
        zzdvhVarZza.zzc("cache_size", Integer.toString(i2));
        zzdvhVarZza.zzc(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, zzfocVar.zza());
        zzdvhVarZza.zzc(AnalyticsProviderAdjust.EventKeys.pid, zzfocVar.zzc());
        zzdvhVarZza.zzc("pv", str);
        zzdvhVarZza.zzd();
    }

    public final void zzl(long j, AdFormat adFormat, int i) {
        zzq("pda", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzm(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzq("pd", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zzn(AdFormat adFormat, long j, int i) {
        zzq("pgcs", j, null, null, adFormat, -1, -1, i, "2");
    }

    public final void zzo(long j, String str, String str2, AdFormat adFormat, int i, int i2) {
        zzq("pgc", j, str, str2, adFormat, i, i2, 1, "2");
    }

    public final void zzp(int i, long j, String str, String str2, AdFormat adFormat, int i2) {
        zzq("pnav", j, str, str2, adFormat, i2, i, 1, "2");
    }
}
