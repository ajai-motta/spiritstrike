package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfe extends zzff {
    private static final String zza = com.google.android.gms.internal.gtm.zza.STARTS_WITH.toString();

    public zzfe() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzff
    protected final boolean zzc(String str, String str2, Map map) {
        return str.startsWith(str2);
    }
}
