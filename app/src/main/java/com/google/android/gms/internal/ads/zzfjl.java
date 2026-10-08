package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfjl implements zzifh {
    public static zzfjl zza() {
        return zzfjk.zza;
    }

    public static zzgus zzc() {
        zzgus zzgusVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgp)).booleanValue()) {
            zzgusVar = zzcbv.zzc;
        } else {
            zzgusVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgo)).booleanValue() ? zzcbv.zza : zzcbv.zzf;
        }
        zzifp.zzb(zzgusVar);
        return zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
