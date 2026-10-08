package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzajk implements zzaed {
    final /* synthetic */ zzajl zza;

    /* synthetic */ zzajk(zzajl zzajlVar, byte[] bArr) {
        Objects.requireNonNull(zzajlVar);
        this.zza = zzajlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        zzajl zzajlVar = this.zza;
        return zzajlVar.zzf().zzh(zzajlVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzajl zzajlVar = this.zza;
        long jZzd = zzajlVar.zzd() + BigInteger.valueOf(zzajlVar.zzf().zzi(j)).multiply(BigInteger.valueOf(zzajlVar.zze() - zzajlVar.zzd())).divide(BigInteger.valueOf(zzajlVar.zzg())).longValue();
        String str = zzep.zza;
        zzaee zzaeeVar = new zzaee(j, Math.max(zzajlVar.zzd(), Math.min(jZzd - 30000, zzajlVar.zze() - 1)));
        return new zzaeb(zzaeeVar, zzaeeVar);
    }
}
