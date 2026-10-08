package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzdm extends zzdt {
    public zzdm(String str) {
        super(str);
    }

    protected abstract boolean zzc(zzfo zzfoVar, zzfo zzfoVar2, Map map);

    @Override // com.google.android.gms.tagmanager.zzdt
    protected final boolean zzd(com.google.android.gms.internal.gtm.zzap zzapVar, com.google.android.gms.internal.gtm.zzap zzapVar2, Map map) {
        zzfo zzfoVarZzd = zzfp.zzd(zzfp.zzk(zzapVar));
        zzfo zzfoVarZzd2 = zzfp.zzd(zzfp.zzk(zzapVar2));
        if (zzfoVarZzd == zzfp.zzc() || zzfoVarZzd2 == zzfp.zzc()) {
            return false;
        }
        return zzc(zzfoVarZzd, zzfoVarZzd2, map);
    }
}
