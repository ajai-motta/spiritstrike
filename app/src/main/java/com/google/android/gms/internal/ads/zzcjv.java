package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcjv implements zzifh {
    private final zzcjp zza;

    private zzcjv(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzcjv zzc(zzcjp zzcjpVar) {
        return new zzcjv(zzcjpVar);
    }

    public static Context zzd(zzcjp zzcjpVar) {
        Context contextZza = zzcjpVar.zza();
        zzifp.zzb(contextZza);
        return contextZza;
    }

    public final Context zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
