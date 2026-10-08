package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzxi implements Comparator {
    static final /* synthetic */ zzxi zza = new zzxi();

    private /* synthetic */ zzxi() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzxy) ((List) obj).get(0)).compareTo((zzxy) ((List) obj2).get(0));
    }
}
