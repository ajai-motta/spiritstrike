package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfak implements zzifh {
    private final zzfaf zza;

    private zzfak(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfak zzc(zzfaf zzfafVar) {
        return new zzfak(zzfafVar);
    }

    public static String zzd(zzfaf zzfafVar) {
        String strZze = zzfafVar.zze();
        zzifp.zzb(strZze);
        return strZze;
    }

    public final String zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
