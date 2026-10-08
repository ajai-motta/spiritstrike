package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzell implements zzehq {
    private final Context zza;
    private final zzdrn zzb;

    public zzell(Context context, zzdrn zzdrnVar) {
        this.zza = context;
        this.zzb = zzdrnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final void zza(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu {
        try {
            zzbti zzbtiVar = (zzbti) zzehnVar.zzb;
            zzbtiVar.zzo(zzffuVar.zzZ);
            zzfgn zzfgnVar = zzfgfVar.zza.zza;
            if (zzfgnVar.zzp.zza == 3) {
                zzbtiVar.zzp(zzffuVar.zzU, zzffuVar.zzv.toString(), zzfgnVar.zzd, ObjectWrapper.wrap(this.zza), new zzelk(this, zzehnVar, null), (zzbrp) zzehnVar.zzc);
            } else {
                zzbtiVar.zzl(zzffuVar.zzU, zzffuVar.zzv.toString(), zzfgnVar.zzd, ObjectWrapper.wrap(this.zza), new zzelk(this, zzehnVar, null), (zzbrp) zzehnVar.zzc);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzehq
    public final /* bridge */ /* synthetic */ Object zzb(zzfgf zzfgfVar, zzffu zzffuVar, zzehn zzehnVar) throws zzfgu, zzekz {
        zzeji zzejiVar = new zzeji(zzffuVar, (zzbti) zzehnVar.zzb, AdFormat.REWARDED);
        zzdrj zzdrjVarZzf = this.zzb.zzf(new zzcue(zzfgfVar, zzffuVar, zzehnVar.zza), new zzdrk(zzejiVar));
        zzejiVar.zzc(zzdrjVarZzf.zzd());
        ((zzeiz) zzehnVar.zzc).zzc(zzdrjVarZzf.zzn());
        return zzdrjVarZzf.zzh();
    }
}
