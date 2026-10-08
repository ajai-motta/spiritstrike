package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.applovin.mediation.AppLovinUtils;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcbe {
    private String zzd;
    private String zze;
    private long zzf;
    private JSONObject zzg;
    private boolean zzh;
    private boolean zzj;
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final Map zzc = new HashMap();
    private final List zzi = new ArrayList();

    public zzcbe(String str, long j) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectOptJSONObject3;
        this.zzd = "";
        this.zzh = false;
        this.zzj = false;
        this.zze = str;
        this.zzf = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzg = new JSONObject(str);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmG)).booleanValue() && zzj()) {
                return;
            }
            if (this.zzg.optInt("status", -1) != 1) {
                this.zzh = false;
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("App settings could not be fetched successfully.");
                return;
            }
            this.zzh = true;
            this.zzd = this.zzg.optString("app_id");
            JSONArray jSONArrayOptJSONArray2 = this.zzg.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(i2);
                    String strOptString = jSONObject.optString("format");
                    String strOptString2 = jSONObject.optString(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID);
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if (ReportUtil.INVENTORY_TYPE_INTERSTITIAL.equalsIgnoreCase(strOptString)) {
                            this.zzb.add(strOptString2);
                        } else if (("rewarded".equalsIgnoreCase(strOptString) || "rewarded_interstitial".equals(strOptString)) && (jSONObjectOptJSONObject3 = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.zzc.put(strOptString2, new zzbrd(jSONObjectOptJSONObject3));
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray3 = this.zzg.optJSONArray("persistable_banner_ad_unit_ids");
            if (jSONArrayOptJSONArray3 != null) {
                for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                    this.zza.add(jSONArrayOptJSONArray3.optString(i3));
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhs)).booleanValue() && (jSONObjectOptJSONObject2 = this.zzg.optJSONObject("common_settings")) != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("loeid")) != null) {
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    this.zzi.add(jSONArrayOptJSONArray.get(i4).toString());
                }
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgO)).booleanValue() || (jSONObjectOptJSONObject = this.zzg.optJSONObject("common_settings")) == null) {
                return;
            }
            this.zzj = jSONObjectOptJSONObject.optBoolean("is_prefetching_enabled", false);
        } catch (JSONException e) {
            int i5 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Exception occurred while processing app setting json", e);
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "AppSettings.parseAppSettingsJson");
        }
    }

    private final boolean zzl() {
        if (!TextUtils.isEmpty(this.zze) && this.zzg != null) {
            long jZzm = zzm();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            if (jZzm >= 0 && (this.zzf > jCurrentTimeMillis || TimeUnit.MILLISECONDS.toSeconds(jCurrentTimeMillis - this.zzf) > jZzm)) {
                return false;
            }
        }
        return true;
    }

    private final long zzm() {
        zzbel zzbelVar = zzbeu.zzmJ;
        return (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmI)).booleanValue() || TextUtils.isEmpty(this.zze)) ? ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).longValue() : this.zzg.optLong("cache_ttl_sec", ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).longValue());
    }

    public final void zza(long j) {
        this.zzf = j;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzd;
    }

    public final Map zzf() {
        return this.zzc;
    }

    public final JSONObject zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zzi;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        zzdvi zzdviVarZzv;
        if (zzl()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeK)).booleanValue() && (zzdviVarZzv = com.google.android.gms.ads.internal.zzt.zzh().zzv()) != null) {
            zzdvh zzdvhVarZza = zzdviVarZzv.zza();
            zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "cld_reset");
            zzdvhVarZza.zzc("cld_lut_ms", String.valueOf(this.zzf));
            zzdvhVarZza.zzc("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()));
            zzdvhVarZza.zzc("cld_ttl_sec", String.valueOf(zzm()));
            zzdvhVarZza.zzd();
        }
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd = "";
        this.zze = "";
        this.zzg = null;
        this.zzh = false;
        this.zzi.clear();
        this.zzj = false;
        return true;
    }

    public final int zzk() {
        if (TextUtils.isEmpty(this.zze) || this.zzg == null) {
            return 3;
        }
        return zzl() ? 1 : 2;
    }
}
