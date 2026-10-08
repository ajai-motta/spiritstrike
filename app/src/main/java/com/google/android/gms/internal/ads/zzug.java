package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzug {
    private final Map zza = new HashMap();
    private final Map zzb = new HashMap();
    private zzga zzc;

    public zzug(zzadg zzadgVar, zzakg zzakgVar) {
    }

    public final void zza(zzga zzgaVar) {
        if (zzgaVar != this.zzc) {
            this.zzc = zzgaVar;
            this.zza.clear();
            this.zzb.clear();
        }
    }
}
