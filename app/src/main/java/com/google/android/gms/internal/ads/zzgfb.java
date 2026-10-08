package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgfb implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzgfb(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzgfb zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzgfb(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbaa zzbaaVarZzb = zzfsp.zzb((Context) this.zza.zzb(), (zzfrs) this.zzb.zzb());
        zzifp.zzb(zzbaaVarZzb);
        return zzbaaVarZzb;
    }
}
