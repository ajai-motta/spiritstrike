package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdnq implements zzczi {
    private final zzdlq zza;
    private final zzdlv zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdnq(zzdlq zzdlqVar, zzdlv zzdlvVar, Executor executor, Executor executor2) {
        this.zza = zzdlqVar;
        this.zzb = zzdlvVar;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final void zza(final zzcgy zzcgyVar) {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdnp
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzcgyVar.zze("onSdkImpression", new ArrayMap());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzczi
    public final void zzdw() {
        if (this.zzb.zzd()) {
            zzdlq zzdlqVar = this.zza;
            zzehf zzehfVarZzZ = zzdlqVar.zzZ();
            if (zzehfVarZzZ == null && zzdlqVar.zzX() != null && ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfW)).booleanValue()) {
                ListenableFuture listenableFutureZzX = zzdlqVar.zzX();
                zzcca zzccaVarZzY = zzdlqVar.zzY();
                if (listenableFutureZzX == null || zzccaVarZzY == null) {
                    return;
                }
                zzgui.zzr(zzgui.zzq(listenableFutureZzX, zzccaVarZzY), new zzdno(this), this.zzd);
                return;
            }
            if (zzehfVarZzZ != null) {
                zzcgy zzcgyVarZzW = zzdlqVar.zzW();
                zzcgy zzcgyVarZzT = zzdlqVar.zzT();
                if (zzcgyVarZzW == null) {
                    zzcgyVarZzW = zzcgyVarZzT == null ? null : zzcgyVarZzT;
                }
                if (zzcgyVarZzW != null) {
                    zza(zzcgyVarZzW);
                }
            }
        }
    }
}
