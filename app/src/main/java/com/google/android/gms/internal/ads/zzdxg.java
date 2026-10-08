package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdxg implements zzdwr {
    private final long zza;
    private final zzdwv zzb;
    private final zzffl zzc;

    zzdxg(long j, Context context, zzdwv zzdwvVar, zzcjn zzcjnVar, String str) {
        this.zza = j;
        this.zzb = zzdwvVar;
        zzffn zzffnVarZzq = zzcjnVar.zzq();
        zzffnVarZzq.zzc(context);
        zzffnVarZzq.zzb(str);
        this.zzc = zzffnVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.zzc.zzc(zzmVar, new zzdxe(this));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzb() {
        try {
            zzffl zzfflVar = this.zzc;
            zzfflVar.zze(new zzdxf(this));
            zzfflVar.zzb(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwr
    public final void zzc() {
    }

    final /* synthetic */ long zzd() {
        return this.zza;
    }

    final /* synthetic */ zzdwv zze() {
        return this.zzb;
    }
}
