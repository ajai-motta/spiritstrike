package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzbou extends zzbpf, zzbot {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzbou$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
        public static void $default$zzc(zzbou _this, String str, String str2) {
            StringBuilder sb = new StringBuilder(str.length() + 1 + String.valueOf(str2).length() + 2);
            sb.append(str);
            sb.append("(");
            sb.append(str2);
            sb.append(");");
            _this.zza(sb.toString());
        }

        public static void $default$zzd(zzbou _this, String str, JSONObject jSONObject) {
            String string = jSONObject.toString();
            StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
            sb.append(str);
            sb.append("',");
            sb.append(string);
            sb.append(");");
            String string2 = sb.toString();
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Dispatching AFMA event: ".concat(string2));
            _this.zza(sb.toString());
        }

        public static void $default$zze(zzbou _this, String str, Map map) {
            try {
                _this.zzd(str, com.google.android.gms.ads.internal.client.zzbb.zza().zzk(map));
            } catch (JSONException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not convert parameters to JSON.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpf
    void zza(String str);

    @Override // com.google.android.gms.internal.ads.zzbpf
    void zzb(String str, JSONObject jSONObject);

    @Override // com.google.android.gms.internal.ads.zzbpf
    void zzc(String str, String str2);

    @Override // com.google.android.gms.internal.ads.zzbot
    void zzd(String str, JSONObject jSONObject);

    @Override // com.google.android.gms.internal.ads.zzbot
    void zze(String str, Map map);
}
