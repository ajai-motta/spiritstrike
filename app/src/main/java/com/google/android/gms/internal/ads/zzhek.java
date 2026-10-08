package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhek {
    private HashMap zza = new HashMap();

    public final zzhel zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzhel zzhelVar = new zzhel(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzhelVar;
    }
}
