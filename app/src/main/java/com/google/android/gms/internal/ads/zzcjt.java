package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcjt implements zzifh {
    private final zzcjp zza;

    private zzcjt(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzcjt zzc(zzcjp zzcjpVar) {
        return new zzcjt(zzcjpVar);
    }

    public static Context zzd(zzcjp zzcjpVar) {
        Context contextZzb = zzcjpVar.zzb();
        zzifp.zzb(contextZzb);
        return contextZzb;
    }

    public final Context zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
