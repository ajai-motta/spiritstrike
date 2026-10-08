package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeaz implements zzguf {
    final /* synthetic */ zzebc zza;

    zzeaz(zzebc zzebcVar) {
        Objects.requireNonNull(zzebcVar);
        this.zza = zzebcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue()) {
            Matcher matcher = zzebc.zzh.matcher(th.getMessage());
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                zzebc zzebcVar = this.zza;
                zzebcVar.zzc().zzc(Integer.parseInt(strGroup));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgf zzfgfVar = (zzfgf) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue()) {
            zzebc zzebcVar = this.zza;
            zzffx zzffxVar = zzfgfVar.zzb.zzb;
            zzebcVar.zzc().zzc(zzffxVar.zzf);
            zzebcVar.zzc().zze(zzffxVar.zzg);
        }
    }
}
