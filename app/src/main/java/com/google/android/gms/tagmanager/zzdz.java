package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdz extends zzff {
    private static final String zza = com.google.android.gms.internal.gtm.zza.REGEX.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.IGNORE_CASE.toString();

    public zzdz() {
        super(zza);
    }

    @Override // com.google.android.gms.tagmanager.zzff
    protected final boolean zzc(String str, String str2, Map map) {
        try {
            return Pattern.compile(str2, true != zzfp.zzf(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(zzb))).booleanValue() ? 64 : 66).matcher(str).find();
        } catch (PatternSyntaxException unused) {
            return false;
        }
    }
}
