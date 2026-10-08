package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzxh implements Comparator {
    static final /* synthetic */ zzxh zza = new zzxh();

    private /* synthetic */ zzxh() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzxq) ((List) obj).get(0)).compareTo((zzxq) ((List) obj2).get(0));
    }
}
