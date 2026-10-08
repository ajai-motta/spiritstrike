package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzdvn;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzp extends QueryInfoGenerationCallback {
    private final zzo zza;
    private final zzdvn zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
    private final Boolean zzf;

    public zzp(zzo zzoVar, boolean z, int i, Boolean bool, zzdvn zzdvnVar) {
        this.zza = zzoVar;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdvnVar;
    }

    private static long zza() {
        return com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() + ((Long) zzbgz.zzh.zze()).longValue();
    }

    private final long zzb() {
        return com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zze;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", "true");
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[8] = new Pair("tpc", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        zzaa.zze(this.zzb, null, "sgpcf", pairArr);
        this.zza.zzc(z, new zzq(null, str, zza(), i));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[7] = new Pair("tpc", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        zzaa.zze(this.zzb, null, "sgpcs", pairArr);
        this.zza.zzc(z, new zzq(queryInfo, "", zza(), i));
    }
}
