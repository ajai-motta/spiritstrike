package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdnd {
    private final zzdse zza;
    private final zzdqt zzb;
    private final zzcql zzc;
    private final zzdly zzd;

    public zzdnd(zzdse zzdseVar, zzdqt zzdqtVar, zzcql zzcqlVar, zzdly zzdlyVar) {
        this.zza = zzdseVar;
        this.zzb = zzdqtVar;
        this.zzc = zzcqlVar;
        this.zzd = zzdlyVar;
    }

    public final View zza() throws zzchn {
        zzcgy zzcgyVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzr.zzb(), null, null);
        zzcgyVarZza.zzE().setVisibility(8);
        zzcgyVarZza.zzab("/sendMessageToSdk", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdnc
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzb((zzcgy) obj, map);
            }
        });
        zzcgyVarZza.zzab("/adMuted", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdmx
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzc((zzcgy) obj, map);
            }
        });
        WeakReference weakReference = new WeakReference(zzcgyVarZza);
        zzblx zzblxVar = new zzblx() { // from class: com.google.android.gms.internal.ads.zzdmy
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, final Map map) {
                zzcgy zzcgyVar = (zzcgy) obj;
                zzciw zzciwVarZzP = zzcgyVar.zzP();
                final zzdnd zzdndVar = this.zza;
                zzciwVarZzP.zzG(new zzciu() { // from class: com.google.android.gms.internal.ads.zzdnb
                    @Override // com.google.android.gms.internal.ads.zzciu
                    public final /* synthetic */ void zza(boolean z, int i, String str, String str2) {
                        zzdndVar.zzf(map, z, i, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcgyVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcgyVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        };
        zzdqt zzdqtVar = this.zzb;
        zzdqtVar.zzh(weakReference, "/loadHtml", zzblxVar);
        zzdqtVar.zzh(new WeakReference(zzcgyVarZza), "/showOverlay", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdmz
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzd((zzcgy) obj, map);
            }
        });
        zzdqtVar.zzh(new WeakReference(zzcgyVarZza), "/hideOverlay", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdna
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zze((zzcgy) obj, map);
            }
        });
        return zzcgyVarZza.zzE();
    }

    final /* synthetic */ void zzb(zzcgy zzcgyVar, Map map) {
        this.zzb.zzf("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(zzcgy zzcgyVar, Map map) {
        this.zzd.zzt();
    }

    final /* synthetic */ void zzd(zzcgy zzcgyVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Showing native ads overlay.");
        zzcgyVar.zzE().setVisibility(0);
        this.zzc.zze(true);
    }

    final /* synthetic */ void zze(zzcgy zzcgyVar, Map map) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("Hiding native ads overlay.");
        zzcgyVar.zzE().setVisibility(8);
        this.zzc.zze(false);
    }

    final /* synthetic */ void zzf(Map map, boolean z, int i, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzf("sendMessageToNativeJs", map2);
    }
}
