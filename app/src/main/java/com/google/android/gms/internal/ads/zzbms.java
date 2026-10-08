package com.google.android.gms.internal.ads;

import com.facebook.bolts.AppLinks;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbms implements zzblx {
    private final zzdyo zza;

    public zzbms(zzdyo zzdyoVar) {
        Preconditions.checkNotNull(zzdyoVar, "The Inspector Manager must not be null");
        this.zza = zzdyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        if (map == null || !map.containsKey(AppLinks.KEY_NAME_EXTRAS)) {
            return;
        }
        long j = Long.MAX_VALUE;
        if (map.containsKey("expires")) {
            try {
                j = Long.parseLong((String) map.get("expires"));
            } catch (NumberFormatException unused) {
            }
        }
        this.zza.zzi((String) map.get(AppLinks.KEY_NAME_EXTRAS), j);
    }
}
