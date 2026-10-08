package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzclt implements zzfea {
    private final zzckz zza;
    private Context zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzr zzd;

    /* synthetic */ zzclt(zzckz zzckzVar, byte[] bArr) {
        this.zza = zzckzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfea
    public final zzfeb zza() {
        zzifp.zzc(this.zzb, Context.class);
        zzifp.zzc(this.zzc, String.class);
        zzifp.zzc(this.zzd, com.google.android.gms.ads.internal.client.zzr.class);
        return new zzclu(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzfea
    public final /* bridge */ /* synthetic */ zzfea zzb(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzrVar.getClass();
        this.zzd = zzrVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfea
    public final /* bridge */ /* synthetic */ zzfea zzc(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfea
    public final /* bridge */ /* synthetic */ zzfea zzd(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
