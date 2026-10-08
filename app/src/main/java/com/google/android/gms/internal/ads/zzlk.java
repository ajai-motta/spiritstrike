package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzlk extends zzui {
    private final zzbe zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlk(zzll zzllVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzllVar);
        this.zzc = new zzbe();
    }

    @Override // com.google.android.gms.internal.ads.zzui, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i, zzbd zzbdVar, boolean z) {
        zzbf zzbfVar = this.zzb;
        zzbd zzbdVarZzd = zzbfVar.zzd(i, zzbdVar, z);
        if (zzbfVar.zzb(zzbdVarZzd.zzc, this.zzc, 0L).zzb()) {
            Object obj = zzbdVar.zza;
            Object obj2 = zzbdVar.zzb;
            int i2 = zzbdVar.zzc;
            long j = zzbdVar.zzd;
            long j2 = zzbdVar.zze;
            zzbdVarZzd.zza(obj, obj2, i2, j, 0L, zzc.zza, true);
        } else {
            zzbdVarZzd.zzf = true;
        }
        return zzbdVarZzd;
    }
}
