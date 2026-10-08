package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfvi extends zzhwi implements zzhya {
    private zzfvi() {
        throw null;
    }

    /* synthetic */ zzfvi(byte[] bArr) {
        super(zzfvk.zzb);
    }

    public final zzfvi zza(String str) {
        str.getClass();
        zzbg();
        ((zzfvk) this.zza).zze().remove(str);
        return this;
    }

    public final Map zzb() {
        return Collections.unmodifiableMap(((zzfvk) this.zza).zzb());
    }

    public final zzfvi zzc(String str, zzfvg zzfvgVar) {
        str.getClass();
        zzfvgVar.getClass();
        zzbg();
        ((zzfvk) this.zza).zze().put(str, zzfvgVar);
        return this;
    }
}
