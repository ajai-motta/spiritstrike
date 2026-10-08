package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbkv implements zzblx {
    zzbkv() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgy zzcgyVar = (zzcgy) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzgko zzgkoVarZzl = zzgkp.zzl();
        zzgkoVarZzl.zzb((String) map.get("appId"));
        zzgkoVarZzl.zzg(zzcgyVar.getWidth());
        zzgkoVarZzl.zza(zzcgyVar.zzE().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzgkoVarZzl.zzc(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzgkoVarZzl.zzc(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzgkoVarZzl.zzd(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzgkoVarZzl.zzd(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzgkoVarZzl.zzh((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzt().zzc(zzcgyVar, zzgkoVarZzl.zzi());
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
