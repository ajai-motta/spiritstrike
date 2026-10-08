package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbn extends zzff {
    private static final String zza = com.google.android.gms.internal.gtm.zza.EQUALS.toString();

    public zzbn() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzff
    protected final boolean zzc(String str, String str2, Map map) {
        return str.equals(str2);
    }
}
