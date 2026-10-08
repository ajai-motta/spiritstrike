package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzejy implements zzehq {
    private final Context zza;
    private final zzdjz zzb;
    private final Executor zzc;

    public zzejy(Context context, zzdjz zzdjzVar, Executor executor) {
        this.zza = context;
        this.zzb = zzdjzVar;
        this.zzc = executor;
    }

    private static final boolean zzc(zzfgf zzfgfVar, int i) {
        return zzfgfVar.zza.zza.zzh.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        zzfhl zzfhlVar = (zzfhl) zzehnVar.zzb;
        zzfgn zzfgnVar = zzfgfVar.zza.zza;
        String string = zzffuVar.zzv.toString();
        String strZzm = com.google.android.gms.ads.internal.util.zzbp.zzm(zzffuVar.zzs);
        zzfhlVar.zzo(this.zza, zzfgnVar.zzd, string, strZzm, (zzbrp) zzehnVar.zzc, zzfgnVar.zzj, zzfgnVar.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu, zzekz {
        zzdlq zzdlqVarZzag;
        zzfhl zzfhlVar = (zzfhl) zzehnVar.zzb;
        zzbru zzbruVarZzD = zzfhlVar.zzD();
        zzbrv zzbrvVarZzE = zzfhlVar.zzE();
        zzbry zzbryVarZzu = zzfhlVar.zzu();
        if (zzbryVarZzu != null && zzc(zzfgfVar, 6)) {
            zzdlqVarZzag = zzdlq.zzaf(zzbryVarZzu);
        } else if (zzbruVarZzD != null && zzc(zzfgfVar, 6)) {
            zzdlqVarZzag = zzdlq.zzai(zzbruVarZzD);
        } else if (zzbruVarZzD != null && zzc(zzfgfVar, 2)) {
            zzdlqVarZzag = zzdlq.zzah(zzbruVarZzD);
        } else if (zzbrvVarZzE != null && zzc(zzfgfVar, 6)) {
            zzdlqVarZzag = zzdlq.zzaj(zzbrvVarZzE);
        } else {
            if (zzbrvVarZzE == null || !zzc(zzfgfVar, 1)) {
                throw new zzekz(1, "No native ad mappers");
            }
            zzdlqVarZzag = zzdlq.zzag(zzbrvVarZzE);
        }
        if (zzdlqVarZzag != null) {
            zzfgn zzfgnVar = zzfgfVar.zza.zza;
            if (zzfgnVar.zzh.contains(Integer.toString(zzdlqVarZzag.zzx()))) {
                zzdls zzdlsVarZze = this.zzb.zze(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzdmb(zzdlqVarZzag), new zzdnu(zzbrvVarZzE, zzbruVarZzD, zzbryVarZzu));
                ((zzeiz) zzehnVar.zzc).zzc(zzdlsVarZze.zzf());
                zzdlsVarZze.zza().zzq(new zzcou(zzfhlVar), this.zzc);
                return zzdlsVarZze.zzh();
            }
        }
        throw new zzekz(1, "No corresponding native ad listener");
    }
}
