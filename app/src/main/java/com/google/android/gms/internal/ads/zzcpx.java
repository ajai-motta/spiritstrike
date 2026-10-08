package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcpx implements zzbqi {
    private final Context zza;
    private final zzbar zzb;
    private final PowerManager zzc;

    public zzcpx(Context context, zzbar zzbarVar) {
        this.zza = context;
        this.zzb = zzbarVar;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzb(zzcqa zzcqaVar) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzbat zzbatVar = zzcqaVar.zzf;
        if (zzbatVar == null) {
            jSONObject = new JSONObject();
        } else {
            zzbar zzbarVar = this.zzb;
            if (zzbarVar.zzc() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzbatVar.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObjectPut = jSONObject3.put("afmaVersion", zzbarVar.zzb()).put("activeViewJSON", zzbarVar.zzc()).put("timestamp", zzcqaVar.zzd).put("adFormat", zzbarVar.zza()).put("hashCode", zzbarVar.zzd()).put("isMraid", false);
            boolean z2 = zzcqaVar.zzc;
            JSONObject jSONObjectPut2 = jSONObjectPut.put("isStopped", false).put("isPaused", zzcqaVar.zzb).put("isNative", zzbarVar.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", com.google.android.gms.ads.internal.zzt.zzi().zzd()).put("appVolume", com.google.android.gms.ads.internal.zzt.zzi().zzb());
            Context context = this.zza;
            jSONObjectPut2.put("deviceVolume", com.google.android.gms.ads.internal.util.zzaa.zze(context.getApplicationContext()));
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            JSONObject jSONObjectPut3 = jSONObject3.put("windowVisibility", zzbatVar.zzb).put("isAttachedToWindow", z);
            JSONObject jSONObject4 = new JSONObject();
            Rect rect = zzbatVar.zzc;
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("viewBox", jSONObject4.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect.top).put("bottom", rect.bottom).put("left", rect.left).put(TtmlNode.RIGHT, rect.right));
            JSONObject jSONObject5 = new JSONObject();
            Rect rect2 = zzbatVar.zzd;
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("adBox", jSONObject5.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put(TtmlNode.RIGHT, rect2.right));
            JSONObject jSONObject6 = new JSONObject();
            Rect rect3 = zzbatVar.zze;
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("globalVisibleBox", jSONObject6.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect3.top).put("bottom", rect3.bottom).put("left", rect3.left).put(TtmlNode.RIGHT, rect3.right)).put("globalVisibleBoxVisible", zzbatVar.zzf);
            JSONObject jSONObject7 = new JSONObject();
            Rect rect4 = zzbatVar.zzg;
            JSONObject jSONObjectPut7 = jSONObjectPut6.put("localVisibleBox", jSONObject7.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect4.top).put("bottom", rect4.bottom).put("left", rect4.left).put(TtmlNode.RIGHT, rect4.right)).put("localVisibleBoxVisible", zzbatVar.zzh);
            JSONObject jSONObject8 = new JSONObject();
            Rect rect5 = zzbatVar.zzi;
            jSONObjectPut7.put("hitBox", jSONObject8.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect5.top).put("bottom", rect5.bottom).put("left", rect5.left).put(TtmlNode.RIGHT, rect5.right)).put("screenDensity", displayMetrics.density);
            jSONObject3.put("isVisible", zzcqaVar.zza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbH)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzbatVar.zzk;
                if (list != null) {
                    for (Rect rect6 : list) {
                        jSONArray2.put(new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, rect6.top).put("bottom", rect6.bottom).put("left", rect6.left).put(TtmlNode.RIGHT, rect6.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcqaVar.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
