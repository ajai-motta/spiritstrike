package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhtr extends zzhtv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhtr(zzhts zzhtsVar) {
        super(zzhtsVar.zza);
        Objects.requireNonNull(zzhtsVar);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return zza();
    }
}
