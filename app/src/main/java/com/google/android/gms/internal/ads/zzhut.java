package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhut implements zzhyh {
    static {
        int i = zzhvy.zzb;
        int i2 = zzhuv.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhyh
    public final /* synthetic */ Object zza(InputStream inputStream, zzhvy zzhvyVar) throws zzhxd {
        zzhzb zzhzbVarZzaU;
        zzhvn zzhvnVarZzF = zzhvn.zzF(inputStream, 4096);
        zzhxz zzhxzVar = (zzhxz) zzb(zzhvnVarZzF, zzhvyVar);
        zzhvnVarZzF.zzb(0);
        if (zzhxzVar == null || zzhxzVar.zzbi()) {
            return zzhxzVar;
        }
        if (zzhxzVar instanceof zzhur) {
            zzhzbVarZzaU = ((zzhur) zzhxzVar).zzaU();
        } else {
            if (zzhxzVar instanceof zzhus) {
                throw null;
            }
            zzhzbVarZzaU = new zzhzb(zzhxzVar);
        }
        throw zzhzbVarZzaU.zza();
    }
}
