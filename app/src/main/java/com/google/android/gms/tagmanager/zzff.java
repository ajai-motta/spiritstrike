package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzff extends zzdt {
    public zzff(String str) {
        super(str);
    }

    protected abstract boolean zzc(String str, String str2, Map map);

    @Override // com.google.android.gms.tagmanager.zzdt
    protected final boolean zzd(com.google.android.gms.internal.gtm.zzap zzapVar, com.google.android.gms.internal.gtm.zzap zzapVar2, Map map) {
        String strZzm = zzfp.zzm(zzfp.zzk(zzapVar));
        String strZzm2 = zzfp.zzm(zzfp.zzk(zzapVar2));
        if (strZzm == zzfp.zzl() || strZzm2 == zzfp.zzl()) {
            return false;
        }
        return zzc(strZzm, strZzm2, map);
    }
}
