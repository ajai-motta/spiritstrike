package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwc {
    private static final Comparator zza = new zzvv();
    private static final zzwc zzb = new zzwc(new zzwa(Collections.emptyList()));
    private final zzwa zzc;

    private zzwc(zzwa zzwaVar) {
        this.zzc = zzwaVar;
    }

    public static zzwc zza() {
        return zzb;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzwc) && ((zzwc) obj).zzc.equals(this.zzc);
    }

    public final int hashCode() {
        return ~this.zzc.hashCode();
    }

    public final String toString() {
        return this.zzc.toString();
    }
}
