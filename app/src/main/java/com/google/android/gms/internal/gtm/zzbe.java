package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbe extends com.google.android.gms.analytics.zzj {
    private int zza;

    public zzbe() {
        UUID uuidRandomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (uuidRandomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (uuidRandomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            leastSignificantBits = Integer.MAX_VALUE;
        }
        Preconditions.checkNotZero(leastSignificantBits);
        this.zza = leastSignificantBits;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("screenName", null);
        map.put(ReportUtil.INVENTORY_TYPE_INTERSTITIAL, false);
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, false);
        map.put("screenId", Integer.valueOf(this.zza));
        map.put("referrerScreenId", 0);
        map.put("referrerScreenName", null);
        map.put("referrerUri", null);
        return zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbe zzbeVar = (zzbe) zzjVar;
        TextUtils.isEmpty(null);
        int i = this.zza;
        if (i != 0) {
            zzbeVar.zza = i;
        }
        TextUtils.isEmpty(null);
        if (TextUtils.isEmpty(null)) {
            return;
        }
        TextUtils.isEmpty(null);
    }

    public final int zzd() {
        return this.zza;
    }
}
