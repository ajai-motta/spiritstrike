package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzzp implements Comparator {
    static final /* synthetic */ zzzp zza = new zzzp();

    private /* synthetic */ zzzp() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Float.compare(((zzzo) obj).zzc, ((zzzo) obj2).zzc);
    }
}
