package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdy extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.REGEX_GROUP.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ARG1.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.IGNORE_CASE.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.GROUP.toString();

    public zzdy() {
        super(zza, zzb, zzc);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        Long lZzj;
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        if (zzapVar == null || zzapVar == zzfp.zza() || zzapVar2 == null || zzapVar2 == zzfp.zza()) {
            return zzfp.zza();
        }
        int iIntValue = 1;
        int i = true != zzfp.zzf(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(zzd))).booleanValue() ? 64 : 66;
        com.google.android.gms.internal.gtm.zzap zzapVar3 = (com.google.android.gms.internal.gtm.zzap) map.get(zze);
        if (zzapVar3 == null || ((lZzj = zzfp.zzj(zzfp.zzk(zzapVar3))) != zzfp.zzi() && (iIntValue = lZzj.intValue()) >= 0)) {
            try {
                Matcher matcher = Pattern.compile(zzfp.zzm(zzfp.zzk(zzapVar2)), i).matcher(zzfp.zzm(zzfp.zzk(zzapVar)));
                String strGroup = null;
                if (matcher.find() && matcher.groupCount() >= iIntValue) {
                    strGroup = matcher.group(iIntValue);
                }
                return strGroup == null ? zzfp.zza() : zzfp.zzb(strGroup);
            } catch (PatternSyntaxException unused) {
            }
        }
        return zzfp.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
