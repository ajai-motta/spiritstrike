package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzfqi {
    private final String zza;
    private zzfrk zzb;
    private long zzc;
    private int zzd;

    public zzfqi(String str) {
        zzp();
        this.zza = str;
        this.zzb = new zzfrk(null);
    }

    public void zza() {
    }

    public void zzb() {
        this.zzb.clear();
    }

    final void zzc(WebView webView) {
        this.zzb = new zzfrk(webView);
    }

    public final WebView zzd() {
        return (WebView) this.zzb.get();
    }

    public final boolean zze() {
        return this.zzb.get() != null;
    }

    public final void zzf(boolean z) {
        if (zze()) {
            zzfpz.zza().zzf(zzd(), this.zza, true != z ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzg(boolean z) {
        if (zze()) {
            zzfpz.zza().zzg(zzd(), this.zza, true != z ? "unlocked" : "locked");
        }
    }

    public final void zzh(String str, long j) {
        if (j >= this.zzc) {
            this.zzd = 2;
            zzfpz.zza().zze(zzd(), this.zza, str);
        }
    }

    public final void zzi(String str, long j) {
        if (j < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzfpz.zza().zze(zzd(), this.zza, str);
    }

    public final void zzj(zzfov zzfovVar) {
        zzfpz.zza().zzb(zzd(), this.zza, zzfovVar.zzb());
    }

    public void zzk(zzfoy zzfoyVar, zzfow zzfowVar) {
        zzl(zzfoyVar, zzfowVar, null);
    }

    protected final void zzl(zzfoy zzfoyVar, zzfow zzfowVar, JSONObject jSONObject) {
        String strZzh = zzfoyVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfqo.zzc(jSONObject2, "environment", "app");
        zzfqo.zzc(jSONObject2, "adSessionType", zzfowVar.zzi());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("; ");
        sb.append(str2);
        zzfqo.zzc(jSONObject3, "deviceType", sb.toString());
        zzfqo.zzc(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfqo.zzc(jSONObject3, "os", "Android");
        zzfqo.zzc(jSONObject2, "deviceInfo", jSONObject3);
        zzfqo.zzc(jSONObject2, "deviceCategory", zzfqn.zzb().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfqo.zzc(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfqo.zzc(jSONObject4, HandleInvocationsFromAdViewer.KEY_OM_PARTNER, zzfowVar.zzc().zzb());
        zzfqo.zzc(jSONObject4, HandleInvocationsFromAdViewer.KEY_OM_PARTNER_VERSION, zzfowVar.zzc().zzc());
        zzfqo.zzc(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfqo.zzc(jSONObject5, "libraryVersion", "1.5.2-google_20241009");
        zzfqo.zzc(jSONObject5, "appId", zzfpx.zza().zzb().getApplicationContext().getPackageName());
        zzfqo.zzc(jSONObject2, "app", jSONObject5);
        if (zzfowVar.zzg() != null) {
            zzfqo.zzc(jSONObject2, "contentUrl", zzfowVar.zzg());
        }
        if (zzfowVar.zzh() != null) {
            zzfqo.zzc(jSONObject2, "customReferenceData", zzfowVar.zzh());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfowVar.zzd().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfpz.zza().zzc(zzd(), strZzh, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzm() {
        zzfpz.zza().zzd(zzd(), this.zza);
    }

    public final void zzn(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfqo.zzc(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfpz.zza().zzi(zzd(), jSONObject);
    }

    public final void zzo(float f) {
        zzfpz.zza().zzh(zzd(), this.zza, f);
    }

    public final void zzp() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }
}
