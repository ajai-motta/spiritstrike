package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcld implements zzfax {
    private final zzckz zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcld(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final zzfay zza() {
        zzifp.zzc(this.zzb, Context.class);
        zzifp.zzc(this.zzc, String.class);
        return new zzcle(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final /* bridge */ /* synthetic */ zzfax zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfax
    public final /* bridge */ /* synthetic */ zzfax zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
