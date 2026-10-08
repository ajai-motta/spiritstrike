package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzder implements zzifh {
    private final zzdeo zza;

    private zzder(zzdeo zzdeoVar) {
        this.zza = zzdeoVar;
    }

    public static zzder zza(zzdeo zzdeoVar) {
        return new zzder(zzdeoVar);
    }

    public static Set zzc(zzdeo zzdeoVar) {
        Set setEmptySet = Collections.emptySet();
        zzifp.zzb(setEmptySet);
        return setEmptySet;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
