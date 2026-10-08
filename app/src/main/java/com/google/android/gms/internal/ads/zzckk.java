package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzckk implements zzifh {
    private final zzcjp zza;

    private zzckk(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzckk zzc(zzcjp zzcjpVar) {
        return new zzckk(zzcjpVar);
    }

    public static VersionInfoParcel zzd(zzcjp zzcjpVar) {
        VersionInfoParcel versionInfoParcelZzd = zzcjpVar.zzd();
        zzifp.zzb(versionInfoParcelZzd);
        return versionInfoParcelZzd;
    }

    public final VersionInfoParcel zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
