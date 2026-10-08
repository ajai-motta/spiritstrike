package com.google.android.gms.internal.ads;

import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevn implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzevn(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzevn zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzevn(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzevl zzb() {
        return new zzevl(((zzcjv) this.zza).zza(), (Intent) this.zzb.zzb());
    }
}
