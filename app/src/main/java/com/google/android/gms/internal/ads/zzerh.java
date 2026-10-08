package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzerh implements zzeya {
    private final Executor zza;
    private final zzcbj zzb;

    zzerh(Executor executor, zzcbj zzcbjVar) {
        this.zza = executor;
        this.zzb = zzcbjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzds)).booleanValue()) {
            return zzgui.zza(new zzeri(null));
        }
        zzcbj zzcbjVar = this.zzb;
        return zzgui.zzk(zzcbjVar.zzq(), zzerg.zza, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 10;
    }
}
