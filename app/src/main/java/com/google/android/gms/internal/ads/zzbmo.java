package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbmo implements zzblx {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        String strConcat;
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            strConcat = "";
        } else {
            String.valueOf(str4);
            strConcat = "\n".concat(String.valueOf(str4));
        }
        synchronized (this.zza) {
            zzbmn zzbmnVar = (zzbmn) this.zzb.remove(str);
            if (zzbmnVar == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 50);
                sb.append("Received result for unexpected method invocation: ");
                sb.append(str);
                String string = sb.toString();
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + strConcat.length());
                sb2.append(str3);
                sb2.append(strConcat);
                zzbmnVar.zzb(sb2.toString());
                return;
            }
            if (str5 == null) {
                zzbmnVar.zza(null);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    String string2 = jSONObject.toString(2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(string2).length() + 13);
                    sb3.append("Result GMSG: ");
                    sb3.append(string2);
                    com.google.android.gms.ads.internal.util.zze.zza(sb3.toString());
                }
                zzbmnVar.zza(jSONObject);
            } catch (JSONException e) {
                zzbmnVar.zzb(e.getMessage());
            }
        }
    }

    public final void zzb(String str, zzbmn zzbmnVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbmnVar);
        }
    }

    public final ListenableFuture zzc(zzbpf zzbpfVar, String str, JSONObject jSONObject) {
        zzcca zzccaVar = new zzcca();
        com.google.android.gms.ads.internal.zzt.zzc();
        String string = UUID.randomUUID().toString();
        zzb(string, new zzbmm(this, zzccaVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbpfVar.zzb(str, jSONObject2);
        } catch (Exception e) {
            zzccaVar.zzd(e);
        }
        return zzccaVar;
    }
}
