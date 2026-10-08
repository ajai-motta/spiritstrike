package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzau;
import com.google.android.gms.internal.gtm.zzbd;
import com.google.android.gms.internal.gtm.zzbq;
import com.google.android.gms.internal.gtm.zzbs;
import com.google.android.gms.internal.gtm.zzbu;
import com.google.android.gms.internal.gtm.zzbw;
import com.google.android.gms.internal.gtm.zzek;
import com.google.android.gms.internal.gtm.zzff;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzb extends zzbq implements zzt {
    private static DecimalFormat zza;
    private final zzbu zzb;
    private final String zzc;
    private final Uri zzd;

    public zzb(zzbu zzbuVar, String str) {
        super(zzbuVar);
        Preconditions.checkNotEmpty(str);
        this.zzb = zzbuVar;
        this.zzc = str;
        this.zzd = zza(str);
    }

    static Uri zza(String str) {
        Preconditions.checkNotEmpty(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(ShareConstants.MEDIA_URI);
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    static String zzc(double d) {
        if (zza == null) {
            zza = new DecimalFormat("0.######");
        }
        return zza.format(d);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map zzd(com.google.android.gms.analytics.zzh r10) {
        /*
            Method dump skipped, instruction units count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.zzb.zzd(com.google.android.gms.analytics.zzh):java.util.Map");
    }

    private static void zzf(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    private static void zzg(Map map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    @Override // com.google.android.gms.analytics.zzt
    public final Uri zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.analytics.zzt
    public final void zze(zzh zzhVar) {
        Preconditions.checkNotNull(zzhVar);
        Preconditions.checkArgument(zzhVar.zzm(), "Can't deliver not submitted measurement");
        Preconditions.checkNotMainThread("deliver should be called on worker thread");
        zzh zzhVar2 = new zzh(zzhVar);
        zzbd zzbdVar = (zzbd) zzhVar2.zzb(zzbd.class);
        if (TextUtils.isEmpty(zzbdVar.zzf())) {
            zzz().zzc(zzd(zzhVar2), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(zzbdVar.zze())) {
            zzz().zzc(zzd(zzhVar2), "Ignoring measurement without client id");
            return;
        }
        if (this.zzb.zzc().getAppOptOut()) {
            return;
        }
        if (zzff.zzj(0.0d, zzbdVar.zze())) {
            zzF("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(0.0d));
            return;
        }
        Map mapZzd = zzd(zzhVar2);
        mapZzd.put("v", "1");
        mapZzd.put("_v", zzbs.zzb);
        mapZzd.put(ScarConstants.TOKEN_ID_KEY, this.zzc);
        if (this.zzb.zzc().isDryRunEnabled()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : mapZzd.entrySet()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
            zzM("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
            return;
        }
        HashMap map = new HashMap();
        zzff.zzg(map, "uid", zzbdVar.zzg());
        zzau zzauVar = (zzau) zzhVar.zzc(zzau.class);
        if (zzauVar != null) {
            zzff.zzg(map, "an", zzauVar.zzf());
            zzff.zzg(map, "aid", zzauVar.zzd());
            zzff.zzg(map, "av", zzauVar.zzg());
            zzff.zzg(map, "aiid", zzauVar.zze());
        }
        mapZzd.put("_s", String.valueOf(zzs().zza(new zzbw(0L, zzbdVar.zze(), this.zzc, !TextUtils.isEmpty(zzbdVar.zzd()), 0L, map))));
        zzs().zzh(new zzek(zzz(), mapZzd, zzhVar.zza(), true));
    }
}
