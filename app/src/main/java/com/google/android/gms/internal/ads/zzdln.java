package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdln {
    private zzbif zza;

    public zzdln(zzdky zzdkyVar) {
        this.zza = zzdkyVar;
    }

    public final synchronized zzbif zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbif zzbifVar) {
        this.zza = zzbifVar;
    }
}
