package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdxc implements zzdwr {
    private final long zza;
    private final zzepb zzb;

    zzdxc(long j, Context context, zzdwv zzdwvVar, zzcjn zzcjnVar, String str) {
        this.zza = j;
        zzfea zzfeaVarZzn = zzcjnVar.zzn();
        zzfeaVarZzn.zzd(context);
        zzfeaVarZzn.zzb(new com.google.android.gms.ads.internal.client.zzr());
        zzfeaVarZzn.zzc(str);
        zzepb zzepbVarZza = zzfeaVarZzn.zza().zza();
        this.zzb = zzepbVarZza;
        zzepbVarZza.zzdW(new zzdxb(this, zzdwvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zze(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzb() {
        this.zzb.zzR(ObjectWrapper.wrap(null));
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzc() {
        this.zzb.zzc();
    }

    final /* synthetic */ long zzd() {
        return this.zza;
    }
}
