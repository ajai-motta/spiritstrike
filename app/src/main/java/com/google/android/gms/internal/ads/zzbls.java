package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzbls implements zzblx {
    static final /* synthetic */ zzbls zza = new zzbls();

    private /* synthetic */ zzbls() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzcik zzcikVar = (zzcik) obj;
        zzblx zzblxVar = zzblw.zza;
        String str = (String) map.get("u");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("URL missing from httpTrack GMSG.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzf)).booleanValue() && str.isEmpty()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("URL is empty from httpTrack GMSG.");
        } else {
            zzcgp zzcgpVar = (zzcgp) zzcikVar;
            new com.google.android.gms.ads.internal.util.zzbt(zzcikVar.getContext(), ((zzcis) zzcikVar).zzs().afmaVersion, str, null, zzcgpVar.zzC() != null ? zzcgpVar.zzC().zzax : null).zzb();
        }
    }
}
