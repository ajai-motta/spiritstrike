package com.google.android.gms.internal.measurement;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridge;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzx extends zzai {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzx(zzy zzyVar, String str) {
        super(MobileAdsBridge.versionMethodName);
        Objects.requireNonNull(zzyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        return new zzah(Double.valueOf(0.0d));
    }
}
