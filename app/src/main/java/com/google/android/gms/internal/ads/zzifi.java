package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzifi implements zzifh, zzifb {
    private static final zzifi zza = new zzifi(null);
    private final Object zzb;

    private zzifi(Object obj) {
        this.zzb = obj;
    }

    public static zzifh zza(Object obj) {
        zzifp.zza(obj, "instance cannot be null");
        return new zzifi(obj);
    }

    public static zzifh zzc(Object obj) {
        return obj == null ? zza : new zzifi(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final Object zzb() {
        return this.zzb;
    }
}
