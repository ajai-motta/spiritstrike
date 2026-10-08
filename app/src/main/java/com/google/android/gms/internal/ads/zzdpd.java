package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdpd {
    private final Executor zza;
    private final zzdoy zzb;
    private final zzdvc zzc;

    zzdpd(Executor executor, zzdoy zzdoyVar, zzdvc zzdvcVar) {
        this.zza = executor;
        this.zzb = zzdoyVar;
        this.zzc = zzdvcVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZza;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzgui.zza(Collections.emptyList());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            this.zzc.zze().putLong(zzduq.NATIVE_ASSETS_LOADING_CUSTOM_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZza = zzgui.zza(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    listenableFutureZza = zzgui.zza(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZza = TypedValues.Custom.S_STRING.equals(strOptString2) ? zzgui.zza(new zzdpa(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzgui.zzk(this.zzb.zza(jSONObjectOptJSONObject, "image_value", null), new zzglu() { // from class: com.google.android.gms.internal.ads.zzdpb
                        @Override // com.google.android.gms.internal.ads.zzglu
                        public final /* synthetic */ Object apply(Object obj) {
                            return new zzdpa(strOptString, (zzbht) obj);
                        }
                    }, this.zza) : zzgui.zza(null);
                }
            }
            arrayList.add(listenableFutureZza);
        }
        return zzgui.zzk(zzgui.zzm(arrayList), zzdpc.zza, this.zza);
    }
}
