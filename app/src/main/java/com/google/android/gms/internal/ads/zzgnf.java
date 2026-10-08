package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzgnf extends zzgnw implements zzgpz {
    protected zzgnf(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzgnw
    final Collection zza(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.ads.zzgnw
    final Collection zzb(Object obj, Collection collection) {
        return zzg(obj, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgnw
    /* bridge */ /* synthetic */ Collection zzc() {
        throw null;
    }
}
