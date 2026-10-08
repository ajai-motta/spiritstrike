package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbph implements zzblx {
    final /* synthetic */ zzbow zza;
    final /* synthetic */ com.google.android.gms.ads.internal.util.zzbv zzb;
    final /* synthetic */ zzbqb zzc;

    zzbph(zzbqb zzbqbVar, zzaxa zzaxaVar, zzbow zzbowVar, com.google.android.gms.ads.internal.util.zzbv zzbvVar) {
        this.zza = zzbowVar;
        this.zzb = zzbvVar;
        Objects.requireNonNull(zzbqbVar);
        this.zzc = zzbqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        zzbqb zzbqbVar = this.zzc;
        synchronized (zzbqbVar.zzf()) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            com.google.android.gms.ads.internal.util.client.zzo.zzh("JS Engine is requesting an update");
            if (zzbqbVar.zzj() == 0) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Starting reload.");
                zzbqbVar.zzk(2);
                zzbqbVar.zza(null);
            }
            this.zza.zzn("/requestReload", (zzblx) this.zzb.zza());
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
