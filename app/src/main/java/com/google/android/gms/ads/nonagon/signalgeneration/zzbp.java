package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgz;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbp extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ TaggingLibraryJsInterface zzb;

    zzbp(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = str;
        Objects.requireNonNull(taggingLibraryJsInterface);
        this.zzb = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        String.valueOf(str);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        String strConcat = ((Boolean) zzbgz.zzc.zze()).booleanValue() ? ",\"as\":".concat(this.zzb.zze().zzb().toString()) : "";
        String str2 = this.zza;
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[4];
        objArr[0] = str2;
        objArr[1] = str;
        zzbge zzbgeVar = zzbgz.zze;
        objArr[2] = Long.valueOf(((Boolean) zzbgeVar.zze()).booleanValue() ? ((Long) zzbgz.zzh.zze()).longValue() : 0L);
        objArr[3] = strConcat;
        final String str3 = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", objArr);
        if (((Boolean) zzbgeVar.zze()).booleanValue()) {
            try {
                this.zzb.zzd().execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbn
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb.zzc().evaluateJavascript(str3, null);
                    }
                });
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            this.zzb.zzc().evaluateJavascript(str3, null);
        }
        if (((Boolean) zzbgz.zzc.zze()).booleanValue() && ((Boolean) zzbgz.zzd.zze()).booleanValue()) {
            this.zzb.zzf().zza();
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        final String str;
        String query = queryInfo.getQuery();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.zza);
            if (((Boolean) zzbgz.zzc.zze()).booleanValue()) {
                jSONObject.put("as", this.zzb.zze().zzb());
            }
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbgz.zze.zze()).booleanValue() ? ((Long) zzbgz.zzh.zze()).longValue() : 0L);
            jSONObject.put("signal", query);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            String strConcat = ((Boolean) zzbgz.zzc.zze()).booleanValue() ? ",\"as\":".concat(this.zzb.zze().zzb().toString()) : "";
            String str2 = this.zza;
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            objArr[0] = str2;
            objArr[1] = queryInfo.getQuery();
            objArr[2] = Long.valueOf(((Boolean) zzbgz.zze.zze()).booleanValue() ? ((Long) zzbgz.zzh.zze()).longValue() : 0L);
            objArr[3] = strConcat;
            str = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", objArr);
        }
        if (((Boolean) zzbgz.zze.zze()).booleanValue()) {
            try {
                this.zzb.zzd().execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbo
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzb.zzc().evaluateJavascript(str, null);
                    }
                });
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            this.zzb.zzc().evaluateJavascript(str, null);
        }
        if (((Boolean) zzbgz.zzc.zze()).booleanValue() && ((Boolean) zzbgz.zzd.zze()).booleanValue()) {
            this.zzb.zzf().zza();
        }
    }
}
