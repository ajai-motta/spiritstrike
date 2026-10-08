package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import com.google.common.net.HttpHeaders;
import io.ktor.client.utils.CacheControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaqr {
    public static zzapd zza(zzapq zzapqVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzapqVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long jZzb = str != null ? zzb(str) : 0L;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals(CacheControl.NO_CACHE) || strTrim.equals(CacheControl.NO_STORE)) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals(CacheControl.MUST_REVALIDATE) || strTrim.equals(CacheControl.PROXY_REVALIDATE)) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long jZzb2 = str3 != null ? zzb(str3) : 0L;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long jZzb3 = str4 != null ? zzb(str4) : 0L;
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            j4 = jCurrentTimeMillis + (j2 * 1000);
            if (z) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (jZzb <= 0 || jZzb2 < jZzb) {
                j4 = 0;
            } else {
                j4 = jCurrentTimeMillis + (jZzb2 - jZzb);
                j3 = j4;
            }
        }
        zzapd zzapdVar = new zzapd();
        zzapdVar.zza = zzapqVar.zzb;
        zzapdVar.zzb = str5;
        zzapdVar.zzf = j4;
        zzapdVar.zze = j3;
        zzapdVar.zzc = jZzb;
        zzapdVar.zzd = jZzb3;
        zzapdVar.zzg = map;
        zzapdVar.zzh = zzapqVar.zzd;
        return zzapdVar;
    }

    public static long zzb(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "-1".equals(str)) {
                zzaqg.zza("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaqg.zzd(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
