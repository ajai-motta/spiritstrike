package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhtt extends zzhtv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhtt(zzhtu zzhtuVar) {
        super(zzhtuVar.zza);
        Objects.requireNonNull(zzhtuVar);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza().zzf;
    }
}
