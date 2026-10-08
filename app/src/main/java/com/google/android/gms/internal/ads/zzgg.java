package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgg implements zzga {
    private final Context zza;
    private final zzga zzb;

    public zzgg(Context context) {
        zzgi zzgiVar = new zzgi();
        this.zza = context.getApplicationContext();
        this.zzb = zzgiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzga
    public final /* bridge */ /* synthetic */ zzgb zza() {
        return new zzgh(this.zza, this.zzb.zza());
    }
}
