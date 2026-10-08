package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgqu extends zzgnf {
    final transient zzgmv zza;

    zzgqu(Map map, zzgmv zzgmvVar) {
        super(map);
        this.zza = zzgmvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgnf, com.google.android.gms.internal.ads.zzgnw
    protected final /* bridge */ /* synthetic */ Collection zzc() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgnw, com.google.android.gms.internal.ads.zzgnz
    final Set zzh() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgnw, com.google.android.gms.internal.ads.zzgnz
    final Map zzl() {
        return zzm();
    }
}
