package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzerq implements zzeya {
    final Context zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzcve zze;
    private final zzfhv zzf;
    private final zzfgn zzg;
    private final com.google.android.gms.ads.internal.util.zzg zzh = com.google.android.gms.ads.internal.zzt.zzh().zzo();
    private final zzdvc zzi;
    private final zzcvs zzj;

    public zzerq(Context context, String str, String str2, zzcve zzcveVar, zzfhv zzfhvVar, zzfgn zzfgnVar, zzdvc zzdvcVar, zzcvs zzcvsVar, long j) {
        this.zza = context;
        this.zzb = str;
        this.zzc = str2;
        this.zze = zzcveVar;
        this.zzf = zzfhvVar;
        this.zzg = zzfgnVar;
        this.zzi = zzdvcVar;
        this.zzj = zzcvsVar;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        Bundle bundle = new Bundle();
        zzdvc zzdvcVar = this.zzi;
        Map mapZzc = zzdvcVar.zzc();
        String str = this.zzb;
        mapZzc.put("seq_num", str);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue()) {
            zzdvcVar.zzd("tsacc", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzd));
            com.google.android.gms.ads.internal.zzt.zzc();
            zzdvcVar.zzd(DownloadService.KEY_FOREGROUND, true != com.google.android.gms.ads.internal.util.zzs.zzK(this.zza) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        zzcve zzcveVar = this.zze;
        zzfgn zzfgnVar = this.zzg;
        zzcveVar.zzi(zzfgnVar.zzd);
        bundle.putAll(this.zzf.zzc());
        return zzgui.zza(new zzerr(this.zza, bundle, str, this.zzc, this.zzh, zzfgnVar.zzg, this.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 12;
    }
}
