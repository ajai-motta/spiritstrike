package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcr extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.INSTALL_REFERRER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.COMPONENT.toString();
    private final Context zzc;

    public zzcr(Context context) {
        super(zza, new String[0]);
        this.zzc = context;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        String str = zzb;
        String strZzb = zzcs.zzb(this.zzc, ((com.google.android.gms.internal.gtm.zzap) map.get(str)) != null ? zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(str))) : null);
        return strZzb != null ? zzfp.zzb(strZzb) : zzfp.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
