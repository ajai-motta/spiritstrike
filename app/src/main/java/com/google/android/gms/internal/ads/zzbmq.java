package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.internal.NativeProtocol;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbmq implements zzblx {
    private final zzbmp zza;

    public zzbmq(zzbmp zzbmpVar) {
        this.zza = zzbmpVar;
    }

    public static void zzb(zzcgy zzcgyVar, zzbmp zzbmpVar) {
        zzcgyVar.zzab("/reward", new zzbmq(zzbmpVar));
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zza.zza();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zza.zzc();
                    return;
                }
                return;
            }
        }
        zzbyh zzbyhVar = null;
        try {
            int i = Integer.parseInt((String) map.get(AppLovinEventParameters.REVENUE_AMOUNT));
            String str2 = (String) map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzbyhVar = new zzbyh(str2, i);
            }
        } catch (NumberFormatException e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to parse reward amount.", e);
        }
        this.zza.zzb(zzbyhVar);
    }
}
