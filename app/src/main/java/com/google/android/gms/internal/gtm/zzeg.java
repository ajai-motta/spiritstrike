package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeg {
    private final Object zza;
    private final Object zzb = new Object();

    private zzeg(Object obj, Object obj2, zzef zzefVar) {
        this.zza = obj;
    }

    static zzeg zza(Object obj, Object obj2, zzef zzefVar) {
        return new zzeg(obj, obj2, zzefVar);
    }

    public final Object zzb() {
        synchronized (this.zzb) {
        }
        return this.zza;
    }
}
