package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzedw implements zzbqi {
    zzedw() {
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzedx zzedxVar = (zzedx) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkm)).booleanValue()) {
            zzbxl zzbxlVar = zzedxVar.zzc;
            jSONObject2.put("ad_request_url", zzbxlVar.zze());
            jSONObject2.put("ad_request_post_body", zzbxlVar.zzd());
        }
        zzbxl zzbxlVar2 = zzedxVar.zzc;
        jSONObject2.put("base_url", zzbxlVar2.zzc());
        jSONObject2.put("signals", zzedxVar.zzb);
        zzeed zzeedVar = zzedxVar.zza;
        jSONObject3.put(TtmlNode.TAG_BODY, zzeedVar.zzc);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.client.zzbb.zza().zzk(zzeedVar.zzb));
        jSONObject3.put("response_code", zzeedVar.zza);
        jSONObject3.put("latency", zzeedVar.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzbxlVar2.zzh());
        return jSONObject;
    }
}
