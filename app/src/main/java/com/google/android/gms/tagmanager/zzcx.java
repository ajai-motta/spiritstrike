package com.google.android.gms.tagmanager;

import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcx extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.LANGUAGE.toString();

    public zzcx() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return zzfp.zza();
        }
        String language = locale.getLanguage();
        return language == null ? zzfp.zza() : zzfp.zzb(language.toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return false;
    }
}
