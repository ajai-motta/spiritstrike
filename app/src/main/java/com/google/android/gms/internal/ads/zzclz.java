package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclz implements zzffn {
    private final zzckz zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzclz(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    public final zzffo zza() {
        zzifp.zzc(this.zzb, Context.class);
        return new zzcma(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    public final /* synthetic */ zzffn zzb(String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    public final /* bridge */ /* synthetic */ zzffn zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
