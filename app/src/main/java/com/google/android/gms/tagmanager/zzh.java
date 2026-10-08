package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzh extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.ADWORDS_CLICK_REFERRER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.COMPONENT.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.CONVERSION_ID.toString();
    private final Context zzd;

    public zzh(Context context) {
        super(zza, zzc);
        this.zzd = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        if (zzapVar == null) {
            return zzfp.zza();
        }
        String strZzm = zzfp.zzm(zzfp.zzk(zzapVar));
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        String strZzm2 = zzapVar2 != null ? zzfp.zzm(zzfp.zzk(zzapVar2)) : null;
        Context context = this.zzd;
        String string = (String) zzcs.zza.get(strZzm);
        if (string == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_click_referrers", 0);
            string = sharedPreferences != null ? sharedPreferences.getString(strZzm, "") : "";
            zzcs.zza.put(strZzm, string);
        }
        String strZza = zzcs.zza(string, strZzm2);
        return strZza != null ? zzfp.zzb(strZza) : zzfp.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
