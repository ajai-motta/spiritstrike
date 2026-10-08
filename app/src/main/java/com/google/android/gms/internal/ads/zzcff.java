package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcff implements zzblx {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = (String) map.get(str);
            StringBuilder sb = new StringBuilder(str.length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            String string = sb.toString();
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcfe zzcfhVar;
        zzcdr zzcdrVar = (zzcdr) obj;
        if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzo.zzd("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcex zzcexVarZzB = com.google.android.gms.ads.internal.zzt.zzB();
        if (map.containsKey("abort")) {
            if (zzcexVarZzB.zza(zzcdrVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcdq zzcdqVar = new zzcdq((String) map.get("flags"));
        boolean z = zzcdqVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            zzcew zzcewVarZzb = null;
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i = 0; i < jSONArray.length(); i++) {
                        strArr2[i] = jSONArray.getString(i);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z) {
                Iterator it = zzcexVarZzB.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zzcew zzcewVar = (zzcew) it.next();
                    if (zzcewVar.zza == zzcdrVar && str.equals(zzcewVar.zzd())) {
                        zzcewVarZzb = zzcewVar;
                        break;
                    }
                }
            } else {
                zzcewVarZzb = zzcexVarZzB.zzb(zzcdrVar);
            }
            if (zzcewVarZzb != null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache task is already running.");
                return;
            }
            if (zzcdrVar.zzk() == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = 0;
            }
            if (numZzb != null) {
                zzcdrVar.zzo(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzcdrVar.zzA(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzcdrVar.zzB(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzceo zzceoVar = zzcdrVar.zzk().zzb;
            if (iIntValue > 0) {
                int i2 = zzcdqVar.zzg;
                int iZzQ = zzcdi.zzQ();
                if (iZzQ < i2) {
                    zzcfhVar = new zzcfn(zzcdrVar, zzcdqVar);
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzq)).booleanValue()) {
                        iZzQ = zzcfk.zzr();
                    }
                    zzcfhVar = iZzQ < zzcdqVar.zzb ? new zzcfk(zzcdrVar, zzcdqVar) : new zzcfi(zzcdrVar);
                }
            } else {
                zzcfhVar = new zzcfh(zzcdrVar);
            }
            new zzcew(zzcdrVar, zzcfhVar, str, strArr).zzb();
        } else {
            zzcew zzcewVarZzb2 = zzcexVarZzB.zzb(zzcdrVar);
            if (zzcewVarZzb2 == null) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache must specify a source.");
                return;
            }
            zzcfhVar = zzcewVarZzb2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzcfhVar.zzi(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzcfhVar.zzh(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzcfhVar.zzj(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzcfhVar.zzk(numZzb8.intValue());
        }
    }
}
