package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzalp implements zzaki {
    private final zzeg zza = new zzeg();
    private final zzeg zzb = new zzeg();
    private final zzalo zzc;
    private Inflater zzd;

    public zzalp(List list) {
        zzalo zzaloVar = new zzalo();
        this.zzc = zzaloVar;
        zzaloVar.zza(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i, int i2, zzakh zzakhVar, zzdg zzdgVar) {
        zzeg zzegVar = this.zza;
        zzegVar.zzb(bArr, i2 + i);
        zzegVar.zzh(i);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzeg zzegVar2 = this.zzb;
        if (zzep.zzM(zzegVar, zzegVar2, this.zzd)) {
            zzegVar.zzb(zzegVar2.zzi(), zzegVar2.zze());
        }
        zzalo zzaloVar = this.zzc;
        zzaloVar.zzd();
        int iZzd = zzegVar.zzd();
        zzcm zzcmVarZzc = null;
        if (iZzd >= 2 && zzegVar.zzt() == iZzd) {
            zzaloVar.zzb(zzegVar);
            zzcmVarZzc = zzaloVar.zzc(zzegVar);
        }
        zzdgVar.zza(new zzaka(zzcmVarZzc != null ? zzgpe.zzj(zzcmVarZzc) : zzgpe.zzi(), C.TIME_UNSET, 5000000L));
    }
}
