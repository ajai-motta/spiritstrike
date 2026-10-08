package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbr extends zzdm {
    private static final String zza = com.google.android.gms.internal.gtm.zza.GREATER_EQUALS.toString();

    public zzbr() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzdm
    protected final boolean zzc(zzfo zzfoVar, zzfo zzfoVar2, Map map) {
        return zzfoVar.compareTo(zzfoVar2) >= 0;
    }
}
