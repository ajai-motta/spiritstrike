package com.google.android.gms.internal.gtm;

import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvl extends zzvq {
    private static final zzvl zza = new zzvl(zzvq.zze());
    private final AtomicReference zzb;

    zzvl(zzvq zzvqVar) {
        this.zzb = new AtomicReference(zzvqVar);
    }

    public static final zzvl zzb() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzvq
    public final zzuo zza() {
        return ((zzvq) this.zzb.get()).zza();
    }

    @Override // com.google.android.gms.internal.gtm.zzvq
    public final zzwc zzc() {
        return ((zzvq) this.zzb.get()).zzc();
    }

    @Override // com.google.android.gms.internal.gtm.zzvq
    public final boolean zzd(String str, Level level, boolean z) {
        ((zzvq) this.zzb.get()).zzd(str, level, z);
        return false;
    }
}
