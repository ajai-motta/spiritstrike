package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzamc implements Comparator {
    static final /* synthetic */ zzamc zza = new zzamc();

    private /* synthetic */ zzamc() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Long.compare(((zzalt) obj).zzb, ((zzalt) obj2).zzb);
    }
}
