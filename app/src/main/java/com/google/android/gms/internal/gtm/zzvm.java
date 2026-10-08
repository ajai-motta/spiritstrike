package com.google.android.gms.internal.gtm;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzvm implements zzvf {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzuw zzd;
    private final int zze;

    private zzvm() {
        this("", true, 2, Level.ALL, false, zzvp.zzb, zzvp.zzc);
    }

    private zzvm(String str, boolean z, int i, Level level, boolean z2, Set set, zzuw zzuwVar) {
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        this.zzc = set;
        this.zzd = zzuwVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzvf
    public final zzum zza(String str) {
        return new zzvp(this.zza, str, true, 2, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzvm zzb(boolean z) {
        Set set = this.zzc;
        zzuw zzuwVar = this.zzd;
        return new zzvm(this.zza, true, 2, Level.OFF, false, set, zzuwVar);
    }
}
