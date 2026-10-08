package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdvi {
    private final zzdvn zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdvi(zzdvn zzdvnVar, Executor executor) {
        this.zza = zzdvnVar;
        this.zzc = zzdvnVar.zza();
        this.zzb = executor;
    }

    public final zzdvh zza() {
        zzdvh zzdvhVar = new zzdvh(this);
        zzdvhVar.zzl();
        return zzdvhVar;
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmE)).booleanValue()) {
            zzdvh zzdvhVarZza = zza();
            zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "pecr");
            zzdvhVarZza.zzd();
        }
    }

    final /* synthetic */ zzdvn zzc() {
        return this.zza;
    }

    final /* synthetic */ Executor zzd() {
        return this.zzb;
    }

    final /* synthetic */ Map zze() {
        return this.zzc;
    }
}
