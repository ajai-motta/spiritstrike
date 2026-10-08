package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.applovin.mediation.AppLovinUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbel;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbqf;
import com.google.android.gms.internal.ads.zzbqj;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzcbe;
import com.google.android.gms.internal.ads.zzcbv;
import com.google.android.gms.internal.ads.zzcby;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzflc;
import com.google.android.gms.internal.ads.zzflp;
import com.google.android.gms.internal.ads.zzgtq;
import com.google.android.gms.internal.ads.zzgui;
import com.google.android.gms.internal.ads.zzgus;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzf {
    private Context zza;
    private long zzb = 0;

    static final /* synthetic */ ListenableFuture zzd(Long l, zzdvi zzdviVar, zzflc zzflcVar, zzflp zzflpVar, JSONObject jSONObject) throws JSONException {
        boolean zOptBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (zOptBoolean) {
            zzt.zzh().zzo().zzh(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzdviVar, "cld_s", zzt.zzk().elapsedRealtime() - l.longValue());
            }
        }
        String strOptString = jSONObject.optString("errorReason", "");
        if (!TextUtils.isEmpty(strOptString)) {
            zzflcVar.zzk(strOptString);
        }
        zzflcVar.zzd(zOptBoolean);
        zzflpVar.zzb(zzflcVar.zzm());
        return zzgui.zza(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zzf(zzdvi zzdviVar, String str, long j) {
        if (zzdviVar != null) {
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zznH)).booleanValue()) {
                zzdvh zzdvhVarZza = zzdviVar.zza();
                zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "lat_init");
                zzdvhVarZza.zzc(str, Long.toString(j));
                zzdvhVarZza.zzd();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzflp zzflpVar, zzdvi zzdviVar, Long l, boolean z) {
        zzc(context, versionInfoParcel, true, null, str, null, runnable, zzflpVar, zzdviVar, l, z);
    }

    public final void zzb(Context context, VersionInfoParcel versionInfoParcel, String str, zzcbe zzcbeVar, zzflp zzflpVar, boolean z) {
        zzc(context, versionInfoParcel, false, zzcbeVar, zzcbeVar != null ? zzcbeVar.zze() : null, str, null, zzflpVar, null, null, z);
    }

    final void zzc(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzcbe zzcbeVar, String str, String str2, Runnable runnable, final zzflp zzflpVar, final zzdvi zzdviVar, final Long l, boolean z2) {
        PackageInfo packageInfo;
        if (zzt.zzk().elapsedRealtime() - this.zzb < 5000) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzk().elapsedRealtime();
        if (zzcbeVar != null && !TextUtils.isEmpty(zzcbeVar.zzd())) {
            if (zzt.zzk().currentTimeMillis() - zzcbeVar.zzb() <= ((Long) zzbd.zzc().zzd(zzbeu.zzeJ)).longValue() && zzcbeVar.zzc()) {
                return;
            }
        }
        if (context == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Context not provided to fetch application settings");
            return;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("App settings could not be fetched. Required parameters missing");
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            applicationContext = context;
        }
        this.zza = applicationContext;
        final zzflc zzflcVarZzn = zzflc.CC.zzn(context, 4);
        zzflcVarZzn.zza();
        zzbqp zzbqpVarZzb = zzt.zzr().zzb(this.zza, versionInfoParcel, zzflpVar);
        zzbqj zzbqjVar = zzbqm.zza;
        zzbqf zzbqfVarZza = zzbqpVarZzb.zza("google.afma.config.fetchAppSettings", zzbqjVar, zzbqjVar);
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("app_id", str);
            } else if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, str2);
            }
            jSONObject.put("is_init", z);
            jSONObject.put("pn", context.getPackageName());
            zzbel zzbelVar = zzbeu.zza;
            jSONObject.put("experiment_ids", TextUtils.join(",", zzbd.zzb().zze()));
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zzkz)).booleanValue()) {
                jSONObject.put("inspector_enabled", z2);
            }
            try {
                ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                if (applicationInfo != null && (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) != null) {
                    jSONObject.put("version", packageInfo.versionCode);
                }
            } catch (PackageManager.NameNotFoundException unused) {
                com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
            }
            ListenableFuture listenableFutureZzb = zzbqfVarZza.zzb(jSONObject);
            zzgtq zzgtqVar = new zzgtq(this) { // from class: com.google.android.gms.ads.internal.zzd
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return zzf.zzd(l, zzdviVar, zzflcVarZzn, zzflpVar, (JSONObject) obj);
                }
            };
            zzgus zzgusVar = zzcbv.zzg;
            ListenableFuture listenableFutureZzj = zzgui.zzj(listenableFutureZzb, zzgtqVar, zzgusVar);
            if (runnable != null) {
                listenableFutureZzb.addListener(runnable, zzgusVar);
            }
            if (l != null) {
                listenableFutureZzb.addListener(new Runnable(this) { // from class: com.google.android.gms.ads.internal.zze
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzf.zzf(zzdviVar, "cld_r", zzt.zzk().elapsedRealtime() - l.longValue());
                    }
                }, zzgusVar);
            }
            if (((Boolean) zzbd.zzc().zzd(zzbeu.zziq)).booleanValue()) {
                zzcby.zzb(listenableFutureZzj, "ConfigLoader.maybeFetchNewAppSettings");
            } else {
                zzcby.zza(listenableFutureZzj, "ConfigLoader.maybeFetchNewAppSettings");
            }
        } catch (Exception e) {
            int i4 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error requesting application settings", e);
            zzflcVarZzn.zzj(e);
            zzflcVarZzn.zzd(false);
            zzflpVar.zzb(zzflcVarZzn.zzm());
        }
    }
}
