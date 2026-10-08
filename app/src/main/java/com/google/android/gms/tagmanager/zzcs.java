package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.adjust.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcs {
    static final Map zza = new HashMap();
    private static String zzb;

    public static String zza(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?".concat(String.valueOf(str))).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static String zzb(Context context, String str) {
        if (zzb == null) {
            synchronized (zzcs.class) {
                if (zzb == null) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzb = sharedPreferences.getString(Constants.REFERRER, "");
                    } else {
                        zzb = "";
                    }
                }
            }
        }
        return zza(zzb, str);
    }

    public static void zzc(Context context, String str) {
        String strZza = zza(str, "conv");
        if (strZza == null || strZza.length() <= 0) {
            return;
        }
        zza.put(strZza, str);
        zzfb.zza(context, "gtm_click_referrers", strZza, str);
    }

    public static void zzd(String str) {
        synchronized (zzcs.class) {
            zzb = str;
        }
    }
}
