package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuc {
    public static final /* synthetic */ int zza = 0;
    private static final zzuc zzb = new zzuc();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzuh zzc = new zztk();

    private zzuc() {
    }

    public static zzuc zza() {
        return zzb;
    }

    public final zzug zzb(Class cls) {
        zzsv.zzc(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzd;
        zzug zzugVarZza = (zzug) concurrentMap.get(cls);
        if (zzugVarZza == null) {
            zzugVarZza = this.zzc.zza(cls);
            zzsv.zzc(cls, "messageType");
            zzug zzugVar = (zzug) concurrentMap.putIfAbsent(cls, zzugVarZza);
            if (zzugVar != null) {
                return zzugVar;
            }
        }
        return zzugVarZza;
    }
}
