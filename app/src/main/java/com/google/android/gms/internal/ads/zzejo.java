package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzejo implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzejo(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzejo zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzejo(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzejn zzb() {
        return new zzejn((Context) this.zza.zzb(), (zzdjd) this.zzb.zzb());
    }
}
