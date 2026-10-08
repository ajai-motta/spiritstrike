package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzxg implements Comparator {
    static final /* synthetic */ zzxg zza = new zzxg();

    private /* synthetic */ zzxg() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzxf) Collections.max((List) obj)).compareTo((zzxf) Collections.max((List) obj2));
    }
}
