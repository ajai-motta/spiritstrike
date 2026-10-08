package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeaq implements zzifh {
    private final zzifq zza;

    private zzeaq(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzeaq zzc(zzifq zzifqVar) {
        return new zzeaq(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String packageName = ((zzcjv) this.zza).zza().getPackageName();
        zzifp.zzb(packageName);
        return packageName;
    }
}
