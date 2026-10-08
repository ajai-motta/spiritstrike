package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdfb implements zzifh {
    private final zzdeo zza;

    private zzdfb(zzdeo zzdeoVar) {
        this.zza = zzdeoVar;
    }

    public static zzdfb zza(zzdeo zzdeoVar) {
        return new zzdfb(zzdeoVar);
    }

    public static Set zzc(zzdeo zzdeoVar) {
        return zzdeoVar.zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzm();
    }
}
