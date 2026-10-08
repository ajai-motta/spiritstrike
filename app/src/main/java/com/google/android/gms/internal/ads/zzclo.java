package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclo implements zzdwz {
    private final zzckz zza;
    private Context zzb;
    private zzbmx zzc;

    /* synthetic */ zzclo(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwz
    public final zzdxa zza() {
        zzifp.zzc(this.zzb, Context.class);
        zzifp.zzc(this.zzc, zzbmx.class);
        return new zzclp(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzdwz
    public final /* bridge */ /* synthetic */ zzdwz zzb(zzbmx zzbmxVar) {
        zzbmxVar.getClass();
        this.zzc = zzbmxVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwz
    public final /* bridge */ /* synthetic */ zzdwz zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
