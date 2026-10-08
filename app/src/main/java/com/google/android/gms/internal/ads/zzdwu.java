package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdwu {
    private Long zza;
    private final String zzb;
    private String zzc;
    private Integer zzd;
    private String zze;
    private Integer zzf;

    /* synthetic */ zzdwu(String str, byte[] bArr) {
        this.zzb = str;
    }

    final /* synthetic */ String zza() {
        String str = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkY);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", this.zza);
            jSONObject.put("eventCategory", this.zzb);
            jSONObject.putOpt("event", this.zzc);
            jSONObject.putOpt("errorCode", this.zzd);
            jSONObject.putOpt("rewardType", this.zze);
            jSONObject.putOpt("rewardAmount", this.zzf);
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not convert parameters to JSON.");
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 14 + String.valueOf(string).length() + 2);
        sb.append(str);
        sb.append("(\"h5adsEvent\",");
        sb.append(string);
        sb.append(");");
        return sb.toString();
    }

    final /* synthetic */ void zzb(Long l) {
        this.zza = l;
    }

    final /* synthetic */ void zzc(String str) {
        this.zzc = str;
    }

    final /* synthetic */ void zzd(Integer num) {
        this.zzd = num;
    }

    final /* synthetic */ void zze(String str) {
        this.zze = str;
    }

    final /* synthetic */ void zzf(Integer num) {
        this.zzf = num;
    }
}
