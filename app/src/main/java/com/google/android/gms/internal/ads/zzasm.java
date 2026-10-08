package com.google.android.gms.internal.ads;

import java.util.function.Supplier;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class zzasm implements Supplier {
    private final /* synthetic */ int zzc;
    public static final /* synthetic */ zzasm zzb = new zzasm(1);
    static final /* synthetic */ zzasm zza = new zzasm(0);

    private /* synthetic */ zzasm(int i) {
        this.zzc = i;
    }

    @Override // java.util.function.Supplier
    public final /* synthetic */ Object get() {
        return this.zzc != 0 ? zzatc.zza(null) : new zzasp();
    }
}
