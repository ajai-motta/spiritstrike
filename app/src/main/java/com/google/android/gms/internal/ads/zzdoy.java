package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdoy {
    private final Context zza;
    private final zzdoe zzb;
    private final zzaxa zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbdt zzf;
    private final Executor zzg;
    private final zzbhx zzh;
    private final zzdpq zzi;
    private final zzdse zzj;
    private final ScheduledExecutorService zzk;
    private final zzdqz zzl;
    private final zzdvi zzm;
    private final zzfng zzn;
    private final zzefy zzo;
    private final zzegj zzp;
    private final zzfgr zzq;
    private final zzdvc zzr;
    private final zzdwl zzs;

    public zzdoy(Context context, zzdoe zzdoeVar, zzaxa zzaxaVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbdt zzbdtVar, Executor executor, zzfgn zzfgnVar, zzdpq zzdpqVar, zzdse zzdseVar, ScheduledExecutorService scheduledExecutorService, zzdvi zzdviVar, zzfng zzfngVar, zzefy zzefyVar, zzdqz zzdqzVar, zzegj zzegjVar, zzfgr zzfgrVar, zzdvc zzdvcVar, zzdwl zzdwlVar) {
        this.zza = context;
        this.zzb = zzdoeVar;
        this.zzc = zzaxaVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbdtVar;
        this.zzg = executor;
        this.zzh = zzfgnVar.zzj;
        this.zzi = zzdpqVar;
        this.zzj = zzdseVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdviVar;
        this.zzn = zzfngVar;
        this.zzo = zzefyVar;
        this.zzl = zzdqzVar;
        this.zzp = zzegjVar;
        this.zzq = zzfgrVar;
        this.zzr = zzdvcVar;
        this.zzs = zzdwlVar;
    }

    public static final com.google.android.gms.ads.internal.client.zzez zzk(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzt(jSONObjectOptJSONObject);
    }

    public static final List zzl(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzgpe.zzi();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgpe.zzi();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            com.google.android.gms.ads.internal.client.zzez zzezVarZzt = zzt(jSONArrayOptJSONArray.optJSONObject(i));
            if (zzezVarZzt != null) {
                arrayList.add(zzezVarZzt);
            }
        }
        return zzgpe.zzq(arrayList);
    }

    private final ListenableFuture zzm(JSONArray jSONArray, boolean z, boolean z2, zzduq zzduqVar) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgui.zza(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            this.zzr.zze().putLong(zzduqVar.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z, null));
        }
        return zzgui.zzk(zzgui.zzm(arrayList), zzdox.zza, this.zzg);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.common.util.concurrent.ListenableFuture zzn(org.json.JSONObject r16, boolean r17, com.google.android.gms.internal.ads.zzduq r18) {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdoy.zzn(org.json.JSONObject, boolean, com.google.android.gms.internal.ads.zzduq):com.google.common.util.concurrent.ListenableFuture");
    }

    private static Integer zzo(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzffu zzffuVar, zzffx zzffxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbzt zzbztVar) {
        final ListenableFuture listenableFutureZzb = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString("html"), zzffuVar, zzffxVar, zzs(jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0), jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0)), zzbVar, zzbztVar);
        return zzgui.zzj(listenableFutureZzb, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzdos
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) throws zzekz {
                zzcgy zzcgyVar = (zzcgy) obj;
                if (zzcgyVar == null || zzcgyVar.zzh() == null) {
                    throw new zzekz(1, "Retrieve video view in html5 ad response failed.");
                }
                return listenableFutureZzb;
            }
        }, zzcbv.zzg);
    }

    private static ListenableFuture zzq(ListenableFuture listenableFuture, Object obj) {
        final Object obj2 = null;
        return zzgui.zzh(listenableFuture, Exception.class, new zzgtq(obj2) { // from class: com.google.android.gms.internal.ads.zzdot
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzgui.zza(null);
            }
        }, zzcbv.zzg);
    }

    private static ListenableFuture zzr(boolean z, final ListenableFuture listenableFuture, Object obj) {
        return z ? zzgui.zzj(listenableFuture, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzdou
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj2) {
                return obj2 != null ? listenableFuture : zzgui.zzc(new zzekz(1, "Retrieve required value in native ad response failed."));
            }
        }, zzcbv.zzg) : zzq(listenableFuture, null);
    }

    private static final com.google.android.gms.ads.internal.client.zzez zzt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzez(strOptString, strOptString2);
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str, zzduq zzduqVar) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb, zzduqVar);
    }

    public final ListenableFuture zzb(JSONObject jSONObject, String str, zzduq zzduqVar) {
        zzbhx zzbhxVar = this.zzh;
        return zzm(jSONObject.optJSONArray("images"), zzbhxVar.zzb, zzbhxVar.zzd, zzduqVar);
    }

    public final ListenableFuture zzc(JSONObject jSONObject, String str, final zzffu zzffuVar, final zzffx zzffxVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbzt zzbztVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzla)).booleanValue()) {
            return zzgui.zza(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgui.zza(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzgui.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzex)).booleanValue()) {
            if (jSONObjectOptJSONObject.has((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzey))) {
                return zzgui.zza(null);
            }
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString("html");
        final com.google.android.gms.ads.internal.client.zzr zzrVarZzs = zzs(jSONObjectOptJSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0), jSONObjectOptJSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzgui.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            this.zzr.zze().putLong(zzduq.NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        final ListenableFuture listenableFutureZzj = zzgui.zzj(zzgui.zza(null), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzdoo
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzh(zzrVarZzs, zzffuVar, zzffxVar, zzbVar, zzbztVar, strOptString, strOptString2, obj);
            }
        }, zzcbv.zzf);
        return zzgui.zzj(listenableFutureZzj, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzdop
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) throws zzekz {
                if (((zzcgy) obj) != null) {
                    return listenableFutureZzj;
                }
                throw new zzekz(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzcbv.zzg);
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str, zzduq zzduqVar) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return zzgui.zza(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzr(jSONObjectOptJSONObject.optBoolean("require"), zzgui.zzk(zzm(jSONArrayOptJSONArray, false, true, zzduqVar), new zzglu() { // from class: com.google.android.gms.internal.ads.zzdoq
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzi(jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbzt zzbztVar) {
        if (!jSONObject.optBoolean("enable_omid")) {
            return zzgui.zza(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        if (jSONObjectOptJSONObject == null) {
            return zzgui.zza(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
        if (TextUtils.isEmpty(strOptString)) {
            return zzgui.zza(null);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            this.zzr.zze().putLong(zzduq.NATIVE_ASSETS_LOADING_OMID_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        return zzgui.zzj(zzgui.zza(null), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzdor
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzj(strOptString, zzbztVar, zzbVar, obj);
            }
        }, zzcbv.zzf);
    }

    public final ListenableFuture zzf(ListenableFuture listenableFuture) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcC)).booleanValue()) {
            this.zzr.zze().putLong(zzduq.NATIVE_ASSETS_LOADING_MEDIA_START.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        }
        zzcca zzccaVar = new zzcca();
        zzgui.zzr(listenableFuture, new zzdom(this, zzccaVar), zzcbv.zzf);
        return zzccaVar;
    }

    public final ListenableFuture zzg(JSONObject jSONObject, zzffu zzffuVar, zzffx zzffxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbzt zzbztVar) {
        ListenableFuture listenableFutureZza;
        JSONObject jSONObjectZzi = com.google.android.gms.ads.internal.util.zzbp.zzi(jSONObject, "html_containers", "instream");
        if (jSONObjectZzi != null) {
            return zzp(jSONObjectZzi, zzffuVar, zzffxVar, zzbVar, zzbztVar);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzgui.zza(null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("vast_xml");
        boolean z = false;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzkZ)).booleanValue() && jSONObjectOptJSONObject.has("html")) {
            z = true;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z) {
                listenableFutureZza = this.zzi.zza(jSONObjectOptJSONObject, zzbVar, zzbztVar);
            }
            return zzq(zzgui.zzi(listenableFutureZza, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzep)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Required field 'vast_xml' or 'html' is missing");
            return zzgui.zza(null);
        }
        listenableFutureZza = zzp(jSONObjectOptJSONObject, zzffuVar, zzffxVar, zzbVar, zzbztVar);
        return zzq(zzgui.zzi(listenableFutureZza, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzep)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }

    final /* synthetic */ ListenableFuture zzh(com.google.android.gms.ads.internal.client.zzr zzrVar, zzffu zzffuVar, zzffx zzffxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbzt zzbztVar, String str, String str2, Object obj) throws zzchn {
        zzdwl zzdwlVar;
        zzcgy zzcgyVarZza = this.zzj.zza(zzrVar, zzffuVar, zzffxVar);
        final zzcbz zzcbzVarZza = zzcbz.zza(zzcgyVarZza);
        zzdqw zzdqwVarZza = this.zzl.zza();
        zzciw zzciwVarZzP = zzcgyVarZza.zzP();
        zzbel zzbelVar = zzbeu.zzoB;
        zzciwVarZzP.zzZ(zzdqwVarZza, zzdqwVarZza, zzdqwVarZza, zzdqwVarZza, zzdqwVarZza, false, null, !((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(this.zza, null, null) : zzbVar, null, true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue() ? null : zzbztVar, this.zzo, this.zzn, this.zzm, null, zzdqwVarZza, null, null, null, null, null, null);
        zzcgyVarZza.zzab("/getNativeAdViewSignals", zzblw.zzs);
        zzcgyVarZza.zzab("/getNativeClickMeta", zzblw.zzt);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziu)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziw)).booleanValue() && (zzdwlVar = this.zzs) != null) {
                zzcgyVarZza.zzab("/onDeviceStorageEvent", new zzbmf(zzdwlVar));
            }
        }
        zzcgyVarZza.zzP().zzQ(true);
        zzcgyVarZza.zzP().zzG(new zzciu() { // from class: com.google.android.gms.internal.ads.zzdow
            @Override // com.google.android.gms.internal.ads.zzciu
            public final /* synthetic */ void zza(boolean z, int i, String str3, String str4) {
                zzcbz zzcbzVar = zzcbzVarZza;
                if (z) {
                    zzcbzVar.zzb();
                    return;
                }
                int length = String.valueOf(i).length();
                StringBuilder sb = new StringBuilder(length + 58 + String.valueOf(str3).length() + 15 + String.valueOf(str4).length());
                sb.append("Image Web View failed to load. Error code: ");
                sb.append(i);
                sb.append(", Description: ");
                sb.append(str3);
                sb.append(", Failing URL: ");
                sb.append(str4);
                zzcbzVar.zzd(new zzekz(1, sb.toString()));
            }
        });
        zzcgyVarZza.zzau(str, str2, null);
        return zzcbzVarZza;
    }

    final /* synthetic */ zzbhq zzi(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString("text");
        Integer numZzo = zzo(jSONObject, "bg_color");
        Integer numZzo2 = zzo(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzbhq(strOptString, list, numZzo, numZzo2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzh.zze, zOptBoolean);
    }

    final /* synthetic */ ListenableFuture zzj(String str, zzbzt zzbztVar, com.google.android.gms.ads.internal.zzb zzbVar, Object obj) throws zzchn {
        com.google.android.gms.ads.internal.zzt.zzd();
        Context context = this.zza;
        zzegj zzegjVar = this.zzp;
        zzcgy zzcgyVarZza = zzcho.zza(context, zzcji.zzb(), "native-omid", false, false, this.zzc, null, this.zzd, null, null, this.zze, this.zzf, null, null, zzegjVar, this.zzq, this.zzm);
        final zzcbz zzcbzVarZza = zzcbz.zza(zzcgyVarZza);
        zzcgyVarZza.zzP().zzG(new zzciu() { // from class: com.google.android.gms.internal.ads.zzdov
            @Override // com.google.android.gms.internal.ads.zzciu
            public final /* synthetic */ void zza(boolean z, int i, String str2, String str3) {
                zzcbzVarZza.zzb();
            }
        });
        zzcgyVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzoB)).booleanValue()) {
            if (zzbztVar != null) {
                zzcgyVarZza.zzP().zzj(zzbztVar);
            }
            zzcgyVarZza.zzP().zzi(zzbVar);
        }
        return zzcbzVarZza;
    }

    private final com.google.android.gms.ads.internal.client.zzr zzs(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return com.google.android.gms.ads.internal.client.zzr.zzb();
            }
            i = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzr(this.zza, new AdSize(i, i2));
    }
}
