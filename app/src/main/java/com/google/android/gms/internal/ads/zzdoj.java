package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdoj {
    private final zzgus zza;
    private final zzdoy zzb;
    private final zzdpd zzc;
    private final zzdvc zzd;

    zzdoj(zzgus zzgusVar, zzdoy zzdoyVar, zzdpd zzdpdVar, zzdvc zzdvcVar) {
        this.zza = zzgusVar;
        this.zzb = zzdoyVar;
        this.zzc = zzdpdVar;
        this.zzd = zzdvcVar;
    }

    private final ListenableFuture zze(ListenableFuture listenableFuture, zzduq zzduqVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            zzgui.zzr(listenableFuture, new zzdog(this, zzduqVar), this.zza);
        }
        return listenableFuture;
    }

    private static final boolean zzf(JSONObject jSONObject) {
        return jSONObject.optInt("template_id") == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zza(final com.google.android.gms.internal.ads.zzfgf r18, final com.google.android.gms.internal.ads.zzffu r19, final org.json.JSONObject r20, com.google.android.gms.ads.internal.zzb r21, com.google.android.gms.internal.ads.zzbzt r22) {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdoj.zza(com.google.android.gms.internal.ads.zzfgf, com.google.android.gms.internal.ads.zzffu, org.json.JSONObject, com.google.android.gms.ads.internal.zzb, com.google.android.gms.internal.ads.zzbzt):com.google.common.util.concurrent.ListenableFuture");
    }

    final /* synthetic */ zzdlq zzb(zzfgf zzfgfVar, zzffu zzffuVar, JSONObject jSONObject) throws zzekz {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            this.zzd.zze().putLong(zzduq.NATIVE_ASSETS_LOADING_BASIC_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        zzdlq zzdlqVar = new zzdlq();
        zzdlqVar.zza(jSONObject.optInt("template_id", -1));
        zzdlqVar.zzl(jSONObject.optString("custom_template_id"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        zzdlqVar.zzv(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("omid_partner_name") : null);
        zzfgn zzfgnVar = zzfgfVar.zza.zza;
        if (!zzfgnVar.zzh.contains(Integer.toString(zzdlqVar.zzx()))) {
            int iZzx = zzdlqVar.zzx();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzx).length() + 21);
            sb.append("Invalid template ID: ");
            sb.append(iZzx);
            throw new zzekz(1, sb.toString());
        }
        if (zzdlqVar.zzx() == 3) {
            if (zzdlqVar.zzS() == null) {
                throw new zzekz(1, "No custom template id for custom template ad response.");
            }
            if (!zzfgnVar.zzi.contains(zzdlqVar.zzS())) {
                throw new zzekz(1, "Unexpected custom template id in the response.");
            }
        }
        zzdlqVar.zzi(jSONObject.optDouble("rating", -1.0d));
        String strOptString = jSONObject.optString("headline", null);
        if (zzffuVar.zzM) {
            com.google.android.gms.ads.internal.zzt.zzc();
            String strZzC = com.google.android.gms.ads.internal.util.zzs.zzC();
            StringBuilder sb2 = new StringBuilder(String.valueOf(strZzC).length() + 3 + String.valueOf(strOptString).length());
            sb2.append(strZzC);
            sb2.append(" : ");
            sb2.append(strOptString);
            strOptString = sb2.toString();
        }
        zzdlqVar.zzs("headline", strOptString);
        zzdlqVar.zzs(TtmlNode.TAG_BODY, jSONObject.optString(TtmlNode.TAG_BODY, null));
        zzdlqVar.zzs("call_to_action", jSONObject.optString("call_to_action", null));
        zzdlqVar.zzs("store", jSONObject.optString("store", null));
        zzdlqVar.zzs("price", jSONObject.optString("price", null));
        zzdlqVar.zzs("advertiser", jSONObject.optString("advertiser", null));
        return zzdlqVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzdlq zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9, ListenableFuture listenableFuture10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcx)).booleanValue()) {
            this.zzd.zze().putLong(zzduq.RENDERING_NATIVE_ASSETS_LOADING_END.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        zzdlq zzdlqVar = (zzdlq) listenableFuture.get();
        zzdlqVar.zzd((List) listenableFuture2.get());
        zzdlqVar.zzj((zzbii) listenableFuture3.get());
        zzdlqVar.zzk((zzbii) listenableFuture4.get());
        zzdlqVar.zzc((zzbib) listenableFuture5.get());
        zzdlqVar.zze(zzdoy.zzl(jSONObject));
        zzdlqVar.zzf(zzdoy.zzk(jSONObject));
        zzcgy zzcgyVar = (zzcgy) listenableFuture6.get();
        if (zzcgyVar != null) {
            zzdlqVar.zzm(zzcgyVar);
            zzdlqVar.zzg(zzcgyVar.zzE());
            zzdlqVar.zzb(zzcgyVar.zzh());
        }
        zzdlqVar.zzH().putAll((Bundle) listenableFuture7.get());
        zzcgy zzcgyVar2 = (zzcgy) listenableFuture8.get();
        if (zzcgyVar2 != null) {
            zzdlqVar.zzn(zzcgyVar2);
            zzdlqVar.zzh(zzcgyVar2.zzE());
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfW)).booleanValue() || zzf(jSONObject)) {
            zzcgy zzcgyVar3 = (zzcgy) listenableFuture9.get();
            if (zzcgyVar3 != null) {
                zzdlqVar.zzo(zzcgyVar3);
            }
        } else {
            zzdlqVar.zzp(listenableFuture9);
            zzdlqVar.zzr(new zzcca());
        }
        for (zzdpa zzdpaVar : (List) listenableFuture10.get()) {
            if (zzdpaVar.zza != 1) {
                zzdlqVar.zzt(zzdpaVar.zzb, zzdpaVar.zzd);
            } else {
                zzdlqVar.zzs(zzdpaVar.zzb, zzdpaVar.zzc);
            }
        }
        return zzdlqVar;
    }

    final /* synthetic */ zzdvc zzd() {
        return this.zzd;
    }
}
