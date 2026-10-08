package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcjw implements zzifh {
    private final zzcjp zza;

    private zzcjw(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzcjw zzc(zzcjp zzcjpVar) {
        return new zzcjw(zzcjpVar);
    }

    public static WeakReference zzd(zzcjp zzcjpVar) {
        WeakReference weakReferenceZzc = zzcjpVar.zzc();
        zzifp.zzb(weakReferenceZzc);
        return weakReferenceZzc;
    }

    public final WeakReference zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
