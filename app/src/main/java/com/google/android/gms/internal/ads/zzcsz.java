package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcsz implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcsz(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcsz zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcsz(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcsy zzb() {
        return new zzcsy(((zzcse) this.zza).zza(), (Executor) this.zzb.zzb());
    }
}
